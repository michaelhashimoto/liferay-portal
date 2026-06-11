/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * @author Michael Hashimoto
 */
public class JenkinsReportTemplateTest {

	@Test
	public void testRenderJenkinsReportTemplate() {
		TemplateEngine templateEngine = new TemplateEngine();

		ClassLoaderTemplateResolver classLoaderTemplateResolver =
			new ClassLoaderTemplateResolver();

		classLoaderTemplateResolver.setCharacterEncoding("UTF-8");
		classLoaderTemplateResolver.setPrefix(
			"com/liferay/jenkins/results/parser/dependencies/jenkins/report/");
		classLoaderTemplateResolver.setTemplateMode(TemplateMode.HTML);

		templateEngine.setTemplateResolver(classLoaderTemplateResolver);

		Context context = new Context();

		context.setVariable("build", new TestBuild());
		context.setVariable("cssContent", "body { color: red; }");
		context.setVariable("jsContent", "function f() { return 1 < 2; }");

		String content = templateEngine.process("jenkins_report.html", context);

		Assert.assertTrue(
			"Missing heading link",
			content.contains(
				"Jenkins report for <a " +
					"href=\"https://test-1-1.liferay.com/job/test/1/\">" +
						"https://test-1-1.liferay.com/job/test/1/</a>"));
		Assert.assertTrue(
			"Missing raw description",
			content.contains("Description with <strong>markup</strong>"));
		Assert.assertTrue(
			"Missing sender branch information",
			content.contains("<p>Sender Branch Name: LPD-12345</p>") &&
			content.contains("<p>Sender Branch SHA: abc123</p>"));
		Assert.assertTrue(
			"Missing commit information",
			content.contains(
				"<p>Commit Message: LPD-12345 Fix &lt;something&gt;</p>") &&
			content.contains("<p>Commit Date: 6-10-2026 08:00:00 PST</p>"));
		Assert.assertTrue(
			"Missing raw CSS content",
			content.contains("body { color: red; }"));
		Assert.assertTrue(
			"Missing raw JS content",
			content.contains("function f() { return 1 < 2; }"));
		Assert.assertTrue(
			"Missing timeline chart data",
			content.contains("labels: [0,1,2],") &&
			content.contains("data: [0,1,1],") &&
			content.contains("data: [1,0,0],"));
		Assert.assertTrue(
			"Missing timeline chart callback",
			content.contains("return hours + ':' + minutes + ':' + seconds;"));
		Assert.assertTrue(
			"Missing link summary item",
			content.contains(
				"<p><a href=\"https://test-1-0.liferay.com/status\">" +
					"CI System Status</a></p>"));
		Assert.assertTrue(
			"Missing plain summary item",
			content.contains("<p>Build Time: 10 minutes</p>") &&
			content.contains("<p>Start Time: 6-10-2026 07:00:00 PST</p>") &&
			content.contains("<p>Total number of reinvocations: 1</p>"));
		Assert.assertTrue(
			"Missing link and value summary item",
			content.contains(
				"<p>Longest delay time for invoked build to start: <a " +
					"href=\"https://test-1-1.liferay.com/job/test-downstream" +
						"/1/\">downstream-1</a> in: 8 minutes</p>") &&
			content.contains(
				"<p>Longest Running Downstream Build: <a " +
					"href=\"https://test-1-1.liferay.com/job/test-downstream" +
						"/1/\">downstream-1</a> in: 9 minutes</p>"));
		Assert.assertFalse(
			"Unexpected longest running test summary item",
			content.contains("Longest Running Test: "));
		Assert.assertTrue(
			"Missing top level table caption",
			content.contains("Top Level Build - <strong>SUCCESS</strong>"));
		Assert.assertTrue(
			"Missing top level build info row",
			content.contains(
				"<tr child-stopwatch-rows=\"stop-watch-record-header\" " +
					"id=\"12345-\">"));
		Assert.assertTrue(
			"Missing build info name cell",
			content.contains(
				"<th style=\"text-indent: 15\"><a href=\"\" " +
					"id=\"12345-expander-anchor-\" onClick=\"return " +
						"toggleStopWatchRecordExpander(&#39;12345&#39;, " +
							"&#39;&#39;)\" style=\"font-family: monospace, " +
								"monospace; text-decoration: none\">+ </a>" +
									"<a href=\"https://test-1-1.liferay.com" +
										"/job/test/1/\">test (axis-1)</a>" +
											"<span>(cached build)</span>" +
												"</th>"));
		Assert.assertTrue(
			"Missing build info link cells",
			content.contains(
				"<th><a href=\"https://test-1-1.liferay.com/job/test/1" +
					"/console\">Console</a></th>") &&
			content.contains(
				"<th><a href=\"https://test-1-1.liferay.com/job/test/1" +
					"/testReport\">Test Report</a></th>"));
		Assert.assertTrue(
			"Missing build info value cells",
			content.contains("<th>6-10-2026 07:00:00 PST</th>") &&
			content.contains("<th>10 minutes</th>") &&
			content.contains("<th>COMPLETED</th>") &&
			content.contains("<th>SUCCESS</th>"));
		Assert.assertTrue(
			"Missing build durations header row",
			content.contains("id=\"12345-build-durations-header\"") &&
			content.contains(
				"child-stopwatch-rows=\"build-duration-names," +
					"build-duration-values,build-overhead-duration-values," +
						"build-test-duration-values\"") &&
			content.contains("<u>Build Durations</u></td>"));
		Assert.assertTrue(
			"Missing build duration names row",
			content.contains("id=\"12345-build-duration-names\"") &&
			content.contains("<th style=\"text-indent: 70px\">Name</th>") &&
			content.contains("<th>Duration (est)</th>"));
		Assert.assertTrue(
			"Missing total duration row",
			content.contains(
				"<td style=\"text-indent: 70px\">Total Duration</td>") &&
			content.contains("<td>7 minutes</td>") &&
			content.contains("<td>diff-3</td>"));
		Assert.assertTrue(
			"Missing total test durations row",
			content.contains(
				"<td style=\"text-indent: 70px\">Total Test Durations</td>") &&
			content.contains("<td>6 minutes</td>") &&
			content.contains("<td>5 minutes</td>") &&
			content.contains("<td>diff-1</td>"));
		Assert.assertTrue(
			"Missing overhead duration row",
			content.contains(
				"<td style=\"text-indent: 70px\">Overhead Duration</td>") &&
			content.contains("<td>4 minutes</td>") &&
			content.contains("<td>2 minutes</td>") &&
			content.contains("<td>diff-2</td>"));
		Assert.assertTrue(
			"Missing test durations header row",
			content.contains("id=\"12345-test-durations-header\"") &&
			content.contains(
				"child-stopwatch-rows=\"test-duration-names," +
					"test-duration-values-0\"") &&
			content.contains("<u>Test Durations</u></td>"));
		Assert.assertTrue(
			"Missing test duration values row",
			content.contains("id=\"12345-test-duration-values-0\"") &&
			content.contains(
				"<td style=\"text-indent: 70px\">com.liferay.test.FooTest" +
					"</td>") &&
			content.contains("<td>8 minutes</td>") &&
			content.contains("<td>3 minutes</td>") &&
			content.contains("<td>diff-5</td>"));
		Assert.assertTrue(
			"Missing stop watch record header row",
			content.contains("id=\"12345-stop-watch-record-header\"") &&
			content.contains("child-stopwatch-rows=\"record.one\"") &&
			content.contains("<u>Stop Watch Record</u></td>"));
		Assert.assertTrue(
			"Missing stop watch record row",
			content.contains("id=\"12345-record.one\"") &&
			content.contains(
				"<td style=\"text-indent: 50px\"><a href=\"\" " +
					"id=\"12345-expander-anchor-record.one\" " +
						"onClick=\"return toggleStopWatchRecordExpander(" +
							"&#39;12345&#39;, &#39;record.one&#39;)\" " +
								"style=\"font-family: monospace, monospace; " +
									"text-decoration: none\">+ </a>one</td>") &&
			content.contains("<td>date-1000</td>") &&
			content.contains("<td>60 minutes</td>"));
		Assert.assertTrue(
			"Missing child stop watch record row",
			content.contains("id=\"12345-record.one.child\"") &&
			content.contains("<td style=\"text-indent: 105px\">child</td>") &&
			content.contains("<td>date-2000</td>") &&
			content.contains("<td>&nbsp;</td>"));
		Assert.assertTrue(
			"Missing column header", content.contains("<th>Test Report</th>"));
		Assert.assertFalse(
			"Unexpected build durations column header",
			content.contains("<th>Build Time (est)</th>"));
		Assert.assertTrue(
			"Missing completed heading",
			content.contains("<h2>Completed: </h2>"));
		Assert.assertTrue(
			"Missing completed downstream table caption",
			content.contains("<caption>---- Success: 2</caption>"));
		Assert.assertTrue(
			"Missing batch name header",
			content.contains("<th>modules-unit</th>"));
		Assert.assertTrue(
			"Missing downstream build info cells",
			content.contains("<td style=\"text-indent: 15\">") &&
			content.contains(
				"<td><a href=\"https://test-1-1.liferay.com/job/test/1" +
					"/console\">Console</a></td>"));
		Assert.assertFalse(
			"Unexpected empty downstream table", content.contains("Queued: "));
	}

