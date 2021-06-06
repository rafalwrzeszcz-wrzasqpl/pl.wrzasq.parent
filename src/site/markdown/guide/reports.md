<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015, 2017, 2019, 2021 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Reporting plugins

Following reporting plugins are defined in POM structure:

-   `org.apache.maven.plugins:maven-dependency-plugin`
-   `org.apache.maven.plugins:maven-jxr-plugin`
-   `org.apache.maven.plugins:maven-project-info-reports-plugin`
-   `org.apache.maven.plugins:maven-surefire-report-plugin`
-   `org.jacoco:jacoco-maven-plugin`

All of them are included in active plugins set (automatically inherited). Some of them are configured in specific way:

## `org.apache.maven.plugins:maven-project-info-reports-plugin`

To speed up report generation, info report contains no dependencies' repository location.
