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

package com.liferay.portalweb.portlet.mediagallery.dmimage.editdmfolderimagemg;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditDMFolderImageMGTest extends BaseTestCase {
	public void testEditDMFolderImageMG() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//span[@class='image-title']"));
		selenium.clickAt("//span[@class='image-title']",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText("//span[@class='image-title']"));
		selenium.clickAt("//span[@class='image-title']",
			RuntimeVariables.replace("DM Folder Image Title"));
		selenium.waitForVisible("//img");
		assertTrue(selenium.isVisible("//img"));
		selenium.waitForText("//div[contains(@class,'image-viewer-caption')]",
			"DM Folder Image Title - DM Folder Image Description");
		assertEquals(RuntimeVariables.replace(
				"DM Folder Image Title - DM Folder Image Description"),
			selenium.getText("//div[contains(@class,'image-viewer-caption')]"));
		selenium.clickAt("//img[@alt='Edit']", RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		selenium.type("//input[@id='_31_title']",
			RuntimeVariables.replace("DM Folder Image Title Edit"));
		selenium.type("//textarea[@id='_31_description']",
			RuntimeVariables.replace("DM Folder Image Description Edit"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("DM Folder Image Title Edit"),
			selenium.getText("//span[@class='image-title']"));
	}
}