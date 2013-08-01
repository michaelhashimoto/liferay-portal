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

package com.liferay.portalweb.portal.dbupgrade.transfersampledatalatest.wiki.usecaselarportlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ImportExportPortletLARWikiUseCaseTest extends BaseTestCase {
	public void testImportExportPortletLARWikiUseCase()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/wiki-use-case-community/");
		selenium.waitForVisible("link=Wiki Test Page");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Wiki"),
			selenium.getText("//span[@class='portlet-title-text']"));
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//strong/a"));
		selenium.clickAt("//strong/a", RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a");
		assertEquals(RuntimeVariables.replace("Export / Import"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Import", RuntimeVariables.replace("Import"));
		selenium.waitForPageToLoad("30000");
		selenium.uploadTempFile("//input[@id='_86_importFileName']",
			RuntimeVariables.replace("Wiki_Use_Case.Portlet.lar"));
		assertFalse(selenium.isChecked(
				"//input[@id='_86_PORTLET_ARCHIVED_SETUPSCheckbox']"));
		selenium.clickAt("//input[@id='_86_PORTLET_ARCHIVED_SETUPSCheckbox']",
			RuntimeVariables.replace("Archived Setup"));
		assertTrue(selenium.isChecked(
				"//input[@id='_86_PORTLET_ARCHIVED_SETUPSCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_86_PORTLET_USER_PREFERENCESCheckbox']"));
		selenium.clickAt("//input[@id='_86_PORTLET_USER_PREFERENCESCheckbox']",
			RuntimeVariables.replace("User Preferences"));
		assertTrue(selenium.isChecked(
				"//input[@id='_86_PORTLET_USER_PREFERENCESCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_86_DELETE_PORTLET_DATACheckbox']"));
		selenium.clickAt("//input[@id='_86_DELETE_PORTLET_DATACheckbox']",
			RuntimeVariables.replace("Delete portlet data before importing."));
		assertTrue(selenium.isChecked(
				"//input[@id='_86_DELETE_PORTLET_DATACheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_86_PORTLET_DATACheckbox']"));
		selenium.clickAt("//input[@id='_86_PORTLET_DATACheckbox']",
			RuntimeVariables.replace("Data"));
		assertTrue(selenium.isChecked("//input[@id='_86_PORTLET_DATACheckbox']"));
		assertFalse(selenium.isChecked("//input[@id='_86_PERMISSIONSCheckbox']"));
		selenium.clickAt("//input[@id='_86_PERMISSIONSCheckbox']",
			RuntimeVariables.replace("Permissions"));
		assertTrue(selenium.isChecked("//input[@id='_86_PERMISSIONSCheckbox']"));
		assertFalse(selenium.isChecked("//input[@id='_86_CATEGORIESCheckbox']"));
		selenium.clickAt("//input[@id='_86_CATEGORIESCheckbox']",
			RuntimeVariables.replace("Categories"));
		assertTrue(selenium.isChecked("//input[@id='_86_CATEGORIESCheckbox']"));
		selenium.clickAt("//input[@value='Import']",
			RuntimeVariables.replace("Import"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}