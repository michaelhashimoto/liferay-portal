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

package com.liferay.portal.dao.orm;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.test.ExecutionTestListeners;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.persistence.PersistenceExecutionTestListener;
import com.liferay.portal.test.LiferayIntegrationJUnitTestRunner;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Shuyang Zhou
 */
@ExecutionTestListeners(listeners = {PersistenceExecutionTestListener.class})
@RunWith(LiferayIntegrationJUnitTestRunner.class)
public class SQLNullTest {

	@Test
	public void testBlankStringEqualsNull() {
		String sql = _SQL_EQUALS_NULL;

		if (isSybase()) {
			sql = transformSybaseSQL(sql);
		}

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(StringPool.BLANK);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testBlankStringIsNotNull() {
		String sql = _SQL_IS_NOT_NULL;

		if (isSybase()) {
			sql = transformSybaseSQL(sql);
		}

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(StringPool.BLANK);

			List<Object> list = sqlQuery.list();

			if (isOracle()) {
				Assert.assertTrue(list.isEmpty());
			}
			else {
				Assert.assertFalse(list.isEmpty());
			}
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testBlankStringIsNull() {
		String sql = _SQL_IS_NULL;

		if (isSybase()) {
			sql = transformSybaseSQL(sql);
		}

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(StringPool.BLANK);

			List<Object> list = sqlQuery.list();

			if (isOracle()) {
				Assert.assertFalse(list.isEmpty());
			}
			else {
				Assert.assertTrue(list.isEmpty());
			}
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testBlankStringLikeNull() {
		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_SQL_LIKE_NULL);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(StringPool.BLANK);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testBlankStringNotEqualsNull() {
		String sql = _SQL_NOT_EQUALS_NULL;

		if (isSybase()) {
			sql = transformSybaseSQL(sql);
		}

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(StringPool.BLANK);

			List<Object> list = sqlQuery.list();

			if (isSybase()) {
				Assert.assertFalse(list.isEmpty());
			}
			else {
				Assert.assertTrue(list.isEmpty());
			}
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testBlankStringNotLikeNull() {
		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_SQL_NOT_LIKE_NULL);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(StringPool.BLANK);

			List<Object> list = sqlQuery.list();

			if (isSybase()) {
				Assert.assertFalse(list.isEmpty());
			}
			else {
				Assert.assertTrue(list.isEmpty());
			}
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testNullEqualsNull() {
		String sql = _SQL_EQUALS_NULL;

		if (isSybase()) {
			sql = transformSybaseSQL(sql);
		}

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add((Object)null);

			List<Object> list = sqlQuery.list();

			if (isSybase()) {
				Assert.assertFalse(list.isEmpty());
			}
			else {
				Assert.assertTrue(list.isEmpty());
			}
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testNullIsNotNull() {
		String sql = _SQL_IS_NOT_NULL;

		if (isSybase()) {
			sql = transformSybaseSQL(sql);
		}

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add((Object)null);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testNullIsNull() {
		String sql = _SQL_IS_NULL;

		if (isSybase()) {
			sql = transformSybaseSQL(sql);
		}

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add((Object)null);

			List<Object> list = sqlQuery.list();

			Assert.assertFalse(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testNullLikeNull() {
		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_SQL_LIKE_NULL);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add((Object)null);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testNullNotEqualsNull() {
		String sql = _SQL_NOT_EQUALS_NULL;

		if (isSybase()) {
			sql = transformSybaseSQL(sql);
		}

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add((Object)null);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testNullNotLikeNull() {
		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_SQL_NOT_LIKE_NULL);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add((Object)null);

			List<Object> list = sqlQuery.list();

			if (isSybase()) {
				Assert.assertFalse(list.isEmpty());
			}
			else {
				Assert.assertTrue(list.isEmpty());
			}
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testZeroEqualsNull() {
		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_SQL_EQUALS_NULL);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(0);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testZeroIsNotNull() {
		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_SQL_IS_NOT_NULL);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(0);

			List<Object> list = sqlQuery.list();

			Assert.assertFalse(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testZeroIsNull() {
		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_SQL_IS_NULL);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(0);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testZeroLikeNull() {
		String sql = _SQL_LIKE_NULL;

		if (isPostgreSQL()) {
			sql = transformPostgreSQL(sql);
		}
		else if (isSybase()) {
			sql = transformSybaseSQL(sql);
		}

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(0);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testZeroNotEqualsNull() {
		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_SQL_NOT_EQUALS_NULL);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(0);

			List<Object> list = sqlQuery.list();

			if (isSybase()) {
				Assert.assertFalse(list.isEmpty());
			}
			else {
				Assert.assertTrue(list.isEmpty());
			}
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testZeroNotLikeNull() {
		String sql = _SQL_NOT_LIKE_NULL;

		if (isPostgreSQL()) {
			sql = transformPostgreSQL(sql);
		}
		else if (isSybase()) {
			sql = transformSybaseSQL(sql);
		}

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(0);

			List<Object> list = sqlQuery.list();

			if (isSybase()) {
				Assert.assertFalse(list.isEmpty());
			}
			else {
				Assert.assertTrue(list.isEmpty());
			}
		}
		finally {
			session.close();
		}
	}

	protected boolean isDBType(String dBType) {
		DB db = DBFactoryUtil.getDB();

		return dBType.equals(db.getType());
	}

	protected boolean isOracle() {
		return isDBType(DB.TYPE_ORACLE);
	}

	protected boolean isPostgreSQL() {
		return isDBType(DB.TYPE_POSTGRESQL);
	}

	protected boolean isSybase() {
		return isDBType(DB.TYPE_SYBASE);
	}

	protected String transformPostgreSQL(String sql) {
		return sql.replace("?", "CAST(? AS VARCHAR)");
	}

	protected String transformSybaseSQL(String sql) {
		return sql.replace("?", "CONVERT(VARCHAR, ?)");
	}

	private static final String _SQL_EQUALS_NULL =
		"SELECT DISTINCT 1 FROM Counter WHERE ? = NULL";

	private static final String _SQL_IS_NOT_NULL =
		"SELECT DISTINCT 1 FROM Counter WHERE ? IS NOT NULL";

	private static final String _SQL_IS_NULL =
		"SELECT DISTINCT 1 FROM Counter WHERE ? IS NULL";

	private static final String _SQL_LIKE_NULL =
		"SELECT DISTINCT 1 FROM Counter WHERE ? LIKE NULL";

	private static final String _SQL_NOT_EQUALS_NULL =
		"SELECT DISTINCT 1 FROM Counter WHERE ? != NULL";

	private static final String _SQL_NOT_LIKE_NULL =
		"SELECT DISTINCT 1 FROM Counter WHERE ? NOT LIKE NULL";

	private SessionFactory _sessionFactory =
		(SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");

}