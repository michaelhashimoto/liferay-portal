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

package com.liferay.portalweb.asset.wiki.wikipage;

import com.liferay.portalweb.asset.wiki.wikipage.viewconfigureportletabstractswikipageap.ViewConfigurePortletAbstractsWikiPageAPTests;
import com.liferay.portalweb.asset.wiki.wikipage.viewconfigureportletavailablewikipageap.ViewConfigurePortletAvailableWikiPageAPTests;
import com.liferay.portalweb.asset.wiki.wikipage.viewconfigureportletcurrentwikipageap.ViewConfigurePortletCurrentWikiPageAPTests;
import com.liferay.portalweb.asset.wiki.wikipage.viewconfigureportletfullcontentwikipageap.ViewConfigurePortletFullContentWikiPageAPTests;
import com.liferay.portalweb.asset.wiki.wikipage.viewconfigureportlettablewikipageap.ViewConfigurePortletTableWikiPageAPTests;
import com.liferay.portalweb.asset.wiki.wikipage.viewconfigureportlettitlelistwikipageap.ViewConfigurePortletTitleListWikiPageAPTests;
import com.liferay.portalweb.asset.wiki.wikipage.viewwikipageviewcountap.ViewWikiPageViewCountAPTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiPageTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewWikiPageViewCountAPTests.suite());
		testSuite.addTest(ViewConfigurePortletAbstractsWikiPageAPTests.suite());
		testSuite.addTest(ViewConfigurePortletAvailableWikiPageAPTests.suite());
		testSuite.addTest(ViewConfigurePortletCurrentWikiPageAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletFullContentWikiPageAPTests.suite());
		testSuite.addTest(ViewConfigurePortletTableWikiPageAPTests.suite());
		testSuite.addTest(ViewConfigurePortletTitleListWikiPageAPTests.suite());

		return testSuite;
	}

}