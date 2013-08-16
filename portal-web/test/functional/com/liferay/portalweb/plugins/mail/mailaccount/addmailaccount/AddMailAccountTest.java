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

package com.liferay.portalweb.plugins.mail.mailaccount.addmailaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMailAccountTest extends BaseTestCase {
	public void testAddMailAccount() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home");
		selenium.clickAt("link=Mail Test Page",
			RuntimeVariables.replace("Mail Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Mail Account']",
			RuntimeVariables.replace("Add Mail Account"));
		selenium.waitForVisible("//input[@id='_1_WAR_mailportlet_address']");
		selenium.type("//input[@id='_1_WAR_mailportlet_address']",
			RuntimeVariables.replace("liferay.qa.testing@gmail.com"));
		selenium.type("//input[@id='_1_WAR_mailportlet_password']",
			RuntimeVariables.replace("loveispatient"));
		assertFalse(selenium.isChecked(
				"//input[@id='_1_WAR_mailportlet_savePasswordCheckbox']"));
		selenium.check("//input[@id='_1_WAR_mailportlet_savePasswordCheckbox']");
		assertTrue(selenium.isChecked(
				"//input[@id='_1_WAR_mailportlet_savePasswordCheckbox']"));
		selenium.clickAt("//input[@value='Add Account']",
			RuntimeVariables.replace("Add Account"));
		selenium.waitForVisible("//span[@class='message portlet-msg-success']");
		assertEquals(RuntimeVariables.replace("Account has been created."),
			selenium.getText("//span[@class='message portlet-msg-success']"));
	}
}