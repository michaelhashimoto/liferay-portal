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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousrepostmicroblogscontentprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSOURepostMBContentProfileTest extends BaseTestCase {
	public void testViewSOURepostMBContentProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialoffice01/so/profile");
		selenium.waitForVisible("//div[@class='lfr-contact-name']/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		selenium.waitForVisible("//div[@class='activity-title']");
		assertEquals(RuntimeVariables.replace(
				"Reposted From Joe: Microblogs Post"),
			selenium.getText("//div[@class='activity-title']"));
		selenium.open("/web/socialoffice01/so/microblogs");
		selenium.waitForVisible("//div[@class='user-name']");
		assertEquals(RuntimeVariables.replace(
				"Social01 Office01 User01 Reposted From Joe Bloggs"),
			selenium.getText("//div[@class='user-name']"));
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='user-name']/span"));
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("//div[@class='content']"));
	}
}