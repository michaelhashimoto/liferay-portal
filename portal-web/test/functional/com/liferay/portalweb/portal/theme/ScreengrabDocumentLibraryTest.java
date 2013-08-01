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

package com.liferay.portalweb.portal.theme;

import com.liferay.portal.kernel.util.FileUtil;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ScreengrabDocumentLibraryTest extends BaseTestCase {
	public void testScreengrabDocumentLibrary() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.waitForElementPresent("link=Test Page 3");
		selenium.click(RuntimeVariables.replace("link=Test Page 3"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace("link=Test Folder"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace(
				"//input[@value='Add Document']"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.waitForElementPresent("link=Use the classic uploader.");
		selenium.click("link=Use the classic uploader.");
		selenium.waitForElementPresent("_20_title");
		FileUtil.mkdirs(RuntimeVariables.replace(
				"L:\\portal\\build\\portal-web\\test-output\\brochure\\"));
		selenium.captureEntirePageScreenshot(RuntimeVariables.replace(
				"L:\\portal\\build\\portal-web\\test-output\\brochure\\ScreengrabTest04.jpg"),
			"");
		selenium.click(RuntimeVariables.replace("//input[@value='Save']"));
		selenium.waitForPageToLoad("30000");
		FileUtil.mkdirs(RuntimeVariables.replace(
				"L:\\portal\\build\\portal-web\\test-output\\brochure\\"));
		selenium.captureEntirePageScreenshot(RuntimeVariables.replace(
				"L:\\portal\\build\\portal-web\\test-output\\brochure\\ScreengrabTest05.jpg"),
			"");
	}
}