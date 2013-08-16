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

package com.liferay.portalweb.portal.permissions.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Member_AssertActionsTest extends BaseTestCase {
	public void testMember_AssertActions() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertTrue(selenium.isVisible("//input[@title='Search Messages']"));
		assertTrue(selenium.isVisible("//input[@value='Search']"));
		assertEquals(RuntimeVariables.replace("RSS"),
			selenium.getText(
				"//div[@class='category-subscription-types']/span/a/span[contains(.,'RSS')]"));
		assertEquals(RuntimeVariables.replace("Subscribe"),
			selenium.getText(
				"//div[@class='category-subscription-types']/span/a/span[contains(.,'Subscribe')]"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Add Category']"));
		assertTrue(selenium.isVisible("//input[@value='Post New Thread']"));
		assertTrue(selenium.isElementNotPresent("//input[@value='Permissions']"));
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//tr[contains(.,'MB Category Name')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[contains(.,'MB Category Name')]/td[2]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//tr[contains(.,'MB Category Name')]/td[3]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//tr[contains(.,'MB Category Name')]/td[4]"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//tr[contains(.,'MB Category Name')]/td[5]/span[@title='Actions']/ul/li/strong/a"));
		selenium.clickAt("//tr[contains(.,'MB Category Name')]/td[5]/span[@title='Actions']/ul/li/strong/a",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'RSS')]");
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Permissions')]"));
		assertEquals(RuntimeVariables.replace("RSS (Opens New Window)"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'RSS')]"));
		assertEquals(RuntimeVariables.replace("Subscribe"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Subscribe')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]"));
		selenium.clickAt("//tr[contains(.,'MB Category Name')]/td[1]/a",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertTrue(selenium.isVisible("//input[@title='Search Messages']"));
		assertTrue(selenium.isVisible("//input[@value='Search']"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Add Subcategory']"));
		assertTrue(selenium.isVisible("//input[@value='Post New Thread']"));
		assertTrue(selenium.isElementNotPresent("//input[@value='Permissions']"));
		assertEquals(RuntimeVariables.replace(
				"\u00ab Back to Message Boards Home"),
			selenium.getText("//span[@class='header-back-to']/a"));
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("MB Thread Message Subject"),
			selenium.getText(
				"//tr[contains(.,'MB Thread Message Subject')]/td[1]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'MB Thread Message Subject')]/td[2]"));
		assertEquals(RuntimeVariables.replace("MA Liferay"),
			selenium.getText(
				"//tr[contains(.,'MB Thread Message Subject')]/td[3]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//tr[contains(.,'MB Thread Message Subject')]/td[4]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//tr[contains(.,'MB Thread Message Subject')]/td[5]"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'MB Thread Message Subject')]/td[6]"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//tr[contains(.,'MB Thread Message Subject')]/td[7]/span[@title='Actions']/ul/li/strong/a"));
		selenium.clickAt("//tr[contains(.,'MB Thread Message Subject')]/td[7]/span[@title='Actions']/ul/li/strong/a",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'RSS')]");
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Permissions')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Unsubscribe')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Lock Thread')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Move Thread')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]"));
		assertTrue(selenium.isVisible(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'RSS')]"));
		assertTrue(selenium.isVisible(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Subscribe')]"));
		selenium.clickAt("//tr[contains(.,'MB Thread Message Subject')]/td[1]/a",
			RuntimeVariables.replace("MB Thread Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("\u00ab Back to MB Category Name"),
			selenium.getText("//span[@class='header-back-to']/a"));
		assertEquals(RuntimeVariables.replace("MB Thread Message Subject"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Post New Thread"),
			selenium.getText(
				"//div[@class='thread-actions']/table/tbody/tr/td/span/a[contains(.,'Post New Thread')]"));
		assertEquals(RuntimeVariables.replace("Subscribe"),
			selenium.getText(
				"//div[@class='thread-actions']/table/tbody/tr/td/span/a[contains(.,'Subscribe')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='thread-actions']/table/tbody/tr/td/span/a[contains(.,'Lock Thread')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='thread-actions']/table/tbody/tr/td/span/a[contains(.,'Move Thread')]"));
		assertEquals(RuntimeVariables.replace("Reply"),
			selenium.getText(
				"//ul[@class='edit-controls lfr-component']/li[2]/span/a"));
		assertEquals(RuntimeVariables.replace("Reply with Quote"),
			selenium.getText(
				"//ul[@class='edit-controls lfr-component']/li[3]/span/a"));
		assertEquals(RuntimeVariables.replace("Quick Reply"),
			selenium.getText(
				"//ul[@class='edit-controls lfr-component']/li[4]/span/a"));
		assertTrue(selenium.isElementNotPresent(
				"//ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Edit')]"));
		assertTrue(selenium.isElementNotPresent(
				"//ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Delete')]"));
	}
}