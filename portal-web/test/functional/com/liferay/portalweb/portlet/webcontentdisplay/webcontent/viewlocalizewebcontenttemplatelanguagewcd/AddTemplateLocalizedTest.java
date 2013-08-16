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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.viewlocalizewebcontenttemplatelanguagewcd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddTemplateLocalizedTest extends BaseTestCase {
	public void testAddTemplateLocalized() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.waitForElementPresent("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Web Content",
					RuntimeVariables.replace("Web Content"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Templates",
					RuntimeVariables.replace("Templates"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//input[@value='Add Template']",
					RuntimeVariables.replace("Add Template"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_15_name_en_US']",
					RuntimeVariables.replace(
						"Web Content Localized Template Name"));
				selenium.type("//textarea[@id='_15_description_en_US']",
					RuntimeVariables.replace(
						"Web Content Localized Template Description"));
				selenium.clickAt("//input[@value='Select']",
					RuntimeVariables.replace("Select"));
				selenium.waitForVisible("//input[@value='Add Structure']");

				boolean localizedPresentA = selenium.isElementPresent(
						"//td[1]/a");

				if (localizedPresentA) {
					label = 2;

					continue;
				}

				selenium.close();
				selenium.selectWindow("null");

			case 2:

				boolean localizedPresentB = selenium.isElementPresent(
						"//td[1]/a");

				if (!localizedPresentB) {
					label = 3;

					continue;
				}

				selenium.click("//td[1]/a");
				selenium.selectWindow("null");

			case 3:
				Thread.sleep(5000);
				assertEquals(RuntimeVariables.replace(
						"Web Content Localized Structure Name"),
					selenium.getText("//a[@id='_15_structureName']"));
				selenium.type("//input[@id='_15_xsl']",
					RuntimeVariables.replace(
						"L:\\portal\\build\\portal-web\\test\\com\\liferay\\portalweb\\portlet\\webcontentdisplay\\dependencies\\LocalizedTemplate.html"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertEquals(RuntimeVariables.replace(
						"Web Content Localized Template Name"),
					selenium.getText("//td[3]/a"));
				assertEquals(RuntimeVariables.replace(
						"Web Content Localized Template Description"),
					selenium.getText("//td[4]/a"));

			case 100:
				label = -1;
			}
		}
	}
}