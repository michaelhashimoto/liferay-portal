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
public class TranslateFrenchGermanTest extends BaseTestCase {
	public void testTranslateFrenchGerman() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Translator Test Page");
		selenium.clickAt("link=Translator Test Page",
			RuntimeVariables.replace("Translator Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//textarea[@id='_26_text']",
			RuntimeVariables.replace(
				"Mon nom est traducteur de Liferay, fluent dans plus de 6 millions de formes de communication."));
		selenium.select("//select[@id='_26_id']",
			RuntimeVariables.replace("French to German"));
		selenium.clickAt("//input[@value='Translate']",
			RuntimeVariables.replace("Translate"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"Mein Name ist \u00fcbersetzer von Liferay, flie\u00dfender in mehr als 6 Millionen Kommunikationsformen."));
	}
}