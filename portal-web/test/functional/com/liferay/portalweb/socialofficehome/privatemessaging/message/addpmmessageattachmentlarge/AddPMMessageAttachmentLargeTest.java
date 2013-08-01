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

package com.liferay.portalweb.socialofficehome.privatemessaging.message.addpmmessageattachmentlarge;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPMMessageAttachmentLargeTest extends BaseTestCase {
	public void testAddPMMessageAttachmentLarge() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible("//nav/ul/li[contains(.,'Messages')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Messages')]/a/span",
			RuntimeVariables.replace("Messages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Private Messaging"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Private Messaging')]"));
		assertEquals("Mark as Unread",
			selenium.getValue("//input[@value='Mark as Unread']"));
		assertEquals("Delete", selenium.getValue("//input[@value='Delete']"));
		assertEquals("New Message",
			selenium.getValue("//input[@value='New Message']"));
		selenium.clickAt("//input[@value='New Message']",
			RuntimeVariables.replace("New Message"));
		selenium.waitForVisible(
			"//button[contains(@class,'autocomplete-button')]/span");
		selenium.clickAt("//button[contains(@class,'autocomplete-button')]/span",
			RuntimeVariables.replace("Dropdown"));
		selenium.sendKeys("//input[@id='_1_WAR_privatemessagingportlet_to']",
			RuntimeVariables.replace("Social01"));
		Thread.sleep(1000);
		selenium.waitForPartialText("//li[contains(@data-text,'Social01 Office01 User01')]",
			"Social01 Office01 User01");
		assertTrue(selenium.isPartialText(
				"//li[contains(@data-text,'Social01 Office01 User01')]",
				"Social01 Office01 User01"));
		selenium.clickAt("//li[contains(@data-text,'Social01 Office01 User01')]",
			RuntimeVariables.replace("Social01 Office01 User01"));
		assertEquals("Social01 Office01 User01 <socialoffice01>,",
			selenium.getValue(
				"//input[@id='_1_WAR_privatemessagingportlet_to']"));
		assertTrue(selenium.isVisible(
				"//input[@id='_1_WAR_privatemessagingportlet_subject']"));
		selenium.type("//input[@id='_1_WAR_privatemessagingportlet_subject']",
			RuntimeVariables.replace("Message Subject"));
		assertTrue(selenium.isVisible(
				"//textarea[@id='_1_WAR_privatemessagingportlet_body']"));
		selenium.type("//textarea[@id='_1_WAR_privatemessagingportlet_body']",
			RuntimeVariables.replace("Message Body"));
		assertTrue(selenium.isVisible(
				"//input[@id='_1_WAR_privatemessagingportlet_msgFile1']"));
		selenium.uploadCommonFile("//input[@id='_1_WAR_privatemessagingportlet_msgFile1']",
			RuntimeVariables.replace("Document_1.mp3"));
		selenium.clickAt("//input[@value='Send']",
			RuntimeVariables.replace("Send"));
		selenium.waitForVisible("//span[@class='portlet-msg-error']");
		assertEquals(RuntimeVariables.replace(
				"Please enter a file with a valid file size no larger than 3000k."),
			selenium.getText("//span[@class='portlet-msg-error']"));
	}
}