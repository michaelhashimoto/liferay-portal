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

package com.liferay.portalweb.plugins.wsrp.helloworld;

import com.liferay.portalweb.plugins.wsrp.helloworld.addconsumerhw.AddConsumerHWTests;
import com.liferay.portalweb.plugins.wsrp.helloworld.addportletwsrphw.AddPortletWSRPHWTests;
import com.liferay.portalweb.plugins.wsrp.helloworld.addportletwsrphwutf8.AddPortletWSRPHWUTF8Tests;
import com.liferay.portalweb.plugins.wsrp.helloworld.addproducerhw.AddProducerHWTests;
import com.liferay.portalweb.plugins.wsrp.helloworld.manageportletconsumerhw.ManagePortletConsumerHWTests;
import com.liferay.portalweb.plugins.wsrp.helloworld.manageportletconsumerhwutf8.ManagePortletConsumerHWUTF8Tests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class HelloWorldTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddConsumerHWTests.suite());
		testSuite.addTest(AddPortletWSRPHWTests.suite());
		testSuite.addTest(AddPortletWSRPHWUTF8Tests.suite());
		testSuite.addTest(AddProducerHWTests.suite());
		testSuite.addTest(ManagePortletConsumerHWTests.suite());
		testSuite.addTest(ManagePortletConsumerHWUTF8Tests.suite());

		return testSuite;
	}

}