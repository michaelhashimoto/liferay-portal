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

package com.liferay.portalweb.socialofficesite.forums.mbthread;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficesite.forums.mbthread.deletembcategorythreadmessagesite.DeleteMBCategoryThreadMessageSiteTests;
import com.liferay.portalweb.socialofficesite.forums.mbthread.editmbcategorythreadmessagesite.EditMBCategoryThreadMessageSiteTests;
import com.liferay.portalweb.socialofficesite.forums.mbthread.editpermissionsmbcategory2guestnoview.EditPermissionsMBCategory2GuestNoViewTests;
import com.liferay.portalweb.socialofficesite.forums.mbthread.markasanswermbcategorythreadreplysite.MarkAsAnswerMBCategoryThreadReplySiteTests;
import com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorymultiplethreadmessagesite.PostNewMBCategoryMultipleThreadMessageSiteTests;
import com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmessagesite.PostNewMBCategoryThreadMessageSiteTests;
import com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmessagetagsite.PostNewMBCategoryThreadMessageTagSiteTests;
import com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmultiplemessagesite.PostNewMBCategoryThreadMultipleMessageSiteTests;
import com.liferay.portalweb.socialofficesite.forums.mbthread.replymbcategorythreadmessagereplymultiplesite.ReplyMBCategoryThreadMessageReplyMultipleSiteTests;
import com.liferay.portalweb.socialofficesite.forums.mbthread.replymbcategorythreadmessagereplysite.ReplyMBCategoryThreadMessageReplySiteTests;
import com.liferay.portalweb.socialofficesite.forums.mbthread.votembcategorythreadmessagesite.VoteMBCategoryThreadMessageSiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MBThreadTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(DeleteMBCategoryThreadMessageSiteTests.suite());
		testSuite.addTest(EditMBCategoryThreadMessageSiteTests.suite());
		testSuite.addTest(EditPermissionsMBCategory2GuestNoViewTests.suite());
		testSuite.addTest(MarkAsAnswerMBCategoryThreadReplySiteTests.suite());
		testSuite.addTest(
			PostNewMBCategoryMultipleThreadMessageSiteTests.suite());
		testSuite.addTest(PostNewMBCategoryThreadMessageSiteTests.suite());
		testSuite.addTest(PostNewMBCategoryThreadMessageTagSiteTests.suite());
		testSuite.addTest(
			PostNewMBCategoryThreadMultipleMessageSiteTests.suite());
		testSuite.addTest(
			ReplyMBCategoryThreadMessageReplyMultipleSiteTests.suite());
		testSuite.addTest(ReplyMBCategoryThreadMessageReplySiteTests.suite());
		testSuite.addTest(VoteMBCategoryThreadMessageSiteTests.suite());

		return testSuite;
	}

}