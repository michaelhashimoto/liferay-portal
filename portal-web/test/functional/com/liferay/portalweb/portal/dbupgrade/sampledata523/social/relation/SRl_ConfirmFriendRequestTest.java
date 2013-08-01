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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.social.relation;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SRl_ConfirmFriendRequestTest extends BaseTestCase {
	public void testSRl_ConfirmFriendRequest() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialrelationsn1/home/");
		selenium.clickAt("link=Requests Test Page",
			RuntimeVariables.replace("Requests Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"socialrelationfn2 socialrelationmn2 socialrelationln2"),
			selenium.getText("//div/a[contains(.,'socialrelationfn2')]"));
		assertEquals(RuntimeVariables.replace("Confirm"),
			selenium.getText("//a[.='Confirm']"));
		selenium.clickAt("//a[.='Confirm']", RuntimeVariables.replace("Confirm"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Confirm"));
		assertFalse(selenium.isTextPresent(
				"socialrelationfn2 socialrelationmn2 socialrelationln2"));
	}
}