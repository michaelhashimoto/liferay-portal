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

package com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.addugusergroups;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewUGUserGroupsTest extends BaseTestCase {
	public void testViewUGUserGroups() throws Exception {
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
		selenium.clickAt("link=User Groups",
			RuntimeVariables.replace("User Groups"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("User Groups"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertTrue(selenium.isVisible("//tr[3]/td[1]/input"));
		assertEquals(RuntimeVariables.replace("UG UserGroup1 Name"),
			selenium.getText("//tr[3]/td[2]/a"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//tr[3]/td[4]/span[@title='Actions']/ul/li/strong/a/span"));
		assertTrue(selenium.isVisible("//tr[4]/td[1]/input"));
		assertEquals(RuntimeVariables.replace("UG UserGroup2 Name"),
			selenium.getText("//tr[4]/td[2]/a"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[4]/td[3]"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//tr[4]/td[4]/span[@title='Actions']/ul/li/strong/a/span"));
		assertTrue(selenium.isVisible("//tr[5]/td[1]/input"));
		assertEquals(RuntimeVariables.replace("UG UserGroup3 Name"),
			selenium.getText("//tr[5]/td[2]/a"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[5]/td[3]"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//tr[5]/td[4]/span[@title='Actions']/ul/li/strong/a/span"));
		assertEquals(RuntimeVariables.replace("Showing 3 results."),
			selenium.getText("//div[@class='search-results']"));
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
		selenium.clickAt("link=User Groups",
			RuntimeVariables.replace("User Groups"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("User Groups"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("UG UserGroup1 Name"),
			selenium.getText("//tr[3]/td[2]/a"));
		selenium.clickAt("//tr[3]/td[2]/a",
			RuntimeVariables.replace("UG UserGroup1 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("UG UserGroup1 Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Old Name UG UserGroup1 Name"),
			selenium.getText("//div[@class='aui-field-wrapper-content']"));
		assertEquals("UG UserGroup1 Name",
			selenium.getValue("//input[@id='_127_name']"));
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
		selenium.clickAt("link=User Groups",
			RuntimeVariables.replace("User Groups"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("User Groups"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("UG UserGroup2 Name"),
			selenium.getText("//tr[4]/td[2]/a"));
		selenium.clickAt("//tr[4]/td[2]/a",
			RuntimeVariables.replace("UG UserGroup2 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("UG UserGroup2 Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Old Name UG UserGroup2 Name"),
			selenium.getText("//div[@class='aui-field-wrapper-content']"));
		assertEquals("UG UserGroup2 Name",
			selenium.getValue("//input[@id='_127_name']"));
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
		selenium.clickAt("link=User Groups",
			RuntimeVariables.replace("User Groups"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("User Groups"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("UG UserGroup3 Name"),
			selenium.getText("//tr[5]/td[2]/a"));
		selenium.clickAt("//tr[5]/td[2]/a",
			RuntimeVariables.replace("UG UserGroup3 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("UG UserGroup3 Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Old Name UG UserGroup3 Name"),
			selenium.getText("//div[@class='aui-field-wrapper-content']"));
		assertEquals("UG UserGroup3 Name",
			selenium.getValue("//input[@id='_127_name']"));
	}
}