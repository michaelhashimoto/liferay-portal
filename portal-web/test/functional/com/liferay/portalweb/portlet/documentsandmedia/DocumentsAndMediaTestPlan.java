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

package com.liferay.portalweb.portlet.documentsandmedia;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.documentsandmedia.dmcomment.DMCommentTestPlan;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocument.DMDocumentTestPlan;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocumenttype.DMDocumentTypeTestPlan;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.DMFolderTestPlan;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.DMImageTestPlan;
import com.liferay.portalweb.portlet.documentsandmedia.dmlar.DMLARTestPlan;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.PortletTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentsAndMediaTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(DMCommentTestPlan.suite());
		testSuite.addTest(DMDocumentTestPlan.suite());
		testSuite.addTest(DMDocumentTypeTestPlan.suite());
		testSuite.addTest(DMFolderTestPlan.suite());
		testSuite.addTest(DMImageTestPlan.suite());
		testSuite.addTest(DMLARTestPlan.suite());
		testSuite.addTest(PortletTestPlan.suite());

		return testSuite;
	}

}