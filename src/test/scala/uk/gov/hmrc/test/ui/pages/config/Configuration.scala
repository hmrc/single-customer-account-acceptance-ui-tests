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

package uk.gov.hmrc.test.ui.pages.config

case class Configuration(
  APP_ROOT: String,
  APPROOT: String,
  AUTHLOGINSTUB: String,
  FEEDBACK_PAGE: String,
  STATEPENSION_PAGE: String,
  NI_PAGE: String,
  PAGE_TIMEOUT_SECS: Int
)

object Configuration {

  lazy val environment: Environment.Name = {

    val environmentProperty =
      System.getProperty("environment", "local").toLowerCase
    environmentProperty match {
      case "local"   => Environment.Local
      case "dev"     => Environment.dev
      case "qa"      => Environment.Qa
      case "staging" => Environment.Staging
      case _         =>
        throw new IllegalArgumentException(s"Environment '$environmentProperty' not known")
    }
  }

  lazy val settings: Configuration = create()

  private def create(): Configuration =
    environment match {

      case Environment.Local =>
        new Configuration(
          APP_ROOT = "http://localhost:9949/auth-login-stub/gg-sign-in?continue=%2Fsingle-customer-account",
          APPROOT = "http://localhost:8420/single-customer-account",
          AUTHLOGINSTUB = "http://localhost:9949/auth-login-stub/gg-sign-in",
          FEEDBACK_PAGE = "http://localhost:9514/feedback/single-customer-account-frontend",
          STATEPENSION_PAGE = "http://localhost:9234/check-your-state-pension/account",
          NI_PAGE = "http://localhost:9234/check-your-state-pension/account/nirecord",
          PAGE_TIMEOUT_SECS = 60
        )

      case Environment.dev =>
        new Configuration(
          APP_ROOT =
            "https://www.development.tax.service.gov.uk/auth-login-stub/gg-sign-in?continue=%2Fsingle-customer-account",
          APPROOT = "https://www.development.tax.service.gov.uk/single-customer-account",
          AUTHLOGINSTUB = "https://www.development.tax.service.gov.uk/auth-login-stub/gg-sign-in",
          FEEDBACK_PAGE = "https://www.development.tax.service.gov.uk/feedback/single-customer-account-frontend",
          STATEPENSION_PAGE = "https://www.development.tax.service.gov.uk/check-your-state-pension/account",
          NI_PAGE = "https://www.development.tax.service.gov.uk/check-your-state-pension/account/nirecord",
          PAGE_TIMEOUT_SECS = 60
        )

      case Environment.Qa =>
        new Configuration(
          APP_ROOT = "https://www.qa.tax.service.gov.uk/auth-login-stub/gg-sign-in?continue=%2Fsingle-customer-account",
          APPROOT = "https://www.qa.tax.service.gov.uk/single-customer-account",
          AUTHLOGINSTUB = "https://www.qa.tax.service.gov.uk/auth-login-stub/gg-sign-in",
          FEEDBACK_PAGE = "https://www.qa.tax.service.gov.uk/feedback/single-customer-account-frontend",
          STATEPENSION_PAGE = "https://www.qa.tax.service.gov.uk/check-your-state-pension/account",
          NI_PAGE = "https://www.qa.tax.service.gov.uk/check-your-state-pension/account/nirecord",
          PAGE_TIMEOUT_SECS = 60
        )

      case Environment.Staging =>
        new Configuration(
          APP_ROOT =
            "https://www.staging.tax.service.gov.uk/auth-login-stub/gg-sign-in?continue=%2Fsingle-customer-account",
          APPROOT = "https://www.staging.tax.service.gov.uk/single-customer-account",
          AUTHLOGINSTUB = "https://www.staging.tax.service.gov.uk/auth-login-stub/gg-sign-in",
          FEEDBACK_PAGE = "https://www.staging.tax.service.gov.uk/feedback/single-customer-account-frontend",
          STATEPENSION_PAGE = "https://www.staging.tax.service.gov.uk/check-your-state-pension/account",
          NI_PAGE = "https://www.staging.tax.service.gov.uk/check-your-state-pension/account/nirecord",
          PAGE_TIMEOUT_SECS = 60
        )

      case _ =>
        throw new IllegalArgumentException(s"Environment '$environment' not known")
    }
}

object Environment extends Enumeration {
  type Name = Value
  val Local, dev, Qa, Staging = Value
}
