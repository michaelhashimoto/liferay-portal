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

package com.liferay.portalweb.plugins.assetmanagementsystem.portlet.removeportlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RemovePortletAMSTest extends BaseTestCase {
	public void testRemovePortletAMS() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Asset Management System Test Page");
		selenium.clickAt("link=Asset Management System Test Page",
			RuntimeVariables.replace("Asset Management System Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.click("//img[@alt='Remove']");
		selenium.waitForConfirmation(
			"Are you sure you want to remove this component?");
		selenium.waitForElementNotPresent("//section");
		assertTrue(selenium.isElementNotPresent("//section"));
	}
}