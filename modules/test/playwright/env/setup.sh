#!/bin/bash

set -e -x

if [ -L $0 ]
then
	CURRENT_FILE_NAME=$(readlink $0)
else
	CURRENT_FILE_NAME=$0
fi

CURRENT_DIR_NAME=$(dirname ${CURRENT_FILE_NAME})

source ${CURRENT_DIR_NAME}/common.sh

deploy_project_osgi_modules

update_portal_ext_properties ${CURRENT_DIR_NAME}/portal-ext.properties

start_app_server

deploy_project_client_extensions