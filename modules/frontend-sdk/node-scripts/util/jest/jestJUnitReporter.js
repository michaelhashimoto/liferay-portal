/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

const fs = require('fs');
const path = require('path');
const stripAnsi = require('strip-ansi');
const xml = require('xml');

const PROJECT_DIR = process.cwd();

const SKIPPED_STATUSES = ['pending', 'todo'];

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

function formatDuration(startTime) {
	if (!startTime) {
		return 0;
	}

	return (Date.now() - startTime) / 1000;
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

	const testResults = testCases.map((testCase) => {
		const testResults = [
			{
				_attr: {
					classname: formatTestFilePath(testCase.testFilePath),
					name: formatTestName(testCase),
					time: testCase.duration / 1000,
				},
			},
		];

		if (isSkipped(testCase)) {
			testResults.push({skipped: null});
		}

		if (testCase.failureMessages && testCase.failureMessages.length) {
			const failureMessageArray = testCase.failureMessages.map(
				(failureMessage) =>
					failureMessage.split('\n').map((message) =>
						stripAnsi(message)
							.split(PROJECT_DIR + path.sep)
							.join('')
					)
			);

			testResults.push({
				failure: [
					{
						_attr: {
							message: failureMessageArray[0][0],
						},
					},
					failureMessageArray
						.map((failureMessage) => failureMessage.join('\n'))
						.join('\n'),
				],
			});
		}

		return {
			testcase: testResults,
		};
	});

	const testSuiteAttributes = {
		_attr: {
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
		},
	};

	fs.writeFileSync(
		'TEST-frontend-js.xml',
		xml(
			{testsuite: [testSuiteAttributes, ...testResults]},
			{declaration: true, indent: '  '}
		)
	);

	return testReport;
};
