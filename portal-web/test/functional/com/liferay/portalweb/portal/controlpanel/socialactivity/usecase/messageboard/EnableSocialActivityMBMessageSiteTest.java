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
public class EnableSocialActivityMBMessageSiteTest extends BaseTestCase {
	public void testEnableSocialActivityMBMessageSite()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/site-name/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Social Activity",
					RuntimeVariables.replace("Social Activity"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible(
					"//input[@id='_179_com.liferay.portlet.messageboards.model.MBMessage.enabledCheckbox']");

				boolean messageBoardsMessageEnabled = selenium.isChecked(
						"//input[@id='_179_com.liferay.portlet.messageboards.model.MBMessage.enabledCheckbox']");

				if (messageBoardsMessageEnabled) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_179_com.liferay.portlet.messageboards.model.MBMessage.enabledCheckbox']",
					RuntimeVariables.replace("MBMessage"));

			case 2:
				assertTrue(selenium.isChecked(
						"//input[@id='_179_com.liferay.portlet.messageboards.model.MBMessage.enabledCheckbox']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertTrue(selenium.isChecked(
						"//input[@id='_179_com.liferay.portlet.messageboards.model.MBMessage.enabledCheckbox']"));

			case 100:
				label = -1;
			}
		}
	}
}