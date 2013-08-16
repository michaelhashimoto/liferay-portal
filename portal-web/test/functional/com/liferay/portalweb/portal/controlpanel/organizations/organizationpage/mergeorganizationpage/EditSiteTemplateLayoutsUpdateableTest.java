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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationpage.mergeorganizationpage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditSiteTemplateLayoutsUpdateableTest extends BaseTestCase {
	public void testEditSiteTemplateLayoutsUpdateable()
		throws Exception {
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
				selenium.clickAt("link=Site Templates",
					RuntimeVariables.replace("Site Templates"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//span[@title='Actions']/ul/li/strong/a/span"));
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Edit')]/a");
				assertEquals(RuntimeVariables.replace("Edit"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Edit')]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Edit')]/a"));
				selenium.waitForPageToLoad("30000");

				boolean layoutsUpdateableChecked = selenium.isChecked(
						"_149_layoutsUpdateableCheckbox");

				if (layoutsUpdateableChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_149_layoutsUpdateableCheckbox']",
					RuntimeVariables.replace(
						"Allow Site Administrators to Modify the Pages Associated with This Site Template Set this to allow site administrators to add, remove, or configure applications and change page properties. If site administrators modify a page, changes to the original site template page are no longer propagated. If this option is set, it is possible to disallow modifications from specific pages through the page management tool."));

			case 2:
				assertTrue(selenium.isChecked(
						"//input[@id='_149_layoutsUpdateableCheckbox']"));
				assertEquals(RuntimeVariables.replace(
						"Allow Site Administrators to Modify the Pages Associated with This Site Template Set this to allow site administrators to add, remove, or configure applications and change page properties. If site administrators modify a page, changes to the original site template page are no longer propagated. If this option is set, it is possible to disallow modifications from specific pages through the page management tool."),
					selenium.getText(
						"//label[@for='_149_layoutsUpdateableCheckbox']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 100:
				label = -1;
			}
		}
	}
}