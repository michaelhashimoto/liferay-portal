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

package com.liferay.portalweb.portlet.wikidisplay.comment.ratewdfrontpagecomment;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RateWDFrontPageCommentTest extends BaseTestCase {
	public void testRateWDFrontPageComment() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace("Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[contains(@id,'ratingThumbContent')]/div"));
		Thread.sleep(1000);
		selenium.clickAt("//div[contains(@id,'ratingThumbContent')]/a[contains(@class,'thumb-down')]",
			RuntimeVariables.replace("Thumb Down"));
		selenium.waitForText("//div[contains(@id,'ratingThumbContent')]/div",
			"-1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText("//div[contains(@id,'ratingThumbContent')]/div"));
		selenium.clickAt("//div[contains(@id,'ratingThumbContent')]/a[contains(@class,'thumb-down')]",
			RuntimeVariables.replace("Thumb Down"));
		Thread.sleep(1000);
		selenium.waitForText("//div[contains(@id,'ratingThumbContent')]/div",
			"0 (0 Votes)");
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[contains(@id,'ratingThumbContent')]/div"));
		selenium.clickAt("//div[contains(@id,'ratingThumbContent')]/a[contains(@class,'thumb-up')]",
			RuntimeVariables.replace("Thumb Up"));
		selenium.waitForText("//div[contains(@id,'ratingThumbContent')]/div",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText("//div[contains(@id,'ratingThumbContent')]/div"));
	}
}