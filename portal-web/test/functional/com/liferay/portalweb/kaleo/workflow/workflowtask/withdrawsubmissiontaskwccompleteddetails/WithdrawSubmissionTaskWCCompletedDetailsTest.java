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

package com.liferay.portalweb.kaleo.workflow.workflowtask.withdrawsubmissiontaskwccompleteddetails;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class WithdrawSubmissionTaskWCCompletedDetailsTest extends BaseTestCase {
	public void testWithdrawSubmissionTaskWCCompletedDetails()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Workflow", RuntimeVariables.replace("Workflow"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Submissions",
			RuntimeVariables.replace("Submissions"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Single Approver"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("WC Web Content Title"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[4]/a"));
		assertTrue(selenium.isVisible("//td[5]/a"));
		assertTrue(selenium.isVisible("//td[6]/a"));
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("WC Web Content Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//tr[3]/td[1]"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("Yes"),
			selenium.getText("//tr[3]/td[3]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li[1]/a"));
		assertFalse(selenium.isTextPresent("Withdraw Submission"));
	}
}