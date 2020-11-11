<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2016 - 2019 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

# Travis-based deployment pipeline

**Note:** This page plays role mostly of the internal guideline for **Rafał Wrzeszcz - Wrzasq.pl** projects, but it's entirely general and you can re-use the same flow with your own projects.

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

As the deployment process relies on some sensitive data, like **Sonatype** credentials, **GitHub** token etc., to pass them safely into the build we use environment variables encoded with **Travis** repository key. To pass large blobs like keys, we ue additional secret string that we randomly generate on our own for each repository, store it encoded as well and use as a key to encrypt/decrypt files with `openssl`.

**Note:** Keep in mind that the private key of the pair is never exposed, even to us, so whenever you want to encode data that may be later needed by you keep the copy of it.

To keep our project **Maven** setup independent from the choosen deployment pipeline we keep dedicated `settings.xml` for **Travis** deploys that populates the credentials and other properties.

**Note:** Everything related to **Travis**-based deployment should go into `.travis/` subdirectory.

To prepare the repository to use **Travis** for deployment automation first of all pick a secret string for it (keep it!), for example using (replace any non-alphanumerical character of the output with random character to avoid possible escaping):

```bash
cat /dev/urandom | base64 | head -c 16
```

Export it as a shell environment variable to make it reusable in further calls:

```bash
export SECRET=<secret string>
```

### Keys

Use the secret to encode key files. We need **SSH** public key for **GitHub** access and **GPG** key for signing artifacts to be deployed.

To generates **SSH** key use:

```bash
ssh-keygen -t rsa -b 4096 -C "Travis CI"
```

-   Copy public key and put it as a deployment key of your **GitHub** repository (grant it write access - it will be used for pushing tags).
-   Encrypt private key file:

```bash
openssl aes-256-cbc -md sha256 -k "$SECRET" -in .travis/id_rsa -out .travis/id_rsa.enc
```

To export and encrypt **GPG** (the one associated with **Sonatype** account, for tutorial about generating the key itself use **Google**) do:

```bash
gpg -a --export deployer@account.com > .travis/gpg_key
gpg -a --export-secret-keys deployer@account.com >> .travis/gpg_key
openssl aes-256-cbc -md sha256 -k "$SECRET" -in .travis/gpg_key -out .travis/gpg_key.enc
```

**Note:** Never, ever commit unencrypted keys to the repositories (not even private onces)!

### Environment variables

To pass the short, or variable data into deployment builds we use encrypted environment variables. Following environment variables are used:

-   `OSSRH_USERNAME` - **Sonatype** deployments accoung login;
-   `OSSRH_PASSWORD` - **Sonatype** deployments accoung password;
-   `GPG_PASSPHRASE` - password for **GPG** key;
-   `GITHUB_TOKEN` - **GitHub** access token, used for deploying pages;
-   `SECRET` - our secret string used for decrypting key files.

To generate encrypted values for them call:

```bash
travis encrypt OSSRH_USERNAME=<Sonatype account login>
travis encrypt OSSRH_PASSWORD=<Sonatype account password>
travis encrypt GPG_PASSPHRASE=<GPG key passphrase>
travis encrypt GITHUB_TOKEN=<GitHub access token>
travis encrypt SECRET=$SECRET
```

Save produced strings in `.travis.yml`:

```yaml
env:
    global:
        -
            secure: …
        -
            secure: …
        …
```

### Plain files

To bind the described setup with **Travis** build cycle you will need two files - there is no point in describing them here as the description may most likely go outdated and miss the real requirements, so the best way is to just look into this repository examples and use them as a templates:

-   `.travis.yml` - sections `before_deploy` to prepare required deployment environment and `deploy` for actual deployment command;
-   `.travis/settings.xml` - file that contains mapping of environment variables into **Maven** properties of the deployment configuration;
-   `.travis/release.sh` - script containing CD pipeline logic as **Travis** doesn't support complex deployment scripts.
