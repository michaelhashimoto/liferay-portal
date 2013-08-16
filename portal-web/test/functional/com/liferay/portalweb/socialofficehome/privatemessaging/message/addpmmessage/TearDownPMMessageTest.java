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

package com.liferay.portalweb.socialofficehome.privatemessaging.message.addpmmessage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownPMMessageTest extends BaseTestCase {
	public void testTearDownPMMessage() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.waitForVisible(
					"//nav/ul/li[contains(.,'Messages')]/a/span");
				selenium.clickAt("//nav/ul/li[contains(.,'Messages')]/a/span",
					RuntimeVariables.replace("Messages"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Private Messaging"),
					selenium.getText(
						"xPath=(//span[@class='portlet-title-default'])[contains(.,'Private Messaging')]"));

				boolean message1Present = selenium.isElementPresent(
						"//td[1]/span/span/span/input[2]");

				if (!message1Present) {
					label = 2;

					continue;
				}

				selenium.clickAt("//td[1]/span/span/span/input[2]",
					RuntimeVariables.replace("Checkbox"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");

			case 2:

				boolean message2Present = selenium.isElementPresent(
						"//td[1]/span/span/span/input[2]");

				if (!message2Present) {
					label = 3;

					continue;
				}

				selenium.clickAt("//td[1]/span/span/span/input[2]",
					RuntimeVariables.replace("Checkbox"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");

			case 3:

				boolean message3Present = selenium.isElementPresent(
						"//td[1]/span/span/span/input[2]");

				if (!message3Present) {
					label = 4;

					continue;
				}

				selenium.clickAt("//td[1]/span/span/span/input[2]",
					RuntimeVariables.replace("Checkbox"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");

			case 4:

				boolean message4Present = selenium.isElementPresent(
						"//td[1]/span/span/span/input[2]");

				if (!message4Present) {
					label = 5;

					continue;
				}

				selenium.clickAt("//td[1]/span/span/span/input[2]",
					RuntimeVariables.replace("Checkbox"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");

			case 5:

				boolean message5Present = selenium.isElementPresent(
						"//td[1]/span/span/span/input[2]");

				if (!message5Present) {
					label = 6;

					continue;
				}

				selenium.clickAt("//td[1]/span/span/span/input[2]",
					RuntimeVariables.replace("Checkbox"));
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");

			case 6:
			case 100:
				label = -1;
			}
		}
	}
}