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
public class ViewDMFolderImageMyMediaMGTest extends BaseTestCase {
	public void testViewDMFolderImageMyMediaMG() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Mine", RuntimeVariables.replace("Mine"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Mine"),
			selenium.getText("//h1[@class='header-title']/span"));
		selenium.waitForVisible(
			"//img[@alt='DM Folder Image Title - DM Folder Image Description']");
		assertTrue(selenium.isVisible(
				"//img[@alt='DM Folder Image Title - DM Folder Image Description']"));
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText("//span[@class='image-title']"));
	}
}