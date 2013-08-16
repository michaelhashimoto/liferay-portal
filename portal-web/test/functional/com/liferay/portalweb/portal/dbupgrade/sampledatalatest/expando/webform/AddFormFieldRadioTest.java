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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.expando.webform;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddFormFieldRadioTest extends BaseTestCase {
	public void testAddFormFieldRadio() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/expando-web-form-community/");
		selenium.waitForVisible("link=Web Form Page");
		selenium.clickAt("link=Web Form Page",
			RuntimeVariables.replace("Web Form Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.click("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		selenium.waitForVisible("//div[3]/span/span/button[1]");
		selenium.clickAt("//div[3]/span/span/button[1]",
			RuntimeVariables.replace("Add Row"));
		selenium.waitForVisible("//select[@id='_86_fieldType4']");
		selenium.select("//select[@id='_86_fieldType4']",
			RuntimeVariables.replace("label=Radio Buttons"));
		selenium.waitForVisible("//input[@id='_86_fieldLabel4_en_US']");
		selenium.type("//input[@id='_86_fieldLabel4_en_US']",
			RuntimeVariables.replace("Gender"));
		selenium.type("//input[@id='_86_fieldOptions4_en_US']",
			RuntimeVariables.replace("Male,Female"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.waitForVisible("link=Web Form Page");
		selenium.clickAt("link=Web Form Page",
			RuntimeVariables.replace("Web Form Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Gender"));
		assertTrue(selenium.isElementPresent("//input[@value='Male']"));
		assertTrue(selenium.isElementPresent("//input[@value='Female']"));
	}
}