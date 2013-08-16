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
public class TearDownKBAArticleTest extends BaseTestCase {
	public void testTearDownKBAArticle() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.waitForElementPresent("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Knowledge Base (Admin)",
					RuntimeVariables.replace("Knowledge Base (Admin)"));
				selenium.waitForPageToLoad("30000");

				boolean KBArticlesPresent = selenium.isElementPresent(
						"//input[@name='_1_WAR_knowledgebaseportlet_rowIds']");

				if (!KBArticlesPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@name='_1_WAR_knowledgebaseportlet_allRowIds']",
					RuntimeVariables.replace("Select All"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected articles[\\s\\S]$"));

			case 2:
				assertEquals(RuntimeVariables.replace("No articles were found."),
					selenium.getText("//div[@class='portlet-msg-info']"));

			case 100:
				label = -1;
			}
		}
	}
}