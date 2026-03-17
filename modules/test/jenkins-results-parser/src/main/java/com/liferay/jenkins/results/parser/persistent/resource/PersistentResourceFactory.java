/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.TopLevelBuild;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Hashimoto
 */
public class PersistentResourceFactory {

	public static PersistentResource newPersistentResource(
		TopLevelBuild topLevelBuild, PersistentResource.Type type) {

		if (_persistentResources.containsKey(type)) {
			return _persistentResources.get(type);
		}

		if (type == PersistentResource.Type.ASAH_BUNDLE) {
			_persistentResources.put(
				type, new AsahBundlePersistentResource(topLevelBuild));
		}

		if (type == PersistentResource.Type.FARO_BUNDLE) {
			_persistentResources.put(
				type, new FaroBundlePersistentResource(topLevelBuild));
		}
		else if (type == PersistentResource.Type.PORTAL_BUNDLE) {
			_persistentResources.put(
				type, new PortalBundlePersistentResource(topLevelBuild));
		}

		return _persistentResources.get(type);
	}

	private static final Map<PersistentResource.Type, PersistentResource>
		_persistentResources = new HashMap<>();

}