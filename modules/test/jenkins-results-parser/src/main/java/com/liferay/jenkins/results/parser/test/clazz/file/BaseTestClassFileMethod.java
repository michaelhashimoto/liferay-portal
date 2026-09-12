/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseTestClassFileMethod implements TestClassFileMethod {

	/**
	 * Returns the name that the test framework reports, which joins the names
	 * of the enclosing groups and the name of the test.
	 */
	@Override
	public String getFullName() {
		return getFullName(getNameSeparator());
	}

	/**
	 * Returns the name that the test framework reports, joined with
	 * <code>separator</code>. Jest joins the names with a space and Vitest
	 * joins them with <code>" > "</code>, so the caller passes the separator of
	 * the test framework that reported the name.
	 *
	 * <p>
	 * The names are joined rather than replaced within a joined name, because
	 * the name of a test can itself contain a separator.
	 * </p>
	 */
	@Override
	public String getFullName(String separator) {
		StringBuilder sb = new StringBuilder();

		for (String parentName : _parentNames) {
			sb.append(parentName);
			sb.append(separator);
		}

		sb.append(_shortName);

		return sb.toString();
	}

	@Override
	public List<String> getParentNames() {
		return Collections.unmodifiableList(_parentNames);
	}

	@Override
	public String getShortName() {
		return _shortName;
	}

	@Override
	public TestClassFile getTestClassFile() {
		return _testClassFile;
	}

	/**
	 * Returns <code>true</code> if the name is not known until the test runs,
	 * because the name interpolates a value or because a placeholder formats
	 * the value of a table.
	 */
	@Override
	public boolean isDynamic() {
		return _dynamic;
	}

	/**
	 * Returns <code>true</code> if <code>name</code> is the name that the test
	 * framework reported for this test.
	 */
	@Override
	public boolean matches(String name) {
		if (name == null) {
			return false;
		}

		for (String separator : getSeparators()) {
			if (Objects.equals(name, getFullName(separator))) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns <code>true</code> if <code>name</code> could be the name that the
	 * test framework reported for this test, with each placeholder of the name
	 * matching anything. A test whose name is not known until the test runs can
	 * only be matched this way, so the caller matches exactly first and falls
	 * back to this.
	 */
	@Override
	public boolean matchesPattern(String name) {
		if (name == null) {
			return false;
		}

		for (String separator : getSeparators()) {
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

	protected BaseTestClassFileMethod(
		boolean dynamic, List<String> parentNames, String shortName,
		TestClassFile testClassFile) {

		_dynamic = dynamic;
		_parentNames = new ArrayList<>(parentNames);
		_shortName = shortName;
		_testClassFile = testClassFile;
	}

	protected String getNameSeparator() {
		return _NAME_SEPARATOR;
	}

	/**
	 * Returns the separators that a test framework joins the names with, so
	 * that a name reported by either is matched.
	 */
	protected String[] getSeparators() {
		return _SEPARATORS;
	}

	private Pattern _getPattern(String name) {
		Pattern pattern = _patterns.get(name);

		if (pattern != null) {
			return pattern;
		}

		StringBuilder sb = new StringBuilder();

		int index = 0;

		Matcher matcher = _placeholderPattern.matcher(name);

		while (matcher.find()) {
			sb.append(Pattern.quote(name.substring(index, matcher.start())));
			sb.append(".*");

			index = matcher.end();
		}

		sb.append(Pattern.quote(name.substring(index)));

		pattern = Pattern.compile(sb.toString(), Pattern.DOTALL);

		_patterns.put(name, pattern);

		return pattern;
	}

	private static final String _NAME_SEPARATOR = " > ";

	private static final String[] _SEPARATORS = {" > ", " "};

	/**
	 * Matches what a test framework replaces with a value, which is a template
	 * literal interpolation, a <code>printf</code> placeholder, or the
	 * <code>$</code> syntax that names a property of a row of a table.
	 */
	private static final Pattern _placeholderPattern = Pattern.compile(
		"\\$\\{[^}]*\\}|%[#dfijops]|\\$#|\\$[A-Za-z_][A-Za-z0-9_.]*");

	private final boolean _dynamic;
	private final List<String> _parentNames;
	private final Map<String, Pattern> _patterns = new HashMap<>();
	private final String _shortName;
	private final TestClassFile _testClassFile;

}