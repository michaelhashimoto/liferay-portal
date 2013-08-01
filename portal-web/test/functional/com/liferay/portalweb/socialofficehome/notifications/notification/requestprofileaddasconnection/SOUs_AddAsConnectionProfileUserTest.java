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

package com.liferay.portalweb.socialofficehome.notifications.notification.requestprofileaddasconnection;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_AddAsConnectionProfileUserTest extends BaseTestCase {
	public void testSOUs_AddAsConnectionProfileUser() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/joebloggs/so/profile/");
		selenium.waitForVisible("//nav/ul/li[contains(.,'Profile')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Profile')]/a/span",
			RuntimeVariables.replace("Profile"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("test@liferay.com"),
			selenium.getText("//div[@class='lfr-contact-extra']"));
		assertEquals(RuntimeVariables.replace("Connect"),
			selenium.getText("//span[@class='action add-connection']/a"));
		selenium.clickAt("//span[@class='action add-connection']/a",
			RuntimeVariables.replace("Connect"));
		selenium.waitForVisible("//span[@class='disabled']/span");
		assertEquals(RuntimeVariables.replace("Connection Requested"),
			selenium.getText("//span[@class='disabled']/span"));
		assertTrue(selenium.isElementNotPresent(
				"//span[@class='action add-connection']/a"));
	}
}