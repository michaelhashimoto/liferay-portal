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

package com.liferay.portalweb.demo.sitemanagement.staginglocallive;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_ViewMBCategoryMessage1LiveTest extends BaseTestCase {
	public void testUser_ViewMBCategoryMessage1Live() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/liferay/dockbar_underlay.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Site Name");
				selenium.clickAt("link=Site Name",
					RuntimeVariables.replace("Site Name"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent(
						"//body[contains(@class,'live-view')]"));
				assertTrue(selenium.isElementNotPresent(
						"//body[contains(@class,'live-staging')]"));
				assertEquals(RuntimeVariables.replace("MB Category Name"),
					selenium.getText("//td[1]/a/strong"));
				selenium.clickAt("//td[1]/a/strong",
					RuntimeVariables.replace("MB Category Name"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("MB Category Name"),
					selenium.getText("//h1[@class='header-title']/span"));

				boolean threadVisible = selenium.isVisible("//td[1]/a");

				if (threadVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[4]/div/div/div[1]/div/span",
					RuntimeVariables.replace("Threads"));

			case 2:
				assertEquals(RuntimeVariables.replace(
						"MB Category Thread Message1 Subject"),
					selenium.getText("//td[1]/a"));
				selenium.clickAt("//td[1]/a",
					RuntimeVariables.replace(
						"MB Category Thread Message1 Subject"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"MB Category Thread Message1 Subject"),
					selenium.getText("//div[@class='subject']/a/strong"));
				assertEquals(RuntimeVariables.replace(
						"MB Category Thread Message1 Body"),
					selenium.getText("//div[@class='thread-body']"));

			case 100:
				label = -1;
			}
		}
	}
}