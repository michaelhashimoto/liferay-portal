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

package com.liferay.portalweb.socialofficeprofile.profile.souseditprofilepictureprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_EditProfilePictureProfileTest extends BaseTestCase {
	public void testSOUs_EditProfilePictureProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertTrue(selenium.isVisible("//img[@alt='Social01 Office01 User01']"));
		assertTrue(selenium.isElementNotPresent(
				"//img[contains(@src,'default')]"));
		assertEquals(RuntimeVariables.replace("Edit Profile Picture"),
			selenium.getText(
				"//span[contains(@class,'edit-logo-button')]/button"));
		selenium.clickAt("//span[contains(@class,'edit-logo-button')]/button",
			RuntimeVariables.replace("Edit Profile Picture"));
		Thread.sleep(1000);
		selenium.selectWindow("title=My Account");
		selenium.waitForText("//label[@for='_2_fileName']",
			"Upload a GIF or JPEG that is 120 pixels tall and 100 pixels wide.");
		assertEquals(RuntimeVariables.replace(
				"Upload a GIF or JPEG that is 120 pixels tall and 100 pixels wide."),
			selenium.getText("//label[@for='_2_fileName']"));
		selenium.uploadCommonFile("//input[@id='_2_fileName']",
			RuntimeVariables.replace("Document_3.jpg"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.selectWindow("null");
		Thread.sleep(1000);
		assertTrue(selenium.isElementNotPresent(
				"//img[contains(@src,'default')]"));
		assertTrue(selenium.isVisible("//img[@alt='Social01 Office01 User01']"));
	}
}