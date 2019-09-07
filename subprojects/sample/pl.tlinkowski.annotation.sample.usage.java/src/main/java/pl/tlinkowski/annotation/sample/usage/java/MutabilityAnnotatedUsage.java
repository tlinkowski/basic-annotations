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
package pl.tlinkowski.annotation.sample.usage.java;

import pl.tlinkowski.annotation.sample.api.annotated.mutability.MutabilityAnnotatedSample;

/**
 * @author Tomasz Linkowski
 */
public final class MutabilityAnnotatedUsage {

  private MutabilityAnnotatedSample sample;
  private boolean condition;

  /**
   * Conclusion: mutability detection for Java doesn't work.
   */
  void list() {
    var readOnlyList = sample.getReadOnlyList();
    var mutableList = sample.getMutableList();

    sample.setReadOnlyList(readOnlyList);
    sample.setReadOnlyList(mutableList);

    sample.setMutableList(readOnlyList); // unnoticed
    sample.setMutableList(mutableList);

    if (condition) {
      mutableList = readOnlyList; // unnoticed
    } else {
      readOnlyList = mutableList;
    }
  }
}
