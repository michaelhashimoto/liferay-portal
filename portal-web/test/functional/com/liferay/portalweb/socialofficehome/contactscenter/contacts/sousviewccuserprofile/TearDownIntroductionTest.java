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

package com.liferay.portalweb.socialofficehome.contactscenter.contacts.sousviewccuserprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownIntroductionTest extends BaseTestCase {
	public void testTearDownIntroduction() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertTrue(selenium.isVisible("//li[@id='_145_userMenu']"));
		selenium.mouseOver("//li[@id='_145_userMenu']");
		selenium.waitForVisible("link=My Account");
		selenium.clickAt("link=My Account",
			RuntimeVariables.replace("My Account"));
		selenium.waitForVisible("//iframe[contains(@src,'my_account')]");
		selenium.selectFrame("//iframe[contains(@src,'my_account')]");
		selenium.waitForPartialText("//a[@id='_2_commentsLink']", "Comments");
		assertTrue(selenium.isPartialText("//a[@id='_2_commentsLink']",
				"Comments"));
		selenium.clickAt("//a[@id='_2_commentsLink']",
			RuntimeVariables.replace("Comments"));
		selenium.waitForVisible("//textarea[@id='_2_comments']");
		selenium.type("//textarea[@id='_2_comments']",
			RuntimeVariables.replace(""));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.selectFrame("relative=top");
	}
}