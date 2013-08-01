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

package com.liferay.portalweb.portal.controlpanel.sites.siteportlet.addsitepublicpageschildpageportlets;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletsPage2SiteTest extends BaseTestCase {
	public void testViewPortletsPage2Site() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/public-page2");
		selenium.waitForVisible("xpath=(//section)[1]");
		assertTrue(selenium.isVisible("xpath=(//section)[1]"));
		assertEquals(RuntimeVariables.replace("Asset Publisher"),
			selenium.getText("xPath=(//span[@class='portlet-title-text'])[1]"));
		assertTrue(selenium.isVisible("xpath=(//section)[2]"));
		assertEquals(RuntimeVariables.replace("Language"),
			selenium.getText("xPath=(//span[@class='portlet-title-text'])[2]"));
		assertTrue(selenium.isVisible("xpath=(//section)[3]"));
		assertEquals(RuntimeVariables.replace("Web Content Display"),
			selenium.getText("xPath=(//span[@class='portlet-title-text'])[3]"));
	}
}