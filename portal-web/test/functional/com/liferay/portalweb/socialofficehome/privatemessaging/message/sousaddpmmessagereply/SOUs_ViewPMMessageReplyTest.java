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

package com.liferay.portalweb.socialofficehome.privatemessaging.message.sousaddpmmessagereply;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewPMMessageReplyTest extends BaseTestCase {
	public void testSOUs_ViewPMMessageReply() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard");
		selenium.waitForVisible("//nav/ul/li[contains(.,'Messages')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Messages')]/a/span",
			RuntimeVariables.replace("Messages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Private Messaging"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Private Messaging')]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//span[@class='author-sender']"));
		assertEquals(RuntimeVariables.replace("Message Subject"),
			selenium.getText("//div[@class='subject']"));
		assertEquals(RuntimeVariables.replace("Message Subject Reply"),
			selenium.getText("//div[@class='body']"));
		assertEquals(RuntimeVariables.replace("Showing 1 result."),
			selenium.getText("//div[@class='search-results']"));
		selenium.clickAt("//div[@class='subject']",
			RuntimeVariables.replace("Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Message Subject"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Between Joe Bloggs And You"),
			selenium.getText(
				"//div[@class='aui-layout-content thread-info-content ']"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText(
				"xPath=(//span[@class='name'])[contains(.,'Joe Bloggs')]"));
		assertEquals(RuntimeVariables.replace("Message Body"),
			selenium.getText("xPath=(//div[@class='body'])[1]"));
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("xPath=(//span[@class='name'])[3]"));
		assertEquals(RuntimeVariables.replace("Message Subject Reply"),
			selenium.getText("xPath=(//div[@class='body'])[2]"));
	}
}