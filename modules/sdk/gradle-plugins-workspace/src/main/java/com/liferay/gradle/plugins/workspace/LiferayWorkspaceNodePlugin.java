/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.gradle.plugins.workspace;

import aQute.bnd.version.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.gradle.plugins.node.NodeExtension;
import com.liferay.gradle.plugins.node.NodePlugin;
import com.liferay.gradle.plugins.node.task.PackageRunTestTask;
import com.liferay.gradle.plugins.workspace.internal.util.GradleUtil;
import com.liferay.gradle.plugins.workspace.internal.util.StringUtil;
import com.liferay.gradle.util.Validator;
import com.liferay.release.util.ResourceUtil;

import java.io.File;

import java.nio.file.Path;

import java.time.temporal.ChronoUnit;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.gradle.api.Action;
import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.logging.Logger;
import org.gradle.api.tasks.TaskContainer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author Drew Brokke
 * @author Simon Jiang
 */
public class LiferayWorkspaceNodePlugin implements Plugin<Project> {

	public static final Plugin<Project> INSTANCE =
		new LiferayWorkspaceNodePlugin();

	public static final String NODE_LTS_PROPERTY_NAME =
		WorkspacePlugin.PROPERTY_PREFIX + "node.lts.codename";

	@Override
	public void apply(Project project) {
		GradleUtil.applyPlugin(project, NodePlugin.class);

		_configureLTS(project);

		_configureTasksPackageRunTest(project);
	}

	private LiferayWorkspaceNodePlugin() {
		int maxAge = 7;

		String refreshNodeReleases = System.getProperty(
			"liferay.workspace.refresh.node.releases");

		if (refreshNodeReleases != null) {
			maxAge = 0;
		}

		File nodeCacheDir = new File(
			System.getProperty("user.home"), ".liferay/node");

		File indexJsonFile = new File(nodeCacheDir, "index.json");

		_nodeInfos = ResourceUtil.readJSON(
			NodeInfos.class,
			ResourceUtil.getLocalFileResolver(
				indexJsonFile, maxAge, ChronoUnit.DAYS),
			ResourceUtil.getURLResolver(
				nodeCacheDir, "https://nodejs.org/dist/index.json"),
			ResourceUtil.getLocalFileResolver(indexJsonFile),
			ResourceUtil.getClassLoaderResolver("/.node_info.json"));

		if (_nodeInfos == null) {
			throw new GradleException(
				"Unable to read Node release information");
		}
	}

	private void _configureLTS(Project project) {
		_getLTSNodeInfoOptional(
			project
		).ifPresent(
			nodeInfo -> {
				NodeExtension nodeExtension = GradleUtil.getExtension(
					project, NodeExtension.class);

				String nodeVersion = nodeInfo.getNodeVersion();
				String npmVersion = nodeInfo.getNpmVersion();

				Logger logger = project.getLogger();

				if (logger.isInfoEnabled()) {
					String lts = nodeInfo.getLts();

					logger.info(
						"Using {} LTS Node version: {}", StringUtil.quote(lts),
						nodeVersion);
					logger.info(
						"Using {} LTS NPM version: {}", StringUtil.quote(lts),
						npmVersion);
				}

				nodeExtension.setNodeVersion(nodeVersion);
				nodeExtension.setNpmVersion(npmVersion);
			}
		);
	}

	private void _configureTasksPackageRunTest(Project project) {
		TaskContainer taskContainer = project.getTasks();

		taskContainer.withType(
			PackageRunTestTask.class,
			new Action<PackageRunTestTask>() {

				@Override
				public void execute(PackageRunTestTask packageRunTestTask) {
					packageRunTestTask.doLast(
						new Action<Task>() {

							@Override
							public void execute(Task task) {
								_writeCITestResults(task.getProject());
							}

						});
				}

			});
	}

	private String _getLts(Project project) {
		return GradleUtil.getProperty(
			project, NODE_LTS_PROPERTY_NAME, (String)null);
	}

