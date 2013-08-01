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

package com.liferay.portalweb.portal.dbupgrade.sampledata606.tags.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMBMessageCTagTest extends BaseTestCase {
	public void testAddMBMessageCTag() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Manage"),
			selenium.getText("//li[@id='_145_manageContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_manageContent']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Communities",
			RuntimeVariables.replace("Communities"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Tags Message Board Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td[2]/a",
			RuntimeVariables.replace("Open"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace("Message Boards Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td/a/strong",
			RuntimeVariables.replace("Category Test"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Post New Thread']",
			RuntimeVariables.replace("Post New Thread"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_19_subject']",
			RuntimeVariables.replace("MessageC TagC TestC"));
		selenium.type("//textarea[@id='_19_textArea']",
			RuntimeVariables.replace("This is a messageC tagC testC."));
		selenium.type("//li/span/span/input",
			RuntimeVariables.replace("selenium"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MessageC TagC TestC"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row']/td/a"));
		selenium.clickAt("//tr[@class='portlet-section-body results-row']/td/a",
			RuntimeVariables.replace("MessageC TagC TestC"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MessageC TagC TestC"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("selenium"),
			selenium.getText("//span[@class='tag']"));
		assertEquals(RuntimeVariables.replace("This is a messageC tagC testC."),
			selenium.getText("//div[@class='thread-body']"));
	}
}