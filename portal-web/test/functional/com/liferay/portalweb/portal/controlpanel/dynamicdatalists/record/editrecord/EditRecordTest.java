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

package com.liferay.portalweb.portal.controlpanel.dynamicdatalists.record.editrecord;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditRecordTest extends BaseTestCase {
	public void testEditRecord() throws Exception {
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
		selenium.type("//input[@name='_167_keywords']",
			RuntimeVariables.replace("List Name"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("List Name"),
			selenium.getText("//tr[contains(.,'List Name')]/td[2]/a"));
		selenium.clickAt("//tr[contains(.,'List Name')]/td[2]/a",
			RuntimeVariables.replace("List Name"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Actions']/ul/li/strong/a",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Boolean"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[1]/span/span/label"));
		selenium.click(
			"//div[@class='aui-fieldset-content ']/div[1]/span/span/span/input[2]");
		assertEquals(RuntimeVariables.replace("Date"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[2]/div/label"));
		selenium.waitForVisible(
			"//div[@class='aui-datepicker-select-wrapper']/select");
		selenium.clickAt("//div[@class='aui-datepicker-select-wrapper']/select",
			RuntimeVariables.replace("Month Drop Down"));
		selenium.select("//div[@class='aui-datepicker-select-wrapper']/select",
			RuntimeVariables.replace("August"));
		selenium.select("//div[@class='aui-datepicker-select-wrapper']/select[2]",
			RuntimeVariables.replace("9"));
		selenium.select("//div[@class='aui-datepicker-select-wrapper']/select[3]",
			RuntimeVariables.replace("2010"));
		assertEquals(RuntimeVariables.replace("Decimal"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[3]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[3]/span/span/span/input",
			RuntimeVariables.replace("8.910"));
		assertEquals(RuntimeVariables.replace("Documents and Media"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[4]/div/span/span/label"));
		selenium.clickAt("//div[@class='aui-fieldset-content ']/div[4]/div/div/span/span/input",
			RuntimeVariables.replace("Select"));
		selenium.waitForVisible("//iframe");
		selenium.selectFrame("//iframe");
		selenium.waitForVisible("//input[@value='Choose']");
		selenium.clickAt("//input[@value='Choose']",
			RuntimeVariables.replace("Choose"));
		selenium.selectFrame("relative=top");
		selenium.waitForValue("//div[4]/div/span/span/span/input",
			"Document_1.txt");
		assertEquals("Document_1.txt",
			selenium.getValue("//div[4]/div/span/span/span/input"));
		assertTrue(selenium.isPartialText(
				"//div[@class='aui-fieldset-content ']/div[5]/span/span/label",
				"File Upload"));
		selenium.uploadCommonFile("//div[@class='aui-fieldset-content ']/div[5]/span/span/span/input",
			RuntimeVariables.replace("Document_2.txt"));
		assertEquals(RuntimeVariables.replace("Integer"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[6]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[6]/span/span/span/input",
			RuntimeVariables.replace("8910"));
		assertEquals(RuntimeVariables.replace("Number"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[7]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[7]/span/span/span/input",
			RuntimeVariables.replace("111213"));
		assertEquals(RuntimeVariables.replace("Radio"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[8]/div/label"));
		assertEquals(RuntimeVariables.replace("option 1"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[8]/div/span[1]/span"));
		assertEquals(RuntimeVariables.replace("option 2"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[8]/div/span[2]/span"));
		assertEquals(RuntimeVariables.replace("option 3"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[8]/div/span[3]/span"));
		selenium.clickAt("//div[@class='aui-fieldset-content ']/div[8]/div/span[2]/span/span/input",
			RuntimeVariables.replace("option 3"));
		assertEquals(RuntimeVariables.replace("Select"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/span[1]/span/label"));
		assertEquals(RuntimeVariables.replace("option 1"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/span[1]/span/span/select/option[1]"));
		assertEquals(RuntimeVariables.replace("option 2"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/span[1]/span/span/select/option[2]"));
		assertEquals(RuntimeVariables.replace("option 3"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/span[1]/span/span/select/option[3]"));
		selenium.select("//div[@class='aui-fieldset-content ']/span[1]/span/span/select",
			RuntimeVariables.replace("label=option 1"));
		assertEquals(RuntimeVariables.replace("Text"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[9]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[9]/span/span/span/input",
			RuntimeVariables.replace("Text Field Edited"));
		assertEquals(RuntimeVariables.replace("Text Box"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[10]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[10]/span/span/span/textarea",
			RuntimeVariables.replace("Text\nBox\nEdited"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}