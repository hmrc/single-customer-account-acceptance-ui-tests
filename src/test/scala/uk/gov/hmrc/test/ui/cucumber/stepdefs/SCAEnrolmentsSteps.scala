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
import org.scalatestplus.selenium._
import uk.gov.hmrc.test.ui.pages.{SCAStartPage, SCAEnrolments}

class SCAEnrolmentsSteps extends ScalaDsl with EN with Matchers with WebBrowser {

  When("""^User selects the SA service from the tax and benefits page$""") {
    SCAEnrolments.clickOnSelfAssessment()
  }

  Then("""^The user is directed to the existing SA service to view or perform various SA activities$""")(() =>
    assert(SCAEnrolments.verifySAPageURL()))

  Then("""^I should return back to SCA home page$""")(SCAStartPage.returnToHomepage())

  Then("""^I should only see following services available "([^"]*)" "([^"]*)" "([^"]*)"$""") {
    (PAYE: String, NI: String, StatePension: String) =>
      assert(SCAEnrolments.searchResult(PAYE, NI, StatePension))
  }

}
