<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015 - 2021 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Build plugins

Following build plugins are defined in POM structure - all of them are included in active plugins set (automatically
inherited):

-   `com.github.ozsie:detekt-maven-plugin` (via `parent-generic`)
-   `org.apache.maven.plugins:maven-dependency-plugin`
-   `org.apache.maven.plugins:maven-enforcer-plugin`
-   `org.apache.maven.plugins:maven-source-plugin`
-   `org.codehaus.mojo:build-helper-maven-plugin`
-   `org.jacoco:jacoco-maven-plugin`

Additionally, following plugins are defined in management section, so they are not automatically executed in your build,
but you can enable them by including them in your project (or are executed by default by **Maven** and only versions and
configurations are overridden):

-   `org.apache.maven.plugins:maven-clean-plugin`
-   `org.apache.maven.plugins:maven-compiler-plugin`
-   `org.apache.maven.plugins:maven-deploy-plugin`
-   `org.apache.maven.plugins:maven-exec-plugin`
-   `org.apache.maven.plugins:maven-failsafe-plugin`
-   `org.apache.maven.plugins:maven-install-plugin`
-   `org.apache.maven.plugins:maven-jar-plugin`
-   `org.apache.maven.plugins:maven-resources-plugin`
-   `org.apache.maven.plugins:maven-site-plugin`
-   `org.apache.maves.plugins:maven-surefire-plugin`
-   `org.codehaus.mojo:versions-maven-plugin`
-   `org.graalvm.nativeimage:native-image-maven-plugin`
-   `org.jetbrains.kotlin:kotlin-maven-plugin`
-   `pl.wrzasq.parent:parent-nativelambda-plugin`

Some of them are configured in specific way:

## `org.apache.maven.plugins:maven-compiler-plugin`

Java compilation is done with all possible linting restrictions (`-Xlint:all` compiler flag). It's set for **Java 11**
version right now.

## `org.apache.maven.plugins:maven-dependency-plugin`

Dependency plugin is configured to ignore common test-scope dependencies that may not be used by all projects:

-   `io.cucumber:cucumber-java8`
-   `io.cucumber:cucumber-junit`
-   `io.mockk:mockk`
-   `io.mockk:mockk-dsl-jvm`
-   `org.jetbrains:annotations`
-   `org.jetbrains.kotlin:kotlin-reflect`
-   `org.jetbrains.kotlin:kotlin-stdlib`
-   `org.junit.jupiter:junit-jupiter-api`
-   `org.junit.jupiter:junit-jupiter-engine`
-   `org.slf4j:slf4j-nop`

## `org.apache.maven.plugins:maven-enforcer-plugin`

Required **Maven** version is at least `3.3.9` and **Java** `11`.

## `org.apache.maven.plugins:maven-resources-plugin`

Resources are configured to be processed with `\` escape character (when filtered). Initially resources are configured
to be located at `src/main/resources` and set for filtering. Additionally `src/main/resources-binary` directory is
defined to be used as-it-is - these resources won't be filtered.

## `org.codehaus.mojo:build-helper-maven-plugin`

Build helper plugin exposes version components as a series of properties with prefix `semver.`.

## `org.apache.maven.plugins:maven-jar-plugin`

Generates **JAR** artifact with manifest containing project metadata.

## `org.graalvm.nativeimage:native-image-maven-plugin`

Native image building (if enabled) generates an image with name with extension `.bin`.

## `pl.wrzasq.parent:parent-nativelambda-plugin`

Lambda package is generated with same name as native image but with `.zip` extension.

# Profiles

## `integration-tests`

This profile activates `maven-failsafe-plugin`.
