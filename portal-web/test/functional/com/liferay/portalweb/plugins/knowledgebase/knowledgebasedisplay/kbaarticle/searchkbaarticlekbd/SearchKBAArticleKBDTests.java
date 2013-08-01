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

package com.liferay.portalweb.plugins.knowledgebase.knowledgebasedisplay.kbaarticle.searchkbaarticlekbd;

import com.liferay.portalweb.plugins.knowledgebase.knowledgebaseadmin.kbaarticle.addkbaarticle.AddKBAArticleTest;
import com.liferay.portalweb.plugins.knowledgebase.knowledgebaseadmin.kbaarticle.addkbaarticle.TearDownKBAArticleTest;
import com.liferay.portalweb.plugins.knowledgebase.knowledgebasedisplay.portlet.addportletkbd.AddPageKBDTest;
import com.liferay.portalweb.plugins.knowledgebase.knowledgebasedisplay.portlet.addportletkbd.AddPortletKBDTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchKBAArticleKBDTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageKBDTest.class);
		testSuite.addTestSuite(AddPortletKBDTest.class);
		testSuite.addTestSuite(AddKBAArticleTest.class);
		testSuite.addTestSuite(SearchKBAArticleKBDTest.class);
		testSuite.addTestSuite(SearchKBAArticleQuotesKBDTest.class);
		testSuite.addTestSuite(TearDownKBAArticleTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}