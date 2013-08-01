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

package com.liferay.portalweb.socialofficehome.navigation.links.viewlinktasks;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewLinkTasksTest extends BaseTestCase {
	public void testViewLinkTasks() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible("//nav/ul/li[contains(.,'Tasks')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Tasks')]/a/span",
			RuntimeVariables.replace("Tasks"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Tasks"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Tasks')]"));
		assertEquals(RuntimeVariables.replace("Assigned to Me"),
			selenium.getText("link=Assigned to Me"));
		assertEquals(RuntimeVariables.replace("I Have Created"),
			selenium.getText("link=I Have Created"));
		assertEquals(RuntimeVariables.replace("Add Task"),
			selenium.getText("link=Add Task"));
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText("link=Permissions"));
		assertEquals(RuntimeVariables.replace("No tasks were found."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		assertTrue(selenium.isVisible("//div/input[1]"));
		assertEquals(RuntimeVariables.replace("Liferay, Inc."),
			selenium.getText("//li/span[2]/a"));
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//li[2]/span[2]/a"));
	}
}