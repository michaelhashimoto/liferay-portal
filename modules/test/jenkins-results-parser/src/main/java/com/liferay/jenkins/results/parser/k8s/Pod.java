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

package com.liferay.jenkins.results.parser.k8s;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.Exec;
import io.kubernetes.client.models.V1ObjectMeta;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodStatus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Kenji Heigel
 */
public class Pod {

	public ExecutionResult exec(List<String> commands) {
		return exec(commands.toArray(new String[0]));
	}

	public ExecutionResult exec(String... commands) {
		Process process = null;

		int exitValue = 0;
		String standardError = "";
		String standardOut = "";

		try {
			Exec exec = new Exec();

			process = exec.exec(
				getNamespace(), getName(), commands, true,
				System.console() != null);

			try (InputStream inputStream = process.getInputStream() ;
				 InputStream errorStream = process.getErrorStream()) {

				standardOut = JenkinsResultsParserUtil.readInputStream(
					inputStream, true);

				exitValue = process.exitValue();

				if (exitValue != 0) {
					standardError = JenkinsResultsParserUtil.readInputStream(
						errorStream);
				}
			}
			catch (IOException ioe) {
				throw new RuntimeException(
					"Unable to read process input stream", ioe);
			}

			return new ExecutionResult(exitValue, standardError, standardOut);
		}
		catch (ApiException | IOException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (process != null) {
				process.destroy();
			}
		}
	}

	public String getIP() {
		V1Pod v1Pod = getV1Pod();

		V1PodStatus v1PodStatus = v1Pod.getStatus();

		String ip = v1PodStatus.getPodIP();

		if (ip == null) {
			throw new RuntimeException(
				"Unable to get ip of pod '" + getName() + "'");
		}

		return ip;
	}

	public String getName() {
		V1ObjectMeta v1ObjectMeta = _v1Pod.getMetadata();

		return v1ObjectMeta.getName();
	}

	public String getNamespace() {
		V1ObjectMeta v1ObjectMeta = _v1Pod.getMetadata();

		return v1ObjectMeta.getNamespace();
	}

	public String getPhase() {
		V1PodStatus v1PodStatus = _v1Pod.getStatus();

		return v1PodStatus.getPhase();
	}

	protected Pod(V1Pod v1Pod) {
		_v1Pod = v1Pod;
	}

	protected V1Pod getV1Pod() {
		return _v1Pod;
	}

	protected void refreshV1Pod() {
		LiferayK8sConnection liferayK8sConnection =
			LiferayK8sConnection.getInstance();

		Pod pod = liferayK8sConnection.getPod(this, getNamespace());

		_v1Pod = pod.getV1Pod();
	}

	public static class ExecutionResult {

		public int getExitValue() {
			return _exitValue;
		}

		public String getStandardError() {
			return _standardError;
		}

		public String getStandardOut() {
			return _standardOut;
		}

		protected ExecutionResult(
			int exitValue, String standardError, String standardOut) {

			_exitValue = exitValue;
			_standardError = standardError;
			_standardOut = standardOut;
		}

		private final int _exitValue;
		private final String _standardError;
		private final String _standardOut;

	}

	private V1Pod _v1Pod;

}