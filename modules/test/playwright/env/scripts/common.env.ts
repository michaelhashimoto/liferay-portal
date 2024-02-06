/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {glob} from 'glob';
import {copyFile, existsSync, mkdirSync, readFileSync} from 'node:fs'

import {resolve} from 'path'

import {executeBashScript} from './bashUtil.env';
import {executeGradleTask} from './gradleUtil.env';
import {getPropertiesFromFiles, getPropertyValue, writePropertiesFile} from './propertiesUtil.env';

export function deployProjectClientExtensions() {
	const clientExtensionsListFile = getPlaywrightProjectDir() + '/env/client-extensions.list';
	console.log('clientExtensionsListFile=' + clientExtensionsListFile);

	if (existsSync(clientExtensionsListFile)) {
		const clientExtensionsListFileContent = readFileSync(clientExtensionsListFile).toString();

		for (const clientExtension of clientExtensionsListFileContent.split("\n")) {
			console.log('clientExtension=' + clientExtension);

			_deployClientExtension(clientExtension);
		}
	}
}

export function deployProjectDeployDir() {
	const projectDeployDir = getPlaywrightProjectDir() + '/env/deploy/';

	console.log('projectDeployDir=' + projectDeployDir);

	if (existsSync(projectDeployDir)) {
		const deployDir = getLiferayHome() + '/deploy';

		if (!existsSync(deployDir)){
			mkdirSync(deployDir, { recursive: true });
		}

		const deployFiles = glob.sync(projectDeployDir + '/*');

		for (const deployFile of deployFiles) {
			console.log('deployFile=' + deployFile);

			const deployFileName = deployFile.replace(/.+\/([^\/]+)/, '\$1');

			copyFile(deployFile, deployDir + '/' + deployFileName, (error) => {
				if (error) {
					throw error;
				}
			});
		}
	}
}

export function deployProjectOSGiModules() {
	const osgiModulesListFile = getPlaywrightProjectDir() + '/env/osgi-modules.list';

	console.log('osgiModulesListFile=' + osgiModulesListFile);

	if (existsSync(osgiModulesListFile)) {
		const osgiModulesListFileContent = readFileSync(osgiModulesListFile).toString();

		for (const osgiModule of osgiModulesListFileContent.split("\n")) {
			console.log("osgiModule=" + osgiModule);

			_deployOSGiModule(osgiModule);
		}
	}
}

export function getLiferayHome() {
	return resolve(getPlaywrightProperty('liferay.home'))
}

export function getLiferayPortalDir() {
	return resolve(getPlaywrightProperty('liferay.portal.dir'));
}

export function getPlaywrightBaseDir() {
	return resolve(getPlaywrightProperty('playwright.base.dir'));
}

export function getPlaywrightProjectDir() {
	const playwrightProjectConfigFiles = glob.sync(getPlaywrightBaseDir() + '/tests/**/config.ts');

	const playwrightProjectName = getPlaywrightProperty('playwright.project.name');

	for (const playwrightProjectConfigFile of playwrightProjectConfigFiles) {
		const regex = /.*name: '([^']+)'.*/;

		const regexResults = regex.exec(readFileSync(playwrightProjectConfigFile).toString());

		if (playwrightProjectName === regexResults[1]) {
			return resolve(playwrightProjectConfigFile.replace(/(.+)\/[^\/]+/, '\$1'));
		}
	}
}

export function getPlaywrightProperties() {
	return getPropertiesFromFiles([
		'./playwright.properties',
		'./playwright.' + process.env.HOSTNAME + '.properties',
		'./playwright.' + process.env.HOST + '.properties',
		'./playwright.' + process.env.COMPUTERNAME + '.properties',
		'./playwright.' + _getUserName() + '.properties'
	]);
}

export function getPlaywrightProperty(propertyName: string) {
	return getPropertyValue(getPlaywrightProperties(), propertyName);
}

export function updatePortalExtProperties() {
	const liferayHome = getLiferayHome();
	
	let portalExtPropertiesFile = liferayHome + '/portal-ext.properties';

	let portalExtPropertiesFiles = glob.sync(liferayHome + '/**/portal-ext.properties');

	if (portalExtPropertiesFiles.length == 0) {
		portalExtPropertiesFiles.push(portalExtPropertiesFile);
	}
	else {
		portalExtPropertiesFile = portalExtPropertiesFiles[0];
	}

	portalExtPropertiesFiles = portalExtPropertiesFiles.concat([
		getPlaywrightBaseDir() + '/env/portal-ext.properties',
		getPlaywrightProjectDir() + '/env/portal-ext.properties'
	]);
	
	const portalProperties = getPropertiesFromFiles(portalExtPropertiesFiles);

	console.log('portalExtPropertiesFile=' + portalExtPropertiesFile);
	console.log(portalProperties);
	console.log('--------------------------------------------------');

	writePropertiesFile(portalExtPropertiesFile, portalProperties);
}

function _deployClientExtension(clientExtension: string) {
	const clientExtensionDirs = glob.sync(getLiferayPortalDir() + '/workspaces/*-workspace/client-extensions/' + clientExtension);

	if (clientExtensionDirs.length == 0) {
		throw new Error("Unable to find client extension " + clientExtension);
	}

	const clientExtensionDir = clientExtensionDirs[0]

	const workspaceDir = _getWorkspaceDir(clientExtensionDir);

	const gradleParameters = [];

	gradleParameters.push({name: 'liferay.workspace.home.dir', value: getLiferayHome()});

	executeGradleTask(workspaceDir, ':client-extensions:' + clientExtension + ':deploy', gradleParameters);
}

function _deployOSGiModule(osgiModule: string) {
	const script = 'find ' + getLiferayPortalDir() + '/modules | grep -v .releng | grep ' + osgiModule + '$';

	let osgiModuleDir = executeBashScript(script);

	osgiModuleDir = osgiModuleDir.trim();

	if (osgiModuleDir === '') {
		throw new Error('Unable to find ' + osgiModule);
	}

	osgiModuleDir = osgiModuleDir.replace(/.+\/modules(\/.+)/, '\$1');

	const modulesDir = getLiferayPortalDir() + '/modules';

	executeGradleTask(modulesDir, osgiModuleDir.replace(/\//g, ':') + ':deploy', []);
}

function _getUserName() {
	return require("os").userInfo().username;
}

function _getWorkspaceDir(clientExtensionDir: string) {
	return clientExtensionDir.replace(/(.+\/workspaces\/[^\/]+-workspace)\/.+/, '\$1');
}