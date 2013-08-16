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

package com.liferay.portalweb.portal.controlpanel.blogs.blogsentry.addblogsentrycp;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownBlogsEntryCPTest extends BaseTestCase {
	public void testTearDownBlogsEntryCP() throws Exception {
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
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Blogs", RuntimeVariables.replace("Blogs"));
				selenium.waitForPageToLoad("30000");
				Thread.sleep(1000);

				boolean entry1Present = selenium.isElementPresent(
						"//input[@name='_161_rowIds']");

				if (!entry1Present) {
					label = 6;

					continue;
				}

				assertFalse(selenium.isChecked(
						"//input[@name='_161_allRowIds']"));
				selenium.clickAt("//input[@name='_161_allRowIds']",
					RuntimeVariables.replace("All Rows"));
				assertTrue(selenium.isChecked("//input[@name='_161_allRowIds']"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForConfirmation(
					"Are you sure you want to delete the selected entries?");
				Thread.sleep(1000);

				boolean entry2Present = selenium.isElementPresent(
						"//input[@name='_161_rowIds']");

				if (!entry2Present) {
					label = 5;

					continue;
				}

				assertFalse(selenium.isChecked(
						"//input[@name='_161_allRowIds']"));
				selenium.clickAt("//input[@name='_161_allRowIds']",
					RuntimeVariables.replace("All Rows"));
				assertTrue(selenium.isChecked("//input[@name='_161_allRowIds']"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForConfirmation(
					"Are you sure you want to delete the selected entries?");
				Thread.sleep(1000);

				boolean entry3Present = selenium.isElementPresent(
						"//input[@name='_161_rowIds']");

				if (!entry3Present) {
					label = 4;

					continue;
				}

				assertFalse(selenium.isChecked(
						"//input[@name='_161_allRowIds']"));
				selenium.clickAt("//input[@name='_161_allRowIds']",
					RuntimeVariables.replace("All Rows"));
				assertTrue(selenium.isChecked("//input[@name='_161_allRowIds']"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForConfirmation(
					"Are you sure you want to delete the selected entries?");
				Thread.sleep(1000);

				boolean entry4Present = selenium.isElementPresent(
						"//input[@name='_161_rowIds']");

				if (!entry4Present) {
					label = 3;

					continue;
				}

				assertFalse(selenium.isChecked(
						"//input[@name='_161_allRowIds']"));
				selenium.clickAt("//input[@name='_161_allRowIds']",
					RuntimeVariables.replace("All Rows"));
				assertTrue(selenium.isChecked("//input[@name='_161_allRowIds']"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForConfirmation(
					"Are you sure you want to delete the selected entries?");
				Thread.sleep(1000);

				boolean entry5Present = selenium.isElementPresent(
						"//input[@name='_161_rowIds']");

				if (!entry5Present) {
					label = 2;

					continue;
				}

				assertFalse(selenium.isChecked(
						"//input[@name='_161_allRowIds']"));
				selenium.clickAt("//input[@name='_161_allRowIds']",
					RuntimeVariables.replace("All Rows"));
				assertTrue(selenium.isChecked("//input[@name='_161_allRowIds']"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForConfirmation(
					"Are you sure you want to delete the selected entries?");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				assertEquals(RuntimeVariables.replace("No entries were found."),
					selenium.getText("//div[@class='portlet-msg-info']"));

			case 100:
				label = -1;
			}
		}
	}
}