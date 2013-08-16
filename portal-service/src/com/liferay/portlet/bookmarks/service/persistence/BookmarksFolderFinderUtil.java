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

package com.liferay.portlet.bookmarks.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class BookmarksFolderFinderUtil {
	public static java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByNoResourceBlocks()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByNoResourceBlocks();
	}

	public static BookmarksFolderFinder getFinder() {
		if (_finder == null) {
			_finder = (BookmarksFolderFinder)PortalBeanLocatorUtil.locate(BookmarksFolderFinder.class.getName());

			ReferenceRegistry.registerReference(BookmarksFolderFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BookmarksFolderFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BookmarksFolderFinderUtil.class,
			"_finder");
	}

	private static BookmarksFolderFinder _finder;
}