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
public class Writer_PortalRolesTest extends BaseTestCase {
	public void testWriter_PortalRoles() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.clickAt("link=Define Permissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Communities"));
		selenium.waitForPageToLoad("30000");
		selenium.uncheck("_128_rowIds");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupASSIGN_MEMBERS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupASSIGN_REVIEWER']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupDELETE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupMANAGE_ANNOUNCEMENTS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupMANAGE_ARCHIVED_SETUPS']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupMANAGE_LAYOUTS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupMANAGE_STAGING']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupPERMISSIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupPUBLISH_STAGING']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.GroupUPDATE']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("The role permissions were updated."));
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Organizations"));
		selenium.waitForPageToLoad("30000");
		selenium.uncheck("_128_rowIds");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationASSIGN_MEMBERS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationASSIGN_REVIEWER']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationDELETE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationMANAGE_ANNOUNCEMENTS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationMANAGE_ARCHIVED_SETUPS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationMANAGE_LAYOUTS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationMANAGE_STAGING']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationMANAGE_SUBORGANIZATIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationMANAGE_USERS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationPERMISSIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationPUBLISH_STAGING']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationUPDATE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.OrganizationVIEW']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("The role permissions were updated."));
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Roles"));
		selenium.waitForPageToLoad("30000");
		selenium.uncheck("_128_rowIds");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.RoleDEFINE_PERMISSIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.RoleDELETE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.RoleMANAGE_ANNOUNCEMENTS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.RolePERMISSIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.RoleUPDATE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.RoleVIEW']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("The role permissions were updated."));
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=User Groups"));
		selenium.waitForPageToLoad("30000");
		selenium.uncheck("_128_rowIds");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.UserGroupDELETE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.UserGroupMANAGE_ANNOUNCEMENTS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.UserGroupPERMISSIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.UserGroupMANAGE_LAYOUTS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.UserGroupUPDATE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portal.model.UserGroupVIEW']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("The role permissions were updated."));
	}
}