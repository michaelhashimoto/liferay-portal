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

package com.liferay.portalweb.plugins.samplespring.petsite.addpetsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownPetSiteTest extends BaseTestCase {
	public void testTearDownPetSite() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Pet Sites Test Page",
					RuntimeVariables.replace("Pet Sites Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Pet Sites"),
					selenium.getText("//div[@class='portlet-body']/h1"));
				assertEquals(RuntimeVariables.replace("Edit Mode"),
					selenium.getText("//div/div/a"));
				selenium.clickAt("//div/div/a",
					RuntimeVariables.replace("Edit Mode"));
				selenium.waitForText("//div/div/a", "Add Site");
				assertEquals(RuntimeVariables.replace("Add Site"),
					selenium.getText("//div/div/a"));

				boolean petSitePresent = selenium.isElementPresent(
						"//div[@class='portlet-body']/form/a");

				if (!petSitePresent) {
					label = 2;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Remove"),
					selenium.getText("//div[@class='portlet-body']/form/a"));
				selenium.clickAt("//div[@class='portlet-body']/form/a",
					RuntimeVariables.replace("Remove"));
				selenium.waitForTextNotPresent("Remove");

			case 2:
				selenium.waitForText("//div/a[2]", "View Mode");
				assertEquals(RuntimeVariables.replace("View Mode"),
					selenium.getText("//div/a[2]"));
				selenium.clickAt("//div/a[2]",
					RuntimeVariables.replace("View Mode"));
				selenium.waitForText("//div/div/a", "Edit Mode");
				assertEquals(RuntimeVariables.replace("Edit Mode"),
					selenium.getText("//div/div/a"));

			case 100:
				label = -1;
			}
		}
	}
}