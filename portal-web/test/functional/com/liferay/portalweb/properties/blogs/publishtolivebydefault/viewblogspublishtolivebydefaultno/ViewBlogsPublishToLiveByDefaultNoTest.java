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

package com.liferay.portalweb.properties.blogs.publishtolivebydefault.viewblogspublishtolivebydefaultno;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsPublishToLiveByDefaultNoTest extends BaseTestCase {
	public void testViewBlogsPublishToLiveByDefaultNo()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Sites", RuntimeVariables.replace("Sites"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Site"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForText("//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Edit Settings')]/a",
			"Edit Settings");
		assertEquals(RuntimeVariables.replace("Edit Settings"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Edit Settings')]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Edit Settings')]/a"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Staging (Modified)"),
			selenium.getText("//a[@id='_165_stagingLink']"));
		selenium.clickAt("//a[@id='_165_stagingLink']",
			RuntimeVariables.replace("Staging (Modified)"));
		selenium.waitForVisible("//input[@id='_165_local']");
		selenium.clickAt("//input[@id='_165_local']",
			RuntimeVariables.replace("Local Live"));
		assertTrue(selenium.isChecked("//input[@id='_165_local']"));
		selenium.waitForVisible(
			"//input[@id='_165_staged-portlet_161Checkbox']");
		assertTrue(selenium.isChecked(
				"//input[@id='_165_staged-portlet_161Checkbox']"));
	}
}