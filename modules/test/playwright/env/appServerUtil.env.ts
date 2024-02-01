/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {setDefaultResultOrder} from "dns";
import {glob} from 'glob';

import {executeBashScript, executeBashScriptPrint, executeBashScriptSpawn} from './bashUtil.env';
import {getLiferayHome} from './common.env';

setDefaultResultOrder("ipv4first");

export function startAppServer() {
	const script = 'cd ' + _getTomcatDir() + ' && /bin/bash catalina.sh run';

	return executeBashScriptSpawn(script);
}

export function stopAppServer() {
	const script = 'cd ' + _getTomcatDir() + ' && /bin/bash shutdown.sh';

	executeBashScriptPrint(script);
}

export function waitForStartedAppServer() {
	console.log('Wating for app server to start up');

	waitForURLAvailable('http://localhost:8080/web/guest');
}

function _getTomcatDir() {
	const tomcatBinDirs = glob.sync(getLiferayHome() + '/tomcat*/bin');

	if (!tomcatBinDirs.length) {
		throw new Error('Could not find tomcat bin dir');
	}

	return tomcatBinDirs[0];
}

function waitForURLAvailable(url, maxRetries = 30, retryInterval = 5000) {
	const retries = 0;

	while (true) {
		try {
			executeBashScript('curl ' + url);

			break;
		}
		catch {
			console.log(`Waiting for ${url} to be available, will retry in ${retryInterval / 1000} seconds.`);

			executeBashScript('sleep ' + (retryInterval / 1000));

			if (retries >= maxRetries) {
				throw new Error(url + ` was uavailable.`)
			}
		}
	}

	console.log(`${url} is now available.`);
}