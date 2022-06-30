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
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class AverageDurationUtil {

	public static Long getAverageDuration(String batchName, String testName) {
		JSONObject averageDurationsJSONObject = _getAverageDurationJSONObject();

		JSONArray batchesJSONArray = averageDurationsJSONObject.getJSONArray(
			"batches");

		if ((batchesJSONArray == null) || batchesJSONArray.isEmpty()) {
			return null;
		}

		for (int i = 0; i < batchesJSONArray.length(); i++) {
			JSONObject batchJSONObject = batchesJSONArray.getJSONObject(i);

			if (!Objects.equals(
					_fixBatchName(batchName),
					_fixBatchName(batchJSONObject.getString("batchName")))) {

				continue;
			}

			JSONArray testsJSONArray = batchJSONObject.getJSONArray("tests");

			if ((testsJSONArray == null) || testsJSONArray.isEmpty()) {
				break;
			}

			for (int j = 0; j < testsJSONArray.length(); j++) {
				JSONObject testJSONObject = testsJSONArray.getJSONObject(j);

				if (!Objects.equals(
						testName, testJSONObject.getString("testName"))) {

					continue;
				}

				return testJSONObject.getLong("averageDuration");
			}
		}

		return 0L;
	}

	public static Long getBatchAverageDuration(String batchName) {
		JSONObject averageDurationsJSONObject = _getAverageDurationJSONObject();

		JSONArray batchesJSONArray = averageDurationsJSONObject.getJSONArray(
			"batches");

		if ((batchesJSONArray == null) || batchesJSONArray.isEmpty()) {
			return null;
		}

		for (int i = 0; i < batchesJSONArray.length(); i++) {
			JSONObject batchJSONObject = batchesJSONArray.getJSONObject(i);

			if (!Objects.equals(
					_fixBatchName(batchName),
					_fixBatchName(batchJSONObject.getString("batchName")))) {

				continue;
			}

			return batchJSONObject.getLong("averageDuration");
		}

		return 0L;
	}

	public static Long getBatchAverageOverheadDuration(String batchName) {
		JSONObject averageDurationsJSONObject = _getAverageDurationJSONObject();

		JSONArray batchesJSONArray = averageDurationsJSONObject.getJSONArray(
			"batches");

		if ((batchesJSONArray == null) || batchesJSONArray.isEmpty()) {
			return null;
		}

		for (int i = 0; i < batchesJSONArray.length(); i++) {
			JSONObject batchJSONObject = batchesJSONArray.getJSONObject(i);

			if (!Objects.equals(
					_fixBatchName(batchName),
					_fixBatchName(batchJSONObject.getString("batchName")))) {

				continue;
			}

			return batchJSONObject.getLong("averageOverheadDuration");
		}

		return 0L;
	}

	public static void main(String[] args) throws Exception {
		File file = new File(
			"/Users/michaelhashimoto/Downloads/average-durations.json");

		JSONObject averageDurationsJSONObject = _getAverageDurationJSONObject();

		JenkinsResultsParserUtil.write(
			file, averageDurationsJSONObject.toString(2));

		System.out.println(
			getAverageDuration(
				"unit-jdk8", "com.liferay.portal.kernel.util.MathUtilTest"));

		System.out.println(
			getAverageDuration(
				"unit-jdk8",
				"com.liferay.portal.servlet.filters.strip.StripFilterTest"));

		System.out.println(
			getAverageDuration(
				"functional-smoke-wildfly230-mariadb104-jdk8",
				"LocalFile.PortalSmoke#Smoke"));

		System.out.println(
			getAverageDuration(
				"functional-tomcat90-mysql57-jdk8",
				"LocalFile.PortalSmoke#Smoke"));

		System.out.println(
			JenkinsResultsParserUtil.toDurationString(
				getAverageDuration(
					"functional-smoke-tomcat90-mysql57-jdk8",
					"LocalFile.PortalSmoke#Smoke")));

		System.out.println(
			JenkinsResultsParserUtil.toDurationString(
				getAverageDuration(
					"functional-smoke-tomcat90-mysql57-jdk8",
					"LocalFile.PortalSmokeUpgrade#" +
						"ViewPortalSmokeArchive71103")));
	}

	private static String _fixBatchName(String batchName) {
		batchName = batchName.replace("_stable", "");
		batchName = batchName.replace("-smoke", "");
		batchName = batchName.replace("-upgrade", "");

		return batchName;
	}

	private static JSONObject _getAverageDurationJSONObject() {
		if (_averageDurationJSONObject != null) {
			return _averageDurationJSONObject;
		}

		File file = new File(
			JenkinsResultsParserUtil.getDistinctTimeStamp() + ".gz");

		try {
			JenkinsResultsParserUtil.toFile(
				new URL(_AVERAGE_DURATIONS_JSON_URL), file);
		}
		catch (MalformedURLException malformedURLException) {
			return null;
		}

		try {
			String content = JenkinsResultsParserUtil.read(file);

			_averageDurationJSONObject = new JSONObject(content);
		}
		catch (IOException ioException) {
			_averageDurationJSONObject = new JSONObject();
		}

		return _averageDurationJSONObject;
	}

	private static final String _AVERAGE_DURATIONS_JSON_URL =
		"https://test-1-0.liferay.com/userContent/reports/master/average-durations.json.gz";

	private static JSONObject _averageDurationJSONObject;

}