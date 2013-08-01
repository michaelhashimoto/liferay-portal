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

package com.liferay.portalweb.portal.dbupgrade.sampledata529.webcontent.imageassociation;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddIGFolderImageTest extends BaseTestCase {
	public void testAddIGFolderImage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Communities",
			RuntimeVariables.replace("Communities"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Web Content Image Association Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td[1]/a",
			RuntimeVariables.replace("Public Pages - Live (1)"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Image Gallery Page",
			RuntimeVariables.replace("Image Gallery Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td/a",
			RuntimeVariables.replace("Folder Test"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Image']",
			RuntimeVariables.replace("Add Image"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.waitForVisible("link=Use the classic uploader.");
		selenium.click("link=Use the classic uploader.");
		selenium.waitForVisible("//input[@id='_31_file']");
		selenium.uploadFile("//input[@id='_31_file']",
			RuntimeVariables.replace(
				"L:\\portal\\build\\portal-web\\test\\com\\liferay\\portalweb\\portal\\dbupgrade\\sampledata529\\webcontent\\imageassociation\\dependencies\\ImageGallery.jpg"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertTrue(selenium.isElementPresent("//img[@alt='ImageGallery. ']"));
		assertEquals(RuntimeVariables.replace("ImageGallery"),
			selenium.getText("//form[@name='_31_fm2']/div[3]/div/div[1]"));
	}
}