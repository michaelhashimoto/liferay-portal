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

package com.liferay.portalweb.portal.tags.tagsadmin;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchTagsTest extends BaseTestCase {
	public void testSearchTags() throws Exception {
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
		selenium.clickAt("link=Tags", RuntimeVariables.replace("Tags"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_99_tagsAdminSearchInput']",
			RuntimeVariables.replace("blue"));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("blue"),
			selenium.getText("link=blue"));
		assertEquals(RuntimeVariables.replace("blue car"),
			selenium.getText("link=blue car"));
		assertEquals(RuntimeVariables.replace("blue green"),
			selenium.getText("link=blue green"));
		assertFalse(selenium.isTextPresent("link=green"));
		assertFalse(selenium.isTextPresent("link=green tree"));
		selenium.type("//input[@id='_99_tagsAdminSearchInput']",
			RuntimeVariables.replace("green"));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("blue green"),
			selenium.getText("link=blue green"));
		assertEquals(RuntimeVariables.replace("green"),
			selenium.getText("link=green"));
		assertEquals(RuntimeVariables.replace("green tree"),
			selenium.getText("link=green tree"));
		assertFalse(selenium.isTextPresent("link=blue"));
		assertFalse(selenium.isTextPresent("link=blue car"));
	}
}