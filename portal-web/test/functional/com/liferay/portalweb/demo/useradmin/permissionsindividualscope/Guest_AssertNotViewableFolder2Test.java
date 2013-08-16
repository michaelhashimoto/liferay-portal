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

package com.liferay.portalweb.demo.useradmin.permissionsindividualscope;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_AssertNotViewableFolder2Test extends BaseTestCase {
	public void testGuest_AssertNotViewableFolder2() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"xpath=(//a[contains(@class,'document-link')])[1]"));
		assertEquals(RuntimeVariables.replace("DL Folder 1 Name"),
			selenium.getText("xpath=(//a[contains(@class,'document-link')])[1]"));
		assertTrue(selenium.isElementNotPresent(
				"xpath=(//a[contains(@class,'document-link')])[2]"));
		assertTrue(selenium.isElementNotPresent(
				"xpath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[2]"));
		assertFalse(selenium.isTextPresent("DL Folder 2 Name"));
	}
}