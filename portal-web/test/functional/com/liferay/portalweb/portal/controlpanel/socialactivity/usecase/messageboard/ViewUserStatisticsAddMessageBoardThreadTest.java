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

package com.liferay.portalweb.portal.controlpanel.socialactivity.usecase.messageboard;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewUserStatisticsAddMessageBoardThreadTest extends BaseTestCase {
	public void testViewUserStatisticsAddMessageBoardThread()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=User Statistics Test Page",
			RuntimeVariables.replace("User Statistics Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//span[@class='user-name']"));
		assertEquals(RuntimeVariables.replace("Rank: 1"),
			selenium.getText("//div[@class='user-rank']"));
		assertEquals(RuntimeVariables.replace("Contribution Score: 0"),
			selenium.getText("//div[@class='contribution-score']"));
		assertEquals(RuntimeVariables.replace("Participation Score: 5"),
			selenium.getText("//div[@class='participation-score']"));
		assertEquals(RuntimeVariables.replace("User's Message Board Posts: 1"),
			selenium.getText(
				"//div[@class='social-counter-user.message-posts']"));
	}
}