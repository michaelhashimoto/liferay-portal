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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.community.membershiprequest;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MR_RequestCommunityTest extends BaseTestCase {
	public void testMR_RequestCommunity() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/requestmembersn/home/");
		selenium.waitForVisible("link=Available Sites");
		selenium.clickAt("link=Available Sites",
			RuntimeVariables.replace("Available Sites"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_29_name']",
			RuntimeVariables.replace("Membership Request Community Name"));
		selenium.clickAt("//form/span/span[2]/span/input",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Request Membership"),
			selenium.getText("//span/a/span"));
		selenium.clickAt("//span/a/span",
			RuntimeVariables.replace("Request Membership"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//textarea[@id='_29_comments']",
			RuntimeVariables.replace(
				"Community Description comments request to join"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("xPath=(//div[@class='portlet-msg-success'])[1]"));
		assertEquals(RuntimeVariables.replace(
				"Your request was sent. You will receive a reply by email."),
			selenium.getText("xPath=(//div[@class='portlet-msg-success'])[2]"));
	}
}