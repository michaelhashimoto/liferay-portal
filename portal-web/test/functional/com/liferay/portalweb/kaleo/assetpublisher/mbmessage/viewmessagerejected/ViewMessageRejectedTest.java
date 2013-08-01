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

package com.liferay.portalweb.kaleo.assetpublisher.mbmessage.viewmessagerejected;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMessageRejectedTest extends BaseTestCase {
	public void testViewMessageRejected() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("There are no results."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertFalse(selenium.isTextPresent("Message Boards Message Subject"));
		assertFalse(selenium.isTextPresent("Message Boards Message Body"));
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
		selenium.clickAt("link=My Workflow Tasks",
			RuntimeVariables.replace("My Workflow Tasks"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Pending", RuntimeVariables.replace("Pending"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Update"),
			selenium.getText(
				"//tr[contains(.,'Message Boards Message Subject')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Message Boards Message Subject"),
			selenium.getText(
				"//tr[contains(.,'Message Boards Message Subject')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Message Boards Message"),
			selenium.getText(
				"//tr[contains(.,'Message Boards Message Subject')]/td[3]/a"));
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'Message Boards Message Subject')]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText(
				"//tr[contains(.,'Message Boards Message Subject')]/td[5]/a"));
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to your roles."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText(
				"//tr[contains(.,'Message Boards Message Subject')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Message Boards Message Subject"),
			selenium.getText(
				"//tr[contains(.,'Message Boards Message Subject')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Message Boards Message"),
			selenium.getText(
				"//tr[contains(.,'Message Boards Message Subject')]/td[3]/a"));
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'Message Boards Message Subject')]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText(
				"//tr[contains(.,'Message Boards Message Subject')]/td[5]/a"));
	}
}