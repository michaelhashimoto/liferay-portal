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

package com.liferay.portalweb.demo.useradmin.permissionsgroupcompanylevel;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User2_ViewBlogsPortletTest extends BaseTestCase {
	public void testUser2_ViewBlogsPortlet() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Blogs Test Page");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry2 Title"),
			selenium.getText("xPath=(//div[@class='entry-title']/h2/a)[1]"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"xPath=(//div[@class='lfr-meta-actions edit-actions entry'])[1]"));
		assertEquals(RuntimeVariables.replace("Blogs Entry2 Content"),
			selenium.getText("xPath=(//div[@class='entry-body']/p)[1]"));
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Title"),
			selenium.getText("xPath=(//div[@class='entry-title']/h2/a)[2]"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"xPath=(//div[@class='lfr-meta-actions edit-actions entry'])[2]"));
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Content"),
			selenium.getText("xPath=(//div[@class='entry-body']/p)[2]"));
	}
}