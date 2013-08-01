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

package com.liferay.portalweb.demo.media;

import com.liferay.portalweb.demo.media.dmautomaticallyextractedmetadata.DMAutomaticallyExtractedMetaDataTests;
import com.liferay.portalweb.demo.media.dmcheckincheckoutdocument.DMCheckinCheckoutDocumentTests;
import com.liferay.portalweb.demo.media.dmdocumenttypemusic.DMDocumentTypeMusicTests;
import com.liferay.portalweb.demo.media.dmdraganddropdocument.DMDragAndDropDocumentTests;
import com.liferay.portalweb.demo.media.dmkaleo1workflow.DMKaleo1WorkflowTests;
import com.liferay.portalweb.demo.media.dmkaleo2workflow.DMKaleo2WorkflowTests;
import com.liferay.portalweb.demo.media.dmlardocumenttypemusic.DMLARDocumentTypeMusicTests;
import com.liferay.portalweb.demo.media.dmstagingdocumenttypemusic.DMStagingDocumentTypeMusicTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MediaTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(DMAutomaticallyExtractedMetaDataTests.suite());
		testSuite.addTest(DMCheckinCheckoutDocumentTests.suite());
		testSuite.addTest(DMDocumentTypeMusicTests.suite());
		testSuite.addTest(DMDragAndDropDocumentTests.suite());
		testSuite.addTest(DMKaleo1WorkflowTests.suite());
		testSuite.addTest(DMKaleo2WorkflowTests.suite());
		testSuite.addTest(DMLARDocumentTypeMusicTests.suite());
		testSuite.addTest(DMStagingDocumentTypeMusicTests.suite());

		return testSuite;
	}

}