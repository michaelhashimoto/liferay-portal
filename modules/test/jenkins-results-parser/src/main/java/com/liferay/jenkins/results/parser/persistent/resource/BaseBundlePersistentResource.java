/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.Build;
import com.liferay.jenkins.results.parser.BuildDatabase;
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
import java.util.Properties;

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
	public String getStatusMessage() {
		Status status = getStatus();

		if (status == PersistentResource.Status.FAILED) {
			return "Failed to build artifacts at " + getProducerBuildURL();
		}
		else if (status == Status.IN_PROGRESS) {
			if (isController()) {
				return "Building artifact at " + getProducerBuildURL();
			}

			return "Building artifact at " + getProducerBuildURL();
		}
		else if (status == Status.IN_QUEUE) {
			return "In queue at " + _getProducerJobURL();
		}
		else if (status == PersistentResource.Status.SUCCESS) {
			return "Completed successfully at " + getProducerBuildURL();
		}

		return "Not started";
	}

	private String _getProducerJobURL() {
		JenkinsMaster producerJenkinsMaster = getProducerJenkinsMaster();

		if (producerJenkinsMaster == null) {
			return null;
		}

		return producerJenkinsMaster.getRemoteURL() + "/job/" + _JOB_NAME;
	}

	@Override
	public void start() {
		TopLevelBuild topLevelBuild = getTopLevelBuild();

		Map<String, String> buildParameters = new HashMap<>(
			topLevelBuild.getStartPropertiesTempMap());

		buildParameters.put("AXIS_VARIABLE", getJobVariant());
		buildParameters.put("BUILD_PRIORITY", _BUILD_PRIORITY);
		buildParameters.put(
			"GITHUB_UPSTREAM_BRANCH_NAME", getPortalUpstreamBranchName());
		buildParameters.put("JOB_VARIANT", getJobVariant());
		buildParameters.put("SLAVE_LABEL", _SLAVE_LABEL);

		BuildDatabase buildDatabase = topLevelBuild.getBuildDatabase();

		StringBuilder sb = new StringBuilder();

		sb.append(getJobVariant());
		sb.append("/start.properties");

		String key = sb.toString();

		Properties properties = new Properties();

		properties.putAll(buildParameters);

		buildDatabase.putProperties(key, properties, true);

		buildDatabase.uploadBuildDatabaseFileToCloudBucket();

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

		print("Invoked at " + _getProducerJobURL());
	}

	@Override
	public void update() {
		if (!isController()) {
			JSONObject s3JSONObject = getS3JSONObject();

			System.out.println("s3JSONObject=" + s3JSONObject.toString(2));

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

		if ((status == Status.FAILED) || (status == Status.SUCCESS)) {
			String producerBuildURL = getProducerBuildURL();

			TopLevelBuild topLevelBuild = getTopLevelBuild();

			Build build = BuildFactory.newBuild(
					producerBuildURL, getJobVariant(), topLevelBuild);

			topLevelBuild.addDownstreamBuild(build);

			Build.Invocation buildInvocation = build.getCurrentInvocation();

			setControllerBuildURL(topLevelBuild.getBuildURL());
			setProducerBuildURL(producerBuildURL);
			setProducerJenkinsMaster(buildInvocation.getJenkinsMaster());
			setProducerQueueId(buildInvocation.getQueueId());

			save();
		}
		else if (status == Status.IN_PROGRESS) {
			String producerBuildURL = getProducerBuildURL();

			JSONObject apiJSONObject = JenkinsAPIUtil.getAPIJSONObject(
				producerBuildURL);

			String result = apiJSONObject.optString("result");

			if (JenkinsResultsParserUtil.isNullOrEmpty(result)) {
				return;
			}

			if (Objects.equals(result, "SUCCESS")) {
				setStatus(Status.SUCCESS);
			}
			else {
				setStatus(Status.FAILED);
			}

			save();
		}
		else if (status == Status.IN_QUEUE) {
			JenkinsMaster producerJenkinsMaster = getProducerJenkinsMaster();

			long producerQueueId = getProducerQueueId();

			for (JenkinsMaster.QueueItem queueItem :
					producerJenkinsMaster.getQueueItems()) {

				if (queueItem.getId() == producerQueueId) {
					return;
				}
			}

			String producerBuildURL = JenkinsResultsParserUtil.getBuildURL(
				_JOB_NAME, producerJenkinsMaster, producerQueueId);

			if (producerBuildURL != null) {
				setStatus(Status.IN_PROGRESS);

				setProducerBuildURL(producerBuildURL);

				save();

				return;
			}

			print("WARNING: Unable to find queue item");
		}
	}

	protected String getJobVariant() {
		return String.valueOf(getType());
	};

	protected BaseBundlePersistentResource(TopLevelBuild topLevelBuild) {
		super(topLevelBuild);
	}

	protected abstract WorkspaceGitRepository getBundleWorkspaceGitRepository();

	private static final String _BUILD_PRIORITY = "2";

	private static final String _JOB_NAME = "app-server-bundle-builder";

	private static final int _MAX_MISSING_COUNT = 2;

	private static final String _SLAVE_LABEL = "slave-bundle-builder";

	private int _missingCount;

}