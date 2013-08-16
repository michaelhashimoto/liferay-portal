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

package com.liferay.portalweb.portlet.rss.webcontent;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.rss.webcontent.removewcwebcontentfooterrss.RemoveWCWebContentFooterRSSTests;
import com.liferay.portalweb.portlet.rss.webcontent.removewcwebcontentheaderrss.RemoveWCWebContentHeaderRSSTests;
import com.liferay.portalweb.portlet.rss.webcontent.selectwcwebcontentfooterrss.SelectWCWebContentFooterRSSTests;
import com.liferay.portalweb.portlet.rss.webcontent.selectwcwebcontentheaderrss.SelectWCWebContentHeaderRSSTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WebContentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(RemoveWCWebContentFooterRSSTests.suite());
		testSuite.addTest(RemoveWCWebContentHeaderRSSTests.suite());
		testSuite.addTest(SelectWCWebContentFooterRSSTests.suite());
		testSuite.addTest(SelectWCWebContentHeaderRSSTests.suite());

		return testSuite;
	}

}