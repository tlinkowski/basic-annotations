# Basic Annotations

The purpose of this library is to provide a couple of basic annotations related to the following concepts:
1. [Nullability](#nullability)
2. [Mutability](#mutability) of [`Collection`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html)s/[`Iterator`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html)s
3. Miscellaneous

## Nullability

The approach to nullability taken by this library is:

> **Everything is non-null by default, unless explicitly annotated as nullable.**

For this purpose, the library provides two annotations in the `pl.tlinkowski.annotation` package:
1. `@AllNonnullByDefault`:
    - [target](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/Target.html): [packages](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#PACKAGE)
    - affects: **all** [fields](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#FIELD), [methods](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#METHOD) (= return types), [parameters](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#PARAMETER), [local variables](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#LOCAL_VARIABLE), [type uses](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#TYPE_USE), and [type parameters](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#TYPE_PARAMETER) *within the annotated package and its subpackages*
    - similar to: [`@NonNullApi`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/lang/NonNullApi.html) + [`@NonNullFields`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/lang/NonNullFields.html) in Spring; [`@ParametersAreNonnullByDefault`](https://static.javadoc.io/com.google.code.findbugs/jsr305/3.0.2/javax/annotation/ParametersAreNonnullByDefault.html) in JSR 305
2. `@Nullable`:
    - [target](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/Target.html): [fields](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#FIELD), [methods](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#METHOD), [parameters](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#PARAMETER), [local variables](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#LOCAL_VARIABLE), [type uses](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#TYPE_USE), or [type parameters](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/ElementType.html#TYPE_PARAMETER)
    - affects: annotated entity
    - similar to: [`@Nullable`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/lang/Nullable.html) in Spring; [`@CheckForNull`](https://static.javadoc.io/com.google.code.findbugs/jsr305/3.0.2/javax/annotation/CheckForNull.html) in JSR-305

The annotations in this library are based on the dormant Java Specification Request [JSR 305](https://jcp.org/en/jsr/detail?id=305). JSR 305 has been chosen for this library after analyzing the following pros & cons.

### Cons of using JSR 305
1. May cause [split packages in JPMS](https://blog.codefx.org/java/java-9-migration-guide/#Split-Packages) (can be [patched](https://blog.codefx.org/java/jsr-305-java-9/), though).
2. Has no true specification other than [this presentation](https://www.cs.umd.edu/~pugh/JSR-305.pdf) by [William Pugh](https://www.cs.umd.edu/people/pugh).
3. Has potential [licensing problems](https://github.com/google/guava/issues/2960#issue-263628666).
4. Due to the above, libraries don't want to use JSR 305 ([SLF4J](https://www.slf4j.org/news.html), [RxJava](https://github.com/ReactiveX/RxJava/issues/5341), [AutoValue](https://github.com/google/auto/issues/575), [Apache Sling](https://sling.apache.org/documentation/development/null-analysis.html)) or want to stop using it ([Guava](https://github.com/google/guava/issues/2960), [rsocket](https://github.com/rsocket/rsocket-java/issues/423)).
5. In future, Kotlin might support a non-JSR-305 mechanism for its Java interop ([KT-21408](https://youtrack.jetbrains.com/issue/KT-21408)).

### Pros of using JSR 305
1. Honored by Kotlin for its [Java interop](https://kotlinlang.org/docs/reference/java-interop.html#jsr-305-support).
2. Honored by IntelliJ IDEA ([IDEA-173544](https://youtrack.jetbrains.com/issue/IDEA-173544)).
3. Honored by Eclipse ([518839](https://bugs.eclipse.org/bugs/show_bug.cgi?id=518839)).
4. Embraced by some popular libraries ([Spring Framework](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/lang/NonNullApi.html), [Reactor](https://projectreactor.io/docs/core/release/api/reactor/util/annotation/NonNullApi.html), [MongoDB](https://jira.mongodb.org/browse/JAVA-2641)).
5. [Mark Reinhold](https://mreinhold.org/) (Chief Java Architect) seems to at least [tolerate using JSR 305](https://stackoverflow.com/questions/37598775/jsr-305-annotations-replacement-for-java-9/37911663#37911663).

### Summary

To sum up, even though I'd rather *not* rely on JSR 305, it seems too well supported right now to discard it.

However, should the state of JSR 305 change in favor of dropping its usage, this library will do just that. The purpose of this library is to provide `@AllNonnullByDefault` and `@Nullable` annotations that work in the best currently possible way.

## Mutability

