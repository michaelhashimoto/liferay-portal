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

package com.liferay.portalweb.portlet.language;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class InternationalizationJapaneseTest extends BaseTestCase {
	public void testInternationalizationJapanese() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Language Test Page",
			RuntimeVariables.replace("Language Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//img[@alt='\u65e5\u672c\u8a9e [Beta]']",
			RuntimeVariables.replace("\u65e5\u672c\u8a9e [Beta]"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//nav/ul/li[2]/a/span",
			RuntimeVariables.replace("Edit Page Name"));
		selenium.waitForVisible("//input[@type='text']");
		selenium.type("//input[@type='text']",
			RuntimeVariables.replace(
				"\u8a00\u8a9e\u30c6\u30b9\u30c8\u30da\u30fc\u30b8"));
		selenium.clickAt("//button[contains(@id,'Save')]",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible(
			"link=\u8a00\u8a9e\u30c6\u30b9\u30c8\u30da\u30fc\u30b8");
		assertTrue(selenium.isVisible(
				"link=\u8a00\u8a9e\u30c6\u30b9\u30c8\u30da\u30fc\u30b8"));
		selenium.clickAt("//img[@alt='English (United States)']",
			RuntimeVariables.replace("English (United States)"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("link=Language Test Page"));
	}
}