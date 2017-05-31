<!---
# This file is part of the ChillDev-Parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2016 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Lombok

Since version `0.0.8` parent POM includes [Lombok](https://projectlombok.org/). Not only the dependency is included to allow it process your sources, but it also affects some plugins configuration to allow peaceful cooperation.

**Node:** Lombok processes source code at compile time, so it won't be needed at runtime. It's included with `provided` scope, so **Maven** won't require it as a transitive dependency. As simple as that: if you want - use it; if not - it won't affect your artifacts.

## Build process

The common pitfall of using **Lombok** is, that it collides with **PMD**. The second one operates on plain Java source code and doesn't see the code generated by Lombok. One solution for that is to use `@SurpressWarning` in the source or specify PMD ignore rules. But it's invasive and can lead to ignoring too much code, not only generated by Lombok.

We picked different, more complicated (but it's covered entirely by this parent POM) way. However it's good if you understand how it works, because it may influence other parts of your project buildcycle.

We use `org.projectlombok:lombok-maven-plugin`'s `delombok` goal to dump source code generated by **Lombok**. Generated source is dumped into `target/generated-source/delombok`. And this directory is set as the project build source - which means most of the plugins (including compiler plugin!) won't operate on plain `src/main/java` source directory, but will work on already Lombok-processed source code. This will provide full source view to PMD plugin.

## Plugins affected

Such configuration affects some other plugins:

-   `org.apache.maven.plugins:maven-checkstyle-plugin` is forced to work on plain Java source (`src/main/java`) as Lombok-generated code has arbitrary formatting;
-   `org.apache.maven.plugins:maven-javadoc-plugin` generates API documentation based on Delombok source, which means it will include documentation for all the methods generated by Lombok;
-   `org.jacoco:jacoco-maven-plugin` generates coverate of Delombok source, which means code coverage is calculated also for code generated by Lombok;
-   `org.eluder.coveralls:coveralls-maven-plugin` unfortunately it relies on **JaCoCo** results, which means it will compute coverage based on virtual source code - won't be able to present the source coverage on web.