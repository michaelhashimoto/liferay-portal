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
import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Brian Wing Shun Chan
 */
public class UserPermissionUtil {

	/**
	 * @deprecated
	 */
	public static void check(
			PermissionChecker permissionChecker, long userId,
			long organizationId, long locationId, String actionId)
		throws PrincipalException {

		check(
			permissionChecker, userId, new long[] {organizationId, locationId},
			actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long userId,
			long[] organizationIds, String actionId)
		throws PrincipalException {

		getUserPermission().check(
			permissionChecker, userId, organizationIds, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long userId, String actionId)
		throws PrincipalException {

		getUserPermission().check(permissionChecker, userId, actionId);
	}

	/**
	 * @deprecated
	 */
	public static boolean contains(
		PermissionChecker permissionChecker, long userId, long organizationId,
		long locationId, String actionId) {

		return contains(
			permissionChecker, userId, new long[] {organizationId, locationId},
			actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long userId,
		long[] organizationIds, String actionId) {

		return getUserPermission().contains(
			permissionChecker, userId, organizationIds, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long userId, String actionId) {

		return getUserPermission().contains(
			permissionChecker, userId, actionId);
	}

	public static UserPermission getUserPermission() {
		PortalRuntimePermission.checkGetBeanProperty(UserPermissionUtil.class);

		return _userPermission;
	}

	public static boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Group group, Role role,
			User user)
		throws PortalException, SystemException {

		return getUserPermission().hasMembershipProtected(
			permissionChecker, group, role, user);
	}

	public static boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Group group, User user)
		throws PortalException, SystemException {

		return getUserPermission().hasMembershipProtected(
			permissionChecker, group, user);
	}

	public static boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Organization organization,
			Role role, User user)
		throws SystemException {

		return getUserPermission().hasMembershipProtected(
			permissionChecker, organization, role, user);
	}

	public static boolean hasMembershipProtected(
			PermissionChecker permissionChecker, Organization organization,
			User user)
		throws PortalException, SystemException {

		return getUserPermission().hasMembershipProtected(
			permissionChecker, organization, user);
	}

	public void setUserPermission(UserPermission userPermission) {
		PortalRuntimePermission.checkSetBeanProperty(getClass());

		_userPermission = userPermission;
	}

	private static UserPermission _userPermission;

}