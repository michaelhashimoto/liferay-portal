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

package com.liferay.portalweb.plugins.samplesignin;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletSSITest extends BaseTestCase {
	public void testViewPortletSSI() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.click(RuntimeVariables.replace("link=Sample Sign In Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//section/div/div/div");
		assertEquals(RuntimeVariables.replace(
				"You are signed in as Joe Bloggs."),
			selenium.getText("//section/div/div/div"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div/div/a"));
		selenium.clickAt("//div/div/a", RuntimeVariables.replace("Joe Bloggs"));
		selenium.waitForVisible("//input[@id='_2_emailAddress']");
		assertEquals("test@liferay.com",
			selenium.getValue("//input[@id='_2_emailAddress']"));
	}
}