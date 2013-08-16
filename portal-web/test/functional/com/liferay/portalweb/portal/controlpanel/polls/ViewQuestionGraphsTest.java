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

package com.liferay.portalweb.portal.controlpanel.polls;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewQuestionGraphsTest extends BaseTestCase {
	public void testViewQuestionGraphs() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Polls", RuntimeVariables.replace("Polls"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Test Poll Question",
			RuntimeVariables.replace("Test Poll Question"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Area", RuntimeVariables.replace("Area"));
		selenium.waitForPopUp("", RuntimeVariables.replace("30000"));
		selenium.selectPopUp("");
		selenium.waitForVisible("//body/img");
		assertTrue(selenium.isVisible("//body/img"));
		selenium.close();
		selenium.selectWindow("null");
		selenium.waitForVisible("link=Horizontal Bar");
		selenium.clickAt("link=Horizontal Bar",
			RuntimeVariables.replace("Horizontal Bar"));
		selenium.waitForPopUp("", RuntimeVariables.replace("30000"));
		selenium.selectPopUp("");
		selenium.waitForVisible("//body/img");
		assertTrue(selenium.isVisible("//body/img"));
		selenium.close();
		selenium.selectWindow("null");
		selenium.waitForVisible("link=Line");
		selenium.clickAt("link=Line", RuntimeVariables.replace("Line"));
		selenium.waitForPopUp("", RuntimeVariables.replace("30000"));
		selenium.selectPopUp("");
		selenium.waitForVisible("//body/img");
		assertTrue(selenium.isVisible("//body/img"));
		selenium.close();
		selenium.selectWindow("null");
		selenium.waitForVisible("link=Pie");
		selenium.clickAt("link=Pie", RuntimeVariables.replace("Pie"));
		selenium.waitForPopUp("", RuntimeVariables.replace("30000"));
		selenium.selectPopUp("");
		selenium.waitForVisible("//body/img");
		assertTrue(selenium.isVisible("//body/img"));
		selenium.close();
		selenium.selectWindow("null");
		selenium.waitForVisible("link=Vertical Bar");
		selenium.clickAt("link=Vertical Bar",
			RuntimeVariables.replace("Vertical Bar"));
		selenium.waitForPopUp("", RuntimeVariables.replace("30000"));
		selenium.selectPopUp("");
		selenium.waitForVisible("//body/img");
		assertTrue(selenium.isVisible("//body/img"));
		selenium.close();
		selenium.selectWindow("null");
	}
}