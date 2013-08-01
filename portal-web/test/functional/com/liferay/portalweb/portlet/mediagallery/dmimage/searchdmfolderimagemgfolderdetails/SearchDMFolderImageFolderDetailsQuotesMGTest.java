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

package com.liferay.portalweb.portlet.mediagallery.dmimage.searchdmfolderimagemgfolderdetails;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchDMFolderImageFolderDetailsQuotesMGTest extends BaseTestCase {
	public void testSearchDMFolderImageFolderDetailsQuotesMG()
		throws Exception {
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
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		selenium.type("//input[@id='_31_keywords1']",
			RuntimeVariables.replace("\"DM Folder Image Title\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible(
				"//a[@class='image-thumbnail preview aui-image-viewer-link']/img"));
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText("//span[@class='image-title']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_31_keywords1']",
			RuntimeVariables.replace("\"Image2\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent(
				"//a[@class='image-thumbnail preview aui-image-viewer-link']/img"));
		assertFalse(selenium.isTextPresent("DM Folder Image Title"));
	}
}