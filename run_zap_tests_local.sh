#!/usr/bin/env bash

ENV=${1:-local}
BROWSER=${2:-chrome}

if [ "$BROWSER" = "chrome" ]; then
    DRIVER="-Dwebdriver.chrome.driver=/opt/homebrew/bin/chromedriver"
elif [ "$BROWSER" = "firefox" ]; then
    DRIVER="-Dwebdriver.gecko.driver=/opt/homebrew/bin/geckodriver"
fi

export ZAP_FORWARD_ENABLE="true"
export ZAP_FORWARD_PORTS=$(sm -s | grep -E 'PASS|BOOT' | awk '{print $12}' | tr "\n" " ")
# If running services with sbt rather than service-manager, the ports will not be identified
# leading to Connection Refused errors in the browser
#export ZAP_FORWARD_PORTS="9017 8471"

export ZAP_LOCAL_ALERT_FILTERS="${PWD}/alert-filters.json"


(
  cd $WORKSPACE/dast-config-manager
  make local-zap-running
)

echo "Running tests..."
echo "=========================================="
echo "Browser:              ${BROWSER}"
echo "Env:                  ${ENV}"
echo "ZAP Proxy Required:   true"
echo "ZAP alert filters:    ${ZAP_LOCAL_ALERT_FILTERS}"
echo "=========================================="


echo "Running tests via ZAP proxy..."
sbt -Dbrowser=$BROWSER -Denvironment=$ENV -Dzap.proxy=true clean  "testOnly uk.gov.hmrc.test.ui.cucumber.runner.ZapRunner"

(
  cd $WORKSPACE/dast-config-manager
  make local-zap-stop
)