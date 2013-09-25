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

package com.liferay.portalweb.socialofficehome.whatshappening.whentry.addwhentrycontentviewablebyfollowers;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewWHContentViewableByFollowersTest extends BaseTestCase {
	public void testSOUs_ViewWHContentViewableByFollowers()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard");
		assertEquals(RuntimeVariables.replace("Microblogs Status Update"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Microblogs Status Update')]"));
		assertTrue(selenium.isElementPresent(
				"//div[contains(@id,'_2_WAR_microblogsportlet_autocompleteContent')]"));
		assertEquals(RuntimeVariables.replace(
				"You do not have any microblog entries."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.clickAt("//div[contains(@id,'_2_WAR_microblogsportlet_autocompleteContent')]",
			RuntimeVariables.replace("Update your status..."));
		assertEquals(RuntimeVariables.replace("Following"),
			selenium.getText("link=Following"));
		selenium.clickAt("link=Following", RuntimeVariables.replace("Following"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='no-activities']");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("There are no activities."),
			selenium.getText("//div[@class='no-activities']"));
		assertFalse(selenium.isTextPresent("Microblogs Post"));
		selenium.waitForVisible("//nav/ul/li[contains(.,'Microblogs')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
			RuntimeVariables.replace("Microblogs"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Microblogs Post"));
	}
}