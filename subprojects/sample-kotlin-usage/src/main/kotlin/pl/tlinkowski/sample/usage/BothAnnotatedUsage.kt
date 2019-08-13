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
    val readOnlyListOfNonnull = sample.readOnlyListOfNonnull
    val readOnlyListOfNullable = sample.readOnlyListOfNullable
    val mutableListOfNonnull = sample.mutableListOfNonnull
    val mutableListOfNullable = sample.mutableListOfNullable

    sample.readOnlyListOfNonnull = readOnlyListOfNonnull
    sample.readOnlyListOfNonnull = readOnlyListOfNullable // compile-time error
    sample.readOnlyListOfNonnull = mutableListOfNonnull
    sample.readOnlyListOfNonnull = mutableListOfNullable // compile-time error

    sample.readOnlyListOfNullable = readOnlyListOfNonnull
    sample.readOnlyListOfNullable = readOnlyListOfNullable
    sample.readOnlyListOfNullable = mutableListOfNonnull
    sample.readOnlyListOfNullable = mutableListOfNullable

    sample.mutableListOfNonnull = readOnlyListOfNonnull // compile-time error
    sample.mutableListOfNonnull = readOnlyListOfNullable // compile-time error
    sample.mutableListOfNonnull = mutableListOfNonnull
    sample.mutableListOfNonnull = mutableListOfNullable // compile-time error

    sample.mutableListOfNullable = readOnlyListOfNonnull // compile-time error
    sample.mutableListOfNullable = readOnlyListOfNullable // compile-time error
    sample.mutableListOfNullable = mutableListOfNonnull // compile-time error
    sample.mutableListOfNullable = mutableListOfNullable
  }

  /**
   * Conclusion: cast null-wise mutability detection for Kotlin works.
   */
  internal fun castList() {
    val readOnlyListOfNonnull: List<Any> = sample.readOnlyListOfNonnull
    val readOnlyListOfNullable: List<Any?> = sample.readOnlyListOfNullable
    val mutableListOfNonnull: MutableList<Any> = sample.mutableListOfNonnull
    val mutableListOfNullable: MutableList<Any?> = sample.mutableListOfNullable

    sample.readOnlyListOfNonnull = readOnlyListOfNonnull
    sample.readOnlyListOfNonnull = readOnlyListOfNullable // compile-time error
    sample.readOnlyListOfNonnull = mutableListOfNonnull
    sample.readOnlyListOfNonnull = mutableListOfNullable // compile-time error

    sample.readOnlyListOfNullable = readOnlyListOfNonnull
    sample.readOnlyListOfNullable = readOnlyListOfNullable
    sample.readOnlyListOfNullable = mutableListOfNonnull
    sample.readOnlyListOfNullable = mutableListOfNullable

    sample.mutableListOfNonnull = readOnlyListOfNonnull // compile-time error
    sample.mutableListOfNonnull = readOnlyListOfNullable // compile-time error
    sample.mutableListOfNonnull = mutableListOfNonnull
    sample.mutableListOfNonnull = mutableListOfNullable // compile-time error

    sample.mutableListOfNullable = readOnlyListOfNonnull // compile-time error
    sample.mutableListOfNullable = readOnlyListOfNullable // compile-time error
    sample.mutableListOfNullable = mutableListOfNonnull // compile-time error
    sample.mutableListOfNullable = mutableListOfNullable
  }
}
