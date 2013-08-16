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

package com.liferay.portalweb.permissions.mediagallery.mgimage.viewdmfolderimage.guestinline;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_ViewDMFolderImageURLNoMGTest extends BaseTestCase {
	public void testGuest_ViewDMFolderImageURLNoMG() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//span[@class='image-title']"));
		selenium.clickAt("//span[@class='image-title']",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText("//span[@class='image-title']"));
		selenium.clickAt("//span[@class='image-title']",
			RuntimeVariables.replace("DM Folder Image Title"));
		selenium.waitForVisible("//img[@title='View']");
		selenium.clickAt("//img[@title='View']",
			RuntimeVariables.replace("View"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a[@class='show-url-file']",
			RuntimeVariables.replace("Image URL"));
		selenium.waitForVisible("//input[@type='text']");
		selenium.clickAt("//input[@type='text']",
			RuntimeVariables.replace("Image URL"));

		String ImageURL = selenium.getValue("//input[@type='text']");
		RuntimeVariables.setValue("ImageURL", ImageURL);
		selenium.waitForVisible("link=Sign Out");
		selenium.clickAt("link=Sign Out", RuntimeVariables.replace("Sign Out"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//input[@value='Sign In']");
		assertTrue(selenium.isVisible("//input[@value='Sign In']"));
		selenium.open("/web/guest/home/");
		selenium.open(RuntimeVariables.getValue("ImageURL"));
		selenium.waitForVisible("//input[@id='_58_login']");
		assertTrue(selenium.isVisible("//input[@id='_58_login']"));
		assertTrue(selenium.isVisible("//input[@id='_58_password']"));
		assertTrue(selenium.isVisible("//input[@value='Sign In']"));
		assertTrue(selenium.isElementNotPresent(
				"//img[contains(@src,'DM+Folder+Image+Title')]"));
	}
}