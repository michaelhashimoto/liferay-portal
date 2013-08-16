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

package com.liferay.portalweb.portal.permissions.imagegallery.assertactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SiteAdmin_RemoveGuestViewImagePermissionsTest extends BaseTestCase {
	public void testSiteAdmin_RemoveGuestViewImagePermissions()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Media Gallery Test Page",
					RuntimeVariables.replace("Media Gallery Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Media Gallery Permissions Test Folder 2 Edited"),
					selenium.getText(
						"//a[@title='Media Gallery Permissions Test Folder 2 Edited - ']"));
				selenium.clickAt("//a[@title='Media Gallery Permissions Test Folder 2 Edited - ']",
					RuntimeVariables.replace(
						"Media Gallery Permissions Test Folder 2 Edited"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Media Gallery Permissions Test Subfolder 2"),
					selenium.getText(
						"//a[@title='Media Gallery Permissions Test Subfolder 2 - ']"));
				selenium.clickAt("//a[@title='Media Gallery Permissions Test Subfolder 2 - ']",
					RuntimeVariables.replace(
						"Media Gallery Permissions Test Subfolder 2"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Permissions Image Test Edited"),
					selenium.getText(
						"//a[@title='Permissions Image Test Edited - ']"));
				selenium.clickAt("//a[@title='Permissions Image Test Edited - ']",
					RuntimeVariables.replace("Permissions Image Test Edited"));
				Thread.sleep(5000);
				assertTrue(selenium.isVisible("//img[@title='Permissions']"));
				selenium.clickAt("//img[@title='Permissions']",
					RuntimeVariables.replace("Permissions"));
				Thread.sleep(5000);

				boolean actionViewCheckbox = selenium.isChecked(
						"//input[@name='16_ACTION_VIEW']");

				if (!actionViewCheckbox) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@name='16_ACTION_VIEW']",
					RuntimeVariables.replace("Action View Checkbox"));

			case 2:
				assertFalse(selenium.isChecked(
						"//input[@name='16_ACTION_VIEW']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 100:
				label = -1;
			}
		}
	}
}