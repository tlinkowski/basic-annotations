/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2019 Tomasz Linkowski.
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

plugins {
  // https://github.com/tlinkowski/tlinkowski-superpom
  id("pl.tlinkowski.gradle.my.superpom")
}

config {
  info {
    name = "basic-annotations"
    description = "A couple of basic Java annotations that cover null safety (via JSR 305), collection mutability (via Kotlin), and a few other concepts."
    tags = listOf("java", "annotation", "nullability", "mutability")
    inceptionYear = "2019"

    links {
      website = "https://github.com/tlinkowski/basic-annotations"
      issueTracker = "$website/issues"
      scm = "$website.git"
    }
  }
}
