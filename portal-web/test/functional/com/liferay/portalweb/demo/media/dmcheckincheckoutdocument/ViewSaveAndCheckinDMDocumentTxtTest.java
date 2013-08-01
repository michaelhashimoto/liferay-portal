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
public class ViewSaveAndCheckinDMDocumentTxtTest extends BaseTestCase {
	public void testViewSaveAndCheckinDMDocumentTxt() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document Title Edit"),
			selenium.getText(
				"//div[@data-title='DM Document Title Edit']/a/span[2]"));
		selenium.clickAt("//div[@data-title='DM Document Title Edit']/a/span[2]",
			RuntimeVariables.replace("DM Document Title Edit"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Version 1.1"),
			selenium.getText("//h3[contains(@class,'version')]"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("Version"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[2]"));
		assertEquals(RuntimeVariables.replace("Date"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[3]"));
		assertEquals(RuntimeVariables.replace("Size"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[4]"));
		assertEquals(RuntimeVariables.replace("Status"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[5]"));
		assertEquals(RuntimeVariables.replace("1.1"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row']/td[2]"));
		assertEquals(RuntimeVariables.replace("0.5k"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row']/td[4]"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row']/td[5]"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText(
				"//tr[@class='portlet-section-alternate results-row alt last']/td[2]"));
		assertEquals(RuntimeVariables.replace("0.3k"),
			selenium.getText(
				"//tr[@class='portlet-section-alternate results-row alt last']/td[4]"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText(
				"//tr[@class='portlet-section-alternate results-row alt last']/td[5]"));
	}
}