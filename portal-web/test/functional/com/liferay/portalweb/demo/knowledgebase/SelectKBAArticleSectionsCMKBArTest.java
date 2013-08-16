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
public class SelectKBAArticleSectionsCMKBArTest extends BaseTestCase {
	public void testSelectKBAArticleSectionsCMKBAr() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Knowledge Base Article Test Page");
		selenium.clickAt("link=Knowledge Base Article Test Page",
			RuntimeVariables.replace("Knowledge Base Article Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Please configure this portlet to make it visible to all users."),
			selenium.getText(
				"//div[@class='portlet-configuration portlet-msg-info']/a"));
		selenium.clickAt("//div[@class='portlet-configuration portlet-msg-info']/a",
			RuntimeVariables.replace(
				"Please configure this portlet to make it visible to all users."));
		selenium.waitForVisible("//div[@class='kb-edit-link']/a");
		assertEquals(RuntimeVariables.replace("Select Article \u00bb"),
			selenium.getText("//div[@class='kb-edit-link']/a"));
		selenium.clickAt("//div[@class='kb-edit-link']/a",
			RuntimeVariables.replace("Select Article \u00bb"));
		selenium.waitForPopUp("selectConfigurationKBArticle",
			RuntimeVariables.replace("30000"));
		selenium.selectWindow("name=selectConfigurationKBArticle");
		selenium.waitForVisible("//tr[5]/td[1]/a");
		assertEquals(RuntimeVariables.replace("Knowledge Base Article 1"),
			selenium.getText("//tr[5]/td[1]/a"));
		selenium.click("//tr[5]/td[7]/span/span/input[@value='Choose']");
		selenium.selectWindow("null");
		selenium.waitForText("//div[@id='_86_configurationKBArticle']",
			"Knowledge Base Article 1");
		assertEquals(RuntimeVariables.replace("Knowledge Base Article 1"),
			selenium.getText("//div[@id='_86_configurationKBArticle']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.waitForVisible("//div[@class='kb-title']");
		selenium.waitForVisible("//div[@class='kb-entity-body']/p");
		assertEquals(RuntimeVariables.replace("Knowledge Base Article 1"),
			selenium.getText("//div[@class='kb-title']"));
		assertEquals(RuntimeVariables.replace(
				"This is the content of Article 1"),
			selenium.getText("//div[@class='kb-entity-body']/p"));
	}
}