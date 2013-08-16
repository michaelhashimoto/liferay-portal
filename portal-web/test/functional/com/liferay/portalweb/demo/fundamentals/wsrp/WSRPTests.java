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

package com.liferay.portalweb.demo.fundamentals.wsrp;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPageDMTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPortletDMTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WSRPTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageTMTest.class);
		testSuite.addTestSuite(AddPortletTMTest.class);
		testSuite.addTestSuite(AddPageDMTest.class);
		testSuite.addTestSuite(AddPortletDMTest.class);
		testSuite.addTestSuite(AddWSRPProducerDPTest.class);
		testSuite.addTestSuite(CopyWSRPProducerDPURLTest.class);
		testSuite.addTestSuite(AddWSRPConsumerDPTest.class);
		testSuite.addTestSuite(AddWSRPConsumerRemoteDPTest.class);
		testSuite.addTestSuite(AddPageWSRPRemoteTMTest.class);
		testSuite.addTestSuite(AddPortletWSRPRemoteTMTest.class);
		testSuite.addTestSuite(ViewWSRPClickToInvokeResourceServingPhaseDPTest.class);
		testSuite.addTestSuite(ViewWSRPClickToInvokeResourceServingPhaseRDPTest.class);
		testSuite.addTestSuite(TearDownDLDocumentTest.class);
		testSuite.addTestSuite(TearDownWSRPConsumerDPTest.class);
		testSuite.addTestSuite(TearDownWSRPProducerDPTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}