#!/usr/bin/env groovy

def call() {
    withCredentials([usernamePassword(credentialsId: 'jenkins-pat-2', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'git config --global user.email "jenkins@example.com"'
        sh 'git config --global user.name "jenkins"'

        sh 'git status'
        sh 'git branch'
        sh 'git config --list'

        sh 'git remote set-url origin "https://${USER}:${PASS}@github.com/rikg215/jenkins-testing-2.git"'
        sh 'git add .'
        sh 'git commit -m "ci: version bump"'
        sh 'git push origin HEAD:main'
    }
}
