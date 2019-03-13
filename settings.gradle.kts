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
buildscript {
  repositories {
    gradlePluginPortal()
  }
  dependencies {
    classpath(group = "org.kordamp.gradle", name = "settings-gradle-plugin", version = "0.15.0")
  }
}
apply(plugin = "org.kordamp.gradle.settings")

rootProject.name = "basic-annotations"

configure<org.kordamp.gradle.plugin.settings.ProjectsExtension> {
  directories = listOf("subprojects")
}
