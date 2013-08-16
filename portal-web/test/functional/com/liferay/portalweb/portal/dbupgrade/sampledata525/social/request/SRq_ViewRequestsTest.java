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

package com.liferay.portalweb.portal.dbupgrade.sampledata525.social.request;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SRq_ViewRequestsTest extends BaseTestCase {
	public void testSRq_ViewRequests() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialrequestsn1/home/");
		selenium.clickAt("link=Requests Test Page",
			RuntimeVariables.replace("Requests Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"socialrequestfn2 socialrequestmn2 socialrequestln2"),
			selenium.getText("//div/a[contains(.,'socialrequestfn2')]"));
		assertEquals(RuntimeVariables.replace("Confirm"),
			selenium.getText("//a[.='Confirm']"));
		assertEquals(RuntimeVariables.replace("Ignore"),
			selenium.getText("//a[.='Ignore']"));
	}
}