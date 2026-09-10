/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Reads the names of the tests that a JS unit test file declares, so that the
 * names that the test framework reports can be matched back to the file that
 * declares them.
 *
 * @author Michael Hashimoto
 */
public class JSUnitTestNameUtil {

	public static void clearJSUnitTestNames() {
		_jsUnitTestNamesMap.clear();
	}

	public static List<JSUnitTestName> getJSUnitTestNames(File file)
		throws IOException {

		String key = _getKey(file);

		List<JSUnitTestName> jsUnitTestNames = _jsUnitTestNamesMap.get(key);

		if (jsUnitTestNames != null) {
			return jsUnitTestNames;
		}

		jsUnitTestNames = Collections.unmodifiableList(
			getJSUnitTestNames(JenkinsResultsParserUtil.read(file)));

		_jsUnitTestNamesMap.put(key, jsUnitTestNames);

		return jsUnitTestNames;
	}

	public static List<JSUnitTestName> getJSUnitTestNames(String content) {
		List<JSUnitTestName> jsUnitTestNames = new ArrayList<>();

		List<String> describeNames = new ArrayList<>();
		List<Integer> describeDepths = new ArrayList<>();
		List<Boolean> describeDynamics = new ArrayList<>();

		int depth = 0;
		int index = 0;
		int length = content.length();

		String pendingDescribeName = null;
		boolean pendingDescribeDynamic = false;

		while (index < length) {
			char c = content.charAt(index);

			if ((c == '/') && ((index + 1) < length)) {
				char nextChar = content.charAt(index + 1);

				if ((nextChar == '/') || (nextChar == '*')) {
					index = _skipComment(content, index);

					continue;
				}
			}

			if ((c == '\'') || (c == '\"') || (c == '`')) {
				index = _skipString(content, index);

				continue;
			}

			if (c == '{') {
				depth++;

				if (pendingDescribeName != null) {
					describeNames.add(pendingDescribeName);
					describeDepths.add(depth);
					describeDynamics.add(pendingDescribeDynamic);

					pendingDescribeName = null;
					pendingDescribeDynamic = false;
				}

				index++;

				continue;
			}

			if (c == '}') {
				depth--;

				while (!describeDepths.isEmpty()) {
					int lastIndex = describeDepths.size() - 1;

					if (describeDepths.get(lastIndex) <= depth) {
						break;
					}

					describeDepths.remove(lastIndex);
					describeDynamics.remove(lastIndex);
					describeNames.remove(lastIndex);
				}

				index++;

				continue;
			}

			if (!Character.isJavaIdentifierStart(c)) {
				index++;

				continue;
			}

			int wordEndIndex = index;

			while ((wordEndIndex < length) &&
				   Character.isJavaIdentifierPart(
					   content.charAt(wordEndIndex))) {

				wordEndIndex++;
			}

			String word = content.substring(index, wordEndIndex);

			if (((index > 0) && (content.charAt(index - 1) == '.')) ||
				(!word.equals("describe") && !word.equals("it") &&
				 !word.equals("test"))) {

				index = wordEndIndex;

				continue;
			}

			int titleIndex = _getTitleIndex(content, wordEndIndex);

			if (titleIndex == -1) {
				index = wordEndIndex;

				continue;
			}

			Title title = _getTitle(content, titleIndex);

			if (title == null) {
				index = wordEndIndex;

				continue;
			}

			boolean dynamic = false;

			if (title.dynamic || _isEach(content, wordEndIndex)) {
				dynamic = true;
			}

			if (word.equals("describe")) {
				pendingDescribeDynamic = dynamic;
				pendingDescribeName = title.value;
			}
			else {
				boolean describeDynamic = false;

				for (Boolean describeDynamicValue : describeDynamics) {
					if (describeDynamicValue) {
						describeDynamic = true;

						break;
					}
				}

				List<List<String>> rows = _getEachRows(content, wordEndIndex);

				if ((rows == null) || rows.isEmpty() || title.dynamic) {
					jsUnitTestNames.add(
						new JSUnitTestName(
							describeNames, title.value,
							dynamic || describeDynamic));
				}
				else {

					// The names of the tests of an "each" table are known,
					// unless a placeholder formats the value

					boolean uncertain = _isUncertainTitle(title.value);

					for (int i = 0; i < rows.size(); i++) {
						jsUnitTestNames.add(
							new JSUnitTestName(
								describeNames,
								_expandTitle(title.value, rows.get(i), i),
								describeDynamic || uncertain));
					}
				}
			}

			index = title.index;
		}

		return jsUnitTestNames;
	}

	/**
	 * Returns the name of the test with the placeholders replaced by the values
	 * of a row of an <code>each</code> table.
	 */
	private static String _expandTitle(
		String title, List<String> row, int rowIndex) {

		StringBuilder sb = new StringBuilder();

		int argIndex = 0;
		int length = title.length();

		for (int i = 0; i < length; i++) {
			char c = title.charAt(i);

			if ((c != '%') || ((i + 1) >= length)) {
				sb.append(c);

				continue;
			}

			char nextChar = title.charAt(i + 1);

			if (nextChar == '%') {
				sb.append('%');

				i++;

				continue;
			}

			if (nextChar == '#') {
				sb.append(rowIndex);

				i++;

				continue;
			}

			if (_PLACEHOLDERS.indexOf(nextChar) == -1) {
				sb.append(c);

				continue;
			}

			if (argIndex < row.size()) {
				sb.append(row.get(argIndex));

				argIndex++;
			}
			else {
				sb.append(c);
				sb.append(nextChar);
			}

			i++;
		}

		return sb.toString();
	}

