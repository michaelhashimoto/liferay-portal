/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {error} from 'node:console';
import {PathOrFileDescriptor, existsSync, readFileSync, writeFile} from 'node:fs'
import {KeyValuePairObject, getProperties} from 'properties-file'

export function getPropertiesFromFile(propertiesFilePath: PathOrFileDescriptor) {
	if ((propertiesFilePath === null) || (propertiesFilePath === undefined) || !existsSync(propertiesFilePath.toString())) {
		return null;
	}

	return getProperties(readFileSync(propertiesFilePath));
}

export function getPropertiesFromFiles(propertiesFilePaths: PathOrFileDescriptor[]) {
	const propertiesArray = [];

	for (const i in propertiesFilePaths) {
		propertiesArray.push(getPropertiesFromFile(propertiesFilePaths[i]));
	}

	return _mergeProperties(propertiesArray);
}

export function getPropertyValue(properties: KeyValuePairObject, propertyName: string) {
	return _getPropertyValue(properties, propertyName, []);
}

export function writePropertiesFile(propertiesFilePath: PathOrFileDescriptor, properties: KeyValuePairObject) {
	let propertiesFileContent = '';

	for (const propertyName in properties) {
		propertiesFileContent += propertyName + '=' + properties[propertyName] + "\n";
	}

	writeFile(propertiesFilePath, propertiesFileContent, (error) => {
		if (error) {
			throw error;
		}
	});

	console.log(propertiesFileContent);
}

function _getPropertyValue(properties: KeyValuePairObject, propertyName: string, previousNames: string[]) {
	if (previousNames.includes(propertyName)) {
		if (previousNames.length > 1) {
			throw new error("Circular property reference chain found");
		}

		return "${" + propertyName + "}";
	}
	
	previousNames.push(propertyName);

	const propertyValue = properties[propertyName];

	if ((propertyValue === null) || (propertyValue === undefined)) {
		return "${" + propertyName + "}";
	}

	const filteredPropertyValue = _removeCommentsFromPropertyValues(propertyValue);

	let replacedValue = filteredPropertyValue;

	const regex = /(\$\{([^\}]+)\})/g;

	let results;

	while ((results = regex.exec(filteredPropertyValue)) !== null) {
		const foundPropertyName = results[2];

		if (properties[foundPropertyName] != null) {
			replacedValue = replacedValue.replace(results[0], _getPropertyValue(properties, foundPropertyName, previousNames));
		}
	}

	return replacedValue;
}

function _mergeProperties(propertiesArray: KeyValuePairObject[]) {
	let properties;

	for (const i in propertiesArray) {
		const propertiesItem = propertiesArray[i];

		if ((propertiesItem == null) || (propertiesItem == undefined)) {
			continue;
		}

		if ((properties === null) || (properties === undefined)) {
			properties = propertiesItem;
		}
		else {
			for (const newPropertyName in propertiesItem) {
				properties[newPropertyName] = propertiesItem[newPropertyName];
			}
		}
	}

	return properties;
}

function _removeCommentsFromPropertyValues(propertyValue: string) {
	if ((propertyValue === null) || (propertyValue === undefined)) {
		return null;
	}

	const propertyValues = [];

	const propertyValueArray = propertyValue.split(",");

	for (const i in propertyValueArray) {
		const propertyValueItem = propertyValueArray[i].trim();

		if ((!propertyValueItem.length) || (propertyValueItem.startsWith("#"))) {
			continue;
		}

		propertyValues.push(propertyValueItem);
	}

	return propertyValues.join(",");
}