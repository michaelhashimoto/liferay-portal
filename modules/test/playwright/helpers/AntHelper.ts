/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {executeBashScriptPrint} from './BashScriptHelper'

export function callTarget(baseDir: string, antFileName: string, targetName: string, parameters?: Map<string, string>) {
	let antCommand = '#!/bin/bash\n\n';

	antCommand += 'ANT_OPTS=' + process.env.ANT_OPTS + '\n';
	antCommand += 'HOSTNAME=' + process.env.HOSTNAME + '\n';
	antCommand += 'JAVA_HOME=' + process.env.JAVA_HOME + '\n';
	antCommand += 'MASTER_HOSTNAME=' + process.env.MASTER_HOSTNAME + '\n';
	antCommand += 'ORACLE_HOME=' + process.env.ORACLE_HOME + '\n';
	antCommand += 'ORACLE_SID=' + process.env.ORACLE_SID + '\n';
	antCommand += 'PATH=' + process.env.PATH + '\n';
	antCommand += 'SYBASE_ASE=' + process.env.SYBASE_ASE + '\n';

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