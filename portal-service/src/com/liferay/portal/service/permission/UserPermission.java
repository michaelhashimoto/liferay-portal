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

package com.liferay.portal.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Charles May
 */
public interface UserPermission {

	/**
	 * @deprecated
	 */
	public void check(
			PermissionChecker permissionChecker, long userId,
			long organizationId, long locationId, String actionId)
		throws PrincipalException;

	public void check(
			PermissionChecker permissionChecker, long userId,
			long[] organizationIds, String actionId)
		throws PrincipalException;

	public void check(
			PermissionChecker permissionChecker, long userId, String actionId)
		throws PrincipalException;

	/**
	 * @deprecated
	 */
	public boolean contains(
		PermissionChecker permissionChecker, long userId, long organizationId,
		long locationId, String actionId);

	public boolean contains(
		PermissionChecker permissionChecker, long userId,
		long[] organizationIds, String actionId);

	public boolean contains(
		PermissionChecker permissionChecker, long userId, String actionId);

	public boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Group group, Role role,
			User user)
		throws PortalException, SystemException;

	public boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Group group, User user)
		throws PortalException, SystemException;

	public boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Organization organization,
			Role role, User user)
		throws SystemException;

	public boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Organization organization,
			User user)
		throws PortalException, SystemException;

}