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

package com.liferay.portalweb.socialofficehome.activities.activitiesblockedsouser.sousviewactivitiesblockedsouser3;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs2_ViewActivitiesBlockedSOUser3Test extends BaseTestCase {
	public void testSOUs2_ViewActivitiesBlockedSOUser3()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice02/so/dashboard");
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title']/span)[contains(.,'Activities')]"));
		assertEquals(RuntimeVariables.replace("Following"),
			selenium.getText("link=Following"));
		selenium.clickAt("link=Following", RuntimeVariables.replace("Following"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='no-activities']");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("There are no activities."),
			selenium.getText("//div[@class='no-activities']"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='activity-user-name']"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='activity-action']"));
		assertTrue(selenium.isElementNotPresent("//div[@class='activity-body']"));
		assertFalse(selenium.isTextPresent(
				"Social03 Office03 User03 in Open Site Name"));
		assertFalse(selenium.isTextPresent("Wrote a new forum post."));
		assertFalse(selenium.isTextPresent("Forums Thread1 Message Subject"));
		assertFalse(selenium.isTextPresent("Forums Thread1 Message Body"));
		assertFalse(selenium.isTextPresent("Social03 Office03 User03"));
		assertFalse(selenium.isTextPresent("Microblogs Post1"));
	}
}