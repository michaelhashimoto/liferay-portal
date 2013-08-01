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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcstructurewebcontentlocalized.AddWCStructureWebContentLocalizedTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontent.AddWCWebContentTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontentexpirationdate.AddWCWebContentExpirationDateTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontentlocalized.AddWCWebContentLocalizedTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontentreviewdate.AddWCWebContentReviewDateTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontents.AddWCWebContentsTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontenttitleescapecharacter.AddWCWebContentTitleEscapeCharacterTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontenttitlenull.AddWCWebContentTitleNullTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.advancedsearchwcwebcontent.AdvancedSearchWCWebContentTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.deletewcwebcontentactions.DeleteWCWebContentActionsTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.deletewcwebcontentlist.DeleteWCWebContentListTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.deletewcwebcontenttitleescapecharacter.DeleteWCWebContentTitleEscapeCharacterTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.editwcwebcontent.EditWCWebContentTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.editwcwebcontentsummary.EditWCWebContentSummaryTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.expireeditwcwebcontentactions.ExpireEditWCWebContentActionsTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.expirewcwebcontentactions.ExpireWCWebContentActionsTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.expirewcwebcontentlist.ExpireWCWebContentListTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.publishexpirewcwebcontent.PublishExpireWCWebContentTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.publishsaveasdraftwcwebcontent.PublishSaveAsDraftWCWebContentTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.saveasdraftwcwebcontent.SaveAsDraftWCWebContentTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.saveasdraftwcwebcontentversion1to2.SaveAsDraftWCWebContentVersion1to2Tests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.searchwcwebcontent.SearchWCWebContentTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.usereditwcwebcontent.UserEditWCWebContentTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WCWebContentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddWCStructureWebContentLocalizedTests.suite());
		testSuite.addTest(AddWCWebContentTests.suite());
		testSuite.addTest(AddWCWebContentExpirationDateTests.suite());
		testSuite.addTest(AddWCWebContentLocalizedTests.suite());
		testSuite.addTest(AddWCWebContentReviewDateTests.suite());
		testSuite.addTest(AddWCWebContentsTests.suite());
		testSuite.addTest(AddWCWebContentTitleEscapeCharacterTests.suite());
		testSuite.addTest(AddWCWebContentTitleNullTests.suite());
		testSuite.addTest(AdvancedSearchWCWebContentTests.suite());
		testSuite.addTest(DeleteWCWebContentActionsTests.suite());
		testSuite.addTest(DeleteWCWebContentListTests.suite());
		testSuite.addTest(DeleteWCWebContentTitleEscapeCharacterTests.suite());
		testSuite.addTest(EditWCWebContentTests.suite());
		testSuite.addTest(EditWCWebContentSummaryTests.suite());
		testSuite.addTest(ExpireEditWCWebContentActionsTests.suite());
		testSuite.addTest(ExpireWCWebContentActionsTests.suite());
		testSuite.addTest(ExpireWCWebContentListTests.suite());
		testSuite.addTest(PublishExpireWCWebContentTests.suite());
		testSuite.addTest(PublishSaveAsDraftWCWebContentTests.suite());
		testSuite.addTest(SaveAsDraftWCWebContentTests.suite());
		testSuite.addTest(SaveAsDraftWCWebContentVersion1to2Tests.suite());
		testSuite.addTest(SearchWCWebContentTests.suite());
		testSuite.addTest(UserEditWCWebContentTests.suite());

		return testSuite;
	}

}