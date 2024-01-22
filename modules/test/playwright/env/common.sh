#!/bin/bash

set -e -x

if [[ "${LIFERAY_HOME}" == "" ]]
then
	echo "Please set 'LIFERAY_HOME'"

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

	for client_extension_dir in $@
	do
		if [[ ! -d ${PROJECT_DIR}/${client_extension_dir} ]]
		then
			echo "${PROJECT_DIR}/${client_extension_dir} does not exist."

			exit 1
		fi

		cd ${PROJECT_DIR}/${client_extension_dir}

		if [[ -e ${PROJECT_DIR}/${client_extension_dir}/client-extension.poshi.yaml ]]
		then
			${PROJECT_DIR}/gradlew clean deployPoshi -Pliferay.workspace.home.dir=${LIFERAY_HOME}
		else
			${PROJECT_DIR}/gradlew clean deploy -Pliferay.workspace.home.dir=${LIFERAY_HOME}
		fi
	done
}

function deploy_osgi_modules() {
	mkdir -p ${LIFERAY_HOME}/deploy

	for osgi_module_dir in $@
	do
		if [[ ! -d ${PROJECT_DIR}/${osgi_module_dir} ]]
		then
			echo "${PROJECT_DIR}/${osgi_module_dir} does not exist."

			exit 1
		fi

		cd ${PROJECT_DIR}/${osgi_module_dir}

		${PROJECT_DIR}/gradlew clean deploy
	done
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