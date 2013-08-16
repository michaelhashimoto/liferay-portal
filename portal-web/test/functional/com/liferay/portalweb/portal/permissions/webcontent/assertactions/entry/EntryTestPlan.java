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

package com.liferay.portalweb.portal.permissions.webcontent.assertactions.entry;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.permissions.webcontent.assertactions.entry.adddiscussion.AddDiscussionTests;
import com.liferay.portalweb.portal.permissions.webcontent.assertactions.entry.delete.DeleteTests;
import com.liferay.portalweb.portal.permissions.webcontent.assertactions.entry.deletediscussion.DeleteDiscussionTests;
import com.liferay.portalweb.portal.permissions.webcontent.assertactions.entry.expire.ExpireTests;
import com.liferay.portalweb.portal.permissions.webcontent.assertactions.entry.permissions.PermissionsTests;
import com.liferay.portalweb.portal.permissions.webcontent.assertactions.entry.update.UpdateTests;
import com.liferay.portalweb.portal.permissions.webcontent.assertactions.entry.updatediscussion.UpdateDiscussionTests;
import com.liferay.portalweb.portal.permissions.webcontent.assertactions.entry.view.ViewTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddDiscussionTests.suite());
		testSuite.addTest(DeleteTests.suite());
		testSuite.addTest(DeleteDiscussionTests.suite());
		testSuite.addTest(ExpireTests.suite());
		testSuite.addTest(PermissionsTests.suite());
		testSuite.addTest(UpdateTests.suite());
		testSuite.addTest(UpdateDiscussionTests.suite());
		testSuite.addTest(ViewTests.suite());

		return testSuite;
	}

}