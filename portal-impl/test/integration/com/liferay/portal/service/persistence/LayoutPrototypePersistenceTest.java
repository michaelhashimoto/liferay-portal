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

import com.liferay.portal.NoSuchLayoutPrototypeException;
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
import com.liferay.portal.model.LayoutPrototype;
import com.liferay.portal.service.ServiceTestUtil;
import com.liferay.portal.service.persistence.PersistenceExecutionTestListener;
import com.liferay.portal.test.LiferayIntegrationJUnitTestRunner;

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
public class LayoutPrototypePersistenceTest {
	@After
	public void tearDown() throws Exception {
		Iterator<LayoutPrototype> iterator = _layoutPrototypes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		LayoutPrototype layoutPrototype = _persistence.create(pk);

		Assert.assertNotNull(layoutPrototype);

		Assert.assertEquals(layoutPrototype.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		LayoutPrototype newLayoutPrototype = addLayoutPrototype();

		_persistence.remove(newLayoutPrototype);

		LayoutPrototype existingLayoutPrototype = _persistence.fetchByPrimaryKey(newLayoutPrototype.getPrimaryKey());

		Assert.assertNull(existingLayoutPrototype);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLayoutPrototype();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		LayoutPrototype newLayoutPrototype = _persistence.create(pk);

		newLayoutPrototype.setUuid(ServiceTestUtil.randomString());

		newLayoutPrototype.setCompanyId(ServiceTestUtil.nextLong());

		newLayoutPrototype.setName(ServiceTestUtil.randomString());

		newLayoutPrototype.setDescription(ServiceTestUtil.randomString());

		newLayoutPrototype.setSettings(ServiceTestUtil.randomString());

		newLayoutPrototype.setActive(ServiceTestUtil.randomBoolean());

		_layoutPrototypes.add(_persistence.update(newLayoutPrototype, false));

		LayoutPrototype existingLayoutPrototype = _persistence.findByPrimaryKey(newLayoutPrototype.getPrimaryKey());

		Assert.assertEquals(existingLayoutPrototype.getUuid(),
			newLayoutPrototype.getUuid());
		Assert.assertEquals(existingLayoutPrototype.getLayoutPrototypeId(),
			newLayoutPrototype.getLayoutPrototypeId());
		Assert.assertEquals(existingLayoutPrototype.getCompanyId(),
			newLayoutPrototype.getCompanyId());
		Assert.assertEquals(existingLayoutPrototype.getName(),
			newLayoutPrototype.getName());
		Assert.assertEquals(existingLayoutPrototype.getDescription(),
			newLayoutPrototype.getDescription());
		Assert.assertEquals(existingLayoutPrototype.getSettings(),
			newLayoutPrototype.getSettings());
		Assert.assertEquals(existingLayoutPrototype.getActive(),
			newLayoutPrototype.getActive());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		LayoutPrototype newLayoutPrototype = addLayoutPrototype();

		LayoutPrototype existingLayoutPrototype = _persistence.findByPrimaryKey(newLayoutPrototype.getPrimaryKey());

		Assert.assertEquals(existingLayoutPrototype, newLayoutPrototype);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail(
				"Missing entity did not throw NoSuchLayoutPrototypeException");
		}
		catch (NoSuchLayoutPrototypeException nsee) {
		}
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		LayoutPrototype newLayoutPrototype = addLayoutPrototype();

		LayoutPrototype existingLayoutPrototype = _persistence.fetchByPrimaryKey(newLayoutPrototype.getPrimaryKey());

		Assert.assertEquals(existingLayoutPrototype, newLayoutPrototype);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		LayoutPrototype missingLayoutPrototype = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLayoutPrototype);
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = new LayoutPrototypeActionableDynamicQuery() {
				@Override
				protected void performAction(Object object) {
					LayoutPrototype layoutPrototype = (LayoutPrototype)object;

					Assert.assertNotNull(layoutPrototype);

					count.increment();
				}
			};

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		LayoutPrototype newLayoutPrototype = addLayoutPrototype();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LayoutPrototype.class,
				LayoutPrototype.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("layoutPrototypeId",
				newLayoutPrototype.getLayoutPrototypeId()));

		List<LayoutPrototype> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		LayoutPrototype existingLayoutPrototype = result.get(0);

		Assert.assertEquals(existingLayoutPrototype, newLayoutPrototype);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LayoutPrototype.class,
				LayoutPrototype.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("layoutPrototypeId",
				ServiceTestUtil.nextLong()));

		List<LayoutPrototype> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		LayoutPrototype newLayoutPrototype = addLayoutPrototype();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LayoutPrototype.class,
				LayoutPrototype.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"layoutPrototypeId"));

		Object newLayoutPrototypeId = newLayoutPrototype.getLayoutPrototypeId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("layoutPrototypeId",
				new Object[] { newLayoutPrototypeId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLayoutPrototypeId = result.get(0);

		Assert.assertEquals(existingLayoutPrototypeId, newLayoutPrototypeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LayoutPrototype.class,
				LayoutPrototype.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"layoutPrototypeId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("layoutPrototypeId",
				new Object[] { ServiceTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected LayoutPrototype addLayoutPrototype() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		LayoutPrototype layoutPrototype = _persistence.create(pk);

		layoutPrototype.setUuid(ServiceTestUtil.randomString());

		layoutPrototype.setCompanyId(ServiceTestUtil.nextLong());

		layoutPrototype.setName(ServiceTestUtil.randomString());

		layoutPrototype.setDescription(ServiceTestUtil.randomString());

		layoutPrototype.setSettings(ServiceTestUtil.randomString());

		layoutPrototype.setActive(ServiceTestUtil.randomBoolean());

		_layoutPrototypes.add(_persistence.update(layoutPrototype, false));

		return layoutPrototype;
	}

	private static Log _log = LogFactoryUtil.getLog(LayoutPrototypePersistenceTest.class);
	private List<LayoutPrototype> _layoutPrototypes = new ArrayList<LayoutPrototype>();
	private LayoutPrototypePersistence _persistence = (LayoutPrototypePersistence)PortalBeanLocatorUtil.locate(LayoutPrototypePersistence.class.getName());
}