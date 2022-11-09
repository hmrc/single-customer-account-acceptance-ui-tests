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
  Given("""^message service is running i.e. get API call return '(.*)'$""") { (statuscode: Int) =>
    assert(SCAStartPage.getMessage() equals statuscode)
  }

  Then("""^I should post a test message to message service and get the '(.*)'$""") { (statuscode: Int) =>
    assert(SCAStartPage.postMessage() equals statuscode)
  }

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

  Then("""^I should see following tiles on the page "([^"]*)" "([^"]*)" "([^"]*)"$""") {
    (PAYE: String, SA: String, StatePension: String) =>
      assert(SCAStartPage.searchResult(PAYE, SA, StatePension))
  }

  Then("""^The user should see "Your State Pension” tile with following links "([^"]*)" and "([^"]*)"$""") {
    (statePensionLink: String, niLink: String) =>
      assert(SCAStartPage.verifyStatePensionLinks(statePensionLink, niLink))
  }

  When("""User selects 'Check your State Pension summary' link in State pension tile$""") {
    SCAStartPage.clickOnStatePensionSummary()
  }

  Then("""^System directs the user to State Pension summary page$""")(() =>
    assert(SCAStartPage.verifyStatePensionPageURL())
  )

  Then("""^The user should be able to return to 'Your taxes and benefits' page$""")(SCAStartPage.returnToPreviousPage())

  When("""User selects 'Check your National Insurance record' NI link in State pension tile$""") {
    SCAStartPage.clickOnNIRecord()
  }

  Then("""^System directs the user to National Insurance record page$""")(() =>
    assert(SCAStartPage.verifyNIRecordPageURL())
  )

  When("""^I click on 'Your Details' on SCA landing page menu$""") {
    SCAStartPage.clickOnYourDetails()
  }

  Then("""^I should see CHOCS title page Header contain service name as "([^"]*)"$""") { (chocsServiceName: String) =>
    assert(SCAStartPage.verifyCHOCSServiceName(chocsServiceName))
  }

  When("""^User selects 'Messages' from the SCA home page menu$""") {
    SCAStartPage.clickOnMessages()
  }
  Then("""The user can see all their messages under messages home page$""") { (Message: String) =>
    assert(SCAStartPage.verifyMessages(Message))
  }

  When("""^User click on a Message$""") {
    SCAStartPage.clickOnMessage()
  }

  Then("""More information related to that message can be seen under message focus page$""") { (msgInfo: String) =>
    assert(SCAStartPage.messageInfo(msgInfo))
  }

  Then("""^The user should be able to return to previous page$""") {
    SCAStartPage.clickOnBackButton()
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

  Then("""^I should return back to SCA home page$""")(SCAStartPage.returnToPreviousPage())

  When("""^I click on Sign out button on SCA title page header$""") {
    SCAStartPage.clickOnSignout()
  }

  Then("""^I should get re-directed to customer feedback page$""")(() => assert(SCAStartPage.verifyFeedbackPageURL()))

  Then("""^I should see customer feedback page contain text as "([^"]*)"$""") { (feedbackPageText: String) =>
    assert(SCAStartPage.verifyFeedbackPageText(feedbackPageText))
  }

}
