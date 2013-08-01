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

package com.liferay.portalweb.portal.dbupgrade.sampledata611.webcontent.imageassociation;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageAssociationTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddCommunityWebContentImageAssociationTest.class);
		testSuite.addTestSuite(AddPageIGTest.class);
		testSuite.addTestSuite(AddPortletIGTest.class);
		testSuite.addTestSuite(AddPageWCDTest.class);
		testSuite.addTestSuite(AddPortletWCDTest.class);
		testSuite.addTestSuite(ConfigurePortletShowActionsTest.class);
		testSuite.addTestSuite(ConfigurePortletShowFolderMenuTest.class);
		testSuite.addTestSuite(AddIGFolderTest.class);
		testSuite.addTestSuite(AddIGFolderImageTest.class);
		testSuite.addTestSuite(AddStructureImageAssociationTest.class);
		testSuite.addTestSuite(AddTemplateImageAssociationTest.class);
		testSuite.addTestSuite(AddWebContentImageAssociationTest.class);
		testSuite.addTestSuite(SelectWebContentImageAssociationTest.class);
		testSuite.addTestSuite(ViewWebContentImageAssociationTest.class);

		return testSuite;
	}
}