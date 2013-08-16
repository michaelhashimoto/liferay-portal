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
public class ViewPetSiteTest extends BaseTestCase {
	public void testViewPetSite() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Pet Sites Test Page",
			RuntimeVariables.replace("Pet Sites Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Pet Sites"),
			selenium.getText("//div[@class='portlet-body']/h1"));
		assertTrue(selenium.isVisible("//select[@name='url']"));
		selenium.select("//select[@name='url']",
			RuntimeVariables.replace("Liferay [http://www.liferay.com]"));
		selenium.clickAt("//button[@type='submit']",
			RuntimeVariables.replace("View Selected"));
		selenium.waitForVisible(
			"//img[@alt='Open Source, Enterprise, For Life']");
		assertTrue(selenium.isVisible(
				"//img[@alt='Open Source, Enterprise, For Life']"));
	}
}