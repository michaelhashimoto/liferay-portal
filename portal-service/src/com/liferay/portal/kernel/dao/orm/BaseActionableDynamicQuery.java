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

package com.liferay.portal.kernel.dao.orm;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.service.BaseLocalService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BaseActionableDynamicQuery
	implements ActionableDynamicQuery {

	@Override
	public void performActions() throws PortalException, SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			_clazz, _classLoader);

		Projection minPrimaryKeyProjection = ProjectionFactoryUtil.min(
			_primaryKeyPropertyName);
		Projection maxPrimaryKeyProjection = ProjectionFactoryUtil.max(
			_primaryKeyPropertyName);

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();

		projectionList.add(minPrimaryKeyProjection);
		projectionList.add(maxPrimaryKeyProjection);

		dynamicQuery.setProjection(projectionList);

		addDefaultCriteria(dynamicQuery);
		addCriteria(dynamicQuery);

		List<Object[]> results = dynamicQuery(dynamicQuery);

		Object[] minAndMaxPrimaryKeys = results.get(0);

		if ((minAndMaxPrimaryKeys[0] == null) ||
			(minAndMaxPrimaryKeys[1] == null)) {

			return;
		}

		long minPrimaryKey = (Long)minAndMaxPrimaryKeys[0];
		long maxPrimaryKey = (Long)minAndMaxPrimaryKeys[1];

		long startPrimaryKey = minPrimaryKey;
		long endPrimaryKey = startPrimaryKey + _interval;

		while (startPrimaryKey <= maxPrimaryKey) {
			performActions(startPrimaryKey, endPrimaryKey);

			startPrimaryKey = endPrimaryKey;
			endPrimaryKey += _interval;
		}
	}

	public void performActions(long startPrimaryKey, long endPrimaryKey)
		throws PortalException, SystemException {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			_clazz, _classLoader);

		Property property = PropertyFactoryUtil.forName(
			_primaryKeyPropertyName);

		dynamicQuery.add(property.ge(startPrimaryKey));
		dynamicQuery.add(property.lt(endPrimaryKey));

		addDefaultCriteria(dynamicQuery);
		addCriteria(dynamicQuery);

		List<Object> objects = dynamicQuery(dynamicQuery);

		for (Object object : objects) {
			performAction(object);
		}
	}

	@Override
	public void setBaseLocalService(BaseLocalService baseLocalService)
		throws SystemException {

		_baseLocalService = baseLocalService;

		Class<?> clazz = _baseLocalService.getClass();

		try {
			_dynamicQueryMethod = clazz.getMethod(
				"dynamicQuery", DynamicQuery.class);
		}
		catch (NoSuchMethodException nsme) {
			throw new SystemException(nsme);
		}
	}

	@Override
	public void setClass(Class<?> clazz) {
		_clazz = clazz;
	}

	@Override
	public void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public void setInterval(int interval) {
		_interval = interval;
	}

	@Override
	public void setPrimaryKeyPropertyName(String primaryKeyPropertyName) {
		_primaryKeyPropertyName = primaryKeyPropertyName;
	}

	protected void addCriteria(DynamicQuery dynamicQuery) {
	}

	protected void addDefaultCriteria(DynamicQuery dynamicQuery) {
		if (_companyId > 0) {
			Property property = PropertyFactoryUtil.forName("companyId");

			dynamicQuery.add(property.eq(_companyId));
		}

		if (_groupId > 0) {
			Property property = PropertyFactoryUtil.forName("groupId");

			dynamicQuery.add(property.eq(_groupId));
		}
	}

	@SuppressWarnings("rawtypes")
	protected List dynamicQuery(DynamicQuery dynamicQuery)
		throws PortalException, SystemException {

		try {
			return (List)_dynamicQueryMethod.invoke(
				_baseLocalService, dynamicQuery);
		}
		catch (InvocationTargetException ite) {
			Throwable throwable = ite.getCause();

			if (throwable instanceof PortalException) {
				throw (PortalException)throwable;
			}
			else if (throwable instanceof SystemException) {
				throw (SystemException)throwable;
			}

			throw new SystemException(ite);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	protected abstract void performAction(Object object)
		throws PortalException, SystemException;

	private BaseLocalService _baseLocalService;
	private ClassLoader _classLoader;
	private Class<?> _clazz;
	private long _companyId;
	private Method _dynamicQueryMethod;
	private long _groupId;
	private int _interval = Indexer.DEFAULT_INTERVAL;
	private String _primaryKeyPropertyName;

}