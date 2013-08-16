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

package com.liferay.portalweb.plugins.knowledgebase.knowledgebasesearch.kbaarticle.searchkbaarticlekbsr;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchKBAArticleQuotesKBSrTest extends BaseTestCase {
	public void testSearchKBAArticleQuotesKBSr() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Knowledge Base Search Test Page",
			RuntimeVariables.replace("Knowledge Base Display Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@title='Search Articles']",
			RuntimeVariables.replace("\"Knowledge Base Admin Article Title\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Title"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[1]/span"));
		assertEquals(RuntimeVariables.replace("Author"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[2]/span"));
		assertEquals(RuntimeVariables.replace("Create Date"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[3]/span"));
		assertEquals(RuntimeVariables.replace("Modified Date"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[4]/span"));
		assertEquals(RuntimeVariables.replace(
				"Knowledge Base Admin Article Title"),
			selenium.getText("//tr[contains(@class,'results-row last')]/td[1]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//tr[contains(@class,'results-row last')]/td[2]"));
		assertTrue(selenium.isVisible(
				"//tr[contains(@class,'results-row last')]/td[3]"));
		assertTrue(selenium.isVisible(
				"//tr[contains(@class,'results-row last')]/td[4]"));
		assertEquals(RuntimeVariables.replace("0 Views"),
			selenium.getText("//tr[contains(@class,'results-row last')]/td[5]"));
		assertEquals(RuntimeVariables.replace("Showing 1 result."),
			selenium.getText("//div[@class='search-results']"));
	}
}