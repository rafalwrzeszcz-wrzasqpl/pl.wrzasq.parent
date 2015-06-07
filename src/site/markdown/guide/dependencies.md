<!---
# This file is part of the ChillDev-Parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Dependencies

It's pointless to define any common dependencies, every project has own, very dependent set of dependencies. But when it comes to tests, the base dependencies are always the same. Parent POM defines two common `test` scope dependencies:

-   `junit:junit`
-   `org.mockito:mockito-core`
-   `org.springframework:spring-test`
-   `org.springframework.security:spring-security-test`
