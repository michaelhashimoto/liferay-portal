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

package com.liferay.portalweb.portal.controlpanel.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddDeletableMessageTest extends BaseTestCase {
	public void testAddDeletableMessage() throws Exception {
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
		selenium.clickAt("link=Message Boards",
			RuntimeVariables.replace("Message Boards"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("T\u00e9st Cat\u00e9gory"),
			selenium.getText("//td[2]/a/strong"));
		selenium.clickAt("//td[2]/a/strong",
			RuntimeVariables.replace("T\u00e9st Cat\u00e9gory"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("T\u00e9st Subcat\u00e9gory"),
			selenium.getText("//td[2]/a/strong"));
		selenium.clickAt("//td[2]/a/strong",
			RuntimeVariables.replace("T\u00e9st Subcat\u00e9gory"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"S\u00e9cond T\u00e9st Subcat\u00e9gory"),
			selenium.getText("//td[2]/a/strong"));
		selenium.clickAt("//td[2]/a/strong",
			RuntimeVariables.replace("S\u00e9cond T\u00e9st Subcat\u00e9gory"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Post New Thread']",
			RuntimeVariables.replace("Post New Thread"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_162_subject']",
			RuntimeVariables.replace(
				"T\u00e9st M\u00e9ssag\u00e9 to b\u00e9 D\u00e9l\u00e9t\u00e9d"));
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
			RuntimeVariables.replace(
				"This m\u00e9ssag\u00e9 will b\u00e9 d\u00e9l\u00e9t\u00e9d!"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"T\u00e9st M\u00e9ssag\u00e9 to b\u00e9 D\u00e9l\u00e9t\u00e9d"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace(
				"T\u00e9st M\u00e9ssag\u00e9 to b\u00e9 D\u00e9l\u00e9t\u00e9d"),
			selenium.getText("//div/a/strong"));
		assertEquals(RuntimeVariables.replace(
				"This m\u00e9ssag\u00e9 will b\u00e9 d\u00e9l\u00e9t\u00e9d!"),
			selenium.getText("//td[2]/div[2]"));
	}
}