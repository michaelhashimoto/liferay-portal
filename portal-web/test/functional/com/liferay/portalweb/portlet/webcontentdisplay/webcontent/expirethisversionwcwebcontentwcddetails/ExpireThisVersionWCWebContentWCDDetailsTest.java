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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.expirethisversionwcwebcontentwcddetails;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ExpireThisVersionWCWebContentWCDDetailsTest extends BaseTestCase {
	public void testExpireThisVersionWCWebContentWCDDetails()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Web Content Display Test Page",
			RuntimeVariables.replace("Web Content Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent Content Edit"),
			selenium.getText("//div[@class='journal-content-article']/p"));
		selenium.clickAt("//img[@title='Edit Web Content']",
			RuntimeVariables.replace("Edit Web Content"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Version: 1.1"),
			selenium.getText("//span[@class='workflow-version']"));
		assertEquals(RuntimeVariables.replace("View History"),
			selenium.getText("//button[2]"));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("View History"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"xPath=(//span[@title='Actions']/ul/li/strong/a/span)[2]"));
		selenium.clickAt("xPath=(//span[@title='Actions']/ul/li/strong/a/span)[2]",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Expire')]/a");
		assertEquals(RuntimeVariables.replace("Expire"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Expire')]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Expire')]/a",
			RuntimeVariables.replace("Expire"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("WC WebContent Title Edit"),
			selenium.getText("//tr[4]/td[3]"));
		assertEquals(RuntimeVariables.replace("1.1"),
			selenium.getText("//tr[4]/td[4]"));
		assertEquals(RuntimeVariables.replace("Expired"),
			selenium.getText("//tr[4]/td[5]"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Web Content Display Test Page",
			RuntimeVariables.replace("Web Content Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent Content"),
			selenium.getText("//div[@class='journal-content-article']/p"));
	}
}