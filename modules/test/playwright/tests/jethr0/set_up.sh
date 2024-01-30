#!/bin/bash

set -e -x

source ${PLAYWRIGHT_BASE_DIR}/env/set_up.sh

cd ${PROJECT_DIR}

ant -f build-test-liferay-jethr0-workspace.xml start-workspace