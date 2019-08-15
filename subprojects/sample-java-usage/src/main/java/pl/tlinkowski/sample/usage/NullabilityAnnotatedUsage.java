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
package pl.tlinkowski.sample.usage;

import pl.tlinkowski.sample.api.annotated.nullability.NullabilityAnnotatedSample;

/**
 * @author Tomasz Linkowski
 */
public final class NullabilityAnnotatedUsage {

  private NullabilityAnnotatedSample sample;
  private boolean condition;

  /**
   * Conclusion: nullability for parameters/return types for Java works partially as warnings.
   */
  void obj() {
    var obj = sample.getObj();
    var objOrNull = sample.getObjOrNull();

    sample.setObj(objOrNull); // warning
    sample.setObjOrNull(obj);

    if (condition) {
      obj = objOrNull; // unnoticed
    } else {
      objOrNull = obj;
    }
  }

  /**
   * Conclusion: nullability for generic parameter types for Java doesn't work.
   */
  void list() {
    var listOfObj = sample.getListOfObj();
    var listOfObjOrNull = sample.getListOfObjOrNull();

    sample.setListOfObj(listOfObjOrNull); // unnoticed
    sample.setListOfObjOrNull(listOfObj);

    if (condition) {
      listOfObj = listOfObjOrNull; // unnoticed
    } else {
      listOfObjOrNull = listOfObj;
    }
  }
}
