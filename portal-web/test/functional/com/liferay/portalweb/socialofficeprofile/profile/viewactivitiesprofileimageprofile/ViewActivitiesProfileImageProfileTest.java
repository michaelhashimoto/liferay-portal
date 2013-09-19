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

package com.liferay.portalweb.socialofficeprofile.profile.viewactivitiesprofileimageprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewActivitiesProfileImageProfileTest extends BaseTestCase {
	public void testViewActivitiesProfileImageProfile()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/joebloggs/so/profile");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Profile"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[@class='no-icon lfr-contact-info']/div/a"));
		assertEquals(RuntimeVariables.replace("test@liferay.com"),
			selenium.getText("//div[@class='no-icon lfr-contact-info']/div[3]"));
		selenium.waitForVisible(
			"xpath=(//span[@class='avatar']/a/img[@alt='Joe Bloggs'])[1]");
		assertTrue(selenium.isElementPresent(
				"xpath=(//span[@class='avatar']/a/img[@alt='Joe Bloggs'])[1]"));
		assertEquals(RuntimeVariables.replace("Joe in Open Site Name"),
			selenium.getText("xpath=(//div[@class='activity-user-name'])[1]"));
		assertEquals(RuntimeVariables.replace("Wrote a new blog entry."),
			selenium.getText("xpath=(//div[@class='activity-action'])[1]"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[1]", "Blogs Entry Title"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[1]",
				"Blogs Entry Content"));
		assertTrue(selenium.isElementPresent(
				"xpath=(//span[@class='avatar']/a/img[@alt='Joe Bloggs'])[2]"));
		assertEquals(RuntimeVariables.replace("Joe in Open Site Name"),
			selenium.getText("xpath=(//div[@class='activity-user-name'])[2]"));
		assertEquals(RuntimeVariables.replace(
				"Wrote a new forum post in MB Category Name."),
			selenium.getText("xpath=(//div[@class='activity-action'])[2]"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[2]",
				"MB Category Thread Message Subject"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[2]",
				"MB Category Thread Message Body"));
		assertTrue(selenium.isElementPresent(
				"xpath=(//span[@class='avatar']/a/img[@alt='Joe Bloggs'])[3]"));
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("xpath=(//div[@class='activity-user-name'])[3]"));
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("xpath=(//div[@class='activity-action'])[3]"));
	}
}