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

package com.liferay.portalweb.plugins.samplespring.portlet.addportletdu;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletDUTest extends BaseTestCase {
	public void testViewPortletDU() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Description Upload Test Page",
			RuntimeVariables.replace("Description Upload Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Upload a Pet Description Here"),
			selenium.getText("//div[@class='portlet-body']/h1"));
		assertEquals(RuntimeVariables.replace(
				"Please upload a small text file (under 2K) and the contents will be added as a description for the pet you choose."),
			selenium.getText("//div[@class='portlet-body']/p"));
		assertTrue(selenium.isVisible("//select[@name='selectedPet']"));
		assertTrue(selenium.isVisible("//input[@name='file']"));
		assertEquals(RuntimeVariables.replace("Upload"),
			selenium.getText("//button[@type='submit']"));
	}
}