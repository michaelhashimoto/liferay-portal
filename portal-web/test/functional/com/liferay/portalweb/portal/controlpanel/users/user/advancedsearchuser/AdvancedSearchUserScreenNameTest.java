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

package com.liferay.portalweb.portal.controlpanel.users.user.advancedsearchuser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AdvancedSearchUserScreenNameTest extends BaseTestCase {
	public void testAdvancedSearchUserScreenName() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
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

				boolean advanced1Present = selenium.isVisible(
						"//a[.='Advanced \u00bb']");

				if (!advanced1Present) {
					label = 2;

					continue;
				}

				selenium.clickAt("//a[.='Advanced \u00bb']",
					RuntimeVariables.replace("Advanced \u00bb"));

			case 2:
				selenium.type("//input[@id='_125_screenName']",
					RuntimeVariables.replace("usersn"));
				selenium.clickAt("xPath=(//input[@value='Search'])[2]",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("usersn"));
				selenium.clickAt("link=Users and Organizations",
					RuntimeVariables.replace("Users and Organizations"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Search All Users",
					RuntimeVariables.replace("Search All Users"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForElementPresent("//a[.='Advanced \u00bb']");

				boolean advanced2Visible = selenium.isVisible(
						"//a[.='Advanced \u00bb']");

				if (!advanced2Visible) {
					label = 3;

					continue;
				}

				selenium.clickAt("//a[.='Advanced \u00bb']",
					RuntimeVariables.replace("Advanced \u00bb"));

			case 3:
				selenium.type("//input[@id='_125_screenName']",
					RuntimeVariables.replace("usersn1"));
				selenium.clickAt("xPath=(//input[@value='Search'])[2]",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertFalse(selenium.isTextPresent("usersn"));
				selenium.clickAt("//a[.='\u00ab Basic']",
					RuntimeVariables.replace("\u00ab Basic"));

			case 100:
				label = -1;
			}
		}
	}
}