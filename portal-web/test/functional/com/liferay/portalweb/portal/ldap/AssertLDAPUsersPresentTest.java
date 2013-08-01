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

package com.liferay.portalweb.portal.ldap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertLDAPUsersPresentTest extends BaseTestCase {
	public void testAssertLDAPUsersPresent() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace("link=Users and Organizations"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Search All Users",
			RuntimeVariables.replace("Search All Users"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='_125_keywords']",
			RuntimeVariables.replace("jane"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Jane"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Smith"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("janesmith"),
			selenium.getText("//td[4]/a"));
		assertFalse(selenium.isTextPresent("No users were found."));
		selenium.type("//input[@name='_125_keywords']",
			RuntimeVariables.replace("luke"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Luke"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Skywalker"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("lukeskywalker"),
			selenium.getText("//td[4]/a"));
		assertFalse(selenium.isTextPresent("No users were found."));
		selenium.type("//input[@name='_125_keywords']",
			RuntimeVariables.replace("martin"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Martin"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Luther"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("martinluther"),
			selenium.getText("//td[4]/a"));
		assertFalse(selenium.isTextPresent("No users were found."));
		System.out.println("LDAP Users have been imported into Liferay.");
	}
}