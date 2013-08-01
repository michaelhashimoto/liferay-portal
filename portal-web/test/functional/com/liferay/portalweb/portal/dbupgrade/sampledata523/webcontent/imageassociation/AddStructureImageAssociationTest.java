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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.webcontent.imageassociation;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddStructureImageAssociationTest extends BaseTestCase {
	public void testAddStructureImageAssociation() throws Exception {
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
			RuntimeVariables.replace("Web Content Image Association Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row']/td[1]/a",
			RuntimeVariables.replace("Public Pages - Live (1)"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
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
		selenium.clickAt("//input[@value='Add Structure']",
			RuntimeVariables.replace("Add Structure"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_15_newStructureId']",
			RuntimeVariables.replace("test_image"));
		selenium.type("//input[@id='_15_name']",
			RuntimeVariables.replace("Image Structure Test"));
		selenium.type("//textarea[@id='_15_description']",
			RuntimeVariables.replace("This is an image structure test."));
		selenium.clickAt("//input[@value='Add Row']",
			RuntimeVariables.replace("Add Row"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_15_structure_el0_name']",
			RuntimeVariables.replace("image-gallery-test"));
		selenium.select("//select[@id='_15_structure_el0_type']",
			RuntimeVariables.replace("label=Image Gallery"));
		selenium.clickAt("//input[@value='Add Row']",
			RuntimeVariables.replace("Add Row"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_15_structure_el0_name']",
			RuntimeVariables.replace("image-test"));
		selenium.select("//select[@id='_15_structure_el0_type']",
			RuntimeVariables.replace("label=Image"));
		selenium.clickAt("//input[@value='Add Row']",
			RuntimeVariables.replace("Add Row"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_15_structure_el0_type']",
			RuntimeVariables.replace("label=Text"));
		selenium.type("//input[@id='_15_structure_el0_name']",
			RuntimeVariables.replace("text-test"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("TEST_IMAGE"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row']/td[2]"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row']/td[3]",
				"Image Structure Test"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row']/td[3]",
				"This is an image structure test."));
	}
}