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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RatePage1BlogsEntry1Test extends BaseTestCase {
	public void testRatePage1BlogsEntry1() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/blogs-page-scope-community/");
		selenium.clickAt("link=Blogs Test Page1",
			RuntimeVariables.replace("Blogs Test Page1"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.waitForText("//span[@class='portlet-title-text']", "Blogs");
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//span[@class='portlet-title-text']"));
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Title"),
			selenium.getText("//div[@class='entry-title']/h2/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Content"),
			selenium.getText("//div[@class='entry-body']/p"));
		assertTrue(selenium.isPartialText(
				"//div[@class='taglib-ratings stars']/div[2]/div/div", "0 Votes"));
		selenium.clickAt("//a[4]", RuntimeVariables.replace("4 Star"));
		selenium.waitForPartialText("//div[@class='taglib-ratings stars']/div[2]/div/div",
			"1 Vote");
		assertTrue(selenium.isPartialText(
				"//div[@class='taglib-ratings stars']/div[2]/div/div", "1 Vote"));
		assertTrue(selenium.isVisible(
				"xPath=(//img[contains(@class,'aui-rating-element-on')])[4]"));
		assertTrue(selenium.isVisible(
				"xPath=(//a[contains(@class,'aui-rating-element-on')])[4]"));
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//img[contains(@class,'aui-rating-element-on')])[5]"));
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//a[contains(@class,'aui-rating-element-on')])[5]"));
	}
}