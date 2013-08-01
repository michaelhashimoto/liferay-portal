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

package com.liferay.portalweb.socialofficeprofile.profile.souseditsocialnetworknullprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_EditSocialNetworkNullProfileTest extends BaseTestCase {
	public void testSOUs_EditSocialNetworkNullProfile()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("Social Network:"),
			selenium.getText("//div[@data-title='Social Network']/h3"));
		assertEquals(RuntimeVariables.replace("Facebook"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'Facebook')]/span"));
		assertEquals(RuntimeVariables.replace("socialoffice01"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'Facebook')]/span[2]"));
		assertEquals(RuntimeVariables.replace("MySpace"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'MySpace')]/span"));
		assertEquals(RuntimeVariables.replace("socialoffice01"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'MySpace')]/span[2]"));
		assertEquals(RuntimeVariables.replace("Twitter"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'Twitter')]/span"));
		assertEquals(RuntimeVariables.replace("socialoffice01"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'Twitter')]/span[2]"));
		selenium.clickAt("//div[@data-title='Social Network']",
			RuntimeVariables.replace("Social Network"));
		selenium.waitForVisible("//input[contains(@id,'facebookSn')]");
		selenium.type("//input[contains(@id,'facebookSn')]",
			RuntimeVariables.replace(""));
		selenium.type("//input[contains(@id,'mySpaceSn')]",
			RuntimeVariables.replace(""));
		selenium.type("//input[contains(@id,'twitterSn')]",
			RuntimeVariables.replace(""));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//li[@data-title='Social Network']");
		assertEquals(RuntimeVariables.replace("Social Network"),
			selenium.getText("//li[@data-title='Social Network']"));
		assertFalse(selenium.isTextPresent("Social Network:"));
		assertFalse(selenium.isTextPresent("Facebook"));
		assertFalse(selenium.isTextPresent("MySpace"));
		assertFalse(selenium.isTextPresent("Twitter"));
	}
}