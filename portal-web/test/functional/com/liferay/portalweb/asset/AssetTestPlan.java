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

package com.liferay.portalweb.asset;

import com.liferay.portalweb.asset.assetpublisher.AssetPublisherTestPlan;
import com.liferay.portalweb.asset.blogs.BlogsTestPlan;
import com.liferay.portalweb.asset.bookmarks.BookmarksTestPlan;
import com.liferay.portalweb.asset.documentsandmedia.DocumentsAndMediaTestPlan;
import com.liferay.portalweb.asset.messageboards.MessageBoardsTestPlan;
import com.liferay.portalweb.asset.webcontent.WebContentTestPlan;
import com.liferay.portalweb.asset.wiki.WikiTestPlan;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AssetPublisherTestPlan.suite());
		testSuite.addTest(BlogsTestPlan.suite());
		testSuite.addTest(BookmarksTestPlan.suite());
		testSuite.addTest(DocumentsAndMediaTestPlan.suite());
		testSuite.addTest(MessageBoardsTestPlan.suite());
		testSuite.addTest(WebContentTestPlan.suite());
		testSuite.addTest(WikiTestPlan.suite());

		return testSuite;
	}

}