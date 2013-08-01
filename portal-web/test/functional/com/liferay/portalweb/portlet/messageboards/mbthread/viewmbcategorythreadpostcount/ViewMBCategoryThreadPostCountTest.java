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

package com.liferay.portalweb.portlet.messageboards.mbthread.viewmbcategorythreadpostcount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMBCategoryThreadPostCountTest extends BaseTestCase {
	public void testViewMBCategoryThreadPostCount() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Message Boards Test Page");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("3"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[3]"));
		assertEquals(RuntimeVariables.replace("6"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[4]"));
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("4"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[3]/td[4]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[4]/td[4]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[5]/td[4]"));
		selenium.clickAt("link=MB Category Thread1 Message Subject",
			RuntimeVariables.replace("MB Category Thread1 Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//div[7]/table/tbody/tr[2]/td/ul/li[5]/span/a/span"));
		selenium.clickAt("//div[7]/table/tbody/tr[2]/td/ul/li[5]/span/a/span",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete this[\\s\\S]$"));
		selenium.waitForText("//div[@class='portlet-msg-success']",
			"Your request completed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Message Boards Test Page");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("3"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[3]"));
		assertEquals(RuntimeVariables.replace("5"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[4]"));
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("3"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[3]/td[4]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[4]/td[4]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[5]/td[4]"));
		selenium.clickAt("link=MB Category Thread1 Message Subject",
			RuntimeVariables.replace("MB Category Thread1 Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//div[6]/table/tbody/tr[2]/td/ul/li[5]/span/a/span"));
		selenium.clickAt("//div[6]/table/tbody/tr[2]/td/ul/li[5]/span/a/span",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete this[\\s\\S]$"));
		selenium.waitForText("//div[@class='portlet-msg-success']",
			"Your request completed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Message Boards Test Page");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("3"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[3]"));
		assertEquals(RuntimeVariables.replace("4"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[4]"));
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("2"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[3]/td[4]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[4]/td[4]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[5]/td[4]"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//td[7]/span/ul/li/strong/a"));
		selenium.clickAt("//td[7]/span/ul/li/strong/a",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[7]/a");
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[7]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[7]/a",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete this[\\s\\S]$"));
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Message Boards Test Page");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("2"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[3]"));
		assertEquals(RuntimeVariables.replace("2"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[4]"));
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[3]/td[4]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText(
				"//table[@class='taglib-search-iterator']/tbody/tr[4]/td[4]"));
	}
}