	/**
	 * Returns a row of values for each test that an <code>each</code> table
	 * declares, or <code>null</code> if the call is not an <code>each</code> or
	 * the table is not a list of literals.
	 */
	private static List<List<String>> _getEachRows(String content, int index) {
		if (!_isEach(content, index)) {
			return null;
		}

		int length = content.length();

		while ((index < length) && (content.charAt(index) == '.')) {
			index++;

			while ((index < length) &&
				   Character.isJavaIdentifierPart(content.charAt(index))) {

				index++;
			}
		}

		index = _skipWhitespaceAndComments(content, index);

		if ((index >= length) || (content.charAt(index) != '(')) {
			return null;
		}

		index = _skipWhitespaceAndComments(content, index + 1);

		if ((index >= length) || (content.charAt(index) != '[')) {
			return null;
		}

		List<List<String>> rows = new ArrayList<>();

		index = _skipWhitespaceAndComments(content, index + 1);

		while (index < length) {
			char c = content.charAt(index);

			if (c == ']') {
				return rows;
			}

			if (c == ',') {
				index = _skipWhitespaceAndComments(content, index + 1);

				continue;
			}

			List<String> row = new ArrayList<>();

			if (c == '[') {
				index = _skipWhitespaceAndComments(content, index + 1);

				while (index < length) {
					c = content.charAt(index);

					if (c == ']') {
						index = _skipWhitespaceAndComments(content, index + 1);

						break;
					}

					if (c == ',') {
						index = _skipWhitespaceAndComments(content, index + 1);

						continue;
					}

					Title value = _getValue(content, index);

					if (value == null) {
						return null;
					}

					row.add(value.value);

					index = _skipWhitespaceAndComments(content, value.index);
				}
			}
			else {
				Title value = _getValue(content, index);

				if (value == null) {
					return null;
				}

				row.add(value.value);

				index = _skipWhitespaceAndComments(content, value.index);
			}

			rows.add(row);
		}

		return null;
	}

	/**
	 * Returns a key that changes when the file changes, so that a file that is
	 * written again is read again.
	 */
	private static String _getKey(File file) {
		return JenkinsResultsParserUtil.combine(
			JenkinsResultsParserUtil.getCanonicalPath(file), "_",
			String.valueOf(file.lastModified()), "_",
			String.valueOf(file.length()));
	}

	private static Title _getTitle(String content, int index) {
		int length = content.length();

		index = _skipWhitespaceAndComments(content, index);

		if (index >= length) {
			return null;
		}

		char c = content.charAt(index);

		if ((c != '\'') && (c != '\"') && (c != '`')) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		boolean dynamic = false;

		while (true) {
			int endIndex = _skipString(content, index);

			String literal = content.substring(index + 1, endIndex - 1);

			if ((content.charAt(index) == '`') && literal.contains("${")) {
				dynamic = true;
			}

			sb.append(_unescape(literal));

			index = _skipWhitespaceAndComments(content, endIndex);

			if ((index >= length) || (content.charAt(index) != '+')) {
				break;
			}

			index = _skipWhitespaceAndComments(content, index + 1);

			if (index >= length) {
				break;
			}

			c = content.charAt(index);

			if ((c != '\'') && (c != '\"') && (c != '`')) {
				break;
			}
		}

		Title title = new Title();

		title.dynamic = dynamic;
		title.index = index;
		title.value = sb.toString();

		return title;
	}

	/**
	 * Returns the index of the argument that holds the name of the test, or
	 * <code>-1</code> if the word is not a call that declares a test.
	 */
	private static int _getTitleIndex(String content, int index) {
		int length = content.length();

		boolean each = false;

		while ((index < length) && (content.charAt(index) == '.')) {
			int endIndex = index + 1;

			while ((endIndex < length) &&
				   Character.isJavaIdentifierPart(content.charAt(endIndex))) {

				endIndex++;
			}

			if (content.startsWith("each", index + 1)) {
				each = true;
			}

			index = endIndex;
		}

		index = _skipWhitespaceAndComments(content, index);

		if (index >= length) {
			return -1;
		}

		if (each) {

			// The table of an "each" precedes the name of the test

			char c = content.charAt(index);

			if (c == '`') {
				index = _skipString(content, index);
			}
			else if (c == '(') {
				index = _skipBalanced(content, index);
			}
			else {
				return -1;
			}

			index = _skipWhitespaceAndComments(content, index);
		}

		if ((index >= length) || (content.charAt(index) != '(')) {
			return -1;
		}

		return index + 1;
	}

