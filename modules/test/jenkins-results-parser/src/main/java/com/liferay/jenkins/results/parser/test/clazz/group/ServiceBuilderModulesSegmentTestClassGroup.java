/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.test.clazz.ServiceBuilderAntTargetTestClass;
import com.liferay.jenkins.results.parser.test.clazz.TestClass;
import com.liferay.jenkins.results.parser.test.clazz.TestClassMethod;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class ServiceBuilderModulesSegmentTestClassGroup
	extends ModulesSegmentTestClassGroup {

	@Override
	public String getTestCasePropertiesContent() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.getTestCasePropertiesContent());

		ServiceBuilderModulesBatchTestClassGroup.BuildType buildType =
			_serviceBuilderModulesBatchTestClassGroup.getBuildType();

		if (buildType !=
				ServiceBuilderModulesBatchTestClassGroup.BuildType.CORE) {

			sb.append("SKIP_SERVICE_BUILDER_CORE=true\n");
		}

		if (buildType !=
				ServiceBuilderModulesBatchTestClassGroup.BuildType.FULL) {

			sb.append("SKIP_SERVICE_BUILDER_FULL=true\n");
		}

		return sb.toString();
	}

	protected ServiceBuilderModulesSegmentTestClassGroup(
		BatchTestClassGroup batchTestClassGroup) {

		super(batchTestClassGroup);

		if (!(batchTestClassGroup instanceof
				ServiceBuilderModulesBatchTestClassGroup)) {

			throw new RuntimeException("Invalid parent batch test class group");
		}

		_serviceBuilderModulesBatchTestClassGroup =
			(ServiceBuilderModulesBatchTestClassGroup)batchTestClassGroup;
	}

	protected ServiceBuilderModulesSegmentTestClassGroup(
		BatchTestClassGroup batchTestClassGroup, JSONObject jsonObject) {

		super(batchTestClassGroup, jsonObject);

		if (!(batchTestClassGroup instanceof
				ServiceBuilderModulesBatchTestClassGroup)) {

			throw new RuntimeException("Invalid parent batch test class group");
		}

		_serviceBuilderModulesBatchTestClassGroup =
			(ServiceBuilderModulesBatchTestClassGroup)batchTestClassGroup;
	}

	@Override
	protected String getTestTaskNames(int axisIndex) {
		StringBuilder sb = new StringBuilder();

		AxisTestClassGroup axisTestClassGroup = getAxisTestClassGroup(
			axisIndex);

		for (TestClass testClass : axisTestClassGroup.getTestClasses()) {
			if (testClass instanceof ServiceBuilderAntTargetTestClass) {
				continue;
			}

			for (TestClassMethod testClassMethod :
					testClass.getTestClassMethods()) {

				sb.append(testClassMethod.getName());
				sb.append(",");
			}
		}

		if (!sb.isEmpty()) {
			sb.setLength(sb.length() - 1);
		}

		return sb.toString();
	}

	private final ServiceBuilderModulesBatchTestClassGroup
		_serviceBuilderModulesBatchTestClassGroup;

}