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

package com.liferay.portalweb.portal.permissions.controlpanel;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CA_BlogsRolesTest extends BaseTestCase {
	public void testCA_BlogsRoles() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.clickAt("link=Define Permissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Blogs"));
		selenium.waitForPageToLoad("30000");
		selenium.check("_128_rowIds");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryADD_DISCUSSION']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryDELETE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryDELETE_DISCUSSION']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryPERMISSIONS']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryUPDATE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryUPDATE_DISCUSSION']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryVIEW']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("The role permissions were updated."));
	}
}