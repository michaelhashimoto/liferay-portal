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

package com.liferay.portalweb.portlet.unitconverter.unit.convertunit;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConvertUnitTest extends BaseTestCase {
	public void testConvertUnit() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Unit Converter Test Page",
			RuntimeVariables.replace("Unit Converter Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='_27_fromValue']",
			RuntimeVariables.replace("1.0"));
		selenium.select("//select[@name='_27_fromId']",
			RuntimeVariables.replace("Inch"));
		selenium.select("//select[@name='_27_toId']",
			RuntimeVariables.replace("Centimeter"));
		selenium.select("//select[@name='_27_type']",
			RuntimeVariables.replace("Length"));
		selenium.clickAt("//input[@value='Convert']",
			RuntimeVariables.replace("Convert"));
		selenium.waitForValue("//input[@name='_27_to_value']",
			"2.5399999187200026");
		assertEquals("2.5399999187200026",
			selenium.getValue("//input[@name='_27_to_value']"));
	}
}