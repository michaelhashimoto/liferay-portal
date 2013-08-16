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

package com.liferay.portal.freemarker;

import com.liferay.portal.kernel.cache.MultiVMKeyPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;

import freemarker.cache.ConcurrentCacheStorage;

/**
 * @author Mika Koivisto
 */
public class LiferayCacheStorage implements ConcurrentCacheStorage {

	public static PortalCache getPortalCache() {
		return _portalCache;
	}

	@Override
	public void clear() {
		_portalCache.removeAll();
	}

	@Override
	public Object get(Object key) {
		return _portalCache.get(key.toString());
	}

	@Override
	public boolean isConcurrent() {
		return true;
	}

	@Override
	public void put(Object key, Object value) {
		_portalCache.put(key.toString(), value);
	}

	@Override
	public void remove(Object key) {
		_portalCache.remove(key.toString());
	}

	private static PortalCache _portalCache = MultiVMKeyPoolUtil.getCache(
		LiferayCacheStorage.class.getName());

}