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

import com.liferay.jenkins.results.parser.util.TestPropsUtil;
import com.liferay.jenkins.results.parser.util.TestPropsValues;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

/**
 * @author Michael Hashimoto
 */
public class LocalGitRepositoryTest extends TestPropsValues {

	@BeforeClass
	public static void setupClass() {
		TestPropsUtil.printProperties();

		Properties repositoryProperties = new Properties();

		repositoryProperties.put(
			JenkinsResultsParserUtil.combine(
				"repository.dir[", REPOSITORY_NAME, "][",
				REPOSITORY_UPSTREAM_BRANCH_NAME, "]"),
			REPOSITORY_DIR);

		BaseGitRepository.setRepositoryProperties(repositoryProperties);
	}

	@Test
	public void testLocalGitRepository() {
		LocalGitRepository localGitRepository = _getLocalGitRepository();

		localGitRepository.getGitWorkingDirectory();

		System.out.println(localGitRepository);
		System.out.println(localGitRepository.getDirectory());
		System.out.println(localGitRepository.getGitWorkingDirectory());
		System.out.println(localGitRepository.getUpstreamBranchName());
	}

	@Test
	public void testLocalGitRepository2() {
		LocalGitRepository localGitRepository = _getLocalGitRepository();

		localGitRepository.getGitWorkingDirectory();

		System.out.println(localGitRepository);
		System.out.println(localGitRepository.getDirectory());
		System.out.println(localGitRepository.getGitWorkingDirectory());
		System.out.println(localGitRepository.getUpstreamBranchName());
	}

	@Test
	public void testLocalGitRepository3() {
		LocalGitRepository localGitRepository = _getLocalGitRepository();

		localGitRepository.getGitWorkingDirectory();

		System.out.println(localGitRepository);
		System.out.println(localGitRepository.getDirectory());
		System.out.println(localGitRepository.getGitWorkingDirectory());
		System.out.println(localGitRepository.getUpstreamBranchName());
	}

	private LocalGitRepository _getLocalGitRepository() {
		return GitRepositoryFactory.getLocalGitRepository(
			REPOSITORY_NAME, REPOSITORY_UPSTREAM_BRANCH_NAME);
	}

}