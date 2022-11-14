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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.scalatest.matchers.must.Matchers.{be, convertToAnyMustWrapper}
import scalaj.http.Http
import uk.gov.hmrc.test.ui.PagePaths.{FeedbackPagePaths, GGloginPagePaths, SCAStartPagePaths}
import uk.gov.hmrc.test.ui.pages.config.Configuration
import uk.gov.hmrc.test.ui.utils.BrowserPackage.StartUpTearDown
import uk.gov.hmrc.test.ui.utils.HttpClient

import java.time.Duration

object SCAStartPage
    extends StartUpTearDown
    with GGloginPagePaths
    with SCAStartPagePaths
    with FeedbackPagePaths
    with HttpClient {
  def getMessage(): Int = {
    val getURL   = "http://localhost:8910/messages"
    val response = Http(getURL)
      .header("Content-Type", "application/json")
      .asString
    println(response)
    response.code
  }

  def postMessage(): Int = {
    val getURL   = "http://localhost:8910/messages"
    val response = Http(getURL)
      .method("POST")
      .header("Content-Type", "application/json")
      .postData(s"""{
                   |   "externalRef":{
                   |      "id":"$APIId",
                   |      "source":"gmc"
                   |   },
                   |   "recipient":{
                   |      "taxIdentifier":{
                   |         "name":"sautr",
                   |         "value":"1632631936"
                   |      },
                   |      "name":{
                   |         "forename":"Edward",
                   |         "secondForename":"A",
                   |         "surname":"Robertson"
                   |      },
                   |      "email":"someEmail@test.com"
                   |   },
                   |   "messageType":"mailout-batch",
                   |   "subject":"SCA Test Message_$APIId",
                   |   "content":"PHA+U0NBIFRlc3QgTWVzc2FnZTwvcD4=",
                   |   "validFrom":"2017-02-14",
                   |   "alertQueue":"DEFAULT",
                   |   "details":{
                   |      "formId":"SA300",
                   |      "issueDate":"2022-10-07",
                   |      "statutory":true,
                   |      "paperSent":false,
                   |      "batchId":"1234567",
                   |      "sourceData": "base64 encoded source data that was used by GMC to create the message",
                   |      "replyTo": "5c0a57826b00006b0032d0db"
                   |   }
                   |}""".stripMargin)
      .asString
    println(response)
    response.code
  }
  def verifySCAStartPage(): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.APPROOT))

  def searchResults(name: String): Boolean        =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(accountName), name))

  def SCAMenuResult(TaxesAndBenefits: String, Messages: String, YourDetails: String): Boolean = {
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(TaxandBenefits), TaxesAndBenefits))
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(Msgs), Messages))
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(PersonalDetails), YourDetails))
  }
  def searchResult(PAYE: String, SA: String, StatePension: String): Boolean = {
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(PayAsYouEarn), PAYE))
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(selfAssesment), SA))
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(Pension), StatePension))
  }
  def verifyStatePensionLinks(statePensionLink: String, niLink: String): Boolean = {
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(statePensionURL), statePensionLink))
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(niURL), niLink))
  }
  def clickOnStatePensionSummary(): Unit          = driver.findElement(By.linkText(statePensionURL)).click()
  def verifyStatePensionPageURL(): Boolean        =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.STATEPENSION_PAGE))
  def clickOnNIRecord(): Unit                     = driver.findElement(By.linkText(niURL)).click()
  def verifyNIRecordPageURL(): Boolean            =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.NI_PAGE))
  def clickOnMessage(): Unit                      = driver.findElement(By.partialLinkText(yourMessage)).click()
  def clickOnBackButton(): Unit                   = driver.findElement(By.className(backButton)).click()
  def clickOnFeedback(): Unit                     = driver.findElement(By.xpath(Feedbacklink)).click()
  def returnToPreviousPage(): Unit                = driver.navigate.back()
  def verifyFeedbackPageURL(): Boolean            =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.FEEDBACK_PAGE))
  def assertContent(id: By, expectedText: String) = driver.findElement(id).getText must be(expectedText)
  def clickOn(by: By): Unit                       =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .until(ExpectedConditions.elementToBeClickable(by))
      .click()

  def clickById(id: String): Unit =
    clickOn(By.id(id))

}