	@Test
	public void testRenderRCAJenkinsReportTemplate() {
		TemplateEngine templateEngine = new TemplateEngine();

		ClassLoaderTemplateResolver classLoaderTemplateResolver =
			new ClassLoaderTemplateResolver();

		classLoaderTemplateResolver.setCharacterEncoding("UTF-8");
		classLoaderTemplateResolver.setPrefix(
			"com/liferay/jenkins/results/parser/dependencies/jenkins/report/");
		classLoaderTemplateResolver.setTemplateMode(TemplateMode.HTML);

		templateEngine.setTemplateResolver(classLoaderTemplateResolver);

		Context context = new Context();

		context.setVariable("build", new TestBuild());
		context.setVariable(
			"commitGroups",
			Arrays.asList(
				_createObjectMap(
					"buildDuration", "10 minutes", "buildResult", "SUCCESS",
					"buildStatus", "completed", "buildURL",
					"https://test-1-1.liferay.com/job/rca-batch/1/",
					"commitDate", "2026-06-10 8:00:00 AM PST", "commitMessage",
					"LPD-12345 Break <something>", "commitSHA", "*abc123d",
					"commitURL",
					"https://github.com/liferay/liferay-portal/commit/abc123d",
					"commits",
					Arrays.asList(
						_createMap(
							"date", "2026-06-10 7:00:00 AM PST", "message",
							"LPD-12345 Earlier commit", "sha", "def456a", "url",
							"https://github.com/liferay/liferay-portal/commit" +
								"/def456a")),
					"diffText", "2 commits", "diffURL",
					"https://github.com/liferay/liferay-portal/compare" +
						"/def456a...abc123d",
					"toggleSHA", "abc123d"),
				_createObjectMap(
					"commitDate", "2026-06-09 8:00:00 AM PST", "commitMessage",
					"LPD-12345 Good commit", "commitSHA", "fed789b",
					"commitURL",
					"https://github.com/liferay/liferay-portal/commit/fed789b",
					"commits", new ArrayList<>())));
		context.setVariable("cssContent", "body { font-family: sans-serif; }");
		context.setVariable("jsContent", "$(document).ready(function() {});");

		String content = templateEngine.process(
			"jenkins_report_rca.html", context);

		Assert.assertTrue(
			"Missing jQuery script",
			content.contains(
				"<script src=\"https://ajax.aspnetcdn.com/ajax/jQuery" +
					"/jquery-3.3.1.min.js\" type=\"text/javascript\">" +
						"</script>"));
		Assert.assertTrue(
			"Missing raw JS content",
			content.contains("$(document).ready(function() {});"));
		Assert.assertTrue(
			"Missing raw CSS content",
			content.contains("body { font-family: sans-serif; }"));
		Assert.assertTrue(
			"Missing table caption",
			content.contains(
				"<h2>Commit history of <a href=\"https://github.com/liferay" +
					"/liferay-portal/commits/master\">https://github.com" +
						"/liferay/liferay-portal/commits/master</a></h2>"));
		Assert.assertTrue(
			"Missing toggle cell",
			content.contains(
				"<td><label for=\"abc123d\">+</label><input " +
					"data-toggle=\"toggle\" type=\"checkbox\" id=\"abc123d\" " +
						"name=\"abc123d\" /></td>"));
		Assert.assertTrue(
			"Missing commit link",
			content.contains(
				"<td><a href=\"https://github.com/liferay/liferay-portal" +
					"/commit/abc123d\">*abc123d</a></td>"));
		Assert.assertTrue(
			"Missing escaped commit message",
			content.contains("<td>LPD-12345 Break &lt;something&gt;</td>"));
		Assert.assertTrue(
			"Missing diff link",
			content.contains(
				"<td><a href=\"https://github.com/liferay/liferay-portal" +
					"/compare/def456a...abc123d\">2 commits</a></td>"));
		Assert.assertTrue(
			"Missing build link",
			content.contains(
				"<td><a href=\"https://test-1-1.liferay.com/job/rca-batch/1" +
					"/\">build</a></td>"));
		Assert.assertTrue(
			"Missing hidden commit row",
			content.contains(
				"<td><a href=\"https://github.com/liferay/liferay-portal" +
					"/commit/def456a\">def456a</a></td>"));
		Assert.assertTrue(
			"Missing result row tbody",
			content.contains("<tbody class=\"result-row\">"));
		Assert.assertTrue(
			"Missing hidden row tbody",
			content.contains("<tbody class=\"hidden-row\">"));
		Assert.assertFalse(
			"Unexpected toggle cell on single commit group",
			content.contains("for=\"fed789b\""));
		Assert.assertTrue(
			"Missing HEAD commit note",
			content.contains("<p><em>Indicates HEAD Commit (*)</em></p>"));
	}

