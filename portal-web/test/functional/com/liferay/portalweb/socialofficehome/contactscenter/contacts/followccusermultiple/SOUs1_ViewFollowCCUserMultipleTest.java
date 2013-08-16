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

package com.liferay.portalweb.socialofficehome.contactscenter.contacts.followccusermultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs1_ViewFollowCCUserMultipleTest extends BaseTestCase {
	public void testSOUs1_ViewFollowCCUserMultiple() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible(
			"//nav/ul/li[contains(.,'Contacts Center')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Contacts Center')]/a/span",
			RuntimeVariables.replace("Contacts Center"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("You have 0 connections."),
			selenium.getText("link=You have 0 connections."));
		selenium.clickAt("link=You have 0 connections.",
			RuntimeVariables.replace("You have 0 connections."));
		selenium.waitForText("//div[@class='empty']", "There are no results.");
		assertEquals(RuntimeVariables.replace("There are no results."),
			selenium.getText("//div[@class='empty']"));
		assertEquals(RuntimeVariables.replace("You are following 0 people."),
			selenium.getText("link=You are following 0 people."));
		selenium.clickAt("link=You are following 0 people.",
			RuntimeVariables.replace("You are following 0 people."));
		selenium.waitForText("//div[@class='empty']", "There are no results.");
		assertEquals(RuntimeVariables.replace("There are no results."),
			selenium.getText("//div[@class='empty']"));
	}
}