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

package com.liferay.jethr0.project;

import com.liferay.jethr0.object.ObjectDALO;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import org.springframework.context.annotation.Configuration;

/**
 * @author Michael Hashimoto
 */
@Configuration
public class ProjectDALO extends ObjectDALO {

	public Project createProject(
		String name, int priority, Project.State state, Project.Type type) {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("name", name);
		jsonObject.put("priority", priority);
		jsonObject.put("state", state.getJSONObject());
		jsonObject.put("type", type.getJSONObject());

		return new DefaultProject(create(jsonObject));
	}

	public void deleteProject(Project project) {
		if (project == null) {
			return;
		}

		delete(project.getID());
	}

	public List<Project> retrieveProjects() {
		List<Project> projects = new ArrayList<>();

		for (JSONObject jsonObject : retrieve()) {
			projects.add(new DefaultProject(jsonObject));
		}

		return projects;
	}

	public Project updateProject(Project project) {
		JSONObject jsonObject = new JSONObject();

		Project.State state = project.getState();
		Project.Type type = project.getType();

		jsonObject.put("id", project.getID());
		jsonObject.put("name", project.getName());
		jsonObject.put("priority", project.getPriority());
		jsonObject.put("state", state.getJSONObject());
		jsonObject.put("type", type.getJSONObject());

		return new DefaultProject(update(jsonObject));
	}

	@Override
	protected String getObjectLabel() {
		return "Project";
	}

	@Override
	protected String getObjectURLPath() {
		return "/o/c/projects";
	}

}