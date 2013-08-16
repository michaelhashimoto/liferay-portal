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

package com.liferay.portalweb.plugins.mail.message.deletemessagenulldrafts;

import com.liferay.portalweb.plugins.mail.mailaccount.addmailaccount.AddMailAccountTest;
import com.liferay.portalweb.plugins.mail.mailaccount.addmailaccount.TearDownMailAccountTest;
import com.liferay.portalweb.plugins.mail.portlet.addportlet.AddPageMailTest;
import com.liferay.portalweb.plugins.mail.portlet.addportlet.AddPortletMailTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DeleteMessageNullDraftsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageMailTest.class);
		testSuite.addTestSuite(AddPortletMailTest.class);
		testSuite.addTestSuite(AddMailAccountTest.class);
		testSuite.addTestSuite(DeleteMessageNullDraftsTest.class);
		testSuite.addTestSuite(TearDownMailAccountTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}