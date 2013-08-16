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

package com.liferay.portalweb.socialofficesite.home.announcement.sousaddannouncementsentrysitesite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_SelectTimeZonePacificStandardTimeCPMATest extends BaseTestCase {
	public void testSOUs_SelectTimeZonePacificStandardTimeCPMA()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");

				boolean socialOfficeSignOutPresent = selenium.isElementPresent(
						"//li[@id='_145_userMenu']");

				if (!socialOfficeSignOutPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/liferay/dockbar_underlay.js')]");
				assertTrue(selenium.isVisible("//li[@id='_145_userMenu']"));
				selenium.mouseOver("//li[@id='_145_userMenu']");

			case 2:
				selenium.waitForVisible("link=My Account");
				selenium.clickAt("link=My Account",
					RuntimeVariables.replace("My Account"));
				selenium.waitForVisible(
					"//iframe[contains(@class,'aui-dialog-iframe-node')]");
				selenium.selectFrame(
					"//iframe[contains(@class,'aui-dialog-iframe-node')]");
				selenium.waitForVisible("//a[@id='_2_displaySettingsLink']");
				selenium.clickAt("//a[@id='_2_displaySettingsLink']",
					RuntimeVariables.replace("Display Settings"));
				selenium.waitForElementPresent(
					"//div[@id='_2_displaySettings' and contains(@class,'selected')]");
				selenium.waitForVisible("//select[@name='_2_timeZoneId']");
				selenium.select("//select[@name='_2_timeZoneId']",
					RuntimeVariables.replace(
						"(UTC -08:00) Pacific Standard Time"));
				assertEquals("(UTC -08:00) Pacific Standard Time",
					selenium.getSelectedLabel("//select[@name='_2_timeZoneId']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertEquals("(UTC -08:00) Pacific Standard Time",
					selenium.getSelectedLabel("//select[@name='_2_timeZoneId']"));
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}