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

package com.liferay.portalweb.socialofficesite.forums.mbthread.editpermissionsmbcategory2guestnoview;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditPermissionsMBCategory2GuestNoViewTest extends BaseTestCase {
	public void testEditPermissionsMBCategory2GuestNoView()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard");
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
				assertEquals(RuntimeVariables.replace("Forums"),
					selenium.getText("//nav/ul/li[contains(.,'Forums')]/a/span"));
				selenium.clickAt("//nav/ul/li[contains(.,'Forums')]/a/span",
					RuntimeVariables.replace("Forums"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("MB Category2 Name"),
					selenium.getText("//tr[4]/td/a/strong"));
				selenium.clickAt("//tr[4]/td/a/strong",
					RuntimeVariables.replace("MB Category2 Name"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("MB Category2 Name"),
					selenium.getText("//h1[@class='header-title']"));
				assertTrue(selenium.isVisible("//input[@value='Permissions']"));
				selenium.clickAt("//input[@value='Permissions']",
					RuntimeVariables.replace("Permissions"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("//input[@id='guest_ACTION_VIEW']");

				boolean guestActionChecked = selenium.isChecked(
						"//input[@id='guest_ACTION_VIEW']");

				if (!guestActionChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='guest_ACTION_VIEW']",
					RuntimeVariables.replace("Guest Action Checkbox"));

			case 2:
				assertFalse(selenium.isChecked(
						"//input[@id='guest_ACTION_VIEW']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 100:
				label = -1;
			}
		}
	}
}