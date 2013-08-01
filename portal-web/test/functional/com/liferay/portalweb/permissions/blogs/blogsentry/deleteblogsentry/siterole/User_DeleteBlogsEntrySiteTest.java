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

package com.liferay.portalweb.permissions.blogs.blogsentry.deleteblogsentry.siterole;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_DeleteBlogsEntrySiteTest extends BaseTestCase {
	public void testUser_DeleteBlogsEntrySite() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//td[contains(.,'Delete')]/span/a/span"));
		selenium.clickAt("//td[contains(.,'Delete')]/span/a/span",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForConfirmation("Are you sure you want to delete this?");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Showing 0 results."),
			selenium.getText("//div[@class='search-results']"));
	}
}