// jhipster-needle-gradle-imports

plugins {
  java
  // jhipster-needle-gradle-plugins
}

// jhipster-needle-gradle-properties

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}
// jhipster-needle-gradle-plugins-configurations

repositories {
  mavenCentral()
  // jhipster-needle-gradle-repositories
}

group = "com.mycompany.myapp"
version = "0.0.1-SNAPSHOT"

val profiles = (project.findProperty("profiles") as String? ?: "")
  .split(",")
  .map { it.trim() }
  .filter { it.isNotEmpty() }
// jhipster-needle-profile-activation

dependencies {
  // jhipster-needle-gradle-implementation-dependencies
  // jhipster-needle-gradle-compile-dependencies
  // jhipster-needle-gradle-runtime-dependencies
  testImplementation(libs.junit.engine)
  testImplementation(libs.junit.params)
  testImplementation(libs.assertj)
  testImplementation(libs.mockito)
  // jhipster-needle-gradle-test-dependencies
}

// jhipster-needle-gradle-free-configuration-blocks

tasks.test {
  filter {
    includeTestsMatching("**Test*")
    excludeTestsMatching("**IT*")
    excludeTestsMatching("**CucumberTest*")
  }
  useJUnitPlatform()
  // jhipster-needle-gradle-tasks-test
}

val integrationTest = task<Test>("integrationTest") {
  description = "Runs integration tests."
  group = "verification"
  shouldRunAfter("test")
  filter {
    includeTestsMatching("**IT*")
    includeTestsMatching("**CucumberTest*")
  }
  useJUnitPlatform()
}
