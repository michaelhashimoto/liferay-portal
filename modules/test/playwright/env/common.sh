#!/bin/bash

set -e -x

if [[ "${LIFERAY_HOME}" == "" ]]
then
	echo "Please set 'LIFERAY_HOME'"

	exit 1
fi

if [[ "${PLAYWRIGHT_PROJECT_DIR}" == "" ]]
then
	echo "Please set 'PLAYWRIGHT_PROJECT_DIR'"

	exit 1
fi

if [[ "${PLAYWRIGHT_PROJECT_NAME}" == "" ]]
then
	echo "Please set 'PLAYWRIGHT_PROJECT_NAME'"

	exit 1
fi

if [[ "${PROJECT_DIR}" == "" ]]
then
	echo "Please set 'PROJECT_DIR'"

	exit 1
fi

function copy_to_deploy_folder() {
	mkdir -p ${LIFERAY_HOME}/deploy

	cp -r $1/ ${LIFERAY_HOME}/deploy
}

function deploy_client_extensions() {
	mkdir -p ${LIFERAY_HOME}/deploy

	cd ${PROJECT_DIR}

	ant -f build-test-playwright.xml deploy-client-extensions -Dclient.extension.dirs="${@}"
}

function deploy_osgi_modules() {
	mkdir -p ${LIFERAY_HOME}/deploy

	cd ${PROJECT_DIR}

	ant -f build-test-playwright.xml deploy-osgi-modules -Dosgi.module.dirs="${@}"
}

function deploy_project_client_extensions() {
	if [[ -f ${PLAYWRIGHT_PROJECT_DIR}/env/client-extensions.list ]]
	then
		deploy_client_extensions $(cat ${PLAYWRIGHT_PROJECT_DIR}/env/client-extensions.list)
	fi
}

function deploy_project_osgi_modules() {
	if [[ -f ${PLAYWRIGHT_PROJECT_DIR}/env/osgi-modules.list ]]
	then
		deploy_osgi_modules $(cat ${PLAYWRIGHT_PROJECT_DIR}/env/osgi-modules.list)
	fi
}

function start_app_server() {
	cd ${PROJECT_DIR}

	ant -f build-test.xml start-app-server

	ant -f build-test.xml wait-for-server-startup
}

function stop_app_server() {
	cd ${PROJECT_DIR}

	ant -f build-test.xml stop-app-server

	ant -f build-test.xml wait-for-server-shutdown -Dapp.server.port.number=8080
}

function update_portal_ext_properties() {
	cd ${PROJECT_DIR}

	ant -f build-test-playwright.xml update-portal-ext-properties -Dupdated.portal.ext.properties=${1}
}