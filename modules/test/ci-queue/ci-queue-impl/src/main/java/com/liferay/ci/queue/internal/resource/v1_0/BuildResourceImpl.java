/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.ci.queue.internal.resource.v1_0;

import com.liferay.ci.queue.resource.v1_0.BuildResource;

import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.rest.dto.v1_0.ObjectEntry;
import com.liferay.object.rest.manager.v1_0.ObjectEntryManager;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.vulcan.dto.converter.DefaultDTOConverterContext;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Hashimoto
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/build.properties",
	scope = ServiceScope.PROTOTYPE, service = BuildResource.class
)
public class BuildResourceImpl extends BaseBuildResourceImpl {

	@Override
	public String build() throws Exception {
		User user = _userLocalService.getUser(contextUser.getUserId());

		_defaultDTOConverterContext = new DefaultDTOConverterContext(
			false, null, null, null, null, LocaleUtil.getSiteDefault(), null,
			user);

		ObjectDefinition objectDefinition = _getObjectDefinition(
			"Queue");

		Page<ObjectEntry> page = _objectEntryManager.getObjectEntries(
			contextCompany.getCompanyId(), objectDefinition, null, null,
			_defaultDTOConverterContext, "name isNotNull", null, null, null);

		String string = "";

		for (ObjectEntry objectEntry : page.getItems()) {
			Map<String, Object> properties = objectEntry.getProperties();

			string += "##\n";
			string += "## objectEntry=" + objectEntry + "\n";
			string += "##\n";

			for (Map.Entry<String, Object> entry : properties.entrySet()) {
				string += "-> " + entry + "\n";
			}

			string += "\n\n";
		}

		return string;
	}

	@Override
	public Response build(String string) throws Exception {
		_defaultDTOConverterContext = new DefaultDTOConverterContext(
			false, null, null, null, null, LocaleUtil.getSiteDefault(), null,
			_userLocalService.getUser(contextUser.getUserId()));

		ObjectDefinition objectDefinition = _getObjectDefinition("Queue");

		Map<String, Object> properties = new HashMap<>();

		properties.put("name", string);

		ObjectEntry objectEntry = new ObjectEntry();

		objectEntry.setProperties(properties);

		_objectEntryManager.addObjectEntry(
			_defaultDTOConverterContext, objectDefinition, objectEntry, null);

		Response.ResponseBuilder responseBuilder = Response.ok(string);

		return responseBuilder.build();
	}

	private ObjectDefinition _getObjectDefinition(String objectName) {
		ObjectDefinition objectDefinition = _objectDefinitions.get(objectName);

		if (objectDefinition != null) {
			return objectDefinition;
		}

		List<ObjectDefinition> objectDefinitions =
			_objectDefinitionLocalService.getObjectDefinitions(
				contextCompany.getCompanyId(), true,
				WorkflowConstants.STATUS_APPROVED);

		for (ObjectDefinition currentObjectDefinition : objectDefinitions) {
			_objectDefinitions.put(
				currentObjectDefinition.getShortName(),
				currentObjectDefinition);
		}

		return _objectDefinitions.get(objectName);
	}

	private final Map<String, ObjectDefinition> _objectDefinitions =
		new HashMap<>();

	private DefaultDTOConverterContext _defaultDTOConverterContext;

	@Reference
	private ObjectDefinitionLocalService _objectDefinitionLocalService;

	@Reference(target = "(object.entry.manager.storage.type=default)")
	private ObjectEntryManager _objectEntryManager;

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BuildResourceImpl.class);

	@Reference
	private UserLocalService _userLocalService;

}