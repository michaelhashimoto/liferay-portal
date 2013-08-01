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

package com.liferay.portal.util;

import com.liferay.portal.kernel.security.pacl.DoPrivileged;
import com.liferay.portal.kernel.util.CalendarFactory;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Brian Wing Shun Chan
 */
@DoPrivileged
public class CalendarFactoryImpl implements CalendarFactory {

	@Override
	public Calendar getCalendar() {
		return new GregorianCalendar();
	}

	@Override
	public Calendar getCalendar(int year, int month, int date) {
		return new GregorianCalendar(year, month, date);
	}

	@Override
	public Calendar getCalendar(
		int year, int month, int date, int hour, int minute) {

		return new GregorianCalendar(year, month, date, hour, minute);
	}

	@Override
	public Calendar getCalendar(
		int year, int month, int date, int hour, int minute, int second) {

		return new GregorianCalendar(year, month, date, hour, minute, second);
	}

	@Override
	public Calendar getCalendar(Locale locale) {
		return new GregorianCalendar(locale);
	}

	@Override
	public Calendar getCalendar(TimeZone timeZone) {
		return new GregorianCalendar(timeZone);
	}

	@Override
	public Calendar getCalendar(TimeZone timeZone, Locale locale) {
		return new GregorianCalendar(timeZone, locale);
	}

}