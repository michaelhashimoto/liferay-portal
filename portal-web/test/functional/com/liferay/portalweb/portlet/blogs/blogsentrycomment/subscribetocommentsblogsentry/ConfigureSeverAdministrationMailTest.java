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

package com.liferay.portalweb.portlet.blogs.blogsentrycomment.subscribetocommentsblogsentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigureSeverAdministrationMailTest extends BaseTestCase {
	public void testConfigureSeverAdministrationMail()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Server Administration",
			RuntimeVariables.replace("Server Administration"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Mail", RuntimeVariables.replace("Mail"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_137_pop3Host']",
			RuntimeVariables.replace("pop.gmail.com"));
		selenium.type("//input[@id='_137_pop3Port']",
			RuntimeVariables.replace("995"));
		selenium.clickAt("//input[@id='_137_pop3SecureCheckbox']",
			RuntimeVariables.replace("Use a Secure Network Connection"));
		selenium.type("//input[@id='_137_pop3User']",
			RuntimeVariables.replace("liferay.qa.server.trunk@gmail.com"));
		selenium.type("//input[@id='_137_pop3Password']",
			RuntimeVariables.replace("loveispatient"));
		selenium.type("//input[@id='_137_smtpHost']",
			RuntimeVariables.replace("smtp.gmail.com"));
		selenium.type("//input[@id='_137_smtpPort']",
			RuntimeVariables.replace("465"));
		selenium.clickAt("//input[@id='_137_smtpSecureCheckbox']",
			RuntimeVariables.replace("Use a Secure Network Connection"));
		selenium.type("//input[@id='_137_smtpUser']",
			RuntimeVariables.replace("liferay.qa.server.trunk@gmail.com"));
		selenium.type("//input[@id='_137_smtpPassword']",
			RuntimeVariables.replace("loveispatient"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}