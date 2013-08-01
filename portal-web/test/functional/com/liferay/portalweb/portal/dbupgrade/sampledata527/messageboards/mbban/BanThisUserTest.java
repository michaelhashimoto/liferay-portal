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

package com.liferay.portalweb.portal.dbupgrade.sampledata527.messageboards.mbban;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class BanThisUserTest extends BaseTestCase {
	public void testBanThisUser() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/mb-ban-community/message-boards-test-page/");
		selenium.waitForVisible("link=Message Boards Test Page");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Ban Category"),
			selenium.getText("//b"));
		selenium.clickAt("//b", RuntimeVariables.replace("MB Ban Category"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Ban Thread"),
			selenium.getText("//td[1]/a"));
		selenium.clickAt("//td[1]/a", RuntimeVariables.replace("MB Ban Thread"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Ban this User"),
			selenium.getText("//span[3]/a[2]"));
		selenium.clickAt("//span[3]/a[2]",
			RuntimeVariables.replace("Ban this User"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}