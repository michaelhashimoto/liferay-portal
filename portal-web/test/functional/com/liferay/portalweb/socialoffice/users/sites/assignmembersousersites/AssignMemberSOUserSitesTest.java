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

package com.liferay.portalweb.socialoffice.users.sites.assignmembersousersites;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssignMemberSOUserSitesTest extends BaseTestCase {
	public void testAssignMemberSOUserSites() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("//li[contains(@class,'user-menu has-submenu')]/a/span[@class='full-name']",
					RuntimeVariables.replace("User Name"));
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Sites", RuntimeVariables.replace("Sites"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_134_name']",
					RuntimeVariables.replace("Site "));
				selenium.clickAt("//form[contains(@id,'_134_')]/span/span[2]/span/input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Site Name"),
					selenium.getText("//tr[3]/td[1]/a"));
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//span[@title='Actions']/ul/li/strong/a/span"));
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Manage Memberships')]/a");
				assertEquals(RuntimeVariables.replace("Manage Memberships"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Manage Memberships')]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Manage Memberships')]/a"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Add Members"),
					selenium.getText(
						"//span[@title='Add Members']/ul/li/strong/a/span"));
				selenium.clickAt("//span[@title='Add Members']/ul/li/strong/a/span",
					RuntimeVariables.replace("Add Members"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'User')]/a");
				assertEquals(RuntimeVariables.replace("User"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'User')]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'User')]/a"));
				selenium.waitForPageToLoad("30000");

				boolean basicVisible = selenium.isVisible("link=\u00ab Basic");

				if (!basicVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace("\u00ab Basic"));

			case 2:
				selenium.type("//input[@name='_174_keywords']",
					RuntimeVariables.replace("socialoffice01"));
				selenium.clickAt("//div[contains(@id,'user_searchbasic')]/span/span[2]/span/input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Social01 Office01 User01"),
					selenium.getText("//tr[3]/td[2]"));
				assertFalse(selenium.isChecked("//input[@name='_174_rowIds']"));
				selenium.clickAt("//input[@name='_174_rowIds']",
					RuntimeVariables.replace("Entry Check Box"));
				assertTrue(selenium.isChecked("//input[@name='_174_rowIds']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.type("//input[@name='_174_keywords']",
					RuntimeVariables.replace("socialoffice01"));
				selenium.clickAt("//div[contains(@id,'user_searchbasic')]/span/span[2]/span/input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Social01 Office01 User01"),
					selenium.getText("//tr[3]/td[1]"));

			case 100:
				label = -1;
			}
		}
	}
}