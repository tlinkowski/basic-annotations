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
package pl.tlinkowski.sample.api.annotated.both;

import java.util.List;

import kotlin.annotations.jvm.Mutable;
import kotlin.annotations.jvm.ReadOnly;

import pl.tlinkowski.annotation.basic.Nullable;

/**
 * @author Tomasz Linkowski
 */
public interface BothAnnotatedSample {

  @ReadOnly
  List<Object> getReadOnlyListOfNonnull();

  void setReadOnlyListOfNonnull(@ReadOnly List<Object> list);

  @ReadOnly
  List<@Nullable Object> getReadOnlyListOfNullable();

  void setReadOnlyListOfNullable(@ReadOnly List<@Nullable Object> list);

  @Mutable
  List<Object> getMutableListOfNonnull();

  void setMutableListOfNonnull(@Mutable List<Object> list);

  @Mutable
  List<@Nullable Object> getMutableListOfNullable();

  void setMutableListOfNullable(@Mutable List<@Nullable Object> list);
}
