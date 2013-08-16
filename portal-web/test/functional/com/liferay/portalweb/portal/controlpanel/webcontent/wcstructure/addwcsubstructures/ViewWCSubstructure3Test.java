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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcsubstructures;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWCSubstructure3Test extends BaseTestCase {
	public void testViewWCSubstructure3() throws Exception {
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
		selenium.clickAt("link=Web Content",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Structures",
			RuntimeVariables.replace("Structures"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//input[@name='_15_keywords']");
		selenium.type("//input[@name='_15_keywords']",
			RuntimeVariables.replace("Substructure3"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");

		String structureID = selenium.getText("//td[2]/a");
		RuntimeVariables.setValue("structureID", structureID);
		assertEquals(RuntimeVariables.replace("${structureID}"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Substructure3 Name"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("WC Substructure3 Description"),
			selenium.getText("//td[4]/a"));
		selenium.clickAt("//td[3]/a",
			RuntimeVariables.replace("WC Substructure3 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//span[@class='portlet-title-text']"));
		assertTrue(selenium.isPartialText(
				"//div[@id='cpContextPanelTemplate']",
				"Web Content can be any content you would like to add to a site, such as articles, a FAQ, or a news item. Administrators can manage content, as well as assign user roles and permissions. Users may add, edit, approve, or view content depending on their role."));
		assertEquals(RuntimeVariables.replace("WC Substructure3 Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Other Languages (0)"),
			selenium.getText(
				"xPath=(//span[contains(@class,'flag-selector')]/a)[1]"));
		assertTrue(selenium.isPartialText(
				"//fieldset/div/div/div[contains(.,'ID')]",
				RuntimeVariables.getValue("structureID")));
		assertEquals("WC Substructure3 Name",
			selenium.getValue("//input[@id='_15_name_en_US']"));
		assertEquals("WC Substructure3 Description",
			selenium.getValue("//textarea[@id='_15_description_en_US']"));
		assertEquals(RuntimeVariables.replace("Other Languages (0)"),
			selenium.getText(
				"xPath=(//span[contains(@class,'flag-selector')]/a)[2]"));
		assertEquals(RuntimeVariables.replace("WC Structure1 Name"),
			selenium.getText("//a[@id='_15_parentStructureName']"));
		assertEquals("Select", selenium.getValue("//input[@value='Select']"));
		assertEquals("Remove", selenium.getValue("//input[@value='Remove']"));
		assertTrue(selenium.isVisible("//input[@value='Add Row']"));
		assertTrue(selenium.isVisible("//input[@value='Launch Editor']"));
		assertTrue(selenium.isVisible("//input[@value='Download']"));
		assertEquals("Text",
			selenium.getSelectedLabel("//select[@id='_15_structure_el0_type']"));
		assertEquals("Extra",
			selenium.getValue("//input[@id='_15_structure_el0_name']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_15_structure_el0_repeatable']"));
		assertTrue(selenium.isVisible("//input[@value='Save']"));
		assertTrue(selenium.isVisible("//input[@value='Save and Continue']"));
		assertTrue(selenium.isVisible(
				"//input[@value='Save and Edit Default Values']"));
		assertTrue(selenium.isVisible("//input[@value='Cancel']"));
	}
}