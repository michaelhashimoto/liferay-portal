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

package com.liferay.portalweb.portlet.wiki.comment.ratefrontpagecomment;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RateFrontPageCommentTest extends BaseTestCase {
	public void testRateFrontPageComment() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Wiki Test Page");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[3]/div/div[2]/div/div/div/div"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[1]",
			RuntimeVariables.replace(""));
		selenium.waitForText("//div[3]/div/div[2]/div/div/div/div",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText("//div[3]/div/div[2]/div/div/div/div"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[1]",
			RuntimeVariables.replace(""));
		selenium.waitForText("//div[3]/div/div[2]/div/div/div/div",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[3]/div/div[2]/div/div/div/div"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace(""));
		selenium.waitForText("//div[3]/div/div[2]/div/div/div/div",
			"-1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText("//div[3]/div/div[2]/div/div/div/div"));
		selenium.clickAt("//div[@class='taglib-ratings thumbs']/div/div/a[2]",
			RuntimeVariables.replace(""));
		selenium.waitForText("//div[3]/div/div[2]/div/div/div/div",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[3]/div/div[2]/div/div/div/div"));
	}
}