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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.community.membershiprequest;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUserMRTest extends BaseTestCase {
	public void testAddUserMR() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Users", RuntimeVariables.replace("Users"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Add", RuntimeVariables.replace("Add"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@name='_125_prefixId']",
			RuntimeVariables.replace("label=Mr."));
		selenium.type("//input[@name='_125_screenName']",
			RuntimeVariables.replace("requestmembersn"));
		selenium.type("//input[@name='_125_emailAddress']",
			RuntimeVariables.replace("requestmemberea@liferay.com"));
		selenium.type("//input[@name='_125_firstName']",
			RuntimeVariables.replace("requestmemberfn"));
		selenium.type("//input[@name='_125_lastName']",
			RuntimeVariables.replace("requestmemberln"));
		selenium.select("//select[@name='_125_birthdayMonth']",
			RuntimeVariables.replace("label=April"));
		selenium.select("//select[@name='_125_birthdayDay']",
			RuntimeVariables.replace("label=10"));
		selenium.select("//select[@name='_125_birthdayYear']",
			RuntimeVariables.replace("label=1986"));
		selenium.select("//select[@name='_125_male']",
			RuntimeVariables.replace("label=Male"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("requestmembersn",
			selenium.getValue("//input[@name='_125_screenName']"));
		assertEquals("requestmemberea@liferay.com",
			selenium.getValue("//input[@name='_125_emailAddress']"));
		assertEquals("requestmemberfn",
			selenium.getValue("//input[@name='_125_firstName']"));
		assertEquals("requestmemberln",
			selenium.getValue("//input[@name='_125_lastName']"));
	}
}