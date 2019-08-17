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

/**
 * Provides a set of basic annotations based on <a href="https://jcp.org/en/jsr/detail?id=305">JSR 305</a> and
 * <a href="https://github.com/JetBrains/kotlin/tree/master/libraries/tools/kotlin-annotations-jvm">Kotlin JVM
 * annotations</a>.
 * <p>
 * The following annotations are to be used by the consumers of this library:
 * <ul>
 *   <li>for nullability: {@link pl.tlinkowski.annotation.basic.NonNullPackage}, {@link pl.tlinkowski.annotation.basic.NullOr}</li>
 *   <li>for collection mutability: {@code kotlin.annotations.jvm.ReadOnly}, {@code kotlin.annotations.jvm.Mutable}</li>
 *   <li>miscellaneous: {@link pl.tlinkowski.annotation.basic.VisibleForTesting}</li>
 * </ul>
 * <p>
 * More details can be found in the <a href="https://github.com/tlinkowski/basic-annotations">GitHub README</a>.
 * <p>
 * Note: even though this library provides a {@code module-info.class}, all its other classes are compatible with JDK 8.
 *
 * @author Tomasz Linkowski
 */
module pl.tlinkowski.annotation.basic {
  exports pl.tlinkowski.annotation.basic;

  requires transitive org.checkerframework.checker.qual;
  requires transitive kotlin.annotations.jvm;
}
