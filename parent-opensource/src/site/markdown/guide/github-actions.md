<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2020 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Deployment pipeline using GitHub Actions

**Note:** This page plays role mostly of the internal guideline for **Rafał Wrzeszcz - Wrzasq.pl** projects, but it's
rather generic and you can re-use the same flow with your own projects.

## Concept

### Principles

-   When possible rely on **Maven**, rather than CI to avoid lock-in with particular CI solution.
-   Try to automate as much as possible.

### Actions

Our current deployment involves following specific actions:

-   Signing artifacts with GPG key.
-   Publishing artifacts (together with GPG checksums) to Sonatype Nexus.
-   Publishing GitHub page.
-   Creating Git tag.

### Approach

Each commit to `master` should trigger roll-out of next iterative version. Pipeline should handle versioning, tagging
and releasing artifacts to repositories (including site generation)

Deployment pipeline will automatically increase release number. If new major or minor release is to be performed,
version needs to be set manually before committing files (in `pom.xml` of root module).

## Setup

As the deployment process relies on some sensitive data, like **Sonatype** credentials, **GitHub** token etc., to pass
them safely into the build we use secrets from feature of **GitHub Actions** (both on organization and repository
level).

To keep our project **Maven** setup independent from the chosen deployment pipeline we keep dedicated `settings.xml`
for **GitHub Actions** deploys that populates the credentials and other properties.

**Note:** Everything related to **GitHub Actions** pipeline should go into `.github/` subdirectory.

**Note:** Never, ever commit unencrypted keys to the repositories (not even private ones)!

### Environment variables

To pass the short value, or variable data into deployment builds we use encrypted environment variables. Following
environment variables are used:

-   `OSSRH_USERNAME` - **Sonatype** deployments account login;
-   `OSSRH_PASSWORD` - **Sonatype** deployments account password;
-   `GPG_PASSPHRASE` - password for **GPG** key;
-   `GPG_PRIVATE_KEY` - **GPG** private key;
-   `SSH_PRIVATE_KEY` - repository-specific, deployment **SSH** key;
-   `COVERALLS_REPOTOKEN` (repository-specific, not used in `pl.wrzasq.parent`) - project key for **Coveralls**;
-   `GITHUB_TOKEN` (specific for each GitHub action run) - **GitHub** access token, used for deploying pages.

They are (except `GITHUB_TOKEN`, which is provided by **GitHub Actions**) stored as secret variables in organization or
repository respectively.

### Plain files

To bind the described setup of **GitHub Actions** with **Maven** the deployment phase of pipeline use specific file,
which is stored in `.github/settings.xml`.
