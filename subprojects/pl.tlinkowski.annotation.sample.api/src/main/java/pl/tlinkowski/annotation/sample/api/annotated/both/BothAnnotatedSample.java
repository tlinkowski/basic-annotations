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
package pl.tlinkowski.annotation.sample.api.annotated.both;

import java.util.List;

import kotlin.annotations.jvm.Mutable;
import kotlin.annotations.jvm.ReadOnly;

import pl.tlinkowski.annotation.basic.NullOr;

/**
 * @author Tomasz Linkowski
 */
public interface BothAnnotatedSample {

  @ReadOnly
  List<Object> getReadOnlyListOfObj();

  void setReadOnlyListOfObj(@ReadOnly List<Object> list);

  @ReadOnly
  List<@NullOr Object> getReadOnlyListOfObjOrNull();

  void setReadOnlyListOfObjOrNull(@ReadOnly List<@NullOr Object> list);

  @Mutable
  List<Object> getMutableListOfObj();

  void setMutableListOfObj(@Mutable List<Object> list);

  @Mutable
  List<@NullOr Object> getMutableListOfObjOrNull();

  void setMutableListOfObjOrNull(@Mutable List<@NullOr Object> list);
}
