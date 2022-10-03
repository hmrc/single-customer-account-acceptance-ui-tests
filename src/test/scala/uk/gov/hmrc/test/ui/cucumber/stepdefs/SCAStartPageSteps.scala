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
import uk.gov.hmrc.test.ui.pages.SCAStartPage

class SCAStartPageSteps extends ScalaDsl with EN with Matchers with WebBrowser {

  Then("""^I am on SCA start page$""")(() => assert(SCAStartPage.verifySCAStartPage()))

  Then("""^I should see SCA title page Header contain logo text as "([^"]*)"$""") { (logoText: String) =>
    assert(SCAStartPage.verifySCAStartPageHeaderLogoText(logoText))
  }

  Then("""^I should see SCA title page Header contain service name as "([^"]*)"$""") { (serviceName: String) =>
    assert(SCAStartPage.verifySCAStartPageHeaderServiceName(serviceName))
  }

  Then("""^I should see SCA title page footer contain "([^"]*)"$""") { (pageFooterName: String) =>
    assert(SCAStartPage.verifySCAStartPageFooter(pageFooterName))
  }

  Then("""^I should see SCA name as "([^"]*)"$""") { (name: String) =>
    assert(SCAStartPage.searchResults(name))
  }

  When("""^I click on 'Home' on SCA landing page menu$""") {
    SCAStartPage.clickOnAccountHome()
  }

  Then("""^I should see following services on home page menu "([^"]*)" "([^"]*)" "([^"]*)"$""") {
    (TaxesAndBenefits: String, Messages: String, YourDetails: String) =>
      assert(SCAStartPage.SCAMenuResult(TaxesAndBenefits, Messages, YourDetails))
  }

  When("""^I click on 'Your Taxes and Benefits' on SCA landing page menu$""") {
    SCAStartPage.clickOnTaxesAndBenefits()
  }

  Then("""^I should see following services available "([^"]*)" "([^"]*)" "([^"]*)" "([^"]*)"$""") {
    (SA: String, PAYE: String, NI: String, StatePension: String) =>
      assert(SCAStartPage.searchResult(SA, PAYE, NI, StatePension))
  }

  When("""^I click on 'Your Details' on SCA landing page menu$""") {
    SCAStartPage.clickOnYourDetails()
  }

  Then("""^I should see CHOCS title page Header contain service name as "([^"]*)"$""") { (chocsServiceName: String) =>
    assert(SCAStartPage.verifyCHOCSServiceName(chocsServiceName))
  }

  Then("""^I should see if there is a link present on homepage to report Technical Problems "([^"]*)"$""") {
    (technicalProblems: String) =>
      assert(SCAStartPage.verifyTechnicalProblemsLink(technicalProblems))
  }

  When("""^I click on new service feedback link$""") {
    SCAStartPage.clickOnFeedback()
  }

  Then("""^I should see feedback page contain text as "([^"]*)"$""") { (feedbackPageText: String) =>
    assert(SCAStartPage.verifyNewServiceFeedbackPageText(feedbackPageText))
  }

  Then("""^I should return back to SCA home page$""")(SCAStartPage.returnToHomepage())

  When("""^I click on Sign out button on SCA title page header$""") {
    SCAStartPage.clickOnSignout()
  }

  Then("""^I should get re-directed to customer feedback page$""")(() => assert(SCAStartPage.verifyFeedbackPageURL()))

  Then("""^I should see customer feedback page contain text as "([^"]*)"$""") { (feedbackPageText: String) =>
    assert(SCAStartPage.verifyFeedbackPageText(feedbackPageText))
  }

}
