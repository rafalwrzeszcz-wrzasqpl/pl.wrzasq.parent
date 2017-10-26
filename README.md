<!---
# This file is part of the ChillDev-Parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015, 2017 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# ChillDev-Parent

**ChillDev-Parent** is a generic bootstrap project structure that we use in all our projects (both open source, internal and commerial).

[![Build Status](https://travis-ci.org/chilloutdevelopment/pl.chilldev.parent.svg)](https://travis-ci.org/chilloutdevelopment/pl.chilldev.parent)
[![Coverage Status](https://coveralls.io/repos/chilloutdevelopment/pl.chilldev.parent/badge.png?branch=develop)](https://coveralls.io/r/chilloutdevelopment/pl.chilldev.parent)
[![Known Vulnerabilities](https://snyk.io/test/github/chilloutdevelopment/pl.chilldev.parent/badge.svg)](https://snyk.io/test/github/chilloutdevelopment/pl.chilldev.parent)
[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/chilloutdevelopment/pl.chilldev.parent)

# Usage

To use it in your project, simply define `pl.chilldev.parent:parent` as your project parent POM:

```xml
<project
    xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd
">
    <modelVersion>4.0.0</modelVersion>

    <!-- core project settings -->
    <groupId>${groupId}</groupId>
    <artifactId>${artifactId}</artifactId>
    <packaging>pom</packaging>
    <version>${version}</version>
    <parent>
        <groupId>pl.chilldev.parent</groupId>
        <artifactId>parent-generic</artifactId>
        <version>${pl.chilldev.parent.version}</version>
    </parent>
</project>
```

# Resources

-   [GitHub page with API documentation](https://chilloutdevelopment.github.io/pl.chilldev.parent)
-   [Contribution guide](https://github.com/chilloutdevelopment/pl.chilldev.parent/blob/develop/CONTRIBUTING.md)
-   [Issues tracker](https://github.com/chilloutdevelopment/pl.chilldev.parent/issues)
-   [Maven packages](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22pl.chilldev.parent%22)
-   [Chillout Development @ GitHub](https://github.com/chilloutdevelopment)
-   [Chillout Development @ Facebook](https://www.facebook.com/chilldev)

# Authors

This project is published under [MIT license](https://github.com/chilloutdevelopment/pl.chilldev.parent/tree/master/LICENSE).

**pl.chilldev.parent** is brought to you by [Chillout Development](https://chilldev.pl).

List of contributors:

-   [Rafał "Wrzasq" Wrzeszcz](https://github.com/rafalwrzeszcz) ([wrzasq.pl](https://wrzasq.pl)).
