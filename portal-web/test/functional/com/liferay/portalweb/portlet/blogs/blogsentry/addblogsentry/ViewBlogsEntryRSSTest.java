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

package com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsEntryRSSTest extends BaseTestCase {
	public void testViewBlogsEntryRSS() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//div[@class='entry-title']/h2/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Content"),
			selenium.getText("//div[@class='entry-body']"));
		assertEquals(RuntimeVariables.replace("RSS (Opens New Window)"),
			selenium.getText("//div[@class='subscribe']/span[1]/a"));

		String rssURL = selenium.getAttribute(
				"//div[@class='subscribe']/span[1]/a@href");
		RuntimeVariables.setValue("rssURL", rssURL);
		selenium.open(RuntimeVariables.getValue("rssURL"));
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//x:h1[@id='feedTitleText']"));
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//x:h2[@id='feedSubtitleText']"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//x:div[@id='feedContent']/x:div[1]/x:h3/x:a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Content"),
			selenium.getText("//x:div[@id='feedContent']/x:div[1]/x:div"));
		selenium.clickAt("//x:div[@id='feedContent']/x:div[1]/x:h3/x:a",
			RuntimeVariables.replace("Blogs Entry Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Content"),
			selenium.getText("//div[@class='entry-body']"));
	}
}