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

package com.liferay.portalweb.demo.sitemanagement.staginglocalliveworkflow;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class WCC_SubmitForPublicationMainVariationHomeSiteStagingTest
	extends BaseTestCase {
	public void testWCC_SubmitForPublicationMainVariationHomeSiteStaging()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/community-site-test/home/");
		selenium.waitForVisible("link=Staging");
		selenium.clickAt("link=Staging", RuntimeVariables.replace("Staging"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Submit for Publication"),
			selenium.getText("//button[3]"));
		selenium.clickAt("//button[3]",
			RuntimeVariables.replace("Submit for Publication"));
		selenium.waitForText("//span[@class='workflow-status']/strong",
			"Pending (Review)");
		assertEquals(RuntimeVariables.replace("Pending (Review)"),
			selenium.getText("//span[@class='workflow-status']/strong"));
		selenium.open("/web/community-site-test/home");
		assertFalse(selenium.isTextPresent("This is a Web Content article"));
	}
}