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

package com.liferay.portal.scheduler.quartz;

import com.liferay.portal.kernel.scheduler.CronTrigger;
import com.liferay.portal.test.LiferayIntegrationJUnitTestRunner;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.quartz.Trigger;

/**
 * @author Brian Wing Shun Chan
 */
@RunWith(LiferayIntegrationJUnitTestRunner.class)
public class QuartzSchedulerEngineTest {

	@Test
	public void testCronTriggerFireTime() throws Exception {
		CronTrigger cronTrigger = new CronTrigger(
			"jobName", "groupName", "0/1 * * * * ?");

		Trigger trigger1 = _quartzSchedulerEngine.getQuartzTrigger(cronTrigger);

		Date nextFireTime1 = trigger1.getFireTimeAfter(trigger1.getStartTime());

		Thread.sleep(1000);

		Trigger trigger2 = _quartzSchedulerEngine.getQuartzTrigger(cronTrigger);

		Date nextFireTime2 = trigger2.getFireTimeAfter(trigger2.getStartTime());

		if (nextFireTime1.equals(nextFireTime2)) {
			Assert.fail();
		}
	}

	private QuartzSchedulerEngine _quartzSchedulerEngine =
		new QuartzSchedulerEngine();

}