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
public class ViewPageWhoIsUsingLiferayTest extends BaseTestCase {
	public void testViewPageWhoIsUsingLiferay() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/what-we-do/");
		selenium.clickAt("link=Who Is Using Liferay",
			RuntimeVariables.replace("Who Is Using Liferay"));
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
				"Liferay helps you build feature-rich, easy-to-use web applications quickly."),
			selenium.getText(
				"//header[@class='content-head content-head-liferay-portal']/hgroup/h1"));
		assertEquals(RuntimeVariables.replace(
				"Here are some of our customers from around the globe:"),
			selenium.getText(
				"//header[@class='content-head content-head-liferay-portal']/p"));
		assertEquals(RuntimeVariables.replace("Rolex"),
			selenium.getText("//ul[@class='left']/li[1]/span"));
		assertEquals(RuntimeVariables.replace("Bugaboo"),
			selenium.getText("//ul[@class='left']/li[2]/span"));
		assertEquals(RuntimeVariables.replace("Deluxe Corporation"),
			selenium.getText("//ul[@class='left']/li[3]/span"));
		assertEquals(RuntimeVariables.replace("Domino's Pizza"),
			selenium.getText("//ul[@class='left']/li[4]/span"));
		assertEquals(RuntimeVariables.replace("BASF"),
			selenium.getText("//ul[@class='left']/li[5]/span"));
		assertEquals(RuntimeVariables.replace("Honda"),
			selenium.getText("//ul[@class='right']/li[1]/span"));
		assertEquals(RuntimeVariables.replace("GE Capital"),
			selenium.getText("//ul[@class='right']/li[2]/span"));
		assertEquals(RuntimeVariables.replace("Sesame Street"),
			selenium.getText("//ul[@class='right']/li[3]/span"));
		assertEquals(RuntimeVariables.replace("China Mobile"),
			selenium.getText("//ul[@class='right']/li[4]/span"));
		assertEquals(RuntimeVariables.replace("York University"),
			selenium.getText("//ul[@class='right']/li[5]/span"));
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