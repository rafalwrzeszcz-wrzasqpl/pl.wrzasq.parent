<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015 - 2017, 2019, 2021, 2025 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# `deploy` profile

In addition to main POM, for open source projects `pl.wrzasq.parent:parent-opensource` defines `deploy` profile (to use
as `mvn -P deploy`), which performs deployment to public repositories.

## Plugins

### `org.apache.maven.plugins:maven-gpg-plugin`

Bound to phase `verify`, creates a certificate, which is needed to publish project artifact to staging repository.

### `org.sonatype.central:central-publishing-maven-plugin`

Open source projects are configured to be deployed into central OSS Sonatype repository.
