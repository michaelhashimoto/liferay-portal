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

package com.liferay.portalweb.portlet.wikidisplay.comment;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.wikidisplay.comment.addwdfrontpagecomment.AddWDFrontPageCommentTests;
import com.liferay.portalweb.portlet.wikidisplay.comment.addwdfrontpagecommentmultiple.AddWDFrontPageCommentMultipleTests;
import com.liferay.portalweb.portlet.wikidisplay.comment.addwdfrontpagecommentnull.AddWDFrontPageCommentNullTests;
import com.liferay.portalweb.portlet.wikidisplay.comment.deletewdfrontpagecomment.DeleteWDFrontPageCommentTests;
import com.liferay.portalweb.portlet.wikidisplay.comment.editwdfrontpagecomment.EditWDFrontPageCommentTests;
import com.liferay.portalweb.portlet.wikidisplay.comment.ratewdfrontpagecomment.RateWDFrontPageCommentTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CommentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddWDFrontPageCommentTests.suite());
		testSuite.addTest(AddWDFrontPageCommentMultipleTests.suite());
		testSuite.addTest(AddWDFrontPageCommentNullTests.suite());
		testSuite.addTest(DeleteWDFrontPageCommentTests.suite());
		testSuite.addTest(EditWDFrontPageCommentTests.suite());
		testSuite.addTest(RateWDFrontPageCommentTests.suite());

		return testSuite;
	}

}