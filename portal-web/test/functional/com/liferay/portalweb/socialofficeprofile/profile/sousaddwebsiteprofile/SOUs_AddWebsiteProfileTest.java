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

package com.liferay.portalweb.socialofficeprofile.profile.sousaddwebsiteprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_AddWebsiteProfileTest extends BaseTestCase {
	public void testSOUs_AddWebsiteProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace(
				"To complete your profile, please add:"),
			selenium.getText("//p[@class='portlet-msg portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Websites"),
			selenium.getText("//li[@data-title='Websites']"));
		selenium.clickAt("//li[@data-title='Websites']",
			RuntimeVariables.replace("Websites"));
		selenium.waitForVisible("//input[contains(@id,'websiteUrl')]");
		selenium.type("//input[contains(@id,'websiteUrl')]",
			RuntimeVariables.replace("http://www.socialoffice01.com"));
		selenium.select("//select[contains(@id,'websiteType')]",
			RuntimeVariables.replace("Personal"));
		selenium.clickAt("//input[contains(@id,'websitePrimary')]",
			RuntimeVariables.replace("Primary"));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//div[@data-title='Websites']/h3");
		assertEquals(RuntimeVariables.replace("Websites:"),
			selenium.getText("//div[@data-title='Websites']/h3"));
		assertEquals(RuntimeVariables.replace("Personal"),
			selenium.getText("//div[@data-title='Websites']/ul/li/span"));
		assertEquals(RuntimeVariables.replace("http://www.socialoffice01.com"),
			selenium.getText("//div[@data-title='Websites']/ul/li/span[2]"));
	}
}