	public class TestBuild {

		public boolean buildDurationsEnabled() {
			return false;
		}

		@Override
		public boolean equals(Object object) {
			if (this == object) {
				return true;
			}

			return false;
		}

		public long getAverageDelayTime() {
			return 4;
		}

		public long getAverageDuration() {
			return 7;
		}

		public long getAverageOverheadDuration() {
			return 2;
		}

		public long getAverageTotalTestDuration() {
			return 5;
		}

		public String getBatchName() {
			return "modules-unit";
		}

		public JSONObject getBuildJSONObject() {
			JSONObject buildJSONObject = new JSONObject();

			buildJSONObject.put(
				"description", "Description with <strong>markup</strong>");

			return buildJSONObject;
		}

		public String getBuildURL() {
			return "https://test-1-1.liferay.com/job/test/1/";
		}

		public String getCISystemStatusURL() {
			return "https://test-1-0.liferay.com/status";
		}

		public int getDepth() {
			return 1;
		}

		public String getDiffDurationString(long diffDuration) {
			return "diff-" + diffDuration;
		}

		public String getDisplayName() {
			return "test (axis-1)";
		}

		public int getDownstreamBuildCount(String result, String status) {
			return 2;
		}

		public long getDuration() {
			return 10;
		}

		public List<TestBuild> getJenkinsReportDownstreamBuilds(
			String result, String status) {

			if (!Objects.equals(result, "SUCCESS")) {
				return new ArrayList<>();
			}

			return Arrays.asList((TestBuild)new TestDownstreamBuild());
		}

