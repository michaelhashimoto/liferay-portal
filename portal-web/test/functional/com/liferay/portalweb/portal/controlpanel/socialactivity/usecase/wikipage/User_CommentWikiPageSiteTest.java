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

package com.liferay.portalweb.portal.controlpanel.socialactivity.usecase.wikipage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_CommentWikiPageSiteTest extends BaseTestCase {
	public void testUser_CommentWikiPageSite() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("All Pages"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'All Pages')]/a/span"));
		selenium.clickAt("//ul[@class='top-links-navigation']/li/span[contains(.,'All Pages')]/a/span",
			RuntimeVariables.replace("All Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Page Title"),
			selenium.getText("//tr[contains(.,'Wiki Page Title')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'Wiki Page Title')]/td[1]/a",
			RuntimeVariables.replace("Wiki Page Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Page Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		assertEquals(RuntimeVariables.replace("Be the first."),
			selenium.getText(
				"//fieldset[contains(@class,'add-comment')]/div/a	"));
		selenium.clickAt("//fieldset[contains(@class,'add-comment')]/div/a	",
			RuntimeVariables.replace("Be the first."));
		selenium.waitForVisible("//textarea[@name='_36_postReplyBody0']");
		selenium.type("//textarea[@name='_36_postReplyBody0']",
			RuntimeVariables.replace("Wiki Page Comment"));
		selenium.clickAt("//input[@value='Reply']",
			RuntimeVariables.replace("Reply"));
		selenium.waitForText("//div[@id='_36_discussion-status-messages']",
			"Your request processed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@id='_36_discussion-status-messages']"));
		assertEquals(RuntimeVariables.replace("userfn userln"),
			selenium.getText("//span[@class='user-name']"));
		assertEquals(RuntimeVariables.replace("Wiki Page Comment"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
	}
}