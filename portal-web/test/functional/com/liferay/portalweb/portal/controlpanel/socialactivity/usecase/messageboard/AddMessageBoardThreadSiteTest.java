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

package com.liferay.portalweb.portal.controlpanel.socialactivity.usecase.messageboard;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMessageBoardThreadSiteTest extends BaseTestCase {
	public void testAddMessageBoardThreadSite() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/site-name/");
				selenium.clickAt("link=Message Boards Test Page",
					RuntimeVariables.replace("Message Boards Test Page"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//input[@value='Post New Thread']",
					RuntimeVariables.replace("Post New Thread"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_19_subject']",
					RuntimeVariables.replace("MB Thread Message Subject"));
				Thread.sleep(1000);
				selenium.waitForVisible(
					"//iframe[contains(@title,'Rich text editor')]");
				selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
					RuntimeVariables.replace("MB Thread Message Body"));

				boolean subscribeMeCheckbox = selenium.isChecked(
						"//input[@id='_19_subscribeCheckbox']");

				if (!subscribeMeCheckbox) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_19_subscribeCheckbox']",
					RuntimeVariables.replace("Subscribe Me Checkbox"));

			case 2:
				assertFalse(selenium.isChecked(
						"//input[@id='_19_subscribeCheckbox']"));
				selenium.clickAt("//input[@value='Publish']",
					RuntimeVariables.replace("Publish"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertEquals(RuntimeVariables.replace(
						"MB Thread Message Subject"),
					selenium.getText("//h1[@class='header-title']/span"));
				assertEquals(RuntimeVariables.replace("MB Thread Message Body"),
					selenium.getText("//div[@class='thread-body']"));

			case 100:
				label = -1;
			}
		}
	}
}