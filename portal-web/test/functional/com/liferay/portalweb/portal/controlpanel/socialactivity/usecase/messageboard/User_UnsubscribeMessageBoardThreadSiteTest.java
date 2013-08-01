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

package com.liferay.portalweb.portal.controlpanel.socialactivity.usecase.messageboard;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_UnsubscribeMessageBoardThreadSiteTest extends BaseTestCase {
	public void testUser_UnsubscribeMessageBoardThreadSite()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementNotPresent("//body[contains(@id,'aui')]");
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//a[@id='_19_mbThreadsSearchContainer_1_menu_unsubscribe']");
		assertEquals(RuntimeVariables.replace("Unsubscribe"),
			selenium.getText(
				"//a[@id='_19_mbThreadsSearchContainer_1_menu_unsubscribe']"));
		selenium.clickAt("//a[@id='_19_mbThreadsSearchContainer_1_menu_unsubscribe']",
			RuntimeVariables.replace("Unsubscribe"));
		selenium.waitForPageToLoad("30000");
	}
}