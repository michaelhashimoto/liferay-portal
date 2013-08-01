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
public class AddIntroductionProfileTest extends BaseTestCase {
	public void testAddIntroductionProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/joebloggs/so/profile");
		selenium.waitForVisible(
			"xPath=(//div[@class='lfr-contact-name']/a)[contains(.,'Joe Bloggs')]");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText(
				"xPath=(//div[@class='lfr-contact-name']/a)[contains(.,'Joe Bloggs')]"));
		assertEquals(RuntimeVariables.replace(
				"To complete your profile, please add:"),
			selenium.getText("//p[@class='portlet-msg portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Introduction"),
			selenium.getText("//li[@data-title='Introduction']"));
		selenium.clickAt("//li[@data-title='Introduction']",
			RuntimeVariables.replace("Introduction"));
		selenium.waitForVisible("//textarea[contains(@id,'comments')]");
		selenium.type("//textarea[contains(@id,'comments')]",
			RuntimeVariables.replace("Introduction Content"));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//div[@data-title='Introduction']/h3");
		assertEquals(RuntimeVariables.replace("Introduction:"),
			selenium.getText("//div[@data-title='Introduction']/h3"));
		assertEquals(RuntimeVariables.replace("Introduction Content"),
			selenium.getText("//div[@data-title='Introduction']/ul/li/span"));
	}
}