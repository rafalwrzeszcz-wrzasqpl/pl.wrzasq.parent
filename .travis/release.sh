#!/bin/bash

##
# This file is part of the ChillDev-Parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2017 © by Rafal Wrzeszcz - Wrzasq.pl.
##

set -ex

BRANCH="${1}"

# make sure HEAD points to the branch
git checkout ${BRANCH}

# first make current version release
mvn versions:set versions:commit -DremoveSnapshot=true
git add -u
git commit -m "Automated release release."
git push origin ${BRANCH}:master

# now create a new version commit
mvn versions:set versions:commit \
    -DnewVersion="\${semver.majorVersion}.\${semver.minorVersion}.\${semver.nextIncrementalVersion}"
    -DnextSnapshot=true
git add -u
git commit -m "[skip ci] New version bump."
git push
