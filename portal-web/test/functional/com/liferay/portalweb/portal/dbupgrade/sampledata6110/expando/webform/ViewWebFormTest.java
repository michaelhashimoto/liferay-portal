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

package com.liferay.portalweb.portal.dbupgrade.sampledata6110.expando.webform;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWebFormTest extends BaseTestCase {
	public void testViewWebForm() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/expando-web-form-community/");
		selenium.clickAt("link=Web Form Page",
			RuntimeVariables.replace("Web Form Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]"));
		selenium.click(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
		selenium.waitForVisible("//iframe");
		selenium.selectFrame("//iframe");
		selenium.waitForText("//div[@class='portlet-msg-alert']",
			"There is existing form data. Please export and delete it before making changes to the fields.");
		assertEquals(RuntimeVariables.replace(
				"There is existing form data. Please export and delete it before making changes to the fields."),
			selenium.getText("//div[@class='portlet-msg-alert']"));
		assertTrue(selenium.isElementPresent("//input[@value='Export Data']"));
		assertTrue(selenium.isElementPresent("//input[@value='Delete Data']"));
		selenium.selectFrame("relative=top");
	}
}