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
rootProject.name = "basic-annotations"

/*
 * Source: https://aalmiray.github.io/kordamp-gradle-plugins/#_project_structure
 */
fun includeProject(projectDirName: String, projectName: String) {
  val baseDir = File(settingsDir, projectDirName)
  val projectDir = File(baseDir, projectName)
  val buildFileName = "$projectName.gradle.kts"

  assert(projectDir.isDirectory())
  assert(File(projectDir, buildFileName).isFile())

  include(projectName)
  project(":$projectName").projectDir = projectDir
  project(":$projectName").buildFileName = buildFileName
}

listOf("subprojects").forEach { dirName ->
  val subdir = File(rootDir, dirName)
  subdir.walkTopDown().forEach { dir ->
    val buildFile = File(dir, "${dir.name}.gradle.kts")
    if (buildFile.exists()) {
      includeProject(dirName, dir.name)
    }
  }
}
