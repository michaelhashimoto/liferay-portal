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

package com.liferay.portalweb.socialofficehome.mydocuments.dmdocument.movedmfolder1documentfolder2;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.mydocuments.dmdocument.adddmfolderdocument.AddDMFolder1DocumentTest;
import com.liferay.portalweb.socialofficehome.mydocuments.dmdocument.adddmfolderdocument.AddDMFolder1Test;
import com.liferay.portalweb.socialofficehome.mydocuments.dmdocument.adddmfolderdocument.AddDMFolder2Test;
import com.liferay.portalweb.socialofficehome.mydocuments.dmdocument.adddmfolderdocument.TearDownDMFolderTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveDMFolder1DocumentFolder2Tests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddDMFolder1Test.class);
		testSuite.addTestSuite(AddDMFolder2Test.class);
		testSuite.addTestSuite(AddDMFolder1DocumentTest.class);
		testSuite.addTestSuite(MoveDMFolder1DocumentFolder2Test.class);
		testSuite.addTestSuite(TearDownDMFolderTest.class);

		return testSuite;
	}
}