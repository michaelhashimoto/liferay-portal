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

package com.liferay.portlet.messageboards.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.parsers.bbcode.BBCodeTranslatorUtil;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.documentlibrary.NoSuchDirectoryException;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategoryConstants;
import com.liferay.portlet.messageboards.model.MBDiscussion;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class MBMessageImpl extends MBMessageBaseImpl {

	public MBMessageImpl() {
	}

	@Override
	public String[] getAssetTagNames() throws SystemException {
		return AssetTagLocalServiceUtil.getTagNames(
			MBMessage.class.getName(), getMessageId());
	}

	@Override
	public String getAttachmentsDir() {
		if (_attachmentDirs == null) {
			_attachmentDirs = getThreadAttachmentsDir() + "/" + getMessageId();
		}

		return _attachmentDirs;
	}

	@Override
	public String[] getAttachmentsFiles()
		throws PortalException, SystemException {

		String[] fileNames = new String[0];

		try {
			fileNames = DLStoreUtil.getFileNames(
				getCompanyId(), CompanyConstants.SYSTEM, getAttachmentsDir());
		}
		catch (NoSuchDirectoryException nsde) {
		}

		return fileNames;
	}

	@Override
	public String getBody(boolean translate) {
		String body = null;

		if (translate) {
			body = BBCodeTranslatorUtil.getHTML(getBody());
		}
		else {
			body = getBody();
		}

		return body;
	}

	@Override
	public MBCategory getCategory() throws PortalException, SystemException {
		return MBCategoryLocalServiceUtil.getCategory(getCategoryId());
	}

	@Override
	public MBThread getThread() throws PortalException, SystemException {
		return MBThreadLocalServiceUtil.getThread(getThreadId());
	}

	@Override
	public String getThreadAttachmentsDir() {
		return "messageboards/" + getThreadId();
	}

	@Override
	public String getWorkflowClassName() {
		if (isDiscussion()) {
			return MBDiscussion.class.getName();
		}
		else {
			return MBMessage.class.getName();
		}
	}

	@Override
	public boolean isDiscussion() {
		if (getCategoryId() == MBCategoryConstants.DISCUSSION_CATEGORY_ID) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isFormatBBCode() {
		String format = getFormat();

		if (format.equals("bbcode")) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isReply() {
		return !isRoot();
	}

	@Override
	public boolean isRoot() {
		if (getParentMessageId() ==
				MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void setAttachmentsDir(String attachmentsDir) {
		_attachmentDirs = attachmentsDir;
	}

	private String _attachmentDirs;

}