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

package com.liferay.portalweb.portlet.directory.usergroup.viewusergroupuser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewUserGroupUserTest extends BaseTestCase {
	public void testViewUserGroupUser() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Directory Test Page",
			RuntimeVariables.replace("Directory Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=User Groups",
			RuntimeVariables.replace("User Groups"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("User Group Name"),
			selenium.getText("//tr[3]/td[1]"));
		assertEquals(RuntimeVariables.replace("User Group Description"),
			selenium.getText("//tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("View Users"),
			selenium.getText("//td[3]/span/a/span"));
		selenium.clickAt("//td[3]/span/a/span",
			RuntimeVariables.replace("View Users"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("userfn"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("userln"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("usersn"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace(""), selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace(""), selenium.getText("//td[5]/a"));
		selenium.clickAt("//td[1]/a", RuntimeVariables.replace("userfn"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("userfn usermn userln"),
			selenium.getText("//div[@class='user-information']/div[1]/h2"));
		assertEquals(RuntimeVariables.replace("Email Address"),
			selenium.getText("//dl[@class='property-list']/dt[1]"));
		assertEquals(RuntimeVariables.replace("userea@liferay.com"),
			selenium.getText("//dl[@class='property-list']/dd[1]"));
		assertEquals(RuntimeVariables.replace("Birthday"),
			selenium.getText("//dl[@class='property-list']/dt[2]"));
		assertEquals(RuntimeVariables.replace("4/10/86"),
			selenium.getText("//dl[@class='property-list']/dd[2]"));
		assertEquals(RuntimeVariables.replace("Gender"),
			selenium.getText("//dl[@class='property-list']/dt[3]"));
		assertEquals(RuntimeVariables.replace("Male"),
			selenium.getText("//dl[@class='property-list']/dd[3]"));
	}
}