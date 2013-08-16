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

package com.liferay.portalweb.portal.permissions.blogs.assertactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_AssertActionsTest extends BaseTestCase {
	public void testGuest_AssertActions() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertTrue(selenium.isElementNotPresent(
				"//span[@title='Options']/ul/li/strong/a"));
		assertTrue(selenium.isVisible("//input[@value='Search']"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Add Blog Entry']"));
		assertTrue(selenium.isElementNotPresent("//input[@value='Permissions']"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Edit')]/span/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Permissions')]/span/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Delete')]/span/a/span"));
		assertEquals(RuntimeVariables.replace("Permissions Blogs Test Entry"),
			selenium.getText("//div[@class='entry-title']/h2/a"));
		selenium.clickAt("//div[@class='entry-title']/h2/a",
			RuntimeVariables.replace("Permissions Blogs Test Entry"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Add Comment"),
			selenium.getText("//span/a[contains(.,'Add Comment')]"));
		selenium.clickAt("//span/a[contains(.,'Add Comment')]",
			RuntimeVariables.replace("Add Comment"));
		selenium.waitForVisible("//textarea[@name='_33_postReplyBody0']");
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Edit')]/span/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Permissions')]/span/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Delete')]/span/a/span"));
		assertTrue(selenium.isElementNotPresent("//input[@value='Reply']"));
		assertTrue(selenium.isVisible(
				"//div[@class='lfr-discussion-controls']/div/a"));
		selenium.clickAt("//input[@value='Reply as...']",
			RuntimeVariables.replace("Reply as..."));
		selenium.waitForVisible("//iframe[@id='_33_signInDialog']");
		selenium.selectFrame("//iframe[@id='_33_signInDialog']");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.waitForVisible("//label[@for='_164_login']");
		assertEquals(RuntimeVariables.replace("Email Address"),
			selenium.getText("//label[@for='_164_login']"));
		assertTrue(selenium.isVisible("//input[@id='_164_login']"));
		assertEquals(RuntimeVariables.replace("Password"),
			selenium.getText("//label[@for='_164_password']"));
		assertTrue(selenium.isVisible("//input[@id='_164_password']"));
		assertFalse(selenium.isChecked("//input[@id='_164_rememberMeCheckbox']"));
		assertEquals(RuntimeVariables.replace("Remember Me"),
			selenium.getText("//label[@for='_164_rememberMeCheckbox']"));
		assertTrue(selenium.isVisible("//input[@value='Sign In']"));
		selenium.selectFrame("relative=top");
		selenium.clickAt("//button[@title='Close dialog']",
			RuntimeVariables.replace("Close dialog"));
	}
}