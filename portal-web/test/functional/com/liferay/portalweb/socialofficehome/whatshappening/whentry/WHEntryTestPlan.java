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

package com.liferay.portalweb.socialofficehome.whatshappening.whentry;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.whatshappening.whentry.addwhentrycontent150character.AddWHEntryContent150CharacterTests;
import com.liferay.portalweb.socialofficehome.whatshappening.whentry.addwhentrycontent151character.AddWHEntryContent151CharacterTests;
import com.liferay.portalweb.socialofficehome.whatshappening.whentry.addwhentrycontentviewablebyconnections.AddWHEntryContentViewableByConnectionsTests;
import com.liferay.portalweb.socialofficehome.whatshappening.whentry.addwhentrycontentviewablebyeveryone.AddWHEntryContentViewableByEveryoneTests;
import com.liferay.portalweb.socialofficehome.whatshappening.whentry.addwhentrycontentviewablebyfollowers.AddWHEntryContentViewableByFollowersTests;
import com.liferay.portalweb.socialofficehome.whatshappening.whentry.sousviewwhentrycontentviewablebyeveryone.SOUs_ViewWHEntryContentViewableByEveryoneTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WHEntryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddWHEntryContent150CharacterTests.suite());
		testSuite.addTest(AddWHEntryContent151CharacterTests.suite());
		testSuite.addTest(AddWHEntryContentViewableByConnectionsTests.suite());
		testSuite.addTest(AddWHEntryContentViewableByEveryoneTests.suite());
		testSuite.addTest(AddWHEntryContentViewableByFollowersTests.suite());
		testSuite.addTest(
			SOUs_ViewWHEntryContentViewableByEveryoneTests.suite());

		return testSuite;
	}

}