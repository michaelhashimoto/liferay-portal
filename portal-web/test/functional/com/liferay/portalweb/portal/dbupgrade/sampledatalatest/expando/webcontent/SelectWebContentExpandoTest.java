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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.expando.webcontent;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SelectWebContentExpandoTest extends BaseTestCase {
	public void testSelectWebContentExpando() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/expando-web-content-community/");
		selenium.waitForVisible("link=Web Content Display Page");
		selenium.clickAt("link=Web Content Display Page",
			RuntimeVariables.replace("Web Content Display Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//img[@alt='Select Web Content']",
			RuntimeVariables.replace("Select Web Content"));
		selenium.waitForVisible("link=Expando Web Content Test");
		selenium.clickAt("link=Expando Web Content Test",
			RuntimeVariables.replace("Expando Web Content Test"));
		selenium.waitForPartialText("//form[@id='_86_fm1']/div",
			"Displaying Content:");
		assertTrue(selenium.isPartialText("//form[@id='_86_fm1']/div",
				"Displaying Content:"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}