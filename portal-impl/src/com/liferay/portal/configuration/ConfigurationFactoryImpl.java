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

package com.liferay.portal.configuration;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactory;
import com.liferay.portal.kernel.security.pacl.DoPrivileged;

/**
 * @author Brian Wing Shun Chan
 */
@DoPrivileged
public class ConfigurationFactoryImpl implements ConfigurationFactory {

	@Override
	public Configuration getConfiguration(
		ClassLoader classLoader, String name) {

		return new ConfigurationImpl(classLoader, name);
	}

}