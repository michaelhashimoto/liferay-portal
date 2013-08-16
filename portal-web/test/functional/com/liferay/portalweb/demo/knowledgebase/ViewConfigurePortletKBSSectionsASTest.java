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
public class ViewConfigurePortletKBSSectionsASTest extends BaseTestCase {
	public void testViewConfigurePortletKBSSectionsAS()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Knowledge Base Section Test Page");
		selenium.clickAt("link=Knowledge Base Section Test Page",
			RuntimeVariables.replace("Knowledge Base Section Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Application Server"),
			selenium.getText("//div[@class='kb-articles-sections-title']"));
		assertEquals(RuntimeVariables.replace("The third"),
			selenium.getText("//div[@class='kb-articles']/div/span/a/span"));
		selenium.clickAt("//div[@class='kb-articles']/div/span/a/span",
			RuntimeVariables.replace("The third"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("The third"),
			selenium.getText("//div[@class='kb-title']"));
		assertEquals(RuntimeVariables.replace(
				"Number three detailing the specifics of Tomcat and Jboss"),
			selenium.getText("//div[@class='kb-entity-body']/p"));
	}
}