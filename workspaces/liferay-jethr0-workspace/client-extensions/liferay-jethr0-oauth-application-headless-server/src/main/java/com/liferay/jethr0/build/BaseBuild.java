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

package com.liferay.jethr0.build;

import com.liferay.jethr0.project.Project;
import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseBuild implements Build {

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public String getJobName() {
		return _jobName;
	}

	@Override
	public JSONObject getJSONObject() {
		State state = getState();

		JSONObject jsonObject = new JSONObject();

		jsonObject.put(
			"id", getId()
		).put(
			"jobName", getJobName()
		).put(
			"name", getBuildName()
		).put(
			"state", state.getJSONObject()
		);

		return jsonObject;
	}

	@Override
	public String getBuildName() {
		return _buildName;
	}

	@Override
	public Project getProject() {
		return _project;
	}

	@Override
	public State getState() {
		return _state;
	}

	@Override
	public void setJobName(String jobName) {
		_jobName = jobName;
	}

	@Override
	public void setState(State state) {
		_state = state;
	}

	protected BaseBuild(Project project, JSONObject jsonObject) {
		_project = project;

		_buildName = jsonObject.getString("buildName");
		_id = jsonObject.getLong("id");
		_jobName = jsonObject.getString("jobName");
		_state = State.get(jsonObject.getJSONObject("state"));
	}

	private final String _buildName;
	private final long _id;
	private String _jobName;
	private final Project _project;
	private State _state;

}