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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.social.activities;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPortletActivitiesTest extends BaseTestCase {
	public void testAddPortletActivities() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/joebloggs/home/");
		selenium.clickAt("link=Activities Page",
			RuntimeVariables.replace("Activities Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForVisible("link=Add Application");
		selenium.clickAt("link=Add Application",
			RuntimeVariables.replace("Add Application"));
		selenium.waitForVisible("//input[@id='layout_configuration_content']");
		selenium.sendKeys("//input[@id='layout_configuration_content']",
			RuntimeVariables.replace("a"));
		selenium.waitForVisible("//div[@title='Activities']/p/a");
		selenium.clickAt("//div[@title='Activities']/p/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//td[1]/div/div[1]/div");
		assertTrue(selenium.isVisible("//td[1]/div/div[1]/div"));
	}
}