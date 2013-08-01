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

package com.liferay.portalweb.portal.controlpanel.pagetemplates.pagetemplate.activatepagetemplate;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.pagetemplates.pagetemplate.addpagetemplate.AddPageTemplateTest;
import com.liferay.portalweb.portal.controlpanel.pagetemplates.pagetemplate.addpagetemplate.TearDownPageTemplateTest;
import com.liferay.portalweb.portal.controlpanel.pagetemplates.pagetemplate.deactivatepagetemplate.DeactivatePageTemplateTest;
import com.liferay.portalweb.portal.controlpanel.pagetemplates.pagetemplate.deactivatepagetemplate.ViewInactivePageTemplateTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ActivatePageTemplateTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageTemplateTest.class);
		testSuite.addTestSuite(DeactivatePageTemplateTest.class);
		testSuite.addTestSuite(ViewInactivePageTemplateTest.class);
		testSuite.addTestSuite(ActivatePageTemplateTest.class);
		testSuite.addTestSuite(ViewActivePageTemplateTest.class);
		testSuite.addTestSuite(TearDownPageTemplateTest.class);

		return testSuite;
	}
}