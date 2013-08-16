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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.serveradministration.executegeneratecustomroles;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ExecuteGenerateCustomRolesTest extends BaseTestCase {
	public void testExecuteGenerateCustomRoles() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Server Administration",
			RuntimeVariables.replace("Server Administration"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Data Migration",
			RuntimeVariables.replace("Data Migration"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Convert legacy permission algorithm."),
			selenium.getText("//div[3]/div/div[1]/div/span"));
		assertTrue(selenium.isElementPresent(
				"//input[@id='_137_com.liferay.portal.convert.ConvertPermissionAlgorithm.generate-custom-rolesCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_137_com.liferay.portal.convert.ConvertPermissionAlgorithm.generate-custom-rolesCheckbox']"));
		selenium.clickAt("//input[@id='_137_com.liferay.portal.convert.ConvertPermissionAlgorithm.generate-custom-rolesCheckbox']",
			RuntimeVariables.replace("Generate Custom Roles Checkbox"));
		assertTrue(selenium.isChecked(
				"//input[@id='_137_com.liferay.portal.convert.ConvertPermissionAlgorithm.generate-custom-rolesCheckbox']"));
		selenium.clickAt("//input[@value='Execute' and @type='button' and @onclick=\"_137_saveServer('convertProcess.com.liferay.portal.convert.ConvertPermissionAlgorithm');\"]",
			RuntimeVariables.replace("Execute"));
	}
}