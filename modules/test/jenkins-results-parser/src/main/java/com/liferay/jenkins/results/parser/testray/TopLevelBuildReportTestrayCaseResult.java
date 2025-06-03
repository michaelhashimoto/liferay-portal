/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.testray;

import com.liferay.jenkins.results.parser.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Hashimoto
 */
public class TopLevelBuildReportTestrayCaseResult
	extends BuildReportTestrayCaseResult {

	public void recordTestrayCaseResult(Job job) {
		TestrayBuild testrayBuild = getTestrayBuild();

		TestrayRun testrayRun = TestrayFactory.newTestrayRun(
			testrayBuild, "top-level-build", job.getJobPropertiesFiles());

		long start = JenkinsResultsParserUtil.getCurrentTimeMillis();

		Document document = DocumentHelper.createDocument();

		Element rootElement = document.addElement("testsuite");

		Element environmentsElement = rootElement.addElement("environments");

		for (TestrayRun.Factor factor : testrayRun.getFactors()) {
			Element environmentElement = environmentsElement.addElement(
				"environment");

			environmentElement.addAttribute("type", factor.getName());
			environmentElement.addAttribute("option", factor.getValue());
		}

		Map<String, String> propertiesMap = new HashMap<>();

		TopLevelBuildReport topLevelBuildReport = getTopLevelBuildReport();

		propertiesMap.put(
			"testray.build.date",
			topLevelBuildReport.getTestrayBuildDateString());

		propertiesMap.put("testray.build.name", testrayBuild.getName());

		TestrayRoutine testrayRoutine = testrayBuild.getTestrayRoutine();

		propertiesMap.put("testray.build.type", testrayRoutine.getName());

		TestrayProductVersion testrayProductVersion =
			testrayBuild.getTestrayProductVersion();

		if (testrayProductVersion != null) {
			propertiesMap.put(
				"testray.product.version", testrayProductVersion.getName());
		}

		TestrayProject testrayProject = testrayBuild.getTestrayProject();

		propertiesMap.put("testray.project.name", testrayProject.getName());

		propertiesMap.put("testray.run.id", testrayRun.getRunIDString());

		addPropertyElements(
			rootElement.addElement("properties"), propertiesMap);

		List<TestrayCaseResult> testrayCaseResults = new ArrayList<>();

		testrayCaseResults.add(this);

		for (TestrayCaseResult testrayCaseResult : testrayCaseResults) {
			try {
				Element testcaseElement = Dom4JUtil.getNewElement("testcase");

				Map<String, String> testcasePropertiesMap = new HashMap<>();

				testcasePropertiesMap.put(
					"testray.case.type.name", testrayCaseResult.getType());
				testcasePropertiesMap.put(
					"testray.component.names",
					testrayCaseResult.getSubcomponentNames());
				testcasePropertiesMap.put(
					"testray.main.component.name",
					testrayCaseResult.getComponentName());
				testcasePropertiesMap.put(
					"testray.team.name", testrayCaseResult.getTeamName());
				testcasePropertiesMap.put(
					"testray.testcase.duration",
					String.valueOf(testrayCaseResult.getDuration()));

				String testrayCaseName = testrayCaseResult.getName();

				if (testrayCaseName.length() > 150) {
					testrayCaseName = testrayCaseName.substring(0, 150);
				}

				testcasePropertiesMap.put(
					"testray.testcase.name", testrayCaseName);

				testcasePropertiesMap.put(
					"testray.testcase.priority",
					String.valueOf(testrayCaseResult.getPriority()));

				TestrayCaseResult.Status testrayCaseStatus =
					testrayCaseResult.getStatus();

				testcasePropertiesMap.put(
					"testray.testcase.status", testrayCaseStatus.getName());

				Element propertiesElement = testcaseElement.addElement(
					"properties");

				addPropertyElements(propertiesElement, testcasePropertiesMap);

				String[] warnings = testrayCaseResult.getWarnings();

				if ((warnings != null) && (warnings.length > 0)) {
					Element warningsPropertyElement =
						propertiesElement.addElement("property");

					warningsPropertyElement.addAttribute(
						"name", "testray.testcase.warnings");
					warningsPropertyElement.addAttribute(
						"value", String.valueOf(warnings.length));

					for (String warning : warnings) {
						Element warningPropertyElement =
							warningsPropertyElement.addElement("value");

						warningPropertyElement.addText(
							StringEscapeUtils.escapeHtml(warning));
					}
				}

				Element attachmentsElement = testcaseElement.addElement(
					"attachments");

				for (TestrayAttachment testrayAttachment :
					testrayCaseResult.getTestrayAttachments()) {

					Element attachmentFileElement =
						attachmentsElement.addElement("file");

					attachmentFileElement.addAttribute(
						"name", testrayAttachment.getName());
					attachmentFileElement.addAttribute(
						"url", testrayAttachment.getURL() + "?authuser=0");
					attachmentFileElement.addAttribute(
						"value", testrayAttachment.getKey() + "?authuser=0");
				}

				String errors = testrayCaseResult.getErrors();

				if (!JenkinsResultsParserUtil.isNullOrEmpty(errors)) {
					Element failureElement = testcaseElement.addElement(
						"failure");

					failureElement.addAttribute("message", errors);
				}

				rootElement.add(testcaseElement);
			}
			catch (RuntimeException runtimeException) {
				System.out.println(runtimeException);
			}
		}

		TestrayServer testrayServer = testrayBuild.getTestrayServer();

		JenkinsMaster jenkinsMaster = topLevelBuildReport.getJenkinsMaster();

		try {
			testrayServer.writeCaseResult(
				JenkinsResultsParserUtil.combine(
					"TESTS-", jenkinsMaster.getName(), "_",
					topLevelBuildReport.getJobName(), "_",
					String.valueOf(topLevelBuildReport.getBuildNumber()),
					"_top-level-build.xml"),
				Dom4JUtil.format(rootElement));
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}

		long end = JenkinsResultsParserUtil.getCurrentTimeMillis();

		System.out.println(
			JenkinsResultsParserUtil.combine(
				"Recorded ", String.valueOf(testrayCaseResults.size()),
				" case results for top-level-build in ",
				JenkinsResultsParserUtil.toDurationString(end - start)));
	}

	protected TopLevelBuildReportTestrayCaseResult(
		TestrayBuild testrayBuild, TopLevelBuildReport topLevelBuildReport) {

		super(testrayBuild, topLevelBuildReport);
	}

}