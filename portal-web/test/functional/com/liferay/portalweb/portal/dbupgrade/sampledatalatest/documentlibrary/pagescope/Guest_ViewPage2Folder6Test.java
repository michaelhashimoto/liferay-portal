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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_ViewPage2Folder6Test extends BaseTestCase {
	public void testGuest_ViewPage2Folder6() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/document-library-page-scope-community/");
		selenium.waitForVisible("link=DL Page2 Name");
		selenium.clickAt("link=DL Page2 Name",
			RuntimeVariables.replace("DL Page2 Name"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//span[@class='portlet-title-text']",
			"Documents and Media (DL Page2 Name)");
		assertEquals(RuntimeVariables.replace(
				"Documents and Media (DL Page2 Name)"),
			selenium.getText("//span[@class='portlet-title-text']"));
		assertTrue(selenium.isVisible(
				"xPath=(//span[@class='document-thumbnail']/img)[5]"));
		assertEquals(RuntimeVariables.replace("DL Folder6 Name"),
			selenium.getText(
				"xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[5]"));
		selenium.clickAt("xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[5]",
			RuntimeVariables.replace("DL Folder6 Name"));
		selenium.waitForText("//a[@class='browse-folder']", "Up");
		assertEquals(RuntimeVariables.replace("Up"),
			selenium.getText("//a[@class='browse-folder']"));
		assertEquals(RuntimeVariables.replace("DL Folder6 Name"),
			selenium.getText("//li[@class='folder selected']/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DL Page2 Name"),
			selenium.getText(
				"//div[@id='_20_breadcrumbContainer']/ul/li[1]/span"));
		assertEquals(RuntimeVariables.replace("Home"),
			selenium.getText(
				"//div[@id='_20_breadcrumbContainer']/ul/li[2]/span/a"));
		assertEquals(RuntimeVariables.replace("DL Folder6 Name"),
			selenium.getText(
				"//div[@id='_20_breadcrumbContainer']/ul/li[3]/span/a"));
		selenium.open("/web/document-library-page-scope-community/");
		selenium.waitForVisible("link=DL Page3 Name");
		selenium.clickAt("link=DL Page3 Name",
			RuntimeVariables.replace("DL Page3 Name"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//span[@class='portlet-title-text']",
			"Documents and Media (DL Page2 Name)");
		assertEquals(RuntimeVariables.replace(
				"Documents and Media (DL Page2 Name)"),
			selenium.getText("//span[@class='portlet-title-text']"));
		assertTrue(selenium.isVisible(
				"xPath=(//span[@class='document-thumbnail']/img)[5]"));
		assertEquals(RuntimeVariables.replace("DL Folder6 Name"),
			selenium.getText(
				"xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[5]"));
		selenium.clickAt("xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[5]",
			RuntimeVariables.replace("DL Folder6 Name"));
		selenium.waitForText("//a[@class='browse-folder']", "Up");
		assertEquals(RuntimeVariables.replace("Up"),
			selenium.getText("//a[@class='browse-folder']"));
		assertEquals(RuntimeVariables.replace("DL Folder6 Name"),
			selenium.getText("//li[@class='folder selected']/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DL Page2 Name"),
			selenium.getText(
				"//div[@id='_20_breadcrumbContainer']/ul/li[1]/span"));
		assertEquals(RuntimeVariables.replace("Home"),
			selenium.getText(
				"//div[@id='_20_breadcrumbContainer']/ul/li[2]/span/a"));
		assertEquals(RuntimeVariables.replace("DL Folder6 Name"),
			selenium.getText(
				"//div[@id='_20_breadcrumbContainer']/ul/li[3]/span/a"));
	}
}