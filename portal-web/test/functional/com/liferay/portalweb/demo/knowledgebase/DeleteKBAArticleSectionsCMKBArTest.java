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
public class DeleteKBAArticleSectionsCMKBArTest extends BaseTestCase {
	public void testDeleteKBAArticleSectionsCMKBAr() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Knowledge Base Article Test Page");
		selenium.clickAt("link=Knowledge Base Article Test Page",
			RuntimeVariables.replace("Knowledge Base Article Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Knowledge Base Article 1"),
			selenium.getText("//div[@class='kb-title']"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//div[@class='kb-article-icons']/table/tbody/tr/td[4]/span/a"));
		selenium.clickAt("//div[@class='kb-article-icons']/table/tbody/tr/td[4]/span/a",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete this[\\s\\S]$"));
		assertEquals(RuntimeVariables.replace(
				"Your request failed to complete."),
			selenium.getText("xPath=(//div[@class='portlet-msg-error'])[1]"));
		assertEquals(RuntimeVariables.replace(
				"The selected article no longer exists."),
			selenium.getText("xPath=(//div[@class='portlet-msg-error'])[2]"));
	}
}