	private Optional<NodeInfo> _getLTSNodeInfoOptional(Project project) {
		String lts = _getLts(project);

		if (Validator.isNull(lts)) {
			return Optional.empty();
		}

		Optional<NodeInfo> nodeInfoOptional = _nodeInfos.stream(
		).filter(
			nodeInfo -> Objects.equals(nodeInfo.getLts(), lts)
		).max(
			(first, second) -> {
				Version firstVersion = Version.parseVersion(
					first.getNodeVersion());
				Version secondVersion = Version.parseVersion(
					second.getNodeVersion());

				return firstVersion.compareTo(secondVersion);
			}
		);

		if (!nodeInfoOptional.isPresent()) {
			Logger logger = project.getLogger();

			if (logger.isErrorEnabled()) {
				logger.error(
					"Property {} must be one of: {}",
					StringUtil.quote(NODE_LTS_PROPERTY_NAME),
					_nodeInfos.stream(
					).map(
						NodeInfo::getLts
					).distinct(
					).filter(
						nodeInfoLts -> !Objects.equals(nodeInfoLts, "false")
					).sorted(
					).collect(
						Collectors.joining(", ")
					));
			}
		}

		return nodeInfoOptional;
	}

	private String _getPackageName(Project project) {
		File projectDir = project.getProjectDir();

		return _getRelativePath(_getRepositoryDir(project), projectDir);
	}

	private String _getRelativePath(File dir, File file) {
		Path dirPath = dir.toPath();

		String relativePath = String.valueOf(dirPath.relativize(file.toPath()));

		return relativePath.replace(File.separatorChar, '/');
	}

	private File _getRepositoryDir(Project project) {
		File dir = project.getProjectDir();

		while (dir != null) {
			File gitFile = new File(dir, ".git");

			if (gitFile.exists()) {
				return dir;
			}

			dir = dir.getParentFile();
		}

		return project.getRootDir();
	}

	private String _getTestClassName(Project project, String testSuiteName) {
		File testFile = new File(project.getProjectDir(), testSuiteName);

		return _getRelativePath(_getRepositoryDir(project), testFile);
	}

	private boolean _isTestFileName(String testSuiteName) {
		if ((testSuiteName == null) || !testSuiteName.contains(".")) {
			return false;
		}

		if (testSuiteName.contains("/") || testSuiteName.endsWith(".js") ||
			testSuiteName.endsWith(".jsx") || testSuiteName.endsWith(".ts") ||
			testSuiteName.endsWith(".tsx")) {

			return true;
		}

		return false;
	}

	private void _writeCITestResults(Project project) {
		File file = new File(project.getProjectDir(), _TEST_RESULTS_FILE_NAME);

		if (!file.exists()) {
			return;
		}

		try {
			DocumentBuilderFactory documentBuilderFactory =
				DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder =
				documentBuilderFactory.newDocumentBuilder();

			Document document = documentBuilder.parse(file);

			NodeList testSuiteNodeList = document.getElementsByTagName(
				"testsuite");

			boolean modified = false;

			for (int i = 0; i < testSuiteNodeList.getLength(); i++) {
				Element testSuiteElement = (Element)testSuiteNodeList.item(i);

				String testSuiteName = testSuiteElement.getAttribute("name");

				if (!_isTestFileName(testSuiteName)) {
					continue;
				}

				testSuiteElement.setAttribute(
					"package", _getPackageName(project));

				String testClassName = _getTestClassName(
					project, testSuiteName);

				NodeList testCaseNodeList =
					testSuiteElement.getElementsByTagName("testcase");

				for (int j = 0; j < testCaseNodeList.getLength(); j++) {
					Element testCaseElement = (Element)testCaseNodeList.item(j);

					testCaseElement.setAttribute("classname", testClassName);

					modified = true;
				}
			}

			if (!modified) {
				return;
			}

			TransformerFactory transformerFactory =
				TransformerFactory.newInstance();

			Transformer transformer = transformerFactory.newTransformer();

			transformer.transform(
				new DOMSource(document),
				new StreamResult(
					new File(
						project.getProjectDir(), _CI_TEST_RESULTS_FILE_NAME)));
		}
		catch (Exception exception) {
			Logger logger = project.getLogger();

			if (logger.isWarnEnabled()) {
				logger.warn("Unable to write CI test results", exception);
			}
		}
	}

	private static final String _CI_TEST_RESULTS_FILE_NAME =
		"CI_TEST-frontend-js.xml";

	private static final String _TEST_RESULTS_FILE_NAME =
		"TEST-frontend-js.xml";

	private final NodeInfos _nodeInfos;

	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class NodeInfo {

		public String getLts() {
			return _lts;
		}

		public String getNodeVersion() {
			return _nodeVersion.substring(1);
		}

		public String getNpmVersion() {
			return _npmVersion;
		}

		@JsonProperty("lts")
		private String _lts;

		@JsonProperty("version")
		private String _nodeVersion;

		@JsonProperty("npm")
		private String _npmVersion;

	}

	private static class NodeInfos extends ArrayList<NodeInfo> {
	}

}