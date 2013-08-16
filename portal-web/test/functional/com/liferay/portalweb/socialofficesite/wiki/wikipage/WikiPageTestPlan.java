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

package com.liferay.portalweb.socialofficesite.wiki.wikipage;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.addsaveasdraftwikifrontpagesite.AddSaveAsDraftWikiFrontPageSiteTests;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.addwikifrontpageattachmentsite.AddWikiFrontPageAttachmentSiteTests;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.addwikifrontpagechildpagesite.AddWikiFrontPageChildPageSiteTests;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.addwikifrontpagecommentsite.AddWikiFrontPageCommentSiteTests;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.addwikifrontpagesite.AddWikiFrontPageSiteTests;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.editpermissionsfrontpagechildpageguestnoview.EditPermissionsFrontPageChildPageGuestNoViewTests;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.editwikifrontpagesite.EditWikiFrontPageSiteTests;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.ratewikifrontpagesite.RateWikiFrontPageSiteTests;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.saveasdraftwikifrontpagesite.SaveAsDraftWikiFrontPageSiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiPageTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSaveAsDraftWikiFrontPageSiteTests.suite());
		testSuite.addTest(AddWikiFrontPageAttachmentSiteTests.suite());
		testSuite.addTest(AddWikiFrontPageChildPageSiteTests.suite());
		testSuite.addTest(AddWikiFrontPageCommentSiteTests.suite());
		testSuite.addTest(AddWikiFrontPageSiteTests.suite());
		testSuite.addTest(
			EditPermissionsFrontPageChildPageGuestNoViewTests.suite());
		testSuite.addTest(EditWikiFrontPageSiteTests.suite());
		testSuite.addTest(RateWikiFrontPageSiteTests.suite());
		testSuite.addTest(SaveAsDraftWikiFrontPageSiteTests.suite());

		return testSuite;
	}

}