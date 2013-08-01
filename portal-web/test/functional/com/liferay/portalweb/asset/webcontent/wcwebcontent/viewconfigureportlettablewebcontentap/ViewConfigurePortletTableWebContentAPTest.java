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

package com.liferay.portalweb.asset.webcontent.wcwebcontent.viewconfigureportlettablewebcontentap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewConfigurePortletTableWebContentAPTest extends BaseTestCase {
	public void testViewConfigurePortletTableWebContentAP()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//tr[contains(.,'Title')]/th[1]");
		assertEquals(RuntimeVariables.replace("Title"),
			selenium.getText("//tr[contains(.,'Title')]/th[1]"));
		assertEquals(RuntimeVariables.replace("WC Web Content Title"),
			selenium.getText("//tr[contains(.,'WC Web Content Title')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'WC Web Content Title')]/td[1]/a",
			RuntimeVariables.replace("WC Web Content Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC Web Content Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("WC Web Content Content"),
			selenium.getText("//div[@class='journal-content-article']"));
	}
}