		public String getJenkinsReportTimeZoneName() {
			return "PST";
		}

		public Map<String, Object> getLongestDelayedDownstreamBuild() {
			return _createObjectMap(
				"buildURL",
				"https://test-1-1.liferay.com/job/test-downstream/1/",
				"delayTime", 8L, "displayName", "downstream-1");
		}

		public Map<String, Object> getLongestRunningDownstreamBuild() {
			return _createObjectMap(
				"buildURL",
				"https://test-1-1.liferay.com/job/test-downstream/1/",
				"displayName", "downstream-1", "duration", 9L);
		}

		public long getOverheadDuration() {
			return 4;
		}

		public Map<String, String> getPrimaryGitHubRemoteGitCommit() {
			return _createMap(
				"commitDateString", "6-10-2026 08:00:00 PST", "message",
				"LPD-12345 Fix <something>");
		}

		public Map<String, String> getPrimaryWorkspaceGitRepository() {
			return _createMap(
				"senderBranchName", "LPD-12345", "senderBranchSHA", "abc123");
		}

		public long getQueuingDuration() {
			return 1;
		}

		public String getResult() {
			return "SUCCESS";
		}

		public Long getStartTime() {
			return 5000L;
		}

		public String getStartTimeString() {
			return "6-10-2026 07:00:00 PST";
		}

