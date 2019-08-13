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
package pl.tlinkowski.sample.api.annotated.nullability;

import java.util.List;

import pl.tlinkowski.annotation.basic.Nullable;

/**
 * @author Tomasz Linkowski
 */
public interface NullabilityAnnotatedSample {

  Object getNonnullObj();

  void setNonnullObj(Object obj);

  @Nullable Object getNullableObj();

  void setNullableObj(@Nullable Object obj);

  List<Object> getListOfNonnull();

  void setListOfNonnull(List<Object> list);

  List<@Nullable Object> getListOfNullable();

  void setListOfNullable(List<@Nullable Object> list);
}
