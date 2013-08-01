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

package com.liferay.portalweb.asset.documentsandmedia.dmimage.viewconfigureportletabstractsdmimageap;

import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPageAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPortletAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletdisplaystyleabstracts.ConfigurePortletDisplayStyleAbstractsTest;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.addnewdmfolderimageapactions.AddDMFolderTest;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.addnewdmfolderimageapactions.AddNewDMFolderImageAPActionsTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocument.adddmdocument.TearDownDMDocumentTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPageDMTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPortletDMTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewConfigurePortletAbstractsDMImageAPTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(AddPageDMTest.class);
		testSuite.addTestSuite(AddPortletDMTest.class);
		testSuite.addTestSuite(AddDMFolderTest.class);
		testSuite.addTestSuite(AddNewDMFolderImageAPActionsTest.class);
		testSuite.addTestSuite(ConfigurePortletDisplayStyleAbstractsTest.class);
		testSuite.addTestSuite(ViewConfigurePortletAbstractsDMImageAPTest.class);
		testSuite.addTestSuite(TearDownDMDocumentTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}