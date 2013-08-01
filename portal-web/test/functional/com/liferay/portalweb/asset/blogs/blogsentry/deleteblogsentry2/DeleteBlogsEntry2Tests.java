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

package com.liferay.portalweb.asset.blogs.blogsentry.deleteblogsentry2;

import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPageAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPortletAPTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DeleteBlogsEntry2Tests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletBlogsTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(ConfigurePortletAssetLinkBehaviorShowFullContentTest.class);
		testSuite.addTestSuite(AddBlogsEntry1Test.class);
		testSuite.addTestSuite(AddBlogsEntry2Test.class);
		testSuite.addTestSuite(DeleteBlogsEntry2Test.class);
		testSuite.addTestSuite(TearDownBlogsEntryAPTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}