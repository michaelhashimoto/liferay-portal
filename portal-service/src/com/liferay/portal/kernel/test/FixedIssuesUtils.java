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

package com.liferay.portal.kernel.test;

import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;

import org.junit.Assume;

/**
 * @author Zsolt Balogh
 */
public class FixedIssuesUtils {

	public static void assumeIssueIsFixed(String issue) {
		Assume.assumeTrue(isIssueFixed(issue));
	}

	public static void assumeIssueIsNotFixed(String issue) {
		Assume.assumeFalse(isIssueFixed(issue));
	}

	public static boolean isIssueFixed(String issue) {
		return ArrayUtil.contains(_instance._fixedIssues, issue);
	}

	private FixedIssuesUtils() {
		_fixedIssues = StringUtil.split(
			GetterUtil.getString(System.getProperty("fixed.issues")));
	}

	private static FixedIssuesUtils _instance = new FixedIssuesUtils();

	private String[] _fixedIssues;

}