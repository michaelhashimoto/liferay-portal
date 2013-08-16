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

package com.liferay.portalweb.plugins.testhook;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletTHTest extends BaseTestCase {
	public void testViewPortletTH() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Test Hook Page",
			RuntimeVariables.replace("Test Hook Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("terms.of.use.required=PASSED"),
			selenium.getText("//div[@class='portlet-body']/p[1]"));
		assertEquals(RuntimeVariables.replace(
				"application.startup.events=PASSED"),
			selenium.getText("//div[@class='portlet-body']/p[2]"));
		assertTrue(selenium.isPartialText("//div[@class='portlet-body']/p[3]",
				"field.enable.com.liferay.portal.model.Contact.male=PASSED"));
		assertTrue(selenium.isPartialText("//div[@class='portlet-body']/p[3]",
				"field.enable.com.liferay.portal.model.Contact.birthday=PASSED"));
		assertTrue(selenium.isPartialText("//div[@class='portlet-body']/p[3]",
				"field.enable.com.liferay.portal.model.Organization.status=PASSED"));
		assertEquals(RuntimeVariables.replace("javax.portlet.title.33=PASSED"),
			selenium.getText("//div[@class='portlet-body']/p[4]"));
		assertEquals(RuntimeVariables.replace("/META-INF/custom_jsps=PASSED"),
			selenium.getText("//div[@class='portlet-body']/p[5]"));
		assertEquals(RuntimeVariables.replace(
				"com.liferay.portal.service.UserLocalService=PASSED"),
			selenium.getText("//div[@class='portlet-body']/p[6]"));
	}
}