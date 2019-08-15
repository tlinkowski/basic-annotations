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

import pl.tlinkowski.sample.api.annotated.both.BothAnnotatedSample;

/**
 * @author Tomasz Linkowski
 */
public final class BothAnnotatedUsage {

  private BothAnnotatedSample sample;

  /**
   * Conclusion: null-wise mutability detection for Java doesn't work.
   */
  void list() {
    var readOnlyListOfObj = sample.getReadOnlyListOfObj();
    var readOnlyListOfObjOrNull = sample.getReadOnlyListOfObjOrNull();
    var mutableListOfObj = sample.getMutableListOfObj();
    var mutableListOfObjOrNull = sample.getMutableListOfObjOrNull();

    sample.setReadOnlyListOfObj(readOnlyListOfObj);
    sample.setReadOnlyListOfObj(readOnlyListOfObjOrNull); // unnoticed
    sample.setReadOnlyListOfObj(mutableListOfObj);
    sample.setReadOnlyListOfObj(mutableListOfObjOrNull); // unnoticed

    sample.setReadOnlyListOfObjOrNull(readOnlyListOfObj);
    sample.setReadOnlyListOfObjOrNull(readOnlyListOfObjOrNull);
    sample.setReadOnlyListOfObjOrNull(mutableListOfObj);
    sample.setReadOnlyListOfObjOrNull(mutableListOfObjOrNull);

    sample.setMutableListOfObj(readOnlyListOfObj); // unnoticed
    sample.setMutableListOfObj(readOnlyListOfObjOrNull); // unnoticed
    sample.setMutableListOfObj(mutableListOfObj);
    sample.setMutableListOfObj(mutableListOfObjOrNull); // unnoticed

    sample.setMutableListOfObjOrNull(readOnlyListOfObj); // unnoticed
    sample.setMutableListOfObjOrNull(readOnlyListOfObjOrNull); // unnoticed
    sample.setMutableListOfObjOrNull(mutableListOfObj); // unnoticed
    sample.setMutableListOfObjOrNull(mutableListOfObjOrNull);
  }
}
