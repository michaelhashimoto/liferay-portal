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

package com.liferay.portalweb.portal.tags.webcontent.wcwebcontent.searchwcwebcontenttagwcs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchWCWebContentTagWCSTest extends BaseTestCase {
	public void testSearchWCWebContentTagWCS() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Web Content Search Test Page",
			RuntimeVariables.replace("Web Content Search Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_77_keywords']",
			RuntimeVariables.replace("tag"));
		selenium.clickAt("//input[@type='image']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//div[@class='search-results']",
				"Results 1 - 1 of 1."));
		assertEquals(RuntimeVariables.replace("1."),
			selenium.getText("//tr[contains(.,'WC WebContent Title')]/td[1]"));
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//tr[contains(.,'WC WebContent Title')]/td[2]"));
		assertTrue(selenium.isPartialText(
				"//tr[contains(.,'WC WebContent Title')]/td[3]",
				"WC WebContent Content"));
		assertTrue(selenium.isPartialText(
				"//tr[contains(.,'WC WebContent Title')]/td[3]",
				"http://localhost:8080/web/guest/web-content-display-test-page"));
		assertTrue(selenium.isPartialText("//div[@class='search-results']",
				"Showing 1 result."));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Web Content Search Test Page",
			RuntimeVariables.replace("Web Content Search Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_77_keywords']",
			RuntimeVariables.replace("tag1"));
		selenium.clickAt("//input[@type='image']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//div[@class='search-results']",
				"Results 0 - 0 of 0."));
		assertFalse(selenium.isTextPresent("Results 1 - 1 of 1."));
		assertFalse(selenium.isTextPresent("WC WebContent Title"));
		assertFalse(selenium.isTextPresent("WC WebContent Content"));
		assertFalse(selenium.isTextPresent(
				"http://localhost:8080/web/guest/web-content-display-test-page"));
		assertFalse(selenium.isTextPresent("Showing 1 result."));
		assertEquals(RuntimeVariables.replace(
				"No pages were found that matched the keywords: tag1."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}