/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

const fs = require('fs');
const path = require('path');
const {stripVTControlCharacters} = require('util');

const PROJECT_DIR = process.cwd();

const SKIPPED_STATUSES = ['pending', 'todo'];

const XML_CHARACTER_MAP = {
	'"': '&quot;',
	'&': '&amp;',
	"'": '&apos;',
	'<': '&lt;',
	'>': '&gt;',
};

function countFailures(testCases) {
	const failedTestCases = testCases.filter(
		(testCase) =>
			testCase.failureMessages && testCase.failureMessages.length
	);

	return failedTestCases.length;
}

function countSkipped(testCases) {
	const skippedTestCases = testCases.filter(isSkipped);

	return skippedTestCases.length;
}

function escapeXML(value) {
	return String(value).replace(
		/["&'<>]/g,
		(character) => XML_CHARACTER_MAP[character]
	);
}

function formatAttributes(attributes) {
	return Object.entries(attributes)
		.map(([name, value]) => ` ${name}="${escapeXML(value)}"`)
		.join('');
}

function formatDuration(startTime) {
	if (!startTime) {
		return 0;
	}

	return (Date.now() - startTime) / 1000;
}

function formatFailureMessages(testCase) {
	return testCase.failureMessages.map((failureMessage) =>
		stripVTControlCharacters(failureMessage)
			.split(PROJECT_DIR + path.sep)
			.join('')
	);
}

function formatTestCase(testCase) {
	const attributes = formatAttributes({
		classname: formatTestFilePath(testCase.testFilePath),
		name: formatTestName(testCase),
		time: testCase.duration / 1000,
	});

	const children = [];

	if (isSkipped(testCase)) {
		children.push('\t\t<skipped/>');
	}

	if (testCase.failureMessages && testCase.failureMessages.length) {
		const failureMessages = formatFailureMessages(testCase);

		const failureAttributes = formatAttributes({
			message: failureMessages[0].split('\n')[0],
		});

		children.push(
			`\t\t<failure${failureAttributes}>${escapeXML(
				failureMessages.join('\n')
			)}</failure>`
		);
	}

	if (!children.length) {
		return [`\t<testcase${attributes}/>`];
	}

	return [`\t<testcase${attributes}>`, ...children, '\t</testcase>'];
}

function formatTestFilePath(testFilePath) {
	const relativePath = path.relative(PROJECT_DIR, testFilePath);

	return relativePath.split(path.sep).join('/');
}

function formatTestName(testCase) {
	const {ancestorTitles, title} = testCase;

	if (!ancestorTitles || !title) {
		return testCase.fullName;
	}

	return [...ancestorTitles, title].join(' > ');
}

function getTestCases(testReport) {
	return testReport.testResults.reduce((testCases, testSuite) => {
		if (testSuite.testResults.length) {
			testCases.push(
				...testSuite.testResults.map((testResult) => ({
					...testResult,
					testFilePath: testSuite.testFilePath,
				}))
			);
		}
		else if (testSuite.failureMessage) {
			testCases.push({
				duration: 0,
				failureMessages: [testSuite.failureMessage],
				fullName: testSuite.testFilePath,
				testFilePath: testSuite.testFilePath,
			});
		}

		return testCases;
	}, []);
}

function isSkipped(testCase) {
	return SKIPPED_STATUSES.includes(testCase.status);
}

module.exports = (testReport) => {
	const testCases = getTestCases(testReport);

	const testSuiteAttributes = formatAttributes({
		errors: 0,
		failures: countFailures(testCases),
		hostname: '',
		id: 0,
		name: 'Jest',
		package: PROJECT_DIR,
		skipped: countSkipped(testCases),
		tests: testCases.length,
		time: formatDuration(testReport.startTime),
		timestamp: testReport.startTime,
	});

	const lines = [
		'<?xml version="1.0" encoding="UTF-8"?>',
		`<testsuite${testSuiteAttributes}>`,
		...testCases.flatMap(formatTestCase),
		'</testsuite>',
	];

	fs.writeFileSync('TEST-frontend-js.xml', lines.join('\n'));

	return testReport;
};
