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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.searchwcwebcontentwcd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchWCWebContentQuotesWCDTest extends BaseTestCase {
	public void testSearchWCWebContentQuotesWCD() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Web Content Display Test Page",
			RuntimeVariables.replace("Web Content Display Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Configuration",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForVisible("//input[@name='_86_keywords']");
		selenium.type("//input[@name='_86_keywords']",
			RuntimeVariables.replace("\"WC WebContent Title\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//td[contains(.,'WC WebContent Title')]/a"));
		selenium.type("//input[@name='_86_keywords']",
			RuntimeVariables.replace("\"WC1 WebContent1 Title1\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("No Web Content was found."),
			selenium.getText("xPath=(//div[@class='portlet-msg-info'])[2]"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'WC WebContent Title')]/a"));
	}
}