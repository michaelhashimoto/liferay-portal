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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.viewmicroblogstimeline;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMicroblogsTimelineTest extends BaseTestCase {
	public void testViewMicroblogsTimeline() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
			RuntimeVariables.replace("Microblogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Timeline"),
			selenium.getText("link=Timeline"));
		selenium.clickAt("link=Timeline", RuntimeVariables.replace("Timeline"));
		selenium.waitForVisible("xPath=(//div[@class='content'])[1]");
		selenium.waitForVisible("xPath=(//div[@class='content'])[2]");
		selenium.waitForVisible("xPath=(//div[@class='content'])[3]");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Joe Bloggs says"),
			selenium.getText("xPath=(//div[@class='user-name'])[1]"));
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("xPath=(//div[@class='content'])[1]"));
		assertEquals(RuntimeVariables.replace("Comment"),
			selenium.getText("xPath=(//span[@class='action comment']/a)[1]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs says"),
			selenium.getText("xPath=(//div[@class='user-name'])[2]"));
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("xPath=(//div[@class='content'])[2]"));
		assertEquals(RuntimeVariables.replace("Comment"),
			selenium.getText("xPath=(//span[@class='action comment']/a)[2]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs says"),
			selenium.getText("xPath=(//div[@class='user-name'])[3]"));
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("xPath=(//div[@class='content'])[3]"));
		assertEquals(RuntimeVariables.replace("Comment"),
			selenium.getText("xPath=(//span[@class='action comment']/a)[3]"));
	}
}