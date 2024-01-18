/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {executeBashScriptPrint} from './BashScriptHelper'

export function callTarget(baseDir: string, antFileName: string, targetName: string, parameters?: Map<string, string>) {
	let antCommand = '#!/bin/bash\n';

	if ((baseDir != null) && (baseDir != undefined)) {
		antCommand += 'cd ' + baseDir + '\n';
	}

	antCommand += 'ant'

	if ((antFileName != null) && (antFileName != undefined)) {
		antCommand += ' -f ' + antFileName;
	}

	if ((targetName !== null) && (targetName !== undefined)) {
		antCommand += ' ' + targetName;
	}

	if ((parameters !== null) && (parameters !== undefined)) {
		for (const [parameterName, parameterValue] of Object.entries(parameters)) {
			antCommand += ' -D' + parameterName + '=' + parameterValue;
		}
	}

	executeBashScriptPrint(antCommand);
}