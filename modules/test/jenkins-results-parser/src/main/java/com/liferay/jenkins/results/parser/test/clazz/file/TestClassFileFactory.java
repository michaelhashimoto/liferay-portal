/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.file;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import java.io.File;
import java.io.IOException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Michael Hashimoto
 */
public class TestClassFileFactory {

	public static void clear() {
		_jsUnitTestClassFiles.clear();
	}

	public static JSUnitTestClassFile newJSUnitTestClassFile(File file)
		throws IOException {

		File canonicalFile = JenkinsResultsParserUtil.getCanonicalFile(file);

		JSUnitTestClassFile jsUnitTestClassFile = _jsUnitTestClassFiles.get(
			canonicalFile);

		if (jsUnitTestClassFile != null) {
			return jsUnitTestClassFile;
		}

		jsUnitTestClassFile = new JSUnitTestClassFile(canonicalFile);

		_jsUnitTestClassFiles.put(canonicalFile, jsUnitTestClassFile);

		return _jsUnitTestClassFiles.get(canonicalFile);
	}

	/**
	 * Returns the test class file for <code>file</code>, or <code>null</code>
	 * if the file is not a kind of test file that is supported.
	 */
	public static TestClassFile newTestClassFile(File file) throws IOException {
		if ((file == null) || !file.isFile()) {
			return null;
		}

		if (_isJSUnitTestClassFile(file)) {
			return newJSUnitTestClassFile(file);
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

	private static final Map<File, JSUnitTestClassFile> _jsUnitTestClassFiles =
		new ConcurrentHashMap<>();

}