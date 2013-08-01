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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.localizewcwebcontenttemplatewcd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownTemplateTest extends BaseTestCase {
	public void testTearDownTemplate() throws Exception {
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

				boolean template1Present = selenium.isElementPresent(
						"_15_rowIds");

				if (!template1Present) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@name='_15_allRowIds']",
					RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected templates[\\s\\S]$"));

			case 2:

				boolean template2Present = selenium.isElementPresent(
						"_15_rowIds");

				if (!template2Present) {
					label = 3;

					continue;
				}

				selenium.clickAt("//input[@name='_15_allRowIds']",
					RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected templates[\\s\\S]$"));

			case 3:

				boolean template3Present = selenium.isElementPresent(
						"_15_rowIds");

				if (!template3Present) {
					label = 4;

					continue;
				}

				selenium.clickAt("//input[@name='_15_allRowIds']",
					RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected templates[\\s\\S]$"));

			case 4:

				boolean template4Present = selenium.isElementPresent(
						"_15_rowIds");

				if (!template4Present) {
					label = 5;

					continue;
				}

				selenium.clickAt("//input[@name='_15_allRowIds']",
					RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected templates[\\s\\S]$"));

			case 5:

				boolean template5Present = selenium.isElementPresent(
						"_15_rowIds");

				if (!template5Present) {
					label = 6;

					continue;
				}

				selenium.clickAt("//input[@name='_15_allRowIds']",
					RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected templates[\\s\\S]$"));

			case 6:
			case 100:
				label = -1;
			}
		}
	}
}