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

package com.liferay.portalweb.socialofficeprofile.profile.sousviewdeleteprofilepicturemyaccountprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_DeleteProfilePictureMyAccountTest extends BaseTestCase {
	public void testSOUs_DeleteProfilePictureMyAccount()
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
				Thread.sleep(5000);
				selenium.waitForVisible("//a[contains(@id,'deleteLogoLink')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//a[contains(@id,'deleteLogoLink')]"));
				selenium.clickAt("//a[contains(@id,'deleteLogoLink')]",
					RuntimeVariables.replace("Delete"));
				Thread.sleep(1000);
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}