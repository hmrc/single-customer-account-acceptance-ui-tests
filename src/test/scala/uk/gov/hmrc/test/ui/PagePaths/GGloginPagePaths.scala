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
  val logoText           = "./html/body/header/div[1]/div/div[1]/a/span/span"
  val serviceName        = "./html/body/header/div[1]/div/div[2]/a"
  val footer             = "./html/body/footer/div/div/div[2]/a"
  val accountHome        = "nav-home"
  val accountName        = "name"
  val TaxandBenefits     = "nav-taxes-and-benefits"
  val Msgs               = "nav-messages"
  val PersonalDetails    = "nav-details"
  val TaxesAndBenefits   = "nav-taxes-and-benefits"
  val selfAssesment      = "sa"
  val PayAsYouEarn       = "paye"
  val Pension            = "nisp"
  val statePensionURL    = "/html/body/div[2]/main/div/div/div[1]/main/div/div/div[3]/div/div/p[3]/a"
  val niURL              = "/html/body/div[2]/main/div/div/div[1]/main/div/div/div[3]/div/div/p[4]/a"
  val yourDetails        = "nav-details"
  val Messages           = "nav-messages"
  val yourMessage        =
    "/html/body/div[2]/main/div/div/div[1]/main/div/div/div[4]/div/table/tbody/tr[1]/td[2]/div/span/a/span/span"
  val backButton         = "govuk-back-link"
  val Feedbacklink       = "./html/body/header/div[2]/div/p/span/a"
  val SignoutButton      = "nav-signout"
  val SCAAccessErrorText = "govuk-heading-xl"
  var APIId              = Random.nextInt()
}
trait FeedbackPagePaths {
  val TechnicalHelpPage      = "./html/body/div/main/div/div/a"
  val technicalHelpPageTitle = "head > title"
}
