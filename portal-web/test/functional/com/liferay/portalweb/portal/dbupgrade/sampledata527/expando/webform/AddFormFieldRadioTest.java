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

package com.liferay.portalweb.portal.dbupgrade.sampledata527.expando.webform;

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
		selenium.clickAt("link=Web Form Page",
			RuntimeVariables.replace("Web Form Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//strong/span"));
		selenium.clickAt("//strong/span", RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Form Fields",
			RuntimeVariables.replace("Form Fields"));
		selenium.waitForVisible("//a[@class='add-row']");
		selenium.clickAt("//a[@class='add-row']",
			RuntimeVariables.replace("Add Row"));
		selenium.waitForVisible("//select[@id='_86_fieldType4']");
		selenium.select("//select[@id='_86_fieldType4']",
			RuntimeVariables.replace("Radio Buttons"));
		selenium.waitForVisible("//input[@id='_86_fieldOptions4']");
		selenium.type("//input[@id='_86_fieldLabel4']",
			RuntimeVariables.replace("Gender"));
		selenium.type("//input[@id='_86_fieldOptions4']",
			RuntimeVariables.replace("Male,Female"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/expando-web-form-community/");
		selenium.clickAt("link=Web Form Page",
			RuntimeVariables.replace("Web Form Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Gender"),
			selenium.getText("//label[contains(@for,'_field2')]"));
		assertTrue(selenium.isVisible("//input[@value='Male']"));
		assertTrue(selenium.isVisible("//input[@value='Female']"));
	}
}