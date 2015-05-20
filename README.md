<!---
# This file is part of the ChillDev-Parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# ChillDev-Parent

**ChillDev-Parent** is a generic bootstrap project structure that we use in all our projects (both open source, internal and commerial).

[![Build Status](https://travis-ci.org/chilloutdevelopment/pl.chilldev.parent.svg)](https://travis-ci.org/chilloutdevelopment/pl.chilldev.parent)
[![Coverage Status](https://coveralls.io/repos/chilloutdevelopment/pl.chilldev.parent/badge.png?branch=develop)](https://coveralls.io/r/chilloutdevelopment/pl.chilldev.parent)
[![Dependency Status](https://www.versioneye.com/user/projects/555cb2e4634daa30fb00090e/badge.svg?style=flat)](https://www.versioneye.com/user/projects/555cb2e4634daa30fb00090e)

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
        <artifactId>parent</artifactId>
        <version>${pl.chilldev.parent.version}</version>
    </parent>
</project>
```

# Resources

-   [GitHub page with API documentation](http://chilloutdevelopment.github.io/pl.chilldev.parent)
-   [Issues tracker](https://github.com/chilloutdevelopment/pl.chilldev.parent/issues)
-   [Maven packages](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22pl.chilldev.parent%22)
-   [Chillout Development @ GitHub](https://github.com/chilloutdevelopment)
-   [Chillout Development @ Facebook](http://www.facebook.com/chilldev)

# Contributing

Do you want to help improving this project? Simply *fork* it and post a pull request. You can do everything on your own, you don't need to ask if you can, just do all the awesome things you want!

This project is published under [MIT license](https://github.com/chilloutdevelopment/pl.chilldev.parent/tree/master/LICENSE).

# Authors

**pl.chilldev.parent** is brought to you by [Chillout Development](http://chilldev.pl).

List of contributors:

-   [Rafał "Wrzasq" Wrzeszcz](https://github.com/rafalwrzeszcz) ([wrzasq.pl](http://wrzasq.pl)).
