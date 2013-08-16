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

package com.liferay.portalweb.portlet.signin.portlet.viewportletforgotpassword;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletForgotPasswordTest extends BaseTestCase {
	public void testViewPortletForgotPassword() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Sign In Test Page");
		selenium.clickAt("link=Sign In Test Page",
			RuntimeVariables.replace("Sign In Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Forgot Password"),
			selenium.getText("//li[3]/a/span"));
		selenium.clickAt("//li[3]/a/span",
			RuntimeVariables.replace("Forgot Password"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//input[@id='_58_emailAddress']"));
		selenium.type("//input[@id='_58_emailAddress']",
			RuntimeVariables.replace("test@liferay.com"));
		selenium.type("//input[@id='_58_captchaText']",
			RuntimeVariables.replace("1111"));
		selenium.clickAt("//input[@value='Next']",
			RuntimeVariables.replace("Next"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request failed to complete."),
			selenium.getText("xPath=(//div[@class='portlet-msg-error'])[1]"));
		assertEquals(RuntimeVariables.replace("Text verification failed."),
			selenium.getText("xPath=(//div[@class='portlet-msg-error'])[2]"));
		assertTrue(selenium.isVisible("//input[@id='_58_emailAddress']"));
		selenium.type("//input[@id='_58_emailAddress']",
			RuntimeVariables.replace("testfake@liferay.com"));
		selenium.type("//input[@id='_58_captchaText']",
			RuntimeVariables.replace("1111"));
		selenium.clickAt("//input[@value='Next']",
			RuntimeVariables.replace("Next"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request failed to complete."),
			selenium.getText("xPath=(//div[@class='portlet-msg-error'])[1]"));
		assertEquals(RuntimeVariables.replace("Text verification failed."),
			selenium.getText("xPath=(//div[@class='portlet-msg-error'])[2]"));
	}
}