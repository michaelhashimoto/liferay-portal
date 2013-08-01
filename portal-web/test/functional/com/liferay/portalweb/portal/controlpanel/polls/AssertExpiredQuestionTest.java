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

package com.liferay.portalweb.portal.controlpanel.polls;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertExpiredQuestionTest extends BaseTestCase {
	public void testAssertExpiredQuestion() throws Exception {
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
		selenium.clickAt("link=Polls", RuntimeVariables.replace("Polls"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Edited Test Question 2"),
			selenium.getText(
				"//tr[contains(.,'Edited Test Question 2')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'Edited Test Question 2')]/td[1]/a",
			RuntimeVariables.replace("Edited Test Question 2"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent(
				"//span[1]/span/span/input[@type='radio']"));
		assertTrue(selenium.isElementNotPresent(
				"//span[2]/span/span/input[@type='radio']"));
		assertTrue(selenium.isElementNotPresent(
				"//span[3]/span/span/input[@type='radio']"));
		assertTrue(selenium.isElementNotPresent(
				"//span[4]/span/span/input[@type='radio']"));
		assertEquals(RuntimeVariables.replace(
				"Voting is disabled because this poll expired on 1/1/08 12:00 AM."),
			selenium.getText("//div[6]"));
	}
}