/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portalweb.portal.controlpanel.blogs.entry;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.addblogsentryautodraftcp.AddBlogsEntryAutoDraftCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.addblogsentrycontentnullcp.AddBlogsEntryContentNullCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.addblogsentrydraftcp.AddBlogsEntryDraftCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.addblogsentrymultiplecp.AddBlogsEntryMultipleCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.addblogsentryratingcp.AddBlogsEntryRatingCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.addblogsentrytitleescapecharactercp.AddBlogsEntryTitleEscapeCharacterCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.addblogsentrytitlenullcp.AddBlogsEntryTitleNullCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.deleteblogsentrycp.DeleteBlogsEntryCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.deleteblogsentrytitleescapecharactercp.DeleteBlogsEntryTitleEscapeCharacterCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.editblogsentrycontentcp.EditBlogsEntryContentCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.editblogsentrytitlecp.EditBlogsEntryTitleCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.publishblogsentrydraftcp.PublishBlogsEntryDraftCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.searchblogsentrycp.SearchBlogsEntryCPTests;
import com.liferay.portalweb.portal.controlpanel.blogs.entry.viewblogsentryviewcountcp.ViewBlogsEntryViewCountCPTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddBlogsEntryAutoDraftCPTests.suite());
		testSuite.addTest(AddBlogsEntryContentNullCPTests.suite());
		testSuite.addTest(AddBlogsEntryDraftCPTests.suite());
		testSuite.addTest(AddBlogsEntryMultipleCPTests.suite());
		testSuite.addTest(AddBlogsEntryRatingCPTests.suite());
		testSuite.addTest(AddBlogsEntryTitleEscapeCharacterCPTests.suite());
		testSuite.addTest(AddBlogsEntryTitleNullCPTests.suite());
		testSuite.addTest(DeleteBlogsEntryCPTests.suite());
		testSuite.addTest(DeleteBlogsEntryTitleEscapeCharacterCPTests.suite());
		testSuite.addTest(EditBlogsEntryContentCPTests.suite());
		testSuite.addTest(EditBlogsEntryTitleCPTests.suite());
		testSuite.addTest(PublishBlogsEntryDraftCPTests.suite());
		testSuite.addTest(SearchBlogsEntryCPTests.suite());
		testSuite.addTest(ViewBlogsEntryViewCountCPTests.suite());

		return testSuite;
	}

}