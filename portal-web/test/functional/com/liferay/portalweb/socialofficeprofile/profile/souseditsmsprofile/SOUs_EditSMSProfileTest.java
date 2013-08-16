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

package com.liferay.portalweb.socialofficeprofile.profile.souseditsmsprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_EditSMSProfileTest extends BaseTestCase {
	public void testSOUs_EditSMSProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("SMS:"),
			selenium.getText("//div[@data-title='SMS']/h3"));
		assertEquals(RuntimeVariables.replace("socialoffice01@liferay.com"),
			selenium.getText("//div[@data-title='SMS']/ul/li"));
		selenium.clickAt("//div[@data-title='SMS']",
			RuntimeVariables.replace("SMS:"));
		selenium.waitForVisible("//input[contains(@id,'smsSn')]");
		selenium.type("//input[contains(@id,'smsSn')]",
			RuntimeVariables.replace("socialoffice01edit@liferay.com"));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForText("//div[@data-title='SMS']/ul/li",
			"socialoffice01edit@liferay.com");
		assertEquals(RuntimeVariables.replace("SMS:"),
			selenium.getText("//div[@data-title='SMS']/h3"));
		assertEquals(RuntimeVariables.replace("socialoffice01edit@liferay.com"),
			selenium.getText("//div[@data-title='SMS']/ul/li"));
	}
}