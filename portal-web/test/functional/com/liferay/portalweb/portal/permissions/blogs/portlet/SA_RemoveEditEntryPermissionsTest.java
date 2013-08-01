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

package com.liferay.portalweb.portal.permissions.blogs.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_RemoveEditEntryPermissionsTest extends BaseTestCase {
	public void testSA_RemoveEditEntryPermissions() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Blogs Test Page",
					RuntimeVariables.replace("Blogs Test Page"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//div[@class='entry-title']/h2/a",
					RuntimeVariables.replace("Blogs Entry Title"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Permissions",
					RuntimeVariables.replace("Permissions"));
				selenium.waitForPageToLoad("30000");

				boolean portletUpdateChecked = selenium.isChecked(
						"//input[@id='portlet_ACTION_UPDATE']");

				if (!portletUpdateChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='portlet_ACTION_UPDATE']",
					RuntimeVariables.replace("Portlet Update"));

			case 2:
				assertFalse(selenium.isChecked(
						"//input[@id='portlet_ACTION_UPDATE']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertFalse(selenium.isChecked(
						"//input[@id='portlet_ACTION_UPDATE']"));

			case 100:
				label = -1;
			}
		}
	}
}