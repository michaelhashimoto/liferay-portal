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

package com.liferay.portalweb.socialofficehome.activities.activitiesblockedsouser.sousviewactivitiesblockedsouser3;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs1_ViewActivitiesSOUser3Test extends BaseTestCase {
	public void testSOUs1_ViewActivitiesSOUser3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard");
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title']/span)[contains(.,'Activities')]"));
		assertEquals(RuntimeVariables.replace("Connections"),
			selenium.getText("link=Connections"));
		selenium.clickAt("link=Connections",
			RuntimeVariables.replace("Connections"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("xPath=(//div[@class='activity-user-name'])[1]");
		assertEquals(RuntimeVariables.replace(
				"Social03 Office03 User03 in Open Site Name"),
			selenium.getText("xPath=(//div[@class='activity-user-name'])[1]"));
		assertEquals(RuntimeVariables.replace("Wrote a new forum post."),
			selenium.getText("xPath=(//div[@class='activity-action'])[1]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='activity-body'])[1]",
				"Forums Thread1 Message Subject"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='activity-body'])[1]",
				"Forums Thread1 Message Body"));
		assertEquals(RuntimeVariables.replace("Social03 Office03 User03"),
			selenium.getText("xPath=(//div[@class='activity-user-name'])[2]"));
		assertEquals(RuntimeVariables.replace("Microblogs Post1"),
			selenium.getText("xPath=(//div[@class='activity-action'])[2]"));
	}
}