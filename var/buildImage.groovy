#!/usr/bin/env groovy

def call(){
    echo 'building the app image...'
    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh 'docker build -t korngsamnang/demo-app:jma-2.0 .'
        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
        sh 'docker push korngsamnang/demo-app:jma-2.0'
    }

}