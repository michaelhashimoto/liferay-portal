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

package com.liferay.portalweb.demo.knowledgebase;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewKBAArticleSectionsPortletsTest extends BaseTestCase {
	public void testViewKBAArticleSectionsPortlets() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Knowledge Base Display Test Page");
		selenium.clickAt("link=Knowledge Base Display Test Page",
			RuntimeVariables.replace("Knowledge Base Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("KB Admin Article"),
			selenium.getText("//tr[3]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//tr[3]/td[3]/a"));
		assertTrue(selenium.isVisible("//tr[3]/td[4]/a"));
		assertTrue(selenium.isVisible("//tr[3]/td[5]/a"));
		assertEquals(RuntimeVariables.replace("0 (Approved)"),
			selenium.getText("//tr[3]/td[6]/a"));
		assertTrue(selenium.isVisible("//tr[3]/td[7]/a"));
		selenium.clickAt("//tr[3]/td[2]/a",
			RuntimeVariables.replace("KB Admin Article"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("KB Admin Article"),
			selenium.getText("//div[@class='kb-title']"));
		assertEquals(RuntimeVariables.replace(
				"This is an article created from the KB Admin"),
			selenium.getText("//div[@class='kb-entity-body']/p"));
	}
}