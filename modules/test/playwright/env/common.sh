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

	for client_extension_dir in $@
	do
		if [[ ! -d ${PORTAL_REPOSITORY_DIR}/${client_extension_dir} ]]
		then
			echo "${PORTAL_REPOSITORY_DIR}/${client_extension_dir} does not exist."

			exit 1
		fi

		cd ${PORTAL_REPOSITORY_DIR}/${client_extension_dir}

		${PORTAL_REPOSITORY_DIR}/gradlew clean deploy
	done
}

function deploy_osgi_modules() {
	mkdir -p ${LIFERAY_HOME}/deploy

	for osgi_module_dir in $@
	do
		if [[ ! -d ${PORTAL_REPOSITORY_DIR}/${osgi_module_dir} ]]
		then
			echo "${PORTAL_REPOSITORY_DIR}/${osgi_module_dir} does not exist."

			exit 1
		fi

		cd ${PORTAL_REPOSITORY_DIR}/${osgi_module_dir}

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

	ant -f build-test.xml stop-app-server

	ant -f build-test.xml wait-for-server-shutdown -Dapp.server.port.number=8080
}