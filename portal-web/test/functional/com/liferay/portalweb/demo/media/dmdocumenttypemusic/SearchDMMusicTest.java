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

package com.liferay.portalweb.demo.media.dmdocumenttypemusic;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchDMMusicTest extends BaseTestCase {
	public void testSearchDMMusic() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("mp3"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForText("//div[@class='search-info']/span[@class='keywords']",
			"Searched for mp3 everywhere.");
		assertEquals(RuntimeVariables.replace("Searched for mp3 everywhere."),
			selenium.getText(
				"//div[@class='search-info']/span[@class='keywords']"));
		assertEquals(RuntimeVariables.replace("DM Music Title"),
			selenium.getText(
				"//div[@data-title='DM Music Title']/a/span[@class='entry-title']"));
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("music"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForText("//div[@class='search-info']/span[@class='keywords']",
			"Searched for music everywhere.");
		assertEquals(RuntimeVariables.replace("Searched for music everywhere."),
			selenium.getText(
				"//div[@class='search-info']/span[@class='keywords']"));
		assertEquals(RuntimeVariables.replace("DM Music Title"),
			selenium.getText(
				"//div[@data-title='DM Music Title']/a/span[@class='entry-title']"));
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("\"DM Music Title\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForText("//div[@class='search-info']/span[@class='keywords']",
			"Searched for \"DM Music Title\" everywhere.");
		assertEquals(RuntimeVariables.replace(
				"Searched for \"DM Music Title\" everywhere."),
			selenium.getText(
				"//div[@class='search-info']/span[@class='keywords']"));
		assertEquals(RuntimeVariables.replace("DM Music Title"),
			selenium.getText(
				"//div[@data-title='DM Music Title']/a/span[@class='entry-title']"));
	}
}