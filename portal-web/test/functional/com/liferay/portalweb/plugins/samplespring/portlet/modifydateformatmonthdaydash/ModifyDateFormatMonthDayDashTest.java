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

package com.liferay.portalweb.plugins.samplespring.portlet.modifydateformatmonthdaydash;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ModifyDateFormatMonthDayDashTest extends BaseTestCase {
	public void testModifyDateFormatMonthDayDash() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Pets Test Page",
			RuntimeVariables.replace("Pets Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Edit Mode"),
			selenium.getText("//div/div/a"));
		selenium.clickAt("//div/div/a", RuntimeVariables.replace("Edit Mode"));
		selenium.waitForText("//div[@class='portlet-body']/h1",
			"Modify Preferences");
		assertEquals(RuntimeVariables.replace("Modify Preferences"),
			selenium.getText("//div[@class='portlet-body']/h1"));
		assertEquals(RuntimeVariables.replace(
				"Current Date Format is: MM/dd/yyyy"),
			selenium.getText("//div[@class='portlet-body']/p"));
		assertTrue(selenium.isVisible("//select[@name='dateFormat']"));
		selenium.select("//select[@name='dateFormat']",
			RuntimeVariables.replace("MM-dd-yyyy"));
		selenium.clickAt("//button[@type='submit']",
			RuntimeVariables.replace("Modify"));
		selenium.waitForText("//div[@class='portlet-body']/p",
			"Current Date Format is: MM-dd-yyyy");
		assertEquals(RuntimeVariables.replace(
				"Current Date Format is: MM-dd-yyyy"),
			selenium.getText("//div[@class='portlet-body']/p"));
		assertEquals(RuntimeVariables.replace("View Mode"),
			selenium.getText("//div/div/a"));
		selenium.clickAt("//div/div/a", RuntimeVariables.replace("View Mode"));
		selenium.waitForText("//div/div/a", "Edit Mode");
		assertEquals(RuntimeVariables.replace("Edit Mode"),
			selenium.getText("//div/div/a"));
	}
}