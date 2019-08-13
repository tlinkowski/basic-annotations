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

import pl.tlinkowski.sample.api.annotated.nullability.NullabilityAnnotatedSample

/**
 * @author Tomasz Linkowski
 */
class NullabilityAnnotatedUsage {

  private lateinit var sample: NullabilityAnnotatedSample
  private var condition = false

  //region OBJ

  /**
   * Conclusion: nullability for parameters/return types for Kotlin works as compile-time errors.
   */
  fun obj() {
    var nonnullObj = sample.nonnullObj
    var nullableObj = sample.nullableObj

    sample.nonnullObj = nullableObj // compile-time error
    sample.nullableObj = nonnullObj

    if (condition) {
      nonnullObj = nullableObj // compile-time error
    } else {
      nullableObj = nonnullObj
    }
  }

  /**
   * Conclusion: nullability for cast parameters/return types for Kotlin works as compile-time errors.
   */
  fun castObj() {
    var nonnullObj: Any = sample.nonnullObj
    var nullableObj: Any? = sample.nullableObj

    sample.nonnullObj = nullableObj // compile-time error
    sample.nullableObj = nonnullObj

    if (condition) {
      nonnullObj = nullableObj // compile-time error
    } else {
      nullableObj = nonnullObj
    }
  }
  //endregion

  //region LIST

  /**
   * Conclusion: nullability for generic parameter types for Kotlin works.
   */
  fun list() {
    var listOfNonnull = sample.listOfNonnull
    var listOfNullable = sample.listOfNullable

    sample.listOfNonnull = listOfNullable // compile-time error
    sample.listOfNullable = listOfNonnull // "Java type mismatch" (variance unknown) -> compile-time error

    if (condition) {
      listOfNonnull = listOfNullable // compile-time error
    } else {
      listOfNullable = listOfNonnull // "Java type mismatch" (variance unknown) -> compile-time error
    }
  }

  /**
   * Conclusion: nullability for cast covariant generic parameter types for Kotlin works.
   */
  fun castCovariantList() {
    var listOfNonnull: List<Any> = sample.listOfNonnull
    var listOfNullable: List<Any?> = sample.listOfNullable

    sample.listOfNonnull = listOfNullable // compile-time error
    sample.listOfNullable = listOfNonnull

    if (condition) {
      listOfNonnull = listOfNullable // compile-time error
    } else {
      listOfNullable = listOfNonnull
    }
  }

  /**
   * Conclusion: nullability for cast invariant generic parameter types for Kotlin works.
   */
  fun castInvariantList() {
    var listOfNonnull: MutableList<Any> = sample.listOfNonnull
    var listOfNullable: MutableList<Any?> = sample.listOfNullable

    sample.listOfNonnull = listOfNullable // compile-time error
    sample.listOfNullable = listOfNonnull // compile-time error

    if (condition) {
      listOfNonnull = listOfNullable // compile-time error
    } else {
      listOfNullable = listOfNonnull // compile-time error
    }
  }
  //endregion
}
