/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.file;

import java.util.List;

/**
 * A test that a JS unit test file declares with <code>it</code> or
 * <code>test</code>, within zero or more <code>describe</code> groups.
 *
 * @author Michael Hashimoto
 */
public class JSUnitTestClassFileMethod extends BaseTestClassFileMethod {

	/**
	 * Returns the names of the enclosing <code>describe</code> groups.
	 */
	public List<String> getDescribes() {
		return getParentNames();
	}

	protected JSUnitTestClassFileMethod(
		List<String> describes, boolean dynamic, String shortName,
		TestClassFile testClassFile) {

		super(dynamic, describes, shortName, testClassFile);
	}

}