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

package com.liferay.portalweb.socialofficehome.sites.site.sousfavoritesite1;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_FavoriteSite1Test extends BaseTestCase {
	public void testSOUs_FavoriteSite1() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		assertTrue(selenium.isVisible("//input[@class='search-input']"));
		selenium.type("//input[@class='search-input']",
			RuntimeVariables.replace("Open"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site1 Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		assertTrue(selenium.isVisible(
				"//li[contains(@class, 'social-office-enabled')]/span[@class='action favorite']/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[@class='action favorite']/a",
			RuntimeVariables.replace("Favorite"));
		selenium.waitForElementPresent(
			"//li[contains(@class, 'social-office-enabled')]/span[@class='action unfavorite']/a");
		assertTrue(selenium.isElementPresent(
				"//li[contains(@class, 'social-office-enabled')]/span[@class='action unfavorite']/a"));
	}
}