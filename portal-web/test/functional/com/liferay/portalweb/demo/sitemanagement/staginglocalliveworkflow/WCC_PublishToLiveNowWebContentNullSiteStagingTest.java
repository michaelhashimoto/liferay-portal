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

package com.liferay.portalweb.demo.sitemanagement.staginglocalliveworkflow;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class WCC_PublishToLiveNowWebContentNullSiteStagingTest
	extends BaseTestCase {
	public void testWCC_PublishToLiveNowWebContentNullSiteStaging()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/community-site-test/home/");
		selenium.waitForVisible("link=Staging");
		selenium.clickAt("link=Staging", RuntimeVariables.replace("Staging"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.clickAt("//span[@class='staging-icon-menu-container']/span/ul/li/strong/a",
			RuntimeVariables.replace("Staging Drop Down"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a");
		assertEquals(RuntimeVariables.replace("Publish to Live Now"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.click("//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a");
		Thread.sleep(5000);
		selenium.waitForVisible("//input[@value='Publish']");
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to publish these pages[\\s\\S]$"));
	}
}