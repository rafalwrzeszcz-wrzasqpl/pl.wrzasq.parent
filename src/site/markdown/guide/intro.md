<!---
# This file is part of the ChillDev-Parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015 © by Rafał Wrzeszcz - Wrzasq.pl.
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
        <version>0.0.1</version>
    </parent>

    <!-- your project definition here -->
</project>
```
