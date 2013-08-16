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

package com.liferay.portalweb.portal.permissions.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Member_ReplyMessageTest extends BaseTestCase {
	public void testMember_ReplyMessage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//tr[contains(.,'MB Category Name')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'MB Category Name')]/td[1]/a",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Thread Message Subject"),
			selenium.getText(
				"//tr[contains(.,'MB Thread Message Subject')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'MB Thread Message Subject')]/td[1]/a",
			RuntimeVariables.replace("MB Thread Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Reply"),
			selenium.getText(
				"//ul[@class='edit-controls lfr-component']/li[contains(.,'Reply')]/span/a"));
		selenium.clickAt("//ul[@class='edit-controls lfr-component']/li[contains(.,'Reply')]/span/a",
			RuntimeVariables.replace("Reply"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
			RuntimeVariables.replace("MB Thread Message Body Reply"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("RE: MB Thread Message Subject"),
			selenium.getText(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/div/div[@class='subject']/a"));
		assertEquals(RuntimeVariables.replace("MB Thread Message Body Reply"),
			selenium.getText(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/div[@class='thread-body']"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Edit')]"));
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Permissions')]"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Delete')]"));
	}
}