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

package com.liferay.portlet.journal.service;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.TestPropsValues;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.model.JournalTemplate;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Marcellus Tavares
 */
public class BaseJournalServiceTestCase {

	protected JournalArticle addArticle(
			String content, String structureId, String templateId)
		throws Exception {

		Map<Locale, String> titleMap = new HashMap<Locale, String>();

		titleMap.put(Locale.US, "Test Article");

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setScopeGroupId(TestPropsValues.getGroupId());

		return JournalArticleLocalServiceUtil.addArticle(
			TestPropsValues.getUserId(), TestPropsValues.getGroupId(), 0, 0,
			StringPool.BLANK, true, 0, titleMap, null, content, "general",
			structureId, templateId, null, 1, 1, 1965, 0, 0, 0, 0, 0, 0, 0,
			true, 0, 0, 0, 0, 0, true, false, false, null, null, null, null,
			serviceContext);
	}

	protected JournalStructure addStrucure(String xsd) throws Exception {
		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(Locale.US, "Test Structure");

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		return JournalStructureLocalServiceUtil.addStructure(
			TestPropsValues.getUserId(), TestPropsValues.getGroupId(),
			StringPool.BLANK, true, null, nameMap, null, xsd, serviceContext);
	}

	protected JournalTemplate addTemplate(
			String structureId, String xsl, String langType)
		throws Exception {

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(Locale.US, "Test Template");

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		return JournalTemplateLocalServiceUtil.addTemplate(
			TestPropsValues.getUserId(), TestPropsValues.getGroupId(),
			StringPool.BLANK, true, structureId, nameMap, null, xsl, true,
			langType, false, false, null, null, serviceContext);
	}

}