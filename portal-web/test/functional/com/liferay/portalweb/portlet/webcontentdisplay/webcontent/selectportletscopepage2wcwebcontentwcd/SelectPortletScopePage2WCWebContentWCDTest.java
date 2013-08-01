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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.selectportletscopepage2wcwebcontentwcd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SelectPortletScopePage2WCWebContentWCDTest extends BaseTestCase {
	public void testSelectPortletScopePage2WCWebContentWCD()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Web Content Display Test Page3");
		selenium.clickAt("link=Web Content Display Test Page3",
			RuntimeVariables.replace("Web Content Display Test Page3"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Select existing web content or add some web content to be displayed in this portlet."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.clickAt("//img[@alt='Select Web Content']",
			RuntimeVariables.replace("Select Web Content"));
		selenium.waitForVisible("//iframe");
		selenium.selectFrame("//iframe");
		selenium.waitForVisible("link=WC WebContent Title");
		selenium.clickAt("link=WC WebContent Title",
			RuntimeVariables.replace("WC WebContent Title"));
		selenium.waitForPartialText("//form[@id='_86_fm1']/div[1]/span[2]",
			"Displaying Content: WC WebContent Title");
		assertTrue(selenium.isPartialText(
				"//form[@id='_86_fm1']/div[1]/span[2]",
				"Displaying Content: WC WebContent Title"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.selectFrame("relative=top");
	}
}