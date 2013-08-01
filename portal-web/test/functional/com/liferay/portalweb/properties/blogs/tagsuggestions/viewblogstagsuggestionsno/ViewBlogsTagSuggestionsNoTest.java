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

package com.liferay.portalweb.properties.blogs.tagsuggestions.viewblogstagsuggestionsno;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsTagSuggestionsNoTest extends BaseTestCase {
	public void testViewBlogsTagSuggestionsNo() throws Exception {
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
				selenium.clickAt("//input[@value='Add Blog Entry']",
					RuntimeVariables.replace("Add Blog Entry"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForElementPresent(
					"//textarea[@id='_33_editor' and @style='display: none;']");

				boolean categorizationCollapsed = selenium.isElementPresent(
						"//div[@id='blogsEntryCategorizationPanel' and contains(@class,'lfr-collapsed')]");

				if (!categorizationCollapsed) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[@id='blogsEntryCategorizationPanel']/div/div/span",
					RuntimeVariables.replace("Categorization"));

			case 2:
				selenium.waitForVisible("//input[@title='Add Tags']");
				assertTrue(selenium.isVisible("//input[@title='Add Tags']"));
				assertTrue(selenium.isElementNotPresent(
						"//button[@id='suggest']"));

			case 100:
				label = -1;
			}
		}
	}
}