/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.CloudBucketUtil;
import com.liferay.jenkins.results.parser.JenkinsMaster;
import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public interface PersistentResource {

	public void addPersistentResourceArtifact(Artifact artifact);

	public List<Artifact> getArtifacts();

	public String getBaseS3ObjectPath();

	public String getControllerBuildURL();

	public JSONObject getJSONObject();

	public String getProducerBuildURL();

	public JenkinsMaster getProducerJenkinsMaster();

	public long getProducerQueueId();

	public String getS3ObjectPath();

	public Status getStatus();

	public Type getType();

	public boolean isArtifactsAvailable();

	public boolean isController();

	public boolean isMissing();

	public void print(String message);

	public void printStatusMessage();

	public String getStatusMessage();

	public void start();

	public void update();

	public void upload(File baseDir);

	public static class Artifact {

		public JSONObject getJSONObject() {
			JSONObject jsonObject = new JSONObject();

			jsonObject.put(
				"name", getName()
			).put(
				"s3_object_path", getS3ObjectPath()
			);

			return jsonObject;
		}

		public String getName() {
			return _name;
		}

		public String getS3ObjectPath() {
			return JenkinsResultsParserUtil.combine(
				_persistentResource.getBaseS3ObjectPath(), "/", getName());
		}

		public boolean isAvailable() {
			return CloudBucketUtil.isS3ObjectPathAvailable(getS3ObjectPath());
		}

		@Override
		public String toString() {
			return String.valueOf(getJSONObject());
		}

		protected Artifact(String name, PersistentResource persistentResource) {
			_name = name;
			_persistentResource = persistentResource;
		}

		private final String _name;
		private final PersistentResource _persistentResource;

	}

	public static enum Status {

		FAILED, IN_PROGRESS, IN_QUEUE, NOT_STARTED, SUCCESS

	}

	public static enum Type {

		ASAH_BUNDLE("asah-bundle"), FARO_BUNDLE("faro-bundle"),
		PORTAL_BUNDLE("portal-bundle");

		@Override
		public String toString() {
			return _key;
		}

		private Type(String key) {
			_key = key;
		}

		private final String _key;

	}

}