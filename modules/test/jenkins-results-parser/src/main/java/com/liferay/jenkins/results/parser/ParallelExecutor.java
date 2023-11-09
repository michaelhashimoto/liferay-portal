/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Peter Yoo
 */
public class ParallelExecutor<T> {

	public ParallelExecutor(
		Collection<Callable<T>> callables, boolean excludeNulls,
		ExecutorService executorService) {

		this(callables, excludeNulls, executorService, false);
	}

	public ParallelExecutor(
		Collection<Callable<T>> callables, boolean excludeNulls,
		ExecutorService executorService, boolean failOnError) {

		_callablesMap = _toCallablesMap(callables);

		_excludeNulls = excludeNulls;
		_executorService = executorService;
		_failOnError = failOnError;

		if (executorService == null) {
			_disposeExecutor = true;
			_executorService = Executors.newSingleThreadExecutor();
		}
		else {
			_disposeExecutor = false;
		}
	}

	public ParallelExecutor(
		Collection<Callable<T>> callables, ExecutorService executorService) {

		this(callables, false, executorService);
	}

	public List<T> execute() {
		return execute(null);
	}

	public List<T> execute(Long timeoutSeconds) {
		start();

		return waitFor(timeoutSeconds);
	}

	public void shutdownNow() {
		_executorService.shutdownNow();
	}

	public synchronized void start() {
		Set<Map.Entry<String, Collection<Callable<T>>>> entries =
			_callablesMap.entrySet();

		List<Callable<Collection<T>>> topLevelCallables = new ArrayList<>(
			entries.size());

		for (final Map.Entry<String, Collection<Callable<T>>>
				callablesMapEntry : entries) {

			String key = callablesMapEntry.getKey();

			if (key.equals(_DEFAULT_GROUP_NAME)) {
				for (final Callable<T> callable :
						callablesMapEntry.getValue()) {

					topLevelCallables.add(
						_createTopLevelCallable(Arrays.asList(callable)));
				}

				continue;
			}

			topLevelCallables.add(
				_createTopLevelCallable(callablesMapEntry.getValue()));
		}

		if (_futures != null) {
			return;
		}

		_futures = new ArrayList<>(topLevelCallables.size());

		for (Callable<Collection<T>> callable : topLevelCallables) {
			_futures.add(_executorService.submit(callable));
		}
	}

	public List<T> waitFor() {
		return waitFor(null);
	}

	public List<T> waitFor(Long timeoutSeconds) {
		if (_futures == null) {
			start();
		}

		if (timeoutSeconds == null) {
			timeoutSeconds = 60L * 60L * 2L;
		}

		try {
			List<T> results = new ArrayList<>();

			for (Future<Collection<T>> future : _futures) {
				Collection<T> futureResults = null;

				try {
					futureResults = future.get(
						timeoutSeconds, TimeUnit.SECONDS);
				}
				catch (Exception exception) {
					future.cancel(true);

					String errorMessage = exception.getMessage();

					if (exception instanceof TimeoutException) {
						errorMessage = JenkinsResultsParserUtil.combine(
							"Parallel executor thread timed out after ",
							JenkinsResultsParserUtil.toDurationString(
								timeoutSeconds * 1000),
							"\n", exception.getMessage());
					}

					if (_failOnError) {
						throw new RuntimeException(errorMessage, exception);
					}

					System.out.println(errorMessage);
				}

				if ((futureResults == null) && _excludeNulls) {
					continue;
				}

				results.addAll(futureResults);
			}

			return results;
		}
		finally {
			if (_disposeExecutor) {
				_executorService.shutdownNow();

				while (!_executorService.isShutdown()) {
					JenkinsResultsParserUtil.sleep(100);
				}

				_executorService = null;
			}
		}
	}

	public abstract static class GroupedCallable<T> implements Callable<T> {

		public GroupedCallable(String groupName) {
			this(groupName, _DEFAULT_CALL_TIMEOUT_SECONDS);
		}

		public GroupedCallable(String groupName, long timeoutSeconds) {
			_groupName = groupName;
			_timeoutSeconds = timeoutSeconds;
		}

		public abstract T call() throws Exception;

		public String getGroupName() {
			return _groupName;
		}

		public long getTimeoutSeconds() {
			return _timeoutSeconds;
		}

