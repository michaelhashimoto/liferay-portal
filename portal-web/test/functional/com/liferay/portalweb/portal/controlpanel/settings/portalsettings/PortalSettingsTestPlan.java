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

package com.liferay.portalweb.portal.controlpanel.settings.portalsettings;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.editgeneral.EditGeneralTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.edittimezone.EditTimeZoneTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.enterdefaultuserassociationscommunity.EnterDefaultUserAssociationsCommunityTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.enterdefaultuserassociationsrole.EnterDefaultUserAssociationsRoleTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.enterdefaultuserassociationsusergroup.EnterDefaultUserAssociationsUserGroupTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.enterreservedemailaddress.EnterReservedEmailAddressTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.enterreservedscreenname.EnterReservedScreenNameTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewauthenticationcas.ViewAuthenticationCASTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewauthenticationgeneral.ViewAuthenticationGeneralTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewauthenticationldap.ViewAuthenticationLDAPTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewauthenticationntlm.ViewAuthenticationNTLMTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewauthenticationopenid.ViewAuthenticationOpenIDTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewauthenticationopensso.ViewAuthenticationOpenSSOTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewauthenticationsiteminder.ViewAuthenticationSiteMinderTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewdefaultuserassociations.ViewDefaultUserAssociationsTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewemailnotificationaccountcreated.ViewEmailNotificationAccountCreatedTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewemailnotificationgeneral.ViewEmailNotificationGeneralTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewemailnotificationpasswordchanged.ViewEmailNotificationPasswordChangedTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewmailhostnames.ViewMailHostNamesTests;
import com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewreservedscreennames.ViewReservedScreenNamesTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalSettingsTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(EditGeneralTests.suite());
		testSuite.addTest(EditTimeZoneTests.suite());
		testSuite.addTest(EnterDefaultUserAssociationsCommunityTests.suite());
		testSuite.addTest(EnterDefaultUserAssociationsRoleTests.suite());
		testSuite.addTest(EnterDefaultUserAssociationsUserGroupTests.suite());
		testSuite.addTest(EnterReservedEmailAddressTests.suite());
		testSuite.addTest(EnterReservedScreenNameTests.suite());
		testSuite.addTest(ViewAuthenticationCASTests.suite());
		testSuite.addTest(ViewAuthenticationGeneralTests.suite());
		testSuite.addTest(ViewAuthenticationLDAPTests.suite());
		testSuite.addTest(ViewAuthenticationNTLMTests.suite());
		testSuite.addTest(ViewAuthenticationOpenIDTests.suite());
		testSuite.addTest(ViewAuthenticationOpenSSOTests.suite());
		testSuite.addTest(ViewAuthenticationSiteMinderTests.suite());
		testSuite.addTest(ViewDefaultUserAssociationsTests.suite());
		testSuite.addTest(ViewEmailNotificationAccountCreatedTests.suite());
		testSuite.addTest(ViewEmailNotificationGeneralTests.suite());
		testSuite.addTest(ViewEmailNotificationPasswordChangedTests.suite());
		testSuite.addTest(ViewMailHostNamesTests.suite());
		testSuite.addTest(ViewReservedScreenNamesTests.suite());

		return testSuite;
	}

}