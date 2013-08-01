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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.expando.webcontent;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWebContentExpandoTest extends BaseTestCase {
	public void testViewWebContentExpando() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/expando-web-content-community/");
		selenium.waitForVisible("link=Web Content Display Page");
		selenium.clickAt("link=Web Content Display Page",
			RuntimeVariables.replace("Web Content Display Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("First Expando Bank"),
			selenium.getText("//div[@class='journal-content-article']/h1"));
		assertTrue(selenium.isElementPresent("//input[@value='Create Account']"));
		assertEquals(RuntimeVariables.replace("Michael"),
			selenium.getText("//td[2]"));
		assertEquals(RuntimeVariables.replace("Hashimoto"),
			selenium.getText("//td[3]"));
		assertEquals(RuntimeVariables.replace("$100.00"),
			selenium.getText("//td[4]"));
		assertEquals(RuntimeVariables.replace("JR"),
			selenium.getText("//tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("Houn"),
			selenium.getText("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("$1,000,000.00"),
			selenium.getText("//tr[3]/td[4]"));
		assertEquals(RuntimeVariables.replace("Michael"),
			selenium.getText("//tr[4]/td[2]"));
		assertEquals(RuntimeVariables.replace("Saechang"),
			selenium.getText("//tr[4]/td[3]"));
		assertEquals(RuntimeVariables.replace("$1,000,000.00"),
			selenium.getText("//tr[4]/td[4]"));
		assertTrue(selenium.isTextPresent("# of Accounts: 3"));
	}
}