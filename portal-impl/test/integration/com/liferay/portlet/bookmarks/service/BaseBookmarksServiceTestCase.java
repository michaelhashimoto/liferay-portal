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

package com.liferay.portlet.bookmarks.service;

import com.liferay.portal.model.Group;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceTestUtil;
import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.bookmarks.model.BookmarksFolder;
import com.liferay.portlet.bookmarks.model.BookmarksFolderConstants;

import org.junit.Before;

/**
 * @author Brian Wing Shun Chan
 */
public class BaseBookmarksServiceTestCase {

	@Before
	public void setUp() throws Exception {
		group = ServiceTestUtil.addGroup();
	}

	protected BookmarksEntry addEntry() throws Exception {
		BookmarksFolder folder = addFolder();

		String name = "Test Entry";
		String url = "http://www.liferay.com";
		String description = "This is a test entry.";

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		return BookmarksEntryServiceUtil.addEntry(
			folder.getGroupId(), folder.getFolderId(), name, url, description,
			serviceContext);
	}

	protected BookmarksFolder addFolder() throws Exception {
		long parentFolderId = BookmarksFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		return addFolder(parentFolderId);
	}

	protected BookmarksFolder addFolder(long parentFolderId) throws Exception {
		String name = "Test Folder";
		String description = "This is a test folder.";

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setScopeGroupId(group.getGroupId());

		return BookmarksFolderServiceUtil.addFolder(
			parentFolderId, name, description, serviceContext);
	}

	protected Group group;

}