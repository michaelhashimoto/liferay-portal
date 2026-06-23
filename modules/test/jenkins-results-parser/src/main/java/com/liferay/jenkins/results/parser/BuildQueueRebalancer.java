/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import com.liferay.jenkins.results.parser.aws.AWSFleetCloud;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

	private static double _getRebalanceThresholdMultiplier() {
		try {
			String rebalanceThresholdMultiplier =
				JenkinsResultsParserUtil.getBuildProperty(
					"jenkins.queue.rebalance.threshold");

			if (JenkinsResultsParserUtil.isDouble(
					rebalanceThresholdMultiplier)) {

				return Double.parseDouble(rebalanceThresholdMultiplier);
			}

			return _REBALANCE_THRESHOLD_MULTIPLIER_DEFAULT;
		}
		catch (IOException ioException) {
			return _REBALANCE_THRESHOLD_MULTIPLIER_DEFAULT;
		}
	}

	private void _executeRebalanceActions() {
		for (RebalanceAction rebalanceAction : _rebalanceActions) {
			rebalanceAction.execute();
		}
	}

	private void _generateAvailableRebalanceActions() {
		Map<String, Queue> queueMap = _getQueueMap();

		for (Map.Entry<String, Queue> queueEntry : queueMap.entrySet()) {
			System.out.println(
				"Rebalancing queue items with label " + queueEntry.getKey());

			Queue queue = queueEntry.getValue();

			for (JenkinsMaster jenkinsMaster :
					_jenkinsCohort.getAvailableJenkinsMasters()) {

				List<JenkinsMaster.QueueItem> queueItems = queue.getQueueItems(
					jenkinsMaster);

				int targetQueueSize = queue.getTargetQueueSize();

				if (queueItems.size() < targetQueueSize) {
					continue;
				}

				for (int i = targetQueueSize; i < queueItems.size(); i++) {
					_rebalanceActions.add(
						new RebalanceAction(queueItems.get(i)));
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

	private Queue _getQueue(String primaryLabel) {
		Map<String, Queue> queueMap = _getQueueMap();

		return queueMap.get(primaryLabel);
	}

	private synchronized Map<String, Queue> _getQueueMap() {
		if (_queueMaps != null) {
			return _queueMaps;
		}

		List<JenkinsMaster.QueueItem> availableQueueItems = new ArrayList<>();

		List<JenkinsMaster> jenkinsMasters =
			_jenkinsCohort.getAvailableJenkinsMasters();

		for (JenkinsMaster jenkinsMaster : jenkinsMasters) {
			availableQueueItems.addAll(jenkinsMaster.getQueueItems());
		}

		_queueMaps = new HashMap<>();

		for (JenkinsMaster.QueueItem queueItem : availableQueueItems) {
			AWSFleetCloud awsFleetCloud = queueItem.getAWSFleetCloud();

			if (awsFleetCloud == null) {
				System.out.println(
					"Skipping queue item with no matching fleet: " +
						queueItem.getURL());

				continue;
			}

			String primaryLabel = awsFleetCloud.getPrimaryLabel();

			Queue queue = _queueMaps.get(primaryLabel);

			if (queue == null) {
				queue = new Queue(awsFleetCloud);
			}

			queue.addQueueItem(queueItem);

			_queueMaps.put(primaryLabel, queue);
		}

		return _queueMaps;
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

	private static final double _REBALANCE_THRESHOLD_MULTIPLIER_DEFAULT = 1.5;

	private final JenkinsCohort _jenkinsCohort;
	private Map<String, Queue> _queueMaps;
	private final List<RebalanceAction> _rebalanceActions = new ArrayList<>();

	private static class Queue {

		public void addQueueItem(JenkinsMaster.QueueItem queueItem) {
			if (_queueItems.contains(queueItem)) {
				return;
			}

			_queueItems.add(queueItem);

			JenkinsMaster jenkinsMaster = queueItem.getJenkinsMaster();

			List<JenkinsMaster.QueueItem> queueItems =
				_jenkinsMasterQueueItems.get(jenkinsMaster);

			if (queueItems == null) {
				queueItems = new ArrayList<>();
			}

			queueItems.add(queueItem);

			_jenkinsMasterQueueItems.put(jenkinsMaster, queueItems);
		}

		public int getAverageQueueSize() {
			if (_availableQueueCount == 0) {
				return 0;
			}

			return _queueItems.size() / _availableQueueCount;
		}

		public String getLabel() {
			return _label;
		}

		public int getMaxQueueSize() {
			return _maxQueueSize;
		}

		// TODO - Somehow calculate which jenkins master has the most room.

		public JenkinsMaster getMostAvailableJenkinsMaster() {
			return null;
		}

		public List<JenkinsMaster.QueueItem> getQueueItems() {
			Collections.sort(_queueItems);

			return new ArrayList<>(_queueItems);
		}

		public List<JenkinsMaster.QueueItem> getQueueItems(
			JenkinsMaster jenkinsMaster) {

			List<JenkinsMaster.QueueItem> queueItems =
				_jenkinsMasterQueueItems.get(jenkinsMaster);

			if (queueItems == null) {
				return new ArrayList<>();
			}

			Collections.sort(queueItems);

			return queueItems;
		}

		public int getTargetQueueSize() {
			int targetQueueSize = getMaxQueueSize();

			int averageQueueSize = getAverageQueueSize();

			if (targetQueueSize < averageQueueSize) {
				targetQueueSize = averageQueueSize;
			}

			return (int)(targetQueueSize * _getRebalanceThresholdMultiplier());
		}

		private Queue(AWSFleetCloud awsFleetCloud) {
			_label = awsFleetCloud.getPrimaryLabel();

			_maxQueueSize = awsFleetCloud.getMaxSize();

			JenkinsMaster jenkinsMaster = awsFleetCloud.getJenkinsMaster();

			JenkinsCohort jenkinsCohort = jenkinsMaster.getJenkinsCohort();

			List<JenkinsMaster> availableJenkinsMasters =
				jenkinsCohort.getAvailableJenkinsMasters();

			_availableQueueCount = availableJenkinsMasters.size();
		}

		private final int _availableQueueCount;
		private final Map<JenkinsMaster, List<JenkinsMaster.QueueItem>>
			_jenkinsMasterQueueItems = new HashMap<>();
		private final String _label;
		private final int _maxQueueSize;
		private final List<JenkinsMaster.QueueItem> _queueItems =
			new ArrayList<>();

	}

	private class RebalanceAction {

		public void execute() {
			try {
				JenkinsMaster currentJenkinsMaster = _getCurrentJenkinsMaster();

				if (getType() == Type.ABORT) {
					JenkinsStopBuildUtil.cancelQueueItem(
						currentJenkinsMaster, _queueItem.getId());

					_executed = true;

					return;
				}

				Queue queue = _getQueue(_queueItem.getPrimaryLabel());

				JenkinsMaster targetJenkinsMaster =
					queue.getMostAvailableJenkinsMaster();

				if ((targetJenkinsMaster == null) ||
					(targetJenkinsMaster == currentJenkinsMaster)) {

					return;
				}

				long queueId = JenkinsResultsParserUtil.invokeJenkinsBuild(
					targetJenkinsMaster, _queueItem.getTaskName(),
					_queueItem.getParameters());

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