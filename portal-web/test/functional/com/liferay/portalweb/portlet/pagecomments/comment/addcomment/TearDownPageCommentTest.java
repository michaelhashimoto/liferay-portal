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

package com.liferay.portalweb.portlet.pagecomments.comment.addcomment;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownPageCommentTest extends BaseTestCase {
	public void testTearDownPageComment() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Page Comments Test Page",
					RuntimeVariables.replace("Page Comments Test Page"));
				selenium.waitForPageToLoad("30000");

				boolean pageComment1Present = selenium.isElementPresent(
						"//div[@class='lfr-discussion-message']");

				if (!pageComment1Present) {
					label = 2;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//li[contains(.,'Delete')]/span/a/span"));
				selenium.click("//li[contains(.,'Delete')]/span/a/span");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this?");
				selenium.waitForVisible(
					"//div[@class='lfr-message-response portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText(
						"//div[@class='lfr-message-response portlet-msg-success']"));
				Thread.sleep(5000);

				boolean pageComment2Present = selenium.isElementPresent(
						"//div[@class='lfr-discussion-message']");

				if (!pageComment2Present) {
					label = 3;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//li[contains(.,'Delete')]/span/a/span"));
				selenium.click("//li[contains(.,'Delete')]/span/a/span");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this?");
				selenium.waitForVisible(
					"//div[@class='lfr-message-response portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText(
						"//div[@class='lfr-message-response portlet-msg-success']"));
				Thread.sleep(5000);

				boolean pageComment3Present = selenium.isElementPresent(
						"//div[@class='lfr-discussion-message']");

				if (!pageComment3Present) {
					label = 4;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//li[contains(.,'Delete')]/span/a/span"));
				selenium.click("//li[contains(.,'Delete')]/span/a/span");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this?");
				selenium.waitForVisible(
					"//div[@class='lfr-message-response portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText(
						"//div[@class='lfr-message-response portlet-msg-success']"));
				Thread.sleep(5000);

				boolean pageComment4Present = selenium.isElementPresent(
						"//div[@class='lfr-discussion-message']");

				if (!pageComment4Present) {
					label = 5;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//li[contains(.,'Delete')]/span/a/span"));
				selenium.click("//li[contains(.,'Delete')]/span/a/span");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this?");
				selenium.waitForVisible(
					"//div[@class='lfr-message-response portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText(
						"//div[@class='lfr-message-response portlet-msg-success']"));
				Thread.sleep(5000);

				boolean pageComment5Present = selenium.isElementPresent(
						"//div[@class='lfr-discussion-message']");

				if (!pageComment5Present) {
					label = 6;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//li[contains(.,'Delete')]/span/a/span"));
				selenium.click("//li[contains(.,'Delete')]/span/a/span");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this?");
				selenium.waitForVisible(
					"//div[@class='lfr-message-response portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText(
						"//div[@class='lfr-message-response portlet-msg-success']"));
				Thread.sleep(5000);

			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 100:
				label = -1;
			}
		}
	}
}