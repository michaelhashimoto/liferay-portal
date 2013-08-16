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

package com.liferay.portalweb.plugins.testevent.event.sendevent;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SendEventTest extends BaseTestCase {
	public void testSendEvent() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Event Producer Test Page",
			RuntimeVariables.replace("Event Producer Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Send Event"),
			selenium.getText("//div[@class='portlet-body']/a"));
		selenium.clickAt("//div[@class='portlet-body']/a",
			RuntimeVariables.replace("Send Event"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Event Consumer"),
			selenium.getText("//span[@class='portlet-title-text']"));
		assertEquals(RuntimeVariables.replace("PASSED"),
			selenium.getText("//div[@class='portlet-content']"));
	}
}