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


import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.test.ui.PagePaths.{FeedbackPagePaths, GGloginPagePaths, SCAStartPagePaths}
import uk.gov.hmrc.test.ui.utils.BrowserPackage.StartUpTearDown
import uk.gov.hmrc.test.ui.pages.config.Configuration

import java.time.Duration

object SCAEnrolments extends StartUpTearDown with GGloginPagePaths with SCAStartPagePaths with FeedbackPagePaths {

  def clickOnSelfAssessment(): Unit           = driver.findElement(By.id(selfAssesment)).click()

  def verifySAPageURL(): Boolean =
    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.SELFASSESSMENT_PAGE))

  def searchResult(PAYE: String, NI: String, StatePension: String): Boolean = {

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

}
