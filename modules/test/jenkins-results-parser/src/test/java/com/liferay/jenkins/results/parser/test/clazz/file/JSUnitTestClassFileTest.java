/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.file;

import com.liferay.jenkins.results.parser.RandomTestUtil;
import com.liferay.jenkins.results.parser.ReflectionTestUtil;

import java.io.File;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Hashimoto
 */
public class JSUnitTestClassFileTest
	extends com.liferay.jenkins.results.parser.Test {

	@Test
	public void testGetFullName() throws Exception {
		TestClassFileMethod testClassFileMethod = _getTestClassFileMethod(
			_getTestClassFile(
				"describe('a', () => {describe('b', () => {" +
					"it('c > d', () => {});});});"));

		testEquals("a > b > c > d", testClassFileMethod.getFullName());
		testEquals("a b c > d", testClassFileMethod.getFullName(" "));
	}

	@Test
	public void testGetRelativePath() throws Exception {
		TestClassFile testClassFile = _getTestClassFile("it('a', () => {});");

		File file = testClassFile.getFile();

		testEquals(
			file.getName(),
			testClassFile.getRelativePath(file.getParentFile()));
	}

	@Test
	public void testGetTestClassFile() throws Exception {
		TestClassFile testClassFile = _getTestClassFile("it('a', () => {});");

		TestClassFileMethod testClassFileMethod = _getTestClassFileMethod(
			testClassFile);

		testSame(testClassFile, testClassFileMethod.getTestClassFile());
	}

	@Test
	public void testGetTestClassFileMethods() throws Exception {
		_testGetTestClassFileMethods("", new String[0]);
		_testGetTestClassFileMethods(
			"const a = /alert\\((.*?)\\)/;const b = /'|\"/g;it('c', () => {});",
			"c");
		_testGetTestClassFileMethods(
			"describe('a', () => {describe('b', () => {it('c', () => {});});" +
				"});",
			"a > b > c");
		_testGetTestClassFileMethods(
			"describe('a', () => {it('b', () => {});it('c', () => {});});",
			"a > b", "a > c");
		_testGetTestClassFileMethods(
			"describe('a', ({b}) => {it('c', () => {});});", "a > c");
		_testGetTestClassFileMethods(
			"describe.each([['a'], ['b']])('%s', (c) => {" +
				"it(`${c} d`, () => {});});",
			"a > a d", "b > b d");
		_testGetTestClassFileMethods("it('a ' + 'b' + \n'c', () => {});", "a bc");
		_testGetTestClassFileMethods(
			"it('a', () => {render(<b c={{d: 1}} />);render(<e>f</e>);});",
			"a");
		_testGetTestClassFileMethods("it(`a ${b} c`, () => {});", "a ${b} c");
		_testGetTestClassFileMethods("it(`a`, () => {});", "a");
		_testGetTestClassFileMethods("it(a, () => {});", "${a}");
		_testGetTestClassFileMethods(
			"it.each(['a', 'b'])('c %s', () => {});", "c a", "c b");
		_testGetTestClassFileMethods("it.each(['a'])('b %p', () => {});", "b %p");
		_testGetTestClassFileMethods("it.each([a.b])('c %s', () => {});", "c %s");
		_testGetTestClassFileMethods("it.each(a)('b %s', () => {});", "b %s");
		_testGetTestClassFileMethods(
			"test.each(['a'])('%# %% b %s', () => {});", "0 % b a");
		_testGetTestClassFileMethods(
			"test.each([['a', 'b'], ['c', 'd']])('e %s %s', () => {});",
			"e a b", "e c d");
	}

	@Test
	public void testGetTestClassFileMethodsComments() throws Exception {
		_testGetTestClassFileMethods(
			"/* describe('a', () => {}); */ it('b', () => {});", "b");
		_testGetTestClassFileMethods("// it('a', () => {});\nit('b', () => {});", "b");
		_testGetTestClassFileMethods(
			"describe('a', () => {// comment\nit('b', () => {});});", "a > b");
	}

	@Test
	public void testGetTestClassFileMethodsDeclarationWords() throws Exception {
		String[] describeWords = ReflectionTestUtil.getFieldValue(
			JSUnitTestClassFile.class, "_DESCRIBE_WORDS");

		for (String describeWord : describeWords) {
			_testGetTestClassFileMethods(
				describeWord + "('a', () => {it('b', () => {});});", "a > b");
		}

		String[] testWords = ReflectionTestUtil.getFieldValue(
			JSUnitTestClassFile.class, "_TEST_WORDS");

		for (String testWord : testWords) {
			_testGetTestClassFileMethods(testWord + "('a', () => {});", "a");
		}
	}

	@Test
	public void testGetTestClassFileMethodsEscapes() throws Exception {
		_testGetTestClassFileMethods("it('a\\'b', () => {});", "a'b");
		_testGetTestClassFileMethods("it('a\\nb', () => {});", "a\nb");
		_testGetTestClassFileMethods("it(\"a\\\"b\", () => {});", "a\"b");
	}

	@Test
	public void testGetTestClassFileMethodsExpressionTitles() throws Exception {
		_testGetTestClassFileMethods("it(() => {}, () => {});", new String[0]);
		_testGetTestClassFileMethods("it(a('b, c'), () => {});", "${a('b, c')}");
		_testGetTestClassFileMethods("it(a.b, () => {});", "${a.b}");
		_testGetTestClassFileMethods("it(a[0], () => {});", "${a[0]}");
	}

	@Test
	public void testIsDynamic() throws Exception {
		_testIsDynamic("it('a', () => {});", false);
		_testIsDynamic("it(`a ${b}`, () => {});", true);
		_testIsDynamic("it(`a`, () => {});", false);
		_testIsDynamic("it(a, () => {});", true);
		_testIsDynamic("it.each(['a'])('b %p', () => {});", true);
		_testIsDynamic("it.each(['a'])('b %s', () => {});", false);
		_testIsDynamic("it.each([a.b])('c %s', () => {});", true);
	}

	@Test
	public void testMatches() throws Exception {
		TestClassFileMethod testClassFileMethod = _getTestClassFileMethod(
			_getTestClassFile("describe('a', () => {it('b', () => {});});"));

		Assert.assertFalse(testClassFileMethod.matches("a-b"));
		Assert.assertFalse(
			testClassFileMethod.matches(RandomTestUtil.randomString()));
		Assert.assertFalse(testClassFileMethod.matches(null));
		Assert.assertTrue(testClassFileMethod.matches("a > b"));
		Assert.assertTrue(testClassFileMethod.matches("a b"));
	}

	@Test
	public void testMatchesPattern() throws Exception {
		TestClassFile testClassFile = _getTestClassFile(
			"describe('a', () => {it(`b ${c} d`, () => {});" +
				"it('e', () => {});});");

		List<TestClassFileMethod> testClassFileMethods =
			testClassFile.getTestClassFileMethods();

		TestClassFileMethod dynamicTestClassFileMethod =
			testClassFileMethods.get(0);

		Assert.assertFalse(dynamicTestClassFileMethod.matchesPattern("a > b"));
		Assert.assertFalse(dynamicTestClassFileMethod.matchesPattern(null));
		Assert.assertTrue(
			dynamicTestClassFileMethod.matchesPattern("a > b anything d"));
		Assert.assertTrue(
			dynamicTestClassFileMethod.matchesPattern("a b anything d"));

		TestClassFileMethod testClassFileMethod = testClassFileMethods.get(1);

		Assert.assertFalse(
			testClassFileMethod.matchesPattern(RandomTestUtil.randomString()));
		Assert.assertTrue(testClassFileMethod.matchesPattern("a > e"));
	}

	@Test
	public void testNewTestClassFile() throws Exception {
		File file = File.createTempFile(RandomTestUtil.randomString(), ".txt");

		try {
			Assert.assertNull(TestClassFileFactory.newTestClassFile(file));
			Assert.assertNull(
				TestClassFileFactory.newTestClassFile(file.getParentFile()));
		}
		finally {
			file.delete();
		}
	}

	private TestClassFile _getTestClassFile(String content) throws Exception {
		File file = File.createTempFile(
			RandomTestUtil.randomString(), ".spec.tsx");

		try {
			Files.write(
				file.toPath(), content.getBytes(StandardCharsets.UTF_8));

			return TestClassFileFactory.newTestClassFile(file);
		}
		finally {
			file.delete();
		}
	}

	private TestClassFileMethod _getTestClassFileMethod(
		TestClassFile testClassFile) {

		List<TestClassFileMethod> testClassFileMethods =
			testClassFile.getTestClassFileMethods();

		return testClassFileMethods.get(0);
	}

	private void _testGetTestClassFileMethods(
			String content, String... expectedFullNames)
		throws Exception {

		List<String> fullNames = new ArrayList<>();

		TestClassFile testClassFile = _getTestClassFile(content);

		for (TestClassFileMethod testClassFileMethod :
				testClassFile.getTestClassFileMethods()) {

			fullNames.add(testClassFileMethod.getFullName());
		}

		testEquals(Arrays.asList(expectedFullNames), fullNames);
	}

	private void _testIsDynamic(String content, boolean expectedDynamic)
		throws Exception {

		TestClassFileMethod testClassFileMethod = _getTestClassFileMethod(
			_getTestClassFile(content));

		testEquals(expectedDynamic, testClassFileMethod.isDynamic());
	}

}