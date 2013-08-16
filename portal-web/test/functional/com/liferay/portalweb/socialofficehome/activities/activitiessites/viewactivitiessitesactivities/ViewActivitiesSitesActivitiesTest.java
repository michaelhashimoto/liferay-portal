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

package com.liferay.portalweb.socialofficehome.activities.activitiessites.viewactivitiessitesactivities;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewActivitiesSitesActivitiesTest extends BaseTestCase {
	public void testViewActivitiesSitesActivities() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title']/span)[contains(.,'Activities')]"));
		assertEquals(RuntimeVariables.replace("Me"), selenium.getText("link=Me"));
		selenium.clickAt("link=Me", RuntimeVariables.replace("Me"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Joe added a new bookmarks entry, Bookmarks Entry Name, in Open Site Name."),
			selenium.getText("xPath=(//div[@class='activity-title'])[1]"));
		assertEquals(RuntimeVariables.replace(
				"Joe updated a wiki page, FrontPage, in Open Site Name."),
			selenium.getText("xPath=(//div[@class='activity-title'])[2]"));
		assertEquals(RuntimeVariables.replace(
				"Joe updated a wiki page, FrontPage, in Open Site Name."),
			selenium.getText("xPath=(//div[@class='activity-title'])[3]"));
		assertEquals(RuntimeVariables.replace(
				"Joe wrote a new blog entry, Blogs Entry Title, in Open Site Name."),
			selenium.getText("xPath=(//div[@class='activity-title'])[4]"));
		assertEquals(RuntimeVariables.replace(
				"Joe wrote a new message board post, MB Category Thread Message Subject, in Open Site Name."),
			selenium.getText("xPath=(//div[@class='activity-title'])[5]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='activity-body'])[5]", "Go to Category"));
		assertEquals(RuntimeVariables.replace(
				"Joe uploaded a new document, DM Folder Document Title, in Open Site Name."),
			selenium.getText("xPath=(//div[@class='activity-title'])[6]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='activity-body'])[6]", "View Document"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='activity-body'])[6]", "Go to Folder"));
		assertEquals(RuntimeVariables.replace(
				"Joe added a new calendar event, Calendar Event Title, in Open Site Name."),
			selenium.getText("xPath=(//div[@class='activity-title'])[7]"));
	}
}