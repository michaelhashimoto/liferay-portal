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

package com.liferay.portalweb.asset.webcontent.wcwebcontent.addwcwebcontent2displaypageap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWCWebContent2DisplayPageAPTest extends BaseTestCase {
	public void testViewWCWebContent2DisplayPageAP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent2 Title"),
			selenium.getText("//h3[@class='asset-title']/a"));
		assertEquals(RuntimeVariables.replace("WC WebContent2 Content"),
			selenium.getText("//div[@class='asset-summary']"));
		assertFalse(selenium.isTextPresent("WC WebContent1 Title"));
		assertFalse(selenium.isTextPresent("WC WebContent1 Content"));
		selenium.clickAt("//h3[@class='asset-title']/a",
			RuntimeVariables.replace("WC WebContent2 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent2 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("WC WebContent2 Content"),
			selenium.getText("//div[@class='journal-content-article']"));
	}
}