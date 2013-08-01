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

package com.liferay.portalweb.socialofficeprofile.profile.souseditexpertisenullprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_EditExpertiseNullProfileTest extends BaseTestCase {
	public void testSOUs_EditExpertiseNullProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("Expertise Title:"),
			selenium.getText("//div[@data-title='Projects']/div/h3"));
		assertEquals(RuntimeVariables.replace("01 Jan 2012 - Current"),
			selenium.getText("//div[@class='project-date property-list']"));
		assertEquals(RuntimeVariables.replace("Expertise Description"),
			selenium.getText(
				"//div[@class='project-description property-list']"));
		selenium.clickAt("//div[@data-title='Projects']",
			RuntimeVariables.replace("Projects"));
		selenium.waitForVisible(
			"//input[contains(@id,'_2_projectsEntryTitle0')]");
		selenium.type("//input[contains(@id,'_2_projectsEntryTitle0')]",
			RuntimeVariables.replace(""));
		selenium.waitForVisible(
			"//textarea[@id='_2_projectsEntryDescription0']");
		selenium.type("//textarea[@id='_2_projectsEntryDescription0']",
			RuntimeVariables.replace(""));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//li[@data-title='Projects']");
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//li[@data-title='Projects']"));
		assertFalse(selenium.isTextPresent("Expertise Title"));
		assertFalse(selenium.isTextPresent("01 Jan 2012 - Current"));
		assertFalse(selenium.isTextPresent("Expertise Description"));
	}
}