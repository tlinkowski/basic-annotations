tasks.wrapper {
  gradleVersion = "5.2.1"
  distributionType = Wrapper.DistributionType.ALL
}

allprojects {
  repositories {
    mavenCentral()
  }
}

subprojects {
  group = "pl.tlinkowski"
}

apply(from = "$rootDir/gradle/ide.gradle.kts")
