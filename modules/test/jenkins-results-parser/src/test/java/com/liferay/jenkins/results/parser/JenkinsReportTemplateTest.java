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
	public void testRenderJenkinsReportTableRows() {
		TemplateEngine templateEngine = new TemplateEngine();

		ClassLoaderTemplateResolver classLoaderTemplateResolver =
			new ClassLoaderTemplateResolver();

		classLoaderTemplateResolver.setCharacterEncoding("UTF-8");
		classLoaderTemplateResolver.setPrefix(
			"com/liferay/jenkins/results/parser/dependencies/jenkins/report/");
		classLoaderTemplateResolver.setTemplateMode(TemplateMode.HTML);

		templateEngine.setTemplateResolver(classLoaderTemplateResolver);

		List<Map<String, Object>> rows = new ArrayList<>();

		rows.add(
			_createObjectMap(
				"cells",
				Arrays.asList(
					_createObjectMap(
						"parts",
						Arrays.asList(
							_createMap(
								"id", "12345-expander-anchor-", "onClick",
								"return toggleStopWatchRecordExpander(" +
									"'12345', '')",
								"style",
								"font-family: monospace, monospace; " +
									"text-decoration: none",
								"type", "expander"),
							_createMap(
								"text", "test (axis-1)", "type", "link", "url",
								"https://test-1-1.liferay.com/job/test/1/"),
							_createMap(
								"text", "(cached build)", "type", "span")),
						"style", "text-indent: 15", "tagName", "th"),
					_createObjectMap(
						"parts", Arrays.asList(_createMap("type", "nbsp")),
						"tagName", "td"),
					_createObjectMap(
						"parts",
						Arrays.asList(
							_createMap(
								"text", "Stop Watch Record", "type",
								"underline")),
						"tagName", "td")),
				"childStopwatchRows", "stop-watch-record-header", "id",
				"12345-"));
		rows.add(_createObjectMap("batchName", "modules-unit"));
		rows.add(
			_createObjectMap(
				"cells",
				Arrays.asList(
					_createObjectMap(
						"parts", new ArrayList<>(), "tagName", "td")),
				"id", "12345-stop-watch-record-header", "style",
				"display: none"));

		Context context = new Context();

		context.setVariable("rows", rows);

		String content = templateEngine.process(
			"jenkins_report_table_rows.html", context);

		Assert.assertTrue(
			"Missing build info row attributes",
			content.contains(
				"<tr child-stopwatch-rows=\"stop-watch-record-header\" " +
					"id=\"12345-\">"));
		Assert.assertTrue(
			"Missing expander anchor",
			content.contains(
				"<a href=\"\" id=\"12345-expander-anchor-\" onClick=\"return " +
					"toggleStopWatchRecordExpander(&#39;12345&#39;, " +
						"&#39;&#39;)\" style=\"font-family: monospace, " +
							"monospace; text-decoration: none\">+ </a>"));
		Assert.assertTrue(
			"Missing name cell link",
			content.contains(
				"<a href=\"https://test-1-1.liferay.com/job/test/1/\">" +
					"test (axis-1)</a><span>(cached build)</span></th>"));
		Assert.assertTrue(
			"Missing name cell style",
			content.contains("<th style=\"text-indent: 15\">"));
		Assert.assertTrue(
			"Missing nbsp cell", content.contains("<td>&nbsp;</td>"));
		Assert.assertTrue(
			"Missing underline cell",
			content.contains("<td><u>Stop Watch Record</u></td>"));
		Assert.assertTrue(
			"Missing batch name header",
			content.contains("<th>modules-unit</th>"));
		Assert.assertTrue(
			"Missing hidden row",
			content.contains(
				"<tr id=\"12345-stop-watch-record-header\" style=\"display: " +
					"none\">"));
		Assert.assertTrue(
			"Missing hidden row empty cell", content.contains("<td></td>"));
	}

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
			"Missing raw Chart.js content",
			content.contains("var x = 1 && 2;"));
		Assert.assertTrue(
			"Missing link summary item",
			content.contains(
				"<p><a href=\"https://test-1-0.liferay.com/status\">" +
					"CI System Status</a></p>"));
		Assert.assertTrue(
			"Missing plain summary item",
			content.contains("<p>Build Time: 10 minutes</p>"));
		Assert.assertTrue(
			"Missing link and value summary item",
			content.contains(
				"<p>Longest Running Downstream Build: <a " +
					"href=\"https://test-1-1.liferay.com/job/test-downstream" +
						"/1/\">downstream-1</a> in: 9 minutes</p>"));
		Assert.assertTrue(
			"Missing top level table caption",
			content.contains("Top Level Build - <strong>SUCCESS</strong>"));
		Assert.assertTrue(
			"Missing top level table rows",
			content.contains("<td>top-level-row</td>"));
		Assert.assertTrue(
			"Missing stop watch record rows",
			content.contains("<td>stop-watch-row</td>"));
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
			"Missing completed downstream table rows",
			content.contains("<td>downstream-1</td>") &&
			content.contains("<td>downstream-2</td>"));
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

		context.setVariable(
			"build",
			_createObjectMap(
				"buildJSONObject", new JSONObject(), "buildURL",
				"https://test-1-1.liferay.com/job/rca/1/",
				"jenkinsReportChartJsContent", "var x = 1;",
				"jenkinsReportSummaryItems",
				Arrays.asList(
					_createMap("label", "Build Time: ", "value", "10 minutes")),
				"workspaceGitRepository",
				_createMap(
					"gitHubURL",
					"https://github.com/liferay/liferay-portal/tree/master")));
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

		public JSONObject getBuildJSONObject() {
			JSONObject buildJSONObject = new JSONObject();

			buildJSONObject.put(
				"description", "Description with <strong>markup</strong>");

			return buildJSONObject;
		}

		public String getBuildURL() {
			return "https://test-1-1.liferay.com/job/test/1/";
		}

		public int getDownstreamBuildCount(String result, String status) {
			return 2;
		}

		public Map<String, Object> getJenkinsReportBuildInfoRow() {
			return _createTextCellRow("top-level-row");
		}

		public String getJenkinsReportChartJsContent() {
			return "var x = 1 && 2;";
		}

		public List<Map<String, Object>> getJenkinsReportStopWatchRecordRows() {
			return Arrays.asList(_createTextCellRow("stop-watch-row"));
		}

		public List<Map<String, String>> getJenkinsReportSummaryItems() {
			return Arrays.asList(
				_createMap(
					"linkText", "CI System Status", "url",
					"https://test-1-0.liferay.com/status"),
				_createMap("label", "Build Time: ", "value", "10 minutes"),
				_createMap(
					"label", "Longest Running Downstream Build: ", "linkText",
					"downstream-1", "url",
					"https://test-1-1.liferay.com/job/test-downstream/1/",
					"value", " in: 9 minutes"));
		}

		public List<Map<String, Object>> getJenkinsReportTableRows(
			String result, String status) {

			if (!Objects.equals(result, "SUCCESS")) {
				return new ArrayList<>();
			}

			return Arrays.asList(
				_createTextCellRow("downstream-1"),
				_createTextCellRow("downstream-2"));
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

		public String getResult() {
			return "SUCCESS";
		}

		public String getStatus() {
			return "completed";
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

	private Map<String, Object> _createTextCellRow(String text) {
		return _createObjectMap(
			"cells",
			Arrays.asList(
				_createObjectMap(
					"parts",
					Arrays.asList(_createMap("text", text, "type", "text")),
					"tagName", "td")));
	}

}