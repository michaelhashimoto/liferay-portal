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

package com.liferay.portalweb.portlet.activities.portlet.draganddropportletactivities;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DragAndDropPortletActivitiesTest extends BaseTestCase {
	public void testDragAndDropPortletActivities() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/group/joebloggs/home/");
		selenium.clickAt("link=Activities Test Page",
			RuntimeVariables.replace("Activities Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible(
				"//div[@id='column-1']/div/div[contains(@class,'portlet-activities')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@id='column-2']/div/div[contains(@class,'portlet-activities')]"));
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText("//span[@class='portlet-title-text']"));
		selenium.clickAt("//span[@class='portlet-title-text']",
			RuntimeVariables.replace("Activities"));
		Thread.sleep(1000);
		selenium.mouseDown("//span[@class='portlet-title-text']");
		Thread.sleep(1000);
		selenium.waitForElementPresent("//div[@id='column-1_shim']");
		selenium.mouseMoveAt("//div[@id='column-2_shim']",
			RuntimeVariables.replace("0,80"));
		selenium.mouseUp("//div[@id='column-2_shim']");
		selenium.waitForVisible(
			"//div[@id='column-2']/div/div[contains(@class,'portlet-activities')]");
		assertTrue(selenium.isVisible(
				"//div[@id='column-2']/div/div[contains(@class,'portlet-activities')]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@id='column-1']/div/div[contains(@class,'portlet-activities')]"));
	}
}