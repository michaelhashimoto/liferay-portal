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

package com.liferay.portalweb.portal.controlpanel.sites.site.leavesite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_LeaveSitesTest extends BaseTestCase {
	public void testUser_LeaveSites() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/usersn/home/");
		selenium.clickAt("link=My Sites", RuntimeVariables.replace("My Sites"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_29_name']",
			RuntimeVariables.replace("Site Name"));
		selenium.clickAt("xPath=(//input[@value='Search'])[3]",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Site Name"),
			selenium.getText("//tr[contains(.,'Site Name')]/td[1]"));
		assertEquals(RuntimeVariables.replace("2"),
			selenium.getText("//tr[contains(.,'Site Name')]/td[2]"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[contains(.,'Site Name')]/td[3]"));
		assertEquals(RuntimeVariables.replace("Leave"),
			selenium.getText("//tr[contains(.,'Site Name')]/td[4]/span/a/span"));
		selenium.clickAt("//tr[contains(.,'Site Name')]/td[4]/span/a/span",
			RuntimeVariables.replace("Leave"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/user/usersn/home/");
		selenium.clickAt("link=My Sites", RuntimeVariables.replace("My Sites"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("No sites were found."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}