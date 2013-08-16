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

package com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyassettyperequired;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewVocabularyAssetTypeRequiredTest extends BaseTestCase {
	public void testViewVocabularyAssetTypeRequired() throws Exception {
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
				assertEquals(RuntimeVariables.replace("Vocabulary Name"),
					selenium.getText("//span[@class='vocabulary-item']/a"));
				selenium.clickAt("//a[@class='vocabulary-item-actions-trigger']",
					RuntimeVariables.replace("Edit"));
				selenium.waitForVisible("//input[@id='_147_title_en_US']");
				assertEquals("Vocabulary Name",
					selenium.getValue("//input[@id='_147_title_en_US']"));
				assertEquals(RuntimeVariables.replace("Vocabulary Description"),
					selenium.getText("//textarea[@id='_147_description_en_US']"));
				assertEquals(RuntimeVariables.replace("Associated Asset Types"),
					selenium.getText(
						"//div[@id='vocabularyExtraFieldsPanelContainer']/div/div/span"));

				boolean requiredCheckBoxNotVisible = selenium.isVisible(
						"_147_required0Checkbox");

				if (requiredCheckBoxNotVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[@id='vocabularyExtraFieldsPanelContainer']/div/div/span",
					RuntimeVariables.replace("Associated Asset Types"));
				selenium.waitForVisible("//input[@id='_147_required0Checkbox']");

			case 2:
				assertTrue(selenium.isChecked(
						"//input[@id='_147_required0Checkbox']"));

			case 100:
				label = -1;
			}
		}
	}
}