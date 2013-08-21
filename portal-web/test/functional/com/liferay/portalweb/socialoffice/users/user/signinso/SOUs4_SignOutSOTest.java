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

package com.liferay.portalweb.socialoffice.users.user.signinso;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs4_SignOutSOTest extends BaseTestCase {
	public void testSOUs4_SignOutSO() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");

				boolean socialOfficeUserBarPresent = selenium.isElementPresent(
						"//div[@class='so-portlet-user-bar']");

				if (!socialOfficeUserBarPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("//li[contains(@class,'user-menu has-submenu')]/a/span[@class='full-name']",
					RuntimeVariables.replace("User Name"));

			case 2:
				selenium.waitForVisible("link=Sign Out");
				selenium.clickAt("link=Sign Out",
					RuntimeVariables.replace("Sign Out"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("//input[@value='Sign In']");
				assertTrue(selenium.isVisible("//input[@value='Sign In']"));

			case 100:
				label = -1;
			}
		}
	}
}