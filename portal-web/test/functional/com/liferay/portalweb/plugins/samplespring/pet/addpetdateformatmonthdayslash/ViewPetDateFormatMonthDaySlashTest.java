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

package com.liferay.portalweb.plugins.samplespring.pet.addpetdateformatmonthdayslash;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPetDateFormatMonthDaySlashTest extends BaseTestCase {
	public void testViewPetDateFormatMonthDaySlash() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Pets Test Page",
			RuntimeVariables.replace("Pets Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Pets"),
			selenium.getText("//div[@class='portlet-body']/h1"));
		assertEquals(RuntimeVariables.replace("Bubbles"),
			selenium.getText(
				"//div[@class='portlet-body']/table/tbody/tr[contains(.,'Fish')]/td[contains(.,'Bubbles')]/a"));
		selenium.clickAt("//div[@class='portlet-body']/table/tbody/tr[contains(.,'Fish')]/td[contains(.,'Bubbles')]/a",
			RuntimeVariables.replace("Bubbles"));
		selenium.waitForText("//div[@class='portlet-body']/h1",
			"Pet Info for: Bubbles");
		assertEquals(RuntimeVariables.replace("Species: Fish"),
			selenium.getText("//div[@class='portlet-body']/ul/li[1]"));
		assertEquals(RuntimeVariables.replace("Breed: Goldfish"),
			selenium.getText("//div[@class='portlet-body']/ul/li[2]"));
		assertEquals(RuntimeVariables.replace(
				"Birthdate: Sun Aug 14 00:00:00 GMT 2011"),
			selenium.getText("//div[@class='portlet-body']/ul/li[3]"));
		assertEquals(RuntimeVariables.replace("Description:"),
			selenium.getText("//div[@class='portlet-body']/ul/li[4]"));
	}
}