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

package com.liferay.portalweb.portal.dbupgrade.sampledata6110.stagingcommunity.quartz;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSchedulerEventStagingCommunityQuartzTest extends BaseTestCase {
	public void testAddSchedulerEventStagingCommunityQuartz()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/community-staging-community-quartz-staging/");
		selenium.waitForVisible("link=Page Staging Community Quartz");
		selenium.clickAt("link=Page Staging Community Quartz",
			RuntimeVariables.replace("Page Staging Community Quartz"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.clickAt("//strong/a",
			RuntimeVariables.replace("Staging Drop Down"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		assertEquals(RuntimeVariables.replace("Schedule Publication to Live"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.click("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		selenium.waitForVisible("//input[@name='_88_description']");
		selenium.type("//input[@name='_88_description']",
			RuntimeVariables.replace("Quartz Scheduler Event"));
		selenium.select("//select[@id='_88_schedulerStartDateMonth']",
			RuntimeVariables.replace("December"));
		selenium.select("//select[@id='_88_schedulerStartDateDay']",
			RuntimeVariables.replace("31"));
		selenium.select("//select[@id='_88_schedulerStartDateYear']",
			RuntimeVariables.replace("2016"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Add Event']",
			RuntimeVariables.replace("Add Event"));
		assertEquals(RuntimeVariables.replace("View All"),
			selenium.getText("//span[1]/a"));
		selenium.clickAt("//span[1]/a", RuntimeVariables.replace("View All"));
		selenium.waitForText("//div[@id='_88_scheduledPublishEventsDiv']/div/div/table/tbody/tr[3]/td",
			"Quartz Scheduler Event");
		assertEquals(RuntimeVariables.replace("Quartz Scheduler Event"),
			selenium.getText(
				"//div[@id='_88_scheduledPublishEventsDiv']/div/div/table/tbody/tr[3]/td"));
	}
}