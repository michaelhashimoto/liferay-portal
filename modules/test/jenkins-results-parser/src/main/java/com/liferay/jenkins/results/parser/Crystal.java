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

import com.liferay.jenkins.results.parser.test.clazz.FunctionalTestClass;
import com.liferay.jenkins.results.parser.test.clazz.JUnitTestClass;
import com.liferay.jenkins.results.parser.test.clazz.TestClass;
import com.liferay.jenkins.results.parser.test.clazz.TestClassMethod;
import com.liferay.jenkins.results.parser.test.clazz.group.AxisTestClassGroup;
import com.liferay.jenkins.results.parser.test.clazz.group.BatchTestClassGroup;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class Crystal {

	public static Job asahPullRequest() {
		String jobName = "test-subrepository-acceptance-pullrequest(7.0.x)";
		String testSuiteName = "analytics-cloud-acceptance";
		String repositoryName = "com-liferay-osb-asah-private";
		Job.BuildProfile buildProfile = Job.BuildProfile.DXP;
		String portalUpstreamBranchName = "master";
		String upstreamBranchName = "7.0.x";

		return JobFactory.newJob(
			buildProfile, jobName, null, null, portalUpstreamBranchName, null,
			repositoryName, testSuiteName, upstreamBranchName);
	}

	public static Job faroPullRequest() {
		String jobName = "test-subrepository-acceptance-pullrequest(7.1.x)";
		String testSuiteName = "analytics-cloud-acceptance";
		String upstreamBranchName = "7.1.x";
		String repositoryName = "com-liferay-osb-faro-private";
		Job.BuildProfile buildProfile = Job.BuildProfile.DXP;
		String portalUpstreamBranchName = "master";

		//Job.BuildProfile buildProfile,
		//String jobName,
		//JSONObject jsonObject,
		//PortalGitWorkingDirectory portalGitWorkingDirectory,
		//String portalUpstreamBranchName,
		//List<String> projectNames,
		//String repositoryName,
		//String testSuiteName,
		//String upstreamBranchName

		return JobFactory.newJob(
			buildProfile, jobName, null, null, portalUpstreamBranchName, null,
			repositoryName, testSuiteName, upstreamBranchName);
	}

	public static void main(String[] args) throws Exception {
		long start0 = System.currentTimeMillis();
		Build build = BuildFactory.newBuild(
			"https://test-5-2.liferay.com/job/test-portal-acceptance-" +
				"pullrequest(master)/852/",
			null);
		long duration0 = System.currentTimeMillis() - start0;

		long start1 = System.currentTimeMillis();

		//build.getConsoleText();
		//System.out.println(build.getBuildURL());
		//
		//for (Build batchBuild : build.getDownstreamBuilds(null)) {
		//	batchBuild.getConsoleText();
		//	System.out.println(batchBuild.getBuildURL());
		//
		//	for (Build axisBuild : batchBuild.getDownstreamBuilds(null)) {
		//		axisBuild.getConsoleText();
		//		System.out.println(axisBuild.getBuildURL());
		//	}
		//}

		long duration1 = System.currentTimeMillis() - start1;

		long start2 = System.currentTimeMillis();

		build.archive();

		long duration2 = System.currentTimeMillis() - start2;

		long start3 = System.currentTimeMillis();
		//if (build instanceof TopLevelBuild) {
		//	TopLevelBuild topLevelBuild = (TopLevelBuild)build;

		//
		//	topLevelBuild.getJenkinsReportElement();
		//}
		long duration3 = System.currentTimeMillis() - start3;

		long start4 = System.currentTimeMillis();

		build.getConsoleText();

		System.out.println(build.getBuildURL());

		for (Build batchBuild : build.getDownstreamBuilds(null)) {
			batchBuild.getConsoleText();

			System.out.println(batchBuild.getBuildURL());

			for (Build axisBuild : batchBuild.getDownstreamBuilds(null)) {
				axisBuild.getConsoleText();

				System.out.println(axisBuild.getBuildURL());
			}
		}

		long duration4 = System.currentTimeMillis() - start4;

		System.out.println(
			JenkinsResultsParserUtil.combine(
				"Created build in ",
				JenkinsResultsParserUtil.toDurationString(duration0)));

		System.out.println(
			JenkinsResultsParserUtil.combine(
				"Get Console Output in ",
				JenkinsResultsParserUtil.toDurationString(duration1)));

		System.out.println(
			JenkinsResultsParserUtil.combine(
				"Archived build in ",
				JenkinsResultsParserUtil.toDurationString(duration2)));

		System.out.println(
			JenkinsResultsParserUtil.combine(
				"Jenkins Report build in ",
				JenkinsResultsParserUtil.toDurationString(duration3)));

		System.out.println(
			JenkinsResultsParserUtil.combine(
				"Get Console Output in ",
				JenkinsResultsParserUtil.toDurationString(duration4)));

		//Build upstreamBuild = BuildFactory.newBuild(
		//	"https://test-5-1.liferay.com/job/test-portal-testsuite-" +
		//		"upstream(master)/1663/",
		//	null);
		//
		//for (Build build : upstreamBuild.getDownstreamBuilds(null)) {
		//	System.out.println(build.getBuildURL());
		//}

		//System.out.println("***********************************************");
		//start = JenkinsResultsParserUtil.getCurrentTimeMillis();
		//testJob(portalRelease());
		//System.out.println(
		//	JenkinsResultsParserUtil.toDurationString(
		//		JenkinsResultsParserUtil.getCurrentTimeMillis() - start));
		//System.out.println("***********************************************");
		//start = JenkinsResultsParserUtil.getCurrentTimeMillis();
		//testJob(portalReleaseTomcat());
		//System.out.println(
		//	JenkinsResultsParserUtil.toDurationString(
		//		JenkinsResultsParserUtil.getCurrentTimeMillis() - start));
		//System.out.println("***********************************************");
		//start = JenkinsResultsParserUtil.getCurrentTimeMillis();
		//testJob(portalReleaseSmoke());
		//System.out.println(
		//	JenkinsResultsParserUtil.toDurationString(
		//		JenkinsResultsParserUtil.getCurrentTimeMillis() - start));
		//System.out.println("***********************************************");
		//start = JenkinsResultsParserUtil.getCurrentTimeMillis();
		//testJob(portalPullRequest());
		//System.out.println(
		//	JenkinsResultsParserUtil.toDurationString(
		//		JenkinsResultsParserUtil.getCurrentTimeMillis() - start));
		//System.out.println("***********************************************");
		//start = JenkinsResultsParserUtil.getCurrentTimeMillis();
		//testJob(portalPullRequestRelevant());
		//System.out.println(
		//	JenkinsResultsParserUtil.toDurationString(
		//		JenkinsResultsParserUtil.getCurrentTimeMillis() - start));
		//System.out.println("***********************************************");
		//start = JenkinsResultsParserUtil.getCurrentTimeMillis();
		//testJob(portalPullRequestSmoke());
		//System.out.println(
		//	JenkinsResultsParserUtil.toDurationString(
		//		JenkinsResultsParserUtil.getCurrentTimeMillis() - start));
		//System.out.println("***********************************************");
		//start = JenkinsResultsParserUtil.getCurrentTimeMillis();
		//testJob(qaWebsites());
		//System.out.println(
		//	JenkinsResultsParserUtil.toDurationString(
		//		JenkinsResultsParserUtil.getCurrentTimeMillis() - start));
		//System.out.println("***********************************************");
		//start = JenkinsResultsParserUtil.getCurrentTimeMillis();
		//testJob(faroPullRequest());
		//System.out.println(
		//	JenkinsResultsParserUtil.toDurationString(
		//		JenkinsResultsParserUtil.getCurrentTimeMillis() - start));
		//System.out.println("***********************************************");
		//start = JenkinsResultsParserUtil.getCurrentTimeMillis();
		//testJob(asahPullRequest());
		//System.out.println(
		//	JenkinsResultsParserUtil.toDurationString(
		//		JenkinsResultsParserUtil.getCurrentTimeMillis() - start));
		//System.out.println("***********************************************");
		//start = JenkinsResultsParserUtil.getCurrentTimeMillis();
		//testJob(portalHotfix());
		//System.out.println(
		//	JenkinsResultsParserUtil.toDurationString(
		//		JenkinsResultsParserUtil.getCurrentTimeMillis() - start));
		//System.out.println("***********************************************");
	}

	public static Job portalHotfix() throws Exception {
		Build build = BuildFactory.newBuild(
			"https://test-5-1.liferay.com/job/test-portal-hotfix-release/370/",
			null);

		return build.getJob();
	}

	public static Job portalPullRequest() throws Exception {
		String jobName = "test-portal-acceptance-pullrequest(master)";
		String testSuiteName = "stable";
		String upstreamBranchName = "master";
		String repositoryName = "liferay-portal";
		Job.BuildProfile buildProfile = Job.BuildProfile.DXP;

		return JobFactory.newJob(
			buildProfile, jobName, null, null, null, null, repositoryName,
			testSuiteName, upstreamBranchName);
	}

	public static Job portalPullRequestRelevant() throws Exception {
		String jobName = "test-portal-acceptance-pullrequest(master)";
		String testSuiteName = "relevant";
		String upstreamBranchName = "master";
		String repositoryName = "liferay-portal";
		Job.BuildProfile buildProfile = Job.BuildProfile.DXP;

		return JobFactory.newJob(
			buildProfile, jobName, null, null, null, null, repositoryName,
			testSuiteName, upstreamBranchName);
	}

	public static Job portalPullRequestSmoke() throws Exception {
		String jobName = "test-portal-acceptance-pullrequest(master)";
		String testSuiteName = "smoke";
		String upstreamBranchName = "master";
		String repositoryName = "liferay-portal";
		Job.BuildProfile buildProfile = Job.BuildProfile.DXP;

		return JobFactory.newJob(
			buildProfile, jobName, null, null, null, null, repositoryName,
			testSuiteName, upstreamBranchName);
	}

	public static Job portalRelease() throws Exception {
		String jobName = "test-portal-release";
		String testSuiteName = "portal-release";
		String upstreamBranchName = "master";
		String repositoryName = "liferay-portal";
		Job.BuildProfile buildProfile = Job.BuildProfile.DXP;

		return JobFactory.newJob(
			buildProfile, jobName, null, null, null, null, repositoryName,
			testSuiteName, upstreamBranchName);
	}

	public static Job portalReleaseSmoke() throws Exception {
		String jobName = "test-portal-release";
		String testSuiteName = "portal-release-smoke";
		String upstreamBranchName = "master";
		String repositoryName = "liferay-portal";
		Job.BuildProfile buildProfile = Job.BuildProfile.DXP;

		return JobFactory.newJob(
			buildProfile, jobName, null, null, null, null, repositoryName,
			testSuiteName, upstreamBranchName);
	}

	public static Job portalReleaseTomcat() throws Exception {
		String jobName = "test-portal-release";
		String testSuiteName = "portal-release-tomcat";
		String upstreamBranchName = "master";
		String repositoryName = "liferay-portal";
		Job.BuildProfile buildProfile = Job.BuildProfile.DXP;

		return JobFactory.newJob(
			buildProfile, jobName, null, null, null, null, repositoryName,
			testSuiteName, upstreamBranchName);
	}

	public static Job qaWebsites() throws Exception {
		String jobName = "test-qa-websites-functional-daily";
		String testSuiteName = "default";
		String upstreamBranchName = "master";
		String repositoryName = "liferay-qa-websites-ee";
		Job.BuildProfile buildProfile = Job.BuildProfile.DXP;

		List<String> projectNames = new ArrayList<>();

		projectNames.add("liferay-cloud-platform");

		return JobFactory.newJob(
			buildProfile, jobName, null, null, null, projectNames,
			repositoryName, testSuiteName, upstreamBranchName);
	}

	public static void testJob(Job job) throws Exception {
		System.out.println("job=" + job);
		System.out.println("job.getBuildProfile()=" + job.getBuildProfile());

		JSONObject jsonObject = job.getJSONObject();

		String testSuiteName = "default";

		if (job instanceof TestSuiteJob) {
			TestSuiteJob testSuiteJob = (TestSuiteJob)job;

			testSuiteName = testSuiteJob.getTestSuiteName();
		}

		if (job instanceof QAWebsitesGitRepositoryJob) {
			QAWebsitesGitRepositoryJob qaWebsitesGitRepositoryJob =
				(QAWebsitesGitRepositoryJob)job;

			List<String> projectNames =
				qaWebsitesGitRepositoryJob.getProjectNames();

			if (projectNames != null) {
				for (String projectName : projectNames) {
					testSuiteName += "_" + projectName;
				}
			}
		}

		String name = job.getJobName() + "_" + testSuiteName;

		File file = new File(
			JenkinsResultsParserUtil.combine(
				"/Users/michaelhashimoto/Downloads/", name, ".json"));

		JenkinsResultsParserUtil.write(file, jsonObject.toString(2));

		System.out.println(file);

		File jobSummaryDir = new File(file.getParentFile(), name);

		CIJobSummaryReportUtil.writeJobSummaryReport(jobSummaryDir, job);

		System.out.println(new File(jobSummaryDir, "index.html"));

		System.out.println("-------------------------------------------------");

		for (BatchTestClassGroup batchTestClassGroup :
				job.getBatchTestClassGroups()) {

			System.out.println("> " + batchTestClassGroup.getBatchName());

			for (AxisTestClassGroup axisTestClassGroup :
					batchTestClassGroup.getAxisTestClassGroups()) {

				System.out.println("> > " + axisTestClassGroup.getAxisName());

				for (TestClass testClass :
						axisTestClassGroup.getTestClasses()) {

					System.out.println("> > > " + testClass.getName());

					for (TestClassMethod testClassMethod :
							testClass.getTestClassMethods()) {

						if (testClass instanceof FunctionalTestClass ||
							testClass instanceof JUnitTestClass) {

							continue;
						}

						System.out.println(
							"> > > > " + testClassMethod.getName());
					}
				}
			}
		}

		System.out.println("-------------------------------------------------");

		for (BatchTestClassGroup batchTestClassGroup :
				job.getDependentBatchTestClassGroups()) {

			System.out.println("> " + batchTestClassGroup.getBatchName());

			for (AxisTestClassGroup axisTestClassGroup :
					batchTestClassGroup.getAxisTestClassGroups()) {

				System.out.println("> > " + axisTestClassGroup.getAxisName());

				for (TestClass testClass :
						axisTestClassGroup.getTestClasses()) {

					System.out.println("> > > " + testClass.getName());

					if (testClass instanceof FunctionalTestClass ||
						testClass instanceof JUnitTestClass) {

						continue;
					}

					for (TestClassMethod testClassMethod :
							testClass.getTestClassMethods()) {

						System.out.println(
							"> > > > " + testClassMethod.getName());
					}
				}
			}
		}
	}

}