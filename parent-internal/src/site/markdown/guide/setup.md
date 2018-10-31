<!---
# This file is part of the ChillDev-Parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2018 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

**Note:** This module sets up our common services integration, like **S3** repository access. Usually it has no use for
anyone from outside.

# Internal setup

Following components are set with `parent-internal` to expose unified way of interaction with company service.

## S3

We use [**S3**](https://aws.amazon.com/s3/) as our private **Maven** repository. This module includes build extension
that handles `s3://` repository URLs and define two repositories:

-   `aws-s3` for releases;
-   `aws-s3-snapshot` for snapshots.

Keep in mind that access to the repositories is restricted and you need to set it for yourself locally by defining
`<server>` entries in `~/.m2/settings.xml`.
