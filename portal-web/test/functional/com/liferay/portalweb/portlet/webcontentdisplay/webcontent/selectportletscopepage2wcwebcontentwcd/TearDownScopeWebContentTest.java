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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.selectportletscopepage2wcwebcontentwcd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownScopeWebContentTest extends BaseTestCase {
	public void testTearDownScopeWebContent() throws Exception {
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
				assertTrue(selenium.isPartialText("//div/span/ul/li/strong/a",
						"Scope: Default"));
				selenium.clickAt("//div/span/ul/li/strong/a",
					RuntimeVariables.replace("Scope: Default"));
				assertEquals(RuntimeVariables.replace("Default"),
					selenium.getText("//a"));
				selenium.clickAt("//a", RuntimeVariables.replace("Default"));
				selenium.waitForPageToLoad("30000");

				boolean defaultScopeWebContentPresent = selenium.isElementPresent(
						"_15_rowIds");

				if (!defaultScopeWebContentPresent) {
					label = 4;

					continue;
				}

				selenium.clickAt("_15_allRowIds",
					RuntimeVariables.replace("checkBox"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected web content[\\s\\S]$"));
				selenium.clickAt("link=Templates",
					RuntimeVariables.replace("Templates"));
				selenium.waitForPageToLoad("30000");

				boolean templatePresent = selenium.isElementPresent(
						"_15_rowIds");

				if (!templatePresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("_15_allRowIds",
					RuntimeVariables.replace("checkBox"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected templates[\\s\\S]$"));

			case 2:
				selenium.clickAt("link=Structures",
					RuntimeVariables.replace("Structures"));
				selenium.waitForPageToLoad("30000");

				boolean structurePresent = selenium.isElementPresent(
						"_15_rowIds");

				if (!structurePresent) {
					label = 3;

					continue;
				}

				selenium.clickAt("_15_allRowIds",
					RuntimeVariables.replace("checkBox"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected structures[\\s\\S]$"));

			case 3:
			case 4:
				assertTrue(selenium.isPartialText("//div/span/ul/li/strong/a",
						"Scope: Default"));
				selenium.clickAt("//div/span/ul/li/strong/a",
					RuntimeVariables.replace("Scope: Default"));
				assertEquals(RuntimeVariables.replace(
						"Web Content Display Test Page2"),
					selenium.getText("//li[2]/a"));
				selenium.clickAt("//li[2]/a",
					RuntimeVariables.replace("Web Content Display Test Page2"));
				selenium.waitForPageToLoad("30000");

				boolean page2ScopeWebContentPresent = selenium.isElementPresent(
						"_15_rowIds");

				if (!page2ScopeWebContentPresent) {
					label = 7;

					continue;
				}

				selenium.clickAt("_15_allRowIds",
					RuntimeVariables.replace("Checkbox"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected web content[\\s\\S]$"));
				selenium.clickAt("link=Templates",
					RuntimeVariables.replace("Templates"));
				selenium.waitForPageToLoad("30000");

				boolean template2Present = selenium.isElementPresent(
						"_15_rowIds");

				if (!template2Present) {
					label = 5;

					continue;
				}

				selenium.clickAt("_15_allRowIds",
					RuntimeVariables.replace("Checkbox"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected templates[\\s\\S]$"));

			case 5:
				selenium.clickAt("link=Structures",
					RuntimeVariables.replace("Structures"));
				selenium.waitForPageToLoad("30000");

				boolean structure2Present = selenium.isElementPresent(
						"_15_rowIds");

				if (!structure2Present) {
					label = 6;

					continue;
				}

				selenium.clickAt("_15_allRowIds",
					RuntimeVariables.replace("Checkbox"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected structures[\\s\\S]$"));

			case 6:
			case 7:
			case 100:
				label = -1;
			}
		}
	}
}