	/**
	 * Returns the value of the literal at <code>index</code>, or
	 * <code>null</code> if there is no literal there.
	 */
	private static Title _getValue(String content, int index) {
		int length = content.length();

		char c = content.charAt(index);

		Title value = new Title();

		if ((c == '\'') || (c == '\"') || (c == '`')) {
			int endIndex = _skipString(content, index);

			value.index = endIndex;
			value.value = _unescape(content.substring(index + 1, endIndex - 1));

			return value;
		}

		int endIndex = index;

		while ((endIndex < length) &&
			   ((content.charAt(endIndex) == '.') ||
				(content.charAt(endIndex) == '-') ||
				Character.isLetterOrDigit(content.charAt(endIndex)))) {

			endIndex++;
		}

		if (endIndex == index) {
			return null;
		}

		value.index = endIndex;
		value.value = content.substring(index, endIndex);

		return value;
	}

	private static boolean _isEach(String content, int index) {
		int length = content.length();

		while ((index < length) && (content.charAt(index) == '.')) {
			int endIndex = index + 1;

			while ((endIndex < length) &&
				   Character.isJavaIdentifierPart(content.charAt(endIndex))) {

				endIndex++;
			}

			if (Objects.equals(
					content.substring(index + 1, endIndex), "each")) {

				return true;
			}

			index = endIndex;
		}

		return false;
	}

	private static boolean _isUncertainTitle(String title) {
		for (String placeholder : _UNCERTAIN_PLACEHOLDERS) {
			if (title.contains(placeholder)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns the index after the group that closes the group opened at
	 * <code>index</code>.
	 */
	private static int _skipBalanced(String content, int index) {
		int depth = 0;
		int length = content.length();

		while (index < length) {
			char c = content.charAt(index);

			if ((c == '/') && ((index + 1) < length)) {
				char nextChar = content.charAt(index + 1);

				if ((nextChar == '/') || (nextChar == '*')) {
					index = _skipComment(content, index);

					continue;
				}
			}

			if ((c == '\'') || (c == '\"') || (c == '`')) {
				index = _skipString(content, index);

				continue;
			}

			if (c == '(') {
				depth++;
			}
			else if (c == ')') {
				depth--;

				if (depth == 0) {
					return index + 1;
				}
			}

			index++;
		}

		return index;
	}

	private static int _skipComment(String content, int index) {
		int length = content.length();

		if (content.startsWith("//", index)) {
			while ((index < length) && (content.charAt(index) != '\n')) {
				index++;
			}

			return index;
		}

		index = index + 2;

		while (index < length) {
			if (content.startsWith("*/", index)) {
				return index + 2;
			}

			index++;
		}

		return index;
	}

	/**
	 * Returns the index after the string that starts at <code>index</code>.
	 */
	private static int _skipString(String content, int index) {
		char quote = content.charAt(index);

		int length = content.length();

		index++;

		while (index < length) {
			char c = content.charAt(index);

			if (c == '\\') {
				index = index + 2;

				continue;
			}

			if (c == quote) {
				return index + 1;
			}

			if ((quote == '`') && content.startsWith("${", index)) {
				index = _skipTemplateExpression(content, index + 2);

				continue;
			}

			index++;
		}

		return index;
	}

	private static int _skipTemplateExpression(String content, int index) {
		int depth = 1;
		int length = content.length();

		while (index < length) {
			char c = content.charAt(index);

			if ((c == '\'') || (c == '\"') || (c == '`')) {
				index = _skipString(content, index);

				continue;
			}

			if (c == '{') {
				depth++;
			}
			else if (c == '}') {
				depth--;

				if (depth == 0) {
					return index + 1;
				}
			}

			index++;
		}

		return index;
	}

	private static int _skipWhitespaceAndComments(String content, int index) {
		int length = content.length();

		while (index < length) {
			char c = content.charAt(index);

			if (Character.isWhitespace(c)) {
				index++;

				continue;
			}

			if ((c == '/') && ((index + 1) < length)) {
				char nextChar = content.charAt(index + 1);

				if ((nextChar == '/') || (nextChar == '*')) {
					index = _skipComment(content, index);

					continue;
				}
			}

			break;
		}

		return index;
	}

	private static String _unescape(String literal) {
		StringBuilder sb = new StringBuilder();

		int length = literal.length();

		for (int i = 0; i < length; i++) {
			char c = literal.charAt(i);

			if ((c != '\\') || ((i + 1) >= length)) {
				sb.append(c);

				continue;
			}

			i++;

			char escapedChar = literal.charAt(i);

			if (escapedChar == 'n') {
				sb.append('\n');
			}
			else if (escapedChar == 't') {
				sb.append('\t');
			}
			else {
				sb.append(escapedChar);
			}
		}

		return sb.toString();
	}

	private static final String _PLACEHOLDERS = "difjops";

	private static final String[] _UNCERTAIN_PLACEHOLDERS = {"%j", "%o", "%p"};

	private static final Map<String, List<JSUnitTestName>> _jsUnitTestNamesMap =
		new ConcurrentHashMap<>();

	private static class Title {

		public boolean dynamic;
		public int index;
		public String value;

	}

}