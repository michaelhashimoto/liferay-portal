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

package com.liferay.portalweb.portlet.blogs.blogsentrycomment.subscribetocommentsblogsentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewGmailBlogsEntryComment1NotificationTest extends BaseTestCase {
	public void testViewGmailBlogsEntryComment1Notification()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.openWindow("http://www.gmail.com/",
			RuntimeVariables.replace("gmail"));
		selenium.waitForPopUp("gmail", RuntimeVariables.replace(""));
		selenium.selectWindow("gmail");
		selenium.type("//input[@id='Email']",
			RuntimeVariables.replace("liferay.qa.testing.trunk@gmail.com"));
		selenium.type("//input[@id='Passwd']",
			RuntimeVariables.replace("loveispatient"));
		selenium.clickAt("//input[@id='signIn']",
			RuntimeVariables.replace("Sign In"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(10000);
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//tbody/tr[1]/td[5]/div/span"));
		assertEquals(RuntimeVariables.replace("New Comments by Joe Bloggs"),
			selenium.getText("//tbody/tr[1]/td[6]/div/div/div/span"));
		selenium.clickAt("//tbody/tr[1]/td[6]/div/div/div/span",
			RuntimeVariables.replace("New Comments by Joe Bloggs"));
		selenium.waitForVisible(
			"//table/tr/td/div/div/div/div/div/div/div/div/div/div/div/div/div");
		assertTrue(selenium.isPartialText(
				"//table/tr/td/div/div/div/div/div/div/div/div/div/div/div/div/div",
				"Dear Joe Bloggs"));
		assertTrue(selenium.isPartialText(
				"//table/tr/td/div/div/div/div/div/div/div/div/div/div/div/div/div",
				"Joe Bloggs added a new comment."));
		assertTrue(selenium.isPartialText(
				"//table/tr/td/div/div/div/div/div/div/div/div/div/div/div/div/div",
				"Blogs Entry Comment Body"));
		selenium.clickAt("link=liferay.qa.testing.trunk@gmail.com",
			RuntimeVariables.replace("liferay.qa.testing.trunk@gmail.com"));
		Thread.sleep(1000);
		selenium.waitForVisible("//td[2]/a");
		assertEquals(RuntimeVariables.replace("Sign out"),
			selenium.getText("//td[2]/a"));
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Sign out"));
		selenium.waitForPageToLoad("30000");
		selenium.close();
		selenium.selectWindow("null");
	}
}