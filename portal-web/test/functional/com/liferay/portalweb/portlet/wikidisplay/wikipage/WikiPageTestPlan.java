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

package com.liferay.portalweb.portlet.wikidisplay.wikipage;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.addwdfrontpagechildpage.AddWDFrontPageChildPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.addwdfrontpagechildpageformathtml.AddWDFrontPageChildPageFormatHTMLTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.addwdfrontpagechildpagemultiple.AddWDFrontPageChildPageMultipleTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.addwdfrontpagechildpagenameduplicate.AddWDFrontPageChildPageNameDuplicateTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.addwdfrontpagechildpagenameinvalid.AddWDFrontPageChildPageNameInvalidTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.addwdfrontpagechildpagenamenull.AddWDFrontPageChildPageNameNullTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.canceladdwdfrontpagechildpage.CancelAddWDFrontPageChildPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.changeparentwdfrontpagechildpagetonone.ChangeParentWDFrontPageChildPageToNoneTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.compareversioneditwikifrontpage.CompareVersionEditWikiFrontPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.compareversioneditwikifrontpageminorchange.CompareVersionEditWikiFrontPageMinorChangeTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.copywdfrontpage.CopyWDFrontPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.deletewdfrontpagechildpage.DeleteWDFrontPageChildPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.editwikifrontpage.EditWikiFrontPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.editwikifrontpageminorchange.EditWikiFrontPageMinorChangeTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.linkwdfrontpagechildpagetowdfrontpagechildpage.LinkWDFrontPageChildPageToWDFrontPageChildPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.previewwdfrontpagechildpage.PreviewWDFrontPageChildPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.removeredirectwdfrontpagechildpage.RemoveRedirectWDFrontPageChildPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.renamewdfrontpagechildpage.RenameWDFrontPageChildPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.reverteditwikifrontpage.RevertEditWikiFrontPageTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.reverteditwikifrontpageminorchange.RevertEditWikiFrontPageMinorChangeTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.viewwikifrontpagewd.ViewWikiFrontPageWDTests;
import com.liferay.portalweb.portlet.wikidisplay.wikipage.viewwikifrontpagewdscopecurrentpage.ViewWikiFrontPageWDScopeCurrentPageTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiPageTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddWDFrontPageChildPageTests.suite());
		testSuite.addTest(AddWDFrontPageChildPageFormatHTMLTests.suite());
		testSuite.addTest(AddWDFrontPageChildPageMultipleTests.suite());
		testSuite.addTest(AddWDFrontPageChildPageNameDuplicateTests.suite());
		testSuite.addTest(AddWDFrontPageChildPageNameInvalidTests.suite());
		testSuite.addTest(AddWDFrontPageChildPageNameNullTests.suite());
		testSuite.addTest(CancelAddWDFrontPageChildPageTests.suite());
		testSuite.addTest(ChangeParentWDFrontPageChildPageToNoneTests.suite());
		testSuite.addTest(CompareVersionEditWikiFrontPageTests.suite());
		testSuite.addTest(
			CompareVersionEditWikiFrontPageMinorChangeTests.suite());
		testSuite.addTest(CopyWDFrontPageTests.suite());
		testSuite.addTest(DeleteWDFrontPageChildPageTests.suite());
		testSuite.addTest(EditWikiFrontPageTests.suite());
		testSuite.addTest(EditWikiFrontPageMinorChangeTests.suite());
		testSuite.addTest(
			LinkWDFrontPageChildPageToWDFrontPageChildPageTests.suite());
		testSuite.addTest(PreviewWDFrontPageChildPageTests.suite());
		testSuite.addTest(RemoveRedirectWDFrontPageChildPageTests.suite());
		testSuite.addTest(RenameWDFrontPageChildPageTests.suite());
		testSuite.addTest(RevertEditWikiFrontPageTests.suite());
		testSuite.addTest(RevertEditWikiFrontPageMinorChangeTests.suite());
		testSuite.addTest(ViewWikiFrontPageWDTests.suite());
		testSuite.addTest(ViewWikiFrontPageWDScopeCurrentPageTests.suite());

		return testSuite;
	}

}