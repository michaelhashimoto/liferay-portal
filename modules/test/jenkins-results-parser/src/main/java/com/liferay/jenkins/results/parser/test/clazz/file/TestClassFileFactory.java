/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.file;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Michael Hashimoto
 */
public class TestClassFileFactory {

	public static void clear() {
		_testClassFiles.clear();
	}

	/**
	 * Returns the test class file for <code>file</code>, or <code>null</code>
	 * if the file is not a kind of test file that is supported.
	 */
	public static TestClassFile newTestClassFile(File file) throws IOException {
		if ((file == null) || !file.isFile() || !_isJSUnitTestClassFile(file)) {
			return null;
		}

		File canonicalFile = JenkinsResultsParserUtil.getCanonicalFile(file);

		TestClassFile testClassFile = _testClassFiles.get(canonicalFile);

		if (testClassFile != null) {
			return testClassFile;
		}

		testClassFile = new JSUnitTestClassFile(canonicalFile);

		_testClassFiles.put(canonicalFile, testClassFile);

		return _testClassFiles.get(canonicalFile);
	}

	public static TestClassFileMethod newTestClassFileMethod(
		boolean dynamic, List<String> parentNames, String shortName,
		TestClassFile testClassFile) {

		if (testClassFile instanceof JSUnitTestClassFile) {
			return new JSUnitTestClassFileMethod(
				parentNames, dynamic, shortName, testClassFile);
		}

		return null;
	}

	private static boolean _isJSUnitTestClassFile(File file) {
		String name = file.getName();

		for (String extension : _JS_UNIT_EXTENSIONS) {
			if (name.endsWith(extension)) {
				return true;
			}
		}

		return false;
	}

	private static final String[] _JS_UNIT_EXTENSIONS = {
		".js", ".jsx", ".ts", ".tsx"
	};

	private static final Map<File, TestClassFile> _testClassFiles =
		new ConcurrentHashMap<>();

}