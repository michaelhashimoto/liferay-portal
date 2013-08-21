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

package com.liferay.portalweb.socialofficesite.recentblogs.blogsentry.configurerbselectionmethodusers;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigureRBSelectionMethodUsersSite2Test extends BaseTestCase {
	public void testConfigureRBSelectionMethodUsersSite2()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.clickAt("//input[contains(@class,'search-input')]",
					RuntimeVariables.replace("Go to"));
				selenium.waitForVisible(
					"//input[contains(@class,'search-input')]");
				selenium.select("//div[@class='sites-tabs']/span/span/span/select",
					RuntimeVariables.replace("All Sites"));
				selenium.type("//input[contains(@class,'search-input')]",
					RuntimeVariables.replace("Open Site2"));
				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Open Site2 Name"),
					selenium.getText(
						"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
				selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
					RuntimeVariables.replace("Open Site2 Name"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Blogs"),
					selenium.getText("//nav/ul/li[contains(.,'Blogs')]/a/span"));
				selenium.clickAt("//nav/ul/li[contains(.,'Blogs')]/a/span",
					RuntimeVariables.replace("Blogs"));
				selenium.waitForPageToLoad("30000");

				boolean recentBlogsConfigurationVisible = selenium.isVisible(
						"//section[@class='portlet']/header[contains(.,'Recent Blogs')]/menu/span/ul/li/strong/a");

				if (recentBlogsConfigurationVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//a[contains(@id,'toggleDockbar')]",
					RuntimeVariables.replace("Toggle Dockbar"));
				selenium.waitForElementPresent(
					"//body[contains(@class,'show-dockbar')]");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				selenium.clickAt("//li[@class='toggle-controls']/a",
					RuntimeVariables.replace("Edit Controls"));
				selenium.waitForVisible(
					"//section[@class='portlet']/header[contains(.,'Recent Blogs')]/menu/span/ul/li/strong/a");

			case 2:
				Thread.sleep(1000);
				assertTrue(selenium.isVisible(
						"//section[@class='portlet']/header[contains(.,'Recent Blogs')]/menu/span/ul/li/strong/a"));
				selenium.clickAt("//section[@class='portlet']/header[contains(.,'Recent Blogs')]/menu/span/ul/li/strong/a",
					RuntimeVariables.replace("Recent Blogs Configuration"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
				assertEquals(RuntimeVariables.replace("Configuration"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]",
					RuntimeVariables.replace("Configuration"));
				selenium.waitForVisible(
					"//iframe[contains(@id,'configurationIframeDialog')]");
				selenium.selectFrame(
					"//iframe[contains(@id,'configurationIframeDialog')]");
				selenium.waitForVisible(
					"//select[contains(@id,'selectionMethod')]");
				selenium.select("//select[contains(@id,'selectionMethod')]",
					RuntimeVariables.replace("Users"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"You have successfully updated the setup."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}