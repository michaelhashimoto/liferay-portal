/**
 * SPDX-FileCopyrightText: (c) 2004 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

export function executeBashScript(bashScript: string) {
	let childProcess = require('child_process');

	const result = childProcess.execSync(bashScript);

	return result.toString('utf8');
}

export function executeBashScriptPrint(bashScript: string) {
	console.log('Executing Bash Script:');
	console.log(bashScript);

	let childProcess = require('child_process');

	childProcess.execSync(bashScript, {stdio: 'inherit'});
}