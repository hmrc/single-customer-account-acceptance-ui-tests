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

trait GGloginPagePaths {
  val redirectURLField     = "redirectionUrl"
  val confidenceLevelField = "confidenceLevel"
  val submitButton         = "submit"
}
trait SCAStartPagePaths {
  val logoText      = "./html/body/header/div[1]/div/div[1]/a/span/span"
  val serviceName   = "./html/body/header/div[1]/div/div[2]/a"
  val footer        = "./html/body/footer/div/div/div[2]/a"
  val SignoutButton = "./html/body/header/div[1]/div/div[2]/nav/a"
}
trait FeedbackPagePaths {
  val feedbackPageTitle = "./html/body/div/main/div/div/form/h1"
}
