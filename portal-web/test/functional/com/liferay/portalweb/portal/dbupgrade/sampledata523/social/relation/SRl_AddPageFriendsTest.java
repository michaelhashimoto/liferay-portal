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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.social.relation;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SRl_AddPageFriendsTest extends BaseTestCase {
	public void testSRl_AddPageFriends() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialrelationsn1/home/");
		selenium.waitForVisible("//div[@id='add-page']/a/span");
		assertEquals(RuntimeVariables.replace("Add Page"),
			selenium.getText("//div[@id='add-page']/a/span"));
		selenium.clickAt("//div[@id='add-page']/a/span",
			RuntimeVariables.replace("Add Page"));
		selenium.waitForVisible("//input[@name='new_page']");
		selenium.type("//input[@name='new_page']",
			RuntimeVariables.replace("Friends Test Page"));
		selenium.waitForVisible("//a[@class='save-page']");
		selenium.clickAt("//a[@class='save-page']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("link=Friends Test Page");
		selenium.clickAt("link=Friends Test Page",
			RuntimeVariables.replace("Friends Test Page"));
		selenium.waitForPageToLoad("30000");
	}
}