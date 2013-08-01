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

package com.liferay.portalweb.portlet.wikidisplay.wikipage.copywdfrontpage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CopyWDFrontPageTest extends BaseTestCase {
	public void testCopyWDFrontPage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace("Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Details"),
			selenium.getText(
				"//div[@class='page-actions top-actions']/span/a[contains(.,'Details')]"));
		selenium.clickAt("//div[@class='page-actions top-actions']/span/a[contains(.,'Details')]",
			RuntimeVariables.replace("Details"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Copy"),
			selenium.getText(
				"//ul[@class='lfr-component taglib-icon-list']/li/a/span[contains(.,'Copy')]"));
		selenium.clickAt("//ul[@class='lfr-component taglib-icon-list']/li/a/span[contains(.,'Copy')]",
			RuntimeVariables.replace("Copy"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.type("//input[contains(@id,'title')]",
			RuntimeVariables.replace("FrontPage2"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace("Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("All Pages"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'All Pages')]"));
		selenium.clickAt("//ul[@class='top-links-navigation']/li/span[contains(.,'All Pages')]/a",
			RuntimeVariables.replace("All Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage2"),
			selenium.getText("//tr[4]/td[1]/a"));
		selenium.clickAt("//tr[4]/td[1]/a",
			RuntimeVariables.replace("FrontPage2"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage2"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
	}
}