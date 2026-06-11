/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import com.google.common.collect.Lists;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import org.thymeleaf.context.Context;

/**
 * @author Michael Hashimoto
 */
public class RootCauseAnalysisToolBuild extends DefaultTopLevelBuild {

	@Override
	public String getBaseGitRepositoryName() {
		String branchName = getBranchName();

		if (branchName.equals("master")) {
			return "liferay-portal";
		}

		return "liferay-portal-ee";
	}

	@Override
	public String getBranchName() {
		return getParameterValue("PORTAL_UPSTREAM_BRANCH_NAME");
	}

	public List<GitCommitGroup> getCommitGroups() {
		List<PortalBuildData> portalBuildDataList = Lists.newArrayList(
			_downstreamPortalBuildDataList);

		List<GitCommitGroup> gitCommitGroups = new ArrayList<>(
			_downstreamPortalBuildDataList.size());

		GitCommitGroup gitCommitGroup = null;

		List<LocalGitCommit> historicalLocalGitCommits =
			_workspaceGitRepository.getHistoricalLocalGitCommits();

		if (portalBuildDataList.size() > 1) {
			PortalBuildData firstPortalBuildData = portalBuildDataList.get(0);
			PortalBuildData secondPortalBuildData = portalBuildDataList.get(1);

			String firstPortalBuildDataPortalBranchSHA =
				firstPortalBuildData.getPortalBranchSHA();
			String secondPortalBuildDataPortalBranchSHA =
				secondPortalBuildData.getPortalBranchSHA();

			if (firstPortalBuildDataPortalBranchSHA.equals(
					secondPortalBuildDataPortalBranchSHA)) {

				LocalGitCommit retestLocalGitCommit = null;

				for (LocalGitCommit historicalLocalGitCommit :
						historicalLocalGitCommits) {

					String sha = historicalLocalGitCommit.getSHA();

					if (sha.equals(firstPortalBuildDataPortalBranchSHA)) {
						retestLocalGitCommit = historicalLocalGitCommit;

						break;
					}
				}

				for (PortalBuildData portalBuildData : portalBuildDataList) {
					if (portalBuildData != null) {
						gitCommitGroup = new GitCommitGroup(portalBuildData);

						gitCommitGroups.add(gitCommitGroup);
					}
					else {
						gitCommitGroup = new GitCommitGroup(null);

						gitCommitGroups.add(gitCommitGroup);
					}

					if (retestLocalGitCommit != null) {
						gitCommitGroup.add(retestLocalGitCommit);
					}
				}

				return gitCommitGroups;
			}
		}

		for (int i = 0; i < historicalLocalGitCommits.size(); i++) {
			LocalGitCommit historicalLocalGitCommit =
				historicalLocalGitCommits.get(i);

			String sha = historicalLocalGitCommit.getSHA();

			PortalBuildData portalBuildData = null;

			for (PortalBuildData currentPortalBuildData : portalBuildDataList) {
				if (sha.equals(currentPortalBuildData.getPortalBranchSHA())) {
					portalBuildData = currentPortalBuildData;

					break;
				}
			}

			if (portalBuildData != null) {
				portalBuildDataList.remove(portalBuildData);

				gitCommitGroup = new GitCommitGroup(portalBuildData);

				gitCommitGroups.add(gitCommitGroup);
			}
			else if (i == 0) {
				gitCommitGroup = new GitCommitGroup(null);

				gitCommitGroups.add(gitCommitGroup);
			}

			gitCommitGroup.add(historicalLocalGitCommit);
		}

		return gitCommitGroups;
	}

	@Override
	public synchronized Element getJenkinsReportElement() {
		if (_workspaceGitRepository == null) {
			throw new IllegalStateException(
				"Please set the workspace Git repository");
		}

		if (_downstreamPortalBuildDataList == null) {
			throw new IllegalStateException(
				"Please set the downstream portal build data list");
		}

		Context context = new Context();

		context.setVariable("build", this);

		try {
			context.setVariable(
				"cssContent",
				JenkinsResultsParserUtil.getResourceFileContent(
					"dependencies/jenkins/report/jenkins_report_rca.css"));
			context.setVariable(
				"jsContent",
				JenkinsResultsParserUtil.getResourceFileContent(
					"dependencies/jenkins/report/jenkins_report_rca.js"));
		}
		catch (IOException ioException) {
			throw new RuntimeException(
				"Unable to load Jenkins report resources", ioException);
		}

		return processJenkinsReportTemplate("jenkins_report_rca.html", context);
	}

	public WorkspaceGitRepository getWorkspaceGitRepository() {
		return _workspaceGitRepository;
	}

	public void setDownstreamPortalBuildDataList(
		List<PortalBuildData> downstreamPortalBuildDataList) {

		_downstreamPortalBuildDataList = downstreamPortalBuildDataList;
	}

	public void setWorkspaceGitRepository(
		WorkspaceGitRepository workspaceGitRepository) {

		_workspaceGitRepository = workspaceGitRepository;
	}

	public static class GitCommitGroup extends ArrayList<LocalGitCommit> {

		public GitCommitGroup(PortalBuildData portalBuildData) {
			this.portalBuildData = portalBuildData;
		}

		public PortalBuildData getPortalBuildData() {
			return portalBuildData;
		}

		protected PortalBuildData portalBuildData;

	}

	protected RootCauseAnalysisToolBuild(String buildURL) {
		this(buildURL, null);
	}

	protected RootCauseAnalysisToolBuild(
		String buildURL, TopLevelBuild topLevelBuild) {

		super(buildURL, topLevelBuild);
	}

	private List<PortalBuildData> _downstreamPortalBuildDataList;
	private WorkspaceGitRepository _workspaceGitRepository;

}