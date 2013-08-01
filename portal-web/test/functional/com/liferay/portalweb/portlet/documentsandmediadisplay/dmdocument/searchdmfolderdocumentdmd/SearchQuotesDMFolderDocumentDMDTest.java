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

package com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.searchdmfolderdocumentdmd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchQuotesDMFolderDocumentDMDTest extends BaseTestCase {
	public void testSearchQuotesDMFolderDocumentDMD() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Display Test Page",
			RuntimeVariables.replace("Documents and Media Display Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@title='Search Documents']",
			RuntimeVariables.replace("\"DM Folder Document Title\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText("//td[3]/a"));
		selenium.type("//input[@title='Search Documents']",
			RuntimeVariables.replace("\"DM2 Folder2 Document2 Title2\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"No documents were found that matched the keywords: \"DM2 Folder2 Document2 Title2\"."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertFalse(selenium.isTextPresent("DL Folder Name"));
		assertFalse(selenium.isTextPresent("DL Folder Document Title"));
	}
}