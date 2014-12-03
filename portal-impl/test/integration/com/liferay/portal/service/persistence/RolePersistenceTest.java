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

package com.liferay.portal.service.persistence;

import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.impl.RoleModelImpl;
import com.liferay.portal.service.ServiceTestUtil;
import com.liferay.portal.test.LiferayIntegrationJUnitTestRunner;
import com.liferay.portal.util.PropsValues;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@RunWith(LiferayIntegrationJUnitTestRunner.class)
public class RolePersistenceTest {
	@BeforeClass
	public static void setUpClass() {
		PropsValues.SPRING_HIBERNATE_SESSION_DELEGATED = false;
	}

	@AfterClass
	public static void tearDownClass() {
		PropsValues.SPRING_HIBERNATE_SESSION_DELEGATED = true;
	}

	@Before
	public void setUp() {
		_listeners = _persistence.getListeners();

		for (ModelListener<Role> modelListener : _listeners) {
			_persistence.unregisterListener(modelListener);
		}
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Role> iterator = _roles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}

		for (ModelListener<Role> modelListener : _listeners) {
			_persistence.registerListener(modelListener);
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Role role = _persistence.create(pk);

		Assert.assertNotNull(role);

		Assert.assertEquals(role.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Role newRole = addRole();

		_persistence.remove(newRole);

		Role existingRole = _persistence.fetchByPrimaryKey(newRole.getPrimaryKey());

		Assert.assertNull(existingRole);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRole();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Role newRole = _persistence.create(pk);

		newRole.setCompanyId(ServiceTestUtil.nextLong());

		newRole.setClassNameId(ServiceTestUtil.nextLong());

		newRole.setClassPK(ServiceTestUtil.nextLong());

		newRole.setName(ServiceTestUtil.randomString());

		newRole.setTitle(ServiceTestUtil.randomString());

		newRole.setDescription(ServiceTestUtil.randomString());

		newRole.setType(ServiceTestUtil.nextInt());

		newRole.setSubtype(ServiceTestUtil.randomString());

		_roles.add(_persistence.update(newRole, false));

		Role existingRole = _persistence.findByPrimaryKey(newRole.getPrimaryKey());

		Assert.assertEquals(existingRole.getRoleId(), newRole.getRoleId());
		Assert.assertEquals(existingRole.getCompanyId(), newRole.getCompanyId());
		Assert.assertEquals(existingRole.getClassNameId(),
			newRole.getClassNameId());
		Assert.assertEquals(existingRole.getClassPK(), newRole.getClassPK());
		Assert.assertEquals(existingRole.getName(), newRole.getName());
		Assert.assertEquals(existingRole.getTitle(), newRole.getTitle());
		Assert.assertEquals(existingRole.getDescription(),
			newRole.getDescription());
		Assert.assertEquals(existingRole.getType(), newRole.getType());
		Assert.assertEquals(existingRole.getSubtype(), newRole.getSubtype());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Role newRole = addRole();

		Role existingRole = _persistence.findByPrimaryKey(newRole.getPrimaryKey());

		Assert.assertEquals(existingRole, newRole);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail("Missing entity did not throw NoSuchRoleException");
		}
		catch (NoSuchRoleException nsee) {
		}
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Role newRole = addRole();

		Role existingRole = _persistence.fetchByPrimaryKey(newRole.getPrimaryKey());

		Assert.assertEquals(existingRole, newRole);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Role missingRole = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRole);
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = new RoleActionableDynamicQuery() {
				@Override
				protected void performAction(Object object) {
					Role role = (Role)object;

					Assert.assertNotNull(role);

					count.increment();
				}
			};

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Role newRole = addRole();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Role.class,
				Role.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("roleId",
				newRole.getRoleId()));

		List<Role> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Role existingRole = result.get(0);

		Assert.assertEquals(existingRole, newRole);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Role.class,
				Role.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("roleId",
				ServiceTestUtil.nextLong()));

		List<Role> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Role newRole = addRole();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Role.class,
				Role.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("roleId"));

		Object newRoleId = newRole.getRoleId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("roleId",
				new Object[] { newRoleId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingRoleId = result.get(0);

		Assert.assertEquals(existingRoleId, newRoleId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Role.class,
				Role.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("roleId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("roleId",
				new Object[] { ServiceTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		if (!PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			return;
		}

		Role newRole = addRole();

		_persistence.clearCache();

		RoleModelImpl existingRoleModelImpl = (RoleModelImpl)_persistence.findByPrimaryKey(newRole.getPrimaryKey());

		Assert.assertEquals(existingRoleModelImpl.getCompanyId(),
			existingRoleModelImpl.getOriginalCompanyId());
		Assert.assertTrue(Validator.equals(existingRoleModelImpl.getName(),
				existingRoleModelImpl.getOriginalName()));

		Assert.assertEquals(existingRoleModelImpl.getCompanyId(),
			existingRoleModelImpl.getOriginalCompanyId());
		Assert.assertEquals(existingRoleModelImpl.getClassNameId(),
			existingRoleModelImpl.getOriginalClassNameId());
		Assert.assertEquals(existingRoleModelImpl.getClassPK(),
			existingRoleModelImpl.getOriginalClassPK());
	}

	protected Role addRole() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Role role = _persistence.create(pk);

		role.setCompanyId(ServiceTestUtil.nextLong());

		role.setClassNameId(ServiceTestUtil.nextLong());

		role.setClassPK(ServiceTestUtil.nextLong());

		role.setName(ServiceTestUtil.randomString());

		role.setTitle(ServiceTestUtil.randomString());

		role.setDescription(ServiceTestUtil.randomString());

		role.setType(ServiceTestUtil.nextInt());

		role.setSubtype(ServiceTestUtil.randomString());

		_roles.add(_persistence.update(role, false));

		return role;
	}

	private static Log _log = LogFactoryUtil.getLog(RolePersistenceTest.class);
	private List<Role> _roles = new ArrayList<Role>();
	private ModelListener<Role>[] _listeners;
	private RolePersistence _persistence = (RolePersistence)PortalBeanLocatorUtil.locate(RolePersistence.class.getName());
}