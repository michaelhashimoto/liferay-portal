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

package com.liferay.portalweb.portal.dbupgrade.sampledata6120.webcontent.journalfeed;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWCJournalFeedTest extends BaseTestCase {
	public void testAddWCJournalFeed() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/wc-journal-feed-community/");
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
		assertEquals(RuntimeVariables.replace("WC Journal Feed Community"),
			selenium.getText(
				"//span[@title='WC Journal Feed Community']/ul/li/strong/a"));
		selenium.clickAt("link=Web Content",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Feeds", RuntimeVariables.replace("Feeds"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("No feeds were found."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.clickAt("//input[@value='Add Feed']",
			RuntimeVariables.replace("Add Feed"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("New Feed"),
			selenium.getText("//h1[@class='header-title']/span"));
		selenium.type("//input[@id='_15_name']",
			RuntimeVariables.replace("Feed Name"));
		selenium.type("//textarea[@id='_15_description']",
			RuntimeVariables.replace("Feed Description"));
		selenium.type("//input[@id='_15_targetLayoutFriendlyUrl']",
			RuntimeVariables.replace("/web/guest/home"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}