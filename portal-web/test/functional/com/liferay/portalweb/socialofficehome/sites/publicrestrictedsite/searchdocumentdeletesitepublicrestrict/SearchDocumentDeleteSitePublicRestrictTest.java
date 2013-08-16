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

package com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.searchdocumentdeletesitepublicrestrict;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchDocumentDeleteSitePublicRestrictTest extends BaseTestCase {
	public void testSearchDocumentDeleteSitePublicRestrict()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//nav/ul/li[contains(.,'Search Test Page')]/a/span",
			RuntimeVariables.replace("Search Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//div[@class='portlet-body']/form/input[contains(@name,'keywords')]",
			RuntimeVariables.replace("DM Folder Document"));
		selenium.clickAt("//div[@class='portlet-body']/form/input[contains(@src,'search')]",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"No results were found that matched the keywords: DM Folder Document."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertTrue(selenium.isElementNotPresent("//span[@class='asset-entry']"));
		assertFalse(selenium.isTextPresent("DL Folder Document Title"));
		assertFalse(selenium.isTextPresent("DL Folder Document Description"));
	}
}