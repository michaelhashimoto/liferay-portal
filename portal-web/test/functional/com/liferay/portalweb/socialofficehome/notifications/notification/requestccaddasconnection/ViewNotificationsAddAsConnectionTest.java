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

package com.liferay.portalweb.socialofficehome.notifications.notification.requestccaddasconnection;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewNotificationsAddAsConnectionTest extends BaseTestCase {
	public void testViewNotificationsAddAsConnection()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		assertTrue(selenium.isElementPresent(
				"//li[@id='_145_notificationsMenu']"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.mouseOver("//li[@id='_145_notificationsMenu']");
		selenium.waitForVisible("//div[@class='title']");
		assertEquals(RuntimeVariables.replace(
				"Social01 Office01 User01 would like to add you as a connection."),
			selenium.getText("//div[@class='title']"));
		assertEquals(RuntimeVariables.replace("Confirm"),
			selenium.getText(
				"//span[@class='lfr-user-action-item lfr-user-action-confirm']/a"));
		assertEquals(RuntimeVariables.replace("Ignore"),
			selenium.getText(
				"//span[@class='lfr-user-action-item lfr-user-action-ignore']/a"));
	}
}