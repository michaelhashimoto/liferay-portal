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

package com.liferay.portalweb.portal.permissions.announcements;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AA_AssertActionsTest extends BaseTestCase {
	public void testAA_AssertActions() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Announcements Test Page",
			RuntimeVariables.replace("Announcements Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Edit"));
		assertTrue(selenium.isElementPresent("link=Delete"));
		assertTrue(selenium.isElementPresent("link=Mark as Read"));
		selenium.clickAt("link=Mark as Read",
			RuntimeVariables.replace("Mark as Read"));
		selenium.waitForVisible("link=Show");
		selenium.clickAt("link=Show", RuntimeVariables.replace("Show"));
		selenium.waitForVisible("link=Hide");
		selenium.clickAt("link=Hide", RuntimeVariables.replace("Hide"));
		selenium.waitForVisible("link=Show");
		selenium.waitForElementNotPresent("link=Hide");
		selenium.clickAt("link=Manage Entries",
			RuntimeVariables.replace("Manage Entries"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//input[@value='Add Entry']"));
	}
}