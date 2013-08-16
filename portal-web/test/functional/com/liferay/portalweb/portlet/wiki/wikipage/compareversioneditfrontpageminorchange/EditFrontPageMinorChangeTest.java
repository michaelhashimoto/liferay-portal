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

package com.liferay.portalweb.portlet.wiki.wikipage.compareversioneditfrontpageminorchange;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditFrontPageMinorChangeTest extends BaseTestCase {
	public void testEditFrontPageMinorChange() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Wiki Test Page",
					RuntimeVariables.replace("Wiki Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Wiki FrontPage Content"),
					selenium.getText("//div[@class='wiki-body']/p"));
				assertEquals(RuntimeVariables.replace("Edit"),
					selenium.getText("//span[contains(.,'Edit')]/a/span"));
				selenium.clickAt("//span[contains(.,'Edit')]/a/span",
					RuntimeVariables.replace("Edit"));
				Thread.sleep(1000);
				selenium.waitForVisible(
					"//iframe[contains(@title,'Rich text editor')]");
				selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
					RuntimeVariables.replace("Wiki FrontPage Content Edit"));

				boolean minorEditChecked = selenium.isChecked(
						"//input[@id='_36_minorEditCheckbox']");

				if (minorEditChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_36_minorEditCheckbox']",
					RuntimeVariables.replace("This is a minor edit."));

			case 2:
				selenium.clickAt("//input[@value='Publish']",
					RuntimeVariables.replace("Publish"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertEquals(RuntimeVariables.replace(
						"Wiki FrontPage Content Edit"),
					selenium.getText("//div[@class='wiki-body']/p"));
				assertNotEquals(RuntimeVariables.replace(
						"Wiki FrontPage Content"),
					selenium.getText("//div[@class='wiki-body']/p"));
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Wiki Test Page",
					RuntimeVariables.replace("Wiki Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Details"),
					selenium.getText("//div[3]/span[2]/a/span"));
				selenium.clickAt("//div[3]/span[2]/a/span",
					RuntimeVariables.replace("Details"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=History",
					RuntimeVariables.replace("History"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("1.2 (Minor Edit)"),
					selenium.getText("//tr[3]/td[4]/a"));
				assertEquals(RuntimeVariables.replace("1.1"),
					selenium.getText("//tr[4]/td[4]/a"));
				assertEquals(RuntimeVariables.replace("1.0 (Minor Edit)"),
					selenium.getText("//tr[5]/td[4]/a"));

			case 100:
				label = -1;
			}
		}
	}
}