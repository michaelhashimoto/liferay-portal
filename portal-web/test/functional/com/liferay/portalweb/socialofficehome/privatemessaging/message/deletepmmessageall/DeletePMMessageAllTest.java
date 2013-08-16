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

package com.liferay.portalweb.socialofficehome.privatemessaging.message.deletepmmessageall;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DeletePMMessageAllTest extends BaseTestCase {
	public void testDeletePMMessageAll() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.waitForVisible(
					"//nav/ul/li[contains(.,'Messages')]/a/span");
				selenium.clickAt("//nav/ul/li[contains(.,'Messages')]/a/span",
					RuntimeVariables.replace("Messages"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Private Messaging"),
					selenium.getText(
						"xPath=(//span[@class='portlet-title-default'])[contains(.,'Private Messaging')]"));
				assertEquals("Mark as Unread",
					selenium.getValue("//input[@value='Mark as Unread']"));
				assertEquals("Delete",
					selenium.getValue("//input[@value='Delete']"));
				assertEquals("New Message",
					selenium.getValue("//input[@value='New Message']"));
				assertEquals(RuntimeVariables.replace(
						"Social01 Office01 User01"),
					selenium.getText(
						"xPath=(//span[@class='author-sender'])[1]"));
				assertEquals(RuntimeVariables.replace("Message3 Subject"),
					selenium.getText("xPath=(//div[@class='subject'])[1]"));
				assertEquals(RuntimeVariables.replace("Message3 Body"),
					selenium.getText("xPath=(//div[@class='body'])[1]"));
				assertEquals(RuntimeVariables.replace(
						"Social01 Office01 User01"),
					selenium.getText(
						"xPath=(//span[@class='author-sender'])[2]"));
				assertEquals(RuntimeVariables.replace("Message2 Subject"),
					selenium.getText("xPath=(//div[@class='subject'])[2]"));
				assertEquals(RuntimeVariables.replace("Message2 Body"),
					selenium.getText("xPath=(//div[@class='body'])[2]"));
				assertEquals(RuntimeVariables.replace(
						"Social01 Office01 User01"),
					selenium.getText(
						"xPath=(//span[@class='author-sender'])[3]"));
				assertEquals(RuntimeVariables.replace("Message1 Subject"),
					selenium.getText("xPath=(//div[@class='subject'])[3]"));
				assertEquals(RuntimeVariables.replace("Message1 Body"),
					selenium.getText("xPath=(//div[@class='body'])[3]"));
				assertEquals(RuntimeVariables.replace("Showing 3 results."),
					selenium.getText("//div[@class='search-results']"));
				assertTrue(selenium.isElementPresent(
						"//td[1]/span/span/span/input[2]"));

				boolean message1Checked = selenium.isChecked(
						"//td[1]/span/span/span/input[2]");

				if (!message1Checked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//td[1]/span/span/span/input[2]",
					RuntimeVariables.replace("Uncheck"));

			case 2:
				assertTrue(selenium.isElementPresent(
						"//tr[4]/td[1]/span/span/span/input[2]"));

				boolean message2Checked = selenium.isChecked(
						"//tr[4]/td[1]/span/span/span/input[2]");

				if (!message2Checked) {
					label = 3;

					continue;
				}

				selenium.clickAt("//tr[4]/td[1]/span/span/span/input[2]",
					RuntimeVariables.replace("Uncheck"));

			case 3:
				assertTrue(selenium.isElementPresent(
						"//tr[5]/td[1]/span/span/span/input[2]"));

				boolean message3Checked = selenium.isChecked(
						"//tr[5]/td[1]/span/span/span/input[2]");

				if (!message3Checked) {
					label = 4;

					continue;
				}

				selenium.clickAt("//tr[5]/td[1]/span/span/span/input[2]",
					RuntimeVariables.replace("Uncheck"));

			case 4:
				assertFalse(selenium.isChecked(
						"//td[1]/span/span/span/input[2]"));
				assertFalse(selenium.isChecked(
						"//tr[4]/td[1]/span/span/span/input[2]"));
				assertFalse(selenium.isChecked(
						"//tr[5]/td[1]/span/span/span/input[2]"));
				selenium.waitForVisible(
					"//input[@id='_1_WAR_privatemessagingportlet_checkAll']");
				selenium.clickAt("//input[@id='_1_WAR_privatemessagingportlet_checkAll']",
					RuntimeVariables.replace("All"));
				assertTrue(selenium.isChecked("//td[1]/span/span/span/input[2]"));
				assertTrue(selenium.isChecked(
						"//tr[4]/td[1]/span/span/span/input[2]"));
				assertTrue(selenium.isChecked(
						"//tr[5]/td[1]/span/span/span/input[2]"));
				assertEquals("Delete",
					selenium.getValue("//input[@value='Delete']"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("//div[@class='portlet-msg-info']");
				assertEquals(RuntimeVariables.replace("No messages found."),
					selenium.getText("//div[@class='portlet-msg-info']"));

			case 100:
				label = -1;
			}
		}
	}
}