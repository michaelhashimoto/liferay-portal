/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.file;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A JS unit test file, which declares its tests with <code>describe</code> and
 * <code>it</code>.
 *
 * @author Michael Hashimoto
 */
public class JSUnitTestClassFile extends BaseTestClassFile {

	public JSUnitTestClassFile(File file) throws IOException {
		super(file);

		_parse();
	}

	public List<JSMethod> getJSMethods() {
		return Collections.unmodifiableList(_jsMethods);
	}

	public class JSMethod {

		public JSMethod(
			List<String> describes, String shortName, boolean dynamic) {

			_describes = new ArrayList<>(describes);
			_shortName = shortName;
			_dynamic = dynamic;
		}

		public List<String> getDescribes() {
			return Collections.unmodifiableList(_describes);
		}

		/**
		 * Returns the name that the test framework reports, which joins the
		 * enclosing <code>describe</code> names and the name of the test with
		 * <code>" > "</code>.
		 */
		public String getFullName() {
			return getFullName(_NAME_SEPARATOR);
		}

		/**
		 * Returns the name that the test framework reports, joined with
		 * <code>separator</code>. Jest joins the names with a space and Vitest
		 * joins them with <code>" > "</code>, so the caller passes the
		 * separator of the test framework that reported the name.
		 *
		 * <p>
		 * The names are joined rather than replaced within a joined name,
		 * because the name of a test can itself contain a separator.
		 * </p>
		 */
		public String getFullName(String separator) {
			StringBuilder sb = new StringBuilder();

			for (String describe : _describes) {
				sb.append(describe);
				sb.append(separator);
			}

			sb.append(_shortName);

			return sb.toString();
		}

		public String getShortName() {
			return _shortName;
		}

		public TestClassFile getTestClassFile() {
			return JSUnitTestClassFile.this;
		}

		/**
		 * Returns <code>true</code> if the name is not known until the test
		 * runs, because the name is a template literal or because a
		 * placeholder formats the value of an <code>each</code> table.
		 */
		public boolean isDynamic() {
			return _dynamic;
		}

		/**
		 * Returns <code>true</code> if <code>name</code> is the name that the
		 * test framework reported for this test.
		 */
		public boolean matches(String name) {
			if (name == null) {
				return false;
			}

			if (Objects.equals(name, getFullName()) ||
				Objects.equals(name, getFullName(" "))) {

				return true;
			}

			return false;
		}

		/**
		 * Returns <code>true</code> if <code>name</code> could be the name that
		 * the test framework reported for this test, with each placeholder of
		 * the name matching anything. A test whose name is not known until the
		 * test runs can only be matched this way, so the caller matches
		 * exactly first and falls back to this.
		 */
		public boolean matchesPattern(String name) {
			if (name == null) {
				return false;
			}

			for (String separator : _SEPARATORS) {
				Pattern pattern = _getPattern(getFullName(separator));

				Matcher matcher = pattern.matcher(name);

				if (matcher.matches()) {
					return true;
				}
			}

			return false;
		}

		@Override
		public String toString() {
			return getFullName();
		}

		private Pattern _getPattern(String name) {
			Pattern pattern = _patterns.get(name);

			if (pattern != null) {
				return pattern;
			}

			Matcher matcher = _placeholderPattern.matcher(name);

			StringBuilder sb = new StringBuilder();

			int index = 0;

			while (matcher.find()) {
				sb.append(
					Pattern.quote(name.substring(index, matcher.start())));
				sb.append(".*");

				index = matcher.end();
			}

			sb.append(Pattern.quote(name.substring(index)));

			pattern = Pattern.compile(sb.toString(), Pattern.DOTALL);

			_patterns.put(name, pattern);

			return pattern;
		}

		private final List<String> _describes;
		private final boolean _dynamic;
		private final Map<String, Pattern> _patterns = new HashMap<>();
		private final String _shortName;

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

