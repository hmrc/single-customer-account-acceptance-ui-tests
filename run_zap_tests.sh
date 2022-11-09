#!/usr/bin/env bash

ENV=${1:-local}
BROWSER=${2:-chrome}

if [ "$BROWSER" = "chrome" ]; then
    DRIVER="-Dwebdriver.chrome.driver=/opt/homebrew/bin/chromedriver"
elif [ "$BROWSER" = "firefox" ]; then
    DRIVER="-Dwebdriver.gecko.driver=/opt/homebrew/bin/geckodriver"
fi

sbt -Dhttp.proxyHost=localhost -Dhttp.proxyPort=11000 -Dbrowser=$BROWSER -Denvironment=$ENV $DRIVER "testOnly uk.gov.hmrc.test.ui.cucumber.runner.ZapRunner"