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

package com.liferay.portalweb.portlet.wiki;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.wiki.attachment.AttachmentTestPlan;
import com.liferay.portalweb.portlet.wiki.comment.CommentTestPlan;
import com.liferay.portalweb.portlet.wiki.lar.LARTestPlan;
import com.liferay.portalweb.portlet.wiki.portlet.PortletTestPlan;
import com.liferay.portalweb.portlet.wiki.wikinode.WikiNodeTestPlan;
import com.liferay.portalweb.portlet.wiki.wikipage.WikiPageTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AttachmentTestPlan.suite());
		testSuite.addTest(CommentTestPlan.suite());
		testSuite.addTest(LARTestPlan.suite());
		testSuite.addTest(PortletTestPlan.suite());
		testSuite.addTest(WikiNodeTestPlan.suite());
		testSuite.addTest(WikiPageTestPlan.suite());

		return testSuite;
	}

}