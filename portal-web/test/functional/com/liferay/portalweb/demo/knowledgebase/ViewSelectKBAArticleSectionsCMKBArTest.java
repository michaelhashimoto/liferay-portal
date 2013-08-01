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
public class ViewSelectKBAArticleSectionsCMKBArTest extends BaseTestCase {
	public void testViewSelectKBAArticleSectionsCMKBAr()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Knowledge Base Article Test Page");
		selenium.clickAt("link=Knowledge Base Article Test Page",
			RuntimeVariables.replace("Knowledge Base Article Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Knowledge Base Article 1"),
			selenium.getText("//div[@class='kb-title']"));
		assertEquals(RuntimeVariables.replace(
				"This is the content of Article 1"),
			selenium.getText("//div[@class='kb-entity-body']/p"));
	}
}