		public String getStatus() {
			return "completed";
		}

		public Map<String, Object> getStopWatchRecordsGroup() {
			return _createObjectMap(
				"stopWatchRecords",
				Arrays.asList(
					_createObjectMap(
						"childStopWatchRecords",
						Arrays.asList(
							_createObjectMap(
								"depth", 1, "name", "record.one.child",
								"shortName", "child", "startTimestamp", 2000L)),
						"depth", 0, "duration", 60L, "name", "record.one",
						"shortName", "one", "startTimestamp", 1000L)));
		}

		public List<Map<String, Object>> getTestDurations() {
			return Arrays.asList(
				_createObjectMap(
					"averageDuration", 3L, "duration", 8L, "name",
					"com.liferay.test.FooTest"));
		}

		public Map<String, Object> getTimelineData() {
			return _createObjectMap(
				"indexData", new int[] {0, 1, 2}, "invocationsData",
				new int[] {1, 0, 0}, "slaveUsageData", new int[] {0, 1, 1});
		}

		public long getTotalActualDuration() {
			return 2;
		}

		public int getTotalActualSlavesUsedCount() {
			return 6;
		}

		public long getTotalCachedDuration() {
			return 3;
		}

		public int getTotalCachedSlavesUsedCount() {
			return 7;
		}

		public long getTotalDuration() {
			return 5;
		}

		public int getTotalReinvocationCount() {
			return 1;
		}

		public int getTotalSlavesUsedCount() {
			return 13;
		}

		public long getTotalTestDuration() {
			return 6;
		}

		public Map<String, String> getWorkspaceGitRepository() {
			return _createMap(
				"gitHubURL",
				"https://github.com/liferay/liferay-portal/tree/master");
		}

		public boolean hasBuildDurations() {
			return true;
		}

		@Override
		public int hashCode() {
			return 12345;
		}

		public boolean isBuildCached() {
			return true;
		}

		public boolean isJenkinsReportLongestRunningTestEnabled() {
			return false;
		}

		public boolean isOverheadIncluded() {
			return true;
		}

		public String toDurationString(long duration) {
			return duration + " minutes";
		}

		public String toJenkinsReportDateString(long timestamp) {
			return "date-" + timestamp;
		}

	}

	public class TestDownstreamBuild extends TestBuild {

		@Override
		public List<TestBuild> getJenkinsReportDownstreamBuilds(
			String result, String status) {

			return new ArrayList<>();
		}

	}

	private Map<String, String> _createMap(String... keyValues) {
		Map<String, String> map = new HashMap<>();

		for (int i = 0; i < keyValues.length; i += 2) {
			map.put(keyValues[i], keyValues[i + 1]);
		}

		return map;
	}

	private Map<String, Object> _createObjectMap(Object... keyValues) {
		Map<String, Object> map = new HashMap<>();

		for (int i = 0; i < keyValues.length; i += 2) {
			map.put((String)keyValues[i], keyValues[i + 1]);
		}

		return map;
	}

}