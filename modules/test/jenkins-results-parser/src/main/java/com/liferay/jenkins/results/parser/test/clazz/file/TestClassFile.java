/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.file;

import java.io.File;

import java.util.List;

/**
 * A file that declares tests, read so that the names that the test framework
 * reports can be matched back to the file that declares them.
 *
 * @author Michael Hashimoto
 */
public interface TestClassFile {

	public File getFile();

	public String getName();

	public String getRelativePath(File dir);

	public List<TestClassFileMethod> getTestMethods();

}