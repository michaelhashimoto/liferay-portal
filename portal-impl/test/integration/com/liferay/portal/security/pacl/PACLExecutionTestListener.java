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

package com.liferay.portal.security.pacl;

import com.liferay.portal.kernel.deploy.hot.HotDeployEvent;
import com.liferay.portal.kernel.deploy.hot.HotDeployUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.test.AbstractExecutionTestListener;
import com.liferay.portal.kernel.test.TestContext;
import com.liferay.portal.spring.context.PortletContextLoaderListener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockServletContext;

/**
 * @author Raymond Augé
 */
public class PACLExecutionTestListener extends AbstractExecutionTestListener {

	@Override
	public void runAfterClass(TestContext testContext) {
		HotDeployEvent hotDeployEvent = _hotDeployEvents.remove(
			testContext.getClazz());

		if (hotDeployEvent == null) {
			return;
		}

		HotDeployUtil.fireUndeployEvent(hotDeployEvent);

		PortletContextLoaderListener portletContextLoaderListener =
			new PortletContextLoaderListener();

		try {
			PortletClassLoaderUtil.setClassLoader(
				hotDeployEvent.getContextClassLoader());
			PortletClassLoaderUtil.setServletContextName(
				hotDeployEvent.getServletContextName());

			portletContextLoaderListener.contextDestroyed(
				new ServletContextEvent(hotDeployEvent.getServletContext()));
		}
		finally {
			PortletClassLoaderUtil.setClassLoader(null);
			PortletClassLoaderUtil.setServletContextName(null);
		}
	}

	@Override
	public void runBeforeClass(TestContext testContext) {
		Class<?> clazz = testContext.getClazz();

		ClassLoader classLoader = clazz.getClassLoader();

		MockServletContext mockServletContext = new MockServletContext(
			new PACLResourceLoader(classLoader));

		mockServletContext.setServletContextName("a-test-hook");

		HotDeployEvent hotDeployEvent = new HotDeployEvent(
			mockServletContext, classLoader);

		HotDeployUtil.fireDeployEvent(hotDeployEvent);

		PortletContextLoaderListener portletContextLoaderListener =
			new PortletContextLoaderListener();

		try {
			PortletClassLoaderUtil.setClassLoader(
				hotDeployEvent.getContextClassLoader());
			PortletClassLoaderUtil.setServletContextName(
				hotDeployEvent.getServletContextName());

			portletContextLoaderListener.contextInitialized(
				new ServletContextEvent(mockServletContext));
		}
		finally {
			PortletClassLoaderUtil.setClassLoader(null);
			PortletClassLoaderUtil.setServletContextName(null);
		}

		_hotDeployEvents.put(clazz, hotDeployEvent);
	}

	private static Map<Class<?>, HotDeployEvent> _hotDeployEvents =
		new HashMap<Class<?>, HotDeployEvent>();

	private static class PACLResourceLoader implements ResourceLoader {

		public PACLResourceLoader(ClassLoader classLoader) {
			_classLoader = classLoader;
		}

		@Override
		public Resource getResource(String location) {
			ClassLoader classLoader = getClassLoader();

			return new ClassPathResource(
				PACLIntegrationJUnitTestRunner.RESOURCE_PATH + location,
				classLoader);
		}

		@Override
		public ClassLoader getClassLoader() {
			return _classLoader;
		}

		private ClassLoader _classLoader;

	}

}