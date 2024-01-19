#!/bin/bash

set -e -x

if [[ "${LIFERAY_HOME}" == "" ]]
then
	echo "Please set 'LIFERAY_HOME'"

    exit 1
fi

if [[ "${PORTAL_REPOSITORY_DIR}" == "" ]]
then
	echo "Please set 'PORTAL_REPOSITORY_DIR'"

    exit 1
fi

function copy_to_deploy_folder() {
	mkdir -p ${LIFERAY_HOME}/deploy

	cp -r $1/ ${LIFERAY_HOME}/deploy
}

function deploy_client_extensions() {
	mkdir -p ${LIFERAY_HOME}/deploy

	for item in $@
	do
		cd ${PORTAL_REPOSITORY_DIR}/$item

		${PORTAL_REPOSITORY_DIR}/gradlew clean deploy
	done
}

function deploy_osgi_modules() {
	mkdir -p ${LIFERAY_HOME}/deploy

	for item in $@
	do
		cd ${PORTAL_REPOSITORY_DIR}/$item

		${PORTAL_REPOSITORY_DIR}/gradlew clean deploy
	done
}

function start_app_server() {
	cd ${PORTAL_REPOSITORY_DIR}

	ant -f build-test.xml start-app-server

	ant -f build-test.xml wait-for-server-startup
}

function stop_app_server() {
	cd ${PORTAL_REPOSITORY_DIR}

	ant -f build-test.xml start-app-server

	ant -f build-test.xml wait-for-server-startup
}