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

import java.io.FileInputStream
import java.util.PropertyResourceBundle

object MessagesReader {
  val english = new FileInputStream("./src/test/resources/content/english.properties")

  val englishResource = {
    try new PropertyResourceBundle(english)
    finally english.close()

  }

  def getMessage(key: String) = englishResource.getString(key)

  lazy val welsh = new FileInputStream("./src/test/resources/content/welsh.properties")

  val welshResource = {

    try new PropertyResourceBundle(welsh)
    finally welsh.close()
  }

  def getWelshContent(key: String) = welshResource.getString(key)

}