		private String _groupName;
		private long _timeoutSeconds = _DEFAULT_CALL_TIMEOUT_SECONDS;

	}

	private Callable<Collection<T>> _createTopLevelCallable(
		final Collection<Callable<T>> nestedCallables) {

		return new Callable<Collection<T>>() {

			@Override
			public List<T> call() throws Exception {
				List<T> results = new ArrayList<>();

				ExecutorService executorService =
					Executors.newSingleThreadExecutor();

				String groupName = null;

				int failures = 0;

				try {
					//boolean first = true;

					List<Long> durations = new ArrayList<>();

					for (Callable<T> callable : nestedCallables) {
						long start = System.currentTimeMillis();
						Future<T> future = executorService.submit(callable);

						long timeoutSeconds = _DEFAULT_CALL_TIMEOUT_SECONDS;

						if (callable instanceof GroupedCallable) {
							GroupedCallable<T> groupedCallable =
								(GroupedCallable<T>)callable;

							timeoutSeconds =
								groupedCallable.getTimeoutSeconds();

							groupName = groupedCallable.getGroupName();
						}

						/*

						if (first &&
							!JenkinsResultsParserUtil.isNullOrEmpty(
								groupName) &&
							(nestedCallables.size() > 1)) {

							System.out.println(
								"Processing thread group " + groupName +
									" size: " + nestedCallables.size());
							first = false;
						}
						*/

						try {
							results.add(
								future.get(timeoutSeconds, TimeUnit.SECONDS));
						}
						catch (TimeoutException timeoutException) {
							failures++;

							System.out.println(
								JenkinsResultsParserUtil.combine(
									"Parallel executor thread timed ",
									"out after ",
									JenkinsResultsParserUtil.toDurationString(
										timeoutSeconds * 1000),
									"\n", timeoutException.getMessage()));

							future.cancel(true);
						}
						finally {
							durations.add(System.currentTimeMillis() - start);
						}
					}

					if (!JenkinsResultsParserUtil.isNullOrEmpty(groupName) &&
						(durations.size() > 1)) {

						long totalDuration = 0;

						for (long duration : durations) {
							totalDuration += duration;
						}

						long averageDuration = totalDuration / durations.size();

						String durationString =
							JenkinsResultsParserUtil.toDurationString(
								averageDuration);

						System.out.println(
							"Thread group " + groupName + " average duration " +
								durationString + " failure count " + failures +
								" out of " + nestedCallables.size());
					}

					return results;
				}
				finally {
					/*

					if (!JenkinsResultsParserUtil.isNullOrEmpty(groupName) &&
						(nestedCallables.size() > 1)) {

						System.out.println(
							"Finished processing thread group " + groupName);
					}
					*/

					executorService.shutdown();
				}
			}

		};
	}

	private Map<String, Collection<Callable<T>>> _toCallablesMap(
		Collection<Callable<T>> callables) {

		Map<String, Collection<Callable<T>>> callablesMap = new HashMap<>();

		for (Callable<T> callable : callables) {
			String groupName = null;

			if (callable instanceof GroupedCallable) {
				GroupedCallable<T> groupedCallable =
					(GroupedCallable<T>)callable;

				groupName = groupedCallable.getGroupName();
			}

			if (JenkinsResultsParserUtil.isNullOrEmpty(groupName)) {
				groupName = _DEFAULT_GROUP_NAME;
			}

			if (!callablesMap.containsKey(groupName)) {
				callablesMap.put(groupName, new ArrayList<Callable<T>>());
			}

			Collection<Callable<T>> callablesCollection = callablesMap.get(
				groupName);

			callablesCollection.add(callable);

			callablesMap.put(groupName, callablesCollection);
		}

		return callablesMap;
	}

	private static final long _DEFAULT_CALL_TIMEOUT_SECONDS = 60 * 60 * 2;

	private static final String _DEFAULT_GROUP_NAME =
		"PARALLEL_EXECUTOR_DEFAULT_CALLABLE_GROUP_NAME";

	private final Map<String, Collection<Callable<T>>> _callablesMap;
	private final boolean _disposeExecutor;
	private boolean _excludeNulls;
	private ExecutorService _executorService;
	private boolean _failOnError;
	private ArrayList<Future<Collection<T>>> _futures;

}