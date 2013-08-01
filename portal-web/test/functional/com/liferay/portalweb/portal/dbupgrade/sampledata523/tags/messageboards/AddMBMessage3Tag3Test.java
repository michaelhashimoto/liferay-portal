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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.tags.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMBMessage3Tag3Test extends BaseTestCase {
	public void testAddMBMessage3Tag3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Communities",
			RuntimeVariables.replace("Communities"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Tags Message Board Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row']/td[1]/a",
			RuntimeVariables.replace("Public Pages - Live (1)"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace("Message Boards Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row']/td/a",
			RuntimeVariables.replace("Category Test"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Post New Thread']",
			RuntimeVariables.replace("Post New Thread"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_19_subject']",
			RuntimeVariables.replace("Message3 Tag3 Test3"));
		selenium.type("//textarea[@id='_19_textArea']",
			RuntimeVariables.replace("This is a message3 tag3 test3."));
		selenium.type("//tr[11]/td[2]/input[2]",
			RuntimeVariables.replace("selenium3"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Message3 Tag3 Test3"),
			selenium.getText("//div[@class='subject']/a/b"));
		assertEquals(RuntimeVariables.replace("selenium3"),
			selenium.getText("//span[@class='tag']"));
		assertEquals(RuntimeVariables.replace("This is a message3 tag3 test3."),
			selenium.getText("//div[@class='thread-body']"));
	}
}