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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.wiki.usecase;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RateWikiFrontPageChildPageComment1Test extends BaseTestCase {
	public void testRateWikiFrontPageChildPageComment1()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/wiki-use-case-community/");
		selenium.waitForVisible("link=Wiki Test Page");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//div[@class='child-pages']/ul/li/a"));
		selenium.clickAt("//div[@class='child-pages']/ul/li/a",
			RuntimeVariables.replace("Wiki FrontPage ChildPage Title"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible(
			"xPath=(//div[@class='aui-rating-label-element'])[3]");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText(
				"xPath=(//div[@class='aui-rating-label-element'])[3]"));
		assertTrue(selenium.isElementNotPresent(
				"//a[contains(@class,'aui-rating-element-off aui-rating-thumb-up aui-rating-element-on')]"));
		Thread.sleep(5000);
		selenium.clickAt("//a[contains(@class,'aui-rating-element-off aui-rating-thumb-up')]",
			RuntimeVariables.replace("Thumbs Up"));
		selenium.waitForText("xPath=(//div[@class='aui-rating-label-element'])[3]",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText(
				"xPath=(//div[@class='aui-rating-label-element'])[3]"));
		assertTrue(selenium.isVisible(
				"//a[contains(@class,'aui-rating-element-off aui-rating-thumb-up aui-rating-element-on')]"));
	}
}