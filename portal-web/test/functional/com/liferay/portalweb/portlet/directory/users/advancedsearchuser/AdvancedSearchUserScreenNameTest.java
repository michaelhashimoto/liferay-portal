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

package com.liferay.portalweb.portlet.directory.users.advancedsearchuser;

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
				selenium.clickAt("link=Directory Test Page",
					RuntimeVariables.replace("Directory Test Page"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Users", RuntimeVariables.replace("Users"));
				selenium.waitForPageToLoad("30000");

				boolean advancedVisible = selenium.isVisible(
						"//div/div/a[contains(.,'Advanced')]");

				if (!advancedVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div/div/a[contains(.,'Advanced')]",
					RuntimeVariables.replace("Advanced \u00bb"));

			case 2:
				selenium.waitForVisible("//select[@id='_11_andOperator']");
				selenium.select("//select[@id='_11_andOperator']",
					RuntimeVariables.replace("Any"));
				selenium.type("//input[@id='_11_screenName']",
					RuntimeVariables.replace("usersn"));
				selenium.clickAt("xPath=(//input[@value='Search'])[2]",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_11_screenName']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.isElementPresent("link=userfn"));
				selenium.type("//input[@id='_11_screenName']",
					RuntimeVariables.replace("usersn1"));
				selenium.clickAt("xPath=(//input[@value='Search'])[2]",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				selenium.select("//select[@id='_11_andOperator']",
					RuntimeVariables.replace("All"));
				selenium.type("//input[@id='_11_screenName']",
					RuntimeVariables.replace(""));
				selenium.clickAt("//div/div/a[contains(.,'Basic')]",
					RuntimeVariables.replace("\u00ab Basic"));
				assertFalse(selenium.isPartialText(
						"//div[@id='_11_usersSearchContainer']", "userfn"));
				assertEquals(RuntimeVariables.replace("No users were found."),
					selenium.getText("//div[@class='portlet-msg-info']"));

			case 100:
				label = -1;
			}
		}
	}
}