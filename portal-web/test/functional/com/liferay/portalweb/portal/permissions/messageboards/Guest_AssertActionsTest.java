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
public class Guest_AssertActionsTest extends BaseTestCase {
	public void testGuest_AssertActions() throws Exception {
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
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='category-subscription-types']/span/a/span[contains(.,'Subscribe')]"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Add Category']"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Post New Thread']"));
		assertTrue(selenium.isElementNotPresent("//input[@value='Permissions']"));
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//tr[contains(.,'MB Category Name')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[contains(.,'MB Category Name')]/td[2]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//tr[contains(.,'MB Category Name')]/td[3]"));
		assertEquals(RuntimeVariables.replace("2"),
			selenium.getText("//tr[contains(.,'MB Category Name')]/td[4]"));
		assertEquals(RuntimeVariables.replace("RSS (Opens New Window)"),
			selenium.getText(
				"//tr[contains(.,'MB Category Name')]/td[5]/span/a"));
		assertTrue(selenium.isElementNotPresent(
				"//tr[contains(.,'MB Category Name')]/td[5]/span[@title='Actions']/ul/li/strong/a"));
		selenium.clickAt("//tr[contains(.,'MB Category Name')]/td[1]/a",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertTrue(selenium.isVisible("//input[@title='Search Messages']"));
		assertTrue(selenium.isVisible("//input[@value='Search']"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Add Subcategory']"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Post New Thread']"));
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
		assertEquals(RuntimeVariables.replace("2"),
			selenium.getText(
				"//tr[contains(.,'MB Thread Message Subject')]/td[4]"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'MB Thread Message Subject')]/td[5]"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'MB Thread Message Subject')]/td[6]"));
		assertTrue(selenium.isElementNotPresent(
				"//tr[contains(.,'MB Thread Message Subject')]/td[7]/span[@title='Actions']/ul/li/strong/a"));
		assertEquals(RuntimeVariables.replace("RSS (Opens New Window)"),
			selenium.getText(
				"//tr[contains(.,'MB Thread Message Subject')]/td[7]/span/a"));
		selenium.clickAt("//tr[contains(.,'MB Thread Message Subject')]/td[1]/a",
			RuntimeVariables.replace("MB Thread Message Subject"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("MB Thread Message Subject"),
			selenium.getText("//h1[@class='header-title']"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='thread-actions']/table/tbody/tr/td/span/a[contains(.,'Post New Thread')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='thread-actions']/table/tbody/tr/td/span/a[contains(.,'Subscribe')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='thread-actions']/table/tbody/tr/td/span/a[contains(.,'Lock Thread')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='thread-actions']/table/tbody/tr/td/span/a[contains(.,'Move Thread')]"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body')]/tr/td/ul[@class='edit-controls lfr-component']/li[2]/span/a"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body')]/tr/td/ul[@class='edit-controls lfr-component']/li[3]/span/a"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body')]/tr/td/ul[@class='edit-controls lfr-component']/li[4]/span/a"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Edit')]"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Permissions')]"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Split Thread')]"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Delete')]"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body')]/tr/td/div/div[@class='user-details']/span/a[contains(.,'Ban This User')]"));
		assertEquals(RuntimeVariables.replace("Sign in to vote."),
			selenium.getText(
				"//tbody[contains(.,'MB Thread Message Body')]/tr/td/div[@class='taglib-ratings thumbs']/a"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/ul[@class='edit-controls lfr-component']/li[2]/span/a"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/ul[@class='edit-controls lfr-component']/li[3]/span/a"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/ul[@class='edit-controls lfr-component']/li[4]/span/a"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Edit')]"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Permissions')]"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Split Thread')]"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/ul[@class='edit-controls lfr-component']/li/span/a[contains(.,'Delete')]"));
		assertTrue(selenium.isElementNotPresent(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/div/div[@class='user-details']/span/a[contains(.,'Ban This User')]"));
		assertEquals(RuntimeVariables.replace("Sign in to vote."),
			selenium.getText(
				"//tbody[contains(.,'MB Thread Message Body Reply')]/tr/td/div[@class='taglib-ratings thumbs']/a"));
	}
}