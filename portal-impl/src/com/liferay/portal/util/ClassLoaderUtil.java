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

package com.liferay.portal.util;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author Raymond Augé
 */
public class ClassLoaderUtil {

	public static ClassLoader getClassLoader(final Class<?> clazz) {
		return AccessController.doPrivileged(
			new PrivilegedAction<ClassLoader>() {

				public ClassLoader run() {
					return clazz.getClassLoader();
				}

			}
		);
	}

	public static ClassLoader getContextClassLoader() {
		return AccessController.doPrivileged(
			new PrivilegedAction<ClassLoader>() {

				public ClassLoader run() {
					Thread thread = Thread.currentThread();

					return thread.getContextClassLoader();
				}

			}
		);
	}

	public static ClassLoader getPortalClassLoader() {
		return AccessController.doPrivileged(
			new PrivilegedAction<ClassLoader>() {

				public ClassLoader run() {
					return PortalClassLoaderUtil.getClassLoader();
				}

			}
		);
	}

	public static void setContextClassLoader(final ClassLoader classLoader) {
		AccessController.doPrivileged(
			new PrivilegedAction<Void>() {

				public Void run() {
					Thread thread = Thread.currentThread();

					thread.setContextClassLoader(classLoader);

					return null;
				}

			}
		);
	}

}