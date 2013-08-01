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

package com.liferay.portalweb.portal.selenium.mouseactions.draganddrop;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DragAndDrop3Test extends BaseTestCase {
	public void testDragAndDrop3() throws Exception {
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
		selenium.clickAt("link=Dynamic Data Lists",
			RuntimeVariables.replace("Dynamic Data Lists"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Manage Data Definitions"),
			selenium.getText(
				"//span[@class='lfr-toolbar-button view-structures ']/a"));
		selenium.clickAt("//span[@class='lfr-toolbar-button view-structures ']/a",
			RuntimeVariables.replace("Manage Data Definitions"));
		selenium.waitForVisible("//iframe[contains(@src,'dynamicdatalists')]");
		selenium.selectFrame("//iframe[contains(@src,'dynamicdatalists')]");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/event-tap/event-tap-min.js')]");
		selenium.waitForVisible(
			"//span[@class='lfr-toolbar-button add-button ']/a");
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText(
				"//span[@class='lfr-toolbar-button add-button ']/a"));
		selenium.clickAt("//span[@class='lfr-toolbar-button add-button ']/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_166_name_en_US']",
			RuntimeVariables.replace("Data Definition"));
		assertEquals(RuntimeVariables.replace("Boolean"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[1]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[1]/div",
			"//div[@class='Catherine']");
	}
}