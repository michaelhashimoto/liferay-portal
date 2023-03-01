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

package com.liferay.jethr0.project.comparator;

import com.liferay.jethr0.object.ObjectDALO;
import com.liferay.jethr0.project.prioritizer.ProjectPrioritizer;
import com.liferay.jethr0.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import org.springframework.context.annotation.Configuration;

/**
 * @author Michael Hashimoto
 */
@Configuration
public class ProjectComparatorDALO extends ObjectDALO {

	public ProjectComparator createProjectComparator(
		ProjectPrioritizer projectPrioritizer, int position,
		ProjectComparator.Type type, String value) {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("position", position);
		jsonObject.put(
			"r_projectPrioritizerToProjectComparators_c_projectPrioritizerId",
			projectPrioritizer.getID());
		jsonObject.put("type", type.getJSONObject());
		jsonObject.put("value", value);

		return new DefaultProjectComparator(
			projectPrioritizer, create(jsonObject));
	}

	public void deleteProjectComparator(ProjectComparator projectComparator) {
		if (projectComparator == null) {
			return;
		}

		delete(projectComparator.getID());
	}

	public List<ProjectComparator> retrieveProjectComparators(
		ProjectPrioritizer projectPrioritizer) {

		List<ProjectComparator> projectComparators = new ArrayList<>();

		String objectURLPath = StringUtil.combine(
			"/o/c/projectprioritizers/",
			String.valueOf(projectPrioritizer.getID()),
			"/projectPrioritizerToProjectComparators");

		for (JSONObject jsonObject : retrieve(objectURLPath)) {
			projectComparators.add(
				new DefaultProjectComparator(projectPrioritizer, jsonObject));
		}

		return projectComparators;
	}

	public ProjectComparator updateProjectComparator(
		ProjectComparator projectComparator) {

		ProjectPrioritizer projectPrioritizer =
			projectComparator.getProjectPrioritizer();
		ProjectComparator.Type type = projectComparator.getType();

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("id", projectComparator.getID());
		jsonObject.put("position", projectComparator.getPosition());
		jsonObject.put(
			"r_projectPrioritizerToProjectComparators_c_projectPrioritizerId",
			projectPrioritizer.getID());
		jsonObject.put("type", type.getJSONObject());
		jsonObject.put("value", projectComparator.getValue());

		return new DefaultProjectComparator(
			projectComparator.getProjectPrioritizer(), update(jsonObject));
	}

	@Override
	protected String getObjectLabel() {
		return "Project Comparator";
	}

	@Override
	protected String getObjectURLPath() {
		return "/o/c/projectcomparators";
	}

}