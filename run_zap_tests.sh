#!/usr/bin/env bash

ENV=${1:-local}
BROWSER=${2:-chrome}

if [ "$BROWSER" = "chrome" ]; then
    DRIVER="-Dwebdriver.chrome.driver=/opt/homebrew/bin/chromedriver"
elif [ "$BROWSER" = "firefox" ]; then
    DRIVER="-Dwebdriver.gecko.driver=/opt/homebrew/bin/geckodriver"
fi

sbt -Dbrowser=$BROWSER -Denvironment=$ENV $DRIVER "testOnly uk.gov.hmrc.test.ui.cucumber.runner.ZapRunner"