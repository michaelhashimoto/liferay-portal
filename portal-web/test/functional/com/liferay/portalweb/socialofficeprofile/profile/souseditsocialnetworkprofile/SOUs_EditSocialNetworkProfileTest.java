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

package com.liferay.portalweb.socialofficeprofile.profile.souseditsocialnetworkprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_EditSocialNetworkProfileTest extends BaseTestCase {
	public void testSOUs_EditSocialNetworkProfile() throws Exception {
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
			RuntimeVariables.replace("socialoffice01edit"));
		selenium.type("//input[contains(@id,'mySpaceSn')]",
			RuntimeVariables.replace("socialoffice01edit"));
		selenium.type("//input[contains(@id,'twitterSn')]",
			RuntimeVariables.replace("socialoffice01edit"));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForText("//div[@data-title='Social Network']/ul/li[contains(.,'Twitter')]/span[2]",
			"socialoffice01edit");
		assertEquals(RuntimeVariables.replace("Social Network:"),
			selenium.getText("//div[@data-title='Social Network']/h3"));
		assertEquals(RuntimeVariables.replace("Facebook"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'Facebook')]/span"));
		assertEquals(RuntimeVariables.replace("socialoffice01edit"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'Facebook')]/span[2]"));
		assertEquals(RuntimeVariables.replace("MySpace"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'MySpace')]/span"));
		assertEquals(RuntimeVariables.replace("socialoffice01edit"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'MySpace')]/span[2]"));
		assertEquals(RuntimeVariables.replace("Twitter"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'Twitter')]/span"));
		assertEquals(RuntimeVariables.replace("socialoffice01edit"),
			selenium.getText(
				"//div[@data-title='Social Network']/ul/li[contains(.,'Twitter')]/span[2]"));
	}
}