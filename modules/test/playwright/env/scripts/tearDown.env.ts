/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {portalTearDown} from '../../tests/portal-web/env/scripts/portalTearDown.env';
import {stopAppServer} from './appServerUtil.env';
import {getPlaywrightProjectName} from './common.env';

export function tearDown() {
	stopAppServer();
}

const playwrightProjectName = getPlaywrightProjectName();

if (playwrightProjectName === 'portal') {
	portalTearDown();
}
else {
	tearDown();
}
