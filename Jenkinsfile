pipeline {
    agent any
    tools {
        maven 'maven_3.9.6'

    }
    stages {
        stage('Build Maven'){
            steps{
                echo 'env.PATH=' + env.PATH
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/surachitasamyukta/Product-Inventory']]])
                sh 'mvn clean install'
            }
        }
    }
}