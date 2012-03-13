/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.stagingcommunity.sites.usecase.demo2;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_DragAndDropPortletUSColumn1SiteStagingTest
	extends BaseTestCase {
	public void testUser_DragAndDropPortletUSColumn1SiteStaging()
		throws Exception {
		selenium.open("/web/guest/home/");
		loadRequiredJavaScriptModules();

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Site Name")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Site Name", RuntimeVariables.replace("Site Name"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		assertEquals(RuntimeVariables.replace(
				"The data of this portlet is not staged. Since remote staging is currently being used, data changes must be made from the Remote Live site. The portlet's workflow will only have effect from the Remote Live site. Any data changes to this portlet in staging will be ignored. Portlet setup is still managed from staging."),
			selenium.getText("//div[@class='portlet-msg-alert']"));
		assertTrue(selenium.isVisible(
				"//div[@id='column-2']/div/div[contains(@class,'portlet-user-statistics')]"));
		assertFalse(selenium.isElementPresent(
				"//div[@id='column-1']/div/div[contains(@class,'portlet-user-statistics')]"));
		assertEquals(RuntimeVariables.replace("User Statistics"),
			selenium.getText("xPath=(//span[@class='portlet-title-text'])[3]"));
		selenium.clickAt("xPath=(//span[@class='portlet-title-text'])[3]",
			RuntimeVariables.replace("User Statistics"));
		Thread.sleep(5000);
		selenium.dragAndDropToObject("xPath=(//span[@class='portlet-title-text'])[3]",
			"//div[@id='column-1']");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//div[@id='column-1']/div/div[contains(@class,'portlet-user-statistics')]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertTrue(selenium.isVisible(
				"//div[@id='column-1']/div/div[contains(@class,'portlet-user-statistics')]"));
		assertFalse(selenium.isElementPresent(
				"//div[@id='column-2']/div/div[contains(@class,'portlet-user-statistics')]"));
	}
}