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

package com.liferay.portalweb.socialofficesite.documents.dmdocument.viewdmdocumentlatestversionsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_AddDMDocumentComment3SiteTest extends BaseTestCase {
	public void testSOUs_AddDMDocumentComment3Site() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		assertTrue(selenium.isVisible("//input[@class='search-input']"));
		selenium.type("//input[@class='search-input']",
			RuntimeVariables.replace("Open"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Documents"),
			selenium.getText("//nav/ul/li[contains(.,'Documents')]/a/span"));
		selenium.clickAt("//nav/ul/li[contains(.,'Documents')]/a/span",
			RuntimeVariables.replace("Documents"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document Title Edit2"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DM Document Title Edit2"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Be the first."),
			selenium.getText("//fieldset/div/a"));
		selenium.clickAt("//fieldset/div/a",
			RuntimeVariables.replace("Be the first."));
		selenium.waitForVisible("//textarea[@name='_20_postReplyBody0']");
		selenium.type("//textarea[@name='_20_postReplyBody0']",
			RuntimeVariables.replace("DM Document Comment3"));
		selenium.clickAt("//input[@value='Reply']",
			RuntimeVariables.replace("Reply"));
		selenium.waitForText("xPath=(//div[@class='lfr-discussion-message'])[1]",
			"DM Document Comment3");
		assertEquals(RuntimeVariables.replace("DM Document Comment2 Edit"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[2]"));
		assertEquals(RuntimeVariables.replace("DM Document Comment3"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[1]"));
		assertEquals(RuntimeVariables.replace("DM Document Comment1"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[3]"));
	}
}