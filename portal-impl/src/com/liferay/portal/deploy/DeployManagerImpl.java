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

package com.liferay.portal.deploy;

import com.liferay.portal.events.GlobalStartupAction;
import com.liferay.portal.kernel.deploy.DeployManager;
import com.liferay.portal.kernel.deploy.auto.AutoDeployDir;
import com.liferay.portal.kernel.deploy.auto.context.AutoDeploymentContext;
import com.liferay.portal.kernel.plugin.PluginPackage;
import com.liferay.portal.kernel.security.pacl.DoPrivileged;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.plugin.PluginPackageUtil;

import java.io.File;

import java.util.List;
import java.util.Properties;

/**
 * @author Jonathan Potter
 * @author Brian Wing Shun Chan
 * @author Ryan Park
 */
@DoPrivileged
public class DeployManagerImpl implements DeployManager {

	@Override
	public void deploy(AutoDeploymentContext autoDeploymentContext)
		throws Exception {

		AutoDeployDir.deploy(
			autoDeploymentContext,
			GlobalStartupAction.getAutoDeployListeners(false));
	}

	@Override
	public String getDeployDir() throws Exception {
		return DeployUtil.getAutoDeployDestDir();
	}

	@Override
	public String getInstalledDir() throws Exception {
		if (ServerDetector.isGlassfish()) {
			File file = new File(
				System.getProperty("com.sun.aas.instanceRoot"), "autodeploy");

			return file.getAbsolutePath();
		}

		return DeployUtil.getAutoDeployDestDir();
	}

	@Override
	public PluginPackage getInstalledPluginPackage(String context) {
		return PluginPackageUtil.getInstalledPluginPackage(context);
	}

	@Override
	public List<PluginPackage> getInstalledPluginPackages() {
		return PluginPackageUtil.getInstalledPluginPackages();
	}

	@Override
	public boolean isDeployed(String context) {
		return PluginPackageUtil.isInstalled(context);
	}

	@Override
	public PluginPackage readPluginPackageProperties(
		String displayName, Properties properties) {

		return PluginPackageUtil.readPluginPackageProperties(
			displayName, properties);
	}

	@Override
	public PluginPackage readPluginPackageXml(String xml) throws Exception {
		return PluginPackageUtil.readPluginPackageXml(xml);
	}

	@Override
	public void redeploy(String context) throws Exception {
		if (ServerDetector.isJetty()) {
			DeployUtil.redeployJetty(context);
		}
		else if (ServerDetector.isTomcat()) {
			DeployUtil.redeployTomcat(context);
		}
	}

	@Override
	public void undeploy(String context) throws Exception {
		File deployDir = new File(getDeployDir(), context);

		DeployUtil.undeploy(ServerDetector.getServerId(), deployDir);
	}

}