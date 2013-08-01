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

package com.liferay.portalweb.portlet.translator;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TranslateJapaneseEnglishTest extends BaseTestCase {
	public void testTranslateJapaneseEnglish() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Translator Test Page");
		selenium.clickAt("link=Translator Test Page",
			RuntimeVariables.replace("Translator Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//textarea[@id='_26_text']",
			RuntimeVariables.replace(
				"\u79c1\u306e\u540d\u524d\u306f\u30b3\u30df\u30e5\u30cb\u30b1\u30fc\u30b7\u30e7\u30f3\u306e6,000,000\u306e\u5f62\u614b\u306e\u6d41\u66a2\u306aLiferay\u306e\u8a33\u8005\u3067\u3042\u308b\u3002"));
		selenium.select("//select[@id='_26_id']",
			RuntimeVariables.replace("Japanese to English"));
		selenium.clickAt("//input[@value='Translate']",
			RuntimeVariables.replace("Translate"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"My name is the translator of fluent Liferay of form of 6,000,000 of communication."));
	}
}