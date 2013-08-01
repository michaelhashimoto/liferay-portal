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

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.bookmarks.model.BookmarksFolder;
import com.liferay.portlet.bookmarks.model.impl.BookmarksFolderImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

/**
 * @author Joshua Steven Rodriguez
 */
public class BookmarksFolderFinderImpl
	extends BasePersistenceImpl<BookmarksFolder>
	implements BookmarksFolderFinder {

	public static final String FIND_BY_NO_RESOURCE_BLOCKS =
		BookmarksFolderFinder.class.getName() + ".findByNoResourceBlocks";

	@Override
	public List<BookmarksFolder> findByNoResourceBlocks()
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_NO_RESOURCE_BLOCKS);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("BookmarksFolder", BookmarksFolderImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(BookmarksFolder.class.getName());

			return q.list(true);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}