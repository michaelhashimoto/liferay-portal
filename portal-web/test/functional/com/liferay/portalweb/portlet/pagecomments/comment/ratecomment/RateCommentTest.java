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

package com.liferay.portalweb.portlet.pagecomments.comment.ratecomment;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RateCommentTest extends BaseTestCase {
	public void testRateComment() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace("Page Comments Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//div[@class='taglib-ratings thumbs']/div/div/a"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a",
			RuntimeVariables.replace("Rate this as good."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//div[@class='taglib-ratings thumbs']/div/div/a"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a",
			RuntimeVariables.replace("Rate this as good."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//div[@class='taglib-ratings thumbs']/div/div/a[2]"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace("Rate this as bad."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"-1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//div[@class='taglib-ratings thumbs']/div/div/a[2]"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace("Rate this as bad."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//div[@class='taglib-ratings thumbs']/div/div/a"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a",
			RuntimeVariables.replace("Rate this as good."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//div[@class='taglib-ratings thumbs']/div/div/a[2]"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace("Rate this as bad."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"-1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//div[@class='taglib-ratings thumbs']/div/div/a[2]"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace("Rate this as bad."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//div[@class='taglib-ratings thumbs']/div/div/a[2]"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace("Rate this as bad."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"-1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//div[@class='taglib-ratings thumbs']/div/div/a"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a",
			RuntimeVariables.replace("Rate this as good."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isVisible(
				"//div[@class='taglib-ratings thumbs']/div/div/a"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a",
			RuntimeVariables.replace("Rate this as good."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"0 (0 Votes)");
	}
}