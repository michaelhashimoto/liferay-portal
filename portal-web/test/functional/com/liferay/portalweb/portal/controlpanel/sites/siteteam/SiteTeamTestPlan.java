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

package com.liferay.portalweb.portal.controlpanel.sites.siteteam;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.siteteam.addsitesteam.AddSitesTeamTests;
import com.liferay.portalweb.portal.controlpanel.sites.siteteam.addsiteteam.AddSiteTeamTests;
import com.liferay.portalweb.portal.controlpanel.sites.siteteam.addsiteteams.AddSiteTeamsTests;
import com.liferay.portalweb.portal.controlpanel.sites.siteteam.assignmemberssiteteamuser.AssignMembersSiteTeamUserTests;
import com.liferay.portalweb.portal.controlpanel.sites.siteteam.deletesiteteam.DeleteSiteTeamTests;
import com.liferay.portalweb.portal.controlpanel.sites.siteteam.editsiteteam.EditSiteTeamTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SiteTeamTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSiteTeamTests.suite());
		testSuite.addTest(AddSitesTeamTests.suite());
		testSuite.addTest(AddSiteTeamsTests.suite());
		testSuite.addTest(AssignMembersSiteTeamUserTests.suite());
		testSuite.addTest(DeleteSiteTeamTests.suite());
		testSuite.addTest(EditSiteTeamTests.suite());

		return testSuite;
	}

}