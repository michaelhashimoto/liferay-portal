#!/bin/bash

set -e -x

source ${PLAYWRIGHT_BASE_DIR}/env/common.sh

echo "This is the 'teardown' for the 'portal' playwright project"

stop_app_server