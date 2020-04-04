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

package com.liferay.jenkins.results.parser.spira;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseSpiraArtifact implements SpiraArtifact {

	public static int getArtifactTypeID(
		Class<? extends SpiraArtifact> spiraArtifactClass) {

		return (Integer)_getClassField(spiraArtifactClass, "ARTIFACT_TYPE_ID");
	}

	public static String getArtifactTypeName(
		Class<? extends SpiraArtifact> spiraArtifactClass) {

		return (String)_getClassField(spiraArtifactClass, "ARTIFACT_TYPE_NAME");
	}

	public static String getIDKey(
		Class<? extends SpiraArtifact> spiraArtifactClass) {

		return (String)_getClassField(spiraArtifactClass, "ID_KEY");
	}

	@Override
	public boolean equals(Object o) {
		if (!Objects.equals(getClass(), o.getClass())) {
			return false;
		}

		SpiraArtifact spiraArtifact = (SpiraArtifact)o;

		if (!(o instanceof SpiraProject)) {
			SpiraProject spiraProject = spiraArtifact.getSpiraProject();

			if (!spiraProject.equals(getSpiraProject())) {
				return false;
			}
		}

		if (spiraArtifact.getID() != getID()) {
			return false;
		}

		return true;
	}

	@Override
	public int getID() {
		return jsonObject.getInt(getIDKey(getClass()));
	}

	@Override
	public String getName() {
		return jsonObject.getString("Name");
	}

	@Override
	public SpiraProject getSpiraProject() {
		if (this instanceof SpiraProject) {
			return (SpiraProject)this;
		}

		return SpiraProject.getSpiraProjectByID(
			jsonObject.getInt(SpiraProject.ID_KEY));
	}

	@Override
	public int hashCode() {
		JSONObject jsonObject = toJSONObject();

		return jsonObject.hashCode();
	}

	@Override
	public JSONObject toJSONObject() {
		return jsonObject;
	}

	@Override
	public String toString() {
		return jsonObject.toString();
	}

	protected static void cacheSpiraArtifacts(
		List<? extends SpiraArtifact> spiraArtifacts,
		Class<? extends SpiraArtifact> spiraArtifactClass) {

		List<SpiraArtifact> cachedSpiraArtifacts = _spiraArtifactMap.get(
			spiraArtifactClass);

		for (SpiraArtifact spiraArtifact : spiraArtifacts) {
			if (cachedSpiraArtifacts == null) {
				cachedSpiraArtifacts = new ArrayList<>();

				_spiraArtifactMap.put(
					spiraArtifact.getClass(), cachedSpiraArtifacts);
			}

			if (cachedSpiraArtifacts.contains(spiraArtifact)) {
				continue;
			}

			boolean found = false;

			for (SpiraArtifact cachedSpiraArtifact : cachedSpiraArtifacts) {
				if (cachedSpiraArtifact.equals(spiraArtifact)) {
					found = true;

					break;
				}
			}

			if (found) {
				throw new RuntimeException("FOuND!");
			}

			cachedSpiraArtifacts.add(spiraArtifact);
		}
	}

	protected static <S extends SpiraArtifact> List<S> getSpiraArtifacts(
		Class<S> spiraArtifactClass,
		Supplier<List<JSONObject>> spiraArtifactRequest,
		Function<JSONObject, S> spiraArtifactCreator,
		SearchQuery.SearchParameter... searchParameters) {

		long start0 = System.currentTimeMillis();
		SearchQuery<S> searchQuery =
			(SearchQuery<S>)SearchQuery.getCachedSearchQuery(
				spiraArtifactClass, searchParameters);

		if (searchQuery != null) {
			printTime(spiraArtifactClass, "FULL_0", start0);

			return searchQuery.getSpiraArtifacts();
		}

		long start1 = System.currentTimeMillis();

		searchQuery = new SearchQuery<>(spiraArtifactClass, searchParameters);

		List<S> cachedSpiraArtifacts = _getCachedSpiraArtifacts(
			spiraArtifactClass);
		printTime(spiraArtifactClass, "getCacheArtifacts", start1);

		if (searchQuery.hasDistinctResult()) {
			printTime(
				spiraArtifactClass, "DISTINCT", System.currentTimeMillis());

			S distinctSpiraArtifact = null;

			long start2 = System.currentTimeMillis();

			for (S cachedSpiraArtifact : cachedSpiraArtifacts) {
				if (searchQuery.matches(cachedSpiraArtifact)) {
					distinctSpiraArtifact = cachedSpiraArtifact;

					break;
				}
			}

			printTime(spiraArtifactClass, "distinct0", start2);

			if (distinctSpiraArtifact == null) {
				JSONObject distinctJSONObject = null;

				long start3 = System.currentTimeMillis();

				for (JSONObject jsonObject : spiraArtifactRequest.get()) {
					if (searchQuery.matches(spiraArtifactClass, jsonObject)) {
						distinctJSONObject = jsonObject;

						break;
					}
				}

				printTime(spiraArtifactClass, "distinct1", start3);

				long start4 = System.currentTimeMillis();

				if (distinctJSONObject != null) {
					distinctSpiraArtifact = spiraArtifactCreator.apply(
						distinctJSONObject);
				}

				printTime(spiraArtifactClass, "distinct2", start4);
			}

			if (distinctSpiraArtifact == null) {
				printTime(spiraArtifactClass, "FULL_2", start0);

				return new ArrayList<>();
			}

			long start5 = System.currentTimeMillis();

			searchQuery.addSpiraArtifact(distinctSpiraArtifact);

			cacheSpiraArtifacts(
				Collections.singletonList(distinctSpiraArtifact),
				spiraArtifactClass);

			List<S> searchQuerySpiraArtifacts = searchQuery.getSpiraArtifacts();

			if (!searchQuerySpiraArtifacts.isEmpty()) {
				SearchQuery.cacheSearchQuery(searchQuery);
			}

			List<S> spiraArtifacts = searchQuery.getSpiraArtifacts();

			printTime(spiraArtifactClass, "getCacheEnd", start5);
			printTime(spiraArtifactClass, "FULL_3", start0);

			return spiraArtifacts;
		}

		if (spiraArtifactClass == SpiraTestCaseObject.class) {
			long fastStart = System.currentTimeMillis();

			boolean hasPathSearch = false;

			for (SearchQuery.SearchParameter searchParameter :
					searchParameters) {

				String searchParameterName = searchParameter.getName();

				if (searchParameterName.equals("Path")) {
					hasPathSearch = true;

					break;
				}
			}

			if (hasPathSearch) {
				for (S spiraArtifact : cachedSpiraArtifacts) {
					if (searchQuery.matches(spiraArtifact)) {
						searchQuery.addSpiraArtifact(spiraArtifact);
					}
				}

				List<S> searchQuerySpiraArtifacts =
					searchQuery.getSpiraArtifacts();

				if (!searchQuerySpiraArtifacts.isEmpty()) {
					SearchQuery.cacheSearchQuery(searchQuery);

					printTime(spiraArtifactClass, "FAST", fastStart);
					printTime(spiraArtifactClass, "FULL_3", start0);

					return searchQuerySpiraArtifacts;
				}
			}
		}

		long slowStart = System.currentTimeMillis();

		long requestMissingStart = System.currentTimeMillis();
		List<JSONObject> jsonObjects = spiraArtifactRequest.get();
		printTime(spiraArtifactClass, "SLOW_request", requestMissingStart);

		long findMatchStart = System.currentTimeMillis();

		for (JSONObject jsonObject : jsonObjects) {
			S spiraArtifact = _getCachedSpiraArtifact(
				spiraArtifactClass, jsonObject);

			if (spiraArtifact == null) {
				spiraArtifact = spiraArtifactCreator.apply(jsonObject);

				cacheSpiraArtifacts(
					Collections.singletonList(spiraArtifact),
					spiraArtifactClass);
			}

			if (searchQuery.matches(spiraArtifact)) {
				searchQuery.addSpiraArtifact(spiraArtifact);
			}
		}

		printTime(spiraArtifactClass, "SLOW_match", findMatchStart);

		long retrieveStart = System.currentTimeMillis();
		List<S> searchQuerySpiraArtifacts = searchQuery.getSpiraArtifacts();

		if (!searchQuerySpiraArtifacts.isEmpty()) {
			SearchQuery.cacheSearchQuery(searchQuery);
		}

		printTime(spiraArtifactClass, "SLOW_retrieve", retrieveStart);

		printTime(spiraArtifactClass, "SLOW", slowStart);

		if (spiraArtifactClass == SpiraTestCaseObject.class) {
			List<S> list = _getCachedSpiraArtifacts(spiraArtifactClass);

			System.out.println("\t\t- CACHE_COUNT: " + list.size());
		}

		printTime(spiraArtifactClass, "FULL_4", start0);

		cacheSpiraArtifacts(searchQuerySpiraArtifacts, spiraArtifactClass);

		return searchQuerySpiraArtifacts;
	}

	protected static void printTime(
		Class<? extends SpiraArtifact> spiraArtifactClass, String name,
		long start) {

		if (spiraArtifactClass != SpiraTestCaseObject.class) {
			return;
		}

		String tab = "";

		if (!name.startsWith("FULL")) {
			tab = "\t";
		}

		System.out.println(
			tab + "\t+ " + name + ": " +
				JenkinsResultsParserUtil.toDurationString(
					System.currentTimeMillis() - start));
	}

	protected static void removeCachedSpiraArtifacts(
		List<? extends SpiraArtifact> spiraArtifacts) {

		for (SpiraArtifact spiraArtifact : spiraArtifacts) {
			List<SpiraArtifact> cachedSpiraArtifacts = _spiraArtifactMap.get(
				spiraArtifact.getClass());

			if (cachedSpiraArtifacts == null) {
				cachedSpiraArtifacts = new ArrayList<>();

				_spiraArtifactMap.put(
					spiraArtifact.getClass(), cachedSpiraArtifacts);
			}

			List<SpiraArtifact> foundSpiraArtifacts = new ArrayList<>();

			for (SpiraArtifact cachedSpiraArtifact : cachedSpiraArtifacts) {
				if (spiraArtifact.equals(cachedSpiraArtifact)) {
					foundSpiraArtifacts.add(cachedSpiraArtifact);
				}
			}

			if (foundSpiraArtifacts.isEmpty()) {
				return;
			}

			cachedSpiraArtifacts.removeAll(foundSpiraArtifacts);
		}
	}

	protected static String toDateString(Calendar calendar) {
		return JenkinsResultsParserUtil.combine(
			"/Date(", String.valueOf(calendar.getTimeInMillis()), ")/");
	}

	protected BaseSpiraArtifact(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	protected boolean matches(SearchQuery.SearchParameter... searchParameters) {
		for (SearchQuery.SearchParameter searchParameter : searchParameters) {
			if (!searchParameter.matches(jsonObject)) {
				return false;
			}
		}

		return true;
	}

	protected final JSONObject jsonObject;

	private static <S extends SpiraArtifact> S _getCachedSpiraArtifact(
		Class<S> spiraArtifactClass, JSONObject jsonObject) {

		List<S> cachedSpiraArtifacts = _getCachedSpiraArtifacts(
			spiraArtifactClass);

		String idKey = getIDKey(spiraArtifactClass);

		for (S cachedSpiraArtifact : cachedSpiraArtifacts) {
			if (!jsonObject.similar(cachedSpiraArtifact.toJSONObject())) {
				continue;
			}

			if (jsonObject.getInt(idKey) != cachedSpiraArtifact.getID()) {
				System.out.println("CACHE____1");

				continue;
			}

			return cachedSpiraArtifact;
		}

		return null;
	}

	private static <S extends SpiraArtifact> List<S> _getCachedSpiraArtifacts(
		Class<S> spiraArtifactClass) {

		List<SpiraArtifact> spiraArtifacts = _spiraArtifactMap.get(
			spiraArtifactClass);

		if (spiraArtifacts == null) {
			spiraArtifacts = new ArrayList<>();

			_spiraArtifactMap.put(spiraArtifactClass, spiraArtifacts);
		}

		return (List<S>)spiraArtifacts;
	}

	private static Object _getClassField(
		Class<? extends SpiraArtifact> spiraArtifactClass, String fieldName) {

		try {
			Field field = spiraArtifactClass.getDeclaredField(fieldName);

			return field.get(fieldName);
		}
		catch (IllegalAccessException | IllegalArgumentException |
			   NoSuchFieldException exception) {

			throw new RuntimeException(
				"Missing field " + fieldName + " in " +
					spiraArtifactClass.getName(),
				exception);
		}
	}

	private static final Map<Class<?>, List<SpiraArtifact>> _spiraArtifactMap =
		new HashMap<>();

}