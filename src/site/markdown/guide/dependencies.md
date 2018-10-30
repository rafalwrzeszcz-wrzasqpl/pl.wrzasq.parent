<!---
# This file is part of the ChillDev-Parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015 - 2018 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Dependencies

It's pointless to define any common dependencies, every project has own, very dependent set of dependencies. But when it comes to tests, the base dependencies are always the same. Parent POM defines some common `test` scope dependencies:

-   `com.github.stefanbirkner:system-rules`
-   `org.junit.jupiter:junit-jupiter-api`
-   `org.junit.jupiter:junit-jupiter-engine`
-   `org.mockito:mockito-core`
-   `org.mockito:mockito-junit-jupiter`
-   `org.projectlombok:lombok`
-   `org.slf4j:slf4j-nop`
-   `org.springframework:spring-test`
-   `org.springframework.security:spring-security-test`
