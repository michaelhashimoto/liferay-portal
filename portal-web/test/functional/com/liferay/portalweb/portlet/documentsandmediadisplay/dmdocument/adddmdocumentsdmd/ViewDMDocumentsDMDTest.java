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

package com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmdocumentsdmd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDMDocumentsDMDTest extends BaseTestCase {
	public void testViewDMDocumentsDMD() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Display Test Page",
			RuntimeVariables.replace("Documents and Media Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Name"),
			selenium.getText("//tr[1]/th[2]"));
		assertEquals(RuntimeVariables.replace("Size"),
			selenium.getText("//tr[1]/th[3]"));
		assertTrue(selenium.isVisible("//tr[3]/td[1]/input"));
		assertTrue(selenium.isVisible(
				"xPath=(//span[@class='entry-thumbnail']/img)[1]"));
		assertEquals(RuntimeVariables.replace("DM Document1 Title"),
			selenium.getText("xPath=(//span[@class='entry-title'])[1]"));
		assertEquals(RuntimeVariables.replace("0.3k"),
			selenium.getText("//tr[3]/td[3]/a"));
		assertTrue(selenium.isVisible("//tr[4]/td[1]/input"));
		assertTrue(selenium.isVisible(
				"xPath=(//span[@class='entry-thumbnail']/img)[2]"));
		assertEquals(RuntimeVariables.replace("DM Document2 Title"),
			selenium.getText("xPath=(//span[@class='entry-title'])[2]"));
		assertEquals(RuntimeVariables.replace("0.5k"),
			selenium.getText("//tr[4]/td[3]/a"));
		assertTrue(selenium.isVisible("//tr[5]/td[1]/input"));
		assertTrue(selenium.isVisible(
				"xPath=(//span[@class='entry-thumbnail']/img)[3]"));
		assertEquals(RuntimeVariables.replace("DM Document3 Title"),
			selenium.getText("xPath=(//span[@class='entry-title'])[3]"));
		assertEquals(RuntimeVariables.replace("0.8k"),
			selenium.getText("//tr[5]/td[3]/a"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Display Test Page",
			RuntimeVariables.replace("Documents and Media Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document1 Title"),
			selenium.getText("xPath=(//span[@class='entry-title'])[1]"));
		selenium.clickAt("xPath=(//span[@class='entry-title'])[1]",
			RuntimeVariables.replace("DM Document1 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document1 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("DM Document1 Title"),
			selenium.getText("//h2[@class='document-title']"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("Download (0.3k)"),
			selenium.getText("//span[@class='download-document']/span/a/span"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Display Test Page",
			RuntimeVariables.replace("Documents and Media Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document2 Title"),
			selenium.getText("xPath=(//span[@class='entry-title'])[2]"));
		selenium.clickAt("xPath=(//span[@class='entry-title'])[2]",
			RuntimeVariables.replace("DM Document2 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document2 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("DM Document2 Title"),
			selenium.getText("//h2[@class='document-title']"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("Download (0.5k)"),
			selenium.getText("//span[@class='download-document']/span/a/span"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Display Test Page",
			RuntimeVariables.replace("Documents and Media Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document3 Title"),
			selenium.getText("xPath=(//span[@class='entry-title'])[3]"));
		selenium.clickAt("xPath=(//span[@class='entry-title'])[3]",
			RuntimeVariables.replace("DM Document3 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document3 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("DM Document3 Title"),
			selenium.getText("//h2[@class='document-title']"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("Download (0.8k)"),
			selenium.getText("//span[@class='download-document']/span/a/span"));
	}
}