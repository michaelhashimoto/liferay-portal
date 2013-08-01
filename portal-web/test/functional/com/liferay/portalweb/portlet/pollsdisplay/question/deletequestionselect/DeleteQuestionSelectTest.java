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

package com.liferay.portalweb.portlet.pollsdisplay.question.deletequestionselect;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DeleteQuestionSelectTest extends BaseTestCase {
	public void testDeleteQuestionSelect() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Polls Display Test Page",
			RuntimeVariables.replace("Polls Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("//div/span[1]/span/span/input"));
		assertTrue(selenium.isElementPresent("//div/span[2]/span/span/input"));
		assertTrue(selenium.isElementPresent("//div/span[3]/span/span/input"));
		assertEquals(RuntimeVariables.replace("a. PD Question ChoiceA"),
			selenium.getText("//div/span[1]/span/label"));
		assertEquals(RuntimeVariables.replace("b. PD Question ChoiceB"),
			selenium.getText("//div/span[2]/span/label"));
		assertEquals(RuntimeVariables.replace("c. PD Question ChoiceC"),
			selenium.getText("//div/span[3]/span/label"));
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
		selenium.clickAt("link=Polls", RuntimeVariables.replace("Polls"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//td[5]/span/ul/li/strong/a"));
		selenium.clickAt("//td[5]/span/ul/li/strong/a",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a");
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete this[\\s\\S]$"));
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Polls Display Test Page",
			RuntimeVariables.replace("Polls Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent("//div/span[1]/span/span/input"));
		assertTrue(selenium.isElementNotPresent("//div/span[2]/span/span/input"));
		assertTrue(selenium.isElementNotPresent("//div/span[3]/span/span/input"));
		assertFalse(selenium.isTextPresent("PD Question ChoiceA"));
		assertFalse(selenium.isTextPresent("PD Question ChoiceB"));
		assertFalse(selenium.isTextPresent("PD Question ChoiceC"));
		assertEquals(RuntimeVariables.replace(
				"Please configure this portlet to make it visible to all users."),
			selenium.getText(
				"//div[@class='portlet-configuration portlet-msg-info']"));
	}
}