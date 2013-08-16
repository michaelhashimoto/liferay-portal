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

package com.liferay.portalweb.asset.documentsandmedia.dmdocumentcomment.ratedmfolderdocumentcommentap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RateDMFolderDocumentCommentAPTest extends BaseTestCase {
	public void testRateDMFolderDocumentCommentAP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForPartialText("//div[@class='aui-rating-label-element']",
			"0 Votes");
		assertTrue(selenium.isPartialText(
				"//div[@class='aui-rating-label-element']", "0 Votes"));
		selenium.clickAt("//div[2]/div/div/div/a",
			RuntimeVariables.replace("Rate this as good."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"+1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("+1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up aui-rating-element-on']"));
		selenium.clickAt("//div/a[2]",
			RuntimeVariables.replace("Rate this as bad."));
		selenium.waitForText("//div[@class='aui-rating-label-element']",
			"-1 (1 Vote)");
		assertEquals(RuntimeVariables.replace("-1 (1 Vote)"),
			selenium.getText("//div[@class='aui-rating-label-element']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down aui-rating-element-on']"));
		selenium.clickAt("//div/a[2]",
			RuntimeVariables.replace("Rate this as bad."));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-up']"));
		assertTrue(selenium.isElementPresent(
				"//a[@class='aui-rating-element aui-rating-element-off aui-rating-thumb-down']"));
	}
}