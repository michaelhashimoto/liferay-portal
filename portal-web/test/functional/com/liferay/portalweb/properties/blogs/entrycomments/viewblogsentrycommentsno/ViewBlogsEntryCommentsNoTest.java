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

package com.liferay.portalweb.properties.blogs.entrycomments.viewblogsentrycommentsno;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsEntryCommentsNoTest extends BaseTestCase {
	public void testViewBlogsEntryCommentsNo() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Blogs Test Page");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("0 Comments"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//div[@class='entry-title']/h2/a"));
		selenium.clickAt("//div[@class='entry-title']/h2/a",
			RuntimeVariables.replace("Blogs Entry Title"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("0 Comments"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-panel-title']/span[contains(.,'Comments')]"));
		assertFalse(selenium.isTextPresent("No comments yet."));
		assertFalse(selenium.isTextPresent("Be the first."));
		assertFalse(selenium.isTextPresent("Subscribe to Comments"));
		assertTrue(selenium.isElementNotPresent(
				"//fieldset[contains(@class,'add-comment')]/div/a"));
		assertTrue(selenium.isElementNotPresent(
				"//span[@class='subscribe-link']"));
	}
}