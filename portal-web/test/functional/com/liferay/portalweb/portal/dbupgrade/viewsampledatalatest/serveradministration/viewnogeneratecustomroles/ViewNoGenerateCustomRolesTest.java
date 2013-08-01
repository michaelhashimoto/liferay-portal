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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.serveradministration.viewnogeneratecustomroles;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewNoGenerateCustomRolesTest extends BaseTestCase {
	public void testViewNoGenerateCustomRoles() throws Exception {
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
		assertFalse(selenium.isTextPresent(
				"Convert legacy permission algorithm."));
		assertTrue(selenium.isElementNotPresent(
				"//input[@id='_137_com.liferay.portal.convert.ConvertPermissionAlgorithm.generate-custom-rolesCheckbox']"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Execute' and @type='button' and @onclick=\"_137_saveServer('convertProcess.com.liferay.portal.convert.ConvertPermissionAlgorithm');\"]"));
	}
}