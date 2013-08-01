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

package com.liferay.portalweb.socialofficeprofile.profile.sousaddaddressprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_AddAddressProfileTest extends BaseTestCase {
	public void testSOUs_AddAddressProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace(
				"To complete your profile, please add:"),
			selenium.getText("//p[@class='portlet-msg portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Addresses"),
			selenium.getText("//li[@data-title='Addresses']"));
		selenium.clickAt("//li[@data-title='Addresses']",
			RuntimeVariables.replace("Addresses"));
		selenium.waitForVisible("//input[contains(@id,'addressStreet1')]");
		Thread.sleep(1000);
		selenium.type("//input[contains(@id,'addressStreet1')]",
			RuntimeVariables.replace("123 Liferay Ln."));
		selenium.select("//select[contains(@id,'addressCountry')]",
			RuntimeVariables.replace("label=United States"));
		selenium.waitForPartialText("//select[contains(@id,'addressRegion')]",
			"California");
		selenium.select("//select[contains(@id,'addressRegion')]",
			RuntimeVariables.replace("label=California"));
		selenium.type("//input[contains(@id,'addressZip')]",
			RuntimeVariables.replace("91234"));
		selenium.type("//input[contains(@id,'addressCity')]",
			RuntimeVariables.replace("Ray of Light"));
		selenium.select("//select[contains(@id,'addressType')]",
			RuntimeVariables.replace("label=Personal"));
		selenium.clickAt("//input[contains(@id,'addressMailing0Checkbox')]",
			RuntimeVariables.replace("Mailing Checkbox"));
		selenium.clickAt("//input[contains(@id,'addressPrimary')]",
			RuntimeVariables.replace("Primary Button"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//div[@data-title='Addresses']/h3");
		assertEquals(RuntimeVariables.replace("Addresses:"),
			selenium.getText("//div[@data-title='Addresses']/h3"));
		assertEquals(RuntimeVariables.replace(
				"Personal 123 Liferay Ln., Ray of Light, 91234, California, United States (Mailing)"),
			selenium.getText("//div[@data-title='Addresses']/ul/li"));
	}
}