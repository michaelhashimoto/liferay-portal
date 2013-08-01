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

package com.liferay.portalweb.portlet.breadcrumb.portlet.configureportletdisplaystyle1;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertConfigurePortletDisplayStyle1Test extends BaseTestCase {
	public void testAssertConfigurePortletDisplayStyle1()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.click(RuntimeVariables.replace("link=Breadcrumb Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText(
				"//div/ul[@class='breadcrumbs breadcrumbs-horizontal lfr-component']/li[1]/span/a"));
		assertEquals(RuntimeVariables.replace("Breadcrumb Test Page"),
			selenium.getText(
				"//div/ul[@class='breadcrumbs breadcrumbs-horizontal lfr-component']/li[2]/span/a"));
	}
}