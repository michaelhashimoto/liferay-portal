/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Chen Tsai
 */
public class JUnitBatchTestClassGroup extends BatchTestClassGroup {

	protected JUnitBatchTestClassGroup(
		String batchName, GitWorkingDirectory gitWorkingDirectory,
		String testSuiteName) {

		super(batchName, gitWorkingDirectory, testSuiteName);
	}

	@Override
	protected List<String> getRelevantTestClassNamesRelativeGlobs(
		List<String> testClassNamesRelativeGlobs) {

		List<String> relevantTestClassNameRelativeGlobs = new ArrayList<>();

		PortalGitWorkingDirectory portalGitWorkingDirectory =
			(PortalGitWorkingDirectory)gitWorkingDirectory;

		List<File> moduleGroupDirs = null;

		File workingDirectory = gitWorkingDirectory.getWorkingDirectory();

		try {
			moduleGroupDirs = portalGitWorkingDirectory.getModuleGroupDirs();
		}
		catch (IOException ioe) {
			throw new RuntimeException(
				JenkinsResultsParserUtil.combine(
					"Unable to get module group directories in ",
					workingDirectory.getPath()),
				ioe);
		}

		List<File> currentBranchFiles =
			gitWorkingDirectory.getCurrentBranchFiles();

		for (File moduleGroupDir : moduleGroupDirs) {
			String modulesGroupRelativePath = moduleGroupDir.getPath();

			for (File currentBranchFile : currentBranchFiles) {
				String currentBranchFilePath = null;

				try {
					currentBranchFilePath =
						currentBranchFile.getCanonicalPath();
				}
				catch (IOException ioe) {
					throw new RuntimeException(
						JenkinsResultsParserUtil.combine(
							"Unable to get canonical path for file  ",
							currentBranchFile.getName()),
						ioe);
				}

				if ((currentBranchFilePath != null) &&
					!currentBranchFilePath.startsWith(
						modulesGroupRelativePath)) {

					relevantTestClassNameRelativeGlobs.addAll(
						testClassNamesRelativeGlobs);

					return relevantTestClassNameRelativeGlobs;
				}
			}
		}

		return relevantTestClassNameRelativeGlobs;
	}

}