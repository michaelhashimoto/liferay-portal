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

package com.liferay.portalweb.plugins.novellcollaboration;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPortletTest extends BaseTestCase {
	public void testAddPortlet() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Novell Collaboration Test Page");
		selenium.click(RuntimeVariables.replace(
				"link=Novell Collaboration Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//a[@id='_145_addApplication']",
				"More"));
		selenium.clickAt("//a[@id='_145_addApplication']",
			RuntimeVariables.replace("More"));
		selenium.waitForElementPresent("//div[@title='Bookmark']/p/a");
		selenium.clickAt("//div[@title='Bookmark']/p/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//section");
		assertTrue(selenium.isVisible("//section"));
		selenium.waitForElementPresent("//div[@title='GroupWise Calendar']/p/a");
		selenium.clickAt("//div[@title='GroupWise Calendar']/p/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//section");
		assertTrue(selenium.isVisible("//section"));
		selenium.waitForVisible("//div[2]/section");
		assertTrue(selenium.isVisible("//div[2]/section"));
		selenium.waitForElementPresent("//div[@title='GroupWise Mail']/p/a");
		selenium.clickAt("//div[@title='GroupWise Mail']/p/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//section");
		assertTrue(selenium.isVisible("//section"));
		selenium.waitForVisible("//div[2]/section");
		assertTrue(selenium.isVisible("//div[2]/section"));
		selenium.waitForVisible("//div[3]/section");
		assertTrue(selenium.isVisible("//div[3]/section"));
	}
}