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

package com.liferay.portalweb.portlet.documentsandmedia.portlet.configuredmportletshowdocumentcolumns;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDMPortletHideDocumentColumnsTest extends BaseTestCase {
	public void testViewDMPortletHideDocumentColumns()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.waitForVisible("//button[@title='Icon View']");
		selenium.clickAt("//button[@title='Icon View']",
			RuntimeVariables.replace("Icon View"));
		Thread.sleep(5000);
		selenium.waitForVisible(
			"//button[contains(@class,'aui-state-active') and @title='Icon View']");
		assertTrue(selenium.isVisible(
				"//button[contains(@class,'aui-state-active') and @title='Icon View']"));
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForText("//div[@class='document-library-breadcrumb']/ul/li[2]/span/a",
			"DM Folder Name");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText(
				"//div[@class='document-library-breadcrumb']/ul/li[2]/span/a"));
		selenium.waitForVisible("//button[@title='List View']");
		selenium.clickAt("//button[@title='List View']",
			RuntimeVariables.replace("List View"));
		selenium.waitForVisible(
			"//button[contains(@class,'aui-state-active') and @title='List View']");
		assertTrue(selenium.isVisible(
				"//button[contains(@class,'aui-state-active') and @title='List View']"));
		selenium.waitForText("//tr[3]/td[2]", "0.3k");
		assertEquals(RuntimeVariables.replace("0.3k"),
			selenium.getText("//tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[3]/td[3]"));
		assertFalse(selenium.isTextPresent("DM Folder Document Title"));
		selenium.clickAt("//button[@title='Icon View']",
			RuntimeVariables.replace("Icon View"));
		selenium.waitForText("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			"DM Folder Document Title");
		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
	}
}