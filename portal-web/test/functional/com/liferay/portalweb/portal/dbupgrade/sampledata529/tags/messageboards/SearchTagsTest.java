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

package com.liferay.portalweb.portal.dbupgrade.sampledata529.tags.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchTagsTest extends BaseTestCase {
	public void testSearchTags() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Communities",
			RuntimeVariables.replace("Communities"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Tags Message Board Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td[1]/a",
			RuntimeVariables.replace("Public Pages - Live (1)"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace("Message Boards Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_19_keywords1']",
			RuntimeVariables.replace("selenium1"));
		selenium.clickAt("//input[@value='Search Categories']",
			RuntimeVariables.replace("Search Categories"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Message1 Tag1 Test1"));
		assertTrue(selenium.isElementNotPresent("link=Message2 Tag2 Test2"));
		assertTrue(selenium.isElementNotPresent("link=Message3 Tag3 Test3"));
		assertTrue(selenium.isElementNotPresent("link=MessageA TagA TestA"));
		assertTrue(selenium.isElementNotPresent("link=MessageB TagB TestB"));
		assertTrue(selenium.isElementNotPresent("link=MessageC TagC TestC"));
		selenium.waitForElementPresent("link=Message Boards Page");
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace("Message Boards Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_19_keywords1']",
			RuntimeVariables.replace("selenium2"));
		selenium.clickAt("//input[@value='Search Categories']",
			RuntimeVariables.replace("Search Categories"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Message2 Tag2 Test2"));
		assertTrue(selenium.isElementNotPresent("link=Message1 Tag1 Test1"));
		assertTrue(selenium.isElementNotPresent("link=Message3 Tag3 Test3"));
		assertTrue(selenium.isElementNotPresent("link=MessageA TagA TestA"));
		assertTrue(selenium.isElementNotPresent("link=MessageB TagB TestB"));
		assertTrue(selenium.isElementNotPresent("link=MessageC TagC TestC"));
		selenium.waitForElementPresent("link=Message Boards Page");
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace("Message Boards Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_19_keywords1']",
			RuntimeVariables.replace("selenium3"));
		selenium.clickAt("//input[@value='Search Categories']",
			RuntimeVariables.replace("Search Categories"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Message3 Tag3 Test3"));
		assertTrue(selenium.isElementNotPresent("link=Message1 Tag1 Test1"));
		assertTrue(selenium.isElementNotPresent("link=Message2 Tag2 Test2"));
		assertTrue(selenium.isElementNotPresent("link=MessageA TagA TestA"));
		assertTrue(selenium.isElementNotPresent("link=MessageB TagB TestB"));
		assertTrue(selenium.isElementNotPresent("link=MessageC TagC TestC"));
		selenium.waitForElementPresent("link=Message Boards Page");
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace("Message Boards Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_19_keywords1']",
			RuntimeVariables.replace("selenium"));
		selenium.clickAt("//input[@value='Search Categories']",
			RuntimeVariables.replace("Search Categories"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=MessageA TagA TestA"));
		assertTrue(selenium.isElementPresent("link=MessageB TagB TestB"));
		assertTrue(selenium.isElementPresent("link=MessageC TagC TestC"));
		assertTrue(selenium.isElementNotPresent("link=Message1 Tag1 Test1"));
		assertTrue(selenium.isElementNotPresent("link=Message2 Tag2 Test2"));
		assertTrue(selenium.isElementNotPresent("link=Message3 Tag3 Test3"));
	}
}