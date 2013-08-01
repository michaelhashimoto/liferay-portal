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

package com.liferay.portalweb.portlet.directory.organizations.searchorganization;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchOrganizationQuotesTest extends BaseTestCase {
	public void testSearchOrganizationQuotes() throws Exception {
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
				selenium.clickAt("link=Organizations",
					RuntimeVariables.replace("Organizations"));
				selenium.waitForPageToLoad("30000");

				boolean basicVisible = selenium.isVisible(
						"//div/div/a[contains(.,'Basic')]");

				if (!basicVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div/div/a[contains(.,'Basic')]",
					RuntimeVariables.replace("Basic \u00bb"));

			case 2:
				selenium.type("//input[@name='_11_keywords']",
					RuntimeVariables.replace("\"Test Organization\""));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@name='_11_keywords']",
					RuntimeVariables.replace(""));
				assertTrue(selenium.isElementPresent("link=Test Organization"));
				selenium.type("//input[@name='_11_keywords']",
					RuntimeVariables.replace("\"Test1 Organization1\""));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@name='_11_keywords']",
					RuntimeVariables.replace(""));
				assertFalse(selenium.isTextPresent("Test Organization"));

			case 100:
				label = -1;
			}
		}
	}
}