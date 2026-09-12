/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The name of a JS unit test, as the enclosing <code>describe</code> names
 * followed by the name of the test.
 *
 * @author Michael Hashimoto
 */
public class JSUnitTestName {

	public JSUnitTestName(
		List<String> describeNames, String testName, boolean dynamic) {

		_describeNames = new ArrayList<>(describeNames);
		_testName = testName;
		_dynamic = dynamic;
	}

	public List<String> getDescribeNames() {
		return Collections.unmodifiableList(_describeNames);
	}

	/**
	 * Returns the name that the test framework reports, which joins the
	 * enclosing <code>describe</code> names and the name of the test with
	 * <code>" > "</code>.
	 */
	public String getName() {
		return getName(_NAME_SEPARATOR);
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
	public String getName(String separator) {
		StringBuilder sb = new StringBuilder();

		for (String describeName : _describeNames) {
			sb.append(describeName);
			sb.append(separator);
		}

		sb.append(_testName);

		return sb.toString();
	}

	public String getTestName() {
		return _testName;
	}

	/**
	 * Returns <code>true</code> if the name is not known until the test runs,
	 * because the name is a template literal or because the test is generated
	 * by <code>each</code>.
	 */
	public boolean isDynamic() {
		return _dynamic;
	}

	@Override
	public String toString() {
		return getName();
	}

	private static final String _NAME_SEPARATOR = " > ";

	private final List<String> _describeNames;
	private final boolean _dynamic;
	private final String _testName;

}