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

package com.liferay.portalweb.socialofficeprofile.profile.souseditphonenumbernullprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_EditPhoneNumberNullProfileTest extends BaseTestCase {
	public void testSOUs_EditPhoneNumberNullProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("Phones:"),
			selenium.getText("//div[@data-title='Phone Numbers']/h3"));
		assertEquals(RuntimeVariables.replace("Business"),
			selenium.getText("//div[@data-title='Phone Numbers']/ul/li/span"));
		assertEquals(RuntimeVariables.replace("123-123-1234 123"),
			selenium.getText("//div[@data-title='Phone Numbers']/ul/li/span[2]"));
		selenium.clickAt("//div[@data-title='Phone Numbers']",
			RuntimeVariables.replace("Phones:"));
		selenium.waitForVisible("//input[contains(@id,'phoneNumber')]");
		selenium.type("//input[contains(@id,'phoneNumber')]",
			RuntimeVariables.replace(""));
		selenium.type("//input[contains(@id,'phoneExtension')]",
			RuntimeVariables.replace(""));
		selenium.select("//select[contains(@id,'phoneType')]",
			RuntimeVariables.replace("Personal"));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//li[@data-title='Phone Numbers']");
		assertEquals(RuntimeVariables.replace("Phones"),
			selenium.getText("//li[@data-title='Phone Numbers']"));
		assertFalse(selenium.isTextPresent("Phones:"));
		assertFalse(selenium.isTextPresent("Business"));
		assertFalse(selenium.isTextPresent("123-123-1234 123"));
	}
}