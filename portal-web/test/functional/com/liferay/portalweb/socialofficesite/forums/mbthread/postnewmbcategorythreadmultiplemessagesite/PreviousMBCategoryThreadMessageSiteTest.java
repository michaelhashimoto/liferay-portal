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

package com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmultiplemessagesite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class PreviousMBCategoryThreadMessageSiteTest extends BaseTestCase {
	public void testPreviousMBCategoryThreadMessageSite()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard");
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[@class='search-input focus']");
		selenium.type("//input[@class='search-input focus']",
			RuntimeVariables.replace("Open"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Forums"),
			selenium.getText("//nav/ul/li[contains(.,'Forums')]/a/span"));
		selenium.clickAt("//nav/ul/li[contains(.,'Forums')]/a/span",
			RuntimeVariables.replace("Forums"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread1 Message Subject"),
			selenium.getText("//tr[5]/td[1]/a"));
		selenium.clickAt("//tr[5]/td[1]/a",
			RuntimeVariables.replace("MB Category Thread1 Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread1 Message Subject"),
			selenium.getText("//h1[@class='header-title']/span"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//div[@class='thread-navigation']/a"));
		selenium.clickAt("//div[@class='thread-navigation']/a",
			RuntimeVariables.replace("Previous"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread2 Message Subject"),
			selenium.getText("//h1[@class='header-title']/span"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//div[@class='thread-navigation']/a"));
		selenium.clickAt("//div[@class='thread-navigation']/a",
			RuntimeVariables.replace("Previous"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread3 Message Subject"),
			selenium.getText("//h1[@class='header-title']/span"));
	}
}