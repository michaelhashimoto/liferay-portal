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

package com.liferay.portalweb.socialofficehome.sites.site.searchsitesdirectory;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSitesSite3TypePrivateTest extends BaseTestCase {
	public void testAddSitesSite3TypePrivate() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//button[contains(.,'Add Site')]/span[2]");
		assertEquals(RuntimeVariables.replace("Add Site"),
			selenium.getText("//button[contains(.,'Add Site')]/span[2]"));
		selenium.clickAt("//button[contains(.,'Add Site')]/span[2]",
			RuntimeVariables.replace("Add Site"));
		selenium.waitForVisible("//label[contains(@for,'_5_WAR_soportlet')]");
		assertTrue(selenium.isVisible(
				"//label[contains(@for,'_5_WAR_soportlet')]"));
		assertTrue(selenium.isVisible("//input[@id='_5_WAR_soportlet_name']"));
		selenium.type("//input[@id='_5_WAR_soportlet_name']",
			RuntimeVariables.replace("Private Site3 Name"));
		assertTrue(selenium.isVisible(
				"//textarea[@id='_5_WAR_soportlet_description']"));
		selenium.type("//textarea[@id='_5_WAR_soportlet_description']",
			RuntimeVariables.replace("Private Site3 Description"));
		assertEquals("Next", selenium.getValue("//input[@value='Next']"));
		selenium.clickAt("//input[@value='Next']",
			RuntimeVariables.replace("Next"));
		selenium.waitForVisible(
			"//select[@id='_5_WAR_soportlet_layoutSetPrototypeSelect']");
		assertTrue(selenium.isVisible(
				"//select[@id='_5_WAR_soportlet_layoutSetPrototypeSelect']"));
		selenium.select("//select[@id='_5_WAR_soportlet_layoutSetPrototypeSelect']",
			RuntimeVariables.replace("Default Social Office Site"));
		assertTrue(selenium.isVisible(
				"//select[@id='_5_WAR_soportlet_typeSelect']"));
		selenium.select("//select[@id='_5_WAR_soportlet_typeSelect']",
			RuntimeVariables.replace("Private"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Home')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Calendar')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Documents')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Forums')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Blog')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Wiki')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Members')]/input"));
		assertEquals(RuntimeVariables.replace(
				"Private sites are not listed, pages are private, and users must be invited to collaborate."),
			selenium.getText("//div[@class='message']"));
		assertEquals("Save", selenium.getValue("//input[@value='Save']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//span[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//span[@class='portlet-msg-success']"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Private Site3 Name"),
			selenium.getText(
				"xPath=(//li[contains(@class, 'social-office-enabled')]/span[2]/a)[3]"));
	}
}