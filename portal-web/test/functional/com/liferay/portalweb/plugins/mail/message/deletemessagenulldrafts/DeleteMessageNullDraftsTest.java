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

package com.liferay.portalweb.plugins.mail.message.deletemessagenulldrafts;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DeleteMessageNullDraftsTest extends BaseTestCase {
	public void testDeleteMessageNullDrafts() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home");
		selenium.waitForVisible("link=Mail Test Page");
		selenium.click(RuntimeVariables.replace("link=Mail Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("liferay.qa.testing@gmail.com"),
			selenium.getText("//div/div/div[1]/div/ul/li/span/span/a"));
		selenium.clickAt("//div/div/div[1]/div/ul/li/span/span/a",
			RuntimeVariables.replace("liferay.qa.testing@gmail.com"));
		selenium.waitForVisible("//a[contains(.,'Drafts')]");
		assertTrue(selenium.isPartialText("//a[contains(.,'Drafts')]", "Drafts"));
		selenium.clickAt("//a[contains(.,'Drafts')]",
			RuntimeVariables.replace("Drafts"));
		Thread.sleep(5000);
		selenium.waitForVisible("//input[@value='Delete']");
		selenium.clickAt("//input[@value='Delete']",
			RuntimeVariables.replace("Delete"));
		selenium.waitForText("//span[@class='message portlet-msg-error']",
			"No messages selected.");
		assertEquals(RuntimeVariables.replace("No messages selected."),
			selenium.getText("//span[@class='message portlet-msg-error']"));
	}
}