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

package com.liferay.portalweb.demo.dynamicdata.kaleoticketdefinitionworkflow;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddTaskKaleoTicketKFTest extends BaseTestCase {
	public void testAddTaskKaleoTicketKF() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Kaleo Forms Test Page");
		selenium.clickAt("link=Kaleo Forms Test Page",
			RuntimeVariables.replace("Kaleo Forms Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Submit New"),
			selenium.getText("//span[@title='Submit New']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Submit New']/ul/li/strong/a",
			RuntimeVariables.replace("Submit New"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a");
		assertEquals(RuntimeVariables.replace("Ticket Process"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a",
			RuntimeVariables.replace("Ticket Process"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_1_WAR_kaleoformsportlet_priority']",
			RuntimeVariables.replace("Major"));
		selenium.select("//select[@id='_1_WAR_kaleoformsportlet_component_name']",
			RuntimeVariables.replace("Kaleo"));
		selenium.type("//input[@id='_1_WAR_kaleoformsportlet_summary']",
			RuntimeVariables.replace("Kaleo Designer does not deploy"));
		selenium.type("//input[@id='_1_WAR_kaleoformsportlet_affect_version']",
			RuntimeVariables.replace("6.1.x"));
		selenium.type("//textarea[@id='_1_WAR_kaleoformsportlet_description']",
			RuntimeVariables.replace(
				"A user is unable to deploy the Kaleo Designer portlet"));
		selenium.uploadCommonFile("//input[@id='_1_WAR_kaleoformsportlet_attachments']",
			RuntimeVariables.replace("Document_1.txt"));
		selenium.select("//select[@id='_1_WAR_kaleoformsportlet_status']",
			RuntimeVariables.replace("Open"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}