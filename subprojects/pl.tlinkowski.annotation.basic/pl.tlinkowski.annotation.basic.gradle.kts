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
  `java-library`
}

modularity.mixedJavaRelease(8)

config {
  bintray.enabled = true

  javadoc.autoLinks.configurations = listOf("implementation") // for JSR 305
}

dependencies {
  // do NOT expose JSR 305 to library users
  implementation(group = "com.google.code.findbugs", name = "jsr305", version = "3.0.2")

  // workaround for https://github.com/tlinkowski/basic-annotations/issues/19
  val kotlinVersion = "1.3.50" //: String by project
  api(group = "org.jetbrains.kotlin", name = "kotlin-annotations-jvm", version = kotlinVersion)
}
