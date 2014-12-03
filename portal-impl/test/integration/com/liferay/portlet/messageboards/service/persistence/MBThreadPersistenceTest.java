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

package com.liferay.portlet.messageboards.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.ServiceTestUtil;
import com.liferay.portal.test.AssertUtils;
import com.liferay.portal.test.LiferayIntegrationJUnitTestRunner;
import com.liferay.portal.util.PropsValues;

import com.liferay.portlet.messageboards.NoSuchThreadException;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.impl.MBThreadModelImpl;

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
public class MBThreadPersistenceTest {
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

		for (ModelListener<MBThread> modelListener : _listeners) {
			_persistence.unregisterListener(modelListener);
		}
	}

	@After
	public void tearDown() throws Exception {
		Iterator<MBThread> iterator = _mbThreads.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}

		for (ModelListener<MBThread> modelListener : _listeners) {
			_persistence.registerListener(modelListener);
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		MBThread mbThread = _persistence.create(pk);

		Assert.assertNotNull(mbThread);

		Assert.assertEquals(mbThread.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		MBThread newMBThread = addMBThread();

		_persistence.remove(newMBThread);

		MBThread existingMBThread = _persistence.fetchByPrimaryKey(newMBThread.getPrimaryKey());

		Assert.assertNull(existingMBThread);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addMBThread();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		MBThread newMBThread = _persistence.create(pk);

		newMBThread.setGroupId(ServiceTestUtil.nextLong());

		newMBThread.setCompanyId(ServiceTestUtil.nextLong());

		newMBThread.setCategoryId(ServiceTestUtil.nextLong());

		newMBThread.setRootMessageId(ServiceTestUtil.nextLong());

		newMBThread.setRootMessageUserId(ServiceTestUtil.nextLong());

		newMBThread.setMessageCount(ServiceTestUtil.nextInt());

		newMBThread.setViewCount(ServiceTestUtil.nextInt());

		newMBThread.setLastPostByUserId(ServiceTestUtil.nextLong());

		newMBThread.setLastPostDate(ServiceTestUtil.nextDate());

		newMBThread.setPriority(ServiceTestUtil.nextDouble());

		newMBThread.setQuestion(ServiceTestUtil.randomBoolean());

		newMBThread.setStatus(ServiceTestUtil.nextInt());

		newMBThread.setStatusByUserId(ServiceTestUtil.nextLong());

		newMBThread.setStatusByUserName(ServiceTestUtil.randomString());

		newMBThread.setStatusDate(ServiceTestUtil.nextDate());

		_mbThreads.add(_persistence.update(newMBThread, false));

		MBThread existingMBThread = _persistence.findByPrimaryKey(newMBThread.getPrimaryKey());

		Assert.assertEquals(existingMBThread.getThreadId(),
			newMBThread.getThreadId());
		Assert.assertEquals(existingMBThread.getGroupId(),
			newMBThread.getGroupId());
		Assert.assertEquals(existingMBThread.getCompanyId(),
			newMBThread.getCompanyId());
		Assert.assertEquals(existingMBThread.getCategoryId(),
			newMBThread.getCategoryId());
		Assert.assertEquals(existingMBThread.getRootMessageId(),
			newMBThread.getRootMessageId());
		Assert.assertEquals(existingMBThread.getRootMessageUserId(),
			newMBThread.getRootMessageUserId());
		Assert.assertEquals(existingMBThread.getMessageCount(),
			newMBThread.getMessageCount());
		Assert.assertEquals(existingMBThread.getViewCount(),
			newMBThread.getViewCount());
		Assert.assertEquals(existingMBThread.getLastPostByUserId(),
			newMBThread.getLastPostByUserId());
		Assert.assertEquals(Time.getShortTimestamp(
				existingMBThread.getLastPostDate()),
			Time.getShortTimestamp(newMBThread.getLastPostDate()));
		AssertUtils.assertEquals(existingMBThread.getPriority(),
			newMBThread.getPriority());
		Assert.assertEquals(existingMBThread.getQuestion(),
			newMBThread.getQuestion());
		Assert.assertEquals(existingMBThread.getStatus(),
			newMBThread.getStatus());
		Assert.assertEquals(existingMBThread.getStatusByUserId(),
			newMBThread.getStatusByUserId());
		Assert.assertEquals(existingMBThread.getStatusByUserName(),
			newMBThread.getStatusByUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingMBThread.getStatusDate()),
			Time.getShortTimestamp(newMBThread.getStatusDate()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		MBThread newMBThread = addMBThread();

		MBThread existingMBThread = _persistence.findByPrimaryKey(newMBThread.getPrimaryKey());

		Assert.assertEquals(existingMBThread, newMBThread);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail("Missing entity did not throw NoSuchThreadException");
		}
		catch (NoSuchThreadException nsee) {
		}
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		MBThread newMBThread = addMBThread();

		MBThread existingMBThread = _persistence.fetchByPrimaryKey(newMBThread.getPrimaryKey());

		Assert.assertEquals(existingMBThread, newMBThread);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		MBThread missingMBThread = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingMBThread);
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = new MBThreadActionableDynamicQuery() {
				@Override
				protected void performAction(Object object) {
					MBThread mbThread = (MBThread)object;

					Assert.assertNotNull(mbThread);

					count.increment();
				}
			};

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		MBThread newMBThread = addMBThread();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBThread.class,
				MBThread.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("threadId",
				newMBThread.getThreadId()));

		List<MBThread> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		MBThread existingMBThread = result.get(0);

		Assert.assertEquals(existingMBThread, newMBThread);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBThread.class,
				MBThread.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("threadId",
				ServiceTestUtil.nextLong()));

		List<MBThread> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		MBThread newMBThread = addMBThread();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBThread.class,
				MBThread.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("threadId"));

		Object newThreadId = newMBThread.getThreadId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("threadId",
				new Object[] { newThreadId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingThreadId = result.get(0);

		Assert.assertEquals(existingThreadId, newThreadId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBThread.class,
				MBThread.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("threadId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("threadId",
				new Object[] { ServiceTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		if (!PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			return;
		}

		MBThread newMBThread = addMBThread();

		_persistence.clearCache();

		MBThreadModelImpl existingMBThreadModelImpl = (MBThreadModelImpl)_persistence.findByPrimaryKey(newMBThread.getPrimaryKey());

		Assert.assertEquals(existingMBThreadModelImpl.getRootMessageId(),
			existingMBThreadModelImpl.getOriginalRootMessageId());
	}

	protected MBThread addMBThread() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		MBThread mbThread = _persistence.create(pk);

		mbThread.setGroupId(ServiceTestUtil.nextLong());

		mbThread.setCompanyId(ServiceTestUtil.nextLong());

		mbThread.setCategoryId(ServiceTestUtil.nextLong());

		mbThread.setRootMessageId(ServiceTestUtil.nextLong());

		mbThread.setRootMessageUserId(ServiceTestUtil.nextLong());

		mbThread.setMessageCount(ServiceTestUtil.nextInt());

		mbThread.setViewCount(ServiceTestUtil.nextInt());

		mbThread.setLastPostByUserId(ServiceTestUtil.nextLong());

		mbThread.setLastPostDate(ServiceTestUtil.nextDate());

		mbThread.setPriority(ServiceTestUtil.nextDouble());

		mbThread.setQuestion(ServiceTestUtil.randomBoolean());

		mbThread.setStatus(ServiceTestUtil.nextInt());

		mbThread.setStatusByUserId(ServiceTestUtil.nextLong());

		mbThread.setStatusByUserName(ServiceTestUtil.randomString());

		mbThread.setStatusDate(ServiceTestUtil.nextDate());

		_mbThreads.add(_persistence.update(mbThread, false));

		return mbThread;
	}

	private static Log _log = LogFactoryUtil.getLog(MBThreadPersistenceTest.class);
	private List<MBThread> _mbThreads = new ArrayList<MBThread>();
	private ModelListener<MBThread>[] _listeners;
	private MBThreadPersistence _persistence = (MBThreadPersistence)PortalBeanLocatorUtil.locate(MBThreadPersistence.class.getName());
}