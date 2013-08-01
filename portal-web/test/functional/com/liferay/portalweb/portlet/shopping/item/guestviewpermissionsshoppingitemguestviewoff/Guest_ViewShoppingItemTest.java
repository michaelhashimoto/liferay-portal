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

package com.liferay.portalweb.portlet.shopping.item.guestviewpermissionsshoppingitemguestviewoff;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_ViewShoppingItemTest extends BaseTestCase {
	public void testGuest_ViewShoppingItem() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("1111"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[1]/a"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping Item Name"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping Item Description"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping: Item Properties"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[3]/a"));
		assertEquals(RuntimeVariables.replace("$9.99"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[4]/a"));
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td[2]/a",
			RuntimeVariables.replace("Shopping Item Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Item"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("1111"),
			selenium.getText("//td[@class='lfr-top']/strong"));
		assertEquals(RuntimeVariables.replace("Shopping Item Name"),
			selenium.getText("//td[@class='lfr-top']/span/strong"));
		assertTrue(selenium.isPartialText("xPath=(//td[@class='lfr-top'])[2]",
				"Shopping Item Description"));
		assertTrue(selenium.isPartialText("xPath=(//td[@class='lfr-top'])[2]",
				"Shopping: Item Properties"));
		assertTrue(selenium.isPartialText("xPath=(//td[@class='lfr-top'])[2]",
				"Availability:"));
		assertEquals(RuntimeVariables.replace("In Stock"),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isPartialText("xPath=(//td[@class='lfr-top'])[2]",
				"Price for 1 to 1 Items"));
		assertTrue(selenium.isPartialText("xPath=(//td[@class='lfr-top'])[2]",
				"9.99"));
	}
}