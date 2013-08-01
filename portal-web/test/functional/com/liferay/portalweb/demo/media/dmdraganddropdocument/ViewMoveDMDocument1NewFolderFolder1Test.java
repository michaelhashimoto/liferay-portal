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

package com.liferay.portalweb.demo.media.dmdraganddropdocument;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMoveDMDocument1NewFolderFolder1Test extends BaseTestCase {
	public void testViewMoveDMDocument1NewFolderFolder1()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent(
				"//div[@data-title='DM Document1 Title']/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("//div[@data-title='DM Folder1 Name']/a/span[2]"));
		selenium.clickAt("//div[@data-title='DM Folder1 Name']/a/span[2]",
			RuntimeVariables.replace("DM Folder1 Name"));
		selenium.waitForText("//li[contains(@class,'selected')]/a/span[2]",
			"DM Folder1 Name");
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("//li[contains(@class,'selected')]/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DM Document1 Title"),
			selenium.getText(
				"//div[@data-title='DM Document1 Title']/a/span[2]"));
	}
}