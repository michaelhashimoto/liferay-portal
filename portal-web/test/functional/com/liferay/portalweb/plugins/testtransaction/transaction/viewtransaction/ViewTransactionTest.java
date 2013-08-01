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

package com.liferay.portalweb.plugins.testtransaction.transaction.viewtransaction;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewTransactionTest extends BaseTestCase {
	public void testViewTransaction() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Test Transaction Page",
			RuntimeVariables.replace("Test Transaction Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//p[1]",
				"BarLocalServiceUtil.addBar_Success=PASSED"));
		assertTrue(selenium.isPartialText("//p[1]",
				"BarLocalServiceUtil.addBarAndClassName_PortalRollback=PASSED"));
		assertTrue(selenium.isPartialText("//p[1]",
				"BarLocalServiceUtil.addBarAndClassName_PortletRollback=PASSED"));
		assertTrue(selenium.isPartialText("//p[2]",
				"PortalServiceUtil.testAddClassNameAndTestTransactionPortletBar_Success=PASSED"));
		assertTrue(selenium.isPartialText("//p[2]",
				"PortalServiceUtil.testAddClassNameAndTestTransactionPortletBar_PortalRollback=PASSED"));
		assertTrue(selenium.isPartialText("//p[2]",
				"PortletServiceUtil.testAddClassNameAndTestTransactionPortletBar_PortletRollback=PASSED"));
	}
}