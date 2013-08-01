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

package com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.deletedmdocumentsdmdactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DeleteDMDocumentsDMDActionsTest extends BaseTestCase {
	public void testDeleteDMDocumentsDMDActions() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Display Test Page",
			RuntimeVariables.replace("Documents and Media Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document1 Title"),
			selenium.getText("//span[@class='entry-title']"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span"));
		selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]");
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]"));
		selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menu_delete')]",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete this[\\s\\S]$"));
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("DM Document2 Title"),
			selenium.getText("//span[@class='entry-title']"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span"));
		selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]");
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]"));
		selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menu_delete')]",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete this[\\s\\S]$"));
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("DM Document3 Title"),
			selenium.getText("//span[@class='entry-title']"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span"));
		selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]");
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]"));
		selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menu_delete')]",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete this[\\s\\S]$"));
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}