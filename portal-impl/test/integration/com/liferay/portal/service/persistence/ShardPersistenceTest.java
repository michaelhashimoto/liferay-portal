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

import com.liferay.portal.NoSuchShardException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.test.ExecutionTestListeners;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Shard;
import com.liferay.portal.model.impl.ShardModelImpl;
import com.liferay.portal.service.ServiceTestUtil;
import com.liferay.portal.service.persistence.PersistenceExecutionTestListener;
import com.liferay.portal.test.LiferayIntegrationJUnitTestRunner;
import com.liferay.portal.util.PropsValues;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@ExecutionTestListeners(listeners =  {
	PersistenceExecutionTestListener.class})
@RunWith(LiferayIntegrationJUnitTestRunner.class)
public class ShardPersistenceTest {
	@After
	public void tearDown() throws Exception {
		Iterator<Shard> iterator = _shards.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Shard shard = _persistence.create(pk);

		Assert.assertNotNull(shard);

		Assert.assertEquals(shard.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Shard newShard = addShard();

		_persistence.remove(newShard);

		Shard existingShard = _persistence.fetchByPrimaryKey(newShard.getPrimaryKey());

		Assert.assertNull(existingShard);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addShard();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Shard newShard = _persistence.create(pk);

		newShard.setClassNameId(ServiceTestUtil.nextLong());

		newShard.setClassPK(ServiceTestUtil.nextLong());

		newShard.setName(ServiceTestUtil.randomString());

		_shards.add(_persistence.update(newShard, false));

		Shard existingShard = _persistence.findByPrimaryKey(newShard.getPrimaryKey());

		Assert.assertEquals(existingShard.getShardId(), newShard.getShardId());
		Assert.assertEquals(existingShard.getClassNameId(),
			newShard.getClassNameId());
		Assert.assertEquals(existingShard.getClassPK(), newShard.getClassPK());
		Assert.assertEquals(existingShard.getName(), newShard.getName());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Shard newShard = addShard();

		Shard existingShard = _persistence.findByPrimaryKey(newShard.getPrimaryKey());

		Assert.assertEquals(existingShard, newShard);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail("Missing entity did not throw NoSuchShardException");
		}
		catch (NoSuchShardException nsee) {
		}
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Shard newShard = addShard();

		Shard existingShard = _persistence.fetchByPrimaryKey(newShard.getPrimaryKey());

		Assert.assertEquals(existingShard, newShard);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Shard missingShard = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingShard);
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = new ShardActionableDynamicQuery() {
				@Override
				protected void performAction(Object object) {
					Shard shard = (Shard)object;

					Assert.assertNotNull(shard);

					count.increment();
				}
			};

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Shard newShard = addShard();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Shard.class,
				Shard.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("shardId",
				newShard.getShardId()));

		List<Shard> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Shard existingShard = result.get(0);

		Assert.assertEquals(existingShard, newShard);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Shard.class,
				Shard.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("shardId",
				ServiceTestUtil.nextLong()));

		List<Shard> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Shard newShard = addShard();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Shard.class,
				Shard.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("shardId"));

		Object newShardId = newShard.getShardId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("shardId",
				new Object[] { newShardId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingShardId = result.get(0);

		Assert.assertEquals(existingShardId, newShardId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Shard.class,
				Shard.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("shardId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("shardId",
				new Object[] { ServiceTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		if (!PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			return;
		}

		Shard newShard = addShard();

		_persistence.clearCache();

		ShardModelImpl existingShardModelImpl = (ShardModelImpl)_persistence.findByPrimaryKey(newShard.getPrimaryKey());

		Assert.assertTrue(Validator.equals(existingShardModelImpl.getName(),
				existingShardModelImpl.getOriginalName()));

		Assert.assertEquals(existingShardModelImpl.getClassNameId(),
			existingShardModelImpl.getOriginalClassNameId());
		Assert.assertEquals(existingShardModelImpl.getClassPK(),
			existingShardModelImpl.getOriginalClassPK());
	}

	protected Shard addShard() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Shard shard = _persistence.create(pk);

		shard.setClassNameId(ServiceTestUtil.nextLong());

		shard.setClassPK(ServiceTestUtil.nextLong());

		shard.setName(ServiceTestUtil.randomString());

		_shards.add(_persistence.update(shard, false));

		return shard;
	}

	private static Log _log = LogFactoryUtil.getLog(ShardPersistenceTest.class);
	private List<Shard> _shards = new ArrayList<Shard>();
	private ShardPersistence _persistence = (ShardPersistence)PortalBeanLocatorUtil.locate(ShardPersistence.class.getName());
}