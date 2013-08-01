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

package com.liferay.portal.kernel.templateparser;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BaseTransformerListener implements TransformerListener {

	@Override
	public String getLanguageId() {
		return _languageId;
	}

	@Override
	public Map<String, String> getTokens() {
		return _tokens;
	}

	@Override
	public boolean isTemplateDriven() {
		return _templateDriven;
	}

	@Override
	public abstract String onOutput(String s);

	@Override
	public abstract String onScript(String s);

	@Override
	public abstract String onXml(String s);

	@Override
	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	@Override
	public void setTemplateDriven(boolean templateDriven) {
		_templateDriven = templateDriven;
	}

	@Override
	public void setTokens(Map<String, String> tokens) {
		_tokens = tokens;
	}

	private String _languageId;
	private boolean _templateDriven;
	private Map<String, String> _tokens;

}