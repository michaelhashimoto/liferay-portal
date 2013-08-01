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

package com.liferay.portalweb.demo.media.dmcheckincheckoutdocument;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_ViewCheckoutDMDocumentTxtTest extends BaseTestCase {
	public void testGuest_ViewCheckoutDMDocumentTxt() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document Title"),
			selenium.getText("//div[@data-title='DM Document Title']/a/span[2]"));
		assertTrue(selenium.isVisible("//img[@alt='Locked']"));
		selenium.clickAt("//div[@data-title='DM Document Title']/a/span[2]",
			RuntimeVariables.replace("DM Document Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Download"),
			selenium.getText("//button[.='Download']"));
		assertEquals(RuntimeVariables.replace("Version 1.0"),
			selenium.getText("//h3[@class='version document-locked']"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[2]"));
		assertEquals(RuntimeVariables.replace("0.3k"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[4]"));
	}
}