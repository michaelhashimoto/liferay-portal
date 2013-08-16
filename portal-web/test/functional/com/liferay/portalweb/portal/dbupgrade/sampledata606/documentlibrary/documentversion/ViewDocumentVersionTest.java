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

package com.liferay.portalweb.portal.dbupgrade.sampledata606.documentlibrary.documentversion;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDocumentVersionTest extends BaseTestCase {
	public void testViewDocumentVersion() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/document-library-document-version-community/");
		selenium.clickAt("link=Document Library Page",
			RuntimeVariables.replace("Document Library Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test1 Folder1"),
			selenium.getText("//a/strong[.='Test1 Folder1']"));
		selenium.clickAt("//a/strong[.='Test1 Folder1']",
			RuntimeVariables.replace("Test1 Folder1"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test2 Document2.txt"),
			selenium.getText("//a/span/span[contains(.,'Test2 Document2.txt')]"));
		assertEquals(RuntimeVariables.replace("This is test2 document2."),
			selenium.getText("//a/div[contains(.,'This is test2 document2.')]"));
		selenium.clickAt("//a/span/span[contains(.,'Test2 Document2.txt')]",
			RuntimeVariables.replace("Test2 Document2.txt"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("1.1"),
			selenium.getText("//span[1]/strong"));
		assertEquals(RuntimeVariables.replace("1.1"),
			selenium.getText("//tr[3]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//tr[4]/td[2]/a"));
	}
}