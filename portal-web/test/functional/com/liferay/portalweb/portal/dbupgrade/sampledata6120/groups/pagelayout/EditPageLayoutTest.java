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

package com.liferay.portalweb.portal.dbupgrade.sampledata6120.groups.pagelayout;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditPageLayoutTest extends BaseTestCase {
	public void testEditPageLayout() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/group-page-layout-community/");
		selenium.waitForVisible("link=Page Layout Page");
		selenium.clickAt("link=Page Layout Page",
			RuntimeVariables.replace("Page Layout Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"//div[@id='layout-column_column-1' and @class='portlet-dropzone portlet-column-content portlet-column-content-first']/div[1]/div[1]/section/header/h1/span[2]"));
		assertTrue(selenium.isElementPresent(
				"//div[@id='layout-column_column-2' and @class='portlet-dropzone portlet-column-content portlet-column-content-last']/div[1]/div[1]/section/header/h1/span[2]"));
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Manage"),
			selenium.getText("//li[@id='_145_manageContent']"));
		selenium.mouseOver("//li[@id='_145_manageContent']");
		selenium.waitForVisible("link=Page Layout");
		selenium.clickAt("link=Page Layout",
			RuntimeVariables.replace("Page Layout"));
		Thread.sleep(5000);
		selenium.waitForVisible("//input[@id='_88_layoutTemplateId2']");
		selenium.clickAt("//input[@id='_88_layoutTemplateId2']",
			RuntimeVariables.replace("2 Columns"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully. The page will be refreshed when you close this dialog. Alternatively you can hide this dialog."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/group-page-layout-community/");
		selenium.waitForVisible("link=Page Layout Page");
		selenium.clickAt("link=Page Layout Page",
			RuntimeVariables.replace("Page Layout Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"//div[@id='column-1' and @class='aui-w50 portlet-column portlet-column-first']"));
		assertTrue(selenium.isElementPresent(
				"//div[@id='column-2' and @class='aui-w50 portlet-column portlet-column-last']"));
		assertEquals(RuntimeVariables.replace("Breadcrumb"),
			selenium.getText(
				"//div[@id='layout-column_column-1' and @class='portlet-dropzone portlet-column-content portlet-column-content-first']/div[1]/div[1]/section/header/h1/span[2]"));
		assertEquals(RuntimeVariables.replace("Navigation"),
			selenium.getText(
				"//div[@id='layout-column_column-2' and @class='portlet-dropzone portlet-column-content portlet-column-content-last']/div[1]/div[1]/section/header/h1/span[2]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@id='column-1' and @class='aui-w30 portlet-column portlet-column-first']"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@id='column-2' and @class='aui-w70 portlet-column portlet-column-last']"));
	}
}