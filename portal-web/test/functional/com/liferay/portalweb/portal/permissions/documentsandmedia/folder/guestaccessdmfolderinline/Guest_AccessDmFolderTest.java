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

package com.liferay.portalweb.portal.permissions.documentsandmedia.folder.guestaccessdmfolderinline;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_AccessDmFolderTest extends BaseTestCase {
	public void testGuest_AccessDmFolder() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Home"),
			selenium.getText("//li[@class='folder selected']/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForText("//li[@class='folder selected']/a/span[2]",
			"DM Folder Name");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//li[@class='folder selected']/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText(
				"//a[@class='document-link']/span[@class='entry-title']"));
		selenium.clickAt("//a[@class='document-link']/span[@class='entry-title']",
			RuntimeVariables.replace("DM Folder Image Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("URL"),
			selenium.getText("//a[@class='show-url-file']"));
		selenium.clickAt("//a[@class='show-url-file']",
			RuntimeVariables.replace("URL"));
		selenium.waitForVisible(
			"//div[contains(@class,'url-file-container')]/input");

		String imageURL = selenium.getValue(
				"//div[contains(@class,'url-file-container')]/input");
		RuntimeVariables.setValue("imageURL", imageURL);
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Sign Out");
		selenium.clickAt("link=Sign Out", RuntimeVariables.replace("Sign Out"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//input[@id='_58_login']");
		assertTrue(selenium.isVisible("//input[@id='_58_login']"));
		selenium.open(RuntimeVariables.getValue("imageURL"));
		Thread.sleep(5000);
		assertTrue(selenium.isVisible("//body/img"));
	}
}