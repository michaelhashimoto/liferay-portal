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

package com.liferay.portalweb.portal.ldap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddLDAPServerTest extends BaseTestCase {
	public void testAddLDAPServer() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//a[@id='_130_authenticationLink']", "Authentication"));
		selenium.clickAt("//a[@id='_130_authenticationLink']",
			RuntimeVariables.replace("Authentication"));
		selenium.waitForVisible("link=LDAP");
		selenium.clickAt("link=LDAP", RuntimeVariables.replace("LDAP"));
		selenium.waitForVisible("//input[@value='Add']");
		selenium.clickAt("//input[@value='Add']",
			RuntimeVariables.replace("Add"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_130_ldap.server.name.0']",
			RuntimeVariables.replace("Test LDAP 1"));
		selenium.clickAt("//input[@name='_130_defaultLdap' and @value='apache']",
			RuntimeVariables.replace("Apache Directory Server"));
		assertTrue(selenium.isChecked(
				"//input[@name='_130_defaultLdap' and @value='apache']"));
		selenium.click("//input[@value='Reset Values']");
		selenium.type("//input[@id='_130_ldap.base.provider.url.0']",
			RuntimeVariables.replace("ldap://localhost:10389"));
		selenium.type("//input[@id='_130_ldap.base.dn.0']",
			RuntimeVariables.replace("dc=example,dc=com"));
		selenium.type("//input[@id='_130_ldap.security.principal.0']",
			RuntimeVariables.replace("uid=admin,ou=system"));
		selenium.type("//input[@id='_130_ldap.security.credentials.0']",
			RuntimeVariables.replace("secret"));
		selenium.type("//input[@id='_130_ldap.auth.search.filter.0']",
			RuntimeVariables.replace("(mail=@email_address@)"));
		selenium.type("//input[@id='_130_ldap.import.user.search.filter.0']",
			RuntimeVariables.replace("(objectClass=person)"));
		selenium.type("//input[@id='_130_userMappingScreenName']",
			RuntimeVariables.replace("cn"));
		selenium.type("//input[@id='_130_userMappingPassword']",
			RuntimeVariables.replace("userPassword"));
		selenium.type("//input[@id='_130_userMappingEmailAddress']",
			RuntimeVariables.replace("mail"));
		selenium.type("//input[@id='_130_userMappingFullName']",
			RuntimeVariables.replace(""));
		selenium.type("//input[@id='_130_userMappingFirstName']",
			RuntimeVariables.replace("givenName"));
		selenium.type("//input[@id='_130_userMappingMiddleName']",
			RuntimeVariables.replace(""));
		selenium.type("//input[@id='_130_userMappingLastName']",
			RuntimeVariables.replace("sn"));
		selenium.type("//input[@id='_130_userMappingJobTitle']",
			RuntimeVariables.replace(""));
		selenium.type("//input[@id='_130_userMappingGroup']",
			RuntimeVariables.replace("businessCategory"));
		selenium.type("//input[@id='_130_userMappingUuid']",
			RuntimeVariables.replace(""));
		selenium.type("//input[@id='_130_ldap.import.group.search.filter.0']",
			RuntimeVariables.replace("(objectClass=groupOfUniqueNames)"));
		selenium.type("//input[@id='_130_groupMappingGroupName']",
			RuntimeVariables.replace("cn"));
		selenium.type("//input[@id='_130_groupMappingDescription']",
			RuntimeVariables.replace(""));
		selenium.type("//input[@id='_130_groupMappingUser']",
			RuntimeVariables.replace("businessCategory"));
		selenium.type("//input[@id='_130_ldap.users.dn.0']",
			RuntimeVariables.replace("dc=example,dc=com,ou=users"));
		selenium.type("//input[@id='_130_ldap.user.default.object.classes.0']",
			RuntimeVariables.replace(""));
		selenium.type("//input[@id='_130_ldap.groups.dn.0']",
			RuntimeVariables.replace("dc=example,dc=com,ou=groups"));
		selenium.type("//input[@id='_130_ldap.group.default.object.classes.0']",
			RuntimeVariables.replace(""));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}