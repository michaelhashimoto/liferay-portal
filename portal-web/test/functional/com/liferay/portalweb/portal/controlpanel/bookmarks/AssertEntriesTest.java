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

package com.liferay.portalweb.portal.controlpanel.bookmarks;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertEntriesTest extends BaseTestCase {
	public void testAssertEntries() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Bookmarks", RuntimeVariables.replace("Bookmarks"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Mine", RuntimeVariables.replace("Mine"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("exact:http://www.digg.com"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("exact:http://www.liferay.com"),
			selenium.getText("//tr[4]/td[2]/a"));
		selenium.clickAt("link=Recent", RuntimeVariables.replace("Recent"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("exact:http://www.digg.com"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("exact:http://www.liferay.com"),
			selenium.getText("//tr[4]/td[2]/a"));
	}
}