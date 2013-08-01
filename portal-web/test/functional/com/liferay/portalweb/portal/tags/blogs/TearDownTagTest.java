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

package com.liferay.portalweb.portal.tags.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownTagTest extends BaseTestCase {
	public void testTearDownTag() throws Exception {
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

				boolean tagsVisible = selenium.isElementPresent(
						"//span[@class='tag-item']/a");

				if (!tagsVisible) {
					label = 2;

					continue;
				}

				selenium.click("//input[@title='Check All Tags']");
				assertTrue(selenium.isVisible(
						"//input[@title='Check All Tags']"));
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//span[@title='Actions']/ul/li/strong/a/span"));
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a",
					RuntimeVariables.replace("Delete"));
				selenium.waitForConfirmation(
					"Are you sure you want to delete the selected tags?");
				selenium.waitForText("//div[@class='lfr-message-response portlet-msg-success']",
					"Your request processed successfully.");
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText(
						"//div[@class='lfr-message-response portlet-msg-success']"));

			case 2:
				assertEquals(RuntimeVariables.replace("There are no tags."),
					selenium.getText(
						"//div[@class='lfr-message-response portlet-msg-info']"));

			case 100:
				label = -1;
			}
		}
	}
}