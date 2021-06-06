<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015 - 2021 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Dependencies

Parent project adds generic **Kotlin** dependencies (standard library and reflections) so that it doesn't need to be
repeated in each project:

-   `org.jetbrains:annotations`
-   `org.jetbrains.kotlin:kotlin-flect`
-   `org.jetbrains.kotlin:kotlin-stdlib`

Additionally, parent POM defines some common `test` scope dependencies:

-   `io.cucumber:cucumber-java8`
-   `io.cucumber:cucumber-junit`
-   `org.junit.jupiter:junit-jupiter-api`
-   `org.junit.jupiter:junit-jupiter-engine`
-   `io.mockk:mockk`
-   `io.mockk:mockk-dsl-jvm`
