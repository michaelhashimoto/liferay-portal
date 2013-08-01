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

package com.liferay.portalweb.portal.dbupgrade.sampledata611.groups.pagescope;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsEntryScopeTest extends BaseTestCase {
	public void testViewBlogsEntryScope() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/group-page-scope-community/");
		selenium.waitForVisible("link=Blogs Page Scope Current Page");
		selenium.clickAt("link=Blogs Page Scope Current Page",
			RuntimeVariables.replace("Blogs Page Scope Current Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry Scope Current Page"),
			selenium.getText("//div[@class='entry-title']/h2/a"));
		assertEquals(RuntimeVariables.replace(
				"This is a blogs entry scope current page test."),
			selenium.getText("//div[@class='entry-body']/p"));
		selenium.waitForVisible("link=Blogs Page Scope Default");
		selenium.clickAt("link=Blogs Page Scope Default",
			RuntimeVariables.replace("Blogs Page Scope Default"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Blogs Entry Scope Current Page"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='entry-title']/h2/a"));
		assertFalse(selenium.isTextPresent(
				"This is a blogs entry scope current page test."));
	}
}