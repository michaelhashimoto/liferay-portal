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

package com.liferay.portalweb.portal.dbupgrade.transfersampledatalatest.blogs.pagescopelarcp;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ImportExportCPLARPage2BlogsPageScopeTest extends BaseTestCase {
	public void testImportExportCPLARPage2BlogsPageScope()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/blogs-page-scope-community/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Blogs", RuntimeVariables.replace("Blogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Scope: Default"),
			selenium.getText("//div/span/ul/li/strong/a/span"));
		selenium.clickAt("//div/span/ul/li/strong/a/span",
			RuntimeVariables.replace("Scope: Default"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		assertEquals(RuntimeVariables.replace("Blogs Test Page2"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a",
			RuntimeVariables.replace("Blogs Test Page2"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.waitForText("//div/span/ul/li/strong/a/span",
			"Scope: Blogs Test Page2");
		assertEquals(RuntimeVariables.replace("Scope: Blogs Test Page2"),
			selenium.getText("//div/span/ul/li/strong/a/span"));
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//menu/span/ul/li/strong/a"));
		selenium.clickAt("//menu/span/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a");
		assertEquals(RuntimeVariables.replace("Export / Import"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Import", RuntimeVariables.replace("Import"));
		selenium.waitForVisible("//input[@id='_86_importFileName']");
		selenium.uploadTempFile("//input[@id='_86_importFileName']",
			RuntimeVariables.replace("Blogs_Page_Scope.Page2.CP.lar"));
		assertFalse(selenium.isChecked(
				"//input[@id='_86_DELETE_PORTLET_DATACheckbox']"));
		selenium.clickAt("//input[@id='_86_DELETE_PORTLET_DATACheckbox']",
			RuntimeVariables.replace("Delete portlet data before importing."));
		assertTrue(selenium.isChecked(
				"//input[@id='_86_DELETE_PORTLET_DATACheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_86_PORTLET_DATACheckbox']"));
		selenium.clickAt("//input[@id='_86_PORTLET_DATACheckbox']",
			RuntimeVariables.replace("Data"));
		assertTrue(selenium.isChecked("//input[@id='_86_PORTLET_DATACheckbox']"));
		assertFalse(selenium.isChecked("//input[@id='_86_PERMISSIONSCheckbox']"));
		selenium.clickAt("//input[@id='_86_PERMISSIONSCheckbox']",
			RuntimeVariables.replace("Permissions"));
		assertTrue(selenium.isChecked("//input[@id='_86_PERMISSIONSCheckbox']"));
		assertFalse(selenium.isChecked("//input[@id='_86_CATEGORIESCheckbox']"));
		selenium.clickAt("//input[@id='_86_CATEGORIESCheckbox']",
			RuntimeVariables.replace("Categories"));
		assertTrue(selenium.isChecked("//input[@id='_86_CATEGORIESCheckbox']"));
		selenium.clickAt("//input[@value='Import']",
			RuntimeVariables.replace("Import"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}