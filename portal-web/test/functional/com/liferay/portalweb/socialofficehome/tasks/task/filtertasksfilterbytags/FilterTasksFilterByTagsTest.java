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

package com.liferay.portalweb.socialofficehome.tasks.task.filtertasksfilterbytags;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class FilterTasksFilterByTagsTest extends BaseTestCase {
	public void testFilterTasksFilterByTags() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//nav/ul/li[contains(.,'Tasks')]/a/span",
			RuntimeVariables.replace("Tasks"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Tasks"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Tasks')]"));
		assertEquals(RuntimeVariables.replace("Assigned to Me"),
			selenium.getText("link=Assigned to Me"));
		selenium.clickAt("link=Assigned to Me",
			RuntimeVariables.replace("Assigned to Me"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Portal Task Description"),
			selenium.getText("//td[1]/div[1]/a"));
		assertTrue(selenium.isPartialText("//td[1]/div[2]/span[1]",
				"Site: Liferay"));
		assertEquals(RuntimeVariables.replace("Task Description"),
			selenium.getText("//tr[4]/td[1]/div[1]/a"));
		assertTrue(selenium.isVisible("//a[@class='filter-tasks']"));
		selenium.clickAt("//a[@class='filter-tasks']",
			RuntimeVariables.replace("Filter"));
		selenium.waitForVisible("//h3[contains(.,'Filter by Tags')]");
		assertEquals(RuntimeVariables.replace("Filter by Tags"),
			selenium.getText("//h3[contains(.,'Filter by Tags')]"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("portaltag1"),
			selenium.getText("//span/a[contains(.,'portaltag1')]"));
		selenium.clickAt("//span/a[contains(.,'portaltag1')]",
			RuntimeVariables.replace("portaltag1"));
		selenium.waitForElementNotPresent("//tr[4]/td[1]/div[1]/a");
		assertTrue(selenium.isElementNotPresent("//tr[4]/td[1]/div[1]/a"));
		assertEquals(RuntimeVariables.replace("Portal Task Description"),
			selenium.getText("//td[1]/div[1]/a"));
		assertTrue(selenium.isPartialText("//td[1]/div[2]/span[1]",
				"Site: Liferay"));
		assertEquals(RuntimeVariables.replace("portaltag1"),
			selenium.getText("//span/a[contains(.,'portaltag1')]"));
		selenium.clickAt("//span/a[contains(.,'portaltag1')]",
			RuntimeVariables.replace("portaltag1"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Portal Task Description"),
			selenium.getText("//td[1]/div[1]/a"));
		assertTrue(selenium.isPartialText("//td[1]/div[2]/span[1]",
				"Site: Liferay"));
		assertEquals(RuntimeVariables.replace("Task Description"),
			selenium.getText("//tr[4]/td[1]/div[1]/a"));
		assertEquals(RuntimeVariables.replace("tag1"),
			selenium.getText("//span/a[.='tag1']"));
		selenium.clickAt("//span/a[.='tag1']", RuntimeVariables.replace("tag1"));
		selenium.waitForText("//td[1]/div[1]/a", "Task Description");
		assertEquals(RuntimeVariables.replace("Task Description"),
			selenium.getText("//td[1]/div[1]/a"));
		assertNotEquals(RuntimeVariables.replace("Site: Liferay"),
			selenium.getText("//td[1]/div[2]/span[1]"));
		assertTrue(selenium.isElementNotPresent("//tr[4]/td[1]/div[1]/a"));
	}
}