/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

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
	let gitRepositoryPath = executeBashScript(`
		function git_repository_path {
			if [[ -e ./.git ]]
			then
				echo $(pwd);
			elif [[ $(pwd) == / ]]
			then
				echo "Could not find a base git dir"
				exit 1;
			else
				echo $(cd .. ; git_repository_path);
			fi
		}

		git_repository_path
	`);

	return gitRepositoryPath.trim();
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

function _getGitRepositoryProperties(propertiesFileName: string) {
	let propertiesFiles = [];

	const gitRepositoryPath = getBasePortalDir();

	propertiesFiles.push(gitRepositoryPath + '/' + propertiesFileName);

	const regex = /([^/\.]+)\.properties/;

	let results = regex.exec(propertiesFileName);

	if (results !== null) {
		propertiesFiles.push(gitRepositoryPath + '/' + results[1] + '.' + process.env.HOSTNAME + '.properties');
		propertiesFiles.push(gitRepositoryPath + '/' + results[1] + '.' + process.env.HOST + '.properties');
		propertiesFiles.push(gitRepositoryPath + '/' + results[1] + '.' + process.env.COMPUTERNAME + '.properties');
		propertiesFiles.push(gitRepositoryPath + '/' + results[1] + '.' + _getUserName() + '.properties');
	}

	return getPropertiesFromFiles(propertiesFiles);
}

function _getUserName() {
	return require("os").userInfo().username;
}