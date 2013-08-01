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

package com.liferay.portalweb.demo.knowledgebase;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletKBSSectionsASTest extends BaseTestCase {
	public void testConfigurePortletKBSSectionsAS() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Knowledge Base Section Test Page");
		selenium.clickAt("link=Knowledge Base Section Test Page",
			RuntimeVariables.replace("Knowledge Base Section Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace(
				"General \n No articles were found."),
			selenium.getText("//section/div/div/div[@class='portlet-body']"));
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a/span",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForVisible("//select[@id='_86_kbArticlesSections']");
		selenium.addSelection("//select[@id='_86_kbArticlesSections']",
			RuntimeVariables.replace("Application Server"));
		assertEquals("Application Server",
			selenium.getSelectedLabel("//select[@id='_86_kbArticlesSections']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.waitForVisible("//div[@class='kb-articles-sections-title']");
		selenium.waitForVisible("//div[@class='kb-articles']/div/span/a/span");
		assertEquals(RuntimeVariables.replace("Application Server"),
			selenium.getText("//div[@class='kb-articles-sections-title']"));
		assertEquals(RuntimeVariables.replace("The third"),
			selenium.getText("//div[@class='kb-articles']/div/span/a/span"));
	}
}