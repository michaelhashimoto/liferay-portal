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

package com.liferay.portalweb.asset.messageboards.mbthread.viewportletmaximumitems5mbcategorymessage6ap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMBCategoryThreadMessage6APTest extends BaseTestCase {
	public void testViewMBCategoryThreadMessage6AP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread6 Message Subject"),
			selenium.getText("xPath=(//h3[@class='asset-title'])[1]/a"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread6 Message Body"),
			selenium.getText("xPath=(//div[@class='asset-summary'])[1]"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread5 Message Subject"),
			selenium.getText("xPath=(//h3[@class='asset-title'])[2]/a"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread5 Message Body"),
			selenium.getText("xPath=(//div[@class='asset-summary'])[2]"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread4 Message Subject"),
			selenium.getText("xPath=(//h3[@class='asset-title'])[3]/a"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread4 Message Body"),
			selenium.getText("xPath=(//div[@class='asset-summary'])[3]"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread3 Message Subject"),
			selenium.getText("xPath=(//h3[@class='asset-title'])[4]/a"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread3 Message Body"),
			selenium.getText("xPath=(//div[@class='asset-summary'])[4]"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread2 Message Subject"),
			selenium.getText("xPath=(//h3[@class='asset-title'])[5]/a"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread2 Message Body"),
			selenium.getText("xPath=(//div[@class='asset-summary'])[5]"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread1 Message Subject"),
			selenium.getText("xPath=(//h3[@class='asset-title'])[6]/a"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread1 Message Body"),
			selenium.getText("xPath=(//div[@class='asset-summary'])[6]"));
	}
}