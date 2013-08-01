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

package com.liferay.portalweb.portal.permissions.imagegallery.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_DisableAllowAccessInControlPanelPermissionsTest
	extends BaseTestCase {
	public void testSA_DisableAllowAccessInControlPanelPermissions()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent(
			"link=Image Gallery Permissions Test Page");
		selenium.clickAt("link=Image Gallery Permissions Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//strong/a", RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		selenium.click("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		selenium.waitForVisible("//tr[7]/td[2]/input");
		assertTrue(selenium.isElementPresent(
				"//tr[7]/td[2]/input[@disabled='']"));
		assertFalse(selenium.isChecked("//tr[7]/td[2]/input[@disabled='']"));
		selenium.clickAt("//tr[7]/td[2]/input[@disabled='']",
			RuntimeVariables.replace(""));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@id='p_p_id_86_']/div/div[1]"));
		assertFalse(selenium.isChecked("//tr[7]/td[2]/input[@disabled='']"));
	}
}