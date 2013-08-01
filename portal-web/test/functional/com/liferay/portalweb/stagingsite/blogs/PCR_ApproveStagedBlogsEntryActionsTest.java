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

package com.liferay.portalweb.stagingsite.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class PCR_ApproveStagedBlogsEntryActionsTest extends BaseTestCase {
	public void testPCR_ApproveStagedBlogsEntryActions()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/dockbar_underlay.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace("link=My Workflow Tasks"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[3]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'Blogs Entry Title')]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[5]/a"));
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to your roles."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//tr[contains(.,'Blogs Entry Title')]/td[6]/span[@title='Actions']/ul/li/strong/a/span"));
		selenium.clickAt("//tr[contains(.,'Blogs Entry Title')]/td[6]/span[@title='Actions']/ul/li/strong/a/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Approve')]");
		assertEquals(RuntimeVariables.replace("Approve"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Approve')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Approve')]",
			RuntimeVariables.replace("Approve"));
		selenium.waitForVisible("//button[contains(.,'OK')]");
		assertEquals(RuntimeVariables.replace("OK"),
			selenium.getText("//button[contains(.,'OK')]"));
		selenium.clickAt("//button[contains(.,'OK')]",
			RuntimeVariables.replace("OK"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to you."),
			selenium.getText("xPath=(//div[@class='portlet-msg-info'])[1]"));
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to your roles."),
			selenium.getText("xPath=(//div[@class='portlet-msg-info'])[2]"));
		selenium.clickAt("//span/a[contains(.,'Completed')]",
			RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[3]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'Blogs Entry Title')]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[5]/a"));
	}
}