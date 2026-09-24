#!/usr/bin/env groovy

def call() {
    echo "building and versioning the application...branch $GIT_BRANCH selected"
    dir('app') {
        sh 'echo "building node app..."'
        sh 'npm version minor --no-git-tag-version'
        def version = sh(script: "node -p \"require('./package.json').version\"", returnStdout: true).trim()
        env.IMAGE_NAME = "$version-$BUILD_NUMBER"
        sh 'npm install'
    }
}