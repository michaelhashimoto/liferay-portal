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

package com.liferay.portalweb.plugins.samplelar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletSLOptionsTest extends BaseTestCase {
	public void testViewPortletSLOptions() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Sample LAR Test Page",
			RuntimeVariables.replace("Sample LAR Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"This is the Sample LAR Portlet. This was made to demonstrate the portlet LAR plugin feature."));
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Export / Import')]");
		assertEquals(RuntimeVariables.replace("Export / Import"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Export / Import')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Export / Import')]",
			RuntimeVariables.replace("Export / Import"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//input[@id='_86_exportFileName']"));
		assertTrue(selenium.isVisible("//input[@value='Export']"));
		selenium.click(RuntimeVariables.replace("link=Import"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//input[@id='_86_importFileName']"));
		assertTrue(selenium.isVisible("//input[@value='Import']"));
	}
}