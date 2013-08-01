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

package com.liferay.portalweb.portal.tags.webcontent.wcwebcontent.searchwcwebcontenttagwcs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWCWebContentTagWCSTest extends BaseTestCase {
	public void testViewWCWebContentTagWCS() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Web Content Display Test Page",
			RuntimeVariables.replace("Web Content Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent Content"),
			selenium.getText("//div[@class='journal-content-article']/p"));
		selenium.clickAt("//img[@alt='Edit Web Content']",
			RuntimeVariables.replace("Edit Web Content"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertTrue(selenium.isVisible("//span[@class='workflow-id']"));
		assertEquals(RuntimeVariables.replace("Version: 1.1"),
			selenium.getText("//span[@class='workflow-version']"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertTrue(selenium.isPartialText("//a[@id='_15_categorizationLink']",
				"Categorization"));
		selenium.clickAt("//a[@id='_15_categorizationLink']",
			RuntimeVariables.replace("Categorization"));
		selenium.waitForVisible("//h1[@class='header-title']/span");
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("\u00ab Back"),
			selenium.getText("//a[@id='_15_TabsBack']"));
		assertTrue(selenium.isVisible("//span[@class='workflow-id']"));
		assertEquals(RuntimeVariables.replace("Version: 1.1"),
			selenium.getText("//span[@class='workflow-version']"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText("//span/button[contains(.,'Permissions')]"));
		assertEquals(RuntimeVariables.replace("View History"),
			selenium.getText("//span/button[contains(.,'View History')]"));
		assertEquals(RuntimeVariables.replace("Categorization"),
			selenium.getText("//div[3]/h3"));
		assertEquals(RuntimeVariables.replace("Type"),
			selenium.getText("//label[@for='type']"));
		assertTrue(selenium.isVisible("//select[@id='_15_type']"));
		assertEquals("General",
			selenium.getSelectedLabel("//select[@id='_15_type']"));
		assertEquals(RuntimeVariables.replace("Tags"),
			selenium.getText("//label[contains(@for,'TagNames')]"));
		assertEquals(RuntimeVariables.replace("tag"),
			selenium.getText(
				"//div[contains(@id,'assetTagsSelector')]/ul/li/span/span[contains(.,'tag')]"));
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//span/button[contains(.,'Add')]"));
		assertEquals(RuntimeVariables.replace("Select"),
			selenium.getText("//span/button[contains(.,'Select')]"));
		assertEquals(RuntimeVariables.replace("Suggestions"),
			selenium.getText("//span/button[contains(.,'Suggestions')]"));
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//span[@class='article-name']"));
		assertTrue(selenium.isPartialText("//a[@id='_15_contentLink']",
				"Content"));
		assertTrue(selenium.isPartialText("//a[@id='_15_abstractLink']",
				"Abstract"));
		assertTrue(selenium.isPartialText("//a[@id='_15_categorizationLink']",
				"Categorization"));
		assertTrue(selenium.isPartialText("//a[@id='_15_scheduleLink']",
				"Schedule"));
		assertTrue(selenium.isPartialText("//a[@id='_15_displayPageLink']",
				"Display Page"));
		assertTrue(selenium.isPartialText("//a[@id='_15_relatedAssetsLink']",
				"Related Assets"));
		assertTrue(selenium.isPartialText("//a[@id='_15_customFieldsLink']",
				"Custom Fields"));
		assertEquals(RuntimeVariables.replace(
				"A new version will be created automatically if this content is modified."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertTrue(selenium.isVisible("//input[@value='Save as Draft']"));
		assertTrue(selenium.isVisible("//input[@value='Publish']"));
		assertTrue(selenium.isVisible("xpath=(//input[@value='Cancel'])[2]"));
	}
}