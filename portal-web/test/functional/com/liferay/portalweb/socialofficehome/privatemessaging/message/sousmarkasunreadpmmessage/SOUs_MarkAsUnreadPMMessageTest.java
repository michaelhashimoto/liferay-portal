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

package com.liferay.portalweb.socialofficehome.privatemessaging.message.sousmarkasunreadpmmessage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_MarkAsUnreadPMMessageTest extends BaseTestCase {
	public void testSOUs_MarkAsUnreadPMMessage() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/socialoffice01/so/dashboard");
				selenium.waitForVisible(
					"//nav/ul/li[contains(.,'Messages')]/a/span");
				selenium.clickAt("//nav/ul/li[contains(.,'Messages')]/a/span",
					RuntimeVariables.replace("Messages"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementNotPresent(
						"//tr[contains(@class, 'unread')]"));
				assertEquals(RuntimeVariables.replace("Private Messaging"),
					selenium.getText(
						"xPath=(//span[@class='portlet-title-default'])[contains(.,'Private Messaging')]"));
				assertEquals("Mark as Unread",
					selenium.getValue("//input[@value='Mark as Unread']"));
				assertEquals("Delete",
					selenium.getValue("//input[@value='Delete']"));
				assertEquals("New Message",
					selenium.getValue("//input[@value='New Message']"));
				assertEquals(RuntimeVariables.replace("Joe Bloggs"),
					selenium.getText("//span[@class='author-sender']"));
				assertEquals(RuntimeVariables.replace("Message Subject"),
					selenium.getText("//div[@class='subject']"));
				assertEquals(RuntimeVariables.replace("Message Body"),
					selenium.getText("//div[@class='body']"));
				assertEquals(RuntimeVariables.replace("Showing 1 result."),
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
				assertFalse(selenium.isChecked(
						"//td[1]/span/span/span/input[2]"));
				selenium.clickAt("//td[1]/span/span/span/input[2]",
					RuntimeVariables.replace("All"));
				assertTrue(selenium.isChecked("//td[1]/span/span/span/input[2]"));
				assertEquals("Mark as Unread",
					selenium.getValue("//input[@value='Mark as Unread']"));
				selenium.clickAt("//input[@value='Mark as Unread']",
					RuntimeVariables.replace("Mark as Unread"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent(
						"//tr[contains(@class, 'unread')]"));

			case 100:
				label = -1;
			}
		}
	}
}