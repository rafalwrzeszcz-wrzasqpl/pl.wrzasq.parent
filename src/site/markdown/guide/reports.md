<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015, 2017, 2019 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Reporting plugins

Following reporting plugins are defined in POM structure:

-   `findbugs-maven-plugin:spotbugs-maven-plugin`
-   `org.apache.maven.plugins:maven-checkstyle-plugin` (via `parent-generic`)
-   `org.apache.maven.plugins:maven-dependency-plugin`
-   `org.apache.maven.plugins:maven-javadoc-plugin`
-   `org.apache.maven.plugins:maven-jxr-plugin`
-   `org.apache.maven.plugins:maven-pmd-plugin`
-   `org.apache.maven.plugins:maven-project-info-reports-plugin`
-   `org.apache.maven.plugins:maven-surefire-report-plugin`
-   `org.jacoco:jacoco-maven-plugin`

All of them are included in active plugins set (automatically inherited). Some of them are configured in specific way:

## `findbugs-maven-plugin:spotbugs-maven-plugin`

SpotBugs report is built based on the same configuration like it's build plugin.

## `org.apache.maven.plugins:maven-checkstyle-plugin`

Checkstyle report is built based on the same configuration like it's build plugin.

## `org.apache.maven.plugins:maven-javadoc-plugin`

JavaDoc report includes API documentation of entire project (including private members). Packages with names starting from `test.` are excluded.

## `org.apache.maven.plugins:maven-project-info-reports-plugin`

To speed up report generation, info report contains no dependencies repository location.
