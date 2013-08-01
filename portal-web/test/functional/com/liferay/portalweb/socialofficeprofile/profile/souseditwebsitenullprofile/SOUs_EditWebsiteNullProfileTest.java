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

package com.liferay.portalweb.socialofficeprofile.profile.souseditwebsitenullprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_EditWebsiteNullProfileTest extends BaseTestCase {
	public void testSOUs_EditWebsiteNullProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("Websites:"),
			selenium.getText("//div[@data-title='Websites']/h3"));
		assertEquals(RuntimeVariables.replace("Personal"),
			selenium.getText("//div[@data-title='Websites']/ul/li/span"));
		assertEquals(RuntimeVariables.replace("http://www.socialoffice01.com"),
			selenium.getText("//div[@data-title='Websites']/ul/li/span[2]"));
		selenium.clickAt("//div[@data-title='Websites']",
			RuntimeVariables.replace("Websites:"));
		selenium.waitForVisible("//input[contains(@id,'websiteUrl')]");
		selenium.type("//input[contains(@id,'websiteUrl')]",
			RuntimeVariables.replace(""));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//li[@data-title='Websites']");
		assertEquals(RuntimeVariables.replace("Websites"),
			selenium.getText("//li[@data-title='Websites']"));
		assertFalse(selenium.isTextPresent("Websites:"));
		assertFalse(selenium.isTextPresent("Personal"));
		assertFalse(selenium.isTextPresent("http://www.socialoffice01.com"));
	}
}