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

package com.liferay.portalweb.socialofficesite.home.bookmarks;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficesite.home.bookmarks.addbookmarksentrysite.AddBookmarksEntrySiteTests;
import com.liferay.portalweb.socialofficesite.home.bookmarks.deletebookmarksentrysite.DeleteBookmarksEntrySiteTests;
import com.liferay.portalweb.socialofficesite.home.bookmarks.editbookmarksentrysite.EditBookmarksEntrySiteTests;
import com.liferay.portalweb.socialofficesite.home.bookmarks.editpermissionsbookmarksentry2guestnoview.EditPermissionsBookmarksEntry2GuestNoViewTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BookmarksTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddBookmarksEntrySiteTests.suite());
		testSuite.addTest(DeleteBookmarksEntrySiteTests.suite());
		testSuite.addTest(EditBookmarksEntrySiteTests.suite());
		testSuite.addTest(
			EditPermissionsBookmarksEntry2GuestNoViewTests.suite());

		return testSuite;
	}

}