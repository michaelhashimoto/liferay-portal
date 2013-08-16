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

package com.liferay.portal.spring.bean;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.lang.DoPrivilegedFactory;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;

/**
 * @author Shuyang Zhou
 */
public class BeanReferenceRefreshUtil {

	public static void refresh(BeanFactory beanFactory) throws Exception {
		for (Map.Entry<Object, List<RefreshPoint>> entry :
				_registeredRefreshPoints.entrySet()) {

			_refresh(beanFactory, entry.getKey(), entry.getValue());
		}

		_registeredRefreshPoints.clear();
	}

	public static void registerRefreshPoint(
		Object targetBean, Field field, String referencedBeanName) {

		List<RefreshPoint> refreshPoints = _registeredRefreshPoints.get(
			targetBean);

		if (refreshPoints == null) {
			refreshPoints = new ArrayList<RefreshPoint>();

			_registeredRefreshPoints.put(targetBean, refreshPoints);
		}

		refreshPoints.add(new RefreshPoint(field, referencedBeanName));
	}

	private static void _refresh(
			BeanFactory beanFactory, Object targetBean,
			List<RefreshPoint> refreshPoints)
		throws Exception {

		for (RefreshPoint refreshPoint : refreshPoints) {
			_refresh(beanFactory, targetBean, refreshPoint);
		}
	}

	private static void _refresh(
			BeanFactory beanFactory, Object targetBean,
			RefreshPoint refreshPoint)
		throws Exception {

		Field field = refreshPoint._field;

		Object oldReferenceBean = field.get(targetBean);

		String referencedBeanName = refreshPoint._referencedBeanName;

		Object newReferencedBean = beanFactory.getBean(referencedBeanName);

		Object doPrivilegedBean = _doPrivilegedBeans.get(newReferencedBean);

		if ((doPrivilegedBean == null) &&
			DoPrivilegedFactory.isEarlyBeanReference(referencedBeanName)) {

			doPrivilegedBean = DoPrivilegedFactory.wrap(newReferencedBean);

			_doPrivilegedBeans.put(newReferencedBean, doPrivilegedBean);
		}

		if (doPrivilegedBean != null) {
			newReferencedBean = doPrivilegedBean;
		}

		if (oldReferenceBean == newReferencedBean) {
			return;
		}

		field.set(targetBean, newReferencedBean);

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Refreshed field " + field + " with old value " +
					oldReferenceBean + " with new value " + newReferencedBean +
						" on bean " + targetBean);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		BeanReferenceRefreshUtil.class);

	private static Map<Object, Object> _doPrivilegedBeans =
		new IdentityHashMap<Object, Object>();
	private static Map<Object, List<RefreshPoint>> _registeredRefreshPoints =
		new IdentityHashMap<Object, List<RefreshPoint>>();

	private static class RefreshPoint {

		public RefreshPoint(Field field, String referencedBeanName) {
			_field = field;
			_referencedBeanName = referencedBeanName;
		}

		private Field _field;
		private String _referencedBeanName;

	}

}