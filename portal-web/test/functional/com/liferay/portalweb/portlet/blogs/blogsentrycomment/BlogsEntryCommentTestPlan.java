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

package com.liferay.portalweb.portlet.blogs.blogsentrycomment;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.blogs.blogsentrycomment.addblogsentrycomment.AddBlogsEntryCommentTests;
import com.liferay.portalweb.portlet.blogs.blogsentrycomment.addblogsentrycomments.AddBlogsEntryCommentsTests;
import com.liferay.portalweb.portlet.blogs.blogsentrycomment.addblogsentryscomment.AddBlogsEntrysCommentTests;
import com.liferay.portalweb.portlet.blogs.blogsentrycomment.deleteblogsentrycomment.DeleteBlogsEntryCommentTests;
import com.liferay.portalweb.portlet.blogs.blogsentrycomment.editblogsentrycomment.EditBlogsEntryCommentTests;
import com.liferay.portalweb.portlet.blogs.blogsentrycomment.subscribetocommentsblogsentry.SubscribeToCommentsBlogsEntryTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsEntryCommentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddBlogsEntryCommentTests.suite());
		testSuite.addTest(AddBlogsEntryCommentsTests.suite());
		testSuite.addTest(AddBlogsEntrysCommentTests.suite());
		testSuite.addTest(DeleteBlogsEntryCommentTests.suite());
		testSuite.addTest(EditBlogsEntryCommentTests.suite());
		testSuite.addTest(SubscribeToCommentsBlogsEntryTests.suite());

		return testSuite;
	}

}