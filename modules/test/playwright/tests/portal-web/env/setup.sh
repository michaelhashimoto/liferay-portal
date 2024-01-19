#!/bin/bash

set -e -x

if [ -L $0 ]
then
	CURRENT_FILE_NAME=$(readlink $0)
else
	CURRENT_FILE_NAME=$0
fi

CURRENT_DIR_NAME=$(dirname ${CURRENT_FILE_NAME})

source ${CURRENT_DIR_NAME}/../../../env/common.sh

copy_to_deploy_folder ${CURRENT_DIR_NAME}/deploy

deploy_osgi_modules \
	modules/test/poshi/poshi-core \
	modules/test/poshi/poshi-runner

deploy_client_extensions \
	workspaces/liferay-jethr0-workspace/client-extensions/liferay-jethr0-batch-0 \
	workspaces/liferay-jethr0-workspace/client-extensions/liferay-jethr0-batch-1 \
	workspaces/liferay-jethr0-workspace/client-extensions/liferay-jethr0-etc-spring-boot-application \
	workspaces/liferay-jethr0-workspace/client-extensions/liferay-jethr0-custom-element

start_app_server