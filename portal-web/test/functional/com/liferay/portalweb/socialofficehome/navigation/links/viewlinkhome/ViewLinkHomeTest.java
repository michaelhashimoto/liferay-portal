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

package com.liferay.portalweb.socialofficehome.navigation.links.viewlinkhome;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewLinkHomeTest extends BaseTestCase {
	public void testViewLinkHome() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible("//nav/ul/li[contains(.,'Home')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		assertEquals(RuntimeVariables.replace("Microblogs Status Update"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Microblogs Status Update')]"));
		assertEquals(RuntimeVariables.replace("Update your status..."),
			selenium.getText(
				"//div[contains(@id,'_2_WAR_microblogsportlet_autocompleteContent')]"));
		assertEquals(RuntimeVariables.replace(
				"You do not have any microblog entries."),
			selenium.getText("xPath=(//div[@class='portlet-msg-info'])[1]"));
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'Activities')]"));
		selenium.waitForVisible("//div[@class='no-activities']");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("There are no activities."),
			selenium.getText("//div[@class='no-activities']"));
		assertEquals(RuntimeVariables.replace("Connections"),
			selenium.getText("link=Connections"));
		assertEquals(RuntimeVariables.replace("Following"),
			selenium.getText("link=Following"));
		assertEquals(RuntimeVariables.replace("My Sites"),
			selenium.getText("link=My Sites"));
		assertEquals(RuntimeVariables.replace("Me"), selenium.getText("link=Me"));
		assertEquals(RuntimeVariables.replace("Upcoming Tasks"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'Upcoming Tasks')]"));
		assertEquals(RuntimeVariables.replace("View All Tasks"),
			selenium.getText("//div[@class='view-all-tasks']"));
		assertEquals(RuntimeVariables.replace("Events"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'Events')]"));
		assertEquals(RuntimeVariables.replace("There are no more events today."),
			selenium.getText("//div[2]/div/div[2]/div/section/div/div/div"));
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		assertTrue(selenium.isVisible("//div/input[1]"));
		assertEquals(RuntimeVariables.replace("Liferay, Inc."),
			selenium.getText("//li/span[2]/a"));
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//li[2]/span[2]/a"));
	}
}