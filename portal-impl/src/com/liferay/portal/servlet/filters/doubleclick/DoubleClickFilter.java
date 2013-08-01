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

package com.liferay.portal.servlet.filters.doubleclick;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.TransientValue;
import com.liferay.portal.servlet.filters.BasePortalFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.StopWatch;

/**
 * @author     Olaf Fricke
 * @author     Brian Wing Shun Chan
 * @author     Raymond Augé
 * @deprecated As of 6.1.0, with no direct replacement
 */
public class DoubleClickFilter extends BasePortalFilter {

	@Override
	public boolean isFilterEnabled() {
		return false;
	}

	@Override
	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		StopWatch stopWatch = null;

		if (_log.isDebugEnabled()) {
			stopWatch = new StopWatch();

			stopWatch.start();
		}

		HttpSession session = request.getSession(false);

		if (session == null) {
			processFilter(
				DoubleClickFilter.class, request, response, filterChain);
		}
		else {
			DoubleClickController doubleClickController = null;

			synchronized (session) {
				TransientValue<DoubleClickController> transientValue =
					(TransientValue<DoubleClickController>)session.getAttribute(
						_CONTROLLER_KEY);

				if (transientValue != null) {
					doubleClickController = transientValue.getValue();
				}

				if (doubleClickController == null) {
					doubleClickController = new DoubleClickController();

					transientValue = new TransientValue<DoubleClickController>(
						doubleClickController);

					session.setAttribute(_CONTROLLER_KEY, transientValue);
				}
			}

			boolean ok = false;

			try {
				doubleClickController.control(request, response, filterChain);

				ok = true;
			}
			finally {
				if (stopWatch != null) {
					String completeURL = HttpUtil.getCompleteURL(request);

					if (ok) {
						_log.debug(
							"Double click prevention succeeded in " +
								stopWatch.getTime() + " ms for " + completeURL);
					}
					else {
						_log.debug(
							"Double click prevention failed in " +
								stopWatch.getTime() + " ms for " + completeURL);
					}
				}
			}
		}
	}

	private static final String _CONTROLLER_KEY =
		DoubleClickFilter.class.getName();

	private static Log _log = LogFactoryUtil.getLog(DoubleClickFilter.class);

}