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

package com.liferay.portalweb.portal.permissions.documentsandmedia.portlet.userviewdmportletinline;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class PermissionsUserViewPortletOffTest extends BaseTestCase {
	public void testPermissionsUserViewPortletOff() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Documents and Media Test Page",
					RuntimeVariables.replace("Documents and Media Test Page"));
				selenium.waitForPageToLoad("30000");
				Thread.sleep(5000);
				assertEquals(RuntimeVariables.replace("Home"),
					selenium.getText("//span[@class='entry-title']"));
				selenium.clickAt("//span/span/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Permissions')]");
				assertEquals(RuntimeVariables.replace("Permissions"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Permissions')]"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Permissions')]"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Roles Regrole Name"),
					selenium.getText("//tr[6]/td[1]/a"));
				assertEquals(RuntimeVariables.replace("View"),
					selenium.getText("//tr[1]/th[10]"));

				boolean viewPermissionChecked = selenium.isChecked(
						"//tr[6]/td[10]/input");

				if (!viewPermissionChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//tr[6]/td[10]/input",
					RuntimeVariables.replace("View Permission"));

			case 2:
				assertFalse(selenium.isChecked("//tr[6]/td[10]/input"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertFalse(selenium.isChecked("//tr[6]/td[10]/input"));

			case 100:
				label = -1;
			}
		}
	}
}