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

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.test.ui.PagePaths.{FeedbackPagePaths, GGloginPagePaths, SCAStartPagePaths}
import uk.gov.hmrc.test.ui.pages.config.Configuration
import uk.gov.hmrc.test.ui.utils.BrowserPackage.StartUpTearDown

//import java.lang

object GGLoginPage extends StartUpTearDown with GGloginPagePaths with SCAStartPagePaths with FeedbackPagePaths {

  def navigateToStartPage(): Unit =
    driver.get(Configuration.settings.APP_ROOT)

  def navigateToAuthLoginStub(): Unit =
    driver.navigate().to(Configuration.settings.AUTHLOGINSTUB)

  def enterRedirectURL(): Unit  =
    driver
      .findElement(By.name(redirectURLField))
      .sendKeys(Configuration.settings.APPROOT)

  def selectConfidenceLevel(): Unit = {
    val confidenceLevel: Select = new Select(driver.findElement(By.name(confidenceLevelField)))
    confidenceLevel.selectByValue("200")
  }
  def enterNino(): Unit         =
    driver
      .findElement(By.name(nino))
      .sendKeys(NINumber)
  def selectSAEnrolment(): Unit = {
    val EnrolmentSelect: Select = new Select(driver.findElement(By.id(dropdown)))
    EnrolmentSelect.selectByVisibleText(SelfAssessment)
    driver.findElement(By.id(addPresent)).click()
    driver
      .findElement(By.id(identifierValueForUTRNumber))
      .sendKeys(UTRNumber)
  }
  def clickSubmitButton(): Unit =
    driver.findElement(By.id(submitButton)).click()

  val NINumber                    = "HT009413A"
  val dropdown                    = "presets-dropdown"
  val SelfAssessment              = "SA"
  val addPresent                  = "add-preset"
  val identifierValueForUTRNumber = "input-4-0-value"
  val UTRNumber                   = "1632631936"
}
