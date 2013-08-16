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

package com.liferay.portalweb.portlet.messageboards.hybrid.gmailviewmbthreadgmail;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditMBCategoryMailingListActiveActionsTest extends BaseTestCase {
	public void testEditMBCategoryMailingListActiveActions()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//a/strong"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isChecked(
				"//input[@id='_19_mailingListActiveCheckbox']"));
		selenium.clickAt("//input[@id='_19_mailingListActiveCheckbox']",
			RuntimeVariables.replace("Active"));
		assertTrue(selenium.isChecked(
				"//input[@id='_19_mailingListActiveCheckbox']"));
		selenium.waitForVisible("//input[@id='_19_emailAddress']");
		selenium.type("//input[@id='_19_emailAddress']",
			RuntimeVariables.replace("liferay-mailinglist@googlegroups.com"));
		selenium.clickAt("//input[@name='_19_inProtocol']",
			RuntimeVariables.replace("POP"));
		assertTrue(selenium.isChecked("//input[@name='_19_inProtocol']"));
		selenium.type("//input[@id='_19_inServerName']",
			RuntimeVariables.replace("pop.gmail.com"));
		selenium.type("//input[@id='_19_inServerPort']",
			RuntimeVariables.replace("995"));
		assertFalse(selenium.isChecked("//input[@id='_19_inUseSSLCheckbox']"));
		selenium.clickAt("//input[@id='_19_inUseSSLCheckbox']",
			RuntimeVariables.replace("Use a Secure Network Connection"));
		assertTrue(selenium.isChecked("//input[@id='_19_inUseSSLCheckbox']"));
		selenium.type("//input[@id='_19_inUserName']",
			RuntimeVariables.replace("liferay.qa.server.trunk@gmail.com"));
		selenium.type("//input[@id='_19_inPassword']",
			RuntimeVariables.replace("loveispatient"));
		selenium.type("//input[@id='_19_inReadInterval']",
			RuntimeVariables.replace("1"));
		selenium.type("//input[@id='_19_outEmailAddress']",
			RuntimeVariables.replace("liferay.qa.server.trunk@gmail.com"));
		assertFalse(selenium.isChecked("//input[@id='_19_outCustomCheckbox']"));
		selenium.clickAt("//input[@id='_19_outCustomCheckbox']",
			RuntimeVariables.replace("Use Customer Outgoing Server"));
		assertTrue(selenium.isChecked("//input[@id='_19_outCustomCheckbox']"));
		selenium.waitForVisible("//input[@id='_19_outEmailAddress']");
		selenium.type("//input[@id='_19_outEmailAddress']",
			RuntimeVariables.replace("liferay.qa.server.trunk@gmail.com"));
		selenium.type("//input[@id='_19_outServerName']",
			RuntimeVariables.replace("smtp.gmail.com"));
		selenium.type("//input[@id='_19_outServerPort']",
			RuntimeVariables.replace("465"));
		assertFalse(selenium.isChecked("//input[@id='_19_outUseSSLCheckbox']"));
		selenium.clickAt("//input[@id='_19_outUseSSLCheckbox']",
			RuntimeVariables.replace("Use a Secure Network Connection"));
		assertTrue(selenium.isChecked("//input[@id='_19_outUseSSLCheckbox']"));
		selenium.type("//input[@id='_19_outUserName']",
			RuntimeVariables.replace("liferay.qa.server.trunk@gmail.com"));
		selenium.type("//input[@id='_19_outPassword']",
			RuntimeVariables.replace("loveispatient"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}