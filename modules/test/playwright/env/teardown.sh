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

stop_app_server