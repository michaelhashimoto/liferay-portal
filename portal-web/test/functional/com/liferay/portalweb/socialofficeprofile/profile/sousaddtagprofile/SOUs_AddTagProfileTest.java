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

package com.liferay.portalweb.socialofficeprofile.profile.sousaddtagprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_AddTagProfileTest extends BaseTestCase {
	public void testSOUs_AddTagProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace(
				"To complete your profile, please add:"),
			selenium.getText("//p[@class='portlet-msg portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Tags"),
			selenium.getText("//li[@data-title='Tags']"));
		selenium.clickAt("//li[@data-title='Tags']",
			RuntimeVariables.replace("Tags"));
		selenium.waitForVisible("//input[contains(@id,'TagNames')]");
		selenium.type("//input[contains(@id,'TagNames')]",
			RuntimeVariables.replace("tag1"));
		selenium.clickAt("//button[@id='add']", RuntimeVariables.replace("Add"));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//ul[@class='user-tags']/li/a");
		assertEquals(RuntimeVariables.replace("Tags"),
			selenium.getText("//div[@class='user-tags-title']"));
		assertEquals(RuntimeVariables.replace("tag1"),
			selenium.getText("//ul[@class='user-tags']/li/a"));
	}
}