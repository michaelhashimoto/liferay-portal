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

package com.liferay.portalweb.portlet.recentbloggers.rbentry.viewrbusernameandimage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewRBUserNameAndImageTest extends BaseTestCase {
	public void testViewRBUserNameAndImage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Recent Bloggers Test Page",
			RuntimeVariables.replace("Recent Bloggers Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible(
				"//tr[@class='portlet-section-body results-row last']/td/div/a/span[1]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td/div/a/span[2]"));
		assertEquals(RuntimeVariables.replace("Posts: 1"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td/div/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Stars: 0"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td/div/div/div[2]"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td/div/div/div[3]",
				"Date:"));
	}
}