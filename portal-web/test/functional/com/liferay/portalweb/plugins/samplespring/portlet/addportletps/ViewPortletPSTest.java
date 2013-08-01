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

package com.liferay.portalweb.plugins.samplespring.portlet.addportletps;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletPSTest extends BaseTestCase {
	public void testViewPortletPS() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Pet Sites Test Page",
			RuntimeVariables.replace("Pet Sites Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Pet Sites"),
			selenium.getText("//div[@class='portlet-body']/h1"));
		assertEquals(RuntimeVariables.replace(
				"There are currently no sites to display. Edit Mode allows you to add sites."),
			selenium.getText("//div[@class='portlet-body']/form/p"));
		assertEquals(RuntimeVariables.replace("Edit Mode"),
			selenium.getText("//div/div/a"));
		selenium.clickAt("//div/div/a", RuntimeVariables.replace("Edit Mode"));
		selenium.waitForText("//div/div/a", "Add Site");
		assertEquals(RuntimeVariables.replace("Add Site"),
			selenium.getText("//div/div/a"));
		assertEquals(RuntimeVariables.replace("View Mode"),
			selenium.getText("//div/a[2]"));
		selenium.clickAt("//div/a[2]", RuntimeVariables.replace("View Mode"));
		selenium.waitForText("//div/div/a", "Edit Mode");
		assertEquals(RuntimeVariables.replace("Edit Mode"),
			selenium.getText("//div/div/a"));
		assertEquals(RuntimeVariables.replace("Pet Sites"),
			selenium.getText("//div[@class='portlet-body']/h1"));
		assertEquals(RuntimeVariables.replace(
				"There are currently no sites to display. Edit Mode allows you to add sites."),
			selenium.getText("//div[@class='portlet-body']/form/p"));
	}
}