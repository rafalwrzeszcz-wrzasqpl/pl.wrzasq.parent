<!---
# This file is part of the ChillDev-Parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015, 2017 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Parent POM

This package defines basic build flow for all of projects developed in **Chillout Development**. But there is no magic - we release it open source, so you can make use of it for rapid bootstrap of your custom project.

To use it simply use `pl.chilldev.parent:parent` as parent of your project:

```xml
<project
    xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd
">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>pl.chilldev.parent</groupId>
        <artifactId>parent-opensource</artifactId>
        <version>{put-latest-version-here}</version>
    </parent>

    <!-- your project definition here -->
</project>
```

## Project structure

There are four parts of this project, however just two of them are important for end-projects:

-   `parent-generic` is a generic **Java** project setup (that binds `parent` project plugins with `parent-checkstyle` ruleset);
-   `parent-opensource` contains additional setup for **Chillout Development** open source projects.

The other two parts are needed to provide shared **Checkstyle** ruleset and bind it together with released project:

-   `parent` is a base project definition, but without code style checks (which require separate packaging to make it shared between external projects);
-   `parent-checkstyle` is a packaged **Checkstyle** ruleset.
