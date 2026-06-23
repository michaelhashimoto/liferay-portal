/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class BuildQueueRebalancer {

	public BuildQueueRebalancer(JenkinsCohort jenkinsCohort) {
		_jenkinsCohort = jenkinsCohort;
	}

	public void rebalance() {
		_generateBlackListRebalanceActions();

		_generateAvailableRebalanceActions();

		_executeRebalanceActions();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Queue rebalance: ");
		sb.append(_getRebalanceActionCount(Type.REINVOKE));
		sb.append(" reinvoked, ");
		sb.append(_getRebalanceActionCount(Type.ABORT));
		sb.append(" aborted.");

		for (RebalanceAction rebalanceAction : _rebalanceActions) {
			sb.append(rebalanceAction.getSummary());
		}

		return sb.toString();
	}

	public static enum Type {

		ABORT, REINVOKE

	}

	private void _executeRebalanceActions() {
		for (RebalanceAction rebalanceAction : _rebalanceActions) {
			rebalanceAction.execute();
		}
	}

	private void _generateAvailableRebalanceActions() {
		int threshold = JenkinsResultsParserUtil.getBuildPropertyInteger(
			"jenkins.queue.rebalance.threshold", 5);
		int maxMoves = JenkinsResultsParserUtil.getBuildPropertyInteger(
			"jenkins.queue.rebalance.max.moves", 10);

		List<JenkinsMaster> jenkinsMasters =
			_jenkinsCohort.getAvailableJenkinsMasters();

		int moves = 0;

		for (JenkinsMaster sourceJenkinsMaster : jenkinsMasters) {
			Map<String, List<JenkinsMaster.QueueItem>> movableItemsByLabel =
				_getMovableItemsByLabel(sourceJenkinsMaster);

			for (Map.Entry<String, List<JenkinsMaster.QueueItem>> entry :
					movableItemsByLabel.entrySet()) {

				String labelExpression = entry.getKey();

				List<JenkinsMaster.QueueItem> queueItems = entry.getValue();

				if ((queueItems.size() < threshold) ||
					!_hasAvailableCapacityElsewhere(
						jenkinsMasters, sourceJenkinsMaster, labelExpression)) {

					continue;
				}

				Collections.sort(queueItems, _queueItemComparator);

				for (int i = queueItems.size() - 1;
					 (i >= 0) && (moves < maxMoves); i--) {

					_rebalanceActions.add(
						new RebalanceAction(queueItems.get(i)));

					moves++;
				}
			}
		}
	}

	private void _generateBlackListRebalanceActions() {
		for (JenkinsMaster jenkinsMaster :
				_jenkinsCohort.getBlackListedJenkinsMasters()) {

			for (JenkinsMaster.QueueItem queueItem :
					jenkinsMaster.getQueueItems()) {

				_rebalanceActions.add(new RebalanceAction(queueItem));
			}
		}
	}

	private Map<String, List<JenkinsMaster.QueueItem>> _getMovableItemsByLabel(
		JenkinsMaster jenkinsMaster) {

		Map<String, List<JenkinsMaster.QueueItem>> movableItemsByLabel =
			new HashMap<>();

		for (JenkinsMaster.QueueItem queueItem :
				jenkinsMaster.getQueueItems()) {

			String labelExpression = queueItem.getLabelExpression();

			if (JenkinsResultsParserUtil.isNullOrEmpty(labelExpression)) {
				continue;
			}

			List<JenkinsMaster.QueueItem> queueItems = movableItemsByLabel.get(
				labelExpression);

			if (queueItems == null) {
				queueItems = new ArrayList<>();

				movableItemsByLabel.put(labelExpression, queueItems);
			}

			queueItems.add(queueItem);
		}

		return movableItemsByLabel;
	}

	private int _getRebalanceActionCount(Type type) {
		int count = 0;

		for (RebalanceAction rebalanceAction : _rebalanceActions) {
			if (rebalanceAction.getType() == type) {
				count++;
			}
		}

		return count;
	}

	private boolean _hasAvailableCapacityElsewhere(
		List<JenkinsMaster> jenkinsMasters, JenkinsMaster sourceJenkinsMaster,
		String labelExpression) {

		for (JenkinsMaster jenkinsMaster : jenkinsMasters) {
			if ((jenkinsMaster == sourceJenkinsMaster) ||
				!jenkinsMaster.matchesLabelExpression(labelExpression)) {

				continue;
			}

			if (jenkinsMaster.getAvailableSlavesCount(labelExpression) > 0) {
				return true;
			}
		}

		return false;
	}

	private static final Comparator<JenkinsMaster.QueueItem>
		_queueItemComparator = new Comparator<JenkinsMaster.QueueItem>() {

			@Override
			public int compare(
				JenkinsMaster.QueueItem queueItem1,
				JenkinsMaster.QueueItem queueItem2) {

				return Long.compare(
					queueItem1.getInQueueSince(), queueItem2.getInQueueSince());
			}

		};

	private final JenkinsCohort _jenkinsCohort;
	private final List<RebalanceAction> _rebalanceActions = new ArrayList<>();

	private class RebalanceAction {

		public void execute() {
			try {
				JenkinsMaster currentJenkinsMaster = _getCurrentJenkinsMaster();

				if (_type == Type.ABORT) {
					JenkinsStopBuildUtil.cancelQueueItem(
						currentJenkinsMaster, _queueItem.getId());

					_executed = true;

					return;
				}

				String jobName = _queueItem.getTaskName();

				JenkinsMaster targetJenkinsMaster =
					_jenkinsCohort.getMostAvailableJenkinsMaster(
						currentJenkinsMaster, 1, jobName);

				if ((targetJenkinsMaster == null) ||
					(targetJenkinsMaster == currentJenkinsMaster)) {

					return;
				}

				long queueId = JenkinsResultsParserUtil.invokeJenkinsBuild(
					targetJenkinsMaster, jobName, _queueItem.getParameters());

				if (queueId == 0) {
					return;
				}

				JenkinsStopBuildUtil.cancelQueueItem(
					currentJenkinsMaster, _queueItem.getId());

				_targetJenkinsMaster = targetJenkinsMaster;

				_executed = true;
			}
			catch (Exception exception) {
				System.out.println(
					JenkinsResultsParserUtil.combine(
						"Unable to rebalance queue item ", _queueItem.getURL(),
						": ", exception.getMessage()));
			}
		}

		public JenkinsMaster.QueueItem getQueueItem() {
			return _queueItem;
		}

		public String getSummary() {
			if (!_executed) {
				return "This action was not executed.";
			}

			JenkinsMaster currentJenkinsMaster = _getCurrentJenkinsMaster();
			Type type = getType();

			if (type == Type.ABORT) {
				return JenkinsResultsParserUtil.combine(
					"ABORT ", currentJenkinsMaster.getName(), " [",
					_queueItem.getTaskName(), "]");
			}

			return JenkinsResultsParserUtil.combine(
				"REINVOKE ", currentJenkinsMaster.getName(), " -> ",
				_targetJenkinsMaster.getName(), " [", _queueItem.getTaskName(),
				"]");
		}

		public Type getType() {
			if (_type != null) {
				return _type;
			}

			Map<String, String> parameters = _queueItem.getParameters();

			String parentBuildURL = parameters.get("PARENT_BUILD_URL");

			if (JenkinsResultsParserUtil.isNullOrEmpty(parentBuildURL)) {
				_type = Type.REINVOKE;

				return _type;
			}

			if (_isBuildInProgress(parentBuildURL)) {
				_type = Type.ABORT;
			}
			else {
				_type = Type.REINVOKE;
			}

			return _type;
		}

		private RebalanceAction(JenkinsMaster.QueueItem queueItem) {
			_queueItem = queueItem;
		}

		private JenkinsMaster _getCurrentJenkinsMaster() {
			return _queueItem.getJenkinsMaster();
		}

		private boolean _isBuildInProgress(String buildURL) {
			try {
				JSONObject jsonObject = JenkinsResultsParserUtil.toJSONObject(
					JenkinsResultsParserUtil.combine(
						JenkinsResultsParserUtil.getLocalURL(buildURL),
						"/api/json?tree=result"),
					false, 5000);

				if (jsonObject.has("result") && jsonObject.isNull("result")) {
					return true;
				}

				return false;
			}
			catch (Exception exception) {
				return false;
			}
		}

		private boolean _executed;
		private final JenkinsMaster.QueueItem _queueItem;
		private JenkinsMaster _targetJenkinsMaster;
		private Type _type;

	}

}