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

package com.liferay.portalweb.portal.controlpanel.socialactivity.usecase.blogsentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_VoteBlogsEntry2SiteTest extends BaseTestCase {
	public void testUser_VoteBlogsEntry2Site() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='entry-title']/h2/a",
			"Blogs Entry2 Title");
		assertEquals(RuntimeVariables.replace("Blogs Entry2 Title"),
			selenium.getText("//div[@class='entry-title']/h2/a"));
		selenium.clickAt("//div[@class='entry-title']/h2/a",
			RuntimeVariables.replace("Blogs Entry2 Title"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.waitForVisible(
			"xPath=(//div[@class='aui-rating-label-element'])[2]");
		assertEquals(RuntimeVariables.replace("Average (0 Votes)"),
			selenium.getText(
				"xPath=(//div[@class='aui-rating-label-element'])[2]"));
		selenium.clickAt("//a[4]", RuntimeVariables.replace("4 Stars"));
		selenium.waitForText("xPath=(//div[@class='aui-rating-label-element'])[2]",
			"Average (1 Vote)");
		assertEquals(RuntimeVariables.replace("Average (1 Vote)"),
			selenium.getText(
				"xPath=(//div[@class='aui-rating-label-element'])[2]"));
	}
}