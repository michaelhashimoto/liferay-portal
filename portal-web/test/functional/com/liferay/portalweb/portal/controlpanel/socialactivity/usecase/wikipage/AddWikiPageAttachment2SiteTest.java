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

package com.liferay.portalweb.portal.controlpanel.socialactivity.usecase.wikipage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWikiPageAttachment2SiteTest extends BaseTestCase {
	public void testAddWikiPageAttachment2Site() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("All Pages"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'All Pages')]/a/span"));
		selenium.clickAt("//ul[@class='top-links-navigation']/li/span[contains(.,'All Pages')]/a/span",
			RuntimeVariables.replace("All Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Page Title"),
			selenium.getText("//tr[contains(.,'Wiki Page Title')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'Wiki Page Title')]/td[1]/a",
			RuntimeVariables.replace("Wiki Page Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Page Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		assertEquals(RuntimeVariables.replace("1 Attachment"),
			selenium.getText("//div[6]/div[1]/span[2]/a/span"));
		selenium.clickAt("//div[6]/div[1]/span[2]/a/span",
			RuntimeVariables.replace("1 Attachment"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Attachments']",
			RuntimeVariables.replace("Add Attachments"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.waitForVisible("//a[@class='use-fallback using-new-uploader']");
		selenium.click("//a[@class='use-fallback using-new-uploader']");
		selenium.waitForVisible("//input[@id='_36_file1']");
		selenium.uploadCommonFile("//input[@id='_36_file1']",
			RuntimeVariables.replace("Document_2.jpg"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Document_1.jpg"),
			selenium.getText("//td[contains(.,'Document_1')]/a"));
		assertEquals(RuntimeVariables.replace("Document_2.jpg"),
			selenium.getText("//td[contains(.,'Document_2')]/a"));
		assertEquals(RuntimeVariables.replace("Showing 2 results."),
			selenium.getText("//div[@class='search-results']"));
	}
}