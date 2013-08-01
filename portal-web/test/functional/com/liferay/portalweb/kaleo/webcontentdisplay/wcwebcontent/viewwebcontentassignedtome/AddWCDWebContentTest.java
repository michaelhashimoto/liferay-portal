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

package com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentassignedtome;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWCDWebContentTest extends BaseTestCase {
	public void testAddWCDWebContent() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Web Content Display Test Page",
			RuntimeVariables.replace("Web Content Display Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertTrue(selenium.isVisible("//img[@title='Add Web Content']"));
		selenium.clickAt("//img[@title='Add Web Content']",
			RuntimeVariables.replace("Add"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.type("//input[@id='_15_title_en_US']",
			RuntimeVariables.replace("WC Web Content Title"));
		selenium.waitForVisible(
			"//a[contains(@class,'cke_button_cut') and contains(@class,'cke_disabled')]");
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
			RuntimeVariables.replace("WC Web Content Content"));
		selenium.clickAt("//input[@value='Submit for Publication']",
			RuntimeVariables.replace("Submit for Publication"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"WC Web Content Title is not approved."),
			selenium.getText("//div[@class='portlet-msg-alert']"));
	}
}