/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {mergeTests} from '@playwright/test';

import {loginTest} from '../../fixtures/loginTest';
import {objectPagesTest} from '../../fixtures/objectPagesTest'
import {picklistPagesTest} from '../../fixtures/picklistPagesTest'

export const test = mergeTests(
	loginTest,
	objectPagesTest,
	picklistPagesTest,
);

test.describe("Jethr0 Tests", () => {
	test('assert picklist', async ({page, modelBuilderPage, objectDefinitionsPage}) => {
		await objectDefinitionsPage.goto();
	});

	test('assert objects', async ({page, modelBuilderPage, objectDefinitionsPage}) => {
		await objectDefinitionsPage.goto();
	});
});