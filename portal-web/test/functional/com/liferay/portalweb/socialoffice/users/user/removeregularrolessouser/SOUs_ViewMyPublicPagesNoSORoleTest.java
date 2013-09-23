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

package com.liferay.portalweb.socialoffice.users.user.removeregularrolessouser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewMyPublicPagesNoSORoleTest extends BaseTestCase {
	public void testSOUs_ViewMyPublicPagesNoSORole() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/dockbar_underlay.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("//span[contains(.,'My Public Pages')]");
		selenium.clickAt("//span[contains(.,'My Public Pages')]",
			RuntimeVariables.replace("My Public Pages"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible(
				"//a[@title='Go to Social01 Office01 User01']"));
		assertTrue(selenium.isElementNotPresent("link=Dashboard"));
		assertTrue(selenium.isElementNotPresent("link=Contacts Center"));
		assertTrue(selenium.isElementNotPresent("link=Microblogs"));
		assertTrue(selenium.isElementNotPresent("link=Messages"));
		assertTrue(selenium.isElementNotPresent("link=My Documents"));
		assertTrue(selenium.isElementNotPresent("link=Tasks"));
		assertEquals(RuntimeVariables.replace("Welcome"),
			selenium.getText("link=Welcome"));
		selenium.clickAt("link=Welcome", RuntimeVariables.replace("Welcome"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Language"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'Language')]"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'Blogs')]"));
		assertEquals(RuntimeVariables.replace("Search"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'Search')]"));
	}
}