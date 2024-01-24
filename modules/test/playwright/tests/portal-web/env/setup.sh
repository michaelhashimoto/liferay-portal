#!/bin/bash

set -e -x

source ${PLAYWRIGHT_BASE_DIR}/env/common.sh

echo "This is the 'setup' for the 'portal' playwright project"

update_portal_ext_properties

start_app_server

deploy_project_osgi_modules

deploy_osgi_modules \
	modules/apps/frontend-taglib/frontend-taglib-clay-sample-web

deploy_project_env_deploy_folder

deploy_project_client_extensions

deploy_client_extensions \
	workspaces/liferay-jethr0-workspace/client-extensions/liferay-jethr0-custom-element \
	workspaces/liferay-jethr0-workspace/client-extensions/liferay-jethr0-etc-spring-boot