# Basic Java Annotations

[![Build (Linux)](https://img.shields.io/travis/com/tlinkowski/basic-annotations/master?logo=linux)](https://travis-ci.com/tlinkowski/basic-annotations)
[![Build (Windows)](https://img.shields.io/appveyor/ci/tlinkowski/basic-annotations/master?logo=windows)](https://ci.appveyor.com/project/tlinkowski/basic-annotations/branch/master)
[![Code coverage](https://img.shields.io/codecov/c/github/tlinkowski/basic-annotations)](https://codecov.io/gh/tlinkowski/basic-annotations)
[![Codacy grade](https://img.shields.io/codacy/grade/00dfb34300b94e76b791732690fe8548)](https://app.codacy.com/project/tlinkowski/basic-annotations/dashboard)

[![Maven Central](https://img.shields.io/maven-central/v/pl.tlinkowski.annotation/pl.tlinkowski.annotation.basic?label=Maven%20Central)](https://search.maven.org/search?q=g:pl.tlinkowski.annotation)
[![Javadocs](https://javadoc.io/badge/pl.tlinkowski.annotation/pl.tlinkowski.annotation.basic.svg?color=blue)](https://javadoc.io/doc/pl.tlinkowski.annotation/pl.tlinkowski.annotation.basic)
[![Semantic Versioning](https://img.shields.io/badge/-semantic%20versioning-333333)](https://semver.org/)
[![Automated Release Notes by gren](https://img.shields.io/badge/%F0%9F%A4%96-release%20notes-00B2EE)](https://github-tools.github.io/github-release-notes/)

## Usage

<details open>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
compileOnly(group = "pl.tlinkowski.annotation", name = "pl.tlinkowski.annotation.basic", version = "x.y.z")
```

</details>

<details>
<summary>Gradle (Groovy DSL)</summary>

```groovy
compileOnly group: 'pl.tlinkowski.annotation', name: 'pl.tlinkowski.annotation.basic', version: 'x.y.z'
```

</details>

<details>
<summary>Maven</summary>

```xml
<dependency>
  <groupId>pl.tlinkowski.annotation</groupId>
  <artifactId>pl.tlinkowski.annotation.basic</artifactId>
  <version>x.y.z</version>
  <scope>provided</scope>
</dependency>
```

</details>

<details open>
<summary>JPMS (<code>module-info.java</code>)</summary>

```java
requires static pl.tlinkowski.annotation.basic;
```

</details>

## Purpose

The purpose of this library is to provide a couple of basic annotations related to the following concepts:

1.  [Nullability](#nullability)

2.  [Mutability](#mutability) of
    [`Collection`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html)s /
    [`Iterator`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html)s

3.  [Miscellaneous](#miscellaneous)

### Nullability

The approach to nullability taken by this library is:

> **Everything is non-null by default, unless explicitly annotated as nullable.**

This approach is directly in line with [Kotlin's approach](https://kotlinlang.org/docs/reference/null-safety.html)
(although Kotlin enforces it through its type system):

-   `String` (Kotlin) / `String` (Java) → non-null `String`
-   `String?` (Kotlin) / `@NullOr String` (Java) → `null` or `String`

For this purpose, the library provides two annotations in the `pl.tlinkowski.annotation.basic` package:

1.  [`@NonNullPackage`](subprojects/pl.tlinkowski.annotation.basic/src/main/java/pl/tlinkowski/annotation/basic/NonNullPackage.java):

    -   [target](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/Target.html):
        [packages](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#PACKAGE)

    -   affects: **all** [type uses](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#TYPE_USE)
        (e.g. fields, method return types, method parameters, type parameters, local variables) and
        [type parameters](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#TYPE_PARAMETER)
        *within the annotated package*

    -   analogous to (except for the scope of affected entities):
        [`@NonNullApi`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/lang/NonNullApi.html) + 
        [`@NonNullFields`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/lang/NonNullFields.html)
        in Spring;
        [`@ParametersAreNonnullByDefault`](https://static.javadoc.io/com.google.code.findbugs/jsr305/3.0.2/javax/annotation/ParametersAreNonnullByDefault.html)
        in JSR 305

    -   [example usage](subprojects/sample-java-api/src/main/java/pl/tlinkowski/sample/api/annotated/nullability/package-info.java#L21-L24)

2.  [`@NullOr`](subprojects/pl.tlinkowski.annotation.basic/src/main/java/pl/tlinkowski/annotation/basic/NullOr.java):

    -   [target](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/Target.html):
        [type uses](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#TYPE_USE)
        (e.g. fields, method return types, method parameters, type parameters, local variables) and
        [type parameters](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#TYPE_PARAMETER)

    -   affects: annotated type use

    -   analogous to (except for the scope of allowed targets):
        [`@Nullable`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/lang/Nullable.html)
        in Spring;
        [`@CheckForNull`](https://static.javadoc.io/com.google.code.findbugs/jsr305/3.0.2/javax/annotation/CheckForNull.html)
        in JSR-305

    -   [example usage](subprojects/sample-java-api/src/main/java/pl/tlinkowski/sample/api/annotated/nullability/NullabilityAnnotatedSample.java#L33-L41)

The annotations in this library are based on the dormant Java Specification Request 
[JSR 305](https://jcp.org/en/jsr/detail?id=305). JSR 305 has been chosen for this library after analyzing
[the following pros & cons](https://blog.tlinkowski.pl/2019/when-to-use-jsr-305-for-nullability-in-java#assessment-of-jsr-305).

To sum up, even though I'd rather *not* rely on JSR 305, it seems too well supported right now to discard it.

However, should the state of JSR 305 change in favor of dropping its usage, this library will do just that. The purpose
of this library is to provide `@NonNullPackage` and `@NullOr` annotations that work in the best currently 
possible way.

### Mutability

The approach to mutability of [`Collection`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html)s
(but also [`Iterator`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html)s)
taken by this library is:

> **Every use of `Collection` or `Iterator` should be annotated with either `@ReadOnly` or `@Mutable`.**

This approach is in line with [Kotlin's approach](https://kotlinlang.org/docs/reference/collections.html)
(although Kotlin enforces it through its type system):

-   [`List<T>`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) (Kotlin)
    / `@ReadOnly List<T>` (Java) → read-only list of `T`

-   [`MutableList<T>`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html) (Kotlin)
    / `@Mutable List<T>` (Java) → mutable list of `T`

For this purpose, this library includes two annotations in the `kotlin.annotations.jvm` package
(as a transitive dependency on [`kotlin-annotations-jvm`](https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-annotations-jvm)):

1.  [`@ReadOnly`](https://github.com/JetBrains/kotlin/blob/master/libraries/tools/kotlin-annotations-jvm/src/kotlin/annotations/jvm/ReadOnly.java):

    -   [target](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/Target.html):
        [fields](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#FIELD),
        [methods](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#METHOD),
        [parameters](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#PARAMETER),
        or [local variables](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#LOCAL_VARIABLE)

    -   affects: annotated type use

    -   [example usage](subprojects/sample-java-api/src/main/java/pl/tlinkowski/sample/api/annotated/mutability/MutabilityAnnotatedSample.java#L30-L33)

2.  [`@Mutable`](https://github.com/JetBrains/kotlin/blob/master/libraries/tools/kotlin-annotations-jvm/src/kotlin/annotations/jvm/Mutable.java):
 
    -   [target](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/Target.html):
        [fields](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#FIELD),
        [methods](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#METHOD),
        [parameters](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#PARAMETER),
        or [local variables](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#LOCAL_VARIABLE)

    -   affects: annotated type use

    -   [example usage](subprojects/sample-java-api/src/main/java/pl/tlinkowski/sample/api/annotated/mutability/MutabilityAnnotatedSample.java#L35-L38)

There are three main problems with these annotations, though:

1.  [According to Denis Zharkov](https://youtrack.jetbrains.com/issue/KT-6878#focus=streamItem-27-3198699.0-0),
    these annotations will probably be renamed once [KT-23812](https://youtrack.jetbrains.com/issue/KT-23812) is done.

2.  These annotations are JDK6-compatible, and hence they cannot target
    [type uses](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#TYPE_USE)
    or [type parameters](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#TYPE_PARAMETER)
    (introduced in JDK 8). There's an issue about improving this ([KT-28982](https://youtrack.jetbrains.com/issue/KT-28982)),
    but it seems idle now.

3.  These annotations are not retained at runtime (`@Retention(RetentionPolicy.CLASS)`), which could be useful
    (at least theoretically).

To sum up, the main reason this library does not introduce its own annotations is that Kotlin wouldn't recognize them,
and they are very useful for Kotlin interop. However, once [KT-23812](https://youtrack.jetbrains.com/issue/KT-23812)
is done, this library will probably migrate to some
[new annotations](https://github.com/Kotlin/KEEP/blob/jvm-meta-annotations-artifact/proposals/jvm-meta-annotations-artifact.md)
that can be understood by Kotlin.

### Miscellaneous

-   [`@VisibleForTesting`](subprojects/pl.tlinkowski.annotation.basic/src/main/java/pl/tlinkowski/annotation/basic/VisibleForTesting.java):
    Corresponds to Guava's
    [`@VisibleForTesting`](https://google.github.io/guava/releases/28.0-jre/api/docs/com/google/common/annotations/VisibleForTesting.html)
    annotation.

## Sample Projects

Sample projects for this library can be found in [`sample`](subprojects/sample) subdirectory:

-   [`pl.tlinkowski.annotation.sample.api`](subprojects/sample/pl.tlinkowski.annotation.sample.api):
    sample Java API annotated with `@NonNullPackage` and `@ReadOnly`

-   [`pl.tlinkowski.annotation.sample.usage.java`](subprojects/sample/pl.tlinkowski.annotation.sample.usage.java):
    usage of the above API (both correct and incorrect, the latter resulting in warnings from IntelliJ IDEA)

-   [`pl.tlinkowski.annotation.sample.usage.kotlin`](subprojects/sample/pl.tlinkowski.annotation.sample.usage.kotlin):
    usage of the above API (both correct and incorrect, the latter resulting in errors from Kotlin compiler)

## Requirements

Usage: JDK 8+.

Building: Gradle 5+, JDK 11+.

## About the Author

See my webpage ([tlinkowski.pl](https://tlinkowski.pl/)) or
find me on Twitter ([@t_linkowski](https://twitter.com/t_linkowski)).
