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

package com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabulary;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownVocabularyTest extends BaseTestCase {
	public void testTearDownVocabulary() throws Exception {
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
				selenium.clickAt("link=Categories",
					RuntimeVariables.replace("Categories"));
				selenium.waitForPageToLoad("30000");
				Thread.sleep(5000);

				boolean vocabularyPresent = selenium.isElementPresent(
						"//input[@name='vocabulary-item-check']");

				if (!vocabularyPresent) {
					label = 2;

					continue;
				}

				assertFalse(selenium.isChecked(
						"//input[@id='_147_checkAllVocabulariesCheckbox']"));
				selenium.clickAt("//input[@id='_147_checkAllVocabulariesCheckbox']",
					RuntimeVariables.replace("Select All"));
				assertTrue(selenium.isChecked(
						"//input[@id='_147_checkAllVocabulariesCheckbox']"));
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//span[@title='Actions']/ul/li/strong/a/span"));
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForText("//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a",
					"Delete");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a",
					RuntimeVariables.replace("Delete"));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected vocabularies[\\s\\S]$"));
				selenium.waitForElementNotPresent(
					"//input[@name='vocabulary-item-check']");
				assertTrue(selenium.isElementNotPresent(
						"//input[@name='vocabulary-item-check']"));

			case 2:
				selenium.waitForVisible("//div[@id='vocabulary-messages']");
				assertEquals(RuntimeVariables.replace(
						"There are no vocabularies."),
					selenium.getText("//div[@id='vocabulary-messages']"));
				selenium.waitForVisible(
					"//div[@id='vocabulary-category-messages']");
				assertEquals(RuntimeVariables.replace(
						"There are no categories."),
					selenium.getText(
						"//div[@id='vocabulary-category-messages']"));

			case 100:
				label = -1;
			}
		}
	}
}