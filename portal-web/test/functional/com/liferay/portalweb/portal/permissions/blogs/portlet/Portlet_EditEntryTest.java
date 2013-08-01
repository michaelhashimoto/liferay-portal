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

package com.liferay.portalweb.portal.permissions.blogs.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Portlet_EditEntryTest extends BaseTestCase {
	public void testPortlet_EditEntry() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[@class='entry-title']/h2/a",
			RuntimeVariables.replace("Blogs Entry Title Temporary"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-meta-actions edit-actions entry']/table/tbody/tr/td/span/a[contains(.,'Edit')]"));
		selenium.clickAt("//div[@class='lfr-meta-actions edit-actions entry']/table/tbody/tr/td/span/a[contains(.,'Edit')]",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_33_title']",
			RuntimeVariables.replace("Blogs Entry Title Edited"));
		Thread.sleep(1000);
		selenium.waitForVisible("//a[@class='cke_button_unlink cke_disabled']");
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
			RuntimeVariables.replace("Blogs Entry Content Edited"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='portlet-msg-success']",
			"Your request completed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.waitForText("//h1[@class='header-title']/span",
			"Blogs Entry Title Edited");
		assertEquals(RuntimeVariables.replace("Blogs Entry Title Edited"),
			selenium.getText("//h1[@class='header-title']/span"));
		selenium.waitForText("//div[@class='entry-body']",
			"Blogs Entry Content Edited");
		assertEquals(RuntimeVariables.replace("Blogs Entry Content Edited"),
			selenium.getText("//div[@class='entry-body']"));
	}
}