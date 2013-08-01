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

package com.liferay.portalweb.plugins.knowledgebase;

import com.liferay.portalweb.plugins.knowledgebase.knowledgebaseadmin.KnowledgeBaseAdminTestPlan;
import com.liferay.portalweb.plugins.knowledgebase.knowledgebasearticle.KnowledgeBaseArticleTestPlan;
import com.liferay.portalweb.plugins.knowledgebase.knowledgebasedisplay.KnowledgeBaseDisplayTestPlan;
import com.liferay.portalweb.plugins.knowledgebase.knowledgebasesearch.KnowledgeBaseSearchTestPlan;
import com.liferay.portalweb.plugins.knowledgebase.knowledgebasesection.KnowledgeBaseSectionTestPlan;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class KnowledgeBaseTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(KnowledgeBaseAdminTestPlan.suite());
		testSuite.addTest(KnowledgeBaseArticleTestPlan.suite());
		testSuite.addTest(KnowledgeBaseDisplayTestPlan.suite());
		testSuite.addTest(KnowledgeBaseSearchTestPlan.suite());
		testSuite.addTest(KnowledgeBaseSectionTestPlan.suite());

		return testSuite;
	}

}