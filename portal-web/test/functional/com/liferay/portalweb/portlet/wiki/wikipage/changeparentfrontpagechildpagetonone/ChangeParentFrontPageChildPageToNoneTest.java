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

package com.liferay.portalweb.portlet.wiki.wikipage.changeparentfrontpagechildpagetonone;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ChangeParentFrontPageChildPageToNoneTest extends BaseTestCase {
	public void testChangeParentFrontPageChildPageToNone()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[@class='child-pages']/ul/li/a",
			RuntimeVariables.replace("Wiki Front Page Child Page Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("\u00ab Back to FrontPage"),
			selenium.getText("//span[@class='header-back-to']/a"));
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		assertEquals(RuntimeVariables.replace("Details"),
			selenium.getText("//div[3]/span[2]/a/span"));
		selenium.clickAt("//div[3]/span[2]/a/span",
			RuntimeVariables.replace("Details"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Move"),
			selenium.getText("//tr[9]/td/ul/li[3]/a/span"));
		selenium.clickAt("//tr[9]/td/ul/li[3]/a/span",
			RuntimeVariables.replace("Move"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Change Parent",
			RuntimeVariables.replace("Change Parent"));
		selenium.waitForVisible("//select[@id='_36_newParentTitle']");
		selenium.select("//select[@id='_36_newParentTitle']",
			RuntimeVariables.replace("None"));
		selenium.clickAt("//input[@value='Change Parent']",
			RuntimeVariables.replace("Change Parent"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Wiki Front Page Child Page Title"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=All Pages", RuntimeVariables.replace("All Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page Title"),
			selenium.getText("//tr[4]/td[1]/a"));
		selenium.clickAt("//tr[4]/td[1]/a",
			RuntimeVariables.replace("Wiki Front Page Child Page Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertFalse(selenium.isTextPresent("\u00ab Back to FrontPage"));
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Child Page Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
	}
}