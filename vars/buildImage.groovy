#!/usr/bin/env groovy

def call(String IMAGE_NAME) {
    withCredentials([usernamePassword(credentialsId: 'rik215', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t rik215/bootcamp-test:${IMAGE_NAME} ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push rik215/bootcamp-test:${IMAGE_NAME}"
    }
}
