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

package com.liferay.portalweb.asset.wiki.wikipage.viewwikipageviewcountap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWikiPageViewCountAPTest extends BaseTestCase {
	public void testViewWikiPageViewCountAP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");

		String viewCount = selenium.getFirstNumberIncrement(
				"//span[@class='metadata-entry metadata-view-count']");
		RuntimeVariables.setValue("viewCount", viewCount);
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Asset Publisher Test Page");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//span[@class='metadata-entry metadata-view-count']",
				RuntimeVariables.getValue("viewCount")));

		String viewCount2 = selenium.getFirstNumberIncrement(
				"//span[@class='metadata-entry metadata-view-count']");
		RuntimeVariables.setValue("viewCount2", viewCount2);
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Wiki Test Page");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//div[@class='stats']",
				RuntimeVariables.getValue("viewCount2")));

		String viewCount3 = selenium.getFirstNumberIncrement(
				"//div[@class='stats']");
		RuntimeVariables.setValue("viewCount3", viewCount3);
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Asset Publisher Test Page");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//span[@class='metadata-entry metadata-view-count']",
				RuntimeVariables.getValue("viewCount3")));
	}
}