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

package com.liferay.portalweb.portal.evaluatelog;

import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.liferayselenium.LiferaySeleniumHelper;

/**
 * @author Brian Wing Shun Chan
 */
public class EvaluateLogTest extends BaseTestCase {

	@Override
	public void setUp() throws Exception {
	}

	public void testEvaluateLog() throws Exception {
		assertTrue(evaluateLog());
	}

	@Override
	public void tearDown() throws Exception {
	}

	private boolean evaluateLog() throws Exception {
		LiferaySeleniumHelper.assertLiferayErrors();

		String xml = FileUtil.read("log");

		UnsyncBufferedReader unsyncBufferedReader = new UnsyncBufferedReader(
			new UnsyncStringReader(xml));

		String line = null;

		while ((line = unsyncBufferedReader.readLine()) != null) {
			if (!line.contains("Exception") && !line.contains("SEVERE")) {
				continue;
			}

			if (LiferaySeleniumHelper.isIgnorableErrorLine(line)) {
				continue;
			}

			System.out.println("\nException Line:\n\n" + line + "\n");

			return false;
		}

		return true;
	}

}