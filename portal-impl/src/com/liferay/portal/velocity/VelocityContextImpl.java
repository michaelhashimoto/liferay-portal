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

package com.liferay.portal.velocity;

import com.liferay.portal.kernel.velocity.VelocityContext;

/**
 * @author Raymond Augé
 */
public class VelocityContextImpl implements VelocityContext {

	public VelocityContextImpl() {
		_velocityContext = new org.apache.velocity.VelocityContext();
	}

	public VelocityContextImpl(
		org.apache.velocity.VelocityContext velocityContext) {

		_velocityContext = new org.apache.velocity.VelocityContext(
			velocityContext);
	}

	public VelocityContextImpl(VelocityContextImpl velocityContextImpl) {
		_velocityContext = new org.apache.velocity.VelocityContext(
			velocityContextImpl.getWrappedVelocityContext());
	}

	@Override
	public Object get(String key) {
		return _velocityContext.get(key);
	}

	public org.apache.velocity.VelocityContext getWrappedVelocityContext() {
		return _velocityContext;
	}

	@Override
	public void put(String key, Object value) {
		_velocityContext.put(key, value);
	}

	private org.apache.velocity.VelocityContext _velocityContext;

}