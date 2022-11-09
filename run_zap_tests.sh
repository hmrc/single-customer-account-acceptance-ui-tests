#!/usr/bin/env bash

set -e

ENV=${1:-local}
BROWSER=${2:-chrome}

echo "*** running on $ENV using $BROWSER for tags '$tags' ***"

sbt -Dhttp.proxyHost=localhost -Dhttp.proxyPort=11000 -Dbrowser=$BROWSER -Denvironment=$ENV -Dcucumber.options="--tags '$tags'" clean "testOnly uk.gov.hmrc.test.ui.cucumber.runner.ZapRunner"