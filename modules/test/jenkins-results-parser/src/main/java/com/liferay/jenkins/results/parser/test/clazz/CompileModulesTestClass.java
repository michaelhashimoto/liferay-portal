/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.test.clazz.group.BatchTestClassGroup;

import java.io.File;

import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class CompileModulesTestClass extends ModulesTestClass {

	@Override
	public String getName() {
		String path = JenkinsResultsParserUtil.getPathRelativeTo(
			getModuleBaseDir(), getPortalModulesBaseDir());

		return JenkinsResultsParserUtil.combine(
			":", path.replaceAll("/", ":"), ":", getTaskName());
	}

	protected CompileModulesTestClass(
		BatchTestClassGroup batchTestClassGroup, File moduleBaseDir) {

		super(batchTestClassGroup, moduleBaseDir, "assemble");

		addTestClassMethod(getName());
	}

	protected CompileModulesTestClass(
		BatchTestClassGroup batchTestClassGroup, JSONObject jsonObject) {

		super(batchTestClassGroup, jsonObject);
	}

	@Override
	protected List<File> getModulesProjectDirs() {
		return Collections.singletonList(getModuleBaseDir());
	}

}