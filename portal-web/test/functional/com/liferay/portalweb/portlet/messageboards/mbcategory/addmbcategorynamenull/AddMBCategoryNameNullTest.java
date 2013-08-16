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

package com.liferay.portalweb.portlet.messageboards.mbcategory.addmbcategorynamenull;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMBCategoryNameNullTest extends BaseTestCase {
	public void testAddMBCategoryNameNull() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Category']",
			RuntimeVariables.replace("Add Category"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//textarea[@id='_19_description']",
			RuntimeVariables.replace("MB Category Description"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible(
			"//div[@class='aui-form-validator-message required']");
		assertTrue(selenium.isVisible(
				"//div[@class='aui-form-validator-message required']"));
		assertEquals(RuntimeVariables.replace("This field is required."),
			selenium.getText(
				"//div[@class='aui-form-validator-message required']"));
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Message Boards Test Page");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("MB Category Description"));
		assertTrue(selenium.isElementNotPresent(
				"//span[@title='Actions']/ul/li/strong/a"));
	}
}