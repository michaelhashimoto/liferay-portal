/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.BuildDatabase;
import com.liferay.jenkins.results.parser.JenkinsAPIUtil;
import com.liferay.jenkins.results.parser.JenkinsMaster;
import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
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

			return "Waiting for artifact at " + getProducerBuildURL();
		}
		else if (status == Status.IN_QUEUE) {
			return "In queue at " + _getProducerJobURL();
		}
		else if (status == PersistentResource.Status.SUCCESS) {
			return "Completed successfully at " + getProducerBuildURL();
		}

		return "Not started";
	}

	@Override
	public void start() {
		Map<String, String> buildParameters = new HashMap<>();

		Properties startProperties = getStartProperties();

		for (String propertyName : startProperties.stringPropertyNames()) {
			buildParameters.put(
				propertyName,
				JenkinsResultsParserUtil.getProperty(
					startProperties, propertyName));
		}

		buildParameters.put("AXIS_VARIABLE", getJobVariant());
		buildParameters.put("BUILD_PRIORITY", _BUILD_PRIORITY);
		buildParameters.put(
			"GITHUB_UPSTREAM_BRANCH_NAME", getPortalUpstreamBranchName());
		buildParameters.put("JOB_VARIANT", getJobVariant());
		buildParameters.put("SLAVE_LABEL", _SLAVE_LABEL);

		StringBuilder sb = new StringBuilder();

		sb.append(getJobVariant());
		sb.append("/start.properties");

		String key = sb.toString();

		Properties properties = new Properties();

		properties.putAll(buildParameters);

		BuildDatabase buildDatabase = getBuildDatabase();

		buildDatabase.putProperties(key, properties, true);

		buildDatabase.uploadBuildDatabaseFileToCloudBucket();

		JenkinsMaster jenkinsMaster =
			JenkinsResultsParserUtil.getMostAvailableJenkinsMaster(
				_getBaseInvocationURL(), 1, _SLAVE_LABEL);

		long queueId = JenkinsResultsParserUtil.invokeJenkinsBuild(
			jenkinsMaster, _JOB_NAME, buildParameters);

		setControllerBuildURL(getCurrentTopLevelBuildURL());
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

			if (s3JSONObject == null) {
				start();

				return;
			}

			System.out.println("s3JSONObject=" + s3JSONObject.toString(2));

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

			System.out.println("status=" + status);

			setStatus(status);

			System.out.println("getJSONObject()=" + getJSONObject());

			System.out.println("isMissing()=" + isMissing());

			if (isMissing()) {
				_missingCount++;

				if (_missingCount >= _MAX_MISSING_COUNT) {
					start();

					_missingCount = 0;

					return;
				}
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
					return;
				}
			}

			String producerBuildURL = JenkinsResultsParserUtil.getBuildURL(
				_JOB_NAME, producerJenkinsMaster, producerQueueId);

			if (JenkinsResultsParserUtil.isURL(producerBuildURL)) {
				setStatus(Status.IN_PROGRESS);

				setProducerBuildURL(producerBuildURL);
				setProducerJenkinsMaster(producerJenkinsMaster);
				setProducerQueueId(producerQueueId);

				save();

				return;
			}

			print("WARNING: Unable to find queue item");

			return;
		}

		String producerBuildURL = getProducerBuildURL();

		if (!JenkinsResultsParserUtil.isURL(producerBuildURL)) {
			print("WARNING: Unable to find producer build url");

			return;
		}

		if (status == Status.IN_PROGRESS) {
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
				_failCount++;

				if (_failCount <= _MAX_FAIL_COUNT) {
					print(
						"Retry " + _failCount + " of " + _MAX_FAIL_COUNT +
							" due to FAILURE in " + getProducerBuildURL());

					start();

					return;
				}

				setStatus(Status.FAILED);
			}

			save();
		}
	}

	protected BaseBundlePersistentResource(BuildDatabase buildDatabase) {
		super(buildDatabase);
	}

	protected abstract WorkspaceGitRepository getBundleWorkspaceGitRepository();

	protected String getJobVariant() {
		return String.valueOf(getType());
	}

	private String _getBaseInvocationURL() {
		try {
			String serverType = "production";

			String topLevelBuildURL = getCurrentTopLevelBuildURL();

			if (topLevelBuildURL.contains("test-5")) {
				serverType = "staging";
			}

			return JenkinsResultsParserUtil.getBuildProperty(
				"github.webhook.base.invocation.url", serverType);
		}
		catch (IOException ioException) {
			return _BASE_INVOCATION_URL;
		}
	}

	private String _getProducerJobURL() {
		JenkinsMaster producerJenkinsMaster = getProducerJenkinsMaster();

		if (producerJenkinsMaster == null) {
			return null;
		}

		return producerJenkinsMaster.getRemoteURL() + "job/" + _JOB_NAME;
	}

	private static final String _BASE_INVOCATION_URL =
		"http://test-1.liferay.com";

	private static final String _BUILD_PRIORITY = "2";

	private static final String _JOB_NAME = "app-server-bundle-builder";

	private static final int _MAX_FAIL_COUNT = 2;

	private static final int _MAX_MISSING_COUNT = 2;

	private static final String _SLAVE_LABEL = "slave-bundle-builder";

	private int _failCount;
	private int _missingCount;

}