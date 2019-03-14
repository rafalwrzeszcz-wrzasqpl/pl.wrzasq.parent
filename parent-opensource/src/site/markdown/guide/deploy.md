<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2015 - 2017, 2019 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# `deploy` profile

In addition to main POM, for open source projects `pl.wrzasq.parent:parent-opensource` defines `deploy` profile (to use as `mvn -P deploy`), which performs deployment to public repositories (project artifacts to deployment repository, site committed to `gh-pages` branch of **GitHub** repository).

## Plugins

### `org.apache.maven.plugins:maven-gpg-plugin`

Bound to phase `verify`, creates scertificate, which is needed to publish project artifact to staging repository.
