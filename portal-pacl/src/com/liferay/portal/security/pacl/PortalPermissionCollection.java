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

package com.liferay.portal.security.pacl;

import com.liferay.portal.kernel.util.StringPool;

import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;

import java.util.Collections;
import java.util.Enumeration;

/**
 * @author Raymond Augé
 */
public class PortalPermissionCollection extends PermissionCollection {

	public PortalPermissionCollection(
		PACLPolicy paclPolicy, PermissionCollection permissionCollection) {

		_paclPolicy = paclPolicy;
		_permissionCollection = permissionCollection;
	}

	@Override
	public void add(Permission permission) {
		throw new SecurityException();
	}

	@Override
	public Enumeration<Permission> elements() {
		return Collections.enumeration(Collections.EMPTY_LIST);
	}

	public ClassLoader getClassLoader() {
		return _paclPolicy.getClassLoader();
	}

	public PACLPolicy getPACLPolicy() {
		return _paclPolicy;
	}

	public Policy getPolicy() {
		return _paclPolicy.getPolicy();
	}

	@Override
	public boolean implies(Permission permission) {
		if (!_paclPolicy.isActive()) {
			return true;
		}

		if (permission instanceof PACLUtil.Permission) {
			throw new PACLUtil.Exception(_paclPolicy);
		}

		if (_permissionCollection.implies(permission) ||
			_paclPolicy.implies(permission)) {

			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		Class<?> clazz = getClass();

		String className = clazz.getSimpleName();

		return className.concat(StringPool.POUND).concat(
			_paclPolicy.toString());
	}

	private PACLPolicy _paclPolicy;
	private PermissionCollection _permissionCollection;

}