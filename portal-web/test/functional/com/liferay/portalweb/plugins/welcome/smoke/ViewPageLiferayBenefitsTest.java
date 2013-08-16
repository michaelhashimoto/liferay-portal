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

package com.liferay.portalweb.plugins.welcome.smoke;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPageLiferayBenefitsTest extends BaseTestCase {
	public void testViewPageLiferayBenefits() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/what-we-do/");
		selenium.clickAt("link=Liferay Benefits",
			RuntimeVariables.replace("Liferay Benefits"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//nav[@id='navigation']",
			RuntimeVariables.replace("Navigation"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/sortable/sortable-min.js')]");
		assertTrue(selenium.isVisible("//a[@title='Go to Liferay']"));
		assertEquals(RuntimeVariables.replace("Welcome to Liferay Portal"),
			selenium.getText("//h2[@class='page-title']/span"));
		assertEquals(RuntimeVariables.replace("What We Do"),
			selenium.getText(
				"xPath=(//li[contains(@class,'lfr-nav-deletable')]/a/span)[1]"));
		assertEquals(RuntimeVariables.replace("Who Is Using Liferay"),
			selenium.getText(
				"xPath=(//li[contains(@class,'lfr-nav-deletable')]/a/span)[2]"));
		assertEquals(RuntimeVariables.replace("Liferay Benefits"),
			selenium.getText(
				"xPath=(//li[contains(@class,'lfr-nav-deletable')]/a/span)[3]"));
		assertEquals(RuntimeVariables.replace(
				"See how Liferay can change the way you do business."),
			selenium.getText(
				"//header[@class='content-head content-head-liferay-portal']/hgroup/h1"));
		assertEquals(RuntimeVariables.replace("Open Source: A Better Way"),
			selenium.getText("//ul[@id='contentNav']/li[1]/a"));
		assertEquals(RuntimeVariables.replace("Ready to Go"),
			selenium.getText("//ul[@id='contentNav']/li[2]/a"));
		assertEquals(RuntimeVariables.replace("Ready to Grow"),
			selenium.getText("//ul[@id='contentNav']/li[3]/a"));
		assertEquals(RuntimeVariables.replace("Approved by IT"),
			selenium.getText("//ul[@id='contentNav']/li[4]/a"));
		assertEquals(RuntimeVariables.replace("Open for Business"),
			selenium.getText("//ul[@id='contentNav']/li[5]/a"));
		assertTrue(selenium.isVisible("//a[@id='marketplace']"));
		assertTrue(selenium.isVisible(
				"//div[@id='social-office']/div/span[@class='footer-logo']"));
		assertEquals(RuntimeVariables.replace("Want Easy Social Collaboration?"),
			selenium.getText("//div[@id='social-office']/div/div/h3"));
		assertEquals(RuntimeVariables.replace("Get Social Office \u25ba"),
			selenium.getText("//div[@id='social-office']/div/div/a"));
		assertTrue(selenium.isVisible(
				"//div[@id='getting-started']/div/span[@class='footer-logo']"));
		assertTrue(selenium.isVisible("//div[@id='getting-started']/div/div/h3"));
		assertTrue(selenium.isVisible("//div[@id='getting-started']/div/div/a"));
		assertTrue(selenium.isVisible(
				"//div[@id='ide']/div/span[@class='footer-logo']"));
		assertTrue(selenium.isVisible("//div[@id='ide']/div/div/h3"));
		assertTrue(selenium.isVisible("//div[@id='ide']/div/div/a"));
	}
}