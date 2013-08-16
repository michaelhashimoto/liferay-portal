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
public class TranslateChineseTEnglishTest extends BaseTestCase {
	public void testTranslateChineseTEnglish() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Translator Test Page");
		selenium.clickAt("link=Translator Test Page",
			RuntimeVariables.replace("Translator Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//textarea[@id='_26_text']",
			RuntimeVariables.replace(
				"\u6211\u7684\u540d\u5b57\u662fLiferay\u8bd1\u8005\uff0c\u6d41\u5229\u5b8c\u5168\u6210\u529f6\u901a\u4fe1\u7684\u767e\u4e07\u4e2a\u5f62\u5f0f\u3002"));
		selenium.select("//select[@id='_26_id']",
			RuntimeVariables.replace("Chinese (Taiwan) to English"));
		selenium.clickAt("//input[@value='Translate']",
			RuntimeVariables.replace("Translate"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"My name is the Liferay translator, fluent completely successful 6 correspondence 1,000,000 forms."));
	}
}