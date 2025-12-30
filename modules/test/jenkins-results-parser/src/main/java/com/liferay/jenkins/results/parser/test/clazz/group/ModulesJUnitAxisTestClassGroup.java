/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.Job;
import com.liferay.jenkins.results.parser.test.clazz.ModulesJUnitTestClass;
import com.liferay.jenkins.results.parser.test.clazz.TestClass;
import com.liferay.jenkins.results.parser.test.clazz.TestClassFactory;
import com.liferay.jenkins.results.parser.test.task.TestTask;
import com.liferay.jenkins.results.parser.test.task.TestTaskFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class ModulesJUnitAxisTestClassGroup extends JUnitAxisTestClassGroup {

	@Override
	public long getAverageDuration() {
		if (_averageDuration != null) {
			return _averageDuration;
		}

		_averageDuration =
			getAverageOverheadDuration() + getAverageTotalTestTaskDuration();

		return _averageDuration;
	}

	public long getAverageTotalTestTaskDuration() {
		if (_averageTotalTestTaskDuration != null) {
			return _averageTotalTestTaskDuration;
		}

		_averageTotalTestTaskDuration = 0L;

		Job.TestTaskGroupingStrategy testTaskGroupingStrategy =
			_getTestTaskGroupingStrategy();

		for (TestTask testTask : getTestTasks()) {
			if (testTaskGroupingStrategy ==
					Job.TestTaskGroupingStrategy.AVERAGE_DURATION) {

				_averageTotalTestTaskDuration += testTask.getAverageDuration();
			}
			else if (testTaskGroupingStrategy ==
						Job.TestTaskGroupingStrategy.AVERAGE_TOTAL_DURATION) {

				_averageTotalTestTaskDuration +=
					testTask.getAverageTotalDuration();
			}
			else if (testTaskGroupingStrategy ==
						Job.TestTaskGroupingStrategy.LONGEST_DURATION) {

				_averageTotalTestTaskDuration += testTask.getLongestDuration();
			}
		}

		return _averageTotalTestTaskDuration;
	}

	@Override
	public JSONObject getJSONObject() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put(
			"average_duration", getAverageDuration()
		).put(
			"axis_name", getAxisName()
		);

		JSONArray testTasksJSONArray = new JSONArray();

		jsonObject.put("test_tasks", testTasksJSONArray);

		for (TestTask testTask : getTestTasks()) {
			testTasksJSONArray.put(testTask.getJSONObject());
		}

		return jsonObject;
	}

	public List<TestTask> getTestTasks() {
		if (!_testTasks.isEmpty()) {
			return new ArrayList<>(_testTasks.values());
		}

		Job job = getJob();

		for (ModulesJUnitTestClass modulesJUnitTestClass :
				_getModulesJUnitTestClasses()) {

			String testTaskName = modulesJUnitTestClass.getTestTaskName();

			TestTask testTask = _testTasks.get(testTaskName);

			if (testTask == null) {
				testTask = TestTaskFactory.newTestTask(
					modulesJUnitTestClass.getAverageTestTaskDuration(),
					modulesJUnitTestClass.getAverageTotalTestTaskDuration(),
					job, modulesJUnitTestClass.getLongestTestTaskDuration(),
					testTaskName);

				_testTasks.put(testTaskName, testTask);
			}

			testTask.addTestClass(modulesJUnitTestClass);

			modulesJUnitTestClass.setTestTask(testTask);
		}

		return new ArrayList<>(_testTasks.values());
	}

	protected ModulesJUnitAxisTestClassGroup(
		JSONObject jsonObject, SegmentTestClassGroup segmentTestClassGroup) {

		super(jsonObject, segmentTestClassGroup);

		JSONArray testTasksJSONArray = jsonObject.getJSONArray("test_tasks");

		if ((testTasksJSONArray == null) || testTasksJSONArray.isEmpty()) {
			return;
		}

		Job job = getJob();

		for (int i = 0; i < testTasksJSONArray.length(); i++) {
			JSONObject testTaskJSONObject = testTasksJSONArray.getJSONObject(i);

			JSONArray testClassesJSONArray = testTaskJSONObject.getJSONArray(
				"test_classes");

			if (testClassesJSONArray == null) {
				continue;
			}

			String testTaskName = testTaskJSONObject.getString("name");

			TestTask testTask = TestTaskFactory.newTestTask(
				testTaskJSONObject.getLong("average_duration"),
				testTaskJSONObject.getLong("average_total_duration"), job,
				testTaskJSONObject.getLong("longest_duration"), testTaskName);

			for (int j = 0; j < testClassesJSONArray.length(); j++) {
				JSONObject testClassJSONObject =
					testClassesJSONArray.getJSONObject(j);

				if (testClassJSONObject == null) {
					continue;
				}

				TestClass testClass = TestClassFactory.newTestClass(
					getBatchTestClassGroup(), testClassJSONObject);

				addTestClass(testClass);

				testTask.addTestClass(testClass);

				if (!(testClass instanceof ModulesJUnitTestClass)) {
					continue;
				}

				ModulesJUnitTestClass modulesJUnitTestClass =
					(ModulesJUnitTestClass)testClass;

				modulesJUnitTestClass.setTestTask(testTask);
			}

			_testTasks.put(testTaskName, testTask);
		}
	}

	protected ModulesJUnitAxisTestClassGroup(
		JUnitBatchTestClassGroup jUnitBatchTestClassGroup) {

		super(jUnitBatchTestClassGroup);
	}

	private List<ModulesJUnitTestClass> _getModulesJUnitTestClasses() {
		List<ModulesJUnitTestClass> modulesJUnitTestClasses = new ArrayList<>();

		for (TestClass testClass : getTestClasses()) {
			modulesJUnitTestClasses.add((ModulesJUnitTestClass)testClass);
		}

		return modulesJUnitTestClasses;
	}

	private Job.TestTaskGroupingStrategy _getTestTaskGroupingStrategy() {
		Job job = getJob();

		return job.getTestTaskGroupingStrategy();
	}

	private Long _averageDuration;
	private Long _averageTotalTestTaskDuration;
	private final Map<String, TestTask> _testTasks = new HashMap<>();

}