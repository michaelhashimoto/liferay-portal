/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.onepassword;

import java.util.List;

/**
 * @author Michael Hashimoto
 */
public interface OnePasswordItem {

	public String getId();

	public OnePasswordConnect getOnePasswordConnect();

	public OnePasswordItemField getOnePasswordItemField(String label);

	public List<OnePasswordItemField> getOnePasswordItemFields();

	public OnePasswordItemFile getOnePasswordItemFile(String name);

	public List<OnePasswordItemFile> getOnePasswordItemFiles();

	public OnePasswordVault getOnePasswordVault();

	public String getTitle();

}