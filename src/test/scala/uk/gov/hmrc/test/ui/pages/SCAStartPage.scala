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
import uk.gov.hmrc.test.ui.PagePaths.{FeedbackPagePaths, GGloginPagePaths, SCAStartPagePaths}
import uk.gov.hmrc.test.ui.pages.config.Configuration
import uk.gov.hmrc.test.ui.utils.BrowserPackage.StartUpTearDown

import java.time.Duration

object SCAStartPage extends StartUpTearDown with GGloginPagePaths with SCAStartPagePaths with FeedbackPagePaths {
  def verifySCAStartPage(): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.APPROOT))

  def verifySCAStartPageHeaderLogoText(headerLogo: String): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(logoText), headerLogo))

  def verifySCAStartPageHeaderServiceName(headerServiceName: String): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(serviceName), headerServiceName))

  def verifySCAStartPageFooter(footerName: String): Boolean           =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(footer), footerName))
  def verifyTechnicalProblemsLink(technicalProblems: String): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.className(technicalProblemslink), technicalProblems))

  def clickOnAccountHome(): Unit           = driver.findElement(By.id(accountHome)).click()
  def searchResults(name: String): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(accountName), name))

  def SCAMenuResult(TaxesAndBenefits: String, Messages: String, YourDetails: String): Boolean = {
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(TaxandBenefits), TaxesAndBenefits))
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(Msgs), Messages))
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(PersonalDetails), YourDetails))
  }
  def clickOnTaxesAndBenefits(): Unit      = driver.findElement(By.id(TaxesAndBenefits)).click()
  def searchResult(SA: String, PAYE: String, NI: String, StatePension: String): Boolean = {
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(selfAssesment), SA))
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(PayAsYouEarn), PAYE))
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(Nino), NI))
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(Pension), StatePension))
  }
  def clickOnYourDetails(): Unit           = driver.findElement(By.id(yourDetails)).click()

  def verifyCHOCSServiceName(chocsServiceName: String): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(CHOCSServiceName), chocsServiceName))
  def clickOnFeedback(): Unit                                   = driver.findElement(By.xpath(Feedbacklink)).click()

  def verifyNewServiceFeedbackPageText(feedbackPageText: String): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(serviceFeedbackPageTitle), feedbackPageText))

  def returnToHomepage(): Unit         = driver.navigate.back()
  def clickOnSignout(): Unit           = driver.findElement(By.id(SignoutButton)).click()
  def verifyFeedbackPageURL(): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.FEEDBACK_PAGE))

  def verifyFeedbackPageText(feedbackPageText: String): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(feedbackPageTitle), feedbackPageText))

  val HomepageTitle = "Single Customer Account"

}
