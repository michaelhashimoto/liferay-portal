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

package com.liferay.portalweb.demo.useradmin.permissionssitelevel;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User2_ViewSiteMemberRolePermissionTest extends BaseTestCase {
	public void testUser2_ViewSiteMemberRolePermission()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.waitForVisible("link=Blogs Test Page");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//td[1]/span/a/span"));
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText("//td[2]/span/a/span"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//td[3]/span/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='entry '][2]/div[@class='lfr-meta-actions edit-actions entry']"));
	}
}