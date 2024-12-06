// jhipster-needle-gradle-imports

plugins {
  java
  alias(libs.plugins.spring.boot)
  // jhipster-needle-gradle-plugins
}

// jhipster-needle-gradle-properties

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

defaultTasks("bootRun")

springBoot {
  mainClass = "com.mycompany.myapp.JhipsterSampleApplicationApp"
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
  implementation(platform(libs.spring.boot.dependencies))
  implementation(libs.spring.boot.starter)
  implementation(libs.spring.boot.configuration.processor)
  implementation(libs.commons.lang3)
  // jhipster-needle-gradle-implementation-dependencies
  // jhipster-needle-gradle-compile-dependencies
  // jhipster-needle-gradle-runtime-dependencies
  testImplementation(libs.spring.boot.starter.test)

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
