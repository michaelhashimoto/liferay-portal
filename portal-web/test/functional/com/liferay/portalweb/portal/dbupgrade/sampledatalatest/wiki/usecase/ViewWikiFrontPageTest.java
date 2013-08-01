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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.wiki.usecase;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWikiFrontPageTest extends BaseTestCase {
	public void testViewWikiFrontPage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/wiki-use-case-community/");
		selenium.waitForVisible("link=Wiki Test Page");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		assertEquals(RuntimeVariables.replace("Details"),
			selenium.getText("//div[3]/span[2]/a/span"));
		selenium.clickAt("//div[3]/span[2]/a/span",
			RuntimeVariables.replace("Details"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText("//tr[1]/td"));
		assertEquals(RuntimeVariables.replace("Creole"),
			selenium.getText("//tr[2]/td"));
		assertEquals(RuntimeVariables.replace("1.1"),
			selenium.getText("//tr[3]/td"));
		assertTrue(selenium.isPartialText("//tr[5]/td", "Joe Bloggs"));
		assertTrue(selenium.isVisible("//tr[6]/td"));
		selenium.clickAt("link=History", RuntimeVariables.replace("History"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText("//tr[3]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//tr[3]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.1"),
			selenium.getText("//tr[3]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//tr[3]/td[5]/a"));
		assertTrue(selenium.isElementPresent("//tr[3]/td[6]/a"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[3]/td[7]"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[3]/td[8]"));
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText("//tr[4]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//tr[4]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0 (Minor Edit)"),
			selenium.getText("//tr[4]/td[4]/a"));
		assertTrue(selenium.isElementPresent("//tr[4]/td[6]/a"));
		assertEquals(RuntimeVariables.replace("New"),
			selenium.getText("//tr[4]/td[7]"));
		assertEquals(RuntimeVariables.replace("Revert"),
			selenium.getText("//tr[4]/td[8]/span/a/span"));
		selenium.clickAt("link=Recent Changes",
			RuntimeVariables.replace("Recent Changes"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText("link=FrontPage"));
		selenium.clickAt("link=All Pages", RuntimeVariables.replace("All Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText("link=FrontPage"));
		selenium.clickAt("link=Orphan Pages",
			RuntimeVariables.replace("Orphan Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText("link=FrontPage"));
		selenium.clickAt("link=Draft Pages",
			RuntimeVariables.replace("Draft Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("There are no drafts."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}