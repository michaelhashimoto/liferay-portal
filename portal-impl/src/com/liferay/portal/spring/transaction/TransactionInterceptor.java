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

package com.liferay.portal.spring.transaction;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.support.CallbackPreferringPlatformTransactionManager;

/**
 * @author Shuyang Zhou
 */
public class TransactionInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Method method = methodInvocation.getMethod();

		Class<?> targetClass = null;

		Object targetBean = methodInvocation.getThis();

		if (targetBean != null) {
			targetClass = targetBean.getClass();
		}

		TransactionAttribute transactionAttribute =
			transactionAttributeSource.getTransactionAttribute(
				method, targetClass);

		if (transactionAttribute == null) {
			return methodInvocation.proceed();
		}

		return transactionExecutor.execute(
			platformTransactionManager, transactionAttribute, methodInvocation);
	}

	public void setPlatformTransactionManager(
		PlatformTransactionManager platformTransactionManager) {

		if (platformTransactionManager instanceof
				CallbackPreferringPlatformTransactionManager) {

			transactionExecutor = new CallbackPreferringTransactionExecutor();
		}
		else {
			transactionExecutor = new DefaultTransactionExecutor();
		}

		this.platformTransactionManager = platformTransactionManager;
	}

	public void setTransactionAttributeSource(
		TransactionAttributeSource transactionAttributeSource) {

		this.transactionAttributeSource = transactionAttributeSource;
	}

	/**
	 * @deprecated {@link
	 *             #setPlatformTransactionManager(PlatformTransactionManager)}
	 */
	public void setTransactionManager(
		PlatformTransactionManager platformTransactionManager) {

		setPlatformTransactionManager(platformTransactionManager);
	}

	protected PlatformTransactionManager platformTransactionManager;
	protected TransactionAttributeSource transactionAttributeSource;
	protected TransactionExecutor transactionExecutor;

}