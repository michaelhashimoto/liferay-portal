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

package com.liferay.portalweb.demo.useradmin.usermanagementuserprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCustomFieldTest extends BaseTestCase {
	public void testAddCustomField() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Custom Fields",
			RuntimeVariables.replace("Custom Fields"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("User"),
			selenium.getText("//tr[13]/td[1]/a/strong"));
		selenium.clickAt("//tr[13]/td[1]/a/strong",
			RuntimeVariables.replace("User"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Custom Field']",
			RuntimeVariables.replace("Add Custom Field"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_139_name']",
			RuntimeVariables.replace("Employee"));
		selenium.typeKeys("//select[@id='_139_type']",
			RuntimeVariables.replace("ttttttt"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Employee"),
			selenium.getText("//a[1]/strong"));
		assertEquals(RuntimeVariables.replace("True/False"),
			selenium.getText("//td[2]/a"));
	}
}