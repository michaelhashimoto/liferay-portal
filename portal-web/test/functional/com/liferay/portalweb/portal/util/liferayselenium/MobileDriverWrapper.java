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

package com.liferay.portalweb.portal.util.liferayselenium;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Response;

/**
 * @author Kenji Heigel
 */
public class MobileDriverWrapper
	extends WebDriverWrapper implements MobileDriver {

	public MobileDriverWrapper(MobileDriver mobileDriver) {
		super(mobileDriver);

		_mobileDriver = mobileDriver;
	}

	@Override
	public WebDriver context(String name) {
		return _mobileDriver.context(name);
	}

	@Override
	public Response execute(String driverCommand, Map<String, ?> parameters) {
		return _mobileDriver.execute(driverCommand, parameters);
	}

	@Override
	public String getContext() {
		return _mobileDriver.getContext();
	}

	@Override
	public Set<String> getContextHandles() {
		return _mobileDriver.getContextHandles();
	}

	@Override
	public void performMultiTouchAction(MultiTouchAction multiAction) {
		_mobileDriver.performMultiTouchAction(multiAction);
	}

	@Override
	public TouchAction performTouchAction(TouchAction touchAction) {
		return _mobileDriver.performTouchAction(touchAction);
	}

	private MobileDriver _mobileDriver;

}