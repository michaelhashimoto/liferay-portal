/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {ChildProcess, exec, execSync, spawn} from 'child_process';

export function executeBashScript(bashScript: string) {
	const results = execSync(bashScript);

	return results.toString('utf8');
}

export function executeBashScriptPrint(bashScript: string) {
	console.log('Executing Bash Script:');
	console.log(bashScript);

	execSync(bashScript, {stdio: 'inherit'});
}

export function executeBashScriptSpawn(bashScript: string) {
	console.log('Executing Bash Script:');
	console.log(bashScript);

	let child = spawn('/bin/bash', ['-c', bashScript]);

	child.stdout.setEncoding('utf8');

    child.stdout.on('data', function(data) {
        console.log(data.trim());
    });

    child.stderr.setEncoding('utf8');

    child.stderr.on('data', function(data) {
        console.log(data.trim());
    });
}

// export function executeBashScriptSpawn(bashScript: string): ChildProcess {
// 	console.log('Executing Bash Script:');
// 	console.log(bashScript);

// 	return spawn('/bin/bash', ['-c', bashScript], {stdio: 'inherit'});
// }