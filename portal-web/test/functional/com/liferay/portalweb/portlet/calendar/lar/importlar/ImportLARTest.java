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

package com.liferay.portalweb.portlet.calendar.lar.importlar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ImportLARTest extends BaseTestCase {
	public void testImportLAR() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Calendar Test Page",
					RuntimeVariables.replace("Calendar Test Page"));
				selenium.waitForPageToLoad("30000");
				Thread.sleep(1000);
				selenium.waitForVisible("//strong/a");
				selenium.clickAt("//strong/a",
					RuntimeVariables.replace("Options"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a");
				assertEquals(RuntimeVariables.replace("Export / Import"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a",
					RuntimeVariables.replace("Export / Import"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Import",
					RuntimeVariables.replace("Import"));
				selenium.waitForPageToLoad("30000");
				selenium.uploadFile("//input[@id='_86_importFileName']",
					RuntimeVariables.replace(
						"L:\\portal\\build\\portal-web\\test\\functional\\com\\liferay\\portalweb\\portlet\\calendar\\lar\\importlar\\dependencies\\Calendar-Selenium.portlet.lar"));

				boolean deleteBeforeImportNotChecked = selenium.isChecked(
						"//input[@id='_86_DELETE_PORTLET_DATACheckbox']");

				if (deleteBeforeImportNotChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_86_DELETE_PORTLET_DATACheckbox']",
					RuntimeVariables.replace(
						"Delete portlet data before importing."));

			case 2:
				assertTrue(selenium.isChecked(
						"//input[@id='_86_DELETE_PORTLET_DATACheckbox']"));

				boolean dataNotChecked = selenium.isChecked(
						"//input[@id='_86_PORTLET_DATACheckbox']");

				if (dataNotChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("//input[@id='_86_PORTLET_DATACheckbox']",
					RuntimeVariables.replace("Data"));

			case 3:
				assertTrue(selenium.isChecked(
						"//input[@id='_86_PORTLET_DATACheckbox']"));
				selenium.clickAt("//input[@value='Import']",
					RuntimeVariables.replace("Import"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 100:
				label = -1;
			}
		}
	}
}