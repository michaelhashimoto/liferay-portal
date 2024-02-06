/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {startAppServer, waitForStartedAppServer} from './appServerUtil.env';
import {deployParentProjectClientExtensions, deployParentProjectDeployDir, deployParentProjectOSGiModules, deployProjectClientExtensions, deployProjectDeployDir, deployProjectOSGiModules, updatePortalExtProperties} from './common.env';

deployParentProjectClientExtensions();

deployParentProjectDeployDir()

deployParentProjectOSGiModules();

deployProjectClientExtensions();

deployProjectDeployDir();

deployProjectOSGiModules();

updatePortalExtProperties();

startAppServer();

waitForStartedAppServer();