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

package com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentscopemycommunity;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWebContentScopeMyCommunityAssignedToMyRolesTest
	extends BaseTestCase {
	public void testViewWebContentScopeMyCommunityAssignedToMyRoles()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/home/");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//strong/a/span",
				"Joe Bloggs's Personal"));
		selenium.clickAt("link=My Workflow Tasks",
			RuntimeVariables.replace("My Workflow Tasks"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Pending", RuntimeVariables.replace("Pending"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to you."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[3]/a"));
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'Web Content Name')]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[5]/a"));
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("There are no completed tasks."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.clickAt("link=My Submissions",
			RuntimeVariables.replace("My Submissions"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Pending", RuntimeVariables.replace("Pending"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Single Approver"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[6]/a"));
		assertEquals(RuntimeVariables.replace("Withdraw Submission"),
			selenium.getText(
				"//td[@class='align-right col-7 col-7 last valign-middle']/span/a/span"));
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"There are no completed publications requested by me."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.clickAt("link=Web Content",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace("//form/ul/li[1]/span/a"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("Pending"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[8]/a"));
		selenium.clickAt("link=Workflow", RuntimeVariables.replace("Workflow"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Submissions",
			RuntimeVariables.replace("Submissions"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Pending", RuntimeVariables.replace("Pending"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Single Approver"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[6]/a"));
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"There are no completed publication requests."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}