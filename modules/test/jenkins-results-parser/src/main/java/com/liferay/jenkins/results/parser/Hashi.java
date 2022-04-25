/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import org.dom4j.Element;

/**
 * @author Michael Hashimoto
 */
public class Hashi {

	public static void main(String[] args) throws Exception {
		Build build = BuildFactory.newBuild(
			"https://test-5-2.liferay.com/job/test-portal-acceptance-" +
				"pullrequest(master)/852/",
			null);

		if (!(build instanceof TopLevelBuild)) {
			return;
		}

		TopLevelBuild topLevelBuild = (TopLevelBuild)build;

		Element jenkinsReportElement = topLevelBuild.getJenkinsReportElement();

		File jenkinsReportFile = new File("jenkins-report.html");

		JenkinsResultsParserUtil.write(
			jenkinsReportFile, Dom4JUtil.format(jenkinsReportElement, true));

		System.out.println(
			JenkinsResultsParserUtil.getCanonicalPath(jenkinsReportFile));
	}

}