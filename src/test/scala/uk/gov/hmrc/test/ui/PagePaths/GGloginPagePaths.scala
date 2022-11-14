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

package uk.gov.hmrc.test.ui.PagePaths

import scala.util.Random

trait GGloginPagePaths {
  val redirectURLField     = "redirectionUrl"
  val confidenceLevelField = "confidenceLevel"
  val nino                 = "nino"
  val submitButton         = "submit-top"
}
trait SCAStartPagePaths {
  val accountName        = "name"
  val TaxandBenefits     = "nav-taxes-and-benefits"
  val Msgs               = "nav-messages"
  val PersonalDetails    = "nav-details"
  val selfAssesment      = "sa"
  val PayAsYouEarn       = "paye"
  val Pension            = "nisp"
  val statePensionURL    = "//a[normalize-space()='Check your State Pension summary']"
  val niURL              = "//a[normalize-space()='Check your National Insurance record']"
  val yourMessage        = "SCA Test Message"
  val backButton         = "govuk-back-link"
  val Feedbacklink       = "./html/body/header/div[2]/div/p/span/a"
  val SCAAccessErrorText = "govuk-heading-xl"
  var APIId              = Random.nextInt()
}
trait FeedbackPagePaths {
  val TechnicalHelpPage      = "./html/body/div/main/div/div/a"
  val technicalHelpPageTitle = "head > title"
}
