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

package com.liferay.portalweb.stagingsite.sites.site.useraccessstaging;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_AccessStagingTest extends BaseTestCase {
	public void testUser_AccessStaging() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name-staging/");
		assertEquals(RuntimeVariables.replace("Staging"),
			selenium.getText("//div[@class='staging-bar']/ul/li/span/span"));
		assertEquals(RuntimeVariables.replace("Site Name (Staging)"),
			selenium.getText("//nav[@id='breadcrumbs']/ul/li[2]/span/a"));
		assertEquals(RuntimeVariables.replace("Page Name"),
			selenium.getText("//nav[@id='breadcrumbs']/ul/li[3]/span/a"));
	}
}