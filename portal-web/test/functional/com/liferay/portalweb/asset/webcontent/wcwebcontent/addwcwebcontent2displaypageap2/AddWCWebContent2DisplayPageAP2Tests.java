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

package com.liferay.portalweb.asset.webcontent.wcwebcontent.addwcwebcontent2displaypageap2;

import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPageAP1Test;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPageAP2Test;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPortletAPPageAP1Test;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPortletAPPageAP2Test;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontent.TearDownWCWebContentTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWCWebContent2DisplayPageAP2Tests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageAP1Test.class);
		testSuite.addTestSuite(AddPageAP2Test.class);
		testSuite.addTestSuite(AddPortletAPPageAP1Test.class);
		testSuite.addTestSuite(AddPortletAPPageAP2Test.class);
		testSuite.addTestSuite(ConfigurePageAP1PortletAPDisplayPageTest.class);
		testSuite.addTestSuite(ConfigurePageAP1PortletAPSetAsDefaultTest.class);
		testSuite.addTestSuite(ConfigurePageAP2PortletAPSetAsDefaultTest.class);
		testSuite.addTestSuite(AddWCWebContent1DisplayPageAP1Test.class);
		testSuite.addTestSuite(AddWCWebContent2DisplayPageAP2Test.class);
		testSuite.addTestSuite(ViewWCWebContent1DisplayPageAP1Test.class);
		testSuite.addTestSuite(ViewWCWebContent2DisplayPageAP2Test.class);
		testSuite.addTestSuite(TearDownWCWebContentTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}