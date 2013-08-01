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

package com.liferay.portalweb.portlet.sitemap.portlet.viewportletsitemap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletSiteMapTest extends BaseTestCase {
	public void testViewPortletSiteMap() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Site Map Test Page",
			RuntimeVariables.replace("Site Map Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Welcome"),
			selenium.getText("xPath=(//div[@class='portlet-body']/ul/li/a)[1]"));
		selenium.clickAt("xPath=(//div[@class='portlet-body']/ul/li/a)[1]",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Sign In"),
			selenium.getText("xPath=(//h1[@class='portlet-title'])[1]"));
		assertEquals(RuntimeVariables.replace("Hello World"),
			selenium.getText("xPath=(//h1[@class='portlet-title'])[2]"));
		assertTrue(selenium.isVisible("xPath=(//section[@class='portlet'])[1]"));
		assertTrue(selenium.isVisible("xPath=(//section[@class='portlet'])[2]"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Site Map Test Page",
			RuntimeVariables.replace("Site Map Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Site Map Test Page"),
			selenium.getText("xPath=(//div[@class='portlet-body']/ul/li/a)[2]"));
		selenium.clickAt("xPath=(//div[@class='portlet-body']/ul/li/a)[2]",
			RuntimeVariables.replace("Site Map Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Site Map"),
			selenium.getText("//h1[@class='portlet-title']"));
		assertTrue(selenium.isVisible("//section[@class='portlet']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Site Map Test Page",
			RuntimeVariables.replace("Site Map Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Site Map Test Child Page"),
			selenium.getText("//div[@class='portlet-body']/ul/li/ul/li/a"));
		selenium.clickAt("//div[@class='portlet-body']/ul/li/ul/li/a",
			RuntimeVariables.replace("Site Map Test Child Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent("//section[@class='portlet']"));
	}
}