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

package com.liferay.portalweb.portlet.documentsandmedia.dmdocument.searchdmfolderdocument;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchDMFolderDocumentQuotesTest extends BaseTestCase {
	public void testSearchDMFolderDocumentQuotes() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("\"DM Folder Document Title\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForVisible("//div[@class='search-info']/span[1]");
		assertEquals(RuntimeVariables.replace(
				"Searched for \"DM Folder Document Title\" everywhere."),
			selenium.getText("//div[@class='search-info']/span[1]"));
		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("\"DM Folder Document Title 1\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForVisible("//div[@class='search-info']/span[1]");
		assertEquals(RuntimeVariables.replace(
				"Searched for \"DM Folder Document Title 1\" everywhere."),
			selenium.getText("//div[@class='search-info']/span[1]"));
		assertTrue(selenium.isElementNotPresent(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		assertTrue(selenium.isElementNotPresent("link=DM Folder Document Title"));
	}
}