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

package com.liferay.portalweb.socialofficeprofile.profile.viewactivitiesdashboardactivitiesprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewActivitiesProfileTest extends BaseTestCase {
	public void testSOUs_ViewActivitiesProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Profile"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("xPath=(//div[@class='lfr-contact-name']/a)[2]"));
		assertEquals(RuntimeVariables.replace("socialoffice01@liferay.com"),
			selenium.getText("//div[@class='lfr-contact-extra']"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs added a new task for Social01."),
			selenium.getText("xPath=(//div[@class='activity-title'])[1]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='activity-body'])[1]", "Task2 Description"));
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//div[@class='activity-title'])[2]"));
		assertFalse(selenium.isTextPresent("Microblogs Post1"));
		assertFalse(selenium.isTextPresent("Microblogs Post2"));
		assertFalse(selenium.isTextPresent("DM Folder Document1 Title"));
		assertFalse(selenium.isTextPresent("Task1 Description"));
	}
}