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
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

import kotlin.annotations.jvm.MigrationStatus;
import kotlin.annotations.jvm.UnderMigration;

/**
 * Declares that the annotated type use (e.g. field, method return type, method parameter, type parameter, local
 * variable) can be {@code null}.
 * <p>
 * Should be used at type use level in association with {@link NonNullPackage} annotation at package level.
 * <p>
 * Recognized by IDEs (e.g. IntelliJ) and by Kotlin (to infer nullability for its types).
 * <p>
 * Analogous to (except for the scope of allowed targets):
 * <a href="https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/lang/Nullable.html">{@code
 * Nullable}</a> in Spring, {@link javax.annotation.CheckForNull} in JSR 305.
 *
 * @author Tomasz Linkowski
 */
@Documented
@Nonnull(when = When.MAYBE)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@TypeQualifierNickname
@UnderMigration(status = MigrationStatus.STRICT) // https://youtrack.jetbrains.com/issue/KT-10942
public @interface NullOr {

}
