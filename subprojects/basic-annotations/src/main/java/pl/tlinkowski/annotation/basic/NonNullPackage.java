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
package pl.tlinkowski.annotation.basic;

import java.lang.annotation.*;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

import kotlin.annotations.jvm.MigrationStatus;
import kotlin.annotations.jvm.UnderMigration;

/**
 * Declares that all type uses (e.g. fields, method return types, method parameters, type parameters, local variables)
 * within an annotated package are non-{@code null} by default.
 * <p>
 * Should be used at package level in association with {@link NullOr} annotations at type use level.
 *
 * @author Tomasz Linkowski
 */
// https://youtrack.jetbrains.com/issue/KT-10942
@Documented
@Nonnull
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PACKAGE)
@TypeQualifierDefault(ElementType.TYPE_USE)
@UnderMigration(status = MigrationStatus.STRICT) // for compile-time errors in Kotlin
public @interface NonNullPackage {

}
