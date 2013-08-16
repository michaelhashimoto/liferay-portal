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

package com.liferay.portalweb.portlet.loancalculator.loan.calculateloan;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CalculateLoanTest extends BaseTestCase {
	public void testCalculateLoan() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Loan Calculator Test Page",
			RuntimeVariables.replace("Loan Calculator Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='_61_loanAmount']",
			RuntimeVariables.replace("1,000"));
		selenium.type("//input[@name='_61_interest']",
			RuntimeVariables.replace("4.75"));
		selenium.type("//input[@name='_61_years']",
			RuntimeVariables.replace("20"));
		selenium.clickAt("//input[@value='Calculate']",
			RuntimeVariables.replace("Calculate"));
		selenium.waitForText("//tr[6]/td[2]/strong", "1,551");
		assertEquals(RuntimeVariables.replace("1,551"),
			selenium.getText("//tr[6]/td[2]/strong"));
	}
}