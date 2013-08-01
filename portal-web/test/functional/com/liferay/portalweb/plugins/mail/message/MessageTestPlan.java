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

package com.liferay.portalweb.plugins.mail.message;

import com.liferay.portalweb.plugins.mail.message.deletemessagenullallmail.DeleteMessageNullAllMailTests;
import com.liferay.portalweb.plugins.mail.message.deletemessagenulldrafts.DeleteMessageNullDraftsTests;
import com.liferay.portalweb.plugins.mail.message.deletemessagenullinbox.DeleteMessageNullInboxTests;
import com.liferay.portalweb.plugins.mail.message.deletemessagenullsentmail.DeleteMessageNullSentMailTests;
import com.liferay.portalweb.plugins.mail.message.sendmessagesubjectnull.SendMessageSubjectNullTests;
import com.liferay.portalweb.plugins.mail.message.sendmessagetonull.SendMessageToNullTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(DeleteMessageNullAllMailTests.suite());
		testSuite.addTest(DeleteMessageNullDraftsTests.suite());
		testSuite.addTest(DeleteMessageNullInboxTests.suite());
		testSuite.addTest(DeleteMessageNullSentMailTests.suite());
		testSuite.addTest(SendMessageToNullTests.suite());
		testSuite.addTest(SendMessageSubjectNullTests.suite());

		return testSuite;
	}

}