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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontent150character.AddMicroblogsContent150CharacterTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontent151character.AddMicroblogsContent151CharacterTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontentmentions.AddMicroblogsContentMentionsTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontentmultipletag.AddMicroblogsContentMultipleTagTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontentmultipletagmultiple.AddMicroblogsContentMultipleTagMultipleTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontentspecialcharacters.AddMicroblogsContentSpecialCharactersTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontenttagviewablebyeveryone.AddMicroblogsContentTagViewableByEveryoneTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontentviewablebyconnections.AddMicroblogsContentViewableByConnectionsTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontentviewablebyeveryone.AddMicroblogsContentViewableByEveryoneTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontentviewablebyfollowers.AddMicroblogsContentViewableByFollowersTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.deletemicroblogscontent.DeleteMicroblogsContentTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.editmicroblogscontentviewablebyconnections.EditMicroblogsContentViewableByConnectionsTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.editmicroblogscontentviewablebyeveryone.EditMicroblogsContentViewableByEveryoneTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.editmicroblogscontentviewablebyfollowers.EditMicroblogsContentViewableByFollowersTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousdeletereplymicroblogscontentprofile.SOUs_DeleteReplyMicroblogsContentProfileTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousdeleterepostmicroblogscontent.SOUs_DeleteRepostMicroblogsContentTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousreplymbcontentviewablebyconnectioncomment.SOUs_ReplyMBContentViewableByConnectionCommentTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousreplymbcontentviewablebyfollowerscomment.SOUs_ReplyMBContentViewableByFollowersCommentTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousreplymicroblogscontentcommenttag.SOUs_ReplyMicroblogsContentCommentTagTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousreplymicroblogscontentprofile.SOUs_ReplyMicroblogsContentProfileTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousreplymicroblogscontenttagprofile.SOUs_ReplyMicroblogsContentTagProfileTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousrepostmicroblogscontentprofile.SOUs_RepostMicroblogsContentProfileTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousviewmbcontentmultiple.SOUs_ViewMBContentMultipleTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousviewmicroblogscontenttag.SOUs_ViewMicroblogsContentTagTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.viewmicroblogsmentions.ViewMicroblogsMentionsTests;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.viewmicroblogstimeline.ViewMicroblogsTimelineTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MBEntryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddMicroblogsContent150CharacterTests.suite());
		testSuite.addTest(AddMicroblogsContent151CharacterTests.suite());
		testSuite.addTest(AddMicroblogsContentMentionsTests.suite());
		testSuite.addTest(AddMicroblogsContentMultipleTagTests.suite());
		testSuite.addTest(AddMicroblogsContentMultipleTagMultipleTests.suite());
		testSuite.addTest(AddMicroblogsContentSpecialCharactersTests.suite());
		testSuite.addTest(
			AddMicroblogsContentTagViewableByEveryoneTests.suite());
		testSuite.addTest(
			AddMicroblogsContentViewableByConnectionsTests.suite());
		testSuite.addTest(AddMicroblogsContentViewableByEveryoneTests.suite());
		testSuite.addTest(AddMicroblogsContentViewableByFollowersTests.suite());
		testSuite.addTest(DeleteMicroblogsContentTests.suite());
		testSuite.addTest(
			EditMicroblogsContentViewableByConnectionsTests.suite());
		testSuite.addTest(EditMicroblogsContentViewableByEveryoneTests.suite());
		testSuite.addTest(
			EditMicroblogsContentViewableByFollowersTests.suite());
		testSuite.addTest(
			SOUs_DeleteReplyMicroblogsContentProfileTests.suite());
		testSuite.addTest(SOUs_DeleteRepostMicroblogsContentTests.suite());
		testSuite.addTest(
			SOUs_ReplyMBContentViewableByConnectionCommentTests.suite());
		testSuite.addTest(
			SOUs_ReplyMBContentViewableByFollowersCommentTests.suite());
		testSuite.addTest(SOUs_ReplyMicroblogsContentCommentTagTests.suite());
		testSuite.addTest(SOUs_ReplyMicroblogsContentProfileTests.suite());
		testSuite.addTest(SOUs_ReplyMicroblogsContentTagProfileTests.suite());
		testSuite.addTest(SOUs_RepostMicroblogsContentProfileTests.suite());
		testSuite.addTest(SOUs_ViewMBContentMultipleTests.suite());
		testSuite.addTest(SOUs_ViewMicroblogsContentTagTests.suite());
		testSuite.addTest(ViewMicroblogsMentionsTests.suite());
		testSuite.addTest(ViewMicroblogsTimelineTests.suite());

		return testSuite;
	}

}