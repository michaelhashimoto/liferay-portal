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

package com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentversion2resubmitted;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWebContentVersion2ResubmittedTest extends BaseTestCase {
	public void testViewWebContentVersion2Resubmitted()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Web Content Display Test Page",
			RuntimeVariables.replace("Web Content Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC Web Content Content"),
			selenium.getText("//div[@class='journal-content-article']"));
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
		selenium.clickAt("link=My Workflow Tasks",
			RuntimeVariables.replace("My Workflow Tasks"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Pending", RuntimeVariables.replace("Pending"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to you."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText(
				"//tr[contains(.,'WC Web Content Title Edit')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("WC Web Content Title Edit"),
			selenium.getText(
				"//tr[contains(.,'WC Web Content Title Edit')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText(
				"//tr[contains(.,'WC Web Content Title Edit')]/td[3]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'WC Web Content Title Edit')]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText(
				"//tr[contains(.,'WC Web Content Title Edit')]/td[5]/a"));
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Update"),
			selenium.getText("xPath=(//a[.='Update'])[1]"));
		assertEquals(RuntimeVariables.replace("WC Web Content Title Edit"),
			selenium.getText("xPath=(//a[.='WC Web Content Title Edit'])[1]"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//tr[3]/td[3]/a"));
		assertTrue(selenium.isVisible("//tr[3]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//tr[3]/td[5]/a"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("xPath=(//a[.='Review'])[1]"));
		assertEquals(RuntimeVariables.replace("WC Web Content Title Edit"),
			selenium.getText("xPath=(//a[.='WC Web Content Title Edit'])[2]"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//tr[4]/td[3]/a"));
		assertTrue(selenium.isVisible("//tr[4]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//tr[4]/td[5]/a"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("xPath=(//a[.='Review'])[2]"));
		assertEquals(RuntimeVariables.replace("WC Web Content Title"),
			selenium.getText("xPath=(//a[.='WC Web Content Title'])"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//tr[5]/td[3]/a"));
		assertTrue(selenium.isVisible("//tr[5]/td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//tr[5]/td[5]/a"));
	}
}