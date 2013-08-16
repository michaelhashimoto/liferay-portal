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

package com.liferay.portalweb.asset.webcontent.wcwebcontentcomment.ratewcwebcontentcommentap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RateWCWebContentCommentAPTest extends BaseTestCase {
	public void testRateWCWebContentCommentAP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		selenium.click(
			"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		selenium.click(
			"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		selenium.click(
			"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"-1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
		selenium.click(
			"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		selenium.click(
			"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		selenium.click(
			"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"-1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
		selenium.click(
			"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		selenium.click(
			"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"-1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		selenium.click(
			"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		selenium.click(
			"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
	}
}