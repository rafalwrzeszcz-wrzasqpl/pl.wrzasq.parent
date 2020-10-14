<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015 - 2020 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Build plugins

Following build plugins are defined in POM structure - all of them are included in active plugins set (automatically inherited):

-   `findbugs-maven-plugin:spotbugs-maven-plugin`
-   `org.apache.maven.plugins:maven-checkstyle-plugin` (via `parent-generic`)
-   `org.apache.maven.plugins:maven-dependency-plugin`
-   `org.apache.maven.plugins:maven-enforcer-plugin`
-   `org.apache.maven.plugins:maven-javadoc-plugin`
-   `org.apache.maven.plugins:maven-pmd-plugin`
-   `org.apache.maven.plugins:maven-project-info-reports-plugin`
-   `org.apache.maven.plugins:maven-source-plugin`
-   `org.codehaus.mojo:build-helper-maven-plugin`
-   `org.eluder.coveralls:coveralls-maven-plugin`
-   `org.jacoco:jacoco-maven-plugin`
-   `org.projectlombok:lombok-maven-plugin`

Additionally following plugins are defined in management section, so they are not automatically executed in your build, but you can enable them by including them in your project (or are executed by default by **Maven** and only versions and configurations are overridden):

-   `com.bluetrainsoftware.maven.plugins:s3-upload-maven-plugin`
-   `com.github.eirslett:frontend-maven-plugin`
-   `org.apache.maven.plugins:maven-clean-plugin`
-   `org.apache.maven.plugins:maven-compiler-plugin`
-   `org.apache.maven.plugins:maven-deploy-plugin`
-   `org.apache.maven.plugins:maven-failsafe-plugin`
-   `org.apache.maven.plugins:maven-install-plugin`
-   `org.apache.maven.plugins:maven-jar-plugin`
-   `org.apache.maven.plugins:maven-resources-plugin`
-   `org.apache.maven.plugins:maven-shade-plugin`
-   `org.apache.maven.plugins:maven-site-plugin`
-   `org.apache.maves.plugins:maven-surefire-plugin`
-   `org.codehaus.mojo:versions-maven-plugin`

Some of them are configured in specific way:

## `findbugs-maven-plugin:spotbugs-maven-plugin`

SpotBugs plugin is configured for maximum effort and low treshold to perform most aggressive.

## `org.apache.maven.plugins:maven-compiler-plugin`

Java compilation is done with all possible linting restrictions (`-Xlint:all` compiler flag). It's set for **Java 11**
version right now.

## `org.apache.maven.plugins:maven-dependency-plugin`

Dependency plugin is configured to ignore common test-scope dependencies that may not be used by all projects:

-   `io.cucumber:cucumber-java8`
-   `io.cucumber:cucumber-junit`
-   `org.junit.jupiter:junit-jupiter-api`
-   `org.junit.jupiter:junit-jupiter-engine`
-   `org.junit.vintage:junit-vintage-engine`
-   `org.mockito:mockito-core`
-   `org.mockito:mockito-junit-jupiter`
-   `org.projectlombok:lombok`
-   `org.slf4j:slf4j-nop`

## `org.apache.maven.plugins:maven-enforcer-plugin`

Required **Maven** version is at least `3.3.9` and **Java** `11`.

## `org.apache.maven.plugins:maven-resources-plugin`

Resources are configured to be processed with `\` escape character (when filtered). Initially resources are configured to be located at `src/main/resources` and set for filtering. Additionally `src/main/resources-binary` directory is defined to be used as-it-is - these resources won't be filtered.

## `org.apache.maven.plugins:maven-site-plugin`

Site plugin is configured to work with additional dependencies:

-   `net.trajano.wagon:wagon-git`
-   `org.apache.maven.doxia:doxia-module-markdown`

It allows for using **Markdown** format in your documentation and publishing site to Git SCM. We picked this generic approach over using dedicated GitHub plugin `com.github.github:site-maven-plugin`, because it uses GitHub API which heavily limits upload rate (too took ~20 minutes to upload small module page).

## `org.codehaus.mojo:build-helper-maven-plugin`

Build helper plugin exposes version components as a series of properties with prefix `semver.`.

## `org.eluder.coveralls:coveralls-maven-plugin`

Coveralls plugin is not bound to any phase by default, but it can be used from command line.

## `com.bluetrainsoftware.maven.plugins:s3-upload-maven-plugin`

Executes `s3-upload` action during the `deploy` phase.

## `com.github.eirslett:frontend-maven-plugin`

Uses **Node** version `9.3.0` and **npm** version `5.6.0` and executes three stages:

-   `install-node-and-npm`, which installs local version of **Node** and **npm**;
-   `npm`, which installs build tools defined in `package.json` file (**npm** packages);
-   further `npm` tool calls to forward **Maven** lifecycle phases to Node project.

## `org.apache.maven.plugins:maven-jar-plugin`

Generates **JAR** artifact with manifest containing project meta data.

## `org.apache.maven.plugins:maven-shade-plugin`

Generates **JAR** artifact including all dependencies in one package, named with suffix `-standalone`, which is possible to run directly, without any additional class-path packages.

Additionally it excludes all `META-INF/*.SF`, `META-INF/*.DSA` and `META-INF/*.RSA` files they would foul Java when reading consolidated archive.

# Profiles

## `integration-tests`

This profile activates `maven-failsafe-plugin`.
