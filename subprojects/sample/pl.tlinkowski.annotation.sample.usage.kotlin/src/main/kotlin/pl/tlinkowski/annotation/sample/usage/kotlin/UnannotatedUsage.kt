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

import pl.tlinkowski.annotation.sample.api.unannotated.UnannotatedSample

/**
 * @author Tomasz Linkowski
 */
class UnannotatedUsage {

  private lateinit var sample: UnannotatedSample

  //region OBJ
  fun obj() {
    val obj = sample.obj
    sample.obj = obj
  }

  fun objAsAny() {
    val obj: Any = sample.obj
    sample.obj = obj
  }

  fun objAsAnyOrNull() {
    val obj: Any? = sample.obj
    sample.obj = obj
  }
  //endregion

  //region LIST
  fun list() {
    val list = sample.list
    sample.list = list
  }

  fun listAsListOfAny() {
    val list: List<Any> = sample.list
    sample.list = list
  }

  fun listAsListOfAnyOrNull() {
    val list: MutableList<Any?> = sample.list
    sample.list = list
  }
  //endregion
}
