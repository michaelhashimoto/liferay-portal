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

import com.liferay.portal.NoSuchWebsiteException;
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
import com.liferay.portal.model.Website;
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
public class WebsitePersistenceTest {
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

		for (ModelListener<Website> modelListener : _listeners) {
			_persistence.unregisterListener(modelListener);
		}
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Website> iterator = _websites.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}

		for (ModelListener<Website> modelListener : _listeners) {
			_persistence.registerListener(modelListener);
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Website website = _persistence.create(pk);

		Assert.assertNotNull(website);

		Assert.assertEquals(website.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Website newWebsite = addWebsite();

		_persistence.remove(newWebsite);

		Website existingWebsite = _persistence.fetchByPrimaryKey(newWebsite.getPrimaryKey());

		Assert.assertNull(existingWebsite);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addWebsite();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Website newWebsite = _persistence.create(pk);

		newWebsite.setCompanyId(ServiceTestUtil.nextLong());

		newWebsite.setUserId(ServiceTestUtil.nextLong());

		newWebsite.setUserName(ServiceTestUtil.randomString());

		newWebsite.setCreateDate(ServiceTestUtil.nextDate());

		newWebsite.setModifiedDate(ServiceTestUtil.nextDate());

		newWebsite.setClassNameId(ServiceTestUtil.nextLong());

		newWebsite.setClassPK(ServiceTestUtil.nextLong());

		newWebsite.setUrl(ServiceTestUtil.randomString());

		newWebsite.setTypeId(ServiceTestUtil.nextInt());

		newWebsite.setPrimary(ServiceTestUtil.randomBoolean());

		_websites.add(_persistence.update(newWebsite, false));

		Website existingWebsite = _persistence.findByPrimaryKey(newWebsite.getPrimaryKey());

		Assert.assertEquals(existingWebsite.getWebsiteId(),
			newWebsite.getWebsiteId());
		Assert.assertEquals(existingWebsite.getCompanyId(),
			newWebsite.getCompanyId());
		Assert.assertEquals(existingWebsite.getUserId(), newWebsite.getUserId());
		Assert.assertEquals(existingWebsite.getUserName(),
			newWebsite.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingWebsite.getCreateDate()),
			Time.getShortTimestamp(newWebsite.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingWebsite.getModifiedDate()),
			Time.getShortTimestamp(newWebsite.getModifiedDate()));
		Assert.assertEquals(existingWebsite.getClassNameId(),
			newWebsite.getClassNameId());
		Assert.assertEquals(existingWebsite.getClassPK(),
			newWebsite.getClassPK());
		Assert.assertEquals(existingWebsite.getUrl(), newWebsite.getUrl());
		Assert.assertEquals(existingWebsite.getTypeId(), newWebsite.getTypeId());
		Assert.assertEquals(existingWebsite.getPrimary(),
			newWebsite.getPrimary());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Website newWebsite = addWebsite();

		Website existingWebsite = _persistence.findByPrimaryKey(newWebsite.getPrimaryKey());

		Assert.assertEquals(existingWebsite, newWebsite);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail("Missing entity did not throw NoSuchWebsiteException");
		}
		catch (NoSuchWebsiteException nsee) {
		}
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Website newWebsite = addWebsite();

		Website existingWebsite = _persistence.fetchByPrimaryKey(newWebsite.getPrimaryKey());

		Assert.assertEquals(existingWebsite, newWebsite);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Website missingWebsite = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingWebsite);
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = new WebsiteActionableDynamicQuery() {
				@Override
				protected void performAction(Object object) {
					Website website = (Website)object;

					Assert.assertNotNull(website);

					count.increment();
				}
			};

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Website newWebsite = addWebsite();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Website.class,
				Website.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("websiteId",
				newWebsite.getWebsiteId()));

		List<Website> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Website existingWebsite = result.get(0);

		Assert.assertEquals(existingWebsite, newWebsite);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Website.class,
				Website.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("websiteId",
				ServiceTestUtil.nextLong()));

		List<Website> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Website newWebsite = addWebsite();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Website.class,
				Website.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("websiteId"));

		Object newWebsiteId = newWebsite.getWebsiteId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("websiteId",
				new Object[] { newWebsiteId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingWebsiteId = result.get(0);

		Assert.assertEquals(existingWebsiteId, newWebsiteId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Website.class,
				Website.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("websiteId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("websiteId",
				new Object[] { ServiceTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Website addWebsite() throws Exception {
		long pk = ServiceTestUtil.nextLong();

		Website website = _persistence.create(pk);

		website.setCompanyId(ServiceTestUtil.nextLong());

		website.setUserId(ServiceTestUtil.nextLong());

		website.setUserName(ServiceTestUtil.randomString());

		website.setCreateDate(ServiceTestUtil.nextDate());

		website.setModifiedDate(ServiceTestUtil.nextDate());

		website.setClassNameId(ServiceTestUtil.nextLong());

		website.setClassPK(ServiceTestUtil.nextLong());

		website.setUrl(ServiceTestUtil.randomString());

		website.setTypeId(ServiceTestUtil.nextInt());

		website.setPrimary(ServiceTestUtil.randomBoolean());

		_websites.add(_persistence.update(website, false));

		return website;
	}

	private static Log _log = LogFactoryUtil.getLog(WebsitePersistenceTest.class);
	private List<Website> _websites = new ArrayList<Website>();
	private ModelListener<Website>[] _listeners;
	private WebsitePersistence _persistence = (WebsitePersistence)PortalBeanLocatorUtil.locate(WebsitePersistence.class.getName());
}