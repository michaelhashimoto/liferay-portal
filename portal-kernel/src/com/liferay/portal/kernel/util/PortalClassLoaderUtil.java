/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.util;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalClassLoaderUtil {

	public static ClassLoader getClassLoader() {
		return _classLoader;
	}

	public static boolean isPortalClassLoader(ClassLoader classLoader) {
		if (classLoader == _classLoader) {
			return true;
		}

		return false;
	}

	public static void setClassLoader(ClassLoader classLoader) {
		System.out.println("PortalClassLoaderUtil#setClassLoader");
		System.out.println("classLoader=" + classLoader);
		System.out.println("-------------------------------------------------");
		Thread.dumpStack();
		System.out.println("-------------------------------------------------");

		_classLoader = classLoader;
	}

	private static ClassLoader _classLoader;

}