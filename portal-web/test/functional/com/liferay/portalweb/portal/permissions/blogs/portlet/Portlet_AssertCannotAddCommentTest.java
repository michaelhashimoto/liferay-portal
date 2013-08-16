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

package com.liferay.portalweb.portal.permissions.blogs.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Portlet_AssertCannotAddCommentTest extends BaseTestCase {
	public void testPortlet_AssertCannotAddComment() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Blogs Test Page",
					RuntimeVariables.replace("Blogs Test Page"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//div[@class='entry-title']/h2/a",
					RuntimeVariables.replace("Blogs Entry Title Temporary"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForText("//div[@class='lfr-panel-title']/span",
					"Comments");
				assertEquals(RuntimeVariables.replace("Comments"),
					selenium.getText("//div[@class='lfr-panel-title']/span"));

				boolean blogCommentsExpanded = selenium.isVisible(
						"//input[@class='form-text lfr-input-resource ']");

				if (blogCommentsExpanded) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[@class='lfr-panel-title']/span[contains(text(),'Comments')]",
					RuntimeVariables.replace(""));

			case 2:
				assertTrue(selenium.isElementNotPresent("link=Add Comment"));
				assertTrue(selenium.isElementNotPresent("link=Be the first."));

			case 100:
				label = -1;
			}
		}
	}
}