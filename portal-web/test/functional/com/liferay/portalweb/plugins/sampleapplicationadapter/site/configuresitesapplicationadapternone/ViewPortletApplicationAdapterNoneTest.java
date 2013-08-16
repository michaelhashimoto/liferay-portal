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

package com.liferay.portalweb.plugins.sampleapplicationadapter.site.configuresitesapplicationadapternone;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletApplicationAdapterNoneTest extends BaseTestCase {
	public void testViewPortletApplicationAdapterNone()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/public-page");
		selenium.clickAt("link=Public Page",
			RuntimeVariables.replace("Public Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//section");
		assertTrue(selenium.isVisible("//section"));
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText(
				"//div[@class='portlet-body']/div/ul[contains(@class,'breadcrumbs-horizontal')]/li[1]/span/a"));
		assertEquals(RuntimeVariables.replace("Site Name"),
			selenium.getText(
				"//div[@class='portlet-body']/div/ul[contains(@class,'breadcrumbs-horizontal')]/li[2]/span/a"));
		assertEquals(RuntimeVariables.replace("Public Page"),
			selenium.getText(
				"//div[@class='portlet-body']/div/ul[contains(@class,'breadcrumbs-horizontal')]/li[3]/span/a"));
		assertFalse(selenium.isTextPresent(
				"This was modified by the Sample Application Adapter."));
	}
}