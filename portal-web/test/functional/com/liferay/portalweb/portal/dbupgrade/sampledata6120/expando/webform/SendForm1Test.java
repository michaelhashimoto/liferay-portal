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

package com.liferay.portalweb.portal.dbupgrade.sampledata6120.expando.webform;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SendForm1Test extends BaseTestCase {
	public void testSendForm1() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/expando-web-form-community/");
		selenium.clickAt("link=Web Form Page",
			RuntimeVariables.replace("Web Form Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@type='text']", RuntimeVariables.replace("Hashi"));
		selenium.clickAt("//input[contains(@id,'_field2Checkbox')]",
			RuntimeVariables.replace("Checkbox"));
		selenium.clickAt("//input[@value='Male']",
			RuntimeVariables.replace("Male"));
		selenium.select("//select", RuntimeVariables.replace("Poor"));
		selenium.type("//textarea",
			RuntimeVariables.replace("This is a comment. Hashi."));
		selenium.clickAt("//input[@value='Send']",
			RuntimeVariables.replace("Send"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"The form information was sent successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}