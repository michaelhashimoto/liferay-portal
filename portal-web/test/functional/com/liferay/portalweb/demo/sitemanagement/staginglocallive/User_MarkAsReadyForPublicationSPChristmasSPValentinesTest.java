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
public class User_MarkAsReadyForPublicationSPChristmasSPValentinesTest
	extends BaseTestCase {
	public void testUser_MarkAsReadyForPublicationSPChristmasSPValentines()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.waitForElementPresent("link=Site Name");
				selenium.clickAt("link=Site Name",
					RuntimeVariables.replace("Site Name"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent(
						"//body[contains(@class,'live-view')]"));
				assertTrue(selenium.isElementNotPresent(
						"//body[contains(@class,'local-staging')]"));
				assertEquals(RuntimeVariables.replace("Staging"),
					selenium.getText(
						"//div[@class='staging-bar']/ul/li[2]/span/a"));
				selenium.clickAt("//div[@class='staging-bar']/ul/li[2]/span/a",
					RuntimeVariables.replace("Staging"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent(
						"//body[contains(@class,'local-staging')]"));
				assertTrue(selenium.isElementNotPresent(
						"//body[contains(@class,'live-view')]"));

				boolean christmasPresent = selenium.isElementPresent(
						"link=Christmas");

				if (!christmasPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=Christmas",
					RuntimeVariables.replace("Christmas"));
				selenium.waitForPageToLoad("30000");

			case 2:
				selenium.waitForVisible("link=Prices");
				selenium.clickAt("link=Prices",
					RuntimeVariables.replace("Prices"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Christmas Site Pages Variation of Site Name"),
					selenium.getText(
						"//span[@class='layout-set-branch-description']"));
				assertEquals(RuntimeVariables.replace("Draft"),
					selenium.getText("//span[@class='workflow-status']/strong"));
				assertEquals(RuntimeVariables.replace(
						"Mark as Ready for Publication"),
					selenium.getText(
						"//button/span[.='Mark as Ready for Publication']"));
				selenium.clickAt("//button/span[.='Mark as Ready for Publication']",
					RuntimeVariables.replace("Mark as Ready for Publication"));
				selenium.waitForText("//span[@class='workflow-status']/strong",
					"Ready for Publication");
				assertEquals(RuntimeVariables.replace("Ready for Publication"),
					selenium.getText("//span[@class='workflow-status']/strong"));

			case 100:
				label = -1;
			}
		}
	}
}