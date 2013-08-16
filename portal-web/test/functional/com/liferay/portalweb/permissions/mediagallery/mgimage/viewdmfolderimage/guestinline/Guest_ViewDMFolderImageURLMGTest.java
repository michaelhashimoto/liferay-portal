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
public class Guest_ViewDMFolderImageURLMGTest extends BaseTestCase {
	public void testGuest_ViewDMFolderImageURLMG() throws Exception {
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
		assertEquals(RuntimeVariables.replace("URL"),
			selenium.getText("//a[@class='show-url-file']"));
		selenium.clickAt("//a[@class='show-url-file']",
			RuntimeVariables.replace("Image URL"));
		selenium.waitForVisible("//input[@type='text']");
		selenium.clickAt("//input[@type='text']",
			RuntimeVariables.replace("Image URL"));

		String ImageURL = selenium.getValue("//input[@type='text']");
		RuntimeVariables.setValue("ImageURL", ImageURL);
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText("//h2[@class='document-title']"));
		selenium.open(RuntimeVariables.getValue("ImageURL"));
		selenium.waitForVisible("//img[contains(@src,'DM+Folder+Image+Title')]");
		assertTrue(selenium.isVisible(
				"//img[contains(@src,'DM+Folder+Image+Title')]"));
		assertTrue(selenium.isElementNotPresent("//input[@id='_58_login']"));
		assertTrue(selenium.isElementNotPresent("//input[@id='_58_password']"));
		assertTrue(selenium.isElementNotPresent("//input[@value='Sign In']"));
	}
}