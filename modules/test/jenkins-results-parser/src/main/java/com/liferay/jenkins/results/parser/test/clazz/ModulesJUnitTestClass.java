package com.liferay.jenkins.results.parser.test.clazz;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.test.clazz.group.BatchTestClassGroup;

import java.io.File;

import org.json.JSONObject;

public class ModulesJUnitTestClass extends JUnitTestClass {

	public File getModuleDir() {
		String testClassFilePath = JenkinsResultsParserUtil.getCanonicalPath(
			getTestClassFile());

		int x = testClassFilePath.indexOf("/src/test");

		return new File(testClassFilePath.substring(0, x));
	}

	protected ModulesJUnitTestClass(
		BatchTestClassGroup batchTestClassGroup, File testClassFile) {

		super(batchTestClassGroup, testClassFile);
	}

	protected ModulesJUnitTestClass(
		BatchTestClassGroup batchTestClassGroup, JSONObject jsonObject) {

		super(batchTestClassGroup, jsonObject);
	}

}