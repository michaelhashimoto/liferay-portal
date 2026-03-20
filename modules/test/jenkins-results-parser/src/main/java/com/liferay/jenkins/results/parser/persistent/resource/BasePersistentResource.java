/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.BuildDatabase;
import com.liferay.jenkins.results.parser.CloudBucketUtil;
import com.liferay.jenkins.results.parser.JenkinsAPIUtil;
import com.liferay.jenkins.results.parser.JenkinsMaster;
import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.SubrepositoryWorkspace;
import com.liferay.jenkins.results.parser.Workspace;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public abstract class BasePersistentResource implements PersistentResource {

	@Override
	public void addPersistentResourceArtifact(Artifact artifact) {
		_artifacts.put(artifact.getName(), artifact);
	}

	@Override
	public void download(String artifactName, File destinationDir) {
		Artifact artifact = _artifacts.get(artifactName);

		if (artifact == null) {
			throw new RuntimeException(artifactName + " does not exist");
		}

		if (!artifact.isAvailable()) {
			throw new RuntimeException(artifactName + " is not available");
		}

		try {
			CloudBucketUtil.downloadS3File(
				new File(destinationDir, artifactName),
				artifact.getS3ObjectPath());
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	@Override
	public List<Artifact> getArtifacts() {
		return new ArrayList<>(_artifacts.values());
	}

	@Override
	public String getControllerBuildURL() {
		return _controllerBuildURL;
	}

	@Override
	public JSONObject getJSONObject() {
		JSONObject jsonObject = new JSONObject();

		JSONArray artifactsJSONArray = new JSONArray();

		for (Artifact artifact : getArtifacts()) {
			artifactsJSONArray.put(artifact.getJSONObject());
		}

		jsonObject.put(
			"artifacts", artifactsJSONArray
		).put(
			"controller_build_url", getControllerBuildURL()
		).put(
			"producer_build_url", getProducerBuildURL()
		);

		JenkinsMaster producerJenkinsMaster = getProducerJenkinsMaster();

		if (producerJenkinsMaster != null) {
			jsonObject.put(
				"producer_jenkins_master", producerJenkinsMaster.getName());
		}

		jsonObject.put(
			"producer_queue_id", getProducerQueueId()
		).put(
			"status", String.valueOf(getStatus())
		);

		return jsonObject;
	}

	@Override
	public String getProducerBuildURL() {
		return _producerBuildURL;
	}

	@Override
	public JenkinsMaster getProducerJenkinsMaster() {
		return _producerJenkinsMaster;
	}

	@Override
	public long getProducerQueueId() {
		return _producerQueueId;
	}

	@Override
	public String getS3ObjectPath() {
		return JenkinsResultsParserUtil.combine(
			getBaseS3ObjectPath(), "/resource.json");
	}

	@Override
	public Status getStatus() {
		return _status;
	}

	@Override
	public boolean isArtifactsAvailable() {
		for (Artifact artifact : getArtifacts()) {
			if (!artifact.isAvailable()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isController() {
		return Objects.equals(
			getCurrentTopLevelBuildURL(), getControllerBuildURL());
	}

	@Override
	public boolean isMissing() {
		if (isController() || isArtifactsAvailable()) {
			return false;
		}

		String controllerBuildURL = getControllerBuildURL();

		if (!JenkinsResultsParserUtil.isURL(controllerBuildURL)) {
			return false;
		}

		JSONObject apiJSONObject = JenkinsAPIUtil.getAPIJSONObject(
			controllerBuildURL, "result");

		return !JenkinsResultsParserUtil.isNullOrEmpty(
			apiJSONObject.optString("result"));
	}

	@Override
	public void print(String message) {
		System.out.println("[" + getType() + "] " + message);
	}

	@Override
	public void printStatusMessage() {
		print(getStatusMessage());
	}

	@Override
	public void upload(File baseDir) {
		for (Artifact artifact : getArtifacts()) {
			File artifactFile = new File(baseDir, artifact.getName());

			if (!artifactFile.exists()) {
				continue;
			}

			try {
				CloudBucketUtil.uploadS3File(
					artifact.getS3ObjectPath(), artifactFile);
			}
			catch (IOException ioException) {
				throw new RuntimeException(ioException);
			}
		}
	}

	@Override
	public void waitForUpdate() {
		update();

		while (true) {
			Status status = getStatus();

			if (status == Status.FAILED) {
				String statusMessage = getStatusMessage();

				print(statusMessage);

				throw new RuntimeException(statusMessage);
			}
			else if (status == Status.SUCCESS) {
				print(getStatusMessage());

				break;
			}

			printStatusMessage();

			JenkinsResultsParserUtil.sleep(30000);

			update();
		}
	}

	protected BasePersistentResource(BuildDatabase buildDatabase) {
		_buildDatabase = buildDatabase;

		for (String artifactName : getArtifactNames()) {
			_artifacts.put(artifactName, new Artifact(artifactName, this));
		}
	}

	protected abstract Set<String> getArtifactNames();

	protected BuildDatabase getBuildDatabase() {
		return _buildDatabase;
	}

	protected String getCurrentTopLevelBuildURL() {
		return getStartProperty("TOP_LEVEL_BUILD_URL");
	}

	protected JSONObject getS3JSONObject() {
		String s3ObjectPath = getS3ObjectPath();

		if (!CloudBucketUtil.isS3ObjectPathAvailable(s3ObjectPath)) {
			return null;
		}

		try {
			return new JSONObject(CloudBucketUtil.readS3File(s3ObjectPath));
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	protected synchronized Properties getStartProperties() {
		if (_startProperties != null) {
			return _startProperties;
		}

		_startProperties = new Properties();

		if (_buildDatabase.hasProperties("start.properties")) {
			_startProperties.putAll(
				_buildDatabase.getProperties("start.properties"));
		}

		String jobVariant = System.getenv("JOB_VARIANT");

		if (_buildDatabase.hasProperties(jobVariant + "/start.properties")) {
			_startProperties.putAll(
				_buildDatabase.getProperties(jobVariant + "/start.properties"));
		}

		return _startProperties;
	}

	protected String getStartProperty(String propertyName) {
		return JenkinsResultsParserUtil.getProperty(
			getStartProperties(), propertyName);
	}

	protected synchronized Workspace getWorkspace() {
		if (_workspace != null) {
			return _workspace;
		}

		String primaryGitDirectoryName = getStartProperty(
			"PRIMARY_GIT_DIRECTORY_NAME");

		if (!_buildDatabase.hasWorkspace(primaryGitDirectoryName)) {
			return null;
		}

		_workspace = _buildDatabase.getWorkspace(primaryGitDirectoryName);

		if (_workspace instanceof SubrepositoryWorkspace) {
			String portalUpstreamBranchName = getStartProperty(
				"PORTAL_UPSTREAM_BRANCH_NAME");

			if (!JenkinsResultsParserUtil.isNullOrEmpty(
					portalUpstreamBranchName)) {

				SubrepositoryWorkspace subrepositoryWorkspace =
					(SubrepositoryWorkspace)_workspace;

				subrepositoryWorkspace.setPortalUpstreamBranchName(
					portalUpstreamBranchName);
			}
		}

		return _workspace;
	}

	protected void save() {
		try {
			CloudBucketUtil.uploadS3ObjectFromContent(
				getS3ObjectPath(), String.valueOf(getJSONObject()));
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	protected void setControllerBuildURL(String controllerBuildURL) {
		_controllerBuildURL = controllerBuildURL;
	}

	protected void setProducerBuildURL(String producerBuildURL) {
		_producerBuildURL = producerBuildURL;
	}

	protected void setProducerJenkinsMaster(
		JenkinsMaster producerJenkinsMaster) {

		_producerJenkinsMaster = producerJenkinsMaster;
	}

	protected void setProducerQueueId(long producerQueueId) {
		_producerQueueId = producerQueueId;
	}

	protected void setStatus(Status status) {
		_status = status;
	}

	private final Map<String, Artifact> _artifacts = new HashMap<>();
	private final BuildDatabase _buildDatabase;
	private String _controllerBuildURL;
	private String _producerBuildURL;
	private JenkinsMaster _producerJenkinsMaster;
	private long _producerQueueId;
	private Properties _startProperties;
	private Status _status;
	private Workspace _workspace;

}