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

package com.liferay.util.bridges.alloy;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.TextFormatter;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AlloyServiceInvoker {

	public AlloyServiceInvoker(String className) {
		Class<?> clazz = getClass();

		ClassLoader classLoader = clazz.getClassLoader();

		int pos = className.indexOf(".model.");

		String simpleClassName = className.substring(pos + 7);

		String serviceClassName =
			className.substring(0, pos) + ".service." + simpleClassName +
				"LocalServiceUtil";

		try {
			Class<?> serviceClass = classLoader.loadClass(serviceClassName);

			dynamicQueryCountMethod = serviceClass.getMethod(
				"dynamicQueryCount", new Class[] {DynamicQuery.class});
			dynamicQueryMethod = serviceClass.getMethod(
				"dynamicQuery", new Class[] {DynamicQuery.class});
			fetchModelMethod = serviceClass.getMethod(
				"fetch" + simpleClassName, new Class[] {long.class});
			getModelsCountMethod = serviceClass.getMethod(
				"get" + TextFormatter.formatPlural(simpleClassName) + "Count",
				new Class[0]);
			getModelsMethod = serviceClass.getMethod(
				"get" + TextFormatter.formatPlural(simpleClassName),
				new Class[] {int.class, int.class});
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery) throws Exception {
		return (List)dynamicQueryMethod.invoke(false, dynamicQuery);
	}

	public long dynamicQueryCount(DynamicQuery dynamicQuery) throws Exception {
		return (Long)dynamicQueryCountMethod.invoke(false, dynamicQuery);
	}

	public BaseModel<?> fetchModel(long classPK) throws Exception {
		return (BaseModel<?>)fetchModelMethod.invoke(false, classPK);
	}

	@SuppressWarnings("rawtypes")
	public List getModels(int start, int end) throws Exception {
		return (List)getModelsMethod.invoke(false, start, end);
	}

	public int getModelsCount() throws Exception {
		return (Integer)getModelsCountMethod.invoke(false);
	}

	protected Method dynamicQueryCountMethod;
	protected Method dynamicQueryMethod;
	protected Method fetchModelMethod;
	protected Method getModelsCountMethod;
	protected Method getModelsMethod;

}