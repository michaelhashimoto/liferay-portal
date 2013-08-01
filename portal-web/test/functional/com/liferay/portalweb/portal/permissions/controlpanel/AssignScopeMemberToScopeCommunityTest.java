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

package com.liferay.portalweb.portal.permissions.controlpanel;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssignScopeMemberToScopeCommunityTest extends BaseTestCase {
	public void testAssignScopeMemberToScopeCommunity()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.waitForElementPresent("link=Communities");
		selenium.clickAt("link=Communities", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("_134_name");
		selenium.type("_134_name", RuntimeVariables.replace("Scope Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//strong", RuntimeVariables.replace(""));
		selenium.waitForElementPresent(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[5]/a");
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[5]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("link=Available");
		selenium.clickAt("link=Available", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_134_keywords", RuntimeVariables.replace("scope"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("_134_allRowIds", RuntimeVariables.replace(""));
		selenium.clickAt("//input[@value='Update Associations']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"Your request completed successfully."));
	}
}