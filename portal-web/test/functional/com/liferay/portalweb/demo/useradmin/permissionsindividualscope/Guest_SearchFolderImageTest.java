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

package com.liferay.portalweb.demo.useradmin.permissionsindividualscope;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_SearchFolderImageTest extends BaseTestCase {
	public void testGuest_SearchFolderImage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("dog"));
		selenium.clickAt("//input[@id='_20_search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForText("//a[@class='document-link']/span[2]",
			"DL Folder 1 Image 1 Title");
		assertEquals(RuntimeVariables.replace("DL Folder 1 Image 1 Title"),
			selenium.getText("//a[@class='document-link']/span[2]"));
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("cat"));
		selenium.clickAt("//input[@id='_20_search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForElementPresent(
			"//img[contains(@src,'forbidden_action')]");
		assertTrue(selenium.isElementNotPresent("//a[@class='document-link']"));
		assertFalse(selenium.isTextPresent("DL Folder 2 Image 2 Title"));
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("fish"));
		selenium.clickAt("//input[@id='_20_search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForElementPresent(
			"//img[contains(@src,'forbidden_action')]");
		assertTrue(selenium.isElementNotPresent("//a[@class='document-link']"));
		assertFalse(selenium.isTextPresent("DL Folder 2 Image 3 Title"));
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("frog"));
		selenium.clickAt("//input[@id='_20_search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForElementPresent(
			"//img[contains(@src,'forbidden_action')]");
		assertTrue(selenium.isElementNotPresent("//a[@class='document-link']"));
		assertFalse(selenium.isTextPresent(
				"DL Folder 2 SubFolder Image 4 Title"));
	}
}