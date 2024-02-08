/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.google.common.collect.Lists;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.PortalTestClassJob;
import com.liferay.jenkins.results.parser.job.property.JobProperty;
import com.liferay.jenkins.results.parser.test.clazz.PlaywrightTestClass;
import com.liferay.jenkins.results.parser.test.clazz.TestClass;
import com.liferay.jenkins.results.parser.test.clazz.TestClassFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Kenji Heigel
 */
public class PlaywrightBatchTestClassGroup extends BatchTestClassGroup {

	public void addDefaultProjectJobProperty(String batchName) {
		JobProperty jobProperty = getJobProperty(
			PLAYWRIGHT_TEST_PROJECT_PROPERTY_NAME, testSuiteName, batchName);

		String jobPropertyValue = jobProperty.getValue();

		if (JenkinsResultsParserUtil.isNullOrEmpty(jobPropertyValue)) {
			return;
		}

		_addProjectNames(jobPropertyValue);

		recordJobProperty(jobProperty);
	}

	protected PlaywrightBatchTestClassGroup(
		JSONObject jsonObject, PortalTestClassJob portalTestClassJob) {

		super(jsonObject, portalTestClassJob);
	}

	protected PlaywrightBatchTestClassGroup(
		String batchName, PortalTestClassJob portalTestClassJob) {

		super(batchName, portalTestClassJob);

		if (ignore()) {
			return;
		}

		if (testRelevantChanges) {
			List<JobProperty> relevantPlaywrightJobProperties =
				getRelevantPlaywrightJobProperties();

			if (!relevantPlaywrightJobProperties.isEmpty()) {
				recordJobProperties(relevantPlaywrightJobProperties);
			}
		}

		addDefaultProjectJobProperty(batchName);

		for (String projectName : _projectNames) {
			List<TestClass> testClasses = _getTestClasses(projectName);

			if (testClasses.isEmpty()) {
				continue;
			}

			SegmentTestClassGroup segmentTestClassGroup =
				TestClassGroupFactory.newSegmentTestClassGroup(this);

			if (segmentTestClassGroup instanceof
					PlaywrightSegmentTestClassGroup) {

				PlaywrightSegmentTestClassGroup
					playwrightSegmentTestClassGroup =
						(PlaywrightSegmentTestClassGroup)segmentTestClassGroup;

				playwrightSegmentTestClassGroup.setProjectName(projectName);

				AxisTestClassGroup axisTestClassGroup =
					TestClassGroupFactory.newAxisTestClassGroup(this);

				playwrightSegmentTestClassGroup.addAxisTestClassGroup(
					axisTestClassGroup);

				for (TestClass testClass : testClasses) {
					axisTestClassGroup.addTestClass(testClass);

					addTestClass(testClass);
				}

				addAxisTestClassGroup(axisTestClassGroup);

				addSegmentTestClassGroup(playwrightSegmentTestClassGroup);
			}
		}
	}

	protected List<JobProperty> getRelevantPlaywrightJobProperties() {
		Set<File> modifiedModuleDirsSet;

		try {
			modifiedModuleDirsSet = new HashSet<>(
				portalGitWorkingDirectory.getModifiedModuleDirsList());
		}
		catch (IOException ioException) {
			File workingDirectory =
				portalGitWorkingDirectory.getWorkingDirectory();

			throw new RuntimeException(
				JenkinsResultsParserUtil.combine(
					"Unable to get relevant module group directories in ",
					workingDirectory.getPath()),
				ioException);
		}

		modifiedModuleDirsSet.addAll(
			getRequiredModuleDirs(Lists.newArrayList(modifiedModuleDirsSet)));

		Set<JobProperty> playwrightJobProperties = new HashSet<>();

		for (File modifiedModuleDir : modifiedModuleDirsSet) {
			JobProperty playwrightTestProjectJobProperty = getJobProperty(
				PLAYWRIGHT_TEST_PROJECT_PROPERTY_NAME, modifiedModuleDir,
				JobProperty.Type.MODULE_TEST_DIR);

			if (playwrightTestProjectJobProperty.getValue() != null) {
				String projectNames =
					playwrightTestProjectJobProperty.getValue();

				_addProjectNames(projectNames);

				playwrightJobProperties.add(playwrightTestProjectJobProperty);
			}
		}

		playwrightJobProperties.removeAll(Collections.singleton(null));

		return new ArrayList<>(playwrightJobProperties);
	}

	protected static final String PLAYWRIGHT_TEST_PROJECT_PROPERTY_NAME =
		"playwright.test.project";

	private void _addProjectNames(String projectNames) {
		projectNames = projectNames.trim();

		Collections.addAll(_projectNames, projectNames.split("\\s*,\\s*"));
	}

