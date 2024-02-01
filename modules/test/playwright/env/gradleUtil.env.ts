/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {execSync} from 'child_process';
import {PathOrFileDescriptor, existsSync} from 'node:fs'

import {resolve} from 'path'

import {executeBashScriptPrint} from './bashUtil.env'

export type GradleParameter = {
	name: string;
	value: string;
}

export function executeGradleTask(executionDir: PathOrFileDescriptor, taskName: string, gradleParameters: GradleParameter[]) {
	let script = 'cd ' + executionDir + ' ; ';
	
	script += _getGradleWrapper(executionDir) + ' ' + taskName;

	for (const gradleParameter of gradleParameters) {
		script += ' -P' + gradleParameter.name + '=' + gradleParameter.value;
	}

	executeBashScriptPrint(script);
}

function _getGradleWrapper(dir: PathOrFileDescriptor) {
	const gradleWrapper = dir + "/gradlew";

	if (existsSync(gradleWrapper)) {
		return resolve(gradleWrapper.toString());
	}

	const regex = /(.+)\/[^\/]+/;

	const results = regex.exec(dir.toString());

	return _getGradleWrapper(resolve(results[1]));
}