/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.testray;

import com.liferay.jenkins.results.parser.TopLevelBuildReport;
import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class BuildReportTestrayCaseResult extends TestrayCaseResult {

	public TopLevelBuildReport getTopLevelBuildReport() {
		return _topLevelBuildReport;
	}

	protected BuildReportTestrayCaseResult(
		TestrayBuild testrayBuild, TopLevelBuildReport topLevelBuildReport) {

		super(testrayBuild, new JSONObject());

		_topLevelBuildReport = topLevelBuildReport;
	}

	private final TopLevelBuildReport _topLevelBuildReport;

}