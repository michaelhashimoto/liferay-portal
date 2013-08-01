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

package com.liferay.portalweb.asset.messageboards.mbthread.viewportletpaginationsimplembcategorythread6ap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class NextButtonAPTest extends BaseTestCase {
	public void testNextButtonAP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent("//a[@class='previous']"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//a[@class='next']"));
		selenium.clickAt("//a[@class='next']", RuntimeVariables.replace("Next"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//a[@class='previous']"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//a[@class='next']"));
		selenium.clickAt("//a[@class='next']", RuntimeVariables.replace("Next"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//a[@class='previous']"));
		assertTrue(selenium.isElementNotPresent("//a[@class='next']"));
	}
}