	private String _callNPMCommand(File baseDir, String npmCommand) {
		String[] bashCommands = new String[3];

		if (JenkinsResultsParserUtil.isWindows()) {
			bashCommands[0] = "cmd";
			bashCommands[1] = "/c";
		}
		else {
			bashCommands[0] = "/bin/sh";
			bashCommands[1] = "-c";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("export PATH=");

		JobProperty nodeHomeJobProperty = getJobProperty("node.home");

		if (nodeHomeJobProperty != null) {
			String nodeHome = nodeHomeJobProperty.getValue();

			if (!JenkinsResultsParserUtil.isNullOrEmpty(nodeHome)) {
				sb.append(nodeHome);
				sb.append("/bin:");
			}
		}

		JobProperty npmHomeJobProperty = getJobProperty("npm.home");

		if (npmHomeJobProperty != null) {
			String npmHome = npmHomeJobProperty.getValue();

			if (!JenkinsResultsParserUtil.isNullOrEmpty(npmHome)) {
				sb.append(npmHome);
				sb.append(":");
			}
		}

		sb.append("${PATH} ; ");

		sb.append(npmCommand);

		System.out.println(sb.toString());

		bashCommands[2] = sb.toString();

		try {
			ProcessBuilder processBuilder = new ProcessBuilder(bashCommands);

			if (baseDir == null) {
				baseDir = new File(".");
			}

			processBuilder.directory(baseDir.getAbsoluteFile());

			final Process process = processBuilder.start();

			Thread thread = new Thread() {

				@Override
				public void run() {
					try (BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(process.getInputStream()))) {

						String line = bufferedReader.readLine();

						while (line != null) {
							System.out.println(line);

							line = bufferedReader.readLine();
						}
					}
					catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}

			};

			thread.start();

			process.waitFor();

			int exitValue = process.exitValue();

			if (exitValue != 0) {
				String errorMessage = JenkinsResultsParserUtil.readInputStream(
					process.getErrorStream(), true);

				System.out.println(errorMessage);

				throw new RuntimeException(errorMessage);
			}

			return JenkinsResultsParserUtil.readInputStream(
				process.getInputStream(), true);
		}
		catch (InterruptedException | IOException exception) {
			exception.printStackTrace();

			throw new RuntimeException(exception);
		}
	}

	private synchronized JSONObject _getPlaywrightJSONObject() {
		if (_playwrightJSONObject != null) {
			return _playwrightJSONObject;
		}

		File playwrightBaseDir = new File(
			portalGitWorkingDirectory.getWorkingDirectory(),
			"modules/test/playwright");

		String result = _callNPMCommand(
			playwrightBaseDir, "npx playwright test --list --reporter=json");

		_playwrightJSONObject = new JSONObject(result.trim());

		return _playwrightJSONObject;
	}

	private List<TestClass> _getTestClasses(String projectName) {
		List<TestClass> testClasses = new ArrayList<>();

		JSONObject playwrightJSONObject = _getPlaywrightJSONObject();

		File rootDir = new File(playwrightJSONObject.getString("rootDir"));

		JSONArray suitesJSONArray = playwrightJSONObject.getJSONArray("suites");

		for (int i = 0; i < suitesJSONArray.length(); i++) {
			JSONObject suiteJSONObject = suitesJSONArray.getJSONObject(i);

			JSONArray specsJSONArray = suiteJSONObject.optJSONArray("specs");

			if (specsJSONArray == null) {
				continue;
			}

			for (int j = 0; j < specsJSONArray.length(); j++) {
				JSONObject specJSONObject = specsJSONArray.getJSONObject(j);

				JSONArray testsJSONArray = specJSONObject.optJSONArray("tests");

				if ((testsJSONArray == null) || testsJSONArray.isEmpty()) {
					continue;
				}

				JSONObject testJSONObject = testsJSONArray.getJSONObject(0);

				if (!Objects.equals(
						projectName, testJSONObject.optString("projectName"))) {

					continue;
				}

				String specFilePath = suiteJSONObject.getString("file");

				File specFile = new File(rootDir, specFilePath);

				TestClass testClass = TestClassFactory.newTestClass(
					this, specFile, specJSONObject.getString("title"));

				if (!(testClass instanceof PlaywrightTestClass)) {
					continue;
				}

				PlaywrightTestClass playwrightTestClass =
					(PlaywrightTestClass)testClass;

				playwrightTestClass.setSpecFilePath(specFilePath);

				testClasses.add(playwrightTestClass);
			}
		}

		return testClasses;
	}

	private JSONObject _playwrightJSONObject;
	private final Set<String> _projectNames = new HashSet<>();

}