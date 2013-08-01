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

package com.liferay.portalweb.portal.permissions.documentlibrary.portlet.view;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RemoveInlinePermissionsTest extends BaseTestCase {
	public void testRemoveInlinePermissions() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Document Library Permissions Page");
		selenium.clickAt("link=Document Library Permissions Page",
			RuntimeVariables.replace("Document Library Permissions Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.click(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a");
		selenium.waitForVisible("//input[@value='Save']");
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText("//ul[@class='aui-tabview-list']/li[2]/span/a"));
		selenium.clickAt("//ul[@class='aui-tabview-list']/li[2]/span/a",
			RuntimeVariables.replace("Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.uncheck("//tbody/tr[3]/td[5]/input");
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}