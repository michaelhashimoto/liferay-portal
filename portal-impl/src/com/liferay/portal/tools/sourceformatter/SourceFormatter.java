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

package com.liferay.portal.tools.sourceformatter;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UniqueList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hugo Huijser
 */
public class SourceFormatter {

	public static void main(String[] args) {
		try {
			new SourceFormatter(false, false);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SourceFormatter(
			final boolean useProperties, final boolean throwException)
		throws Exception {

		Thread thread1 = new Thread () {

			@Override
			public void run() {
				try {
					List<SourceProcessor> sourceProcessors =
						new ArrayList<SourceProcessor>();

					sourceProcessors.add(
						FTLSourceProcessor.class.newInstance());
					sourceProcessors.add(
						JavaSourceProcessor.class.newInstance());
					sourceProcessors.add(JSSourceProcessor.class.newInstance());
					sourceProcessors.add(
						PropertiesSourceProcessor.class.newInstance());
					sourceProcessors.add(SHSourceProcessor.class.newInstance());
					sourceProcessors.add(
						SQLSourceProcessor.class.newInstance());
					sourceProcessors.add(
						TLDSourceProcessor.class.newInstance());
					sourceProcessors.add(
						XMLSourceProcessor.class.newInstance());

					for (SourceProcessor sourceProcessor : sourceProcessors) {
						sourceProcessor.format(useProperties, throwException);

						_errorMessages.addAll(
							sourceProcessor.getErrorMessages());
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}

		};

		Thread thread2 = new Thread () {

			@Override
			public void run() {
				try {
					SourceProcessor sourceProcessor =
						JSPSourceProcessor.class.newInstance();

					sourceProcessor.format(useProperties, throwException);

					_errorMessages.addAll(sourceProcessor.getErrorMessages());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}

		};

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		if (throwException && !_errorMessages.isEmpty()) {
			System.out.println(StringUtil.merge(_errorMessages, "\n"));
		}
	}

	private static List<String> _errorMessages = new UniqueList<String>();

}