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
package pl.tlinkowski.annotation.sample.usage.kotlin

import pl.tlinkowski.annotation.sample.api.annotated.mutability.MutabilityAnnotatedSample

/**
 * @author Tomasz Linkowski
 */
class MutabilityAnnotatedUsage {

  private lateinit var sample: MutabilityAnnotatedSample

  /**
   * Conclusion: mutability detection for Kotlin works.
   */
  internal fun list() {
    var readOnlyList = sample.readOnlyList
    var mutableList = sample.mutableList

    sample.readOnlyList = readOnlyList
    sample.readOnlyList = mutableList

    sample.mutableList = readOnlyList // compile-time error
    sample.mutableList = mutableList

    mutableList = readOnlyList // compile-time error
    readOnlyList = mutableList
  }

  /**
   * Conclusion: cast mutability detection for Kotlin works.
   */
  internal fun castList() {
    var readOnlyList: List<Any?> = sample.readOnlyList
    var mutableList: MutableList<Any?> = sample.mutableList

    sample.readOnlyList = readOnlyList
    sample.readOnlyList = mutableList

    sample.mutableList = readOnlyList // compile-time error
    sample.mutableList = mutableList

    mutableList = readOnlyList // compile-time error
    readOnlyList = mutableList
  }
}
