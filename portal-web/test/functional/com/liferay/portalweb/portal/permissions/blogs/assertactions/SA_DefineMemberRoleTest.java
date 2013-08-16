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

package com.liferay.portalweb.portal.permissions.blogs.assertactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_DefineMemberRoleTest extends BaseTestCase {
	public void testSA_DefineMemberRole() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Roles", RuntimeVariables.replace("Roles"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_128_keywords']",
					RuntimeVariables.replace("Member"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Member"),
					selenium.getText("//tr/td[1]/a[contains(.,'Member')]"));
				selenium.clickAt("//tr/td[1]/a[contains(.,'Member')]",
					RuntimeVariables.replace("Member"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Define Permissions"),
					selenium.getText(
						"//ul[@class='aui-tabview-list']/li/span/a[contains(.,'Define Permissions')]"));
				selenium.clickAt("//ul[@class='aui-tabview-list']/li/span/a[contains(.,'Define Permissions')]",
					RuntimeVariables.replace("Define Permissions"));
				selenium.waitForPageToLoad("30000");
				selenium.select("//select[@id='_128_add-permissions']",
					RuntimeVariables.replace("label=Blogs"));
				selenium.waitForPageToLoad("30000");

				boolean blogsEntryAddDiscussionChecked = selenium.isChecked(
						"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryADD_DISCUSSION']");

				if (blogsEntryAddDiscussionChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@value='com.liferay.portlet.blogs.model.BlogsEntryADD_DISCUSSION']",
					RuntimeVariables.replace("Blogs Entry Add Discussion"));

			case 2:
				assertTrue(selenium.isChecked(
						"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryADD_DISCUSSION']"));

				boolean blogsEntryViewChecked = selenium.isChecked(
						"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryVIEW']");

				if (blogsEntryViewChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("//input[@value='com.liferay.portlet.blogs.model.BlogsEntryVIEW']",
					RuntimeVariables.replace("Blogs Entry View"));

			case 3:
				assertTrue(selenium.isChecked(
						"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryVIEW']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"The role permissions were updated."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 100:
				label = -1;
			}
		}
	}
}