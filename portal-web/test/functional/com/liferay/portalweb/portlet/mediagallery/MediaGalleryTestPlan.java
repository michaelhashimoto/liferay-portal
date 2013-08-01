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

package com.liferay.portalweb.portlet.mediagallery;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.DMFolderTestPlan;
import com.liferay.portalweb.portlet.mediagallery.dmimage.DMImageTestPlan;
import com.liferay.portalweb.portlet.mediagallery.mglar.MGLARTestPlan;
import com.liferay.portalweb.portlet.mediagallery.portlet.PortletTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MediaGalleryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(DMFolderTestPlan.suite());
		testSuite.addTest(DMImageTestPlan.suite());
		testSuite.addTest(MGLARTestPlan.suite());
		testSuite.addTest(PortletTestPlan.suite());

		return testSuite;
	}

}