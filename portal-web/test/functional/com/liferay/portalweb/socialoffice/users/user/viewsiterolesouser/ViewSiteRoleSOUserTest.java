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

package com.liferay.portalweb.socialoffice.users.user.viewsiterolesouser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSiteRoleSOUserTest extends BaseTestCase {
	public void testViewSiteRoleSOUser() throws Exception {
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
				selenium.clickAt("link=Users and Organizations",
					RuntimeVariables.replace("Users and Organizations"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Search All Users",
					RuntimeVariables.replace("Search All Users"));
				selenium.waitForPageToLoad("30000");

				boolean basicVisible = selenium.isVisible(
						"//a[.='\u00ab Basic']");

				if (!basicVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//a[.='\u00ab Basic']",
					RuntimeVariables.replace("\u00ab Basic"));

			case 2:
				selenium.waitForVisible(
					"//input[@id='_125_toggle_id_users_admin_user_searchkeywords']");
				selenium.type("//input[@id='_125_toggle_id_users_admin_user_searchkeywords']",
					RuntimeVariables.replace("socialoffice01"));
				selenium.clickAt("//div[contains(@id,'user_searchbasic')]/span/span[2]/span/input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Social01"),
					selenium.getText("//td[contains(.,'Social01')]/a"));
				selenium.clickAt("//td[contains(.,'Social01')]/a",
					RuntimeVariables.replace("Social01"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isPartialText("//a[@id='_125_rolesLink']",
						"Roles"));
				selenium.clickAt("//a[@id='_125_rolesLink']",
					RuntimeVariables.replace("Roles"));
				selenium.waitForVisible("//tr[contains(., 'Power User')]/td");
				assertEquals(RuntimeVariables.replace("Power User"),
					selenium.getText("//tr[contains(., 'Power User')]/td"));
				assertEquals(RuntimeVariables.replace("Roles Siterole Name"),
					selenium.getText(
						"//div[@id='_125_communityRolesSearchContainer']/div/table/tbody/tr[3]/td"));
				assertEquals(RuntimeVariables.replace("Open Site Name"),
					selenium.getText(
						"//div[@id='_125_communityRolesSearchContainer']/div/table/tbody/tr[3]/td[2]"));

			case 100:
				label = -1;
			}
		}
	}
}