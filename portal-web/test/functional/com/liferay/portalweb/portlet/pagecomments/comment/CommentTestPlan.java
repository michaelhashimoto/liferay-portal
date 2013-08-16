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

package com.liferay.portalweb.portlet.pagecomments.comment;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.pagecomments.comment.addcomment.AddCommentTests;
import com.liferay.portalweb.portlet.pagecomments.comment.addcommentbodynull.AddCommentBodyNullTests;
import com.liferay.portalweb.portlet.pagecomments.comment.addcommentbodyspace.AddCommentBodySpaceTests;
import com.liferay.portalweb.portlet.pagecomments.comment.addcommentmultiple.AddCommentMultipleTests;
import com.liferay.portalweb.portlet.pagecomments.comment.addcommentreply.AddCommentReplyTests;
import com.liferay.portalweb.portlet.pagecomments.comment.addcommentreplybodynull.AddCommentReplyBodyNullTests;
import com.liferay.portalweb.portlet.pagecomments.comment.addcommentreplybodyspace.AddCommentReplyBodySpaceTests;
import com.liferay.portalweb.portlet.pagecomments.comment.addcommentreplymultiple.AddCommentReplyMultipleTests;
import com.liferay.portalweb.portlet.pagecomments.comment.canceladdcomment.CancelAddCommentTests;
import com.liferay.portalweb.portlet.pagecomments.comment.canceladdcommentreply.CancelAddCommentReplyTests;
import com.liferay.portalweb.portlet.pagecomments.comment.deletecomment.DeleteCommentTests;
import com.liferay.portalweb.portlet.pagecomments.comment.deletecommentreply.DeleteCommentReplyTests;
import com.liferay.portalweb.portlet.pagecomments.comment.editcommentbody.EditCommentBodyTests;
import com.liferay.portalweb.portlet.pagecomments.comment.editcommentbodynull.EditCommentBodyNullTests;
import com.liferay.portalweb.portlet.pagecomments.comment.editcommentbodyspace.EditCommentBodySpaceTests;
import com.liferay.portalweb.portlet.pagecomments.comment.editcommentreplybody.EditCommentReplyBodyTests;
import com.liferay.portalweb.portlet.pagecomments.comment.editcommentreplybodynull.EditCommentReplyBodyNullTests;
import com.liferay.portalweb.portlet.pagecomments.comment.editcommentreplybodyspace.EditCommentReplyBodySpaceTests;
import com.liferay.portalweb.portlet.pagecomments.comment.ratecomment.RateCommentTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CommentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddCommentTests.suite());
		testSuite.addTest(AddCommentBodyNullTests.suite());
		testSuite.addTest(AddCommentBodySpaceTests.suite());
		testSuite.addTest(AddCommentMultipleTests.suite());
		testSuite.addTest(AddCommentReplyTests.suite());
		testSuite.addTest(AddCommentReplyBodyNullTests.suite());
		testSuite.addTest(AddCommentReplyBodySpaceTests.suite());
		testSuite.addTest(AddCommentReplyMultipleTests.suite());
		testSuite.addTest(CancelAddCommentTests.suite());
		testSuite.addTest(CancelAddCommentReplyTests.suite());
		testSuite.addTest(DeleteCommentTests.suite());
		testSuite.addTest(DeleteCommentReplyTests.suite());
		testSuite.addTest(EditCommentBodyTests.suite());
		testSuite.addTest(EditCommentBodyNullTests.suite());
		testSuite.addTest(EditCommentBodySpaceTests.suite());
		testSuite.addTest(EditCommentReplyBodyTests.suite());
		testSuite.addTest(EditCommentReplyBodyNullTests.suite());
		testSuite.addTest(EditCommentReplyBodySpaceTests.suite());
		testSuite.addTest(RateCommentTests.suite());

		return testSuite;
	}

}