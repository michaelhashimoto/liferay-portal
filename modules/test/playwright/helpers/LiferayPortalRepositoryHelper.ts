/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {error} from 'node:console';
import {existsSync} from 'node:fs'

import {executeBashScript} from './BashScriptHelper'
import {getPropertiesFromFiles, mergeProperties} from './PropertiesHelper';

export function getAllProperties() {
	return mergeProperties([
		getBuildProperties(),

		getAppServerProperties(),

		getReleaseProperties(),

		getTestProperties(),
	]);
}

export function getAppServerProperties() {
	return _getGitRepositoryProperties('app.server.properties');
}

export function getBasePortalDir() {
	return _getBasePortalDir(process.cwd());
}

export function getBuildProperties() {
	let buildProperties = _getGitRepositoryProperties('build.properties');

	buildProperties['project.dir'] = getBasePortalDir();
	buildProperties['sdk.dir'] = '${project.dir}/tools/sdk';

	return buildProperties;
}

export function getReleaseProperties() {
	return _getGitRepositoryProperties('release.properties');
}

export function getTestProperties() {
	return _getGitRepositoryProperties('test.properties');
}

export function _getBasePortalDir(dir: string) {
	let gitDir = dir + "/.git";

	if (existsSync(gitDir)) {
		return dir;
	}

	const regex = /(\/.+)\/[^\/]+/;

	let results = regex.exec(dir);

	if (results === null) {
		error('Could not find a base git dir');
	}

	return _getBasePortalDir(results[1]);
}

function _getGitRepositoryProperties(propertiesFileName: string) {
	let propertiesFiles = [];

	const gitRepositoryPath = getBasePortalDir();

	propertiesFiles.push(gitRepositoryPath + '/' + propertiesFileName);

	const regex = /([^/\.]+)\.properties/;

	let results = regex.exec(propertiesFileName);

	if (results !== null) {
		const fileNamePrefix = results[1];

		propertiesFiles.push(gitRepositoryPath + '/' + fileNamePrefix + '.' + process.env.HOSTNAME + '.properties');
		propertiesFiles.push(gitRepositoryPath + '/' + fileNamePrefix + '.' + process.env.HOST + '.properties');
		propertiesFiles.push(gitRepositoryPath + '/' + fileNamePrefix + '.' + process.env.COMPUTERNAME + '.properties');
		propertiesFiles.push(gitRepositoryPath + '/' + fileNamePrefix + '.' + _getUserName() + '.properties');
	}

	return getPropertiesFromFiles(propertiesFiles);
}

function _getUserName() {
	return require("os").userInfo().username;
}