/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import com.google.common.collect.Lists;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

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

	@Override
	public synchronized String getJenkinsReportString() {
		if (_workspaceGitRepository == null) {
			throw new IllegalStateException(
				"Please set the workspace Git repository");
		}

		if (_downstreamPortalBuildDataList == null) {
			throw new IllegalStateException(
				"Please set the downstream portal build data list");
		}

		Context context = new Context();

		context.setVariable("buildURL", getBuildURL());
		context.setVariable("chartJsContent", getJenkinsReportChartJsContent());
		context.setVariable("chartJsURL", getJenkinsReportChartJsURL());
		context.setVariable(
			"columnHeaders",
			Arrays.asList(
				"", "Commit SHA", "Commit Date", "Commit Message",
				"Commit Diffs", "Build Link", "Build Time", "Build Status",
				"Build Result"));

		List<Map<String, Object>> commitGroupMaps = new ArrayList<>();

		List<GitCommitGroup> gitCommitGroups = getCommitGroups();

		for (int i = 0; i < gitCommitGroups.size(); i++) {
			GitCommitGroup nextGitCommitGroup = null;

			if (gitCommitGroups.size() > (i + 1)) {
				nextGitCommitGroup = gitCommitGroups.get(i + 1);
			}

			commitGroupMaps.add(
				_getCommitGroupMap(
					gitCommitGroups.get(i), nextGitCommitGroup, i == 0));
		}

		context.setVariable("commitGroups", commitGroupMaps);

		try {
			context.setVariable(
				"cssContent",
				JenkinsResultsParserUtil.getResourceFileContent(
					"dependencies/rca_jenkins_report.css"));
			context.setVariable(
				"jsContent",
				JenkinsResultsParserUtil.getResourceFileContent(
					"dependencies/rca_jenkins_report.js"));
		}
		catch (IOException ioException) {
			throw new RuntimeException(
				"Unable to load Jenkins report resources", ioException);
		}

		JSONObject jobJSONObject = getBuildJSONObject();

		String description = jobJSONObject.optString("description");

		if (!description.isEmpty()) {
			context.setVariable("description", description);
		}

		String gitHubCommitsURL = _workspaceGitRepository.getGitHubURL();

		context.setVariable(
			"gitHubCommitsURL",
			gitHubCommitsURL.replace("/tree/", "/commits/"));

		context.setVariable("jQueryURL", _URL_JQUERY);
		context.setVariable("summaryItems", getJenkinsReportSummaryItems());

		return processJenkinsReportTemplate("rca_jenkins_report.html", context);
	}

	public void setDownstreamPortalBuildDataList(
		List<PortalBuildData> downstreamPortalBuildDataList) {

		_downstreamPortalBuildDataList = downstreamPortalBuildDataList;
	}

	public void setWorkspaceGitRepository(
		WorkspaceGitRepository workspaceGitRepository) {

		_workspaceGitRepository = workspaceGitRepository;
	}

	protected RootCauseAnalysisToolBuild(String buildURL) {
		this(buildURL, null);
	}

	protected RootCauseAnalysisToolBuild(
		String buildURL, TopLevelBuild topLevelBuild) {

		super(buildURL, topLevelBuild);
	}

	protected List<GitCommitGroup> getCommitGroups() {
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

	protected static class GitCommitGroup extends ArrayList<LocalGitCommit> {

		public GitCommitGroup(PortalBuildData portalBuildData) {
			this.portalBuildData = portalBuildData;
		}

		public PortalBuildData getPortalBuildData() {
			return portalBuildData;
		}

		protected PortalBuildData portalBuildData;

	}

	private Map<String, Object> _getCommitGroupMap(
		GitCommitGroup gitCommitGroup, GitCommitGroup nextGitCommitGroup,
		boolean firstCommit) {

		Map<String, Object> commitGroupMap = new HashMap<>();

		PortalBuildData portalBuildData = gitCommitGroup.getPortalBuildData();

		if (portalBuildData != null) {
			commitGroupMap.put(
				"buildDuration",
				JenkinsResultsParserUtil.toDurationString(
					portalBuildData.getBuildDuration()));
			commitGroupMap.put("buildResult", portalBuildData.getBuildResult());
			commitGroupMap.put("buildStatus", portalBuildData.getBuildStatus());
			commitGroupMap.put("buildURL", portalBuildData.getBuildURL());
		}

		LocalGitCommit headerLocalGitCommit = gitCommitGroup.get(0);

		commitGroupMap.put(
			"commitDate",
			JenkinsResultsParserUtil.toDateString(
				headerLocalGitCommit.getCommitDate(), _DATE_FORMAT_COMMIT,
				"PST"));
		commitGroupMap.put("commitMessage", headerLocalGitCommit.getMessage());

		String prefix = "";

		if (firstCommit) {
			prefix = "*";
		}

		commitGroupMap.put(
			"commitSHA", prefix + headerLocalGitCommit.getAbbreviatedSHA());
		commitGroupMap.put(
			"commitURL", _getGitHubCommitURL(headerLocalGitCommit));

		List<Map<String, String>> commitMaps = new ArrayList<>();

		for (int i = 1; i < gitCommitGroup.size(); i++) {
			commitMaps.add(_getCommitMap(gitCommitGroup.get(i)));
		}

		commitGroupMap.put("commits", commitMaps);

		if (gitCommitGroup.size() > 1) {
			commitGroupMap.put("toggleSHA", headerLocalGitCommit.getSHA());

			if (nextGitCommitGroup != null) {
				LocalGitCommit firstNextLocalGitCommit = nextGitCommitGroup.get(
					0);

				String gitHubCommitDiffURL =
					_workspaceGitRepository.getGitHubURL();

				gitHubCommitDiffURL = gitHubCommitDiffURL.replaceAll(
					"/tree/.+", "/compare/");

				commitGroupMap.put(
					"diffText", gitCommitGroup.size() + " commits");
				commitGroupMap.put(
					"diffURL",
					JenkinsResultsParserUtil.combine(
						gitHubCommitDiffURL, firstNextLocalGitCommit.getSHA(),
						"...", headerLocalGitCommit.getSHA()));
			}
		}

		return commitGroupMap;
	}

	private Map<String, String> _getCommitMap(LocalGitCommit localGitCommit) {
		Map<String, String> commitMap = new HashMap<>();

		commitMap.put(
			"date",
			JenkinsResultsParserUtil.toDateString(
				localGitCommit.getCommitDate(), _DATE_FORMAT_COMMIT, "PST"));
		commitMap.put("message", localGitCommit.getMessage());
		commitMap.put("sha", localGitCommit.getAbbreviatedSHA());
		commitMap.put("url", _getGitHubCommitURL(localGitCommit));

		return commitMap;
	}

	private String _getGitHubCommitURL(LocalGitCommit localGitCommit) {
		String gitHubCommitURL = _workspaceGitRepository.getGitHubURL();

		return gitHubCommitURL.replaceAll(
			"/tree/.+", "/commit/" + localGitCommit.getSHA());
	}

	private static final String _DATE_FORMAT_COMMIT = "yyyy-MM-dd h:mm:ss aa z";

	private static final String _URL_JQUERY =
		"https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js";

	private List<PortalBuildData> _downstreamPortalBuildDataList;
	private WorkspaceGitRepository _workspaceGitRepository;

}