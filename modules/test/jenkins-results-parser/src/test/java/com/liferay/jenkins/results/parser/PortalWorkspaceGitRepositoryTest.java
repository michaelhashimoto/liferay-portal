/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import java.util.Collections;
import java.util.Properties;

import org.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 * @author Kenji Heigel
 */
public class PortalWorkspaceGitRepositoryTest
	extends com.liferay.jenkins.results.parser.Test {

	@Test
	public void testGetPortalTestProperties() throws Exception {
		mockEnvironment(
			Collections.singletonMap(
				"PORTAL_LATEST_BUNDLE_VERSION", "environment.value"));

		Properties buildProperties = new Properties();

		buildProperties.setProperty(
			"portal.bundle.tomcat[environment.value]", "dummy.value");

		JenkinsResultsParserUtil.setBuildProperties(buildProperties);

		PortalWorkspaceGitRepository portalWorkspaceGitRepository =
			_newPortalWorkspaceGitRepository();

		Properties portalTestProperties = new Properties();

		portalTestProperties.setProperty(
			"test.released.release.bundle.version", "property.value");

		Mockito.doReturn(
			portalTestProperties
		).when(
			portalWorkspaceGitRepository
		).getProperties(
			"portal.test.properties"
		);

		portalWorkspaceGitRepository.writePropertiesFiles();

		File directory = portalWorkspaceGitRepository.getDirectory();

		FilenameFilter filenameFilter =
			(dir, name) ->
				name.startsWith("test.") && name.endsWith(".properties");

		Properties testProperties = JenkinsResultsParserUtil.getProperties(
			directory.listFiles(filenameFilter)[0]);

		Assert.assertEquals(
			"environment.value",
			testProperties.getProperty("test.released.release.bundle.version"));
		Assert.assertEquals(
			"dummy.value",
			testProperties.getProperty(
				"test.released.test.portal.bundle.zip.url"));
	}

	@Test
	public void testPrepareGitWorkingDirectoryWithGitArchive()
		throws Exception {

		mockEnvironment(
			Collections.singletonMap("MASTER_NETWORK_NAME", "aws-network"));

		Properties buildProperties = new Properties();

		buildProperties.setProperty("binaries.cache.enabled", "false");
		buildProperties.setProperty(
			"cloud.ci.s3.bucket.dist.path", "s3://liferayci-dist/dist");
		buildProperties.setProperty("git.archive.enabled", "true");

		JenkinsResultsParserUtil.setBuildProperties(buildProperties);

		Shell shell = mockShell();

		Mockito.doReturn(
			new Shell.ExecutionResult(0, "", "")
		).when(
			shell
		).doExecute(
			Mockito.any(Shell.ExecutionRequest.class)
		);

		PortalWorkspaceGitRepository portalWorkspaceGitRepository =
			_newPortalWorkspaceGitRepository();

		portalWorkspaceGitRepository.prepareGitWorkingDirectory();

		Mockito.verify(
			shell, Mockito.atLeastOnce()
		).doExecute(
			Mockito.argThat(
				executionRequest -> hasCommand(
					executionRequest, "git-archives"))
		);

		Assert.assertFalse(
			portalWorkspaceGitRepository.isBinariesCacheEnabled());
	}

	@Test
	public void testPrepareGitWorkingDirectoryWithoutGitArchive()
		throws Exception {

		mockEnvironment(
			Collections.singletonMap("MASTER_NETWORK_NAME", "aws-network"));

		Properties buildProperties = new Properties();

		buildProperties.setProperty("binaries.cache.enabled", "true");
		buildProperties.setProperty(
			"cloud.ci.s3.bucket.dist.path", "s3://liferayci-dist/dist");
		buildProperties.setProperty("git.archive.enabled", "false");

		JenkinsResultsParserUtil.setBuildProperties(buildProperties);

		Shell shell = mockShell();

		PortalWorkspaceGitRepository portalWorkspaceGitRepository =
			_newPortalWorkspaceGitRepository();

		portalWorkspaceGitRepository.prepareGitWorkingDirectory();

		Mockito.verify(
			shell, Mockito.never()
		).doExecute(
			Mockito.argThat(
				executionRequest -> hasCommand(
					executionRequest, "git-archives"))
		);

		Assert.assertTrue(
			portalWorkspaceGitRepository.isBinariesCacheEnabled());
	}

	@Test
	public void testSetUpAdditionalCachesWithBinariesCache() throws Exception {
		mockEnvironment(
			Collections.singletonMap("MASTER_NETWORK_NAME", "aws-network"));

		Properties buildProperties = new Properties();

		buildProperties.setProperty("binaries.cache.enabled", "true");
		buildProperties.setProperty(
			"binaries.cache.s3.path",
			"s3://liferayci-file-propagator/binaries-cache/master.tar.gz");
		buildProperties.setProperty("git.archive.enabled", "false");

		JenkinsResultsParserUtil.setBuildProperties(buildProperties);

		Shell shell = mockShell();

		Mockito.doReturn(
			new Shell.ExecutionResult(0, "", "")
		).when(
			shell
		).doExecute(
			Mockito.any(Shell.ExecutionRequest.class)
		);

		PortalWorkspaceGitRepository portalWorkspaceGitRepository =
			_newPortalWorkspaceGitRepository();

		portalWorkspaceGitRepository.setUpAdditionalCaches();

		Mockito.verify(
			shell
		).doExecute(
			Mockito.argThat(
				executionRequest -> hasCommand(
					executionRequest, "aws s3 cp", "binaries-cache.tar.gz"))
		);

		Mockito.verify(
			shell
		).doExecute(
			Mockito.argThat(
				executionRequest -> hasCommand(
					executionRequest, "tar --directory=",
					"binaries-cache.tar.gz"))
		);
	}

	@Test
	public void testSetUpAdditionalCachesWithoutBinariesCache()
		throws Exception {

		mockEnvironment(
			Collections.singletonMap("MASTER_NETWORK_NAME", "aws-network"));

		Properties buildProperties = new Properties();

		buildProperties.setProperty("binaries.cache.enabled", "false");
		buildProperties.setProperty("git.archive.enabled", "true");

		JenkinsResultsParserUtil.setBuildProperties(buildProperties);

		Shell shell = mockShell();

		PortalWorkspaceGitRepository portalWorkspaceGitRepository =
			_newPortalWorkspaceGitRepository();

		portalWorkspaceGitRepository.setUpAdditionalCaches();

		Mockito.verify(
			shell, Mockito.never()
		).doExecute(
			Mockito.argThat(
				executionRequest -> hasCommand(
					executionRequest, "aws s3 cp", "binaries-cache.tar.gz"))
		);
	}

	@Test
	public void testSetUpFailure() throws Exception {
		mockShell();

		PortalWorkspaceGitRepository portalWorkspaceGitRepository =
			_newPortalWorkspaceGitRepository();

		Mockito.doNothing(
		).when(
			portalWorkspaceGitRepository
		).prepareGitWorkingDirectory();

		IOException ioException = new IOException(
			"The additional caches could not be set up");

		Mockito.doThrow(
			ioException
		).when(
			portalWorkspaceGitRepository
		).setUpAdditionalCaches();

		RuntimeException runtimeException = Assert.assertThrows(
			RuntimeException.class, portalWorkspaceGitRepository::setUp);

		Assert.assertSame(ioException, runtimeException.getCause());

		Assert.assertFalse(portalWorkspaceGitRepository.isSetUp());
	}

	@Test
	public void testSetUpRunsOnce() throws Exception {
		mockEnvironment(
			Collections.singletonMap("MASTER_NETWORK_NAME", "aws-network"));

		Properties buildProperties = new Properties();

		buildProperties.setProperty("git.archive.enabled", "true");

		JenkinsResultsParserUtil.setBuildProperties(buildProperties);

		BuildDatabase buildDatabase = Mockito.mock(BuildDatabase.class);

		BuildDatabaseUtil.setBuildDatabase(buildDatabase);

		mockShell();

		PortalWorkspaceGitRepository portalWorkspaceGitRepository =
			_newPortalWorkspaceGitRepository();

		Mockito.doNothing(
		).when(
			portalWorkspaceGitRepository
		).prepareGitWorkingDirectory();

		Mockito.doNothing(
		).when(
			portalWorkspaceGitRepository
		).setUpAdditionalCaches();

		Assert.assertFalse(portalWorkspaceGitRepository.isSetUp());

		portalWorkspaceGitRepository.setUp();

		Assert.assertTrue(portalWorkspaceGitRepository.isSetUp());

		InOrder inOrder = Mockito.inOrder(
			buildDatabase, portalWorkspaceGitRepository);

		inOrder.verify(
			portalWorkspaceGitRepository
		).prepareGitWorkingDirectory();

		inOrder.verify(
			portalWorkspaceGitRepository
		).setUpAdditionalCaches();

		inOrder.verify(
			buildDatabase
		).putWorkspaceGitRepository(
			Mockito.anyString(), Mockito.any(WorkspaceGitRepository.class)
		);

		portalWorkspaceGitRepository.setUp();

		Mockito.verify(
			portalWorkspaceGitRepository, Mockito.times(1)
		).prepareGitWorkingDirectory();

		Mockito.verify(
			portalWorkspaceGitRepository, Mockito.times(1)
		).setUpAdditionalCaches();

		Mockito.verify(
			buildDatabase, Mockito.times(1)
		).putWorkspaceGitRepository(
			Mockito.anyString(), Mockito.any(WorkspaceGitRepository.class)
		);
	}

	private PortalWorkspaceGitRepository _newPortalWorkspaceGitRepository()
		throws Exception {

		File workingDirectory = File.createTempFile("portal-workspace-", null);

		workingDirectory.delete();

		workingDirectory.mkdir();

		File gitDirectory = new File(workingDirectory, ".git");

		gitDirectory.mkdir();

		JSONObject jsonObject = new JSONObject();

		jsonObject.put(
			"base_branch_head_sha", "1234567890123456789012345678901234567890"
		).put(
			"base_branch_sha", "1234567890123456789012345678901234567890"
		).put(
			"base_branch_username", "liferay"
		).put(
			"directory",
			JenkinsResultsParserUtil.getCanonicalPath(workingDirectory)
		).put(
			"directory_name", "liferay-portal"
		).put(
			"git_hub_url", "https://github.com/liferay/liferay-portal"
		).put(
			"name", "liferay-portal"
		).put(
			"sender_branch_head_sha", "0987654321098765432109876543210987654321"
		).put(
			"sender_branch_name", "master"
		).put(
			"sender_branch_sha", "0987654321098765432109876543210987654321"
		).put(
			"sender_branch_username", "test"
		).put(
			"upstream_branch_name", "master"
		);

		PortalWorkspaceGitRepository portalWorkspaceGitRepository = Mockito.spy(
			new PortalWorkspaceGitRepository(jsonObject));

		GitWorkingDirectory gitWorkingDirectory = Mockito.mock(
			GitWorkingDirectory.class);

		Mockito.doReturn(
			gitWorkingDirectory
		).when(
			portalWorkspaceGitRepository
		).getGitWorkingDirectory();

		LocalGitBranch localGitBranch = Mockito.mock(LocalGitBranch.class);

		Mockito.doReturn(
			"0987654321098765432109876543210987654321"
		).when(
			localGitBranch
		).getSHA();

		Mockito.doReturn(
			localGitBranch
		).when(
			portalWorkspaceGitRepository
		).getLocalGitBranch();

		return portalWorkspaceGitRepository;
	}

}