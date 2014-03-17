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

package com.liferay.portalweb.demo.useradmin.usermanagementuserprofile;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portalweb.portal.BaseTestCase;

import com.liferay.portalweb.portal.util.TestPropsValues;

/**
 * @author Brian Wing Shun Chan
 */
public class EvaluateUserCSVFileTest extends BaseTestCase {

	public void testEvaluateUserCSVFile() throws Exception {
		assertTrue(evaluateUserCSVFile());
	}

	private boolean evaluateUserCSVFile() throws Exception {
		String fileName = TestPropsValues.OUTPUT_DIR_NAME + "users.csv";

		String xml = FileUtil.read(fileName);

		if (!xml.contains("Joe Bloggs,test@liferay.com")) {
			return false;
		}

		if (!xml.contains(
				"selen01 lenn nium01,liferay.qa.server.trunk2@gmail.com")) {

			return false;
		}

		if (!xml.contains("selen02 lenn nium02,test02@selenium.com")) {
			return false;
		}

		return true;
	}

}