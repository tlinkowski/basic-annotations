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
package pl.tlinkowski.sample.usage

import pl.tlinkowski.sample.api.annotated.both.BothAnnotatedSample

/**
 * @author Tomasz Linkowski
 */
class BothAnnotatedUsage {

  private lateinit var sample: BothAnnotatedSample

  /**
   * Conclusion: null-wise mutability detection for Kotlin works.
   */
  internal fun list() {
    val readOnlyListOfObj = sample.readOnlyListOfObj
    val readOnlyListOfObjOrNull = sample.readOnlyListOfObjOrNull
    val mutableListOfObj = sample.mutableListOfObj
    val mutableListOfObjOrNull = sample.mutableListOfObjOrNull

    sample.readOnlyListOfObj = readOnlyListOfObj
    sample.readOnlyListOfObj = readOnlyListOfObjOrNull // compile-time error
    sample.readOnlyListOfObj = mutableListOfObj
    sample.readOnlyListOfObj = mutableListOfObjOrNull // compile-time error

    sample.readOnlyListOfObjOrNull = readOnlyListOfObj
    sample.readOnlyListOfObjOrNull = readOnlyListOfObjOrNull
    sample.readOnlyListOfObjOrNull = mutableListOfObj
    sample.readOnlyListOfObjOrNull = mutableListOfObjOrNull

    sample.mutableListOfObj = readOnlyListOfObj // compile-time error
    sample.mutableListOfObj = readOnlyListOfObjOrNull // compile-time error
    sample.mutableListOfObj = mutableListOfObj
    sample.mutableListOfObj = mutableListOfObjOrNull // compile-time error

    sample.mutableListOfObjOrNull = readOnlyListOfObj // compile-time error
    sample.mutableListOfObjOrNull = readOnlyListOfObjOrNull // compile-time error
    sample.mutableListOfObjOrNull = mutableListOfObj // compile-time error
    sample.mutableListOfObjOrNull = mutableListOfObjOrNull
  }

  /**
   * Conclusion: cast null-wise mutability detection for Kotlin works.
   */
  internal fun castList() {
    val readOnlyListOfObj: List<Any> = sample.readOnlyListOfObj
    val readOnlyListOfObjOrNull: List<Any?> = sample.readOnlyListOfObjOrNull
    val mutableListOfObj: MutableList<Any> = sample.mutableListOfObj
    val mutableListOfObjOrNull: MutableList<Any?> = sample.mutableListOfObjOrNull

    sample.readOnlyListOfObj = readOnlyListOfObj
    sample.readOnlyListOfObj = readOnlyListOfObjOrNull // compile-time error
    sample.readOnlyListOfObj = mutableListOfObj
    sample.readOnlyListOfObj = mutableListOfObjOrNull // compile-time error

    sample.readOnlyListOfObjOrNull = readOnlyListOfObj
    sample.readOnlyListOfObjOrNull = readOnlyListOfObjOrNull
    sample.readOnlyListOfObjOrNull = mutableListOfObj
    sample.readOnlyListOfObjOrNull = mutableListOfObjOrNull

    sample.mutableListOfObj = readOnlyListOfObj // compile-time error
    sample.mutableListOfObj = readOnlyListOfObjOrNull // compile-time error
    sample.mutableListOfObj = mutableListOfObj
    sample.mutableListOfObj = mutableListOfObjOrNull // compile-time error

    sample.mutableListOfObjOrNull = readOnlyListOfObj // compile-time error
    sample.mutableListOfObjOrNull = readOnlyListOfObjOrNull // compile-time error
    sample.mutableListOfObjOrNull = mutableListOfObj // compile-time error
    sample.mutableListOfObjOrNull = mutableListOfObjOrNull
  }
}
