package com.liferay.jethr0.project.comparator;

import com.liferay.jethr0.project.Project;
import com.liferay.jethr0.project.prioritizer.ProjectPrioritizer;
import org.json.JSONObject;

import java.util.Date;

public class PriorityProjectComparator extends BaseProjectComparator {

	@Override
	public int compare(Project project1, Project project2) {
		return Integer.compare(project1.getPriority(), project2.getPriority());
	}

	protected PriorityProjectComparator(
		ProjectPrioritizer projectPrioritizer, JSONObject jsonObject) {

		super(projectPrioritizer, jsonObject);
	}

}