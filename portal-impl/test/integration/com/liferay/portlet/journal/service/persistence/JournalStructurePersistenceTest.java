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

package com.liferay.portlet.journal.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.ServiceTestUtil;
import com.liferay.portal.test.LiferayIntegrationJUnitTestRunner;
import com.liferay.portal.util.PropsValues;

import com.liferay.portlet.journal.NoSuchStructureException;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.model.impl.JournalStructureModelImpl;

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
public class JournalStructurePersistenceTest {
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

		for (ModelListener<JournalStructure> modelListener : _listeners) {
			_persistence.unregisterListener(modelListener);
		}
	}

	@After
	public void tearDown() throws Exception {
		Iterator<JournalStructure> iterator = _journalStructures.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}

		for (ModelListener<JournalStructure> modelListener : _listeners) {
			_persistence.registerListener(modelListener);
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		JournalStructure journalStructure = _persistence.create(pk);

		Assert.assertNotNull(journalStructure);

		Assert.assertEquals(journalStructure.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		JournalStructure newJournalStructure = addJournalStructure();

		_persistence.remove(newJournalStructure);

		JournalStructure existingJournalStructure = _persistence.fetchByPrimaryKey(newJournalStructure.getPrimaryKey());

		Assert.assertNull(existingJournalStructure);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addJournalStructure();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		JournalStructure newJournalStructure = _persistence.create(pk);

		newJournalStructure.setUuid(ServiceTestUtil.randomString());

		newJournalStructure.setGroupId(ServiceTestUtil.nextLong());

		newJournalStructure.setCompanyId(ServiceTestUtil.nextLong());

		newJournalStructure.setUserId(ServiceTestUtil.nextLong());

		newJournalStructure.setUserName(ServiceTestUtil.randomString());

		newJournalStructure.setCreateDate(ServiceTestUtil.nextDate());

		newJournalStructure.setModifiedDate(ServiceTestUtil.nextDate());

		newJournalStructure.setStructureId(ServiceTestUtil.randomString());

		newJournalStructure.setParentStructureId(ServiceTestUtil.randomString());

		newJournalStructure.setName(ServiceTestUtil.randomString());

		newJournalStructure.setDescription(ServiceTestUtil.randomString());

		newJournalStructure.setXsd(ServiceTestUtil.randomString());

		_journalStructures.add(_persistence.update(newJournalStructure, false));

		JournalStructure existingJournalStructure = _persistence.findByPrimaryKey(newJournalStructure.getPrimaryKey());

		Assert.assertEquals(existingJournalStructure.getUuid(),
			newJournalStructure.getUuid());
		Assert.assertEquals(existingJournalStructure.getId(),
			newJournalStructure.getId());
		Assert.assertEquals(existingJournalStructure.getGroupId(),
			newJournalStructure.getGroupId());
		Assert.assertEquals(existingJournalStructure.getCompanyId(),
			newJournalStructure.getCompanyId());
		Assert.assertEquals(existingJournalStructure.getUserId(),
			newJournalStructure.getUserId());
		Assert.assertEquals(existingJournalStructure.getUserName(),
			newJournalStructure.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingJournalStructure.getCreateDate()),
			Time.getShortTimestamp(newJournalStructure.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingJournalStructure.getModifiedDate()),
			Time.getShortTimestamp(newJournalStructure.getModifiedDate()));
		Assert.assertEquals(existingJournalStructure.getStructureId(),
			newJournalStructure.getStructureId());
		Assert.assertEquals(existingJournalStructure.getParentStructureId(),
			newJournalStructure.getParentStructureId());
		Assert.assertEquals(existingJournalStructure.getName(),
			newJournalStructure.getName());
		Assert.assertEquals(existingJournalStructure.getDescription(),
			newJournalStructure.getDescription());
		Assert.assertEquals(existingJournalStructure.getXsd(),
			newJournalStructure.getXsd());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		JournalStructure newJournalStructure = addJournalStructure();

		JournalStructure existingJournalStructure = _persistence.findByPrimaryKey(newJournalStructure.getPrimaryKey());

		Assert.assertEquals(existingJournalStructure, newJournalStructure);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail("Missing entity did not throw NoSuchStructureException");
		}
		catch (NoSuchStructureException nsee) {
		}
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		JournalStructure newJournalStructure = addJournalStructure();

		JournalStructure existingJournalStructure = _persistence.fetchByPrimaryKey(newJournalStructure.getPrimaryKey());

		Assert.assertEquals(existingJournalStructure, newJournalStructure);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		JournalStructure missingJournalStructure = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingJournalStructure);
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = new JournalStructureActionableDynamicQuery() {
				@Override
				protected void performAction(Object object) {
					JournalStructure journalStructure = (JournalStructure)object;

					Assert.assertNotNull(journalStructure);

					count.increment();
				}
			};

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		JournalStructure newJournalStructure = addJournalStructure();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalStructure.class,
				JournalStructure.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id",
				newJournalStructure.getId()));

		List<JournalStructure> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		JournalStructure existingJournalStructure = result.get(0);

		Assert.assertEquals(existingJournalStructure, newJournalStructure);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalStructure.class,
				JournalStructure.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id",
				ServiceTestUtil.nextLong()));

		List<JournalStructure> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		JournalStructure newJournalStructure = addJournalStructure();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalStructure.class,
				JournalStructure.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newJournalStructure.getId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("id", new Object[] { newId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalStructure.class,
				JournalStructure.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("id",
				new Object[] { ServiceTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		if (!PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			return;
		}

		JournalStructure newJournalStructure = addJournalStructure();

		_persistence.clearCache();

		JournalStructureModelImpl existingJournalStructureModelImpl = (JournalStructureModelImpl)_persistence.findByPrimaryKey(newJournalStructure.getPrimaryKey());

		Assert.assertTrue(Validator.equals(
				existingJournalStructureModelImpl.getUuid(),
				existingJournalStructureModelImpl.getOriginalUuid()));
		Assert.assertEquals(existingJournalStructureModelImpl.getGroupId(),
			existingJournalStructureModelImpl.getOriginalGroupId());

		Assert.assertEquals(existingJournalStructureModelImpl.getGroupId(),
			existingJournalStructureModelImpl.getOriginalGroupId());
		Assert.assertTrue(Validator.equals(
				existingJournalStructureModelImpl.getStructureId(),
				existingJournalStructureModelImpl.getOriginalStructureId()));
	}

	protected JournalStructure addJournalStructure() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		JournalStructure journalStructure = _persistence.create(pk);

		journalStructure.setUuid(ServiceTestUtil.randomString());

		journalStructure.setGroupId(ServiceTestUtil.nextLong());

		journalStructure.setCompanyId(ServiceTestUtil.nextLong());

		journalStructure.setUserId(ServiceTestUtil.nextLong());

		journalStructure.setUserName(ServiceTestUtil.randomString());

		journalStructure.setCreateDate(ServiceTestUtil.nextDate());

		journalStructure.setModifiedDate(ServiceTestUtil.nextDate());

		journalStructure.setStructureId(ServiceTestUtil.randomString());

		journalStructure.setParentStructureId(ServiceTestUtil.randomString());

		journalStructure.setName(ServiceTestUtil.randomString());

		journalStructure.setDescription(ServiceTestUtil.randomString());

		journalStructure.setXsd(ServiceTestUtil.randomString());

		_journalStructures.add(_persistence.update(journalStructure, false));

		return journalStructure;
	}

	private static Log _log = LogFactoryUtil.getLog(JournalStructurePersistenceTest.class);
	private List<JournalStructure> _journalStructures = new ArrayList<JournalStructure>();
	private ModelListener<JournalStructure>[] _listeners;
	private JournalStructurePersistence _persistence = (JournalStructurePersistence)PortalBeanLocatorUtil.locate(JournalStructurePersistence.class.getName());
}