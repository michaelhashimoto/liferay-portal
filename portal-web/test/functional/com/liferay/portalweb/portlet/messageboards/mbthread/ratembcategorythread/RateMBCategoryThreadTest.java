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

package com.liferay.portalweb.portlet.messageboards.mbthread.ratembcategorythread;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RateMBCategoryThreadTest extends BaseTestCase {
	public void testRateMBCategoryThread() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread Message Subject"),
			selenium.getText("//td[1]/a"));
		selenium.clickAt("//td[1]/a",
			RuntimeVariables.replace("MB Category Thread Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText(
				"//div[@class='taglib-ratings thumbs']/div/div/div"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		assertTrue(selenium.isElementNotPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		assertTrue(selenium.isElementNotPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[1]",
			RuntimeVariables.replace("Thumb Up"));
		selenium.waitForText("//div[@class='taglib-ratings thumbs']/div/div/div",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText(
				"//div[@class='taglib-ratings thumbs']/div/div/div"));
		assertTrue(selenium.isElementNotPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		assertTrue(selenium.isElementNotPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace("Thumb Down"));
		selenium.waitForText("//div[@class='taglib-ratings thumbs']/div/div/div",
			"-1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText(
				"//div[@class='taglib-ratings thumbs']/div/div/div"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertTrue(selenium.isElementNotPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		assertTrue(selenium.isElementNotPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace("Thumb Down"));
		selenium.waitForText("//div[@class='taglib-ratings thumbs']/div/div/div",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText(
				"//div[@class='taglib-ratings thumbs']/div/div/div"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertTrue(selenium.isVisible(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
		assertTrue(selenium.isElementNotPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		assertTrue(selenium.isElementNotPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
	}
}