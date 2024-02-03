/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {startAppServer, waitForStartedAppServer} from './appServerUtil.env';
import {deployProjectClientExtensions, deployProjectDeployDir, deployProjectOSGiModules, updatePortalExtProperties} from './common.env';
import axios from 'axios';
import {setDefaultResultOrder} from 'dns';

setDefaultResultOrder("ipv4first");

const checkUrl = async (url) => {
	try {
		const response = await axios.head(url);

		return response.status === 200;
	} catch (error) {
		return false;
	}
};

const waitForUrl = async (url, timeoutMinutes) => {
	const startTime = Date.now();

	while (!(await checkUrl(url))) {
		if (Date.now() - startTime > timeoutMinutes * 60 * 1000) {
			console.log(`Timeout reached (${timeoutMinutes} minutes). URL is not available.`);
			return false;
		}

		await new Promise(resolve => setTimeout(resolve, 5000)); // Wait for 5 seconds before checking again
	}

	console.log('URL is available!');

	return true;
};

	
updatePortalExtProperties();
	
deployProjectOSGiModules();

deployProjectClientExtensions();

deployProjectDeployDir();

startAppServer();

const urlToCheck = 'http://localhost:8080/web/guest';
const timeoutMinutes = 5;

waitForUrl(urlToCheck, timeoutMinutes);