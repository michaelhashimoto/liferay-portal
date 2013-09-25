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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousviewmbcontentmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs3_ViewMBContentViewableByEveryoneProfileTest
	extends BaseTestCase {
	public void testSOUs3_ViewMBContentViewableByEveryoneProfile()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice03/so/dashboard");
		assertTrue(selenium.isElementPresent(
				"//div[contains(@id,'_2_WAR_microblogsportlet_autocompleteContent')]"));
		assertEquals(RuntimeVariables.replace(
				"You do not have any microblog entries."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Connections"),
			selenium.getText("link=Connections"));
		selenium.clickAt("link=Connections",
			RuntimeVariables.replace("Connections"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='no-activities']");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("There are no activities."),
			selenium.getText("//div[@class='no-activities']"));
		assertFalse(selenium.isTextPresent("Connections Microblogs Post"));
		assertFalse(selenium.isTextPresent("Followers Microblogs Post"));
		assertFalse(selenium.isTextPresent("Everyone Microblogs Post"));
		assertEquals(RuntimeVariables.replace("Following"),
			selenium.getText("link=Following"));
		selenium.clickAt("link=Following", RuntimeVariables.replace("Following"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='no-activities']");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("There are no activities."),
			selenium.getText("//div[@class='no-activities']"));
		assertFalse(selenium.isTextPresent("Connections Microblogs Post"));
		assertFalse(selenium.isTextPresent("Followers Microblogs Post"));
		assertFalse(selenium.isTextPresent("Everyone Microblogs Post"));
		selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
			RuntimeVariables.replace("Microblogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You do not have any microblog entries."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertFalse(selenium.isTextPresent("Connections Microblogs Post"));
		assertFalse(selenium.isTextPresent("Followers Microblogs Post"));
		assertFalse(selenium.isTextPresent("Everyone Microblogs Post"));
		selenium.open("/web/joebloggs/so/profile");
		assertEquals(RuntimeVariables.replace("Everyone Microblogs Post"),
			selenium.getText("//div[@class='content']"));
		selenium.waitForVisible("//div[@class='activity-action']");
		assertEquals(RuntimeVariables.replace("Everyone Microblogs Post"),
			selenium.getText("//div[@class='activity-action']"));
		selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
			RuntimeVariables.replace("Microblogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[@class='user-name']/span"));
		assertEquals(RuntimeVariables.replace("Everyone Microblogs Post"),
			selenium.getText("//div[@class='content']"));
		assertFalse(selenium.isTextPresent("Connections Microblogs Post"));
		assertFalse(selenium.isTextPresent("Followers Microblogs Post"));
	}
}