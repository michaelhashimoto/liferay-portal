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

package com.liferay.portalweb.plugins.mail.message.sendmessagesubjectnull;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SendMessageSubjectNullTest extends BaseTestCase {
	public void testSendMessageSubjectNull() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Mail Test Page");
		selenium.clickAt("link=Mail Test Page",
			RuntimeVariables.replace("Mail Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("liferay.qa.testing@gmail.com"),
			selenium.getText("//div/div/div[1]/div/ul/li/span/span/a"));
		selenium.clickAt("//div/div/div[1]/div/ul/li/span/span/a",
			RuntimeVariables.replace("liferay.qa.testing@gmail.com"));
		Thread.sleep(5000);
		selenium.waitForText("//a[@class='compose-message']", "Compose Email");
		assertEquals(RuntimeVariables.replace("Compose Email"),
			selenium.getText("//a[@class='compose-message']"));
		selenium.clickAt("//a[@class='compose-message']",
			RuntimeVariables.replace("Compose Email"));
		Thread.sleep(5000);
		selenium.waitForVisible("//input[@id='_1_WAR_mailportlet_to']");
		selenium.type("//input[@id='_1_WAR_mailportlet_to']",
			RuntimeVariables.replace("liferay.qa2@gmail.com"));
		selenium.clickAt("//input[@value='Send']",
			RuntimeVariables.replace("Send"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Sent successfully."),
			selenium.getText("//span[@class='message portlet-msg-success']"));
	}
}