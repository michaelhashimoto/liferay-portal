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

package com.liferay.portalweb.portal.controlpanel.categories.category.editvocabulary1categorytovocabulary2dad;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditVocabulary1CategoryToVocabulary2DADTest extends BaseTestCase {
	public void testEditVocabulary1CategoryToVocabulary2DAD()
		throws Exception {
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
		selenium.waitForVisible("//li/div/div[4]");
		assertEquals(RuntimeVariables.replace("Vocabulary1 Category Name"),
			selenium.getText("//li/div/div[4]"));
		selenium.clickAt("//li/div/div[4]",
			RuntimeVariables.replace("Vocabulary1 Category Name"));
		selenium.waitForVisible("//div[@class='view-category']/div/h1/span");
		assertEquals(RuntimeVariables.replace("Vocabulary1 Category Name"),
			selenium.getText("//div[@class='view-category']/div/h1/span"));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Vocabulary1 Category Name"),
			selenium.getText("//li/div/div[4]"));
		assertEquals(RuntimeVariables.replace("Vocabulary2 Name"),
			selenium.getText("xPath=(//span[@class='vocabulary-item']/a)[2]"));
		selenium.dragAndDropToObject("//li/div/div[4]",
			"xPath=(//span[@class='vocabulary-item']/a)[2]");
		selenium.waitForText("//li[contains(@class,'selected')]/div/span[@class='vocabulary-item']/a",
			"Vocabulary2 Name");
		assertEquals(RuntimeVariables.replace("Vocabulary2 Name"),
			selenium.getText(
				"//li[contains(@class,'selected')]/div/span[@class='vocabulary-item']/a"));
		assertEquals(RuntimeVariables.replace("Vocabulary1 Category Name"),
			selenium.getText("//li/div/div[4]"));
	}
}