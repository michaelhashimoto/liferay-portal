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
public class Member_DocumentLibraryRolesTest extends BaseTestCase {
	public void testMember_DocumentLibraryRoles() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.clickAt("link=Define Permissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Document Library"));
		selenium.waitForPageToLoad("30000");
		selenium.uncheck("_128_rowIds");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileEntryADD_DISCUSSION']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileEntryDELETE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileEntryDELETE_DISCUSSION']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileEntryPERMISSIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileEntryUPDATE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileEntryUPDATE_DISCUSSION']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileEntryVIEW']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFolderADD_DOCUMENT']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFolderADD_SHORTCUT']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFolderADD_SUBFOLDER']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFolderDELETE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFolderPERMISSIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFolderUPDATE']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFolderVIEW']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileShortcutADD_DISCUSSION']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileShortcutDELETE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileShortcutDELETE_DISCUSSION']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileShortcutPERMISSIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileShortcutUPDATE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileShortcutUPDATE_DISCUSSION']");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.documentlibrary.model.DLFileShortcutVIEW']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("The role permissions were updated."));
	}
}