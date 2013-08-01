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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationpage.addorganizationpublicpage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewOrganizationPublicPageTest extends BaseTestCase {
	public void testViewOrganizationPublicPage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/organization-name/");
		assertEquals(RuntimeVariables.replace("Organization Name"),
			selenium.getText("//h1[@class='site-title']/span"));
		assertEquals(RuntimeVariables.replace("Public Page"),
			selenium.getText(
				"//nav[@id='navigation']/ul/li/a/span[contains(.,'Public Page')]"));
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText(
				"//ul[@class='breadcrumbs breadcrumbs-horizontal lfr-component']/li/span/a[contains(.,'Liferay')]"));
		assertEquals(RuntimeVariables.replace("Organization Name"),
			selenium.getText(
				"//ul[@class='breadcrumbs breadcrumbs-horizontal lfr-component']/li/span/a[contains(.,'Organization Name')]"));
		assertEquals(RuntimeVariables.replace("Public Page"),
			selenium.getText(
				"//ul[@class='breadcrumbs breadcrumbs-horizontal lfr-component']/li/span/a[contains(.,'Public Page')]"));
	}
}