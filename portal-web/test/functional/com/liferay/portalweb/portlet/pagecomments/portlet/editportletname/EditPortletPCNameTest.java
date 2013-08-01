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

package com.liferay.portalweb.portlet.pagecomments.portlet.editportletname;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditPortletPCNameTest extends BaseTestCase {
	public void testEditPortletPCName() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace("Page Comments Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Page Comments"),
			selenium.getText("//h1[@class='portlet-title']/span[2]"));
		selenium.clickAt("//h1[@class='portlet-title']/span[2]",
			RuntimeVariables.replace("Page Comments"));
		assertEquals(RuntimeVariables.replace("Page Comments"),
			selenium.getText("//h1[@class='portlet-title']/span[2]"));
		selenium.clickAt("//h1[@class='portlet-title']/span[2]",
			RuntimeVariables.replace("Page Comments"));
		selenium.waitForVisible("//div[5]/div/div/div/span[1]/span/input");
		selenium.type("//div[5]/div/div/div/span[1]/span/input",
			RuntimeVariables.replace("Page Comments Edit"));
		selenium.waitForVisible("//button[@id='save']");
		selenium.clickAt("//button[@id='save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForText("//h1[@class='portlet-title']/span[2]",
			"Page Comments Edit");
		assertEquals(RuntimeVariables.replace("Page Comments Edit"),
			selenium.getText("//h1[@class='portlet-title']/span[2]"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace("Page Comments Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Page Comments Edit"),
			selenium.getText("//h1[@class='portlet-title']/span[2]"));
		selenium.clickAt("//h1[@class='portlet-title']/span[2]",
			RuntimeVariables.replace("Page Comments Edit"));
		assertEquals(RuntimeVariables.replace("Page Comments Edit"),
			selenium.getText("//h1[@class='portlet-title']/span[2]"));
		selenium.clickAt("//h1[@class='portlet-title']/span[2]",
			RuntimeVariables.replace("Page Comments Edit"));
		selenium.waitForVisible("//div[5]/div/div/div/span[1]/span/input");
		selenium.type("//div[5]/div/div/div/span[1]/span/input",
			RuntimeVariables.replace("Page Comments"));
		selenium.waitForVisible("//button[@id='save']");
		selenium.clickAt("//button[@id='save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForText("//h1[@class='portlet-title']/span[2]",
			"Page Comments");
		assertEquals(RuntimeVariables.replace("Page Comments"),
			selenium.getText("//h1[@class='portlet-title']/span[2]"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace("Page Comments Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Page Comments"),
			selenium.getText("//h1[@class='portlet-title']/span[2]"));
	}
}