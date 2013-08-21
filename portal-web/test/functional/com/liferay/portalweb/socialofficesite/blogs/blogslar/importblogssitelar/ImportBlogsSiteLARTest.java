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

package com.liferay.portalweb.socialofficesite.blogs.blogslar.importblogssitelar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ImportBlogsSiteLARTest extends BaseTestCase {
	public void testImportBlogsSiteLAR() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[@class='search-input focus']");
		selenium.type("//input[@class='search-input focus']",
			RuntimeVariables.replace("Open"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a[contains(@id,'toggleDockbar')]",
			RuntimeVariables.replace("Toggle Dockbar"));
		selenium.waitForElementPresent(
			"//body[contains(@class,'show-dockbar')]");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Manage"),
			selenium.getText("//li[@id='_145_manageContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_manageContent']/a/span");
		selenium.waitForVisible("//li[contains(.,'Site Pages')]/a");
		assertEquals(RuntimeVariables.replace("Site Pages"),
			selenium.getText("//li[contains(.,'Site Pages')]/a"));
		selenium.clickAt("//li[contains(.,'Site Pages')]/a",
			RuntimeVariables.replace("Site Pages"));
		selenium.waitForVisible("//iframe[@id='manageContentDialog']");
		selenium.selectFrame("//iframe[@id='manageContentDialog']");
		selenium.waitForVisible("//button[contains(.,'Import')]");
		selenium.clickAt("//button[contains(.,'Import')]",
			RuntimeVariables.replace("Import"));
		selenium.selectFrame("relative=top");
		selenium.waitForVisible("//iframe[@id='_88_importDialog']");
		selenium.selectFrame("//iframe[@id='_88_importDialog']");
		selenium.waitForVisible("//input[@id='_88_importFileName']");
		selenium.uploadFile("//input[@id='_88_importFileName']",
			RuntimeVariables.replace(
				"L:\\portal\\build\\portal-web\\test\\functional\\com\\liferay\\portalweb\\socialofficesite\\blogs\\dependencies\\SO_Site_Blogs-Selenium.lar"));
		selenium.check("//input[@id='_88_PORTLET_DATACheckbox']");
		assertTrue(selenium.isChecked("//input[@id='_88_PORTLET_DATACheckbox']"));
		selenium.check("//input[@id='_88_DELETE_PORTLET_DATACheckbox']");
		assertTrue(selenium.isChecked(
				"//input[@id='_88_DELETE_PORTLET_DATACheckbox']"));
		selenium.clickAt("//input[@id='_88_PERMISSIONSCheckbox']",
			RuntimeVariables.replace("Permissions"));
		assertTrue(selenium.isChecked("//input[@id='_88_PERMISSIONSCheckbox']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_88_permissionsAssignedToRolesCheckbox']"));
		selenium.clickAt("//input[@id='_88_CATEGORIESCheckbox']",
			RuntimeVariables.replace("Categories"));
		assertTrue(selenium.isChecked("//input[@id='_88_CATEGORIESCheckbox']"));
		selenium.clickAt("//input[@value='Import']",
			RuntimeVariables.replace("Import"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.selectFrame("relative=top");
	}
}