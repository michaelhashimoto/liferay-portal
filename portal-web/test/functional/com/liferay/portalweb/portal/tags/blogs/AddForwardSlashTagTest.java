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

package com.liferay.portalweb.portal.tags.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddForwardSlashTagTest extends BaseTestCase {
	public void testAddForwardSlashTag() throws Exception {
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
				assertEquals(RuntimeVariables.replace("Blogs Entry1 Title"),
					selenium.getText(
						"xPath=(//div[@class='entry-title']/h2/a)[3]"));
				selenium.clickAt("xPath=(//div[@class='entry-title']/h2/a)[3]",
					RuntimeVariables.replace("Blogs Entry1 Title"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Edit"),
					selenium.getText(
						"//a[@class='taglib-icon']/span[contains(.,'Edit')]"));
				selenium.click(RuntimeVariables.replace(
						"//a[@class='taglib-icon']/span[contains(.,'Edit')]"));
				selenium.waitForPageToLoad("30000");
				Thread.sleep(1000);
				selenium.waitForVisible(
					"//td[@id='cke_contents__33_editor']/iframe");

				boolean tagsVisible = selenium.isVisible(
						"//input[@class='lfr-tag-selector-input aui-field-input-text']");

				if (tagsVisible) {
					label = 2;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Categorization"),
					selenium.getText(
						"xPath=(//div[@class='lfr-panel-title'])[2]/span"));
				selenium.clickAt("xPath=(//div[@class='lfr-panel-title'])[2]/span",
					RuntimeVariables.replace("Categorization"));
				selenium.waitForVisible(
					"//input[@class='lfr-tag-selector-input aui-field-input-text']");
				assertTrue(selenium.isVisible(
						"//input[@class='lfr-tag-selector-input aui-field-input-text']"));

			case 2:
				selenium.sendKeys("//input[@class='lfr-tag-selector-input aui-field-input-text']",
					RuntimeVariables.replace("/test"));
				selenium.clickAt("//input[@value='Publish']",
					RuntimeVariables.replace("Publish"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertEquals(RuntimeVariables.replace("test"),
					selenium.getText(
						"//span[@class='taglib-asset-tags-summary']/a[2]"));
				assertTrue(selenium.isElementNotPresent(
						"//span[@class='entry-tags']/span/a[contains(.,'/test')]"));
				assertFalse(selenium.isTextPresent("/test"));

			case 100:
				label = -1;
			}
		}
	}
}