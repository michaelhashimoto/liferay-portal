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

import org.json.JSONArray;
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
			"com/liferay/jenkins/results/parser/dependencies/");
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
		rows.add(
			_createObjectMap(
				"rawHTML", "<tr><td>legacy-archived-row</td></tr>"));

		Context context = new Context();

		context.setVariable("rows", rows);

		String content = templateEngine.process(
			"jenkins_report_table_rows.html", context);

		JSONArray jsonArray = new JSONArray();

		for (Map<String, Object> row : rows) {
			jsonArray.put(row);
		}

		jsonArray = new JSONArray(jsonArray.toString());

		List<Map<String, Object>> archivedRows = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);

			archivedRows.add(jsonObject.toMap());
		}

		Context archivedContext = new Context();

		archivedContext.setVariable("rows", archivedRows);

		Assert.assertEquals(
			"Rows rendered from a JSON archive round trip must match", content,
			templateEngine.process(
				"jenkins_report_table_rows.html", archivedContext));

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
		Assert.assertTrue(
			"Missing raw HTML row",
			content.contains("<tr><td>legacy-archived-row</td></tr>"));
	}

	@Test
	public void testRenderJenkinsReportTemplate() {
		TemplateEngine templateEngine = new TemplateEngine();

		ClassLoaderTemplateResolver classLoaderTemplateResolver =
			new ClassLoaderTemplateResolver();

		classLoaderTemplateResolver.setCharacterEncoding("UTF-8");
		classLoaderTemplateResolver.setPrefix(
			"com/liferay/jenkins/results/parser/dependencies/");
		classLoaderTemplateResolver.setTemplateMode(TemplateMode.HTML);

		templateEngine.setTemplateResolver(classLoaderTemplateResolver);

		Context context = new Context();

		context.setVariable(
			"buildURL", "https://test-1-1.liferay.com/job/test/1/");
		context.setVariable("chartJsContent", "var x = 1 && 2;");
		context.setVariable("chartJsURL", "https://cdn.example.com/chart.js");
		context.setVariable(
			"columnHeaders",
			Arrays.asList(
				"Name", "Console", "Test Report", "Start Time", "Build Time",
				"Status", "Result"));

		context.setVariable(
			"commit",
			_createMap(
				"date", "6-10-2026 08:00:00 PST", "message",
				"LPD-12345 Fix <something>", "senderBranchName", "LPD-12345",
				"senderBranchSHA", "abc123"));
		context.setVariable(
			"completedDownstreamTables",
			Arrays.asList(
				_createMap(
					"caption", "---- Success: 2", "rowsHTML",
					"<tr><td>downstream-1</td></tr><tr><td>downstream-2</td>" +
						"</tr>")));
		context.setVariable("cssContent", "body { color: red; }");
		context.setVariable(
			"description", "Description with <strong>markup</strong>");
		context.setVariable(
			"downstreamTables", new ArrayList<Map<String, String>>());
		context.setVariable("jsContent", "function f() { return 1 < 2; }");

		context.setVariable(
			"summaryItems",
			Arrays.asList(
				_createMap(
					"linkText", "CI System Status", "url",
					"https://test-1-0.liferay.com/status"),
				_createMap("label", "Build Time: ", "value", "10 minutes"),
				_createMap(
					"label", "Longest Running Downstream Build: ", "linkText",
					"downstream-1", "url",
					"https://test-1-1.liferay.com/job/test-downstream/1/",
					"value", " in: 9 minutes")));
		context.setVariable("topLevelResult", "SUCCESS");
		context.setVariable(
			"topLevelRowsHTML", "<tr><td>top-level-row</td></tr>");

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
			"Missing commit information",
			content.contains(
				"<p>Commit Message: LPD-12345 Fix &lt;something&gt;</p>"));
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
			content.contains("<tr><td>top-level-row</td></tr>"));
		Assert.assertTrue(
			"Missing column header", content.contains("<th>Test Report</th>"));
		Assert.assertTrue(
			"Missing completed downstream table caption",
			content.contains("<caption>---- Success: 2</caption>"));
		Assert.assertTrue(
			"Missing completed downstream table rows",
			content.contains(
				"<tr><td>downstream-1</td></tr><tr><td>downstream-2</td>" +
					"</tr>"));
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