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

package com.liferay.portalweb.portal.controlpanel.categories.category.deletecategorydetails;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DeleteCategoryDetailsTest extends BaseTestCase {
	public void testDeleteCategoryDetails() throws Exception {
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
		selenium.clickAt("link=Categories",
			RuntimeVariables.replace("Categories"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//li/div/div[4]");
		assertEquals(RuntimeVariables.replace("Category Name"),
			selenium.getText("//li/div/div[4]"));
		selenium.clickAt("//li/div/div[4]",
			RuntimeVariables.replace("Category Name"));
		selenium.waitForVisible("//div[@class='view-category']/div/h1/span");
		assertEquals(RuntimeVariables.replace("Category Name"),
			selenium.getText("//div[@class='view-category']/div/h1/span"));
		selenium.clickAt("//input[@value='Delete']",
			RuntimeVariables.replace("Delete"));
		selenium.waitForConfirmation(
			"Are you sure you want to delete this category?");
		selenium.waitForVisible(
			"//div[@class='lfr-message-response portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-success']"));
		selenium.waitForVisible(
			"//div[@class='lfr-message-response portlet-msg-info']");
		assertEquals(RuntimeVariables.replace("There are no categories."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-info']"));
	}
}