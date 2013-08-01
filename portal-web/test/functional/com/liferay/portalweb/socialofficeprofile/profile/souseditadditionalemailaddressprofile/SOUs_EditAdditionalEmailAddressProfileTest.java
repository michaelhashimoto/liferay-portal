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

package com.liferay.portalweb.socialofficeprofile.profile.souseditadditionalemailaddressprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_EditAdditionalEmailAddressProfileTest extends BaseTestCase {
	public void testSOUs_EditAdditionalEmailAddressProfile()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("Additional Email Addresses:"),
			selenium.getText(
				"//div[@data-title='Additional Email Addresses']/h3"));
		assertEquals(RuntimeVariables.replace("Email Address"),
			selenium.getText(
				"//div[@data-title='Additional Email Addresses']/ul/li/span"));
		assertEquals(RuntimeVariables.replace("socialoffice02@liferay.com"),
			selenium.getText(
				"//div[@data-title='Additional Email Addresses']/ul/li/span[2]/a"));
		selenium.clickAt("//div[@data-title='Additional Email Addresses']",
			RuntimeVariables.replace("Edit"));
		selenium.waitForVisible(
			"//span[contains(.,'Email Address')]/span/input");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/auto_fields.js')]");
		selenium.type("//span[contains(.,'Email Address')]/span/input",
			RuntimeVariables.replace("socialoffice02edit@liferay.com"));
		selenium.clickAt("//input[contains(@id,'emailAddressPrimary')]",
			RuntimeVariables.replace("Primary"));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForText("//div[@data-title='Additional Email Addresses']/ul/li/span[2]/a",
			"socialoffice02edit@liferay.com");
		assertEquals(RuntimeVariables.replace("Additional Email Addresses:"),
			selenium.getText(
				"//div[@data-title='Additional Email Addresses']/h3"));
		assertEquals(RuntimeVariables.replace("Email Address"),
			selenium.getText(
				"//div[@data-title='Additional Email Addresses']/ul/li/span"));
		assertEquals(RuntimeVariables.replace("socialoffice02edit@liferay.com"),
			selenium.getText(
				"//div[@data-title='Additional Email Addresses']/ul/li/span[2]/a"));
	}
}