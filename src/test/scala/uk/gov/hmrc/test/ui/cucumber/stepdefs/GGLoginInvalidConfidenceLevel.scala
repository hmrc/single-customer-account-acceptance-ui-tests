/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.must.Matchers
import org.scalatestplus.selenium.WebBrowser
import uk.gov.hmrc.test.ui.pages.{GGLoginPage, GGLoginPageInvalidConfidenceLevel}

class GGLoginInvalidConfidenceLevel extends ScalaDsl with EN with Matchers with WebBrowser {

  Given("""User login to the GGLogin Page$""") { () =>
    GGLoginPage.navigateToAuthLoginStub()
    GGLoginPage.enterRedirectURL()
  }

  When("""^Confidence level less is less than 200$""") {
    GGLoginPageInvalidConfidenceLevel.selectConfidenceLevel()
    GGLoginPage.enterNino()
    GGLoginPage.clickSubmitButton()
  }

  Then("""^User should see SCA home page with an error "([^"]*)"$""") { (accessError: String) =>
    assert(GGLoginPageInvalidConfidenceLevel.verifySCAStartPageAccessError(accessError))
  }

}
