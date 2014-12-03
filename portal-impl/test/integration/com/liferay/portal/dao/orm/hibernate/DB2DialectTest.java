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

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.test.LiferayIntegrationJUnitTestRunner;
import com.liferay.portal.util.PropsValues;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Laszlo Csontos
 */
@RunWith(LiferayIntegrationJUnitTestRunner.class)
public class DB2DialectTest {

	@BeforeClass
	public static void setUpClass() {
		PropsValues.SPRING_HIBERNATE_SESSION_DELEGATED = false;
	}

	@AfterClass
	public static void tearDownClass() {
		PropsValues.SPRING_HIBERNATE_SESSION_DELEGATED = true;
	}

	@Before
	public void setUp() throws Exception {
		DB db = DBFactoryUtil.getDB();

		String dbType = db.getType();

		Assume.assumeTrue(dbType.equals(DB.TYPE_DB2));
	}

	@Test
	public void testPagingWithOffset() {
		testPaging(_SQL, 10, 20);
	}

	@Test
	public void testPagingWithoutOffset() {
		testPaging(_SQL, 0, 20);
	}

	protected void testPaging(String sql, int offset, int limit) {
		Session session = null;

		try {
			session = _sessionFactory.openSession();

			SQLQuery q = session.createSQLQuery(sql);

			List<?> result = QueryUtil.list(
				q, _sessionFactory.getDialect(), offset, offset + limit);

			Assert.assertNotNull(result);
			Assert.assertEquals(limit, result.size());
		}
		finally {
			_sessionFactory.closeSession(session);
		}
	}

	private static final String _SQL =
		"SELECT tabname FROM syscat.tables WHERE tabschema = 'SYSIBM' ORDER " +
			"BY tabname";

	private SessionFactory _sessionFactory =
		(SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");

}