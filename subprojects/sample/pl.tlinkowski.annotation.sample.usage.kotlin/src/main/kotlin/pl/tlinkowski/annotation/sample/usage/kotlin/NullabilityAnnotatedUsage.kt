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

import pl.tlinkowski.annotation.sample.api.annotated.nullability.NullabilityAnnotatedSample

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
    var obj = sample.obj
    var objOrNull = sample.objOrNull

    sample.obj = objOrNull // compile-time error
    sample.objOrNull = obj

    if (condition) {
      obj = objOrNull // compile-time error
    } else {
      objOrNull = obj
    }
  }

  /**
   * Conclusion: nullability for cast parameters/return types for Kotlin works as compile-time errors.
   */
  fun castObj() {
    var obj: Any = sample.obj
    var objOrNull: Any? = sample.objOrNull

    sample.obj = objOrNull // compile-time error
    sample.objOrNull = obj

    if (condition) {
      obj = objOrNull // compile-time error
    } else {
      objOrNull = obj
    }
  }
  //endregion

  //region LIST

  /**
   * Conclusion: nullability for generic parameter types for Kotlin works.
   */
  fun list() {
    var listOfObj = sample.listOfObj
    var listOfObjOrNull = sample.listOfObjOrNull

    sample.listOfObj = listOfObjOrNull // compile-time error
    sample.listOfObjOrNull = listOfObj // "Java type mismatch" (variance unknown) -> compile-time error

    if (condition) {
      listOfObj = listOfObjOrNull // compile-time error
    } else {
      listOfObjOrNull = listOfObj // "Java type mismatch" (variance unknown) -> compile-time error
    }
  }

  /**
   * Conclusion: nullability for cast covariant generic parameter types for Kotlin works.
   */
  fun castCovariantList() {
    var listOfObj: List<Any> = sample.listOfObj
    var listOfObjOrNull: List<Any?> = sample.listOfObjOrNull

    sample.listOfObj = listOfObjOrNull // compile-time error
    sample.listOfObjOrNull = listOfObj

    if (condition) {
      listOfObj = listOfObjOrNull // compile-time error
    } else {
      listOfObjOrNull = listOfObj
    }
  }

  /**
   * Conclusion: nullability for cast invariant generic parameter types for Kotlin works.
   */
  fun castInvariantList() {
    var listOfObj: MutableList<Any> = sample.listOfObj
    var listOfObjOrNull: MutableList<Any?> = sample.listOfObjOrNull

    sample.listOfObj = listOfObjOrNull // compile-time error
    sample.listOfObjOrNull = listOfObj // compile-time error

    if (condition) {
      listOfObj = listOfObjOrNull // compile-time error
    } else {
      listOfObjOrNull = listOfObj // compile-time error
    }
  }
  //endregion
}
