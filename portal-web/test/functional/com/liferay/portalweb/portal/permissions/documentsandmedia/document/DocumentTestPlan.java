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

package com.liferay.portalweb.portal.permissions.documentsandmedia.document;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.permissions.documentsandmedia.document.guestviewdldocumentinline.Guest_ViewDmDocumentInlineTests;
import com.liferay.portalweb.portal.permissions.documentsandmedia.document.useradddmdocumentinline.User_AddDmDocumentInlineTests;
import com.liferay.portalweb.portal.permissions.documentsandmedia.document.useradddmdocumentscopeportal.User_AddDmDocumentScopePortalTests;
import com.liferay.portalweb.portal.permissions.documentsandmedia.document.useradddmdocumentscopesite.User_AddDmDocumentScopeSiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(Guest_ViewDmDocumentInlineTests.suite());
		testSuite.addTest(User_AddDmDocumentInlineTests.suite());
		testSuite.addTest(User_AddDmDocumentScopePortalTests.suite());
		testSuite.addTest(User_AddDmDocumentScopeSiteTests.suite());

		return testSuite;
	}

}