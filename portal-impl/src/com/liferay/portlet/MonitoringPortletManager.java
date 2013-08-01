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

package com.liferay.portlet;

/**
 * @author Michael C. Han
 */
public class MonitoringPortletManager implements MonitoringPortletManagerMBean {

	@Override
	public boolean isMonitoringPortletActionRequest() {
		return MonitoringPortlet.isMonitoringPortletActionRequest();
	}

	@Override
	public boolean isMonitoringPortletEventRequest() {
		return MonitoringPortlet.isMonitoringPortletEventRequest();
	}

	@Override
	public boolean isMonitoringPortletRenderRequest() {
		return MonitoringPortlet.isMonitoringPortletRenderRequest();
	}

	@Override
	public boolean isMonitoringPortletResourceRequest() {
		return MonitoringPortlet.isMonitoringPortletResourceRequest();
	}

	@Override
	public void setMonitoringPortletActionRequest(
		boolean monitoringPortletActionRequest) {

		MonitoringPortlet.setMonitoringPortletActionRequest(
			monitoringPortletActionRequest);
	}

	@Override
	public void setMonitoringPortletEventRequest(
		boolean monitoringPortletEventRequest) {

		MonitoringPortlet.setMonitoringPortletEventRequest(
			monitoringPortletEventRequest);
	}

	@Override
	public void setMonitoringPortletRenderRequest(
		boolean monitoringPortletRenderRequest) {

		MonitoringPortlet.setMonitoringPortletRenderRequest(
			monitoringPortletRenderRequest);
	}

	@Override
	public void setMonitoringPortletResourceRequest(
		boolean monitoringPortletResourceRequest) {

		MonitoringPortlet.setMonitoringPortletResourceRequest(
			monitoringPortletResourceRequest);
	}

}