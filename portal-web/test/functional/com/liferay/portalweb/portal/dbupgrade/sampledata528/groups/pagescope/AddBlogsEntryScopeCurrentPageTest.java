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

package com.liferay.portalweb.portal.dbupgrade.sampledata528.groups.pagescope;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddBlogsEntryScopeCurrentPageTest extends BaseTestCase {
	public void testAddBlogsEntryScopeCurrentPage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Communities",
			RuntimeVariables.replace("Communities"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Group Page Scope Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Open"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Blogs Page Scope Current Page",
			RuntimeVariables.replace("Blogs Page Scope Current Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Blog Entry']",
			RuntimeVariables.replace("Add Blog Entry"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_33_title']",
			RuntimeVariables.replace("Blogs Entry Scope Current Page"));
		Thread.sleep(5000);
		selenium.waitForElementPresent("//iframe[@id='_33_editor']");
		selenium.waitForElementPresent("FCKeditor1___Frame");
		selenium.waitForElementPresent("//textarea");
		selenium.selectFrame("//iframe[@id='_33_editor']");
		selenium.selectFrame("//iframe[@id='FCKeditor1___Frame']");
		selenium.selectFrame("//iframe");
		selenium.type("//body",
			RuntimeVariables.replace(
				"This is a blogs entry scope current page test."));
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertEquals(RuntimeVariables.replace("Blogs Entry Scope Current Page"),
			selenium.getText("//div[@class='entry-title']/a"));
		assertEquals(RuntimeVariables.replace(
				"This is a blogs entry scope current page test."),
			selenium.getText("//p"));
	}
}