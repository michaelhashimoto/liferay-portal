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

package com.liferay.jenkins.results.parser;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author Peter Yoo
 */
public class OfflineJenkinsSlaveUtility {

	public static String getGroovyScript(
		String compare, int slaveNumber, boolean offlineBoolean,
		String offlineReason) {

		Class<?> clazz = OfflineJenkinsSlaveUtility.class;

		try {
			String script = JenkinsResultsParserUtil.readInputStream(
				clazz.getResourceAsStream(
					"/OfflineJenkinsSlavesUtility.groovy"));

			script = script.replace("${compare}", compare);
			script = script.replace("${number}", String.valueOf(slaveNumber));
			script = script.replace(
				"${offlineBoolean}", String.valueOf(offlineBoolean));
			script = script.replace("${offlineReason}", offlineReason);

			return script;
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	public static void main(String[] args) {
		final String script = getGroovyScript(
			"<=", 35, true, "Upgrading to Jenkins slave image version 1.0.26");

		System.out.println("SCRIPT: \n" + script);

		List<Callable<Object>> callables = new ArrayList<>(
			_jenkinsMasterNames.size());

		for (final String jenkinsMasterName : _jenkinsMasterNames) {
			Callable<Object> callable = new Callable<Object>() {

				@Override
				public Object call() throws Exception {
					System.out.println(
						"Executing groovy script on " + jenkinsMasterName);

					JenkinsResultsParserUtil.executeJenkinsScript(
						jenkinsMasterName, script);

					System.out.println(jenkinsMasterName + " FINISHED");

					return null;
				}

			};

			callables.add(callable);
		}

		ParallelExecutor<Object> parallelExecutor = new ParallelExecutor<>(
			callables,
			JenkinsResultsParserUtil.getNewThreadPoolExecutor(
				_jenkinsMasterNames.size(), true));

		parallelExecutor.execute();
	}

	private static final List<String> _jenkinsMasterNames = Arrays.asList(
		"test-1-1", "test-1-2", "test-1-3", "test-1-4", "test-1-5", "test-1-6",
		"test-1-7", "test-1-8", "test-1-9", "test-1-10", "test-1-11",
		"test-1-12", "test-1-13", "test-1-14", "test-1-15", "test-1-16",
		"test-1-17", "test-1-18", "test-1-19", "test-1-20", "test-1-21",
		"test-1-22", "test-1-23", "test-1-24", "test-1-25");

}