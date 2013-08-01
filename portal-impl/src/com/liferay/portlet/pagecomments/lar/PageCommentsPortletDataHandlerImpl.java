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

package com.liferay.portlet.pagecomments.lar;

import com.liferay.portal.kernel.lar.BasePortletDataHandler;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.portal.kernel.lar.PortletDataHandlerControl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;

import javax.portlet.PortletPreferences;

/**
 * @author Bruno Farache
 * @author Hugo Huijser
 */
public class PageCommentsPortletDataHandlerImpl extends BasePortletDataHandler {

	@Override
	public PortletDataHandlerControl[] getExportControls() {
		return new PortletDataHandlerControl[] {_comments};
	}

	@Override
	public PortletDataHandlerControl[] getImportControls() {
		return new PortletDataHandlerControl[] {_comments};
	}

	@Override
	protected PortletPreferences doDeleteData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		MBMessageLocalServiceUtil.deleteDiscussionMessages(
			Layout.class.getName(), portletDataContext.getPlid());

		return null;
	}

	@Override
	protected String doExportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		portletDataContext.addPermissions(
			"com.liferay.portlet.pagecomments",
			portletDataContext.getScopeGroupId());

		Document document = SAXReaderUtil.createDocument();

		Element rootElement = document.addElement("page-comments-data");

		rootElement.addAttribute(
			"group-id", String.valueOf(portletDataContext.getScopeGroupId()));
		rootElement.addAttribute(
			"plid", String.valueOf(portletDataContext.getPlid()));

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "comments")) {
			portletDataContext.addComments(
				Layout.class, portletDataContext.getPlid());
		}

		return document.formattedString();
	}

	@Override
	protected PortletPreferences doImportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences, String data)
		throws Exception {

		portletDataContext.importPermissions(
			"com.liferay.portlet.pagecomments",
			portletDataContext.getSourceGroupId(),
			portletDataContext.getScopeGroupId());

		if (Validator.isNull(data)) {
			return null;
		}

		Document document = SAXReaderUtil.read(data);

		Element rootElement = document.getRootElement();

		long plid = GetterUtil.getLong(rootElement.attributeValue("plid"));

		portletDataContext.importComments(
			Layout.class, plid, portletDataContext.getPlid(),
			portletDataContext.getScopeGroupId());

		return null;
	}

	private static final String _NAMESPACE = "page_comments";

	private static PortletDataHandlerBoolean _comments =
		new PortletDataHandlerBoolean(_NAMESPACE, "comments", true, true);

}