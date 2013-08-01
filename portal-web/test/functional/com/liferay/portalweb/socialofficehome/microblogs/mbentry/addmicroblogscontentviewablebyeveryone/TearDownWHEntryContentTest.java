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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontentviewablebyeveryone;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownWHEntryContentTest extends BaseTestCase {
	public void testTearDownWHEntryContent() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
					RuntimeVariables.replace("Microblogs"));
				selenium.waitForPageToLoad("30000");
				Thread.sleep(1000);

				boolean whatsHappeningEntry1Present = selenium.isElementPresent(
						"//span[@class='action delete']/a");

				if (!whatsHappeningEntry1Present) {
					label = 2;

					continue;
				}

				selenium.clickAt("//span[@class='action delete']/a",
					RuntimeVariables.replace("Delete"));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this post[\\s\\S]$"));
				Thread.sleep(1000);

				boolean whatsHappeningEntry2Present = selenium.isElementPresent(
						"//span[@class='action delete']/a");

				if (!whatsHappeningEntry2Present) {
					label = 3;

					continue;
				}

				selenium.clickAt("//span[@class='action delete']/a",
					RuntimeVariables.replace("Delete"));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this post[\\s\\S]$"));
				Thread.sleep(1000);

				boolean whatsHappeningEntry3Present = selenium.isElementPresent(
						"//span[@class='action delete']/a");

				if (!whatsHappeningEntry3Present) {
					label = 4;

					continue;
				}

				selenium.clickAt("//span[@class='action delete']/a",
					RuntimeVariables.replace("Delete"));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this post[\\s\\S]$"));
				Thread.sleep(1000);

				boolean whatsHappeningEntry4Present = selenium.isElementPresent(
						"//span[@class='action delete']/a");

				if (!whatsHappeningEntry4Present) {
					label = 5;

					continue;
				}

				selenium.clickAt("//span[@class='action delete']/a",
					RuntimeVariables.replace("Delete"));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this post[\\s\\S]$"));
				Thread.sleep(1000);

				boolean whatsHappeningEntry5Present = selenium.isElementPresent(
						"//span[@class='action delete']/a");

				if (!whatsHappeningEntry5Present) {
					label = 6;

					continue;
				}

				selenium.clickAt("//span[@class='action delete']/a",
					RuntimeVariables.replace("Delete"));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this post[\\s\\S]$"));

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