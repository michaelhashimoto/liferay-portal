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

package com.liferay.portalweb.plugins.drools.user.usecase;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User2_ViewBlogsEntry2TagISSDTest extends BaseTestCase {
	public void testUser2_ViewBlogsEntry2TagISSD() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Sample Drools Test Page",
			RuntimeVariables.replace("Sample Drools Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//div[@class='portlet-content']",
				"Welcome User Two!"));
		assertTrue(selenium.isPartialText("//div[@class='portlet-content']",
				"Indian Symposium"));
		assertTrue(selenium.isPartialText("//div[@class='portlet-content']",
				"Blogs Entry Content"));
	}
}