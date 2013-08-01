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

package com.liferay.portalweb.portlet.wikidisplay.wikipage.renamewdfrontpagechildpage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RenameWDFrontPageChildPageTest extends BaseTestCase {
	public void testRenameWDFrontPageChildPage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace("Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//div[@class='child-pages']/ul/li/a"));
		selenium.clickAt("//div[@class='child-pages']/ul/li/a",
			RuntimeVariables.replace("Wiki FrontPage ChildPage Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace(
				"Wiki FrontPage ChildPage Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		assertEquals(RuntimeVariables.replace("Details"),
			selenium.getText(
				"//div[@class='page-actions top-actions']/span/a[contains(.,'Details')]"));
		selenium.clickAt("//div[@class='page-actions top-actions']/span/a[contains(.,'Details')]",
			RuntimeVariables.replace("Details"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Move"),
			selenium.getText(
				"//ul[@class='lfr-component taglib-icon-list']/li/a[contains(.,'Move')]"));
		selenium.click(RuntimeVariables.replace(
				"//ul[@class='lfr-component taglib-icon-list']/li/a[contains(.,'Move')]"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		selenium.type("//input[contains(@id,'_newTitle')]",
			RuntimeVariables.replace("Wiki FrontPage ChildPage Title Rename"));
		selenium.clickAt("//input[@value='Rename']",
			RuntimeVariables.replace("Rename"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"Wiki FrontPage ChildPage Title Rename"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertNotEquals(RuntimeVariables.replace(
				"Wiki FrontPage ChildPage Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace(
				"(Redirected from Wiki FrontPage ChildPage Title)"),
			selenium.getText("//div[@class='page-redirect']"));
		assertEquals(RuntimeVariables.replace(
				"Wiki FrontPage ChildPage Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace("Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Wiki FrontPage ChildPage Title Rename"),
			selenium.getText("//div[@class='child-pages']/ul/li/a"));
		assertNotEquals(RuntimeVariables.replace(
				"Wiki FrontPage ChildPage Title"),
			selenium.getText("//div[@class='child-pages']/ul/li/a"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace("Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=All Pages", RuntimeVariables.replace("All Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//tr[4]/td[1]/a"));
		assertEquals(RuntimeVariables.replace(
				"Wiki FrontPage ChildPage Title Rename"),
			selenium.getText("//tr[5]/td[1]/a"));
	}
}