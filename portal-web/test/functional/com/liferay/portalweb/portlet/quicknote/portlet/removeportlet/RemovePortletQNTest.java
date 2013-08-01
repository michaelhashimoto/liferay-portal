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

package com.liferay.portalweb.portlet.quicknote.portlet.removeportlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RemovePortletQNTest extends BaseTestCase {
	public void testRemovePortletQN() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Quick Note Test Page");
		selenium.clickAt("link=Quick Note Test Page",
			RuntimeVariables.replace("Quick Note Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace("//img[@alt='Close']"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementNotPresent(
			"//div/div/div/div/div[@class='portlet-body']");
		assertTrue(selenium.isElementNotPresent(
				"//div/div/div/div/div[@class='portlet-body']"));
	}
}