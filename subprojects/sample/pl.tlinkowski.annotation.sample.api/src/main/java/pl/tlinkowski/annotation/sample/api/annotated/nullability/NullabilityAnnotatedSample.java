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
package pl.tlinkowski.annotation.sample.api.annotated.nullability;

import java.util.List;

import pl.tlinkowski.annotation.basic.NullOr;

/**
 * @author Tomasz Linkowski
 */
public interface NullabilityAnnotatedSample {

  Object getObj();

  void setObj(Object obj);

  @NullOr Object getObjOrNull();

  void setObjOrNull(@NullOr Object obj);

  List<Object> getListOfObj();

  void setListOfObj(List<Object> list);

  List<@NullOr Object> getListOfObjOrNull();

  void setListOfObjOrNull(List<@NullOr Object> list);
}
