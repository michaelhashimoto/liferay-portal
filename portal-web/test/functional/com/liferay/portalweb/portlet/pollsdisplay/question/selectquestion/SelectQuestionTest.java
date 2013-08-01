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

package com.liferay.portalweb.portlet.pollsdisplay.question.selectquestion;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SelectQuestionTest extends BaseTestCase {
	public void testSelectQuestion() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Polls Display Test Page",
			RuntimeVariables.replace("Polls Display Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForVisible(
			"//iframe[contains(@id,'configurationIframeDialog')]");
		selenium.selectFrame(
			"//iframe[contains(@id,'configurationIframeDialog')]");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.waitForVisible("//select[@id='_86_questionId']");
		selenium.select("//select[@id='_86_questionId']",
			RuntimeVariables.replace("PD Question Title"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("PD Question Title",
			selenium.getSelectedLabel("//select[@id='_86_questionId']"));
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Polls Display Test Page",
			RuntimeVariables.replace("Polls Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("//div/span[1]/span/span/input"));
		assertTrue(selenium.isElementPresent("//div/span[2]/span/span/input"));
		assertTrue(selenium.isElementPresent("//div/span[3]/span/span/input"));
		assertEquals(RuntimeVariables.replace("a. PD Question ChoiceA"),
			selenium.getText("//div/span[1]/span/label"));
		assertEquals(RuntimeVariables.replace("b. PD Question ChoiceB"),
			selenium.getText("//div/span[2]/span/label"));
		assertEquals(RuntimeVariables.replace("c. PD Question ChoiceC"),
			selenium.getText("//div/span[3]/span/label"));
	}
}