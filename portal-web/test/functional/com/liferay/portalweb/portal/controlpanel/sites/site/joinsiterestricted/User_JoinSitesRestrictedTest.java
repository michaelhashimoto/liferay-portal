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

package com.liferay.portalweb.portal.controlpanel.sites.site.joinsiterestricted;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_JoinSitesRestrictedTest extends BaseTestCase {
	public void testUser_JoinSitesRestricted() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/usersn/home/");
		selenium.clickAt("link=My Sites", RuntimeVariables.replace("My Sites"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("No sites were found."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.open("/user/usersn/home/");
		selenium.clickAt("link=Available Sites",
			RuntimeVariables.replace("Available Sites"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_29_name']",
			RuntimeVariables.replace("Site Name"));
		selenium.clickAt("xPath=(//input[@value='Search'])[3]",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//tr[contains(.,'Site Name')]/td[1]", "Site Name"));
		assertTrue(selenium.isPartialText(
				"//tr[contains(.,'Site Name')]/td[1]", "Site Description"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//tr[contains(.,'Site Name')]/td[2]"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[contains(.,'Site Name')]/td[3]"));
		assertEquals(RuntimeVariables.replace("Request Membership"),
			selenium.getText("//tr[contains(.,'Site Name')]/td[4]/span/a/span"));
		selenium.clickAt("//tr[contains(.,'Site Name')]/td[4]/span/a/span",
			RuntimeVariables.replace("Request Membership"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//textarea[@id='_29_comments']",
			RuntimeVariables.replace(
				"I want to join this really cool community please."));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("xPath=(//div[@class='portlet-msg-success'])[1]"));
		assertEquals(RuntimeVariables.replace(
				"Your request was sent. You will receive a reply by email."),
			selenium.getText("xPath=(//div[@class='portlet-msg-success'])[2]"));
		assertTrue(selenium.isPartialText(
				"//tr[contains(.,'Site Name')]/td[1]", "Site Name"));
		assertTrue(selenium.isPartialText(
				"//tr[contains(.,'Site Name')]/td[1]", "Site Description"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//tr[contains(.,'Site Name')]/td[2]"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[contains(.,'Site Name')]/td[3]"));
		assertEquals(RuntimeVariables.replace("Membership Requested"),
			selenium.getText("//tr[contains(.,'Site Name')]/td[4]/span/span"));
	}
}