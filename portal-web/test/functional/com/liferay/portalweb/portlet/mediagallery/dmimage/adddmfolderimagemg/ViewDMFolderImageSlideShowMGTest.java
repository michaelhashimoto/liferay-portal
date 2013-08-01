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
public class ViewDMFolderImageSlideShowMGTest extends BaseTestCase {
	public void testViewDMFolderImageSlideShowMG() throws Exception {
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
		assertEquals(RuntimeVariables.replace("View Slide Show"),
			selenium.getText(
				"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'View Slide Show')]"));
		selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'View Slide Show')]",
			RuntimeVariables.replace("View Slide Show"));
		Thread.sleep(1000);
		selenium.selectWindow("title=Media Gallery");
		Thread.sleep(1000);
		selenium.waitForVisible("//img[@name='_31_slideShow']");
		assertTrue(selenium.isVisible("//img[@name='_31_slideShow']"));
		selenium.close();
		selenium.selectWindow("null");
		selenium.waitForVisible(
			"//img[@alt='DM Folder Image Title - DM Folder Image Description']");
		assertTrue(selenium.isVisible(
				"//img[@alt='DM Folder Image Title - DM Folder Image Description']"));
	}
}