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
public class SOUs_ViewActivitiesProfileImageProfileTest extends BaseTestCase {
	public void testSOUs_ViewActivitiesProfileImageProfile()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Profile"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='no-icon lfr-contact-info']/div/a"));
		assertEquals(RuntimeVariables.replace("socialoffice01@liferay.com"),
			selenium.getText("//div[@class='no-icon lfr-contact-info']/div[3]"));
		assertTrue(selenium.isElementPresent(
				"xpath=(//span[@class='avatar']/img[@alt='Social01 Office01 User01'])[1]"));
		assertEquals(RuntimeVariables.replace(
				"Social01 commented on Joe Bloggs's blog entry, Blogs Entry Comment Body..., in Open Site Name."),
			selenium.getText("xpath=(//div[@class='activity-title'])[1]"));
		assertTrue(selenium.isElementPresent(
				"xpath=(//span[@class='avatar']/img[@alt='Social01 Office01 User01'])[2]"));
		assertEquals(RuntimeVariables.replace(
				"Social01 replied to Joe Bloggs's message board post, RE: MB Category Thread Message Subject, in Open Site Name."),
			selenium.getText("xpath=(//div[@class='activity-title'])[2]"));
		assertTrue(selenium.isElementPresent(
				"xpath=(//span[@class='avatar']/img[@alt='Social01 Office01 User01'])[3]"));
		assertEquals(RuntimeVariables.replace(
				"@Joe Bloggs: Microblogs Post Comment"),
			selenium.getText("xpath=(//div[@class='activity-title'])[3]"));
	}
}