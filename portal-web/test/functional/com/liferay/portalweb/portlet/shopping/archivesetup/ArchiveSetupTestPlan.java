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

package com.liferay.portalweb.portlet.shopping.archivesetup;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.shopping.archivesetup.deletearchivesetup.DeleteArchiveSetupTests;
import com.liferay.portalweb.portlet.shopping.archivesetup.restorearchivesetup.RestoreArchiveSetupTests;
import com.liferay.portalweb.portlet.shopping.archivesetup.savearchivesetup.SaveArchiveSetupTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ArchiveSetupTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(DeleteArchiveSetupTests.suite());
		testSuite.addTest(RestoreArchiveSetupTests.suite());
		testSuite.addTest(SaveArchiveSetupTests.suite());

		return testSuite;
	}

}