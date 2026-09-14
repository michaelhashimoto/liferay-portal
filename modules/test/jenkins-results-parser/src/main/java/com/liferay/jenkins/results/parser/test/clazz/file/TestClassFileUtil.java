/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.file;

import com.liferay.jenkins.results.parser.Dom4JUtil;
import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * @author Michael Hashimoto
 */
public class TestClassFileUtil {

	/**
	 * Formats <code>testResultsFile</code> so that each test is reported under
	 * the test class file that declares it, rather than under the name that the
	 * test framework reported.
	 */
	public static void formatTestResultsFile(
			File portalDir, File testResultsFile)
		throws DocumentException, IOException {

		if (!testResultsFile.exists()) {
			return;
		}

		String projectPath = _getProjectPath(portalDir, testResultsFile);

		List<Element> testSuiteElements = new ArrayList<>();

		Document document = Dom4JUtil.parse(
			JenkinsResultsParserUtil.read(testResultsFile));

		Element rootElement = document.getRootElement();

		if (Objects.equals(rootElement.getName(), "testsuites")) {
			testSuiteElements.addAll(rootElement.elements("testsuite"));
		}
		else {
			testSuiteElements.add(rootElement);
		}

		for (Element testSuiteElement : testSuiteElements) {
			testSuiteElement.addAttribute("package", projectPath);

			for (Element testCaseElement :
					testSuiteElement.elements("testcase")) {

				_formatTestCaseElement(
					portalDir, projectPath, testCaseElement, testSuiteElement);
			}
		}

		Dom4JUtil.removeWhitespaceTextNodes(rootElement);

		JenkinsResultsParserUtil.write(
			testResultsFile,
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				Dom4JUtil.format(rootElement));

		System.out.println("Formatted " + testResultsFile);
	}

	private static void _formatTestCaseElement(
			File baseDir, String projectPath, Element testCaseElement,
			Element testSuiteElement)
		throws IOException {

		String testSuiteName = testSuiteElement.attributeValue("name");

		if ((testSuiteName != null) && testSuiteName.contains("/")) {

			// The test framework reported the test class file, so there is no
			// name to match

			testCaseElement.addAttribute(
				"classname", projectPath + "/" + testSuiteName);

			return;
		}

		String className = testCaseElement.attributeValue("classname");
		String name = testCaseElement.attributeValue("name");

		if ((className == null) || (name == null)) {
			return;
		}

		File dir = new File(
			baseDir, projectPath + "/" + _getClassPath(className, projectPath));

		if (!dir.isDirectory()) {
			return;
		}

		TestClassFileMethod testClassFileMethod = _getTestClassFileMethod(
			dir, name);

		if (testClassFileMethod == null) {
			return;
		}

		TestClassFile testClassFile = testClassFileMethod.getTestClassFile();

		testCaseElement.addAttribute(
			"classname", testClassFile.getRelativePath(baseDir));

		if (!testClassFileMethod.isDynamic()) {

			// The name that the test framework reported is the name that the
			// test declares, so it is reported in a consistent form

			testCaseElement.addAttribute(
				"name", testClassFileMethod.getFullName());
		}
	}

	private static String _getClassPath(String className, String projectPath) {
		String projectName = projectPath;

		int index = projectName.lastIndexOf("/");

		if (index != -1) {
			projectName = projectName.substring(index + 1);
		}

		String classPath = className.replace('.', '/');

		index = classPath.indexOf(projectName + "/");

		if (index != -1) {
			classPath = classPath.substring(index + projectName.length() + 1);
		}

		return classPath;
	}

	private static String _getProjectPath(File baseDir, File testResultsFile) {
		String baseDirPath = JenkinsResultsParserUtil.getCanonicalPath(baseDir);

		File projectDir = testResultsFile.getParentFile();

		String projectDirPath = JenkinsResultsParserUtil.getCanonicalPath(
			projectDir);

		if (projectDirPath.startsWith(baseDirPath + "/")) {
			return projectDirPath.substring(baseDirPath.length() + 1);
		}

		return projectDirPath;
	}

	private static TestClassFileMethod _getTestClassFileMethod(
			File dir, String name)
		throws IOException {

		for (File file : dir.listFiles()) {
			TestClassFile testClassFile = TestClassFileFactory.newTestClassFile(
				file);

			if (testClassFile == null) {
				continue;
			}

			for (TestClassFileMethod testClassFileMethod :
					testClassFile.getTestClassFileMethods()) {

				if (testClassFileMethod.matches(name) ||
					testClassFileMethod.matchesPattern(name)) {

					return testClassFileMethod;
				}
			}
		}

		return null;
	}

}