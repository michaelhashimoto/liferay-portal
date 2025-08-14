/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Peter Yoo
 */
public class EnvironmentBuildPropertiesUtil {

	public static void generateEnvironmentBuildProperties(
			EnvironmentBuildProperties.Environment environment,
			File rootDirectory)
		throws IOException {

		List<File> sharedPropertiesFiles = JenkinsResultsParserUtil.findFiles(
			rootDirectory, ".*-shared\\.properties");

		for (File sharedPropertiesFile : sharedPropertiesFiles) {
			String sharedPropertiesFileName = sharedPropertiesFile.getName();

			File environmentBuildPropertiesFile = new File(
				sharedPropertiesFile.getParentFile(),
				_getBasePropertiesFileName(sharedPropertiesFileName));

			String urlString = EnvironmentBuildProperties.toURLString(
				environmentBuildPropertiesFile);

			EnvironmentBuildProperties environmentBuildProperties =
				new EnvironmentBuildProperties(environment, urlString);

			environmentBuildProperties.store(environmentBuildPropertiesFile);
		}
	}

	public static void main(String[] args) throws Exception {
		EnvironmentBuildProperties.Environment environment =
			EnvironmentBuildProperties.Environment.AWS;

		EnvironmentBuildProperties ebp = new EnvironmentBuildProperties(
			environment,
			EnvironmentBuildProperties.toURLString(
				new File(
					"/Users/pyoo/dev/liferay-jenkins-ee/dev/commands",
					"build.properties")),
			false);

		Properties properties = new Properties();

		properties.load(
			new StringReader(
				JenkinsResultsParserUtil.toString(
					"https://raw.githubusercontent.com/liferay" +
						"/liferay-jenkins-ee/refs/heads/" +
							environment.getBranchName() +
								"/commands/build.properties")));

		if (Objects.equals(ebp, properties)) {
			System.out.println("Equal");
		}
		else {
			System.out.println("NOT equal");

			printDifferences(ebp, properties, "ebp", "upstream");
		}
	}

	public static void printDifferences(
		Properties properties1, Properties properties2, String name1,
		String name2) {

		if (properties1.size() != properties2.size()) {
			System.out.println(name1 + " size: " + properties1.size());
			System.out.println(name2 + " size: " + properties2.size());
		}

		Set<String> keys1 = properties1.stringPropertyNames();
		Set<String> keys2 = properties2.stringPropertyNames();

		List<String> unique1 = keys1.stream(
		).filter(
			key -> !keys2.contains(key)
		).collect(
			Collectors.toList()
		);

		Collections.sort(unique1);

		List<String> unique2 = keys2.stream(
		).filter(
			key -> !keys1.contains(key)
		).collect(
			Collectors.toList()
		);

		Collections.sort(unique2);

		if (!unique1.isEmpty()) {
			System.out.println("Unique keys in " + name1 + " properties");

			for (String unique : unique1) {
				System.out.println(unique);
			}

			System.out.println("\n");
		}

		if (!unique2.isEmpty()) {
			System.out.println("Unique keys in " + name2 + " properties");

			for (String unique : unique2) {
				System.out.println(unique);
			}
		}

		Set<String> commonKeys = new HashSet<>();

		commonKeys.addAll(keys1);
		commonKeys.addAll(keys2);
		commonKeys.removeAll(unique1);
		commonKeys.removeAll(unique2);

		for (String key : commonKeys) {
			if (!Objects.equals(
					properties1.getProperty(key),
					properties2.getProperty(key))) {

				System.out.println("\nProperty key: " + key);
				System.out.println(
					name1 + " value: " + properties1.getProperty(key));
				System.out.println(
					name2 + " value: " + properties2.getProperty(key));
			}
		}
	}

	private static String _getBasePropertiesFileName(
		String extendedPropertiesFileName) {

		Matcher matcher = _extendedPropertyFileNamePattern.matcher(
			extendedPropertiesFileName);

		if (!matcher.matches()) {
			throw new RuntimeException(
				"Unable to parse property file name " +
					extendedPropertiesFileName);
		}

		return matcher.group(1) + matcher.group(3);
	}

	private static final Pattern _extendedPropertyFileNamePattern =
		Pattern.compile("(.+)(-.+)\\.(properties)");

	private static class PropertiesFilesMap extends HashMap<String, File> {

		public PropertiesFilesMap(File rootDirectory) throws IOException {
			_rootDirectory = rootDirectory;

			List<File> propertiesFiles = JenkinsResultsParserUtil.findFiles(
				rootDirectory, ".*\\.properties");

			String gitRepositoryDirPath = rootDirectory.getCanonicalPath();

			for (File propertiesFile : propertiesFiles) {
				String path = propertiesFile.getCanonicalPath();

				path = path.substring(gitRepositoryDirPath.length());

				put(path, propertiesFile);
			}
		}

		@Override
		public boolean equals(Object object) {
			if (!(object instanceof PropertiesFilesMap)) {
				return false;
			}

			PropertiesFilesMap otherPropertiesFilesMap =
				(PropertiesFilesMap)object;

			if (size() != otherPropertiesFilesMap.size()) {
				return false;
			}

			for (String key : keySet()) {
				if (!otherPropertiesFilesMap.containsKey(key)) {
					return false;
				}

				try {
					String fileContents = getFileContents(key);
					String otherFileContents =
						otherPropertiesFilesMap.getFileContents(key);

					if (!Objects.equals(fileContents, otherFileContents)) {
						return false;
					}
				}
				catch (IOException ioException) {
					return false;
				}
			}

			return true;
		}

		public String getFileContents(String key) throws IOException {
			return JenkinsResultsParserUtil.read(get(key));
		}

		@Override
		public int hashCode() {
			return Objects.hash(keySet().toArray());
		}

		private final File _rootDirectory;

	}

}