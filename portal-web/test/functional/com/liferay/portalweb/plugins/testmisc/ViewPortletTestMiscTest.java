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

package com.liferay.portalweb.plugins.testmisc;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletTestMiscTest extends BaseTestCase {
	public void testViewPortletTestMisc() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Test Misc Page",
			RuntimeVariables.replace("Test Misc Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Portlet Request"),
			selenium.getText("//div/div/h3[1]"));
		assertEquals(RuntimeVariables.replace("Attribute Sharing"),
			selenium.getText("//p[1]/a[1]"));
		assertEquals(RuntimeVariables.replace("Remote User"),
			selenium.getText("//p[1]/a[2]"));
		assertEquals(RuntimeVariables.replace(
				"Portlet Response (ActionResponse, Normal State)"),
			selenium.getText("//h3[2]"));
		assertEquals(RuntimeVariables.replace("Download File"),
			selenium.getText("//p[2]/a"));
		assertEquals(RuntimeVariables.replace(
				"Portlet Response (ActionResponse, Exclusive State)"),
			selenium.getText("//h3[3]"));
		assertEquals(RuntimeVariables.replace("Download File"),
			selenium.getText("//p[3]/a"));
		assertEquals(RuntimeVariables.replace(
				"Portlet Response (ResourceResponse)"),
			selenium.getText("//h3[4]"));
		assertEquals(RuntimeVariables.replace("Buffer Size"),
			selenium.getText("//p[4]/a[1]"));
		assertEquals(RuntimeVariables.replace("Download File"),
			selenium.getText("//p[4]/a[2]"));
		assertEquals(RuntimeVariables.replace("Portlet Session"),
			selenium.getText("//h3[5]"));
		assertEquals(RuntimeVariables.replace("Attribute Sharing"),
			selenium.getText("//p[5]/a"));
		assertTrue(selenium.isPartialText("//p[6]",
				"TestPortletConfigMessageListener.isReceived=PASSED "));
		assertTrue(selenium.isPartialText("//p[6]",
				"TestSpringConfigMessageListener.isReceived=PASSED"));
		assertEquals(RuntimeVariables.replace("Servlet Request"),
			selenium.getText("//h3[7]"));
		assertEquals(RuntimeVariables.replace("Remote User"),
			selenium.getText("//p[7]/a"));
		assertEquals(RuntimeVariables.replace("Upload"),
			selenium.getText("//h3[8]"));
		assertEquals(RuntimeVariables.replace("Form 1"),
			selenium.getText("//p[8]/a[1]"));
		assertEquals(RuntimeVariables.replace("Form 2"),
			selenium.getText("//p[8]/a[2]"));
		assertEquals(RuntimeVariables.replace("Form 3"),
			selenium.getText("//a[3]"));
	}
}