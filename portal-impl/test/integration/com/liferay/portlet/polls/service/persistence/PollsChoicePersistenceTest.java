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

package com.liferay.portlet.polls.service.persistence;

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
import com.liferay.portal.service.ServiceTestUtil;
import com.liferay.portal.test.LiferayIntegrationJUnitTestRunner;
import com.liferay.portal.util.PropsValues;

import com.liferay.portlet.polls.NoSuchChoiceException;
import com.liferay.portlet.polls.model.PollsChoice;
import com.liferay.portlet.polls.model.impl.PollsChoiceModelImpl;

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
public class PollsChoicePersistenceTest {
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

		for (ModelListener<PollsChoice> modelListener : _listeners) {
			_persistence.unregisterListener(modelListener);
		}
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PollsChoice> iterator = _pollsChoices.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}

		for (ModelListener<PollsChoice> modelListener : _listeners) {
			_persistence.registerListener(modelListener);
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		PollsChoice pollsChoice = _persistence.create(pk);

		Assert.assertNotNull(pollsChoice);

		Assert.assertEquals(pollsChoice.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PollsChoice newPollsChoice = addPollsChoice();

		_persistence.remove(newPollsChoice);

		PollsChoice existingPollsChoice = _persistence.fetchByPrimaryKey(newPollsChoice.getPrimaryKey());

		Assert.assertNull(existingPollsChoice);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPollsChoice();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		PollsChoice newPollsChoice = _persistence.create(pk);

		newPollsChoice.setUuid(ServiceTestUtil.randomString());

		newPollsChoice.setQuestionId(ServiceTestUtil.nextLong());

		newPollsChoice.setName(ServiceTestUtil.randomString());

		newPollsChoice.setDescription(ServiceTestUtil.randomString());

		_pollsChoices.add(_persistence.update(newPollsChoice, false));

		PollsChoice existingPollsChoice = _persistence.findByPrimaryKey(newPollsChoice.getPrimaryKey());

		Assert.assertEquals(existingPollsChoice.getUuid(),
			newPollsChoice.getUuid());
		Assert.assertEquals(existingPollsChoice.getChoiceId(),
			newPollsChoice.getChoiceId());
		Assert.assertEquals(existingPollsChoice.getQuestionId(),
			newPollsChoice.getQuestionId());
		Assert.assertEquals(existingPollsChoice.getName(),
			newPollsChoice.getName());
		Assert.assertEquals(existingPollsChoice.getDescription(),
			newPollsChoice.getDescription());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		PollsChoice newPollsChoice = addPollsChoice();

		PollsChoice existingPollsChoice = _persistence.findByPrimaryKey(newPollsChoice.getPrimaryKey());

		Assert.assertEquals(existingPollsChoice, newPollsChoice);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail("Missing entity did not throw NoSuchChoiceException");
		}
		catch (NoSuchChoiceException nsee) {
		}
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PollsChoice newPollsChoice = addPollsChoice();

		PollsChoice existingPollsChoice = _persistence.fetchByPrimaryKey(newPollsChoice.getPrimaryKey());

		Assert.assertEquals(existingPollsChoice, newPollsChoice);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		PollsChoice missingPollsChoice = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPollsChoice);
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = new PollsChoiceActionableDynamicQuery() {
				@Override
				protected void performAction(Object object) {
					PollsChoice pollsChoice = (PollsChoice)object;

					Assert.assertNotNull(pollsChoice);

					count.increment();
				}
			};

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		PollsChoice newPollsChoice = addPollsChoice();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PollsChoice.class,
				PollsChoice.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("choiceId",
				newPollsChoice.getChoiceId()));

		List<PollsChoice> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		PollsChoice existingPollsChoice = result.get(0);

		Assert.assertEquals(existingPollsChoice, newPollsChoice);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PollsChoice.class,
				PollsChoice.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("choiceId",
				ServiceTestUtil.nextLong()));

		List<PollsChoice> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		PollsChoice newPollsChoice = addPollsChoice();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PollsChoice.class,
				PollsChoice.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("choiceId"));

		Object newChoiceId = newPollsChoice.getChoiceId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("choiceId",
				new Object[] { newChoiceId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingChoiceId = result.get(0);

		Assert.assertEquals(existingChoiceId, newChoiceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PollsChoice.class,
				PollsChoice.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("choiceId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("choiceId",
				new Object[] { ServiceTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		if (!PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			return;
		}

		PollsChoice newPollsChoice = addPollsChoice();

		_persistence.clearCache();

		PollsChoiceModelImpl existingPollsChoiceModelImpl = (PollsChoiceModelImpl)_persistence.findByPrimaryKey(newPollsChoice.getPrimaryKey());

		Assert.assertEquals(existingPollsChoiceModelImpl.getQuestionId(),
			existingPollsChoiceModelImpl.getOriginalQuestionId());
		Assert.assertTrue(Validator.equals(
				existingPollsChoiceModelImpl.getName(),
				existingPollsChoiceModelImpl.getOriginalName()));
	}

	protected PollsChoice addPollsChoice() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		PollsChoice pollsChoice = _persistence.create(pk);

		pollsChoice.setUuid(ServiceTestUtil.randomString());

		pollsChoice.setQuestionId(ServiceTestUtil.nextLong());

		pollsChoice.setName(ServiceTestUtil.randomString());

		pollsChoice.setDescription(ServiceTestUtil.randomString());

		_pollsChoices.add(_persistence.update(pollsChoice, false));

		return pollsChoice;
	}

	private static Log _log = LogFactoryUtil.getLog(PollsChoicePersistenceTest.class);
	private List<PollsChoice> _pollsChoices = new ArrayList<PollsChoice>();
	private ModelListener<PollsChoice>[] _listeners;
	private PollsChoicePersistence _persistence = (PollsChoicePersistence)PortalBeanLocatorUtil.locate(PollsChoicePersistence.class.getName());
}