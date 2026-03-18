/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.CloudBucketUtil;
import com.liferay.jenkins.results.parser.JenkinsAPIUtil;
import com.liferay.jenkins.results.parser.JenkinsMaster;
import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.PortalWorkspace;
import com.liferay.jenkins.results.parser.PortalWorkspaceGitRepository;
import com.liferay.jenkins.results.parser.TopLevelBuild;
import com.liferay.jenkins.results.parser.Workspace;
import com.liferay.jenkins.results.parser.WorkspaceBuild;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
		System.out.println("getArtifacts()=" + getArtifacts());

		for (Artifact artifact : getArtifacts()) {
			System.out.println("artifact=" + artifact);

			if (!artifact.isAvailable()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isController() {
		return Objects.equals(
			_topLevelBuild.getBuildURL(), getControllerBuildURL());
	}

	@Override
	public boolean isMissing() {
		if (isController() || isArtifactsAvailable()) {
			return false;
		}

		String controllerBuildURL = getControllerBuildURL();

		System.out.println("controllerBuildURL=" + controllerBuildURL);

		if (!JenkinsResultsParserUtil.isURL(controllerBuildURL)) {
			return false;
		}

		JSONObject apiJSONObject = JenkinsAPIUtil.getAPIJSONObject(
			controllerBuildURL, "result");

		if (apiJSONObject.optString("result") == null) {
			return false;
		}

		return true;
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

			System.out.println("artifactFile=" + artifactFile);

			if (artifactFile.exists()) {
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

	protected BasePersistentResource(TopLevelBuild topLevelBuild) {
		_topLevelBuild = topLevelBuild;

		for (String artifactName : _getArtifactNames()) {
			System.out.println("artifactName=" + artifactName);

			_artifacts.put(artifactName, new Artifact(artifactName, this));
		}
	}

	protected String getPortalUpstreamBranchName() {
		Workspace workspace = getWorkspace();

		if (workspace instanceof PortalWorkspace) {
			PortalWorkspace portalWorkspace = (PortalWorkspace)workspace;

			PortalWorkspaceGitRepository portalWorkspaceGitRepository =
				portalWorkspace.getPortalWorkspaceGitRepository();

			return portalWorkspaceGitRepository.getBranchName();
		}

		return "master";
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

	protected TopLevelBuild getTopLevelBuild() {
		return _topLevelBuild;
	}

	protected Workspace getWorkspace() {
		if (!(_topLevelBuild instanceof WorkspaceBuild)) {
			return null;
		}

		WorkspaceBuild workspaceBuild = (WorkspaceBuild)_topLevelBuild;

		return workspaceBuild.getWorkspace();
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

	private Set<String> _getArtifactNames() {
		Set<String> artifactNames = new HashSet<>();

		try {
			String artifactNamesString =
				JenkinsResultsParserUtil.getBuildProperty(
					"persistent.resource.artifact.names[" + getType() + "]",
					getPortalUpstreamBranchName());

			if (JenkinsResultsParserUtil.isNullOrEmpty(artifactNamesString)) {
				return artifactNames;
			}

			Collections.addAll(artifactNames, artifactNamesString.split(","));
		}
		catch (IOException ioException) {
		}

		return artifactNames;
	}

	private final Map<String, Artifact> _artifacts = new HashMap<>();
	private String _controllerBuildURL;
	private String _producerBuildURL;
	private JenkinsMaster _producerJenkinsMaster;
	private long _producerQueueId;
	private Status _status;
	private final TopLevelBuild _topLevelBuild;

}