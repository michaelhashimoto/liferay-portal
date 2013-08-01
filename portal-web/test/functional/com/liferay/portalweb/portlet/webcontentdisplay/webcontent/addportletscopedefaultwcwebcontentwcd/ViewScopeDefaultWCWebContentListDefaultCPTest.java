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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.addportletscopedefaultwcwebcontentwcd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewScopeDefaultWCWebContentListDefaultCPTest extends BaseTestCase {
	public void testViewScopeDefaultWCWebContentListDefaultCP()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Web Content",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//div/span/ul/li/strong/a",
				"Scope: Default"));
		selenium.clickAt("//div/span/ul/li/strong/a",
			RuntimeVariables.replace("Scope: Default"));
		assertEquals(RuntimeVariables.replace("Default"),
			selenium.getText("//a"));
		selenium.clickAt("//a", RuntimeVariables.replace("Default"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//div/span/ul/li/strong/a",
				"Scope: Default"));
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[4]/a"));
	}
}