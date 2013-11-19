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

package com.liferay.portal.test;

import com.liferay.portal.kernel.test.AbstractExecutionTestListener;
import com.liferay.portal.kernel.test.TestContext;
import com.liferay.portal.search.lucene.LuceneHelperUtil;
import com.liferay.portal.service.ServiceTestUtil;
import com.liferay.portal.util.TestPropsValues;

/**
 * @author Miguel Pastor
 */
public class EnvironmentExecutionTestListener
	extends AbstractExecutionTestListener {

	@Override
	public void runAfterClass(TestContext testContext) {
		ServiceTestUtil.destroyServices();

		try {
			LuceneHelperUtil.delete(TestPropsValues.getCompanyId());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void runBeforeClass(TestContext testContext) {
		ServiceTestUtil.initServices();
		ServiceTestUtil.initPermissions();
	}

}