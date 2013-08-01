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

package com.liferay.portalweb.portlet.pollsdisplay.question.votequestion;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class VoteQuestionTest extends BaseTestCase {
	public void testVoteQuestion() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Polls Display Test Page",
			RuntimeVariables.replace("Polls Display Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div/span[2]/span/span/input",
			RuntimeVariables.replace("Choice B Radio Button"));
		selenium.clickAt("//input[@value='Vote']",
			RuntimeVariables.replace("Vote"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Thank you for your vote."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("0%"),
			selenium.getText("//tr[2]/td[1]"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[2]/td[2]"));
		assertEquals(RuntimeVariables.replace("PD Question ChoiceA"),
			selenium.getText("//td[4]"));
		assertEquals(RuntimeVariables.replace("100%"),
			selenium.getText("//tr[3]/td[1]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("PD Question ChoiceB"),
			selenium.getText("//td[5]"));
		assertEquals(RuntimeVariables.replace("0%"),
			selenium.getText("//tr[4]/td[1]"));
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//tr[4]/td[2]"));
		assertEquals(RuntimeVariables.replace("PD Question ChoiceC"),
			selenium.getText("//tr[4]/td[4]"));
		assertEquals(RuntimeVariables.replace("Total Votes: 1"),
			selenium.getText("//form/div"));
		assertTrue(selenium.isElementNotPresent("//input[@value='Vote']"));
		assertTrue(selenium.isElementNotPresent("//div/span[1]/span/span/input"));
		assertTrue(selenium.isElementNotPresent("//div/span[2]/span/span/input"));
		assertTrue(selenium.isElementNotPresent("//div/span[3]/span/span/input"));
	}
}