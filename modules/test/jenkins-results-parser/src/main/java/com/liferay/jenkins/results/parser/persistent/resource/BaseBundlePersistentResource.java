/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.Build;
import com.liferay.jenkins.results.parser.BuildFactory;
import com.liferay.jenkins.results.parser.JenkinsAPIUtil;
import com.liferay.jenkins.results.parser.JenkinsMaster;
import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.TopLevelBuild;
import com.liferay.jenkins.results.parser.WorkspaceGitRepository;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseBundlePersistentResource
	extends BasePersistentResource {

	@Override
	public String getBaseS3ObjectPath() {
		StringBuilder sb = new StringBuilder();

		try {
			sb.append(
				JenkinsResultsParserUtil.getBuildProperty(
					"cloud.ci.s3.bucket.persistent.resources.archives.path"));
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}

		WorkspaceGitRepository bundleWorkspaceGitRepository =
			getBundleWorkspaceGitRepository();

		sb.append("/");
		sb.append(getType());
		sb.append("/");
		sb.append(bundleWorkspaceGitRepository.getName());
		sb.append("/");
		sb.append(bundleWorkspaceGitRepository.getBaseBranchSHA());
		sb.append("/");
		sb.append(bundleWorkspaceGitRepository.getSenderBranchSHA());

		return sb.toString();
	}

	@Override
	public void print(String message) {
		System.out.println("[" + getType() + "] " + message);
	}

	@Override
	public void start() {
		TopLevelBuild topLevelBuild = getTopLevelBuild();

		Map<String, String> buildParameters = new HashMap<>();

		buildParameters.put("AXIS_VARIABLE", String.valueOf(getType()));
		buildParameters.put("BUILD_PRIORITY", _BUILD_PRIORITY);
		buildParameters.put(
			"DIST_NODES", topLevelBuild.getStartProperty("DIST_NODES"));
		buildParameters.put(
			"DIST_PATH", topLevelBuild.getStartProperty("DIST_PATH"));
		buildParameters.put(
			"GITHUB_UPSTREAM_BRANCH_NAME",
			topLevelBuild.getStartProperty("GITHUB_UPSTREAM_BRANCH_NAME"));
		buildParameters.put(
			"JENKINS_GITHUB_ORIGIN_NAME",
			topLevelBuild.getStartProperty("JENKINS_GITHUB_ORIGIN_NAME"));
		buildParameters.put(
			"JENKINS_GITHUB_PULL_REQUEST_NUMBER",
			topLevelBuild.getStartProperty(
				"JENKINS_GITHUB_PULL_REQUEST_NUMBER"));
		buildParameters.put(
			"JENKINS_GITHUB_PULL_REQUEST_USERNAME",
			topLevelBuild.getStartProperty(
				"JENKINS_GITHUB_PULL_REQUEST_USERNAME"));
		buildParameters.put(
			"JENKINS_GITHUB_RECEIVER_USERNAME",
			topLevelBuild.getStartProperty("JENKINS_GITHUB_RECEIVER_USERNAME"));
		buildParameters.put(
			"JENKINS_GITHUB_SENDER_BRANCH_NAME",
			topLevelBuild.getStartProperty(
				"JENKINS_GITHUB_SENDER_BRANCH_NAME"));
		buildParameters.put(
			"JENKINS_GITHUB_SENDER_BRANCH_SHA",
			topLevelBuild.getStartProperty("JENKINS_GITHUB_SENDER_BRANCH_SHA"));
		buildParameters.put(
			"JENKINS_GITHUB_SENDER_USERNAME",
			topLevelBuild.getStartProperty("JENKINS_GITHUB_SENDER_USERNAME"));
		buildParameters.put(
			"JENKINS_GITHUB_UPSTREAM_BRANCH_NAME",
			topLevelBuild.getStartProperty(
				"JENKINS_GITHUB_UPSTREAM_BRANCH_NAME"));
		buildParameters.put(
			"JENKINS_GITHUB_UPSTREAM_BRANCH_SHA",
			topLevelBuild.getStartProperty(
				"JENKINS_GITHUB_UPSTREAM_BRANCH_SHA"));
		buildParameters.put("JOB_VARIANT", _JOB_NAME);
		buildParameters.put(
			"JSON_MAP_URL", topLevelBuild.getStartProperty("JSON_MAP_URL"));
		buildParameters.put(
			"S3_BUCKET_DIST_PATH",
			topLevelBuild.getStartProperty("S3_BUCKET_DIST_PATH"));
		buildParameters.put("SLAVE_LABEL", _SLAVE_LABEL);

		JenkinsMaster jenkinsMaster =
			JenkinsResultsParserUtil.getMostAvailableJenkinsMaster(
				topLevelBuild.getBaseInvocationURL(), 1, _SLAVE_LABEL);

		long queueId = JenkinsResultsParserUtil.invokeJenkinsBuild(
			jenkinsMaster, _JOB_NAME, buildParameters);

		setControllerBuildURL(topLevelBuild.getBuildURL());
		setProducerJenkinsMaster(jenkinsMaster);
		setProducerQueueId(queueId);

		setStatus(Status.IN_QUEUE);

		save();

		print("Invoked build on " + jenkinsMaster.getURL());
	}

	@Override
	public void update() {
		if (!isController()) {
			JSONObject s3JSONObject = getS3JSONObject();

			if (s3JSONObject == null) {
				start();

				return;
			}

			if (isMissing()) {
				_missingCount++;

				if (_missingCount >= _MAX_MISSING_COUNT) {
					start();

					_missingCount = 0;

					return;
				}
			}

			setControllerBuildURL(
				s3JSONObject.optString("controller_build_url"));
			setProducerBuildURL(s3JSONObject.optString("producer_build_url"));

			String producerJenkinsMasterName = s3JSONObject.optString(
				"producer_jenkins_master");

			if (!JenkinsResultsParserUtil.isNullOrEmpty(
					producerJenkinsMasterName)) {

				setProducerJenkinsMaster(
					JenkinsMaster.getInstance(producerJenkinsMasterName));
			}
			else {
				setProducerJenkinsMaster(null);
			}

			setProducerQueueId(s3JSONObject.optLong("producer_queue_id"));

			Status status = Status.valueOf(s3JSONObject.getString("status"));

			setStatus(status);

			if ((status == Status.FAILED) || (status == Status.SUCCESS)) {
				save();
			}

			return;
		}

		Status status = getStatus();

		if (status == Status.IN_QUEUE) {
			JenkinsMaster producerJenkinsMaster = getProducerJenkinsMaster();

			long producerQueueId = getProducerQueueId();

			for (JenkinsMaster.QueueItem queueItem :
					producerJenkinsMaster.getQueueItems()) {

				if (queueItem.getId() == producerQueueId) {
					System.out.println("Build is In Queue");

					return;
				}
			}

			String producerBuildURL = JenkinsResultsParserUtil.getBuildURL(
				_JOB_NAME, producerJenkinsMaster, producerQueueId);

			if (producerBuildURL != null) {
				setStatus(Status.IN_PROGRESS);

				if (isController()) {
					setProducerBuildURL(producerBuildURL);

					save();
				}

				System.out.println("Build is In Progress");

				return;
			}

			System.out.println("WARNING: Unable to find queue item");

			return;
		}

		if (status == Status.IN_PROGRESS) {
			String producerBuildURL = getProducerBuildURL();

			JSONObject apiJSONObject = JenkinsAPIUtil.getAPIJSONObject(
				producerBuildURL);

			String result = apiJSONObject.optString("result");

			if (result == null) {
				System.out.println(producerBuildURL + " is in progress");

				return;
			}

			if (Objects.equals(result, "SUCCESS")) {
				setStatus(Status.SUCCESS);
			}
			else {
				setStatus(Status.FAILED);
			}

			save();

			return;
		}

		if ((status == Status.SUCCESS) || (status == Status.FAILED)) {
			String producerBuildURL = getProducerBuildURL();

			TopLevelBuild topLevelBuild = getTopLevelBuild();

			Build build = BuildFactory.newBuild(
				producerBuildURL, _JOB_VARIANT, topLevelBuild);

			topLevelBuild.addDownstreamBuild(build);

			Build.Invocation buildInvocation = build.getCurrentInvocation();

			setControllerBuildURL(topLevelBuild.getBuildURL());
			setProducerBuildURL(producerBuildURL);
			setProducerJenkinsMaster(buildInvocation.getJenkinsMaster());
			setProducerQueueId(buildInvocation.getQueueId());

			save();
		}
	}

	protected BaseBundlePersistentResource(TopLevelBuild topLevelBuild) {
		super(topLevelBuild);
	}

	protected abstract WorkspaceGitRepository getBundleWorkspaceGitRepository();

	private static final String _BUILD_PRIORITY = "2";

	private static final String _JOB_NAME = "app-server-bundle-builder";

	private static final String _JOB_VARIANT = "app-server-bundle-builder";

	private static final int _MAX_MISSING_COUNT = 2;

	private static final String _SLAVE_LABEL = "slave-bundle-builder";

	private int _missingCount;

}