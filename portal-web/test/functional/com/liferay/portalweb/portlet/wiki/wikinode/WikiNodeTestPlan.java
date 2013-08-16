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

package com.liferay.portalweb.portlet.wiki.wikinode;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.wiki.wikinode.addwikinode.AddWikiNodeTests;
import com.liferay.portalweb.portlet.wiki.wikinode.addwikinodemultiple.AddWikiNodeMultipleTests;
import com.liferay.portalweb.portlet.wiki.wikinode.addwikinodenameduplicate.AddWikiNodeNameDuplicateTests;
import com.liferay.portalweb.portlet.wiki.wikinode.addwikinodenamenull.AddWikiNodeNameNullTests;
import com.liferay.portalweb.portlet.wiki.wikinode.addwikinodenamenumber.AddWikiNodeNameNumberTests;
import com.liferay.portalweb.portlet.wiki.wikinode.addwikinodenamesymbol.AddWikiNodeNameSymbolTests;
import com.liferay.portalweb.portlet.wiki.wikinode.deletewikinode.DeleteWikiNodeTests;
import com.liferay.portalweb.portlet.wiki.wikinode.editwikinode.EditWikiNodeTests;
import com.liferay.portalweb.portlet.wiki.wikinode.viewwikinodefrontpage.ViewWikiNodeFrontPageTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiNodeTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddWikiNodeTests.suite());
		testSuite.addTest(AddWikiNodeMultipleTests.suite());
		testSuite.addTest(AddWikiNodeNameDuplicateTests.suite());
		testSuite.addTest(AddWikiNodeNameNullTests.suite());
		testSuite.addTest(AddWikiNodeNameNumberTests.suite());
		testSuite.addTest(AddWikiNodeNameSymbolTests.suite());
		testSuite.addTest(DeleteWikiNodeTests.suite());
		testSuite.addTest(EditWikiNodeTests.suite());
		testSuite.addTest(ViewWikiNodeFrontPageTests.suite());

		return testSuite;
	}

}