	/**
	 * Returns the name of the test with the placeholders replaced by the values
	 * of a row of an <code>each</code> table.
	 */
	private String _expandTitle(String title, List<String> row, int rowIndex) {
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
	 * Returns the bindings of the parameters of the callback of an
	 * <code>each</code> to the values of a row, so that a name that
	 * interpolates a parameter can be resolved.
	 */
	private Map<String, String> _getBindings(
		Map<String, String> bindings, List<String> parameters,
		List<String> row) {

		Map<String, String> rowBindings = new HashMap<>(bindings);

		for (int i = 0; i < parameters.size(); i++) {
			if (i >= row.size()) {
				break;
			}

			rowBindings.put(parameters.get(i), row.get(i));
		}

		return rowBindings;
	}

	/**
	 * Returns the index of the brace that opens the body of the callback that
	 * follows <code>index</code>, or <code>-1</code> if the callback has no
	 * body.
	 */
	private int _getBodyIndex(String content, int index) {
		int length = content.length();

		while (index < length) {
			char c = content.charAt(index);

			if (c == '{') {
				return index;
			}

			if (c == ';') {
				return -1;
			}

			if (c == '(') {

				// The parameters of the callback precede the body

				index = _skipBalanced(content, index);

				continue;
			}

			if ((c == '\'') || (c == '\"') || (c == '`')) {
				index = _skipString(content, index);

				continue;
			}

			index++;
		}

		return -1;
	}

	/**
	 * Returns a row of values for each test that an <code>each</code> table
	 * declares, or <code>null</code> if the call is not an <code>each</code> or
	 * the table is not a list of literals.
	 */
	private List<List<String>> _getEachRows(String content, int index) {
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
	 * Returns the names of the parameters of the callback that follows
	 * <code>index</code>.
	 */
	private List<String> _getParameters(String content, int index) {
		List<String> parameters = new ArrayList<>();

		int bodyIndex = _getBodyIndex(content, index);

		if (bodyIndex == -1) {
			return parameters;
		}

		int parametersIndex = content.lastIndexOf('(', bodyIndex);

		if (parametersIndex < index) {

			// The callback declares a single parameter without parentheses

			int endIndex = content.lastIndexOf("=>", bodyIndex);

			if (endIndex < index) {
				return parameters;
			}

			String parameter = content.substring(index, endIndex);

			parameter = parameter.trim();

			if (parameter.startsWith(",")) {
				parameter = parameter.substring(1);

				parameter = parameter.trim();
			}

			if (!parameter.isEmpty()) {
				parameters.add(parameter);
			}

			return parameters;
		}

		int endIndex = content.indexOf(')', parametersIndex);

		if (endIndex == -1) {
			return parameters;
		}

		for (String parameter :
				content.substring(
					parametersIndex + 1, endIndex
				).split(
					","
				)) {

			parameter = parameter.trim();

			if (!parameter.isEmpty()) {
				parameters.add(parameter);
			}
		}

		return parameters;
	}

	/**
	 * Returns a key that changes when the file changes, so that a file that is
	 * written again is read again.
	 */
	private Title _getTitle(
		String content, int index, Map<String, String> bindings) {

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

			if (content.charAt(index) == '`') {
				literal = _resolve(literal, bindings);

				if (literal.contains("${")) {
					dynamic = true;
				}
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
	private int _getTitleIndex(String content, int index) {
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
	private Title _getValue(String content, int index) {
		int length = content.length();

		char c = content.charAt(index);

		if ((c == '\'') || (c == '\"') || (c == '`')) {
			int endIndex = _skipString(content, index);

			Title stringValue = new Title();

			stringValue.index = endIndex;
			stringValue.value = _unescape(
				content.substring(index + 1, endIndex - 1));

			return stringValue;
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

		Title value = new Title();

		value.index = endIndex;
		value.value = content.substring(index, endIndex);

		return value;
	}

	private boolean _isEach(String content, int index) {
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

	private boolean _isUncertainTitle(String title) {
		for (String placeholder : _UNCERTAIN_PLACEHOLDERS) {
			if (title.contains(placeholder)) {
				return true;
			}
		}

		return false;
	}

	private List<String> _merge(List<String> first, List<String> second) {
		List<String> merged = new ArrayList<>(first);

		merged.addAll(second);

		return merged;
	}

	private void _parse() {
		_parse(
			getContent(), new ArrayList<String>(),
			new HashMap<String, String>());
	}

	private void _parse(
		String content, List<String> parentDescribeNames,
		Map<String, String> bindings) {

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

			Title title = _getTitle(content, titleIndex, bindings);

			if (title == null) {
				index = wordEndIndex;

				continue;
			}

			boolean dynamic = false;

			if (title.dynamic || _isEach(content, wordEndIndex)) {
				dynamic = true;
			}

			if (word.equals("describe")) {
				List<List<String>> describeRows = _getEachRows(
					content, wordEndIndex);

				if ((describeRows != null) && !describeRows.isEmpty() &&
					!title.dynamic) {

					int bodyIndex = _getBodyIndex(content, title.index);

					if (bodyIndex != -1) {
						List<String> parameters = _getParameters(
							content, title.index);

						int bodyEndIndex = _skipBlock(content, bodyIndex);

						String body = content.substring(
							bodyIndex + 1, bodyEndIndex - 1);

						List<String> describes = _merge(
							parentDescribeNames, describeNames);

						for (int i = 0; i < describeRows.size(); i++) {
							List<String> row = describeRows.get(i);

							List<String> rowDescribes = new ArrayList<>(
								describes);

							rowDescribes.add(_expandTitle(title.value, row, i));

							_parse(
								body, rowDescribes,
								_getBindings(bindings, parameters, row));
						}

						index = bodyEndIndex;

						continue;
					}
				}

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
					_jsMethods.add(
						new JSMethod(
							_merge(parentDescribeNames, describeNames),
							title.value, dynamic || describeDynamic));
				}
				else {

					// The names of the tests of an "each" table are known,
					// unless a placeholder formats the value

					boolean uncertain = _isUncertainTitle(title.value);

					for (int i = 0; i < rows.size(); i++) {
						_jsMethods.add(
							new JSMethod(
								_merge(parentDescribeNames, describeNames),
								_expandTitle(title.value, rows.get(i), i),
								describeDynamic || uncertain));
					}
				}
			}

			index = title.index;
		}
	}

	/**
	 * Returns <code>literal</code> with the interpolations of the bound
	 * parameters replaced by their values.
	 */
	private String _resolve(String literal, Map<String, String> bindings) {
		if (bindings.isEmpty() || !literal.contains("${")) {
			return literal;
		}

		for (Map.Entry<String, String> entry : bindings.entrySet()) {
			literal = literal.replace(
				"${" + entry.getKey() + "}", entry.getValue());
		}

		return literal;
	}

	/**
	 * Returns the index after the group that closes the group opened at
	 * <code>index</code>.
	 */
	private int _skipBalanced(String content, int index) {
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

	/**
	 * Returns the index after the brace that closes the block opened at
	 * <code>index</code>.
	 */
	private int _skipBlock(String content, int index) {
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

	private int _skipComment(String content, int index) {
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

	private int _skipWhitespaceAndComments(String content, int index) {
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

	private String _unescape(String literal) {
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

	private static final String _NAME_SEPARATOR = " > ";

	private static final String _PLACEHOLDERS = "difjops";

	private static final String[] _SEPARATORS = {" > ", " "};

	private static final String[] _UNCERTAIN_PLACEHOLDERS = {"%j", "%o", "%p"};

	private static final Pattern _placeholderPattern = Pattern.compile(
		"\\$\\{[^}]*\\}|%[#dfijops]");

	private final List<JSMethod> _jsMethods = new ArrayList<>();

	private static class Title {

		public boolean dynamic;
		public int index;
		public String value;

	}

}