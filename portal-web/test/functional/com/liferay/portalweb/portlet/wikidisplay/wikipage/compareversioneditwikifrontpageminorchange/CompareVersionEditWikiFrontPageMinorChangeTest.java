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

package com.liferay.portalweb.portlet.wikidisplay.wikipage.compareversioneditwikifrontpageminorchange;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CompareVersionEditWikiFrontPageMinorChangeTest extends BaseTestCase {
	public void testCompareVersionEditWikiFrontPageMinorChange()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.click(RuntimeVariables.replace("link=Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Details"),
			selenium.getText(
				"//div[@class='page-actions top-actions']/span/a[contains(.,'Details')]"));
		selenium.clickAt("//div[@class='page-actions top-actions']/span/a[contains(.,'Details')]",
			RuntimeVariables.replace("Details"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=History", RuntimeVariables.replace("History"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("1.2 (Minor Edit)"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("1.1"),
			selenium.getText("//tr[4]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("1.0 (Minor Edit)"),
			selenium.getText("//tr[5]/td[4]/a"));
		assertFalse(selenium.isChecked("//td[1]/input"));
		selenium.check("//td[1]/input");
		assertTrue(selenium.isChecked("//td[1]/input"));
		assertFalse(selenium.isChecked("//tr[4]/td[1]/input"));
		selenium.check("//tr[4]/td[1]/input");
		assertTrue(selenium.isChecked("//tr[4]/td[1]/input"));
		assertFalse(selenium.isChecked("//tr[5]/td[1]/input"));
		selenium.clickAt("//input[@value='Compare Versions']",
			RuntimeVariables.replace("Compare Versions"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Comparing Versions 1.1 and 1.2 (Last Version)"),
			selenium.getText("//span[@class='central-title']/span"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage Content Edit"),
			selenium.getText("//p"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//span[@class='diff-html-added']"));
		assertEquals(RuntimeVariables.replace("Text Mode"),
			selenium.getText("//a[@class='change-mode']"));
		selenium.clickAt("//a[@class='change-mode']",
			RuntimeVariables.replace("Text Mode"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage 1.1"),
			selenium.getText(
				"xPath=(//table[@id='taglib-diff-results']/tbody/tr/td)[1]"));
		assertEquals(RuntimeVariables.replace("FrontPage 1.2"),
			selenium.getText(
				"xPath=(//table[@id='taglib-diff-results']/tbody/tr/td)[2]"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage Content"),
			selenium.getText(
				"xPath=(//table[@class='taglib-diff-table']/tbody/tr/td)[1]"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage Content Edit"),
			selenium.getText(
				"xPath=(//table[@class='taglib-diff-table']/tbody/tr/td)[2]"));
	}
}