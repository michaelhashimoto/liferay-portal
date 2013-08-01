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

package com.liferay.portalweb.plugins.knowledgebase.knowledgebaseadmin.kbaarticle.addkbaarticle;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownKBAArticleTest extends BaseTestCase {
	public void testTearDownKBAArticle() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
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
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Knowledge Base (Admin)",
					RuntimeVariables.replace("Knowledge Base (Admin)"));
				selenium.waitForPageToLoad("30000");

				boolean KBArticlePresent = selenium.isElementPresent(
						"//input[@name='_1_WAR_knowledgebaseportlet_rowIds']");

				if (!KBArticlePresent) {
					label = 2;

					continue;
				}

				assertFalse(selenium.isChecked(
						"//input[@name='_1_WAR_knowledgebaseportlet_allRowIds']"));
				selenium.clickAt("//input[@name='_1_WAR_knowledgebaseportlet_allRowIds']",
					RuntimeVariables.replace("Select All"));
				assertTrue(selenium.isChecked(
						"//input[@name='_1_WAR_knowledgebaseportlet_allRowIds']"));
				selenium.waitForVisible(
					"//tr[contains(@class,'results-row last selected')]");
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected articles[\\s\\S]$"));
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 2:
				assertEquals(RuntimeVariables.replace("No articles were found."),
					selenium.getText("//div[@class='portlet-msg-info']"));

			case 100:
				label = -1;
			}
		}
	}
}