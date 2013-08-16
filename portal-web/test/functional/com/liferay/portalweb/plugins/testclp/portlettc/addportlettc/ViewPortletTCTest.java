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

package com.liferay.portalweb.plugins.testclp.portlettc.addportlettc;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletTCTest extends BaseTestCase {
	public void testViewPortletTC() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Test CLP Test Page",
			RuntimeVariables.replace("Test CLP Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//section"));
		assertTrue(selenium.isPartialText(
				"//div[@class='portlet-content']/div", "There are 1 statuses."));
		assertTrue(selenium.isPartialText(
				"//div[@class='portlet-content']/div",
				"NoSuchStatusException was properly caught."));
		assertEquals(RuntimeVariables.replace("Status ID"),
			selenium.getText("//tr[1]/td[1]/strong"));
		assertEquals(RuntimeVariables.replace("User ID"),
			selenium.getText("//tr[1]/td[2]/strong"));
		assertEquals(RuntimeVariables.replace("Modified Date"),
			selenium.getText("//tr[1]/td[3]/strong"));
		assertEquals(RuntimeVariables.replace("Online"),
			selenium.getText("//tr[1]/td[4]/strong"));
		assertEquals(RuntimeVariables.replace("Awake"),
			selenium.getText("//tr[1]/td[5]/strong"));
		assertEquals(RuntimeVariables.replace("Active Panel ID"),
			selenium.getText("//tr[1]/td[6]/strong"));
		assertEquals(RuntimeVariables.replace("Message"),
			selenium.getText("//tr[1]/td[7]/strong"));
		assertEquals(RuntimeVariables.replace("Play Sound"),
			selenium.getText("//tr[1]/td[8]/strong"));
		assertTrue(selenium.isVisible("//tr[2]/td[1]"));
		assertTrue(selenium.isVisible("//tr[2]/td[2]"));
		assertTrue(selenium.isVisible("//tr[2]/td[3]"));
		assertEquals(RuntimeVariables.replace("true"),
			selenium.getText("//tr[2]/td[4]"));
		assertEquals(RuntimeVariables.replace("true"),
			selenium.getText("//tr[2]/td[5]"));
		assertTrue(selenium.isVisible("//tr[2]/td[6]"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[2]/td[7]"));
		assertEquals(RuntimeVariables.replace("true"),
			selenium.getText("//tr[2]/td[8]"));
	}
}