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

package com.liferay.portalweb.demo.sitemanagement.brazilianworldcup;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ImportExportLARPublicPagesSiteBWCTest extends BaseTestCase {
	public void testImportExportLARPublicPagesSiteBWC()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Sites", RuntimeVariables.replace("Sites"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("LAR Import Site"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("LAR Import Site"),
			selenium.getText("//td/a"));
		selenium.clickAt("//td/a", RuntimeVariables.replace("LAR Import Site"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Site Pages",
			RuntimeVariables.replace("Site Pages"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Public Pages",
			RuntimeVariables.replace("Public Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Import"),
			selenium.getText("//button[3]"));
		selenium.clickAt("//button[3]", RuntimeVariables.replace("Import"));
		selenium.waitForVisible("//input[@id='_156_importFileName']");
		selenium.uploadTempFile("//input[@id='_156_importFileName']",
			RuntimeVariables.replace("World_Cup_Public_Pages.lar"));
		assertFalse(selenium.isChecked(
				"//input[@id='_156_DELETE_MISSING_LAYOUTSCheckbox']"));
		selenium.clickAt("//input[@id='_156_DELETE_MISSING_LAYOUTSCheckbox']",
			RuntimeVariables.replace("Delete Missing Pages"));
		assertTrue(selenium.isChecked(
				"//input[@id='_156_DELETE_MISSING_LAYOUTSCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_156_PERMISSIONSCheckbox']"));
		selenium.clickAt("//input[@id='_156_PERMISSIONSCheckbox']",
			RuntimeVariables.replace("Permissions"));
		assertTrue(selenium.isChecked("//input[@id='_156_PERMISSIONSCheckbox']"));
		assertFalse(selenium.isChecked("//input[@id='_156_CATEGORIESCheckbox']"));
		selenium.clickAt("//input[@id='_156_CATEGORIESCheckbox']",
			RuntimeVariables.replace("Categories"));
		assertTrue(selenium.isChecked("//input[@id='_156_CATEGORIESCheckbox']"));
		selenium.waitForVisible(
			"//input[@id='_156_DELETE_PORTLET_DATACheckbox']");
		assertFalse(selenium.isChecked(
				"//input[@id='_156_DELETE_PORTLET_DATACheckbox']"));
		selenium.clickAt("//input[@id='_156_DELETE_PORTLET_DATACheckbox']",
			RuntimeVariables.replace("Delete portlet data before importing"));
		assertTrue(selenium.isChecked(
				"//input[@id='_156_DELETE_PORTLET_DATACheckbox']"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Import']",
			RuntimeVariables.replace("Import"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}