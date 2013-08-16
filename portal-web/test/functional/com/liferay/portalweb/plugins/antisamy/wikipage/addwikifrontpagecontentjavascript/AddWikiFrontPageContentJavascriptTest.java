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

package com.liferay.portalweb.plugins.antisamy.wikipage.addwikifrontpagecontentjavascript;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWikiFrontPageContentJavascriptTest extends BaseTestCase {
	public void testAddWikiFrontPageContentJavascript()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Wiki Test Page");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"This page is empty. Edit it to add some text."),
			selenium.getText("//div[@class='wiki-body']/div/a"));
		selenium.clickAt("//div[@class='wiki-body']/div/a",
			RuntimeVariables.replace(
				"This page is empty. Edit it to add some text."));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertTrue(selenium.isVisible("//select[@id='_36_format']"));
		selenium.select("//select[@id='_36_format']",
			RuntimeVariables.replace("HTML"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForConfirmation(
			"You may lose some formatting when switching from Creole to HTML. Do you want to continue?");
		selenium.waitForVisible("//span[@id='cke_46_label']");
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//span[@id='cke_46_label']"));
		selenium.clickAt("//span[@id='cke_46_label']",
			RuntimeVariables.replace("Source"));
		selenium.waitForVisible(
			"//textarea[@class='cke_source cke_enable_context_menu']");
		selenium.type("//textarea[@class='cke_source cke_enable_context_menu']",
			RuntimeVariables.replace(
				"<p id=\"demo\">PASS</p><script type=\"text/javascript\">document.getElementById('demo').innerHTML=\"FAIL\";</script>"));
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("PASS"),
			selenium.getText("//div[@class='wiki-body']/p[@id='demo']"));
	}
}