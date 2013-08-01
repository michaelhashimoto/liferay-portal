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

package com.liferay.portalweb.portlet.mediagallery.dmimage.adddmfolderimagemg;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDMFolderImageEditingWindowMGTest extends BaseTestCase {
	public void testViewDMFolderImageEditingWindowMG()
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
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText("//span[@class='image-title']"));
		selenium.clickAt("//span[@class='image-title']",
			RuntimeVariables.replace("DM Folder Image Title"));
		selenium.waitForVisible("//a[@class='aui-image-viewer-close']");
		selenium.waitForVisible("//img");
		assertTrue(selenium.isVisible("//img"));
		selenium.waitForVisible("//img[@alt='Download (12.9k)']");
		assertTrue(selenium.isVisible("//img[@alt='Download (12.9k)']"));
		assertTrue(selenium.isVisible("//img[@alt='View']"));
		assertTrue(selenium.isVisible("//img[@alt='Edit']"));
		assertTrue(selenium.isVisible("//img[@alt='Permissions']"));
		assertTrue(selenium.isVisible("//img[@alt='Delete']"));
		selenium.click("//a[@class='aui-image-viewer-close']");
	}
}