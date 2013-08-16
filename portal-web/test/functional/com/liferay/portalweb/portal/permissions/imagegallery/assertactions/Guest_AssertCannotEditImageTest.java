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

package com.liferay.portalweb.portal.permissions.imagegallery.assertactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_AssertCannotEditImageTest extends BaseTestCase {
	public void testGuest_AssertCannotEditImage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Permissions Image 2 Test"),
			selenium.getText("//a[@title='Permissions Image 2 Test - ']"));
		selenium.clickAt("//a[@title='Permissions Image 2 Test - ']",
			RuntimeVariables.replace("Permissions Image 2 Test"));
		selenium.waitForVisible(
			"//div[contains(@class,'aui-image-viewer-caption')]");
		assertEquals(RuntimeVariables.replace("Permissions Image 2 Test -"),
			selenium.getText(
				"//div[contains(@class,'aui-image-viewer-caption')]"));
		assertTrue(selenium.isElementPresent("//img[@title='Download (29.9k)']"));
		assertTrue(selenium.isElementPresent("//img[@title='View']"));
		assertTrue(selenium.isElementNotPresent("//img[@title='Edit']"));
		assertTrue(selenium.isElementNotPresent("//img[@title='Permissions']"));
		assertTrue(selenium.isElementNotPresent("//img[@title='Delete']"));
	}
}