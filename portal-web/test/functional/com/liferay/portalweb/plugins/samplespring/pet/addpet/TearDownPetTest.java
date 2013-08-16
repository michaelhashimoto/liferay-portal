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

package com.liferay.portalweb.plugins.samplespring.pet.addpet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownPetTest extends BaseTestCase {
	public void testTearDownPet() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Pets Test Page",
					RuntimeVariables.replace("Pets Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Pets"),
					selenium.getText("//div[@class='portlet-body']/h1"));

				boolean petPresent = selenium.isElementPresent(
						"//div[@class='portlet-body']/table/tbody/tr[contains(.,'Fish')]/td[contains(.,'Remove')]/a");

				if (!petPresent) {
					label = 2;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Remove"),
					selenium.getText(
						"//div[@class='portlet-body']/table/tbody/tr[contains(.,'Fish')]/td[contains(.,'Remove')]/a"));
				selenium.clickAt("//div[@class='portlet-body']/table/tbody/tr[contains(.,'Fish')]/td[contains(.,'Remove')]/a",
					RuntimeVariables.replace("Remove"));
				selenium.waitForText("//div[@class='portlet-body']/table",
					"Species Breed Name Bird Macaw Polly Remove Cat Calico Boots Remove Dog Poodle Fido Remove Snake Boa Bo Remove Add a Pet");
				assertEquals(RuntimeVariables.replace(
						"Species Breed Name Bird Macaw Polly Remove Cat Calico Boots Remove Dog Poodle Fido Remove Snake Boa Bo Remove Add a Pet"),
					selenium.getText("//div[@class='portlet-body']/table"));

			case 2:
			case 100:
				label = -1;
			}
		}
	}
}