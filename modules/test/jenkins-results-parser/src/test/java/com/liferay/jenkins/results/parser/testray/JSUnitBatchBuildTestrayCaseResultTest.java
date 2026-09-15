/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.testray;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.TopLevelBuildReport;
import com.liferay.jenkins.results.parser.test.clazz.JSUnitModulesTestClass;
import com.liferay.jenkins.results.parser.test.clazz.TestClassFactory;
import com.liferay.jenkins.results.parser.test.clazz.TestClassMethod;
import com.liferay.jenkins.results.parser.test.clazz.group.JSUnitAxisTestClassGroup;
import com.liferay.jenkins.results.parser.test.clazz.group.JSUnitModulesBatchTestClassGroup;

import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Michael Hashimoto
 */
public class JSUnitBatchBuildTestrayCaseResultTest
	extends com.liferay.jenkins.results.parser.Test {

	@Test
	public void testGetName() throws Exception {
		_mockWorkspace();

		// A batch that reports by test task names the test task

		testEquals(
			":apps:a:b:packageRunTest",
			_getName("modules/apps/a/b/test/js/c.js", null));
	}

	@Test
	public void testGetNameLong() throws Exception {
		_mockWorkspace();

		String name = JenkinsResultsParserUtil.combine(
			"modules/dxp/apps/portal-workflow/portal-workflow-kaleo-designer",
			"-web/test/js/designer/definition-builder/diagram-builder",
			"/components/nodes/state/StateNode.js");

		// A Testray case name holds 150 characters, so a longer name drops its
		// leading directories rather than the name of the test class file

		String shortenedName = _getName(name, name);

		Assert.assertTrue(shortenedName.length() <= 150);
		Assert.assertTrue(name.endsWith(shortenedName));
		Assert.assertTrue(shortenedName.endsWith("state/StateNode.js"));
		Assert.assertFalse(shortenedName.startsWith("/"));
	}

	@Test
	public void testGetNameTestClassFile() throws Exception {
		_mockWorkspace();

		// A batch that reports by test class file names the test class file

		testEquals(
			"modules/apps/a/b/test/js/c.js",
			_getName(
				"modules/apps/a/b/test/js/c.js",
				"modules/apps/a/b/test/js/c.js"));
	}

	private String _getName(String methodName, String testClassMethodName) {
		JSUnitModulesTestClass jsUnitModulesTestClass = _getTestClass(
			methodName);

		TestClassMethod testClassMethod = null;

		if (testClassMethodName != null) {
			List<TestClassMethod> testClassMethods =
				jsUnitModulesTestClass.getTestClassMethods();

			testClassMethod = testClassMethods.get(0);
		}

		JSUnitBatchBuildTestrayCaseResult jsUnitBatchBuildTestrayCaseResult =
			new JSUnitBatchBuildTestrayCaseResult(
				Mockito.mock(JSUnitAxisTestClassGroup.class),
				jsUnitModulesTestClass, testClassMethod,
				Mockito.mock(TestrayBuild.class),
				Mockito.mock(TopLevelBuildReport.class));

		return jsUnitBatchBuildTestrayCaseResult.getName();
	}

	private JSUnitModulesTestClass _getTestClass(String methodName) {
		JSONObject methodJSONObject = new JSONObject();

		methodJSONObject.put(
			"ignored", false
		).put(
			"name", methodName
		);

		JSONObject jsonObject = new JSONObject();

		jsonObject.put(
			"file", "/x/modules/apps/a/b"
		).put(
			"methods",
			new JSONArray(
			).put(
				methodJSONObject
			)
		).put(
			"task_name", "packageRunTest"
		);

		return (JSUnitModulesTestClass)TestClassFactory.newTestClass(
			Mockito.mock(JSUnitModulesBatchTestClassGroup.class), jsonObject);
	}

	private void _mockWorkspace() {
		mockEnvironment(Collections.singletonMap("WORKSPACE", "/x"));
	}

}