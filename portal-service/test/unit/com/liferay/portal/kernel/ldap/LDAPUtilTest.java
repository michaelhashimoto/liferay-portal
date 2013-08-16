/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portal.kernel.ldap;

import com.liferay.portal.kernel.test.TestCase;

import org.junit.Test;

/**
 * @author James Lefeu
 */
public class LDAPUtilTest extends TestCase {

	@Test
	public void testIsValidFilterBalancedParentheses() {
		assertTrue(isValidFilter("(object=value)"));
		assertTrue(isValidFilter("((((object=value))))"));
		assertTrue(isValidFilter("((((object=value))(org=liferay)))"));
		assertTrue(
			isValidFilter(
				"(((inetorg=www)((object=value))(org=liferay)))(user=test)"));
		assertFalse(isValidFilter("(object=value))"));
		assertFalse(isValidFilter("(((object=value))"));
		assertFalse(isValidFilter("((((object=value)))(org=liferay)))"));
		assertFalse(
			isValidFilter(
				"(((inetorg=www)((object=value))(org=liferay)))(user=test))"));
	}

	@Test
	public void testIsValidFilterNoFilterType() {
		assertTrue(isValidFilter("(object=value)"));
		assertFalse(isValidFilter("(object)"));
		assertFalse(isValidFilter("(object)(value)"));
		assertFalse(isValidFilter("(!object)"));
	}

	@Test
	public void testIsValidFilterOpenAndCloseParentheses() {
		assertTrue(isValidFilter("(object=value)"));
		assertTrue(isValidFilter("  (object=value)"));
		assertTrue(isValidFilter("(object=value)  "));
		assertFalse(isValidFilter("object=value)"));
		assertFalse(isValidFilter("(object=value"));
		assertFalse(isValidFilter("object=value"));
		assertFalse(isValidFilter("("));
		assertFalse(isValidFilter(")"));
		assertFalse(isValidFilter(")("));
	}

	@Test
	public void testIsValidFilterSpecialChars() {
		assertTrue(isValidFilter(""));
		assertTrue(isValidFilter("*"));
		assertTrue(isValidFilter("  *   "));
	}

	@Test
	public void testIsValidFilterTypeAfterOpenParenthesis() {
		assertTrue(isValidFilter("(object=value)"));
		assertFalse(isValidFilter("(=value)"));
		assertFalse(isValidFilter("(<=value)"));
		assertFalse(isValidFilter("(>=value)"));
		assertFalse(isValidFilter("(~=value)"));
		assertFalse(isValidFilter("(~=value)(object=value)"));
	}

	@Test
	public void testIsValidFilterTypeBeforeCloseParenthesis() {
		assertTrue(isValidFilter("(object=value)"));
		assertTrue(isValidFilter("(object=*)"));
		assertTrue(isValidFilter("(object=subobject=*)"));
		assertFalse(isValidFilter("(object=)"));
		assertFalse(isValidFilter("(object<=)"));
		assertFalse(isValidFilter("(object>=)"));
		assertFalse(isValidFilter("(object~=)"));
		assertFalse(isValidFilter("(object=subobject=)"));
		assertFalse(isValidFilter("(org=liferay)(object=subobject=)"));
	}

	@Test
	public void testIsValidFilterTypesInSequence() {
		assertTrue(isValidFilter("(object=value)"));
		assertTrue(isValidFilter("(object=value=subvalue)"));
		assertTrue(isValidFilter("(object<=value)"));
		assertTrue(isValidFilter("(object<=value<=subvalue)"));
		assertTrue(isValidFilter("(object>=value)"));
		assertTrue(isValidFilter("(object>=value>=subvalue)"));
		assertTrue(isValidFilter("(object~=value)"));
		assertTrue(isValidFilter("(object~=value~=subvalue)"));
		assertTrue(isValidFilter("(object~=value>=subvalue<=subsubvalue)"));
		assertFalse(isValidFilter("(object==value)"));
		assertFalse(isValidFilter("(object=value=<=subvalue)"));
		assertFalse(isValidFilter("(object~==value)"));
		assertFalse(isValidFilter("(object=value=>=subvalue)"));
		assertFalse(isValidFilter("(object~=value>==subvalue<=subsubvalue)"));
	}

	protected boolean isValidFilter(String filter) {
		return LDAPUtil.isValidFilter(filter);
	}

}