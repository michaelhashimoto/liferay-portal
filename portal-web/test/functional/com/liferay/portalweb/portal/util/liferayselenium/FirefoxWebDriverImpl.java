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

package com.liferay.portalweb.portal.util.liferayselenium;

import com.liferay.portalweb.portal.util.TestPropsValues;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author Brian Wing Shun Chan
 */
public class FirefoxWebDriverImpl extends BaseWebDriverImpl {

	public FirefoxWebDriverImpl(String projectDir, String browserURL) {
		super(projectDir, browserURL, new FirefoxDriver(_firefoxProfile));
	}

	private static FirefoxProfile _firefoxProfile = new FirefoxProfile();

	static {
		_firefoxProfile.setPreference(
			"browser.download.dir", TestPropsValues.OUTPUT_DIR);
		_firefoxProfile.setPreference("browser.download.folderList", 2);
		_firefoxProfile.setPreference(
			"browser.download.manager.showWhenStarting", false);
		_firefoxProfile.setPreference("browser.download.useDownloadDir", true);
		_firefoxProfile.setPreference(
			"browser.helperApps.alwaysAsk.force", false);
		_firefoxProfile.setPreference(
			"browser.helperApps.neverAsk.saveToDisk", "application/zip");
		_firefoxProfile.setPreference("dom.max_chrome_script_run_time", 300);
		_firefoxProfile.setPreference("dom.max_script_run_time", 300);
	}

}