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

package com.liferay.portalweb.portlet.wiki.wikinode.addwikinodenamenull;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWikiNodeNameNullTest extends BaseTestCase {
	public void testAddWikiNodeNameNull() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki"),
			selenium.getText("//ul[@class='category-portlets']/li[11]/a"));
		selenium.clickAt("//ul[@class='category-portlets']/li[11]/a",
			RuntimeVariables.replace("Wiki"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Wiki']",
			RuntimeVariables.replace("Add Wiki"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_154_name']", RuntimeVariables.replace(""));
		selenium.type("//textarea[@id='_154_description']",
			RuntimeVariables.replace("Wiki Node Description"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//fieldset/div/span[1]/span/span");
		assertEquals(RuntimeVariables.replace("This field is required."),
			selenium.getText("//fieldset/div/span[1]/span/span"));
	}
}