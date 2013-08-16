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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingcommunity.webcontentdisplay;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class PublishToLiveCommunityStagingCommunityWCDTest extends BaseTestCase {
	public void testPublishToLiveCommunityStagingCommunityWCD()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open(
					"/web/community-staging-community-web-content-display-staging/");
				selenium.waitForVisible(
					"link=Page Staging Community Web Content Display");
				selenium.clickAt("link=Page Staging Community Web Content Display",
					RuntimeVariables.replace(
						"Page Staging Community Web Content Display"));
				selenium.waitForPageToLoad("30000");

				boolean markAsReadyPresent = selenium.isElementPresent(
						"//button[3]");

				if (!markAsReadyPresent) {
					label = 2;

					continue;
				}

				assertEquals(RuntimeVariables.replace(
						"Mark as Ready for Publication"),
					selenium.getText("//button[3]"));
				selenium.clickAt("//button[3]",
					RuntimeVariables.replace("Mark as Ready for Publication"));
				selenium.waitForText("//span[@class='workflow-status']",
					"Status: Ready for Publication");
				assertEquals(RuntimeVariables.replace(
						"Status: Ready for Publication"),
					selenium.getText("//span[@class='workflow-status']"));

			case 2:
				selenium.waitForElementPresent(
					"//script[contains(@src,'/liferay/navigation_interaction.js')]");
				selenium.clickAt("//span[@class='staging-icon-menu-container']/span/ul/li/strong/a",
					RuntimeVariables.replace("Staging Dropdown"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a");
				assertEquals(RuntimeVariables.replace("Publish to Live Now"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a",
					RuntimeVariables.replace("Publish to Live Now"));
				selenium.waitForVisible("//div[@class='portlet-msg-info']");
				assertEquals(RuntimeVariables.replace(
						"There are no selected pages. All pages will therefore be exported."),
					selenium.getText("//div[@class='portlet-msg-info']"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/liferay/panel.js')]");
				selenium.waitForVisible("//input[@value='Publish']");
				selenium.clickAt("//input[@value='Publish']",
					RuntimeVariables.replace("Publish"));
				selenium.waitForConfirmation(
					"Are you sure you want to publish these pages?");
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 100:
				label = -1;
			}
		}
	}
}