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

package com.liferay.portalweb.portal.dbupgrade.sampledata6120.documentlibrary.documentlock;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewLockDLDocumentTest extends BaseTestCase {
	public void testViewLockDLDocument() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("web/document-library-document-lock-community/");
		selenium.clickAt("link=Document Lock Page",
			RuntimeVariables.replace("Document Lock Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test1 Folder1"),
			selenium.getText("//div/a/span[contains(.,'Test1 Folder1')]"));
		selenium.clickAt("//div/a/span[contains(.,'Test1 Folder1')]",
			RuntimeVariables.replace("Test1 Folder1"));
		selenium.waitForText("//div/a/span[contains(.,'Test1 Document1.txt')]",
			"Test1 Document1.txt (Draft)");
		assertEquals(RuntimeVariables.replace("Test1 Document1.txt (Draft)"),
			selenium.getText("//div/a/span[contains(.,'Test1 Document1.txt')]"));
		selenium.clickAt("//div/a/span[contains(.,'Test1 Document1.txt')]",
			RuntimeVariables.replace("Test1 Document1.txt (Draft)"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You now have a lock on this document. No one else can edit this document until you unlock it. This lock will automatically expire in 1 day."),
			selenium.getText(
				"//div[@class='portlet-msg-lock portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Test1 Document1.txt"),
			selenium.getText("//h2[@class='document-title']"));
		assertEquals(RuntimeVariables.replace("This is Test1 Document1"),
			selenium.getText("//span[@class='document-description']"));
	}
}