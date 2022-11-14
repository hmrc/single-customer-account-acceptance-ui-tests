#!/usr/bin/env bash

set -e

browser="chrome"
if [ $# -gt 0  ];
then
  browser="$1"
fi

environment="local"

echo "*** running on $environment using $browser for tags '$tags' ***"

sbt -Dhttp.proxyHost=localhost -Dhttp.proxyPort=11000 -Denvironment="$environment" -Dbrowser="$browser" -Dcucumber.options="--tags '$tags'" clean "testOnly uk.gov.hmrc.test.ui.cucumber.runner.ZapRunner”