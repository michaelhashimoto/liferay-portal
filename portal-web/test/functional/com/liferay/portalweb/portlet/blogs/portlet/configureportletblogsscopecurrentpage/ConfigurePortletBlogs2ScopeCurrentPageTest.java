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

package com.liferay.portalweb.portlet.blogs.portlet.configureportletblogsscopecurrentpage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletBlogs2ScopeCurrentPageTest extends BaseTestCase {
	public void testConfigurePortletBlogs2ScopeCurrentPage()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Blogs Test Page2",
			RuntimeVariables.replace("Blogs Test Page2"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForVisible("//iframe[@id='_33_configurationIframeDialog']");
		selenium.selectFrame("//iframe[@id='_33_configurationIframeDialog']");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.clickAt("link=Scope", RuntimeVariables.replace("Scope"));
		selenium.waitForVisible("//select[@id='_86_scopeType']");
		assertEquals("Default",
			selenium.getSelectedLabel("//select[@id='_86_scopeType']"));
		selenium.select("//select[@id='_86_scopeType']",
			RuntimeVariables.replace("Select Page"));
		assertEquals("Select Page",
			selenium.getSelectedLabel("//select[@id='_86_scopeType']"));
		selenium.waitForVisible("//select[@id='_86_scopeLayoutUuid']");
		selenium.select("//select[@id='_86_scopeLayoutUuid']",
			RuntimeVariables.replace("Current Page (Blogs Test Page2)"));
		assertEquals("Current Page (Blogs Test Page2)",
			selenium.getSelectedLabel("//select[@id='_86_scopeLayoutUuid']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("Select Page",
			selenium.getSelectedLabel("//select[@id='_86_scopeType']"));
		assertEquals("Current Page (Blogs Test Page2)",
			selenium.getSelectedLabel("//select[@id='_86_scopeLayoutUuid']"));
		selenium.selectFrame("relative=top");
	}
}