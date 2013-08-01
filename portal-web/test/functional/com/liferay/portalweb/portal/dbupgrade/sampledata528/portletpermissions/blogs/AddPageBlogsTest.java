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

package com.liferay.portalweb.portal.dbupgrade.sampledata528.portletpermissions.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPageBlogsTest extends BaseTestCase {
	public void testAddPageBlogs() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home");
		selenium.waitForElementPresent("//div[@id='add-page']/a/span");
		selenium.clickAt("//div[@id='add-page']/a/span",
			RuntimeVariables.replace(""));
		selenium.type("//input[@name='new_page']",
			RuntimeVariables.replace("Blogs Portlet Permissions Page"));
		selenium.clickAt("//a[@class='save-page']", RuntimeVariables.replace(""));
		selenium.waitForElementPresent("link=Blogs Portlet Permissions Page");
		selenium.clickAt("link=Blogs Portlet Permissions Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
	}
}