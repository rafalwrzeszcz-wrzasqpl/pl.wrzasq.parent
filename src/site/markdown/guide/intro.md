<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015, 2017, 2019 - 2021 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Parent POM

This package defines basic build flow for all of our projects developed in **Rafał Wrzeszcz - Wrzasq.pl**. There is no
magic however - we release it open source, so you can make use of it for rapid bootstrap of your custom project.

To use it simply use `pl.wrzasq.parent:parent` as parent of your project:

```xml
<project
    xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd
">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>pl.wrzasq.parent</groupId>
        <artifactId>parent-opensource</artifactId>
        <version>{put-latest-version-here}</version>
    </parent>

    <!-- your project definition here -->
</project>
```

## Project structure

There are four parts of this project, however just two of them are important for end-projects:

-   `parent-generic` is a generic **Java** project setup (that binds `parent` project plugins with `parent-detekt`
    ruleset);
-   `parent-opensource` contains additional setup for **Rafał Wrzeszcz - Wrzasq.pl** open source projects.

The other two parts are needed to provide shared **Detekt** ruleset and bind it together with released project:

-   `parent` is a base project definition, but without code style checks (which require separate packaging to make it
    shared between external projects);
-   `parent-detekt` is a packaged **Detekt** ruleset.

Additionally, for serverless **Lambda** projects/modules there is `parent-lambda` module that establishes a common
foundation for logging (and maybe other aspects in future).
