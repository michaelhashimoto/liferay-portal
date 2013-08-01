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

package com.liferay.portal.kernel.staging;

import com.liferay.portal.kernel.util.AutoResetThreadLocal;
import com.liferay.portal.kernel.util.StringBundler;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Raymond Augé
 */
public class MergeLayoutPrototypesThreadLocal {

	public static boolean isInProgress() {
		return _inProgress.get().booleanValue();
	}

	public static boolean isMergeComplete(
		String methodName, Object[] arguments, Class<?>[] parameterTypes) {

		Set<String> methodKeys = _mergeComplete.get();

		String methodKey = _buildMethodKey(
			methodName, arguments, parameterTypes);

		return methodKeys.contains(methodKey);
	}

	public static void setInProgress(boolean inProgress) {
		_inProgress.set(inProgress);
	}

	public static void setMergeComplete(
		String methodName, Object[] arguments, Class<?>[] parameterTypes) {

		Set<String> methodKeys = _mergeComplete.get();

		String methodKey = _buildMethodKey(
			methodName, arguments, parameterTypes);

		methodKeys.add(methodKey);

		setInProgress(false);
	}

	private static String _buildMethodKey(
		String methodName, Object[] arguments, Class<?>[] parameterTypes) {

		if ((arguments == null) || (arguments.length == 0)) {
			return methodName;
		}

		StringBundler sb = new StringBundler(arguments.length * 2 + 1);

		sb.append(methodName);

		for (int i = 0; i < arguments.length; i++) {
			sb.append(parameterTypes[0].getClass().getName());

			sb.append(arguments.toString());
		}

		return sb.toString();
	}

	private static ThreadLocal<Boolean> _inProgress =
		new AutoResetThreadLocal<Boolean>(
			MergeLayoutPrototypesThreadLocal.class + "._inProgress", false);
	private static ThreadLocal<Set<String>> _mergeComplete =
		new AutoResetThreadLocal<Set<String>>(
			MergeLayoutPrototypesThreadLocal.class + "._mergeComplete",
			new HashSet<String>());

}