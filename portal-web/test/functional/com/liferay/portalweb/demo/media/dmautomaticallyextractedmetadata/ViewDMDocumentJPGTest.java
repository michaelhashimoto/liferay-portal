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

package com.liferay.portalweb.demo.media.dmautomaticallyextractedmetadata;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDMDocumentJPGTest extends BaseTestCase {
	public void testViewDMDocumentJPG() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Documents and Media Test Page",
					RuntimeVariables.replace("Documents and Media Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("DM Document Title"),
					selenium.getText(
						"//div[@data-title='DM Document Title']/a/span[2]"));
				selenium.clickAt("//div[@data-title='DM Document Title']/a/span[2]",
					RuntimeVariables.replace("DM Document Title"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Automatically Extracted Metadata"),
					selenium.getText(
						"//div[@id='documentLibraryAssetMetadataPanel']/div/div/span"));

				boolean automaticallyExtractedMetadataCollapsed = selenium.isElementPresent(
						"//div[@id='documentLibraryAssetMetadataPanel' and contains(@class,'lfr-collapsed')]");

				if (!automaticallyExtractedMetadataCollapsed) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[@id='documentLibraryAssetMetadataPanel']/div/div/span",
					RuntimeVariables.replace("Automatically Extracted Metadata"));

			case 2:
				assertEquals(RuntimeVariables.replace("Content Type image/jpeg"),
					selenium.getText(
						"//div[@id='documentLibraryAssetMetadataPanel']/div[2]/div[1]"));
				assertEquals(RuntimeVariables.replace("Bits Per Sample 8"),
					selenium.getText(
						"//div[@id='documentLibraryAssetMetadataPanel']/div[2]/div[2]"));
				assertEquals(RuntimeVariables.replace("Image Length 92"),
					selenium.getText(
						"//div[@id='documentLibraryAssetMetadataPanel']/div[2]/div[3]"));
				assertEquals(RuntimeVariables.replace("Image Width 394"),
					selenium.getText(
						"//div[@id='documentLibraryAssetMetadataPanel']/div[2]/div[4]"));
				assertTrue(selenium.isElementNotPresent(
						"xPath=(//div[@id='documentLibraryAssetMetadataPanel'])[2]/div/div/span"));

			case 100:
				label = -1;
			}
		}
	}
}