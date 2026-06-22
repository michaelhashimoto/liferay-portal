/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.net.URL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Hashimoto
 */
public class JenkinsQueueRebalancerUtil {

	public static void rebalance(String jenkinsBuildURL) throws Exception {
		JenkinsCohort jenkinsCohort =
			JenkinsResultsParserUtil.getJenkinsCohort();

		jenkinsCohort.update();

		RebalanceSummary rebalanceSummary = new RebalanceSummary();

		_drainBlackListedJenkinsMasters(jenkinsCohort, rebalanceSummary);

		_rebalanceQueuePressure(jenkinsCohort, rebalanceSummary);

		String summary = rebalanceSummary.toString();

		System.out.println(summary);

		if (!JenkinsResultsParserUtil.isNullOrEmpty(jenkinsBuildURL)) {
			JenkinsResultsParserUtil.updateBuildDescription(
				summary, new URL(jenkinsBuildURL));
		}
	}

	private static void _act(
		JenkinsCohort jenkinsCohort, JenkinsMaster sourceJenkinsMaster,
		JenkinsMaster.QueueItem queueItem, RebalanceSummary rebalanceSummary) {

		JenkinsMaster.QueueItem.RebalanceStatus rebalanceStatus =
			queueItem.getRebalanceStatus();

		if (rebalanceStatus ==
				JenkinsMaster.QueueItem.RebalanceStatus.NOT_MOVABLE) {

			return;
		}

		try {
			if (rebalanceStatus ==
					JenkinsMaster.QueueItem.RebalanceStatus.ABORT_CANDIDATE) {

				JenkinsStopBuildUtil.cancelQueueItem(
					sourceJenkinsMaster, queueItem.getId());

				rebalanceSummary.addAbort(sourceJenkinsMaster, queueItem);

				return;
			}

			String jobName = queueItem.getTaskName();

			JenkinsMaster targetJenkinsMaster =
				jenkinsCohort.getMostAvailableJenkinsMaster(
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

			rebalanceSummary.addReinvoke(
				sourceJenkinsMaster, targetJenkinsMaster, queueItem);
		}
		catch (Exception exception) {
			System.out.println(
				"Unable to rebalance queue item " + queueItem.getURL() + ": " +
					exception.getMessage());
		}
	}

	private static void _drainBlackListedJenkinsMasters(
		JenkinsCohort jenkinsCohort, RebalanceSummary rebalanceSummary) {

		for (JenkinsMaster jenkinsMaster : jenkinsCohort.getJenkinsMasters()) {
			if (!jenkinsMaster.isBlackListed()) {
				continue;
			}

			for (JenkinsMaster.QueueItem queueItem :
					jenkinsMaster.getQueueItems()) {

				_act(jenkinsCohort, jenkinsMaster, queueItem, rebalanceSummary);
			}
		}
	}

	private static int _getInteger(String propertyName, int defaultValue) {
		try {
			String value = JenkinsResultsParserUtil.getBuildProperty(
				propertyName);

			if (!JenkinsResultsParserUtil.isNullOrEmpty(value)) {
				return Integer.parseInt(value);
			}
		}
		catch (Exception exception) {
		}

		return defaultValue;
	}

	private static Map<String, List<JenkinsMaster.QueueItem>>
		_getMovableItemsByLabel(JenkinsMaster jenkinsMaster) {

		Map<String, List<JenkinsMaster.QueueItem>> movableItemsByLabel =
			new HashMap<>();

		for (JenkinsMaster.QueueItem queueItem :
				jenkinsMaster.getQueueItems()) {

			if (queueItem.getRebalanceStatus() ==
					JenkinsMaster.QueueItem.RebalanceStatus.NOT_MOVABLE) {

				continue;
			}

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

	private static boolean _hasAvailableCapacityElsewhere(
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

	private static void _rebalanceQueuePressure(
		JenkinsCohort jenkinsCohort, RebalanceSummary rebalanceSummary) {

		int threshold = _getInteger("jenkins.queue.rebalance.threshold", 5);
		int maxMoves = _getInteger("jenkins.queue.rebalance.max.moves", 10);

		List<JenkinsMaster> jenkinsMasters = new ArrayList<>();

		for (JenkinsMaster jenkinsMaster : jenkinsCohort.getJenkinsMasters()) {
			if (!jenkinsMaster.isBlackListed() && jenkinsMaster.isAvailable()) {
				jenkinsMasters.add(jenkinsMaster);
			}
		}

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

					_act(
						jenkinsCohort, sourceJenkinsMaster, queueItems.get(i),
						rebalanceSummary);

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

	private static class RebalanceSummary {

		public void addAbort(
			JenkinsMaster sourceJenkinsMaster, JenkinsMaster.QueueItem item) {

			_abortedCount++;

			_movements.add(
				JenkinsResultsParserUtil.combine(
					"ABORT ", sourceJenkinsMaster.getName(), " [",
					item.getTaskName(), "]"));
		}

		public void addReinvoke(
			JenkinsMaster sourceJenkinsMaster,
			JenkinsMaster targetJenkinsMaster, JenkinsMaster.QueueItem item) {

			_reinvokedCount++;

			_movements.add(
				JenkinsResultsParserUtil.combine(
					"REINVOKE ", sourceJenkinsMaster.getName(), " -> ",
					targetJenkinsMaster.getName(), " [", item.getTaskName(),
					"]"));
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

		private int _abortedCount;
		private final List<String> _movements = new ArrayList<>();
		private int _reinvokedCount;

	}

}