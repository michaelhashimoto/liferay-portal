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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.groups.pagescope;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletScopeCurrentPageTest extends BaseTestCase {
	public void testConfigurePortletScopeCurrentPage()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/group-page-scope-community/");
		selenium.waitForVisible("link=Blogs Page Scope Current Page");
		selenium.clickAt("link=Blogs Page Scope Current Page",
			RuntimeVariables.replace("Blogs Page Scope Current Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.clickAt("//strong/a", RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.click("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		selenium.waitForVisible("//li[@id='_86_tabs1scopeTabsId']/a");
		selenium.clickAt("//li[@id='_86_tabs1scopeTabsId']/a",
			RuntimeVariables.replace("Scope"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_86_scopeType']",
			RuntimeVariables.replace("label=Select Layout"));
		selenium.select("//select[@id='_86_scopeLayoutUuid']",
			RuntimeVariables.replace(
				"label=Current Page (Blogs Page Scope Current Page)"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("Current Page (Blogs Page Scope Current Page)",
			selenium.getSelectedLabel("//select[@id='_86_scopeLayoutUuid']"));
	}
}