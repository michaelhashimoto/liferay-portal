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

package com.liferay.portalweb.kaleo.assetpublisher.dmdocument.guestviewpendingdmfolderdocumentnoaptest;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_ViewPendingDMFolderDocumentNoAPTest extends BaseTestCase {
	public void testGuest_ViewPendingDMFolderDocumentNoAP()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent("//section"));
		assertTrue(selenium.isElementNotPresent(
				"//span[@title='Add New']/ul/li/strong/a"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='portlet-msg-info']"));
		assertTrue(selenium.isElementNotPresent("//h3[@class='asset-title']/a"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='asset-resource-info']/span/a/span"));
		assertFalse(selenium.isTextPresent("DM Folder Document Title"));
	}
}