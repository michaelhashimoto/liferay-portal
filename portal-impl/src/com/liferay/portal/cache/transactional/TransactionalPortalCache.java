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

package com.liferay.portal.cache.transactional;

import com.liferay.portal.kernel.cache.CacheListener;
import com.liferay.portal.kernel.cache.CacheListenerScope;
import com.liferay.portal.kernel.cache.PortalCache;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Shuyang Zhou
 * @author Edward Han
 */
public class TransactionalPortalCache implements PortalCache {

	public TransactionalPortalCache(PortalCache portalCache) {
		_portalCache = portalCache;
	}

	@Override
	public void destroy() {
	}

	@Override
	public Collection<Object> get(Collection<Serializable> keys) {
		List<Object> values = new ArrayList<Object>(keys.size());

		for (Serializable key : keys) {
			values.add(get(key));
		}

		return values;
	}

	@Override
	public Object get(Serializable key) {
		Object result = null;

		if (TransactionalPortalCacheHelper.isEnabled()) {
			result = TransactionalPortalCacheHelper.get(_portalCache, key);

			if (result == NULL_HOLDER) {
				return null;
			}
		}

		if (result == null) {
			result = _portalCache.get(key);
		}

		return result;
	}

	@Override
	public String getName() {
		return _portalCache.getName();
	}

	@Override
	public void put(Serializable key, Object value) {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			if (value == null) {
				value = NULL_HOLDER;
			}

			TransactionalPortalCacheHelper.put(_portalCache, key, value);
		}
		else {
			_portalCache.put(key, value);
		}
	}

	@Override
	public void put(Serializable key, Object value, int timeToLive) {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			if (value == null) {
				value = NULL_HOLDER;
			}

			TransactionalPortalCacheHelper.put(_portalCache, key, value);
		}
		else {
			_portalCache.put(key, value, timeToLive);
		}
	}

	@Override
	public void put(Serializable key, Serializable value) {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			if (value == null) {
				value = NULL_HOLDER;
			}

			TransactionalPortalCacheHelper.put(_portalCache, key, value);
		}
		else {
			_portalCache.put(key, value);
		}
	}

	@Override
	public void put(Serializable key, Serializable value, int timeToLive) {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			if (value == null) {
				value = NULL_HOLDER;
			}

			TransactionalPortalCacheHelper.put(_portalCache, key, value);
		}
		else {
			_portalCache.put(key, value, timeToLive);
		}
	}

	@Override
	public void registerCacheListener(CacheListener cacheListener) {
		_portalCache.registerCacheListener(cacheListener);
	}

	@Override
	public void registerCacheListener(
		CacheListener cacheListener, CacheListenerScope cacheListenerScope) {

		_portalCache.registerCacheListener(cacheListener, cacheListenerScope);
	}

	@Override
	public void remove(Serializable key) {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			TransactionalPortalCacheHelper.put(_portalCache, key, NULL_HOLDER);
		}
		else {
			_portalCache.remove(key);
		}
	}

	@Override
	public void removeAll() {
		if (TransactionalPortalCacheHelper.isEnabled()) {
			TransactionalPortalCacheHelper.removeAll(_portalCache);
		}
		else {
			_portalCache.removeAll();
		}
	}

	@Override
	public void unregisterCacheListener(CacheListener cacheListener) {
		_portalCache.unregisterCacheListener(cacheListener);
	}

	@Override
	public void unregisterCacheListeners() {
		_portalCache.unregisterCacheListeners();
	}

	protected static Serializable NULL_HOLDER = "NULL_HOLDER";

	private PortalCache _portalCache;

}