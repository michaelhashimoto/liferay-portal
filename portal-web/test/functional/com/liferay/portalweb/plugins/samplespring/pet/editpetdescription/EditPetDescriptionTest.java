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

package com.liferay.portalweb.plugins.samplespring.pet.editpetdescription;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditPetDescriptionTest extends BaseTestCase {
	public void testEditPetDescription() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Description Upload Test Page",
			RuntimeVariables.replace("Description Upload Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Upload a Pet Description Here"),
			selenium.getText("//div[@class='portlet-body']/h1"));
		assertTrue(selenium.isVisible("//select[@name='selectedPet']"));
		selenium.select("//select[@name='selectedPet']",
			RuntimeVariables.replace("Bubbles (Fish/Goldfish)"));
		selenium.uploadCommonFile("//input[@name='file']",
			RuntimeVariables.replace("Document_1.txt"));
		selenium.clickAt("//button[@type='submit']",
			RuntimeVariables.replace("Upload"));
		Thread.sleep(5000);
	}
}