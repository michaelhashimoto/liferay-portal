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

package com.liferay.portalweb.portal.permissions.documentlibrary.content.documentlibrarydocument.update;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Member_AssertCannotUpdateDocumentTest extends BaseTestCase {
	public void testMember_AssertCannotUpdateDocument()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Documents and Media",
			RuntimeVariables.replace("Documents and Media"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible(
			"//div[@data-title='Document_1.txt']/span[@class='overlay document-action']/span/ul/li/strong/a");
		selenium.clickAt("//div[@data-title='Document_1.txt']/span[@class='overlay document-action']/span/ul/li/strong/a",
			RuntimeVariables.replace("Document Actions Overlay"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Download (0.3k)')]/a");
		assertEquals(RuntimeVariables.replace("Download (0.3k)"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Download (0.3k)')]/a"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Edit')]/a"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Move')]/a"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Checkout')]/a"));
		assertEquals(RuntimeVariables.replace("Document_1.txt"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("Document_1.txt"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Download"),
			selenium.getText("//div[@id='_20_fileEntryToolbar']/span/button[1]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@id='_20_fileEntryToolbar']/span/button[2]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@id='_20_fileEntryToolbar']/span/button[3]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@id='_20_fileEntryToolbar']/span/button[4]"));
		assertFalse(selenium.isTextPresent("Edit"));
		assertFalse(selenium.isTextPresent("Move"));
		assertFalse(selenium.isTextPresent("Checkout"));
	}
}