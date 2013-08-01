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

package com.liferay.portalweb.portlet.wiki.comment;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.wiki.comment.addfrontpagecomment.AddFrontPageCommentTests;
import com.liferay.portalweb.portlet.wiki.comment.addfrontpagecommentbodynull.AddFrontPageCommentBodyNullTests;
import com.liferay.portalweb.portlet.wiki.comment.addfrontpagecommentmultiple.AddFrontPageCommentMultipleTests;
import com.liferay.portalweb.portlet.wiki.comment.deletefrontpagecomment.DeleteFrontPageCommentTests;
import com.liferay.portalweb.portlet.wiki.comment.editfrontpagecommentbody.EditFrontPageCommentBodyTests;
import com.liferay.portalweb.portlet.wiki.comment.ratefrontpagecomment.RateFrontPageCommentTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CommentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddFrontPageCommentTests.suite());
		testSuite.addTest(AddFrontPageCommentBodyNullTests.suite());
		testSuite.addTest(AddFrontPageCommentMultipleTests.suite());
		testSuite.addTest(DeleteFrontPageCommentTests.suite());
		testSuite.addTest(EditFrontPageCommentBodyTests.suite());
		testSuite.addTest(RateFrontPageCommentTests.suite());

		return testSuite;
	}

}