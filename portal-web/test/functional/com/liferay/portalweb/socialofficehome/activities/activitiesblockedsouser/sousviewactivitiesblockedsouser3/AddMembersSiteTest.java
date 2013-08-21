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

package com.liferay.portalweb.socialofficehome.activities.activitiesblockedsouser.sousviewactivitiesblockedsouser3;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMembersSiteTest extends BaseTestCase {
	public void testAddMembersSite() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.clickAt("//input[contains(@class,'search-input')]",
					RuntimeVariables.replace("Go to"));
				selenium.waitForVisible("//input[@class='search-input focus']");
				selenium.type("//input[@class='search-input focus']",
					RuntimeVariables.replace("Open"));
				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Open Site Name"),
					selenium.getText(
						"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
				selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
					RuntimeVariables.replace("Open Site Name"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//a[contains(@id,'toggleDockbar')]",
					RuntimeVariables.replace("Toggle Dockbar"));
				selenium.waitForElementPresent(
					"//body[contains(@class,'show-dockbar')]");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				assertEquals(RuntimeVariables.replace("Manage"),
					selenium.getText("//li[@id='_145_manageContent']/a/span"));
				selenium.mouseOver("//li[@id='_145_manageContent']/a/span");
				selenium.waitForVisible("link=Site Memberships");
				selenium.clickAt("link=Site Memberships",
					RuntimeVariables.replace("Site Memberships"));
				Thread.sleep(5000);
				selenium.waitForVisible(
					"//span[@title='Add Members']/ul/li/strong/a");
				assertEquals(RuntimeVariables.replace("Add Members"),
					selenium.getText(
						"//span[@title='Add Members']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Add Members']/ul/li/strong/a",
					RuntimeVariables.replace("Add Members"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'User')]");
				assertEquals(RuntimeVariables.replace("User"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'User')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'User')]",
					RuntimeVariables.replace("User"));
				selenium.waitForPageToLoad("30000");

				boolean basicVisible = selenium.isVisible(
						"//a[.='\u00ab Basic']");

				if (!basicVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//a[.='\u00ab Basic']",
					RuntimeVariables.replace("\u00ab Basic"));
				selenium.waitForVisible("//input[@name='_174_keywords']");

			case 2:
				selenium.type("//input[@name='_174_keywords']",
					RuntimeVariables.replace("social"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertFalse(selenium.isChecked(
						"//input[@name='_174_allRowIds']"));
				selenium.clickAt("//input[@name='_174_allRowIds']",
					RuntimeVariables.replace("Select All"));
				assertTrue(selenium.isChecked("//input[@name='_174_allRowIds']"));
				assertTrue(selenium.isVisible(
						"//input[contains(@onclick,'updateGroupUsers')]"));
				selenium.clickAt("//input[contains(@onclick,'updateGroupUsers')]",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertEquals(RuntimeVariables.replace(
						"Social01 Office01 User01"),
					selenium.getText(
						"//td[@id='_174_usersSearchContainer_col-name_row-socialoffice01']"));
				assertEquals(RuntimeVariables.replace(
						"Social02 Office02 User02"),
					selenium.getText(
						"//td[@id='_174_usersSearchContainer_col-name_row-socialoffice02']"));
				assertEquals(RuntimeVariables.replace(
						"Social03 Office03 User03"),
					selenium.getText(
						"//td[@id='_174_usersSearchContainer_col-name_row-socialoffice03']"));

			case 100:
				label = -1;
			}
		}
	}
}