<!---
# This file is part of the ChillDev-Parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015 - 2017 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Build plugins

Following build plugins are defined in POM structure - all of them are included in active plugins set (automatically inherited):

-   `org.apache.maven.plugins:maven-checkstyle-plugin` (via `parent-generic`)
-   `org.apache.maven.plugins:maven-dependency-plugin`
-   `org.apache.maven.plugins:maven-javadoc-plugin`
-   `org.apache.maven.plugins:maven-pmd-plugin`
-   `org.apache.maven.plugins:maven-project-info-reports-plugin`
-   `org.apache.maven.plugins:maven-source-plugin`
-   `org.codehaus.mojo:findbugs-maven-plugin`
-   `org.eluder.coveralls:coveralls-maven-plugin`
-   `org.jacoco:jacoco-maven-plugin`
-   `org.projectlombok:lombok-maven-plugin`

Additionally following plugins are defined in management section, so they are not automatically executed in your build, but you can enable them by including them in your project (or are executed by default by **Maven** and only versions and configurations are overridden):

-   `com.alexecollins.docker:docker-maven-plugin`
-   `com.github.eirslett:frontend-maven-plugin`
-   `com.versioneye:versioneye-maven-plugin`
-   `org.apache.maven.plugins:maven-archetype-plugin`
-   `org.apache.maven.plugins:maven-clean-plugin`
-   `org.apache.maven.plugins:maven-compiler-plugin`
-   `org.apache.maven.plugins:maven-deploy-plugin`
-   `org.apache.maven.plugins:maven-install-plugin`
-   `org.apache.maven.plugins:maven-jar-plugin`
-   `org.apache.maven.plugins:maven-resources-plugin`
-   `org.apache.maven.plugins:maven-shade-plugin`
-   `org.apache.maven.plugins:maven-site-plugin`
-   `org.apache.maves.plugins:maven-surefire-plugin`

Some of them are configured in specific way:

## `org.apache.maven.plugins:maven-compiler-plugin`

Java compilation is done with all possible linting restrictions (`-Xlint:all` compiler flag). It's set for **Java 8** version right now.

## `org.apache.maven.plugins:maven-dependency-plugin`

Dependency plugin is configured to ignore common test-scope dependencies that may not be used by all projects:

-   `junit:junit`
-   `org.mockito:mockito-core`
-   `org.powermock:powermock-api-mockito`
-   `org.powermock:powermock-core`
-   `org.powermock:powermock-module-junit4`
-   `org.projectlombok:lombok`
-   `org.slf4j:slf4j-nop`
-   `org.springframework:spring-test`
-   `org.springframework.security:spring-security-test`

## `com.versioneye:versioneye-maven-plugin`

**VersionEye** plugin is configured to check licenses and security issues on `verify` phase.

## `org.apache.maven.plugins:maven-resources-plugin`

Resources are configured to be processed with `\` escape character (when filtered). Initially resources are configured to be located at `src/main/resources` and set for filtering. Additionally `src/main/resources-binary` directory is defined to be used as-it-is - these resources won't be filtered.

## `org.apache.maven.plugins:maven-site-plugin`

Site plugin is configured to work with additional dependencies:

-   `net.trajano.wagon:wagon-git`
-   `org.apache.maven.doxia:doxia-module-markdown`

It allows for using **Markdown** format in your documentation and publishing site to Git SCM. We picked this generic approach over using dedicated GitHub plugin `com.github.github:site-maven-plugin`, because it uses GitHub API which heavily limits upload rate (too took ~20 minutes to upload small module page).

## `org.codehaus.mojo:findbugs-maven-plugin`

FindBugs plugin is configured for maximum effort and low treshold to perform most aggressive.

## `org.eluder.coveralls:coveralls-maven-plugin`

Coveralls plugin is not bound to any phase by default, but it can be used from command line.

## `com.alexecollins.docker:docker-maven-plugin`

Generates **Docker** image in `package` phase.

## `com.github.eirslett:frontend-maven-plugin`

Uses **Node** version `4.1.1` and **npm** version `3.3.4` and executes three stages:

-   `install-node-and-npm`, which installs local version of **Node** and **npm**;
-   `npm`, which installs build toold defined in `package.json` file (**npm** packages);
-   `gulp`, which builds frontend assets (runs **Gulp**) - everything else should be handled in `gulpfile.js`.

## `org.apache.maven.plugins:maven-jar-plugin`

Generates **JAR** artifact with manifest containing project meta data.

## `org.apache.maven.plugins:maven-shade-plugin`

Generates **JAR** artifact including all dependencies in one package, named with suffix `-standalone`, which is possible to run directly, without any additional class-path packages.

Also it's by default configured to merge all `META-INF/services/*` files and `META-INF/spring.handlers` and `META-INF/spring.schemas`.

Additionally it excludes all `META-INF/*.SF`, `META-INF/*.DSA` and `META-INF/*.RSA` files they would foul Java when reading consolidated archive.
