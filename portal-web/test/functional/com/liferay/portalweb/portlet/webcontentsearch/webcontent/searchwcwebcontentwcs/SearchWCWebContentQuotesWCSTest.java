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

package com.liferay.portalweb.portlet.webcontentsearch.webcontent.searchwcwebcontentwcs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchWCWebContentQuotesWCSTest extends BaseTestCase {
	public void testSearchWCWebContentQuotesWCS() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Web Content Search Test Page",
			RuntimeVariables.replace("Web Content Search Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_77_keywords']",
			RuntimeVariables.replace("\"WC WebContent Title\""));
		selenium.clickAt("//input[@type='image']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText(
				"//td[@id='_77_ocerSearchContainer_col-name_row-1']"));
		assertTrue(selenium.isPartialText(
				"//td[@id='_77_ocerSearchContainer_col-name_row-1']",
				"WC WebContent"));
		assertTrue(selenium.isPartialText(
				"//td[@id='_77_ocerSearchContainer_col-name_row-1']", "Content"));
		assertTrue(selenium.isTextPresent("WC WebContent Content"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Web Content Search Test Page",
			RuntimeVariables.replace("Web Content Search Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_77_keywords']",
			RuntimeVariables.replace("\"WC1 WebContent1 Title1\""));
		selenium.clickAt("//input[@type='image']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("WC WebContent Title"));
		assertFalse(selenium.isTextPresent("WC WebContent Content"));
	}
}