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

package com.liferay.portalweb.asset.messageboards.mbthread.viewportletpaginationregularmbcategorythread6ap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class FirstButtonAPTest extends BaseTestCase {
	public void testFirstButtonAP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[contains(@id,'PageIterator')]",
			RuntimeVariables.replace("3"));
		selenium.waitForPageToLoad("30000");
		assertEquals("3",
			selenium.getSelectedLabel("//select[contains(@id,'PageIterator')]"));
		assertEquals(RuntimeVariables.replace("First"),
			selenium.getText("//a[@class='first']"));
		selenium.clickAt("//a[@class='first']",
			RuntimeVariables.replace("First"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent("//a[@class='first']"));
		assertTrue(selenium.isElementNotPresent("//a[@class='previous']"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//a[@class='next']"));
		assertEquals(RuntimeVariables.replace("Last"),
			selenium.getText("//a[@class='last']"));
		assertEquals("1",
			selenium.getSelectedLabel("//select[contains(@id,'PageIterator')]"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[contains(@id,'PageIterator')]",
			RuntimeVariables.replace("2"));
		selenium.waitForPageToLoad("30000");
		assertEquals("2",
			selenium.getSelectedLabel("//select[contains(@id,'PageIterator')]"));
		assertEquals(RuntimeVariables.replace("First"),
			selenium.getText("//a[@class='first']"));
		selenium.clickAt("//a[@class='first']",
			RuntimeVariables.replace("First"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent("//a[@class='first']"));
		assertTrue(selenium.isElementNotPresent("//a[@class='previous']"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//a[@class='next']"));
		assertEquals(RuntimeVariables.replace("Last"),
			selenium.getText("//a[@class='last']"));
		assertEquals("1",
			selenium.getSelectedLabel("//select[contains(@id,'PageIterator')]"));
	}
}