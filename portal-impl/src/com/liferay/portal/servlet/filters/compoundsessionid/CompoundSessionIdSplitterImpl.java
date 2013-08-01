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

package com.liferay.portal.servlet.filters.compoundsessionid;

import com.liferay.portal.kernel.servlet.filters.compoundsessionid.CompoundSessionIdSplitter;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsValues;

/**
 * @author Michael C. Han
 */
public class CompoundSessionIdSplitterImpl
	implements CompoundSessionIdSplitter {

	@Override
	public String getSessionIdDelimiter() {
		return _sessionIdDelimiter;
	}

	@Override
	public boolean hasSessionDelimiter() {
		return Validator.isNotNull(_sessionIdDelimiter);
	}

	@Override
	public String parseSessionId(String sessionId) {
		if (Validator.isNull(_sessionIdDelimiter)) {
			return sessionId;
		}

		int pos = sessionId.indexOf(_sessionIdDelimiter);

		if (pos == -1) {
			return sessionId;
		}

		return sessionId.substring(0, pos);
	}

	private static String _sessionIdDelimiter;

	static {
		String sessionIdDelimiter = PropsValues.SESSION_ID_DELIMITER;

		if (Validator.isNull(sessionIdDelimiter)) {
			sessionIdDelimiter = PropsUtil.get(
				"session.id." + ServerDetector.getServerId() + ".delimiter");
		}

		if (sessionIdDelimiter == null) {
			sessionIdDelimiter = StringPool.BLANK;
		}

		_sessionIdDelimiter = sessionIdDelimiter;
	}

}