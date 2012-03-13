/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.stagingcommunity.sites.usecase.demo2;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class Demo2cTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(ActivateRemoteStagingCommunitySiteTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User_SignInTest.class);
		testSuite.addTestSuite(User_AssertGoToRemoteLiveLinkTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLiveNowSiteStagingTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveNowSiteStagingTest.class);
		testSuite.addTestSuite(User_AddTestPageTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLiveNowTestPageSiteStagingTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveNowTestPageSiteStagingTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLiveNowDeleteLivePageSiteStagingTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveNowDeleteLivePageSiteStagingTest.class);
		testSuite.addTestSuite(User_DeleteTestPageTest.class);
		testSuite.addTestSuite(User_DragAndDropPortletMBColumn2SiteStagingTest.class);
		testSuite.addTestSuite(User_DragAndDropPortletUSColumn1SiteStagingTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLiveNowHomePageSiteStagingTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveNowHomePageSiteStagingTest.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(DefinePermissionsDocumentsStagingAdminTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User_SignInTest.class);
		testSuite.addTestSuite(User_AddPortletDLSiteStagingTest.class);
		testSuite.addTestSuite(User_AddDLImageSiteStagingTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLiveNowNoDLDocumentsSiteStagingTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveNowNoDLDocumentsLiveTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLiveNowDLDocumentsSiteStagingTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveNowDLDocumentsLiveTest.class);
		testSuite.addTestSuite(User_EditSiteSettingsPublicPageVersioningEnabledTest.class);
		testSuite.addTestSuite(User_DragAndDropPortletDLColumn2SiteStagingTest.class);
		testSuite.addTestSuite(User_DragAndDropPortletMBColumn1SiteStagingTest.class);
		testSuite.addTestSuite(User_ViewHistoryVersionNumbersTest.class);
		testSuite.addTestSuite(User_SelectPreviousVersionNumberHistoryTest.class);
		testSuite.addTestSuite(User_ViewSelectPreviousVersionNumberHistoryTest.class);
		testSuite.addTestSuite(User_SelectTopVersionNumberHistoryTest.class);
		testSuite.addTestSuite(User_ViewSelectTopVersionNumberHistoryTest.class);
		testSuite.addTestSuite(User_MarkAsReadyForPublicationPageLayoutOneColumnTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLiveNowPageLayoutOneColumnTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveNowPageLayoutOneColumnTest.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(DefinePermissionsWebContentStagingAdminTest.class);
		testSuite.addTestSuite(DefinePermissionsWCDStagingAdminTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User_SignInTest.class);
		testSuite.addTestSuite(User_AddPortletWCDSiteStagingTest.class);
		testSuite.addTestSuite(User_AddWCWebContentWCDSiteStagingTest.class);
		testSuite.addTestSuite(User_MarkAsReadyForPublicationWCDSiteStagingTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLiveNowWCDSiteStagingTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveNowWCDSiteStagingTest.class);
		testSuite.addTestSuite(User_RenameMainSPVariationSeasonTest.class);
		testSuite.addTestSuite(User_AddSPVariationChristmasCopyFromSeasonTest.class);
		testSuite.addTestSuite(User_ViewSPVariationChristmasCopyFromSeasonTest.class);
		testSuite.addTestSuite(User_AddPageWhiteElephantSPVariationChristmasTest.class);
		testSuite.addTestSuite(User_AddPortletNavigationPageWhiteElephantTest.class);
		testSuite.addTestSuite(User_MarkAsReadyForPublicationPageWhiteElephantTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLiveNowSPVariationChristmasTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveNowSPVariationChristmasTest.class);
		testSuite.addTestSuite(User_EnableInSeasonPageWhiteElephantSiteStagingTest.class);
		testSuite.addTestSuite(User_ViewEnableInSeasonPageWhiteElephantTest.class);
		testSuite.addTestSuite(User_DeletePageWhiteElephantSPVariationSeasonTest.class);
		testSuite.addTestSuite(User_ViewDeletePageWhiteElephantSPVariationSeasonTest.class);
		testSuite.addTestSuite(User_RenameMainPageVariationRegularSPSeasonTest.class);
		testSuite.addTestSuite(User_AddPageVariationSantaSPVariationSeasonTest.class);
		testSuite.addTestSuite(User_AddPageVariationFrostySPVariationSeasonTest.class);
		testSuite.addTestSuite(User_AddPortletBlogsSPVariationSantaTest.class);
		testSuite.addTestSuite(User_MarkAsReadyForPublicationPageVariationSantaTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLivePageVariationSantaSPSeasonTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLivePageVariationSantaSPSeasonTest.class);
		testSuite.addTestSuite(User_DeletePageVariationFrostySPVariationSeasonTest.class);
		testSuite.addTestSuite(User_ViewDeletePageVariationFrostySPSeasonTest.class);
		testSuite.addTestSuite(User_AddSPVariationChristmas2CopyChristmasTest.class);
		testSuite.addTestSuite(User_ViewSPVariationChristmas2CopyChristmasTest.class);
		testSuite.addTestSuite(User_AddSPVariationValentinesCopyFromNoneTest.class);
		testSuite.addTestSuite(User_ViewSPVariationValentinesCopyFromNoneTest.class);
		testSuite.addTestSuite(User_AddPagePricesSPVariationValentinesTest.class);
		testSuite.addTestSuite(User_MarkAsReadyForPublicationSPValentinesTest.class);
		testSuite.addTestSuite(User_PublishToRemoteLiveNowSPVariationValentinesTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveNowSPVariationValentinesTest.class);
		testSuite.addTestSuite(User_MergeSPChristmasSPValentinesTest.class);
		testSuite.addTestSuite(User_ViewMergeSPChristmasSPValentinesTest.class);
		testSuite.addTestSuite(User_EnableInChristmasPagePricesSiteStagingTest.class);
		testSuite.addTestSuite(User_ViewEnableInChristmasPagePricesTest.class);
		testSuite.addTestSuite(User_DeleteSPVariationValentinesTest.class);
		testSuite.addTestSuite(User_ViewDeleteSPVariationValentinesTest.class);
		testSuite.addTestSuite(User_ViewPublishToRemoteLiveCurrentTest.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownRolesTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);

		return testSuite;
	}
}