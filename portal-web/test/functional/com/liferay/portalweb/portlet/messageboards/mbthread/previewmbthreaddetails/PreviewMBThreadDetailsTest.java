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

package com.liferay.portalweb.portlet.messageboards.mbthread.previewmbthreaddetails;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class PreviewMBThreadDetailsTest extends BaseTestCase {
	public void testPreviewMBThreadDetails() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Post New Thread']",
			RuntimeVariables.replace("Post New Thread"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_19_subject']",
			RuntimeVariables.replace("MB Thread Message Subject"));
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
			RuntimeVariables.replace("MB Thread Message Body"));
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Preview']",
			RuntimeVariables.replace("Preview"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Thread Message Subject"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("MB Thread Message Subject"),
			selenium.getText("//div[@class='subject']/a/strong"));
		assertEquals(RuntimeVariables.replace("MB Thread Message Body"),
			selenium.getText("//div[@class='thread-body']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"There are no threads in this category."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.clickAt("link=My Posts", RuntimeVariables.replace("My Posts"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Thread Message Subject"),
			selenium.getText("//td[1]/a"));
		selenium.clickAt("//td[1]/a",
			RuntimeVariables.replace("MB Thread Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Thread Message Subject"),
			selenium.getText("//div[@class='subject']/a/strong"));
		assertEquals(RuntimeVariables.replace("Draft"),
			selenium.getText("//strong[@class='workflow-status-draft']"));
		assertEquals(RuntimeVariables.replace("MB Thread Message Body"),
			selenium.getText("//div[@class='thread-body']"));
	}
}