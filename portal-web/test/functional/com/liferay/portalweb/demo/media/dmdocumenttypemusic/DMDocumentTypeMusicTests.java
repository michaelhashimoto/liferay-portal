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

package com.liferay.portalweb.demo.media.dmdocumenttypemusic;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocument.adddmdocument.TearDownDMDocumentTest;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfolder.AddDMFolderTest;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfolder.TearDownDMFolderTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPageDMTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPortletDMTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DMDocumentTypeMusicTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageDMTest.class);
		testSuite.addTestSuite(AddPortletDMTest.class);
		testSuite.addTestSuite(ConfigureDMMaximumFileSizeCPTest.class);
		testSuite.addTestSuite(AddDMMetadataSetSongInformationTest.class);
		testSuite.addTestSuite(AddDMDocumentTypeMusicTest.class);
		testSuite.addTestSuite(AddDMFolderTest.class);
		testSuite.addTestSuite(AddDMFolderMusicArtistNullTest.class);
		testSuite.addTestSuite(AddDMFolderMusicTest.class);
		testSuite.addTestSuite(AddDMFolderMusicTagMP3Test.class);
		testSuite.addTestSuite(AddDMFolderMusicTagMusicTest.class);
		testSuite.addTestSuite(ViewDMFolderMusicTest.class);
		testSuite.addTestSuite(SearchDMMusicTest.class);
		testSuite.addTestSuite(TearDownDMFolderTest.class);
		testSuite.addTestSuite(TearDownDMDocumentTest.class);
		testSuite.addTestSuite(TearDownDMDocumentTypeTest.class);
		testSuite.addTestSuite(TearDownDMMetadataSetTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}