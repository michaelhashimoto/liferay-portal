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

/**
 * @author Michael Hashimoto
 */
public class BuildQueueRebalancer {

	public BuildQueueRebalancer(JenkinsCohort jenkinsCohort) {
		_jenkinsCohort = jenkinsCohort;
	}

	public void rebalance() {
		_drainBlackListedJenkinsMasters();

		_rebalanceQueuePressure();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Queue rebalance: ");
		sb.append(_reinvokedCount);
		sb.append(" reinvoked, ");
		sb.append(_abortedCount);
		sb.append(" aborted.");

		for (String movement : _movements) {
			sb.append("\n");
			sb.append(movement);
		}

		return sb.toString();
	}

	private void _addAbort(JenkinsMaster.QueueItem queueItem) {
		_abortedCount++;

		JenkinsMaster sourceJenkinsMaster = queueItem.getJenkinsMaster();

		_movements.add(
			JenkinsResultsParserUtil.combine(
				"ABORT ", sourceJenkinsMaster.getName(), " [",
				queueItem.getTaskName(), "]"));
	}

	private void _addReinvoke(
		JenkinsMaster targetJenkinsMaster, JenkinsMaster.QueueItem queueItem) {

		_reinvokedCount++;

		JenkinsMaster sourceJenkinsMaster = queueItem.getJenkinsMaster();

		_movements.add(
			JenkinsResultsParserUtil.combine(
				"REINVOKE ", sourceJenkinsMaster.getName(), " -> ",
				targetJenkinsMaster.getName(), " [", queueItem.getTaskName(),
				"]"));
	}

	private void _drainBlackListedJenkinsMasters() {
		for (JenkinsMaster jenkinsMaster :
				_jenkinsCohort.getBlackListedJenkinsMasters()) {

			for (JenkinsMaster.QueueItem queueItem :
					jenkinsMaster.getQueueItems()) {

				_processQueueItem(queueItem);
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

	private void _processQueueItem(JenkinsMaster.QueueItem queueItem) {
		JenkinsMaster.QueueItem.RebalanceStatus rebalanceStatus =
			queueItem.getRebalanceStatus();

		JenkinsMaster sourceJenkinsMaster = queueItem.getJenkinsMaster();

		try {
			if (rebalanceStatus ==
					JenkinsMaster.QueueItem.RebalanceStatus.ABORT_CANDIDATE) {

				JenkinsStopBuildUtil.cancelQueueItem(
					sourceJenkinsMaster, queueItem.getId());

				_addAbort(queueItem);

				return;
			}

			String jobName = queueItem.getTaskName();

			JenkinsMaster targetJenkinsMaster =
				_jenkinsCohort.getMostAvailableJenkinsMaster(
					sourceJenkinsMaster, 1, jobName);

			if ((targetJenkinsMaster == null) ||
				(targetJenkinsMaster == sourceJenkinsMaster)) {

				return;
			}

			long queueId = JenkinsResultsParserUtil.invokeJenkinsBuild(
				targetJenkinsMaster, jobName, queueItem.getParameters());

			if (queueId == 0) {
				return;
			}

			JenkinsStopBuildUtil.cancelQueueItem(
				sourceJenkinsMaster, queueItem.getId());

			_addReinvoke(targetJenkinsMaster, queueItem);
		}
		catch (Exception exception) {
			System.out.println(
				"Unable to rebalance queue item " + queueItem.getURL() + ": " +
					exception.getMessage());
		}
	}

	private void _rebalanceQueuePressure() {
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

					_processQueueItem(queueItems.get(i));

					moves++;
				}
			}
		}
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

	private int _abortedCount;
	private final JenkinsCohort _jenkinsCohort;
	private final List<String> _movements = new ArrayList<>();
	private int _reinvokedCount;

}