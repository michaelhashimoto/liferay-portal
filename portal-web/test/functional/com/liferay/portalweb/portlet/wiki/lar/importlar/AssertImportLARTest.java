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

package com.liferay.portalweb.portlet.wiki.lar.importlar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertImportLARTest extends BaseTestCase {
	public void testAssertImportLAR() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		assertEquals(RuntimeVariables.replace("Children Pages"),
			selenium.getText("//div[@class='child-pages']/h2"));
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page1 Title"),
			selenium.getText("xPath=(//div[@class='child-pages']/ul/li/a)[1]"));
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page2 Title"),
			selenium.getText("xPath=(//div[@class='child-pages']/ul/li/a)[2]"));
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page3 Title"),
			selenium.getText("xPath=(//div[@class='child-pages']/ul/li/a)[3]"));
		selenium.clickAt("xPath=(//div[@class='child-pages']/ul/li/a)[1]",
			RuntimeVariables.replace("Wiki Front Page Child Page1 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page1 Title"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page1 Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		selenium.clickAt("//span[@class='header-back-to']/a",
			RuntimeVariables.replace("\u00ab Back to FrontPage"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("xPath=(//div[@class='child-pages']/ul/li/a)[2]",
			RuntimeVariables.replace("Wiki Front Page Child Page2 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page2 Title"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page2 Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		selenium.clickAt("//span[@class='header-back-to']/a",
			RuntimeVariables.replace("\u00ab Back to FrontPage"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("xPath=(//div[@class='child-pages']/ul/li/a)[3]",
			RuntimeVariables.replace("Wiki Front Page Child Page3 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page3 Title"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page3 Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		selenium.clickAt("//span[@class='header-back-to']/a",
			RuntimeVariables.replace("\u00ab Back to FrontPage"));
		selenium.waitForPageToLoad("30000");
	}
}