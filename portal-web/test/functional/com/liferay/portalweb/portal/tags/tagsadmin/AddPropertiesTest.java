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

package com.liferay.portalweb.portal.tags.tagsadmin;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPropertiesTest extends BaseTestCase {
	public void testAddProperties() throws Exception {
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
				selenium.clickAt("link=Tags", RuntimeVariables.replace("Tags"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("//h1[@class='header-title']/span");
				assertEquals(RuntimeVariables.replace("selenium ide"),
					selenium.getText("//h1[@class='header-title']/span"));
				selenium.clickAt("//input[@id='editTagButton']",
					RuntimeVariables.replace("Edit"));
				selenium.waitForVisible("//input[@id='_99_name']");

				boolean propertiesVisible = selenium.isVisible(
						"//input[@id='_99_key0']");

				if (propertiesVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div/div/div/div/span",
					RuntimeVariables.replace("Properties"));
				selenium.waitForVisible("//input[@id='_99_key0']");
				assertTrue(selenium.isVisible("//input[@id='_99_key0']"));

			case 2:
				selenium.type("//input[@id='_99_key0']",
					RuntimeVariables.replace("This is a tag for anything"));
				selenium.type("//input[@id='_99_value0']",
					RuntimeVariables.replace("related to selenium."));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForVisible(
					"//div[@class='lfr-message-response portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText(
						"//div[@class='lfr-message-response portlet-msg-success']"));
				selenium.clickAt("link=Tags", RuntimeVariables.replace("Tags"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForText("//span[@class='property-key']",
					"This is a tag for anything");
				assertEquals(RuntimeVariables.replace(
						"This is a tag for anything"),
					selenium.getText("//span[@class='property-key']"));
				assertEquals(RuntimeVariables.replace("related to selenium."),
					selenium.getText("//span[@class='property-value']"));

			case 100:
				label = -1;
			}
		}
	}
}