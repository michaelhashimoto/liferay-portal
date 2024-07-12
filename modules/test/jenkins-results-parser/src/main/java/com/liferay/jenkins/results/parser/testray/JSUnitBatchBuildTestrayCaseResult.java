/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.testray;

import com.liferay.jenkins.results.parser.Build;
import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.TestClassResult;
import com.liferay.jenkins.results.parser.TopLevelBuild;
import com.liferay.jenkins.results.parser.test.clazz.TestClassMethod;
import com.liferay.jenkins.results.parser.test.clazz.group.AxisTestClassGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Hashimoto
 */
public class JSUnitBatchBuildTestrayCaseResult
	extends BatchBuildTestrayCaseResult {

	public JSUnitBatchBuildTestrayCaseResult(
		TestrayBuild testrayBuild, TopLevelBuild topLevelBuild,
		AxisTestClassGroup axisTestClassGroup,
		TestClassMethod testClassMethod) {

		super(testrayBuild, topLevelBuild, axisTestClassGroup);

		_testClassMethod = testClassMethod;
	}

	@Override
	public String getErrors() {
		List<TestClassResult> testClassResults = _getTestClassResults();

		if ((testClassResults == null) || testClassResults.isEmpty()) {
			Build build = getBuild();

			if (build == null) {
				return "Unable to run build on CI";
			}

			String result = build.getResult();

			if (result == null) {
				return "Unable to finish build on CI";
			}

			if (result.equals("ABORTED")) {
				return build.getJobName() + " timed out after 2 hours";
			}

			if (result.equals("SUCCESS") || result.equals("UNSTABLE")) {
				return "Unable to run test on CI";
			}

			return "Failed prior to running test";
		}

		Map<String, String> errorMessages = new HashMap<>();

		if (errorMessages.size() > 1) {
			return JenkinsResultsParserUtil.combine(
				"Failed tests: ",
				JenkinsResultsParserUtil.join(
					", ", new ArrayList<>(errorMessages.keySet())));
		}
		else if (errorMessages.size() == 1) {
			List<String> values = new ArrayList<>(errorMessages.values());

			return values.get(0);
		}

		return "Failed for unknown reason";
	}

	@Override
	public String getName() {
		return _testClassMethod.getName();
	}

	@Override
	public Status getStatus() {
		Build build = getBuild();

		if (build == null) {
			return Status.UNTESTED;
		}

		List<TestClassResult> testClassResults = _getTestClassResults();

		if ((testClassResults == null) || testClassResults.isEmpty()) {
			String result = build.getResult();

			if ((result == null) || result.equals("ABORTED") ||
				result.equals("FAILURE") || result.equals("SUCCESS") ||
				result.equals("UNSTABLE")) {

				return Status.UNTESTED;
			}

			return Status.FAILED;
		}

		return Status.PASSED;
	}

	private String _getTaskResultName(TestClassResult testClassResult) {
		String testClassName = testClassResult.getClassName();

		if (testClassName.contains(".modules.")) {
			testClassName = testClassName.replaceAll(
				".*\\.modules(\\..+)", "$1");
		}
		else {
			testClassName = ".apps." + testClassName;
		}

		return testClassName.replaceAll("\\.", ":");
	}

	private List<TestClassResult> _getTestClassResults() {
		if (_testClassResults != null) {
			return _testClassResults;
		}

		Build build = getBuild();

		if (build == null) {
			return null;
		}

		_testClassResults = new ArrayList<>();

		for (TestClassResult testClassResult : build.getTestClassResults()) {
			String testClassResultName = _getTaskResultName(testClassResult);

			String name = getName();

			if (testClassResultName.startsWith(
					name.replace(":packageRunTest", ""))) {

				_testClassResults.add(testClassResult);
			}
		}

		return _testClassResults;
	}

	private final TestClassMethod _testClassMethod;
	private List<TestClassResult> _testClassResults;

}