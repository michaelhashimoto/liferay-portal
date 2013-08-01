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

package com.liferay.portalweb.portlet.wikidisplay.wikipage.changeparentwdfrontpagechildpagetonone;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ChangeParentWDFrontPageChildPageToNoneTest extends BaseTestCase {
	public void testChangeParentWDFrontPageChildPageToNone()
		throws Exception {
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
		assertEquals(RuntimeVariables.replace("\u00ab Back to FrontPage"),
			selenium.getText("//span[@class='header-back-to']"));
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
				"//ul[@class='lfr-component taglib-icon-list']/li/a/span[contains(.,'Move')]"));
		selenium.clickAt("//ul[@class='lfr-component taglib-icon-list']/li/a/span[contains(.,'Move')]",
			RuntimeVariables.replace("Move"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Change Parent",
			RuntimeVariables.replace("Change Parent"));
		selenium.waitForVisible("//select[contains(@id,'newParentTitle')]");
		selenium.select("//select[contains(@id,'newParentTitle')]",
			RuntimeVariables.replace("None"));
		selenium.clickAt("//input[@value='Change Parent']",
			RuntimeVariables.replace("Change Parent"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace("Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Children Pages"));
		assertFalse(selenium.isTextPresent("Wiki FrontPage ChildPage Title"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace("Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=All Pages", RuntimeVariables.replace("All Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText(
				"//tr[contains(.,'Wiki FrontPage ChildPage Title')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText(
				"//tr[contains(.,'Wiki FrontPage ChildPage Title')]/td[2]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'Wiki FrontPage ChildPage Title')]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText(
				"//tr[contains(.,'Wiki FrontPage ChildPage Title')]/td[4]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'Wiki FrontPage ChildPage Title')]/td[5]/a"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//tr[contains(.,'Wiki FrontPage ChildPage Title')]/td[6]/span/ul/li/strong/a/span"));
		selenium.clickAt("//tr[contains(.,'Wiki FrontPage ChildPage Title')]/td[1]/a",
			RuntimeVariables.replace("Wiki FrontPage ChildPage Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertFalse(selenium.isTextPresent("\u00ab Back to FrontPage"));
		assertEquals(RuntimeVariables.replace(
				"Wiki FrontPage ChildPage Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
	}
}