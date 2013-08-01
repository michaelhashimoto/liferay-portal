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

package com.liferay.portalweb.portal.controlpanel.usergroups.portlet.viewportletugcp;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletUGCPTest extends BaseTestCase {
	public void testViewPortletUGCP() throws Exception {
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
			selenium.getText("//span[@class='portlet-title-text']"));
		assertTrue(selenium.isPartialText(
				"//div[@id='show-portlet-description-127']/div",
				"User groups provide a way to group users independently of the organizations to which they belong. Administrators can define a user group and assign the user group as a member of a site to make all of its users members automatically."));
		assertEquals(RuntimeVariables.replace("View All"),
			selenium.getText("//div[@class='lfr-portlet-toolbar']/span[1]/a"));
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//div[@class='lfr-portlet-toolbar']/span[2]/a"));
		assertEquals(RuntimeVariables.replace("User Groups"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertTrue(selenium.isVisible("//input[@id='_127_keywords']"));
		assertTrue(selenium.isVisible("//input[@value='Search']"));
		assertTrue(selenium.isVisible("//input[@value='Delete']"));
		assertEquals(RuntimeVariables.replace("No user groups were found."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}