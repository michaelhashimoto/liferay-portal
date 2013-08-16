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

package com.liferay.portalweb.portal.tags.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertTagsInTagsAdminTest extends BaseTestCase {
	public void testAssertTagsInTagsAdmin() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Tags", RuntimeVariables.replace("Tags"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("xPath=(//span[@class='tag-item']/a)[1]");
		assertEquals(RuntimeVariables.replace("selenium1 liferay1"),
			selenium.getText("xPath=(//span[@class='tag-item']/a)[1]"));
		assertEquals(RuntimeVariables.replace("selenium2 liferay2"),
			selenium.getText("xPath=(//span[@class='tag-item']/a)[2]"));
		assertEquals(RuntimeVariables.replace("selenium3 liferay3"),
			selenium.getText("xPath=(//span[@class='tag-item']/a)[3]"));
		assertEquals(RuntimeVariables.replace("selenium4 liferay4"),
			selenium.getText("xPath=(//span[@class='tag-item']/a)[4]"));
		assertEquals(RuntimeVariables.replace("test"),
			selenium.getText("xPath=(//span[@class='tag-item']/a)[5]"));
	}
}