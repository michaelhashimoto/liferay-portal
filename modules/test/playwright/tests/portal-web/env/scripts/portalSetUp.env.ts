/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {setUp} from '../../../../env/scripts/setUp.env';

export function portalSetUp() {
	process.stdout.write('Portal specific set up');

	setUp();
}
