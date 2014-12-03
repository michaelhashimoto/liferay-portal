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

import com.liferay.portal.NoSuchUserNotificationEventException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.UserNotificationEvent;
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
public class UserNotificationEventPersistenceTest {
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

		for (ModelListener<UserNotificationEvent> modelListener : _listeners) {
			_persistence.unregisterListener(modelListener);
		}
	}

	@After
	public void tearDown() throws Exception {
		Iterator<UserNotificationEvent> iterator = _userNotificationEvents.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}

		for (ModelListener<UserNotificationEvent> modelListener : _listeners) {
			_persistence.registerListener(modelListener);
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		UserNotificationEvent userNotificationEvent = _persistence.create(pk);

		Assert.assertNotNull(userNotificationEvent);

		Assert.assertEquals(userNotificationEvent.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		UserNotificationEvent newUserNotificationEvent = addUserNotificationEvent();

		_persistence.remove(newUserNotificationEvent);

		UserNotificationEvent existingUserNotificationEvent = _persistence.fetchByPrimaryKey(newUserNotificationEvent.getPrimaryKey());

		Assert.assertNull(existingUserNotificationEvent);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addUserNotificationEvent();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		UserNotificationEvent newUserNotificationEvent = _persistence.create(pk);

		newUserNotificationEvent.setUuid(ServiceTestUtil.randomString());

		newUserNotificationEvent.setCompanyId(ServiceTestUtil.nextLong());

		newUserNotificationEvent.setUserId(ServiceTestUtil.nextLong());

		newUserNotificationEvent.setType(ServiceTestUtil.randomString());

		newUserNotificationEvent.setTimestamp(ServiceTestUtil.nextLong());

		newUserNotificationEvent.setDeliverBy(ServiceTestUtil.nextLong());

		newUserNotificationEvent.setPayload(ServiceTestUtil.randomString());

		newUserNotificationEvent.setArchived(ServiceTestUtil.randomBoolean());

		_userNotificationEvents.add(_persistence.update(
				newUserNotificationEvent, false));

		UserNotificationEvent existingUserNotificationEvent = _persistence.findByPrimaryKey(newUserNotificationEvent.getPrimaryKey());

		Assert.assertEquals(existingUserNotificationEvent.getUuid(),
			newUserNotificationEvent.getUuid());
		Assert.assertEquals(existingUserNotificationEvent.getUserNotificationEventId(),
			newUserNotificationEvent.getUserNotificationEventId());
		Assert.assertEquals(existingUserNotificationEvent.getCompanyId(),
			newUserNotificationEvent.getCompanyId());
		Assert.assertEquals(existingUserNotificationEvent.getUserId(),
			newUserNotificationEvent.getUserId());
		Assert.assertEquals(existingUserNotificationEvent.getType(),
			newUserNotificationEvent.getType());
		Assert.assertEquals(existingUserNotificationEvent.getTimestamp(),
			newUserNotificationEvent.getTimestamp());
		Assert.assertEquals(existingUserNotificationEvent.getDeliverBy(),
			newUserNotificationEvent.getDeliverBy());
		Assert.assertEquals(existingUserNotificationEvent.getPayload(),
			newUserNotificationEvent.getPayload());
		Assert.assertEquals(existingUserNotificationEvent.getArchived(),
			newUserNotificationEvent.getArchived());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		UserNotificationEvent newUserNotificationEvent = addUserNotificationEvent();

		UserNotificationEvent existingUserNotificationEvent = _persistence.findByPrimaryKey(newUserNotificationEvent.getPrimaryKey());

		Assert.assertEquals(existingUserNotificationEvent,
			newUserNotificationEvent);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail(
				"Missing entity did not throw NoSuchUserNotificationEventException");
		}
		catch (NoSuchUserNotificationEventException nsee) {
		}
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserNotificationEvent newUserNotificationEvent = addUserNotificationEvent();

		UserNotificationEvent existingUserNotificationEvent = _persistence.fetchByPrimaryKey(newUserNotificationEvent.getPrimaryKey());

		Assert.assertEquals(existingUserNotificationEvent,
			newUserNotificationEvent);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		UserNotificationEvent missingUserNotificationEvent = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingUserNotificationEvent);
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = new UserNotificationEventActionableDynamicQuery() {
				@Override
				protected void performAction(Object object) {
					UserNotificationEvent userNotificationEvent = (UserNotificationEvent)object;

					Assert.assertNotNull(userNotificationEvent);

					count.increment();
				}
			};

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		UserNotificationEvent newUserNotificationEvent = addUserNotificationEvent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserNotificationEvent.class,
				UserNotificationEvent.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userNotificationEventId",
				newUserNotificationEvent.getUserNotificationEventId()));

		List<UserNotificationEvent> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		UserNotificationEvent existingUserNotificationEvent = result.get(0);

		Assert.assertEquals(existingUserNotificationEvent,
			newUserNotificationEvent);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserNotificationEvent.class,
				UserNotificationEvent.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userNotificationEventId",
				ServiceTestUtil.nextLong()));

		List<UserNotificationEvent> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		UserNotificationEvent newUserNotificationEvent = addUserNotificationEvent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserNotificationEvent.class,
				UserNotificationEvent.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"userNotificationEventId"));

		Object newUserNotificationEventId = newUserNotificationEvent.getUserNotificationEventId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("userNotificationEventId",
				new Object[] { newUserNotificationEventId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingUserNotificationEventId = result.get(0);

		Assert.assertEquals(existingUserNotificationEventId,
			newUserNotificationEventId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserNotificationEvent.class,
				UserNotificationEvent.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"userNotificationEventId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("userNotificationEventId",
				new Object[] { ServiceTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected UserNotificationEvent addUserNotificationEvent()
		throws Exception {
		long pk = ServiceTestUtil.nextLong();

		UserNotificationEvent userNotificationEvent = _persistence.create(pk);

		userNotificationEvent.setUuid(ServiceTestUtil.randomString());

		userNotificationEvent.setCompanyId(ServiceTestUtil.nextLong());

		userNotificationEvent.setUserId(ServiceTestUtil.nextLong());

		userNotificationEvent.setType(ServiceTestUtil.randomString());

		userNotificationEvent.setTimestamp(ServiceTestUtil.nextLong());

		userNotificationEvent.setDeliverBy(ServiceTestUtil.nextLong());

		userNotificationEvent.setPayload(ServiceTestUtil.randomString());

		userNotificationEvent.setArchived(ServiceTestUtil.randomBoolean());

		_userNotificationEvents.add(_persistence.update(userNotificationEvent,
				false));

		return userNotificationEvent;
	}

	private static Log _log = LogFactoryUtil.getLog(UserNotificationEventPersistenceTest.class);
	private List<UserNotificationEvent> _userNotificationEvents = new ArrayList<UserNotificationEvent>();
	private ModelListener<UserNotificationEvent>[] _listeners;
	private UserNotificationEventPersistence _persistence = (UserNotificationEventPersistence)PortalBeanLocatorUtil.locate(UserNotificationEventPersistence.class.getName());
}