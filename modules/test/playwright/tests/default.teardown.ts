/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {test} from '@playwright/test';

import {callTarget} from '../helpers/AntHelper';
import {getBasePortalDir} from '../helpers/LiferayPortalRepositoryHelper';

test('stop app server', async ({page}) => {
	let basePortalDir = getBasePortalDir();

	callTarget(basePortalDir, 'build-test.xml', 'stop-app-server');

	callTarget(basePortalDir, 'build-test.xml', 'wait-for-server-shutdown');
});