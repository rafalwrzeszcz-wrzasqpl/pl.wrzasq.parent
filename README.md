<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015, 2017 - 2020 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# WrzasqPl-Parent

**WrzasqPl-Parent** is a generic bootstrap project structure that we use in all our projects (both open source, internal and commerial).

[![Build Status](https://github.com/rafalwrzeszcz-wrzasqpl/pl.wrzasq.parent/workflows/build/badge.svg)](https://github.com/rafalwrzeszcz-wrzasqpl/pl.wrzasq.parent/actions)
[![Coverage Status](https://coveralls.io/repos/github/rafalwrzeszcz-wrzasqpl/pl.wrzasq.parent/badge.svg)](https://coveralls.io/github/rafalwrzeszcz-wrzasqpl/pl.wrzasq.parent)
[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/rafalwrzeszcz-wrzasqpl/pl.wrzasq.parent)

# Usage

To use it in your project, simply define `pl.wrzasq.parent:parent` as your project parent POM:

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
        <groupId>pl.wrzasq.parent</groupId>
        <artifactId>parent-generic</artifactId>
        <version>${pl.wrzasq.parent.version}</version>
    </parent>
</project>
```

# Resources

-   [GitHub page with API documentation](https://rafalwrzeszcz-wrzasqpl.github.io/pl.wrzasq.parent)
-   [Contribution guide](https://github.com/rafalwrzeszcz-wrzasqpl/pl.wrzasq.parent/blob/master/CONTRIBUTING.md)
-   [Issues tracker](https://github.com/rafalwrzeszcz-wrzasqpl/pl.wrzasq.parent/issues)
-   [Maven packages](https://search.maven.org/search?q=g:pl.wrzasq.parent)
-   [Wrzasq.pl @ GitHub](https://github.com/rafalwrzeszcz-wrzasqpl)
-   [Wrzasq.pl @ Facebook](https://www.facebook.com/wrzasqpl)
-   [Wrzasq.pl @ LinkedIn](https://www.linkedin.com/company/wrzasq-pl/)

# Authors

This project is published under [MIT license](https://github.com/rafalwrzeszcz-wrzasqpl/pl.wrzasq.parent/tree/master/LICENSE).

**pl.wrzasq.parent** is brought to you by [Rafał Wrzeszcz - Wrzasq.pl](https://wrzasq.pl).

List of contributors:

-   [Rafał "Wrzasq" Wrzeszcz](https://github.com/rafalwrzeszcz) ([wrzasq.pl](https://wrzasq.pl)).
