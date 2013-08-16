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

package com.liferay.portalweb.kaleo.wiki.wikipage.viewwikipageassignedtome;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownWorkflowConfigurationTest extends BaseTestCase {
	public void testTearDownWorkflowConfiguration() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Workflow", RuntimeVariables.replace("Workflow"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Default Configuration",
			RuntimeVariables.replace("Default Configuration"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_151_workflowDefinitionName@com.liferay.portal.model.LayoutRevision']",
			RuntimeVariables.replace("No Workflow"));
		selenium.select("//select[@id='_151_workflowDefinitionName@com.liferay.portal.model.User']",
			RuntimeVariables.replace("No Workflow"));
		selenium.select("//select[@id='_151_workflowDefinitionName@com.liferay.portlet.blogs.model.BlogsEntry']",
			RuntimeVariables.replace("No Workflow"));
		selenium.select("//select[@id='_151_workflowDefinitionName@com.liferay.portlet.journal.model.JournalArticle']",
			RuntimeVariables.replace("No Workflow"));
		selenium.select("//select[@id='_151_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBDiscussion']",
			RuntimeVariables.replace("No Workflow"));
		selenium.select("//select[@id='_151_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBMessage']",
			RuntimeVariables.replace("No Workflow"));
		selenium.select("//select[@id='_151_workflowDefinitionName@com.liferay.portlet.wiki.model.WikiPage']",
			RuntimeVariables.replace("No Workflow"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_151_workflowDefinitionName@com.liferay.portal.model.LayoutRevision']"));
		assertEquals("No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_151_workflowDefinitionName@com.liferay.portal.model.User']"));
		assertEquals("No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_151_workflowDefinitionName@com.liferay.portlet.blogs.model.BlogsEntry']"));
		assertEquals("No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_151_workflowDefinitionName@com.liferay.portlet.journal.model.JournalArticle']"));
		assertEquals("No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_151_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBDiscussion']"));
		assertEquals("No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_151_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBMessage']"));
		assertEquals("No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_151_workflowDefinitionName@com.liferay.portlet.wiki.model.WikiPage']"));
		selenium.clickAt("link=Workflow Configuration",
			RuntimeVariables.replace("Workflow Configuration"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_152_workflowDefinitionName@com.liferay.portal.model.LayoutRevision']",
			RuntimeVariables.replace("Default: No Workflow"));
		selenium.select("//select[@id='_152_workflowDefinitionName@com.liferay.portlet.blogs.model.BlogsEntry']",
			RuntimeVariables.replace("Default: No Workflow"));
		selenium.select("//select[@id='_152_workflowDefinitionName@com.liferay.portlet.journal.model.JournalArticle']",
			RuntimeVariables.replace("Default: No Workflow"));
		selenium.select("//select[@id='_152_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBDiscussion']",
			RuntimeVariables.replace("Default: No Workflow"));
		selenium.select("//select[@id='_152_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBMessage']",
			RuntimeVariables.replace("Default: No Workflow"));
		selenium.select("//select[@id='_152_workflowDefinitionName@com.liferay.portlet.wiki.model.WikiPage']",
			RuntimeVariables.replace("Default: No Workflow"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("Default: No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_152_workflowDefinitionName@com.liferay.portal.model.LayoutRevision']"));
		assertEquals("Default: No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_152_workflowDefinitionName@com.liferay.portlet.blogs.model.BlogsEntry']"));
		assertEquals("Default: No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_152_workflowDefinitionName@com.liferay.portlet.journal.model.JournalArticle']"));
		assertEquals("Default: No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_152_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBDiscussion']"));
		assertEquals("Default: No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_152_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBMessage']"));
		assertEquals("Default: No Workflow",
			selenium.getSelectedLabel(
				"//select[@id='_152_workflowDefinitionName@com.liferay.portlet.wiki.model.WikiPage']"));
	}
}